package com.vkv.tfcc.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.dries007.tfc.common.blocks.crop.CropBlock", remap = false)
public class CropBlockMixin {

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true, remap = false)
    private void tfccompat$randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        net.dries007.tfc.common.blocks.crop.CropBlock crop =
                (net.dries007.tfc.common.blocks.crop.CropBlock) state.getBlock();
        ci.cancel();
        if (crop.isMaxAge(state)) return;
        if (random.nextInt(3) != 0) return;
        int maxAge = crop.getMaxAge();
        int newAge = Math.min(state.getValue(crop.getAgeProperty()) + 1, maxAge);
        if (level.getBlockEntity(pos) instanceof net.dries007.tfc.common.blockentities.CropBlockEntity cropBE) {
            cropBE.setGrowth((float) newAge / maxAge);
        }
        level.setBlockAndUpdate(pos, state.setValue(crop.getAgeProperty(), newAge));
    }
}
