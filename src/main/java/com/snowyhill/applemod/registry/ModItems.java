package com.snowyhill.applemod.registry;


import com.snowyhill.applemod.AppleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    // レジストリの作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AppleMod.MOD_ID);

    // レジストリにアイテムを追加

    public static final RegistryObject<Item> APPLE_SAPLING = ITEMS.register("apple_sapling",
            () -> new BlockItem(ModBlocks.APPLE_SAPLING.get(), new Item.Properties())
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

}