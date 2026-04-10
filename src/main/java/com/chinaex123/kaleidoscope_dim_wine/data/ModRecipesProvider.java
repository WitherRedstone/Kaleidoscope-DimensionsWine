package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        // 龙血瓶
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DRAGON_BLOOD_BOTTLE.get(),4)
                .requires(ModItems.DRAGON_BLOOD_BUCKET)
                .requires(Items.GLASS_BOTTLE,4 )
                .unlockedBy("has_dragon_blood_bucket", has(ModItems.DRAGON_BLOOD_BUCKET.get()))
                .save(recipeOutput);

        // 巨物碎片
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, TwilightforestItems.COLOSSAL_FRAGMENT.get(),16)
                .requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                .unlockedBy("has_colossal", has(TwilightforestItems.COLOSSAL_FRAGMENT.get()))
                .save(recipeOutput.withConditions(modLoaded("twilightforest")));

//                .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "pepper")))

    }
}
