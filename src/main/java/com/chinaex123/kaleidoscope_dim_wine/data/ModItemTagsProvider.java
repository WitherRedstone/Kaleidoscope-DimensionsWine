package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider  extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // -------------------- 作物 --------------------
        // c:fruits/crimson_grape
        this.tag(ModItemTags.FRUITS_CRIMSON_GRAPE).add(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        // c:fruits/warped_grape
        this.tag(ModItemTags.FRUITS_WARPED_GRAPE).add(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
        // c:fruits/warped_grape
        this.tag(ModItemTags.FRUITS_DREAMFRUIT).add(ModItems.DREAMFRUIT.get()); // 迷梦果
        // diet:fruits
        this.tag(ModItemTags.FRUITS)
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果
        // diet:fruits
        this.tag(ModItemTags.FRUITS)
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // c:fruits/frostheart_fruit
            this.tag(ModItemTags.FRUITS_FROSTHEART).add(TwilightforestItems.FROSTHEART_FRUIT.get()); // 霜心果
            // diet:fruits
            this.tag(ModItemTags.FRUITS).add(TwilightforestItems.FROSTHEART_FRUIT.get()); // 霜心果
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(ModItemTags.WINTER_CROPS).add(TwilightforestItems.FROSTHEART_FRUIT.get()); // 霜心果
            // 巨物碎片
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_sword"))) // 巨人剑
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_pickaxe"))); // 巨人镐
            // 酿酒的水果 - kaleidoscope_dim_wine:wine/berry
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wine/berry")))
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "raspberry"))) // 树莓
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "blueberry"))) // 蓝莓
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "blackberry"))) // 黑莓
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "maloberry"))); // 桑葚
            // 酿酒的云 - kaleidoscope_dim_wine:wine/cloud
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wine/cloud")))
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "wispy_cloud"))) // 薄云
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "fluffy_cloud"))) // 浮云
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "rainy_cloud"))) // 雨云
                    .add(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "snowy_cloud"))); // 雪云
        }
    }
}
