package com.snowyhill.appletreemod.registry;

import com.snowyhill.appletreemod.AppleTreeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModTabs {
    //レジストリを作る
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AppleTreeMod.MOD_ID);

    //レジストリにタブを追加
    public static final RegistryObject<CreativeModeTab> APPLETREEMOD_TAB = TABS.register("appletreemod_tab",
    () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetabs.appletreemod_tab"))
    .icon(ModItems.APPLE_SAPLING.get()::getDefaultInstance)
            .displayItems(((pParameters, pOutput) -> {

                pOutput.accept(ModItems.APPLE_SAPLING.get());
                pOutput.accept(ModItems.APPLE_LOG_ITEM.get());
                pOutput.accept(ModItems.STRIPPED_APPLE_LOG_ITEM.get());
                pOutput.accept(ModItems.APPLE_WOOD_ITEM.get());
                pOutput.accept(ModItems.STRIPPED_APPLE_WOOD_ITEM.get());
                pOutput.accept(ModItems.APPLE_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_FLOWER_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_UNRIPE_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_FRUIT_LEAVES_ITEM.get());

                pOutput.accept(ModItems.APPLE_PLANKS_ITEM.get());
                pOutput.accept(ModItems.APPLE_SLAB_ITEM.get());
                pOutput.accept(ModItems.APPLE_STAIRS_ITEM.get());
                pOutput.accept(ModItems.APPLE_FENCE_ITEM.get());
                pOutput.accept(ModItems.APPLE_FENCE_GATE_ITEM.get());
                pOutput.accept(ModItems.APPLE_DOOR_ITEM.get());
                pOutput.accept(ModItems.APPLE_TRAPDOOR_ITEM.get());
                pOutput.accept(ModItems.APPLE_BUTTON_ITEM.get());
                pOutput.accept(ModItems.APPLE_PRESSURE_PLATE_ITEM.get());
                
                
                
            }))
            .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
