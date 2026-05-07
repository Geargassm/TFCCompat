package com.vkv.tfcc.mixin;

import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(targets = "net.dries007.tfc.common.capabilities.food.TFCFoodData", remap = false)
public abstract class TFCFoodDataMixin {

    @Shadow public abstract int getFoodLevel();
    @Shadow public abstract void setFoodLevel(int food);

    @Overwrite(remap = false)
    public float getHealthModifier() {
        return 1.0f;
    }

    @Inject(
        method = "eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)V",
        at = @At("RETURN"),
        remap = false
    )
    private void restoreHungerForNonTFCFood(Item maybeFood, ItemStack stack, @Nullable LivingEntity entity, CallbackInfo ci) {
        if (FoodCapability.get(stack) == null && stack.isEdible()) {
            FoodProperties props = maybeFood.getFoodProperties();
            if (props != null) {
                setFoodLevel(Math.min(getFoodLevel() + props.getNutrition(), 20));
            }
        }
    }
}
