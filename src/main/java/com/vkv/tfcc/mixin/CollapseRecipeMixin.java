package com.vkv.tfcc.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.dries007.tfc.common.recipes.CollapseRecipe", remap = false)
public class CollapseRecipeMixin {
    @Inject(method = "tryTriggerCollapse", at = @At("HEAD"), cancellable = true, remap = false)
    private static void tfccompat$noCollapse(Level level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "startCollapse", at = @At("HEAD"), cancellable = true, remap = false)
    private static void tfccompat$noStartCollapse(Level level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
