package com.vkv.tfcc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.dries007.tfc.common.capabilities.food.NutritionData", remap = false)
public class NutritionMixin {
    @Inject(method = "getAverageNutrition", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private void tfccompat$getAverageNutrition(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(1.0f);
    }
}
