package com.vkv.tfcc.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.dries007.tfc.common.recipes.LandslideRecipe", remap = false)
public class LandslideRecipeMixin {
    @Inject(method = "tryLandslide", at = @At("HEAD"), cancellable = true, remap = false)
    private static void tfccompat$noLandslide(Level level, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
