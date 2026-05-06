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
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 43), index = 1)
    private boolean chiselCollapse(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 42), index = 1)
    private boolean landslide(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 40), index = 1)
    private boolean collapse(boolean value) {
        return false;
    }

    @ModifyArg(method = "<init>(Lnet/dries007/tfc/config/ConfigBuilder;)V", at = @At(value = "INVOKE",
            target = "Lnet/dries007/tfc/config/ConfigBuilder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;", ordinal = 41), index = 1)
    private boolean collapseExplode(boolean value) {
        return false;
    }
}
