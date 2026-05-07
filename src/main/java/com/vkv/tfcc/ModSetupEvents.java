package com.vkv.tfcc;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = TFCCompat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetupEvents {

    @SubscribeEvent
    public static void onSpawnPlacementsRegister(SpawnPlacementRegisterEvent event) {
        for (var entry : ForgeRegistries.ENTITY_TYPES.getEntries()) {
            if (!"tfc".equals(entry.getKey().location().getNamespace())) continue;
            EntityType<?> type = entry.getValue();
            MobCategory cat = type.getCategory();
            if (cat == MobCategory.MISC) continue;
            try {
                if (cat == MobCategory.WATER_CREATURE || cat == MobCategory.WATER_AMBIENT) {
                    registerWater(event, type);
                } else {
                    registerGround(event, type);
                }
            } catch (Exception ignored) {}
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Mob> void registerGround(SpawnPlacementRegisterEvent event, EntityType<?> rawType) {
        event.register((EntityType<T>) rawType,
            SpawnPlacements.Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            Mob::checkMobSpawnRules,
            SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Mob> void registerWater(SpawnPlacementRegisterEvent event, EntityType<?> rawType) {
        event.register((EntityType<T>) rawType,
            SpawnPlacements.Type.IN_WATER,
            Heightmap.Types.OCEAN_FLOOR,
            (t, level, reason, pos, rand) -> level.getFluidState(pos).is(FluidTags.WATER),
            SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
