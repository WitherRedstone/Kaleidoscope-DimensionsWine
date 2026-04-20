package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public interface ModItemTags {

    // -------------------- 作物 --------------------
    TagKey<Item> FRUITS = neoforgeItemTag("fruits"); // c:fruits
    TagKey<Item> FRUITS_CRIMSON_GRAPE = neoforgeItemTag("fruits/crimson_grape"); // c:fruits/crimson_grape
    TagKey<Item> FRUITS_WARPED_GRAPE = neoforgeItemTag("fruits/warped_grape"); // c:fruits/warped_grape
    TagKey<Item> FRUITS_DREAMFRUIT = neoforgeItemTag("fruits/dreamfruit"); // c:fruits/dreamfruit
    TagKey<Item> FRUITS_FROSTHEART = neoforgeItemTag("fruits/frostheart_fruit"); // c:fruits/frostheart_fruit

    // 均衡饮食
    TagKey<Item> FRUITS_DIET = dietTag("fruits"); // diet:fruits

    // 静谧四季
    TagKey<Item> SPRING_CROPS = seasonsItemTag("spring_crops");
    TagKey<Item> SUMMER_CROPS = seasonsItemTag("summer_crops");
    TagKey<Item> AUTUMN_CROPS = seasonsItemTag("autumn_crops");
    TagKey<Item> WINTER_CROPS = seasonsItemTag("winter_crops");
    TagKey<Item> YEAR_ROUND_CROPS = seasonsItemTag("year_round_crops");

    // 让物品呈现直立状态
    TagKey<Item> UPRIGHT_ON_BELT = createItemTag("upright_on_belt"); // create:upright_on_belt


    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, name));
    }

    private static TagKey<Item> neoforgeItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
    }

    static TagKey<Item> dietTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("diet", name));
    }

    static TagKey<Item> seasonsItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("sereneseasons", name));
    }

    static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("create", name));
    }
}
