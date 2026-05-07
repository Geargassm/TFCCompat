package com.vkv.tfcc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.dries007.tfc.util.climate.ClimateRange", remap = false)
public class ClimateRangeMixin {
    @Overwrite(remap = false)
    public boolean checkBoth(int hydration, float temperature, boolean allowWiggle) {
        return true;
    }
}
