package com.vkv.tfcc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TFCCompat.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        ItemStack stack = event.getItemStack();

        if (stack.getItem() == Items.POTION && PotionUtils.getPotion(stack) == Potions.WATER) {
            try {
                Class.forName("net.dries007.tfc.common.capabilities.player.PlayerData");
                if (!level.isClientSide) {
                    player.getFoodData().eat(0, 0.2F);
                }
            } catch (ClassNotFoundException e) {
                if (!level.isClientSide) {
                    player.getFoodData().eat(0, 0.2F);
                }
            }
        }

        if (stack.getItem() == Items.EGG) {
            if (!level.isClientSide) {
                ThrownEgg egg = new ThrownEgg(level, player);
                egg.setItem(stack.copyWithCount(1));
                egg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(egg);
                level.gameEvent(player, GameEvent.PROJECTILE_SHOOT, player.blockPosition());
                stack.shrink(1);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            } else {
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }

    @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.HIGHEST)
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (!event.getItemStack().is(Items.BONE_MEAL)) return;

        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block instanceof net.dries007.tfc.common.blocks.crop.CropBlock crop && !crop.isMaxAge(state)) {
            if (!level.isClientSide() && level instanceof net.minecraft.server.level.ServerLevel) {
                int maxAge = crop.getMaxAge();
                int newAge = Math.min(state.getValue(crop.getAgeProperty()) + level.random.nextInt(3) + 2, maxAge);
                if (level.getBlockEntity(pos) instanceof net.dries007.tfc.common.blockentities.CropBlockEntity cropBE) {
                    cropBE.setGrowth((float) newAge / maxAge);
                }
                level.setBlockAndUpdate(pos, state.setValue(crop.getAgeProperty(), newAge));
                event.getItemStack().shrink(1);
                level.levelEvent(2005, pos, 0);
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
            return;
        }

        if (block instanceof net.minecraft.world.level.block.BonemealableBlock bonemealable
                && bonemealable.isValidBonemealTarget(level, pos, state, level.isClientSide())) {
            if (!level.isClientSide() && level instanceof net.minecraft.server.level.ServerLevel serverLevel) {
                bonemealable.performBonemeal(serverLevel, level.random, pos, state);
                event.getItemStack().shrink(1);
                level.levelEvent(2005, pos, 0);
            }
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        ItemStack stack = event.getItem();
        if (!stack.isEdible()) return;
        if (net.dries007.tfc.common.capabilities.food.FoodCapability.get(stack) != null) return;
        net.minecraft.world.food.FoodProperties props = stack.getItem().getFoodProperties();
        if (props == null) return;
        net.minecraft.world.food.FoodData foodData = player.getFoodData();
        foodData.setFoodLevel(Math.min(foodData.getFoodLevel() + props.getNutrition(), 20));
    }


}
