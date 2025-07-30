package com.snowyhill.appletreemod.worldgen.biome;



import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.worldgen.placement.ModPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

//リソースキー

    // リンゴの木用キー
    public static final ResourceKey<BiomeModifier> ADD_APPLE_TREE =
            createKey("add_apple_tree");


    //バイオームに鉱石生成するメソッド
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // 🌳 リンゴの木 - 条件付きバイオーム追加
        // biome tagのキー（"data/introductionmod/tags/worldgen/biome/apple_tree_spawnable.json" に対応）
        TagKey<Biome> appleTreeBiomeTag = TagKey.create(Registries.BIOME,
                new ResourceLocation("introductionmod", "apple_tree_spawnable"));

        context.register(ADD_APPLE_TREE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(appleTreeBiomeTag), // ✅ biomeタグとして扱う
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.APPLE_TREE)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );




    }


    //登録用メソッド
    private static ResourceKey<BiomeModifier> createKey(String name) {
       return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
               new ResourceLocation(AppleTreeMod.MOD_ID,name));
    }


}
