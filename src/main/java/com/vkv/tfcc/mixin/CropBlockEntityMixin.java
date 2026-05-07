package com.vkv.tfcc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.dries007.tfc.common.blockentities.CropBlockEntity", remap = false)
public class CropBlockEntityMixin {
    @Overwrite(remap = false)
    public float getYield() {
        return 1.0f;
    }
}
