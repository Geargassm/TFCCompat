package com.vkv.tfcc.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.dries007.tfc.common.blocks.crop.CropBlock", remap = false)
public class CropBlockMixin {
    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true, remap = false)
    private void allowVanillaFarmland(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (level.getBlockState(pos.below()).is(Blocks.FARMLAND)) {
            cir.setReturnValue(true);
        }
    }
}
