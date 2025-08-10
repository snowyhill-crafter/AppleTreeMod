package com.snowyhill.appletreemod.datagen.server;


import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.registry.ModBlocks;
import com.snowyhill.appletreemod.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public  class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AppleTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN).add(
                ModBlocks.APPLE_LOG.get(),
                ModBlocks.STRIPPED_APPLE_LOG.get(),
                ModBlocks.APPLE_WOOD.get(),
                ModBlocks.STRIPPED_APPLE_WOOD.get()
        );

        this.tag(BlockTags.LEAVES)
                .add(
                        ModBlocks.APPLE_LEAVES.get(),
                        //ここにapple_flower_leavesを入れるとエラーになる。なんで。
                        // Caused by: java.lang.IllegalArgumentException: Couldn't define tag minecraft:leaves as it is missing following references: appletreemod:apple_flower_leaves

                        ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get(),
                        ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get(),
                        ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get()
                );

        this.tag(BlockTags.LOGS)
                .add(
                        ModBlocks.APPLE_LOG.get(),
                        ModBlocks.STRIPPED_APPLE_LOG.get(),
                        ModBlocks.APPLE_WOOD.get(),
                        ModBlocks.STRIPPED_APPLE_WOOD.get()
                );



        this.tag(ModTags.Blocks.APPLE_LOG)
                .add(
                        ModBlocks.APPLE_LOG.get(),
                        ModBlocks.STRIPPED_APPLE_LOG.get(),
                        ModBlocks.APPLE_WOOD.get(),
                        ModBlocks.STRIPPED_APPLE_WOOD.get()
                );

        // ←採掘速度に効くのはこっち
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.APPLE_SLAB.get(),
                ModBlocks.APPLE_FENCE.get(),
                ModBlocks.APPLE_FENCE_GATE.get(),
                ModBlocks.APPLE_DOOR.get(),
                ModBlocks.APPLE_TRAPDOOR.get(),
                ModBlocks.APPLE_STAIRS.get(),
                ModBlocks.APPLE_BUTTON.get(),
                ModBlocks.APPLE_PRESSURE_PLATE.get()
        );


        this.tag(BlockTags.PLANKS).add(ModBlocks.APPLE_PLANKS.get());
        this.tag(BlockTags.SLABS).add(ModBlocks.APPLE_SLAB.get());
        this.tag(BlockTags.STAIRS).add(ModBlocks.APPLE_STAIRS.get());
        this.tag(BlockTags.FENCES).add(ModBlocks.APPLE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.APPLE_FENCE_GATE.get());
        this.tag(BlockTags.DOORS).add(ModBlocks.APPLE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(ModBlocks.APPLE_TRAPDOOR.get());
        this.tag(BlockTags.BUTTONS).add(ModBlocks.APPLE_BUTTON.get());
        this.tag(BlockTags.PRESSURE_PLATES).add(ModBlocks.APPLE_PRESSURE_PLATE.get());





    }
}






