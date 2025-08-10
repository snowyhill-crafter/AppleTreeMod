package com.snowyhill.appletreemod.datagen.server;


import com.snowyhill.appletreemod.AppleTreeMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output , CompletableFuture<HolderLookup.Provider>
            lookUpProvider) {
        super(output, AppleTreeMod.MOD_ID, lookUpProvider);
    }

    @Override
    protected void start() {    }
}