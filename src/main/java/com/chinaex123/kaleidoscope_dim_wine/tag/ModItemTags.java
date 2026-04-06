package com.chinaex123.kaleidoscope_dim_wine.tag;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface ModItemTags {

    // -------------------- 作物 --------------------
    TagKey<Item> FRUITS_CRIMSON_GRAPE = neoforgeItemTag("fruits/crimson_grape"); // c:fruits/crimson_grape
    TagKey<Item> FRUITS_WARPED_GRAPE = neoforgeItemTag("fruits/warped_grape"); // c:fruits/warped_grape

    // 均衡饮食
    TagKey<Item> FRUITS = dietTag("fruits"); // diet:fruits

    // 静谧四季
    TagKey<Item> SPRING_CROPS = seasonsItemTag("spring_crops");
    TagKey<Item> SUMMER_CROPS = seasonsItemTag("summer_crops");
    TagKey<Item> AUTUMN_CROPS = seasonsItemTag("autumn_crops");
    TagKey<Item> WINTER_CROPS = seasonsItemTag("winter_crops");
    TagKey<Item> YEAR_ROUND_CROPS = seasonsItemTag("year_round_crops");
    TagKey<Block> SPRING_CROPS_BLOCK = seasonsBlockTag("spring_crops");
    TagKey<Block> SUMMER_CROPS_BLOCK = seasonsBlockTag("summer_crops");
    TagKey<Block> AUTUMN_CROPS_BLOCK = seasonsBlockTag("autumn_crops");
    TagKey<Block> WINTER_CROPS_BLOCK = seasonsBlockTag("winter_crops");
    TagKey<Block> YEAR_ROUND_CROPS_BLOCK = seasonsBlockTag("year_round_crops");

    // 节气
    TagKey<Block> CROPS_SPRING = eclipticSeasonsTag("crops/spring"); // 春
    TagKey<Block> CROPS_SUMMER = eclipticSeasonsTag("crops/summer"); // 夏
    TagKey<Block> CROPS_AUTUMN = eclipticSeasonsTag("crops/autumn"); // 秋
    TagKey<Block> CROPS_WINTER = eclipticSeasonsTag("crops/winter"); // 冬
    TagKey<Block> CROPS_ALL_SEASONS_BLOCK = seasonsBlockTag("crops/all_seasons"); // 全年生长
    TagKey<Block> CROPS_DRY_AVERAGE = eclipticSeasonsTag("crops/dry_average"); // 干燥
    TagKey<Block> CROPS_AVERAGE_MOIST = eclipticSeasonsTag("crops/average_moist"); // 一般
    TagKey<Block> CROPS_MOIST_HUMID = eclipticSeasonsTag("crops/moist_humid"); // 湿润
    TagKey<Block> CROPS_HUMID_HUMID = eclipticSeasonsTag("crops/humid_humid"); // 潮湿


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

    static TagKey<Block> seasonsBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("sereneseasons", name));
    }

    static TagKey<Block> eclipticSeasonsTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("eclipticseasons", name));
    }

}
