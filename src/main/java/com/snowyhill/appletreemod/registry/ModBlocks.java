package com.snowyhill.appletreemod.registry;

import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.block.AppleFlowerLeavesBlock;
import com.snowyhill.appletreemod.block.AppleSaplingBlock;
import com.snowyhill.appletreemod.block.ModLeavesBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AppleTreeMod.MOD_ID);


    public static final RegistryObject<Block> APPLE_SAPLING = BLOCKS.register(
            "apple_sapling",
            () -> new AppleSaplingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).randomTicks()));


    public static final RegistryObject<Block> APPLE_LEAVES = BLOCKS.register(
            "apple_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).randomTicks()));

    public static final RegistryObject<Block> APPLE_FLOWER_LEAVES = BLOCKS.register(
            "apple_flower_leaves",
            () -> new AppleFlowerLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).randomTicks()));

    public static final RegistryObject<Block> ORNAMENTAL_APPLE_FLOWER_LEAVES = BLOCKS.register(
            "ornamental_apple_flower_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> ORNAMENTAL_APPLE_UNRIPE_LEAVES = BLOCKS.register(
            "ornamental_apple_unripe_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> ORNAMENTAL_APPLE_FRUIT_LEAVES = BLOCKS.register(
            "ornamental_apple_fruit_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

}
