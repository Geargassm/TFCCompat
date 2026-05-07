package com.vkv.tfcc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.dries007.tfc.common.capabilities.food.NutritionData")
public class NutritionMixin {
    @Overwrite(remap = false)
    public float getAverageNutrition() {
        return 1.0f;
    }
}
