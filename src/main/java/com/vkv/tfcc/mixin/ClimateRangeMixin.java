package com.vkv.tfcc.mixin;

import net.dries007.tfc.util.climate.ClimateRange;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.dries007.tfc.util.climate.ClimateRange", remap = false)
public class ClimateRangeMixin {
    @Inject(method = "checkBoth", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private void tfccompat$checkBoth(int hydration, float temperature, boolean allowWiggle,
            CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "checkTemperature", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private void tfccompat$checkTemperature(float temperature, boolean allowWiggle,
            CallbackInfoReturnable<ClimateRange.Result> cir) {
        cir.setReturnValue(ClimateRange.Result.VALID);
    }

    @Inject(method = "checkHydration", at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private void tfccompat$checkHydration(int hydration, boolean allowWiggle,
            CallbackInfoReturnable<ClimateRange.Result> cir) {
        cir.setReturnValue(ClimateRange.Result.VALID);
    }
}
