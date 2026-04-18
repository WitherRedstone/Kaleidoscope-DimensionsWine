package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, KaleidoscopeDimensionsWine.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> MEAD_ESSENCE_REPAIR_SERIALIZER =
            RECIPE_SERIALIZERS.register("mead_essence_repair",
                    () -> new SimpleCraftingRecipeSerializer<>(MeadEssenceRepairRecipe::new)
            );
}
