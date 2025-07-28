package com.snowyhill.applemod.registry;

import com.snowyhill.applemod.AppleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModTabs {
    //レジストリを作る
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AppleMod.MOD_ID);

    //レジストリにタブを追加
    public static final RegistryObject<CreativeModeTab> APPLEMOD_TAB = TABS.register("applemod_tab",
    () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetabs.applemod_tab"))
    .icon(ModItems.APPLE_SAPLING.get()::getDefaultInstance)
            .displayItems(((pParameters, pOutput) -> {

                pOutput.accept(ModItems.APPLE_SAPLING.get());
                pOutput.accept(ModItems.APPLE_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_FLOWER_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_UNRIPE_LEAVES_ITEM.get());
                pOutput.accept(ModItems.ORNAMENTAL_APPLE_FRUIT_LEAVES_ITEM.get());

            }))
            .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
