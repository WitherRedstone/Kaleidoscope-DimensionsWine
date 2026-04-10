package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // 巨物碎片
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TwilightforestItems.COLOSSAL_FRAGMENT.get(),16)
                .requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                .unlockedBy("has_colossal", has(TwilightforestItems.COLOSSAL_FRAGMENT.get()))
                .save(recipeOutput.withConditions(modLoaded("twilightforest")));

//                .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("croptopia", "pepper")))
    }
}
