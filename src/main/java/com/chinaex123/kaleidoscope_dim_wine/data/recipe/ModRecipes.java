package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, KaleidoscopeDimensionsWine.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> MEAD_ESSENCE_REPAIR_SERIALIZER =
            RECIPE_SERIALIZERS.register("mead_essence_repair",
                    () -> new SimpleCraftingRecipeSerializer<>(MeadEssenceRepairRecipe::new)
            );
}
