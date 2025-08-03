package com.snowyhill.appletreemod.registry;


import com.snowyhill.appletreemod.AppleTreeMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    // レジストリの作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AppleTreeMod.MOD_ID);

    // レジストリにアイテムを追加

    public static final RegistryObject<Item> APPLE_SAPLING = ITEMS.register("apple_sapling",
            () -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties())
    );


    public static final RegistryObject<Item> APPLE_LOG_ITEM = ITEMS.register(
            "apple_log",
            () -> new BlockItem(ModBlocks.APPLE_LOG.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> STRIPPED_APPLE_LOG_ITEM = ITEMS.register(
            "stripped_apple_log",
            () -> new BlockItem(ModBlocks.STRIPPED_APPLE_LOG.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_WOOD_ITEM = ITEMS.register(
            "apple_wood",
            () -> new BlockItem(ModBlocks.APPLE_WOOD.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> STRIPPED_APPLE_WOOD_ITEM = ITEMS.register(
            "stripped_apple_wood",
            () -> new BlockItem(ModBlocks.STRIPPED_APPLE_WOOD.get(), new Item.Properties())
    );
    
    
    
    
    public static final RegistryObject<Item> APPLE_LEAVES_ITEM = ITEMS.register(
            "apple_leaves",
            () -> new BlockItem(ModBlocks.APPLE_LEAVES.get(), new Item.Properties())
    );


    public static final RegistryObject<Item> ORNAMENTAL_APPLE_FLOWER_LEAVES_ITEM = ITEMS.register(
            "ornamental_apple_flower_leaves",
            () -> new BlockItem(ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> ORNAMENTAL_APPLE_UNRIPE_LEAVES_ITEM = ITEMS.register(
            "ornamental_apple_unripe_leaves",
            () -> new BlockItem(ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> ORNAMENTAL_APPLE_FRUIT_LEAVES_ITEM = ITEMS.register(
            "ornamental_apple_fruit_leaves",
            () -> new BlockItem(ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get(), new Item.Properties())
    );



    public static final RegistryObject<Item> APPLE_PLANKS_ITEM = ITEMS.register(
            "apple_planks",
            () -> new BlockItem(ModBlocks.APPLE_PLANKS.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_SLAB_ITEM = ITEMS.register(
            "apple_slab",
            () -> new BlockItem(ModBlocks.APPLE_SLAB.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_STAIRS_ITEM = ITEMS.register(
            "apple_stairs",
            () -> new BlockItem(ModBlocks.APPLE_STAIRS.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_FENCE_ITEM = ITEMS.register(
            "apple_fence",
            () -> new BlockItem(ModBlocks.APPLE_FENCE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_FENCE_GATE_ITEM = ITEMS.register(
            "apple_fence_gate",
            () -> new BlockItem(ModBlocks.APPLE_FENCE_GATE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_DOOR_ITEM = ITEMS.register(
            "apple_door",
            () -> new BlockItem(ModBlocks.APPLE_DOOR.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_TRAPDOOR_ITEM = ITEMS.register(
            "apple_trapdoor",
            () -> new BlockItem(ModBlocks.APPLE_TRAPDOOR.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_BUTTON_ITEM = ITEMS.register(
            "apple_button",
            () -> new BlockItem(ModBlocks.APPLE_BUTTON.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> APPLE_PRESSURE_PLATE_ITEM = ITEMS.register(
            "apple_pressure_plate",
            () -> new BlockItem(ModBlocks.APPLE_PRESSURE_PLATE.get(), new Item.Properties())
    );
}