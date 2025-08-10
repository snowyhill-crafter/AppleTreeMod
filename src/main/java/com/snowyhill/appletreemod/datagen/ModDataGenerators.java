package com.snowyhill.appletreemod.datagen;



import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.datagen.client.ModBlockStateProvider;
import com.snowyhill.appletreemod.datagen.client.ModItemModelProvider;
import com.snowyhill.appletreemod.datagen.server.*;
import com.snowyhill.appletreemod.datagen.server.loot.ModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AppleTreeMod.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();


        //ItemModel
        generator.addProvider(event.includeClient(), new ModItemModelProvider(
                packOutput , existingFileHelper));
        //blockstate
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(
                packOutput , existingFileHelper));



        //worldgen
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(
                packOutput , lookUpProvider));
        //ブロックタグ
        var blockTagsProvider = generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider(packOutput
                        ,lookUpProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModItemTagsProvider(
                packOutput, lookUpProvider, blockTagsProvider.contentsGetter(),
                AppleTreeMod.MOD_ID , existingFileHelper));




        // レシピ
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookUpProvider));
       //ルートテーブル
        generator.addProvider(event.includeServer(),  ModLootTables.create(packOutput, lookUpProvider));

        // GlobalLootModifier
        generator.addProvider(event.includeServer(),
                new ModGlobalLootModifierProvider(packOutput, lookUpProvider));





    }
}
