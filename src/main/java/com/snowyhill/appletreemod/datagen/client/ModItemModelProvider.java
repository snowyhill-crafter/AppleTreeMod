package com.snowyhill.appletreemod.datagen.client;


import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.registry.ModBlocks;
import com.snowyhill.appletreemod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AppleTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //ここにアイテムを追加して自動生成させる
    

        itemWithBlock(ModBlocks.APPLE_SLAB);
        itemWithBlock(ModBlocks.APPLE_STAIRS);
        itemWithBlock(ModBlocks.APPLE_FENCE_GATE);
        itemWithBlock(ModBlocks.APPLE_PRESSURE_PLATE);
        basicItem(ModBlocks.APPLE_DOOR.get().asItem());
        trapdoor(ModBlocks.APPLE_TRAPDOOR);
        fence(ModBlocks.APPLE_FENCE,
                ModBlocks.APPLE_PLANKS);
        button(ModBlocks.APPLE_BUTTON,
                ModBlocks.APPLE_PLANKS);
        
        
        
        
        
    }

    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        AppleTreeMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        AppleTreeMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(AppleTreeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(AppleTreeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AppleTreeMod.MOD_ID,"block/" + block.getId().getPath()));
    }



}
