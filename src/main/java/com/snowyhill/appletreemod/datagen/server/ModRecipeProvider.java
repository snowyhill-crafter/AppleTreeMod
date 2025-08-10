package com.snowyhill.appletreemod.datagen.server;

import com.snowyhill.appletreemod.AppleTreeMod;
import com.snowyhill.appletreemod.registry.ModBlocks;
import com.snowyhill.appletreemod.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider>
            lookUpProvider) {
        super(pOutput, lookUpProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {      
            
    woodFromLogs(pRecipeOutput, ModBlocks.APPLE_WOOD.get(),
                ModBlocks.APPLE_LOG.get());

    woodFromLogs(pRecipeOutput, ModBlocks.STRIPPED_APPLE_WOOD.get(),
                ModBlocks.STRIPPED_APPLE_LOG.get());

    planksFromLog(pRecipeOutput,
                  ModBlocks.APPLE_PLANKS.get(),

    ModTags.Items.APPLE_LOG,4);

    slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS,
         ModBlocks.APPLE_SLAB.get(),
                ModBlocks.APPLE_PLANKS.get());

    stairs(pRecipeOutput,
           ModBlocks.APPLE_STAIRS.get(),
                ModBlocks.APPLE_PLANKS.get());

    fence(pRecipeOutput,
          ModBlocks.APPLE_FENCE.get(),
                ModBlocks.APPLE_PLANKS.get());

    fenceGate(pRecipeOutput,
              ModBlocks.APPLE_FENCE_GATE.get(),
                ModBlocks.APPLE_PLANKS.get());

    door(pRecipeOutput,
         ModBlocks.APPLE_DOOR.get(),
                ModBlocks.APPLE_PLANKS.get());

    trapdoor(pRecipeOutput,
             ModBlocks.APPLE_TRAPDOOR.get(),
                ModBlocks.APPLE_PLANKS.get());

    button(pRecipeOutput,
           ModBlocks.APPLE_BUTTON.get(),
                ModBlocks.APPLE_PLANKS.get());

    pressurePlate(pRecipeOutput,
                  ModBlocks.APPLE_PRESSURE_PLATE.get(),
                ModBlocks.APPLE_PLANKS.get());
}
    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }




    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, AppleTreeMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }



protected static void nineBlockStorageRecipes(RecipeOutput pRecipeOutput,
                                              RecipeCategory pUnpackedCategory,
                                              ItemLike pUnpacked,
                                              RecipeCategory pPackedCategory,
                                              ItemLike pPacked) {
    ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
            .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pRecipeOutput);
    ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
            .pattern("###").pattern("###").pattern("###")
            .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pRecipeOutput);
}

private static void stairs(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
    stairBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
private static void fence(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
    fenceBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
private static void fenceGate(RecipeOutput pRecipeOutput, ItemLike pResult,
                              ItemLike pIngredient) {
    fenceGateBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
private static void door(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
    doorBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
private static void trapdoor(RecipeOutput pRecipeOutput, ItemLike pResult,
                             ItemLike pIngredient) {
    trapdoorBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
private static void button(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
    buttonBuilder(pResult, Ingredient.of(pIngredient))
            .unlockedBy(getHasName(pIngredient), has(pIngredient))
            .save(pRecipeOutput);
}
}