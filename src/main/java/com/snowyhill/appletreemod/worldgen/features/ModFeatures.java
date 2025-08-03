package com.snowyhill.appletreemod.worldgen.features;

import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.registry.ModBlocks;


import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModFeatures {


    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY =
            createKey("apple_tree");







    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        FeatureUtils.register(context, APPLE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                        new StraightTrunkPlacer(5, 1, 0),// 少し短く、分岐なしで自然な幹

                        // ここで葉をランダム化。ティックの不具合回避のため実の成長なし。実を直接呼び出す。
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.APPLE_FLOWER_LEAVES.get().defaultBlockState(), 1)
                                .add(ModBlocks.APPLE_LEAVES.get().defaultBlockState(), 1)),

                        new BlobFoliagePlacer(ConstantInt.of(2), // 半径
                                ConstantInt.of(0), 3),// 左：高さオフセット　右：葉の高さ
                        new TwoLayersFeatureSize(1, 0, 1)// 樹冠サイズ（低く丸く）
                ).build()
        );


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(AppleTreeMod.MOD_ID, name));
    }
}
