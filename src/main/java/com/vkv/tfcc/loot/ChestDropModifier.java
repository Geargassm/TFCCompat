package com.vkv.tfcc.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ChestDropModifier extends LootModifier {
    public static final Supplier<Codec<ChestDropModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, ChestDropModifier::new)));

    public ChestDropModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        var blockState = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        if (blockState != null && new ResourceLocation("minecraft", "chest").equals(ForgeRegistries.BLOCKS.getKey(blockState.getBlock()))) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "chest"))));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
