package com.vkv.tfcc.mixin;

import net.dries007.tfc.config.ServerConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerConfig.class)
public class TFCConfigMixin {
    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 0), index = 1)
    private boolean portal(boolean value) {
        return true;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 38), index = 1)
    private boolean enableBlockCollapsing(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 39), index = 1)
    private boolean enableExplosionCollapsing(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 40), index = 1)
    private boolean enableBlockLandslides(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 41), index = 1)
    private boolean enableChiselsStartCollapses(boolean value) {
        return false;
    }
}
