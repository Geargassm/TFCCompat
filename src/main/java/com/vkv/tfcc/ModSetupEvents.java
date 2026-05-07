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

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SubscribeEvent
    public static void onSpawnPlacementsRegister(SpawnPlacementRegisterEvent event) {
        for (var entry : ForgeRegistries.ENTITY_TYPES.getEntries()) {
            if (!"tfc".equals(entry.getKey().location().getNamespace())) continue;
            EntityType type = entry.getValue();
            MobCategory cat = type.getCategory();
            if (cat == MobCategory.MISC) continue;
            try {
                if (cat == MobCategory.WATER_CREATURE || cat == MobCategory.WATER_AMBIENT) {
                    event.register(type,
                        SpawnPlacements.Type.IN_WATER,
                        Heightmap.Types.OCEAN_FLOOR,
                        (t, level, reason, pos, rand) -> level.getFluidState(pos).is(FluidTags.WATER),
                        SpawnPlacementRegisterEvent.Operation.REPLACE);
                } else {
                    event.register(type,
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        (t, level, reason, pos, rand) -> Mob.checkMobSpawnRules(t, level, reason, pos, rand),
                        SpawnPlacementRegisterEvent.Operation.REPLACE);
                }
            } catch (Exception ignored) {}
        }
    }
}
