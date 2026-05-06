package com.vkv.tfcc;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
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

    @SubscribeEvent
    public static void onBonemeal(BonemealEvent event) {
        if (event.getStack().is(Items.BONE_MEAL)) {
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.DEFAULT) {
                event.setResult(net.minecraftforge.eventbus.api.Event.Result.ALLOW);
            }
        }
    }
}
