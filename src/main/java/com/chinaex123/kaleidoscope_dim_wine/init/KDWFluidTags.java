package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public interface KDWFluidTags {

    TagKey<Fluid> JUICE_GRAPE = neoforgeTag("juices/grape");
    TagKey<Fluid> JUICE_GRAPE_CRIMSON = neoforgeTag("juice/crimson_grape");
    TagKey<Fluid> JUICE_GRAPE_WARPED = neoforgeTag("juice/warped_grape");

    TagKey<Fluid> JUICE_FRUIT = neoforgeTag("juice/fruit");
    TagKey<Fluid> JUICE_FRUIT_DREAMFRUIT = neoforgeTag("juice/dreamfruit");
    TagKey<Fluid> JUICE_FRUIT_FROSTHEART_FRUIT = neoforgeTag("juice/frostheart_fruit");
    TagKey<Fluid> JUICE_FRUIT_TORCHBERRIES = neoforgeTag("juice/torchberries");
    TagKey<Fluid> JUICE_FRUIT_ENCHANTED_BERRY = neoforgeTag("juice/enchanted_berry");
    TagKey<Fluid> JUICE_FRUIT_LUNAR_BERRIES = neoforgeTag("juice/lunar_berries");
    TagKey<Fluid> JUICE_FRUIT_ABYSSAL_FRUIT = neoforgeTag("juice/abyssal_fruit");
    TagKey<Fluid> JUICE_FRUIT_SILVER_PUNGENCY_FRUIT = neoforgeTag("juice/silver_pungency_fruit");

    private static TagKey<Fluid> bind(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, name));
    }

    static TagKey<Fluid> neoforgeTag(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
