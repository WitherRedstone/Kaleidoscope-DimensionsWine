package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
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
        // c:fruits
        this.tag(KDWItemTags.FRUITS)
                .add(KDWItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(KDWItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(KDWItems.DREAMFRUIT.get()); // 迷梦果
        // c:fruits/crimson_grape
        this.tag(KDWItemTags.FRUITS_CRIMSON_GRAPE).add(KDWItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        // c:fruits/warped_grape
        this.tag(KDWItemTags.FRUITS_WARPED_GRAPE).add(KDWItems.WARPED_GRAPE.get()); // 诡异葡萄
        // c:fruits/warped_grape
        this.tag(KDWItemTags.FRUITS_DREAMFRUIT).add(KDWItems.DREAMFRUIT.get()); // 迷梦果

        // diet:fruits
        this.tag(KDWItemTags.FRUITS_DIET)
                .add(KDWItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(KDWItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(KDWItems.DREAMFRUIT.get()); // 迷梦果

        // 让物品呈现直立状态
        // create:upright_on_belt
        this.tag(KDWItemTags.UPRIGHT_ON_BELT)
                .add(KDWItems.POP_CAN.get()) // 易拉罐
                .add(KDWItems.CRIMSON_CRESCENDO.get()) // 绯红绝响
                .add(KDWItems.ETHEREAL_NOBLE.get()) // 诡影尊爵
                .add(KDWItems.WART_HENNESSY.get()) // 疣域轩尼诗
                .add(KDWItems.BLAZE_MARTELL.get()) // 烈焰马爹利
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get()) // 岩浆皇家礼炮
                .add(KDWItems.BLACK_BONE_LAFITE.get()) // 黑骨拉菲
                .add(KDWItems.CHORUS_COGNAC.get()) // 紫颂干邑
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get()) // 龙息白兰地
                .add(KDWItems.ABYSSAL_PORTER.get()) // 深渊波特
                .add(KDWItems.SILENT_SHERRY.get()) // 静默雪莉
                .add(KDWItems.FORGOTTEN_MARGARITA.get()) // 遗忘玛格丽特
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get()) // 幻梦泡影
                .add(KDWItems.END_STARLIGHT.get()) // 终末星光
                .add(KDWItems.DIVINE_EMBRYO_PORT.get()) // 神血波尔多
                .add(KDWItems.DRACONIC_BLOOD_WINE.get()); // 龙血酒

        // 葡园酒香柜子
        // vinery:small_bottle
        this.tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.CRIMSON_CRESCENDO.get())) // 绯红绝响
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.ETHEREAL_NOBLE.get())) // 诡影尊爵
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.WART_HENNESSY.get())) // 疣域轩尼诗
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.BLAZE_MARTELL.get())) // 烈焰马爹利
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.BLACK_BONE_LAFITE.get())) // 黑骨拉菲
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.CHORUS_COGNAC.get())) // 紫颂干邑
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DRAGONS_BREATH_BRANDY.get())) // 龙息白兰地
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.ABYSSAL_PORTER.get())) // 深渊波特
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.SILENT_SHERRY.get())) // 静默雪莉
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.FORGOTTEN_MARGARITA.get())) // 遗忘玛格丽特
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.PHANTOM_DREAM_BUBBLE.get())) // 幻梦泡影
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.END_STARLIGHT.get())) // 终末星光
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DIVINE_EMBRYO_PORT.get())) // 神血波尔多
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DRACONIC_BLOOD_WINE.get())); // 龙血酒
        // vinery:large_bottle
        this.tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.MAGMA_ROYAL_SALUTE.get())); // 岩浆皇家礼炮

        // 葡园酒香柜子
        // youkaisfeasts:wine
        this.tag(KDWItemTags.YOUKAISFEASTS_WINE)
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.CRIMSON_CRESCENDO.get())) // 绯红绝响
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.ETHEREAL_NOBLE.get())) // 诡影尊爵
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.WART_HENNESSY.get())) // 疣域轩尼诗
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.BLAZE_MARTELL.get())) // 烈焰马爹利
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.BLACK_BONE_LAFITE.get())) // 黑骨拉菲
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.CHORUS_COGNAC.get())) // 紫颂干邑
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DRAGONS_BREATH_BRANDY.get())) // 龙息白兰地
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.ABYSSAL_PORTER.get())) // 深渊波特
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.SILENT_SHERRY.get())) // 静默雪莉
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.FORGOTTEN_MARGARITA.get())) // 遗忘玛格丽特
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.PHANTOM_DREAM_BUBBLE.get())) // 幻梦泡影
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.END_STARLIGHT.get())) // 终末星光
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DIVINE_EMBRYO_PORT.get())) // 神血波尔多
                .addOptional(BuiltInRegistries.ITEM.getKey(KDWItems.DRACONIC_BLOOD_WINE.get())); // 龙血酒

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // c:fruits
            this.tag(KDWItemTags.FRUITS).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 迷梦果
            // c:fruits/frostheart_fruit
            this.tag(KDWItemTags.FRUITS_FROSTHEART).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
            // diet:fruits
            this.tag(KDWItemTags.FRUITS_DIET).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(KDWItemTags.WINTER_CROPS).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
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

            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(KDWItemTags.UPRIGHT_ON_BELT)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.CAVE_GLOWBREW.get())) // 洞窟萤火酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DAWNLIGHT_DEW.get())) // 林隙晨露
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DEAD_END_SPITTLE.get())) // 死巷之唾
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.SNAKESKIN_LIQUEUR.get())) // 蛇蜕利口酒
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get())) // 霜脉兽血
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.RANGERS_SATCHEL.get())) // 巡林客的背囊
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.EMBEREYE.get())) // 烬瞳
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.STAGCALL_MONSOON.get())) // 鹿鸣季风
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.THORNHEART.get())) // 荆棘之心
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DRUIDS_SECRET_BREW.get())) // 德鲁伊的秘酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.MOORGLOW_BIRDS_SONG.get())) // 辉夜鸟之歌
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.PERENNIAL_FROST.get())) // 终年冻土
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.GIANTS_HYMN.get())) // 巨人赞歌
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.GOBLINS_STASH.get())); // 地精的私藏

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.CAVE_GLOWBREW.get())) // 洞窟萤火酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.SNAKESKIN_LIQUEUR.get())) // 蛇蜕利口酒
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.RANGERS_SATCHEL.get())) // 巡林客的背囊
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.EMBEREYE.get())) // 烬瞳
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DRUIDS_SECRET_BREW.get())) // 德鲁伊的秘酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.MOORGLOW_BIRDS_SONG.get())) // 辉夜鸟之歌
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.PERENNIAL_FROST.get())) // 终年冻土
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.GOBLINS_STASH.get())); // 地精的私藏
            // vinery:large_bottle
            this.tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DAWNLIGHT_DEW.get())) // 林隙晨露
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DEAD_END_SPITTLE.get())) // 死巷之唾
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get())) // 霜脉兽血
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.STAGCALL_MONSOON.get())) // 鹿鸣季风
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.THORNHEART.get())) // 荆棘之心
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.GIANTS_HYMN.get())); // 巨人赞歌

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(KDWItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.CAVE_GLOWBREW.get())) // 洞窟萤火酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.SNAKESKIN_LIQUEUR.get())) // 蛇蜕利口酒
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.RANGERS_SATCHEL.get())) // 巡林客的背囊
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.EMBEREYE.get())) // 烬瞳
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.DRUIDS_SECRET_BREW.get())) // 德鲁伊的秘酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.MOORGLOW_BIRDS_SONG.get())) // 辉夜鸟之歌
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.PERENNIAL_FROST.get())) // 终年冻土
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.GOBLINS_STASH.get())); // 地精的私藏
        }


        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(KDWItemTags.UPRIGHT_ON_BELT)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SPRITE.get())) // 雪碧
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.PEPSI.get())) // 可乐
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.FANTA.get())) // 芬达
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.POLLEN_NECTAR.get())) // 花粉甜酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.HONEYTHORN_MEAD.get())) // 蜜刺佳酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())) // 蜂蜡陈酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())) // 甜蜜水晶
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.ROYAL_HONEY_BREW.get())); // 蜂王特酿

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SPRITE.get())) // 雪碧
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.PEPSI.get())) // 可乐
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.FANTA.get())) // 芬达
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.POLLEN_NECTAR.get())) // 花粉甜酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.HONEYTHORN_MEAD.get())) // 蜜刺佳酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())) // 蜂蜡陈酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())) // 甜蜜水晶
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.ROYAL_HONEY_BREW.get())); // 蜂王特酿

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(KDWItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SPRITE.get())) // 雪碧
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.PEPSI.get())) // 可乐
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.FANTA.get())) // 芬达
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.POLLEN_NECTAR.get())) // 花粉甜酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.HONEYTHORN_MEAD.get())) // 蜜刺佳酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())) // 蜂蜡陈酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())) // 甜蜜水晶
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.ROYAL_HONEY_BREW.get())); // 蜂王特酿
        }


        // ==================== 次元维度 - 天境 ====================
        if (ModList.get().isLoaded("aether")) {
            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(KDWItemTags.UPRIGHT_ON_BELT)
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.DIVINE_OFFERING_BREW.get())) // 神饯紫晶酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.DIVINE_ENERGY_MIST.get())) // 神能迷雾
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.SWET_FIZZ.get())) // 史维特菲士
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.GRAVITITE_DRUNK.get())) // 重力醉
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.HEALING_ELIXIR.get())) // 治愈灵药
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.GINGERBREAD_WARMER.get())) // 姜饼暖饮
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.UNBOUND_SKYBORN.get())); // 无界苍穹

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.DIVINE_ENERGY_MIST.get())) // 神能迷雾
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.SWET_FIZZ.get())) // 史维特菲士
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.GRAVITITE_DRUNK.get())) // 重力醉
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.HEALING_ELIXIR.get())) // 治愈灵药
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.UNBOUND_SKYBORN.get())); // 无界苍穹
            // vinery:large_bottle
            this.tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.DIVINE_OFFERING_BREW.get())) // 姜饼暖饮
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.GINGERBREAD_WARMER.get())); // 姜饼暖饮

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(KDWItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.DIVINE_ENERGY_MIST.get())) // 神能迷雾
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.SWET_FIZZ.get())) // 史维特菲士
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.GRAVITITE_DRUNK.get())) // 重力醉
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.HEALING_ELIXIR.get())) // 治愈灵药
                    .addOptional(BuiltInRegistries.ITEM.getKey(AetherItems.UNBOUND_SKYBORN.get())); // 无界苍穹
        }
    }
}
