package com.vkv.tfcc.loot;

import com.vkv.tfcc.TFCCompat;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Ore;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.common.items.TFCItems;
import net.dries007.tfc.util.loot.AlwaysTrueCondition;
import net.dries007.tfc.world.region.ChooseRocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class TFCCGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public TFCCGlobalLootModifiersProvider(PackOutput output) {
        super(output, TFCCompat.MODID);
    }

    @Override
    protected void start() {
        //WOOD
        //Oak
        add("oak_log_from_oak_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.LOG).get().asItem()));
        add("oak_wood_from_oak_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_oak_log_from_stripped_oak_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_OAK_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_oak_wood_from_stripped_oak_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_OAK_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Birch
        add("birch_log_from_birch_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.LOG).get().asItem()));
        add("birch_wood_from_birch_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_birch_log_from_stripped_birch_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_BIRCH_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_birch_wood_from_stripped_birch_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_BIRCH_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Spruce
        add("spruce_log_from_spruce_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.LOG).get().asItem()));
        add("spruce_wood_from_spruce_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_spruce_log_from_stripped_spruce_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_SPRUCE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_spruce_wood_from_stripped_spruce_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_SPRUCE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Acacia
        add("acacia_log_from_acacia_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.LOG).get().asItem()));
        add("acacia_wood_from_acacia_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_acacia_log_from_stripped_acacia_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_ACACIA_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_acacia_wood_from_stripped_acacia_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_ACACIA_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Dark Oak
        add("hickory_log_from_dark_oak_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.LOG).get().asItem()));
        add("hickory_wood_from_dark_oak_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_hickory_log_from_stripped_dark_oak_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_DARK_OAK_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_hickory_wood_from_stripped_dark_oak_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_DARK_OAK_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Jungle
        add("kapok_log_from_jungle_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.LOG).get().asItem()));
        add("kapok_wood_from_jungle_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_kapok_log_from_stripped_jungle_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_JUNGLE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_kapok_wood_from_stripped_jungle_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_JUNGLE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));
        //Jungle
        add("willow_log_from_mangrove_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.MANGROVE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.LOG).get().asItem()));
        add("willow_wood_from_mangrove_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.MANGROVE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.WOOD).get().asItem()));
        add("stripped_willow_log_from_stripped_mangrove_log", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_MANGROVE_LOG).build()
        }, TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.STRIPPED_LOG).get().asItem()));
        add("stripped_willow_wood_from_stripped_mangrove_wood", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STRIPPED_MANGROVE_WOOD).build()
        }, TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.STRIPPED_WOOD).get().asItem()));

        //Stone
        add("silk_dacite_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("dacite_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.LOOSE).get().asItem()));
        //Cobblestone
        add("dacite_from_cobblestone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COBBLESTONE).build(),
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.LOOSE).get().asItem()));
        add("dacite_from_mossy_cobblestone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.MOSSY_COBBLESTONE).build(),
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.MOSSY_LOOSE).get().asItem()));
        add("gabbro_from_cobbled_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COBBLED_DEEPSLATE).build(),
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.LOOSE).get().asItem()));

        //Granite
        add("silk_granite_from_granite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRANITE).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("granite_from_granite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRANITE).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.LOOSE).get().asItem()));
        //Diorite
        add("silk_diorite_from_diorite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIORITE).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("diorite_from_diorite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIORITE).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.LOOSE).get().asItem()));
        //Andesite
        add("silk_andesite_from_andesite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ANDESITE).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("andesite_from_andesite", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ANDESITE).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.LOOSE).get().asItem()));
        //Basalt
        add("silk_basalt_from_basalt", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BASALT).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("basalt_from_basalt", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BASALT).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.LOOSE).get().asItem()));
        //Basalt
        add("silk_gabbro_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.SMOOTH).get().asItem()));
        add("gabbro_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                new AnyOfCondition.Builder(ExplosionCondition.survivesExplosion()).and(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert()).build()
        }, TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.LOOSE).get().asItem()));

        //ORES
        //Coal
        add("coal_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.BITUMINOUS_COAL).get()));
        add("coal_from_deepslate_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COAL_ORE).build()
        }, TFCItems.ORES.get(Ore.BITUMINOUS_COAL).get()));

        //Copper
        add("copper_from_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COPPER_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.NATIVE_COPPER).get(Ore.Grade.NORMAL).get()));
        add("copper_from_deepslate_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COPPER_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.NATIVE_COPPER).get(Ore.Grade.NORMAL).get()));

        //Diamond
        add("diamond_from_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.DIAMOND).get()));
        add("diamond_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.DIAMOND).get()));

        //Lapis
        add("lapis_lazuli_from_lapis_lazuli_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LAPIS_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.LAPIS_LAZULI).get()));
        add("lapis_lazuli_from_deepslate_lapis_lazuli_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_LAPIS_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.LAPIS_LAZULI).get()));

        //Iron
        add("magnetite_from_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.MAGNETITE).get(Ore.Grade.NORMAL).get()));
        add("magnetite_from_deepslate_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.MAGNETITE).get(Ore.Grade.NORMAL).get()));

        //Gold
        add("native_gold_from_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GOLD_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.NATIVE_GOLD).get(Ore.Grade.NORMAL).get()));
        add("native_gold_from_deepslate_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_GOLD_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.GRADED_ORES.get(Ore.NATIVE_GOLD).get(Ore.Grade.NORMAL).get()));

        //Redstone
        add("cinnabar_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.CINNABAR).get()));
        add("cinnabar_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.CINNABAR).get()));
        add("flux_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.BORAX).get()));
        add("flux_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }, TFCItems.ORES.get(Ore.BORAX).get()));
    }
}
