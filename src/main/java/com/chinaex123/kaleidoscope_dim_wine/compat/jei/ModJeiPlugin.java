package com.chinaex123.kaleidoscope_dim_wine.compat.jei;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
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

        // ==================== 次元维度 - 下界 ====================
        // 绯红葡萄藤
        itemInfos.put(ModItems.CRIMSON_GRAPEVINE.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.the_nether"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_nether.crimson_forest"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.crimson_grapevine"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.crimson_grapevine")
        });
        // 诡异葡萄藤
        itemInfos.put(ModItems.WARPED_GRAPEVINE.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.the_nether"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_nether.warped_forest"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.warped_grapevine"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.warped_grapevine")
        });
        // 绯红菌露
        itemInfos.put(ModItems.CRIMSON_FUNGAL_SAP.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.crimson_fungal_sap")
        });
        // 诡影菌髓
        itemInfos.put(ModItems.WARPED_FUNGAL_SAP.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.warped_fungal_sap")
        });

        // ==================== 次元维度 - 末地 ====================
        // 迷梦果
        itemInfos.put(ModItems.DREAMFRUIT.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.the_end"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_end.end_midlands"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.the_end.end_highlands"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.dreamfruit"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.dreamfruit")
        });
        // 龙血桶
        itemInfos.put(ModItems.DRAGON_BLOOD_BUCKET.get(), new Component[]{
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.dragon_blood_bucket"),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.special_features").withStyle(ChatFormatting.BOLD),
                Component.translatable("jei.info.kaleidoscope_dim_wine.items.special_features.dragon_blood_bucket")
        });

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // 霜心果
            itemInfos.put(TwilightforestItems.FROSTHEART_FRUIT.get(), new Component[]{
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.twilightforest"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.dimensions.biome.twilightforest.snowy_forest"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.frostheart_fruit"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.frostheart_fruit")
            });
            // 霜心果
            itemInfos.put(TwilightforestItems.GOBLIN_ESSENCE.get(), new Component[]{
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.goblin_essence")
            });
        }

        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // 蜜酒精华
            itemInfos.put(TheBumblezoneItems.MEAD_ESSENCE.get(), new Component[]{
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.1"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.2"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.3"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.4"),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.5")
            });
            // 凝碳粉
            itemInfos.put(TheBumblezoneItems.CARBOCRETIN_POWDER.get(), new Component[]{
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement").withStyle(ChatFormatting.BOLD),
                    Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.carbocretin_powder")
            });
        }

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
