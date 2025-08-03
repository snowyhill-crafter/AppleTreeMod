package com.snowyhill.appletreemod.registry;

import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.block.AppleFlowerLeavesBlock;
import com.snowyhill.appletreemod.block.ModLeavesBlock;

import com.snowyhill.appletreemod.block.ModLogBlock;
import com.snowyhill.appletreemod.block.ModStrippableLogBlock;
import com.snowyhill.appletreemod.worldgen.tree.ModTreeGrowers;
import net.minecraft.world.level.block.*;

import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AppleTreeMod.MOD_ID);


    public static final RegistryObject<Block> APPLE_SAPLING = BLOCKS.register(
            "apple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.APPLE_TREE,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> APPLE_LOG = BLOCKS.register("apple_log",
            () -> new ModStrippableLogBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG),
                    () -> ModBlocks.STRIPPED_APPLE_LOG.get()
            )
    );
    // 樹皮はがし後（stripped）原木
    public static final RegistryObject<Block> STRIPPED_APPLE_LOG = BLOCKS.register("stripped_apple_log",
            () -> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
    );

    public static final RegistryObject<Block> APPLE_WOOD = BLOCKS.register("apple_wood",
            () -> new ModStrippableLogBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    () -> ModBlocks.STRIPPED_APPLE_WOOD.get()
            )
    );
    public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = BLOCKS.register("stripped_apple_wood",
            () -> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))
    );



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

    //クラフト
// 板材
    public static final RegistryObject<Block> APPLE_PLANKS = BLOCKS.register(
            "apple_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // ハーフブロック
    public static final RegistryObject<Block> APPLE_SLAB = BLOCKS.register(
            "apple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // 階段
    public static final RegistryObject<Block> APPLE_STAIRS = BLOCKS.register(
            "apple_stairs",
            () -> new StairBlock(ModBlocks.APPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // フェンス
    public static final RegistryObject<Block> APPLE_FENCE = BLOCKS.register(
            "apple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // フェンスゲート
    public static final RegistryObject<Block> APPLE_FENCE_GATE = BLOCKS.register(
            "apple_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // ドア
    public static final RegistryObject<Block> APPLE_DOOR = BLOCKS.register(
            "apple_door",
            () -> new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // トラップドア
    public static final RegistryObject<Block> APPLE_TRAPDOOR = BLOCKS.register(
            "apple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()
            ));
    // ボタン
    public static final RegistryObject<Block> APPLE_BUTTON = BLOCKS.register(
            "apple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            ));
    // 感圧板
    public static final RegistryObject<Block> APPLE_PRESSURE_PLATE = BLOCKS.register(
            "apple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));





}
