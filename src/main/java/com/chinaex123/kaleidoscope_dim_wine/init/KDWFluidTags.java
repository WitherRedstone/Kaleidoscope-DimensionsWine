package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public interface KDWFluidTags {

    TagKey<Fluid> JUICE_GRAPE = forgeTag("juices/grape");
    TagKey<Fluid> JUICE_GRAPE_CRIMSON = forgeTag("juice/crimson_grape");
    TagKey<Fluid> JUICE_GRAPE_WARPED = forgeTag("juice/warped_grape");

    TagKey<Fluid> JUICE_FRUIT = forgeTag("juice/fruit");
    TagKey<Fluid> JUICE_FRUIT_DREAMFRUIT = forgeTag("juice/dreamfruit");
    TagKey<Fluid> JUICE_FRUIT_FROSTHEART_FRUIT = forgeTag("juice/frostheart_fruit");
    TagKey<Fluid> JUICE_FRUIT_TORCHBERRIES = forgeTag("juice/torchberries");
    TagKey<Fluid> JUICE_FRUIT_ENCHANTED_BERRY = forgeTag("juice/enchanted_berry");

    private static TagKey<Fluid> bind(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, name));
    }

    static TagKey<Fluid> forgeTag(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("forge", name));
    }
}
