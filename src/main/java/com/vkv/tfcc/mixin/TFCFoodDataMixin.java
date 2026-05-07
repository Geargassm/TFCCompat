package com.vkv.tfcc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.dries007.tfc.common.capabilities.food.TFCFoodData")
public class TFCFoodDataMixin {
    @Overwrite(remap = false)
    public float getHealthModifier() {
        return 1.0f;
    }
}
