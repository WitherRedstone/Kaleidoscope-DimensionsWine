package com.chinaex123.kaleidoscope_dim_wine.compat.jei;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        Map<Item, Component[]> itemInfos = new HashMap<>();
        // 绯红葡萄藤
        itemInfos.put(ModItems.CRIMSON_GRAPEVINE.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.the_nether"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_nether.crimson_forest"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.natural_growth.crimson_grapevine"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.crimson_grapevine")
        });
        // 诡异葡萄藤
        itemInfos.put(ModItems.WARPED_GRAPEVINE.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.the_nether"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_nether.warped_forest"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.natural_growth.warped_grapevine"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.warped_grapevine")
        });
        // 迷梦果
        itemInfos.put(ModItems.DREAMFRUIT.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.the_end"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_end.end_midlands"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_end.end_highlands"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.natural_growth.dreamfruit"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.dreamfruit")
        });
        // 龙血桶
        itemInfos.put(ModItems.DRAGON_BLOOD_BUCKET.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.natural_growth.dragon_blood_bucket")
        });

        itemInfos.forEach(registration::addIngredientInfo);
    }

    private void addInfoText(IRecipeRegistration registration, Item item, String[] keys) {
        Component[] components = new Component[keys.length];
        for (int i = 0; i < keys.length; i++) {
            components[i] = Component.translatable(keys[i]);
        }
        registration.addIngredientInfo(item, components);
    }
}
