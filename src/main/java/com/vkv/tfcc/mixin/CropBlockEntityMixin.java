package com.vkv.tfcc.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.dries007.tfc.common.blockentities.CropBlockEntity", remap = false)
public class CropBlockEntityMixin {

    @Overwrite(remap = false)
    public float getYield() {
        return 1.0f;
    }

    @Inject(method = "serverTick", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private static void tfccompat$serverTick(Level level, BlockPos pos, BlockState state,
            net.dries007.tfc.common.blockentities.CropBlockEntity entity, CallbackInfo ci) {
        ci.cancel();
        tfccompat$doGrow(level, pos, state, entity);
    }

    @Inject(method = "serverTickBottomPartOnly", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private static void tfccompat$serverTickDouble(Level level, BlockPos pos, BlockState state,
            net.dries007.tfc.common.blockentities.CropBlockEntity entity, CallbackInfo ci) {
        ci.cancel();
        tfccompat$doGrow(level, pos, state, entity);
    }

    private static void tfccompat$doGrow(Level level, BlockPos pos, BlockState state,
            net.dries007.tfc.common.blockentities.CropBlockEntity entity) {
        net.dries007.tfc.common.blocks.crop.CropBlock crop =
                (net.dries007.tfc.common.blocks.crop.CropBlock) state.getBlock();
        if (crop.isMaxAge(state)) return;
        if (level.random.nextInt(1200) != 0) return;
        int maxAge = crop.getMaxAge();
        int newAge = Math.min(state.getValue(crop.getAgeProperty()) + 1, maxAge);
        entity.setGrowth((float) newAge / maxAge);
        level.setBlockAndUpdate(pos, state.setValue(crop.getAgeProperty(), newAge));
    }
}
