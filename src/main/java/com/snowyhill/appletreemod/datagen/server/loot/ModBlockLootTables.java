package com.snowyhill.appletreemod.datagen.server.loot;

import com.snowyhill.appletreemod.registry.ModBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.APPLE_SAPLING.get());
        this.dropSelf(ModBlocks.APPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
        this.dropSelf(ModBlocks.APPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());
        //リンゴ木材
        this.dropSelf(ModBlocks.APPLE_PLANKS.get());
        this.dropSelf(ModBlocks.APPLE_STAIRS.get());
        this.dropSelf(ModBlocks.APPLE_FENCE.get());
        this.dropSelf(ModBlocks.APPLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.APPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.APPLE_BUTTON.get());
        this.dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());
        //重ねたときに壊しても二つドロップさせる
        this.add(ModBlocks.APPLE_SLAB.get(),
                createSlabItemTable(ModBlocks.APPLE_SLAB.get()));
        //指定しないとドアが二つドロップしてしまうので対処した
        this.add(ModBlocks.APPLE_DOOR.get(),
                createDoorTable(ModBlocks.APPLE_DOOR.get()));
        // ORNAMENTAL_* 系の葉。素手だとドロップなし、ハサミで壊すと自分をドロップ
        this.add(ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                )
        );

        this.add(ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                )
        );

        this.add(ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                )
        );

        // APPLE_LEAVES: 苗木5%＋棒2%（バニラ仕様例）
        this.add(ModBlocks.APPLE_LEAVES.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.APPLE_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.APPLE_SAPLING.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.05f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
        );

        // APPLE_FLOWER_LEAVES
        this.add(ModBlocks.APPLE_FLOWER_LEAVES.get(), LootTable.lootTable()
                // 1) ハサミ使用時：ageごとに装飾用ブロックをドロップ
                .withPool(LootPool.lootPool()
                        // age=0 → ornamental_apple_flower_leaves
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.APPLE_FLOWER_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(BlockStateProperties.AGE_2, 0)))
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                        // age=1 → ornamental_apple_unripe_leaves
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.APPLE_FLOWER_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(BlockStateProperties.AGE_2, 1)))
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                        // age=2 → ornamental_apple_fruit_leaves
                        .add(LootItem.lootTableItem(ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.APPLE_FLOWER_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(BlockStateProperties.AGE_2, 2)))
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))))
                )
                // 2) age=2 ならリンゴをドロップ（爆破耐性チェックあり）
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.APPLE)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.APPLE_FLOWER_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(BlockStateProperties.AGE_2, 2)))
                                .when(ExplosionCondition.survivesExplosion()))
                )
                // 3) 苗木 5%（ハサミ以外）
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.APPLE_SAPLING.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.05f))
                                .when(InvertedLootItemCondition.invert(
                                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))))
                )
                // 4) 棒 1〜2本を2%（ハサミ以外）
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))
                                .when(InvertedLootItemCondition.invert(
                                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
