package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("ConstantConditions")
public class ModItemTagsProvider  extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockTags, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // -------------------- 作物 --------------------
        // c:fruits
        this.tag(ModItemTags.FRUITS)
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果
        // c:fruits/crimson_grape
        this.tag(ModItemTags.FRUITS_CRIMSON_GRAPE).add(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        // c:fruits/warped_grape
        this.tag(ModItemTags.FRUITS_WARPED_GRAPE).add(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
        // c:fruits/warped_grape
        this.tag(ModItemTags.FRUITS_DREAMFRUIT).add(ModItems.DREAMFRUIT.get()); // 迷梦果

        // diet:fruits
        this.tag(ModItemTags.FRUITS_DIET)
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果

        // 让物品呈现直立状态
        // create:upright_on_belt
        this.tag(ModItemTags.UPRIGHT_ON_BELT)
                .add(ModItems.POP_CAN.get()) // 易拉罐
                .add(ModItems.CRIMSON_CRESCENDO.get()) // 绯红绝响
                .add(ModItems.ETHEREAL_NOBLE.get()) // 诡影尊爵
                .add(ModItems.WART_HENNESSY.get()) // 疣域轩尼诗
                .add(ModItems.BLAZE_MARTELL.get()) // 烈焰马爹利
                .add(ModItems.MAGMA_ROYAL_SALUTE.get()) // 岩浆皇家礼炮
                .add(ModItems.BLACK_BONE_LAFITE.get()) // 黑骨拉菲
                .add(ModItems.CHORUS_COGNAC.get()) // 紫颂干邑
                .add(ModItems.DRAGONS_BREATH_BRANDY.get()) // 龙息白兰地
                .add(ModItems.ABYSSAL_PORTER.get()) // 深渊波特
                .add(ModItems.SILENT_SHERRY.get()) // 静默雪莉
                .add(ModItems.FORGOTTEN_MARGARITA.get()) // 遗忘玛格丽特
                .add(ModItems.PHANTOM_DREAM_BUBBLE.get()) // 幻梦泡影
                .add(ModItems.END_STARLIGHT.get()) // 终末星光
                .add(ModItems.DIVINE_EMBRYO_PORT.get()) // 神血波尔多
                .add(ModItems.DRACONIC_BLOOD_WINE.get()); // 龙血酒

        // 葡园酒香柜子
        // vinery:small_bottle
        this.tag(ModItemTags.VINERY_SMALL_BOTTLE)
                .addOptional(ModItems.CRIMSON_CRESCENDO.getId()) // 绯红绝响
                .addOptional(ModItems.ETHEREAL_NOBLE.getId()) // 诡影尊爵
                .addOptional(ModItems.WART_HENNESSY.getId()) // 疣域轩尼诗
                .addOptional(ModItems.BLAZE_MARTELL.getId()) // 烈焰马爹利
                .addOptional(ModItems.BLACK_BONE_LAFITE.getId()) // 黑骨拉菲
                .addOptional(ModItems.CHORUS_COGNAC.getId()) // 紫颂干邑
                .addOptional(ModItems.DRAGONS_BREATH_BRANDY.getId()) // 龙息白兰地
                .addOptional(ModItems.ABYSSAL_PORTER.getId()) // 深渊波特
                .addOptional(ModItems.SILENT_SHERRY.getId()) // 静默雪莉
                .addOptional(ModItems.FORGOTTEN_MARGARITA.getId()) // 遗忘玛格丽特
                .addOptional(ModItems.PHANTOM_DREAM_BUBBLE.getId()) // 幻梦泡影
                .addOptional(ModItems.END_STARLIGHT.getId()) // 终末星光
                .addOptional(ModItems.DIVINE_EMBRYO_PORT.getId()) // 神血波尔多
                .addOptional(ModItems.DRACONIC_BLOOD_WINE.getId()) // 龙血酒
                .addOptional(ModItems.MAGMA_ROYAL_SALUTE.getId()); // 岩浆皇家礼炮
        // vinery:large_bottle
        this.tag(ModItemTags.VINERY_LARGE_BOTTLE)
                .addOptional(ModItems.MAGMA_ROYAL_SALUTE.getId()); // 岩浆皇家礼炮

        // 幻想乡乐事柜子
        // youkaisfeasts:wine
        this.tag(ModItemTags.YOUKAISFEASTS_WINE)
                .addOptional(ModItems.CRIMSON_CRESCENDO.getId()) // 绯红绝响
                .addOptional(ModItems.ETHEREAL_NOBLE.getId()) // 诡影尊爵
                .addOptional(ModItems.WART_HENNESSY.getId()) // 疣域轩尼诗
                .addOptional(ModItems.BLAZE_MARTELL.getId()) // 烈焰马爹利
                .addOptional(ModItems.BLACK_BONE_LAFITE.getId()) // 黑骨拉菲
                .addOptional(ModItems.CHORUS_COGNAC.getId()) // 紫颂干邑
                .addOptional(ModItems.DRAGONS_BREATH_BRANDY.getId()) // 龙息白兰地
                .addOptional(ModItems.ABYSSAL_PORTER.getId()) // 深渊波特
                .addOptional(ModItems.SILENT_SHERRY.getId()) // 静默雪莉
                .addOptional(ModItems.FORGOTTEN_MARGARITA.getId()) // 遗忘玛格丽特
                .addOptional(ModItems.PHANTOM_DREAM_BUBBLE.getId()) // 幻梦泡影
                .addOptional(ModItems.END_STARLIGHT.getId()) // 终末星光
                .addOptional(ModItems.DIVINE_EMBRYO_PORT.getId()) // 神血波尔多
                .addOptional(ModItems.DRACONIC_BLOOD_WINE.getId()) // 龙血酒
                .addOptional(ModItems.MAGMA_ROYAL_SALUTE.getId()); // 岩浆皇家礼炮

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // c:fruits
            this.tag(ModItemTags.FRUITS).addOptional(TwilightforestItems.FROSTHEART_FRUIT.getId()); // 迷梦果
            // c:fruits/frostheart_fruit
            this.tag(ModItemTags.FRUITS_FROSTHEART).addOptional(TwilightforestItems.FROSTHEART_FRUIT.getId()); // 霜心果
            // diet:fruits
            this.tag(ModItemTags.FRUITS_DIET).addOptional(TwilightforestItems.FROSTHEART_FRUIT.getId()); // 霜心果
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(ModItemTags.WINTER_CROPS).addOptional(TwilightforestItems.FROSTHEART_FRUIT.getId()); // 霜心果
            // 巨物碎片
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_sword")) // 巨人剑
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_pickaxe")); // 巨人镐
            // 酿酒的水果 - kaleidoscope_dim_wine:wine/berry
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wine/berry")))
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "raspberry")) // 树莓
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blueberry")) // 蓝莓
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blackberry")) // 黑莓
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "maloberry")); // 桑葚
            // 酿酒的云 - kaleidoscope_dim_wine:wine/cloud
            this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wine/cloud")))
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "wispy_cloud")) // 薄云
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "fluffy_cloud")) // 浮云
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "rainy_cloud")) // 雨云
                    .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "snowy_cloud")); // 雪云

            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(ModItemTags.UPRIGHT_ON_BELT)
                    .addOptional(TwilightforestItems.CAVE_GLOWBREW.getId()) // 洞窟萤火酿
                    .addOptional(TwilightforestItems.DAWNLIGHT_DEW.getId()) // 林隙晨露
                    .addOptional(TwilightforestItems.DEAD_END_SPITTLE.getId()) // 死巷之唾
                    .addOptional(TwilightforestItems.SNAKESKIN_LIQUEUR.getId()) // 蛇蜕利口酒
                    .addOptional(TwilightforestItems.FROSTVEIN_BEASTBLOOD.getId()) // 霜脉兽血
                    .addOptional(TwilightforestItems.RANGERS_SATCHEL.getId()) // 巡林客的背囊
                    .addOptional(TwilightforestItems.EMBEREYE.getId()) // 烬瞳
                    .addOptional(TwilightforestItems.STAGCALL_MONSOON.getId()) // 鹿鸣季风
                    .addOptional(TwilightforestItems.THORNHEART.getId()) // 荆棘之心
                    .addOptional(TwilightforestItems.DRUIDS_SECRET_BREW.getId()) // 德鲁伊的秘酿
                    .addOptional(TwilightforestItems.MOORGLOW_BIRDS_SONG.getId()) // 辉夜鸟之歌
                    .addOptional(TwilightforestItems.PERENNIAL_FROST.getId()) // 终年冻土
                    .addOptional(TwilightforestItems.GIANTS_HYMN.getId()) // 巨人赞歌
                    .addOptional(TwilightforestItems.GOBLINS_STASH.getId()); // 地精的私藏

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(ModItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(TwilightforestItems.CAVE_GLOWBREW.getId()) // 洞窟萤火酿
                    .addOptional(TwilightforestItems.SNAKESKIN_LIQUEUR.getId()) // 蛇蜕利口酒
                    .addOptional(TwilightforestItems.RANGERS_SATCHEL.getId()) // 巡林客的背囊
                    .addOptional(TwilightforestItems.EMBEREYE.getId()) // 烬瞳
                    .addOptional(TwilightforestItems.DRUIDS_SECRET_BREW.getId()) // 德鲁伊的秘酿
                    .addOptional(TwilightforestItems.MOORGLOW_BIRDS_SONG.getId()) // 辉夜鸟之歌
                    .addOptional(TwilightforestItems.PERENNIAL_FROST.getId()) // 终年冻土
                    .addOptional(TwilightforestItems.GOBLINS_STASH.getId()); // 地精的私藏
            // vinery:large_bottle
            this.tag(ModItemTags.VINERY_LARGE_BOTTLE)
                    .addOptional(TwilightforestItems.DAWNLIGHT_DEW.getId()) // 林隙晨露
                    .addOptional(TwilightforestItems.DEAD_END_SPITTLE.getId()) // 死巷之唾
                    .addOptional(TwilightforestItems.FROSTVEIN_BEASTBLOOD.getId()) // 霜脉兽血
                    .addOptional(TwilightforestItems.STAGCALL_MONSOON.getId()) // 鹿鸣季风
                    .addOptional(TwilightforestItems.THORNHEART.getId()) // 荆棘之心
                    .addOptional(TwilightforestItems.GIANTS_HYMN.getId()); // 巨人赞歌

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(ModItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(TwilightforestItems.CAVE_GLOWBREW.getId()) // 洞窟萤火酿
                    .addOptional(TwilightforestItems.SNAKESKIN_LIQUEUR.getId()) // 蛇蜕利口酒
                    .addOptional(TwilightforestItems.RANGERS_SATCHEL.getId()) // 巡林客的背囊
                    .addOptional(TwilightforestItems.EMBEREYE.getId()) // 烬瞳
                    .addOptional(TwilightforestItems.DRUIDS_SECRET_BREW.getId()) // 德鲁伊的秘酿
                    .addOptional(TwilightforestItems.MOORGLOW_BIRDS_SONG.getId()) // 辉夜鸟之歌
                    .addOptional(TwilightforestItems.PERENNIAL_FROST.getId()) // 终年冻土
                    .addOptional(TwilightforestItems.GOBLINS_STASH.getId()); // 地精的私藏
        }


        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(ModItemTags.UPRIGHT_ON_BELT)
                    .addOptional(TheBumblezoneItems.SPRITE.getId()) // 雪碧
                    .addOptional(TheBumblezoneItems.PEPSI.getId()) // 可乐
                    .addOptional(TheBumblezoneItems.FANTA.getId()) // 芬达
                    .addOptional(TheBumblezoneItems.POLLEN_NECTAR.getId()) // 花粉甜酿
                    .addOptional(TheBumblezoneItems.HONEYTHORN_MEAD.getId()) // 蜜刺佳酿
                    .addOptional(TheBumblezoneItems.BEESWAX_HONEY_WINE.getId()) // 蜂蜡陈酿
                    .addOptional(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.getId()) // 甜蜜水晶
                    .addOptional(TheBumblezoneItems.ROYAL_HONEY_BREW.getId()); // 蜂王特酿

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(ModItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(TheBumblezoneItems.SPRITE.getId()) // 雪碧
                    .addOptional(TheBumblezoneItems.PEPSI.getId()) // 可乐
                    .addOptional(TheBumblezoneItems.FANTA.getId()) // 芬达
                    .addOptional(TheBumblezoneItems.POLLEN_NECTAR.getId()) // 花粉甜酿
                    .addOptional(TheBumblezoneItems.HONEYTHORN_MEAD.getId()) // 蜜刺佳酿
                    .addOptional(TheBumblezoneItems.BEESWAX_HONEY_WINE.getId()) // 蜂蜡陈酿
                    .addOptional(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.getId()) // 甜蜜水晶
                    .addOptional(TheBumblezoneItems.ROYAL_HONEY_BREW.getId()); // 蜂王特酿

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(ModItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(TheBumblezoneItems.SPRITE.getId()) // 雪碧
                    .addOptional(TheBumblezoneItems.PEPSI.getId()) // 可乐
                    .addOptional(TheBumblezoneItems.FANTA.getId()) // 芬达
                    .addOptional(TheBumblezoneItems.POLLEN_NECTAR.getId()) // 花粉甜酿
                    .addOptional(TheBumblezoneItems.HONEYTHORN_MEAD.getId()) // 蜜刺佳酿
                    .addOptional(TheBumblezoneItems.BEESWAX_HONEY_WINE.getId()) // 蜂蜡陈酿
                    .addOptional(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.getId()) // 甜蜜水晶
                    .addOptional(TheBumblezoneItems.ROYAL_HONEY_BREW.getId()); // 蜂王特酿
        }


        // ==================== 次元维度 - 天境 ====================
        if (ModList.get().isLoaded("aether")) {
            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(ModItemTags.UPRIGHT_ON_BELT)
                    .addOptional(AetherItems.DIVINE_OFFERING_BREW.getId()) // 神饯紫晶酿
                    .addOptional(AetherItems.DIVINE_ENERGY_MIST.getId()) // 神能迷雾
                    .addOptional(AetherItems.SWET_FIZZ.getId()) // 史维特菲士
                    .addOptional(AetherItems.GRAVITITE_DRUNK.getId()) // 重力醉
                    .addOptional(AetherItems.HEALING_ELIXIR.getId()) // 治愈灵药
                    .addOptional(AetherItems.GINGERBREAD_WARMER.getId()) // 姜饼暖饮
                    .addOptional(AetherItems.UNBOUND_SKYBORN.getId()); // 无界苍穹

            // 葡园酒香柜子
            // vinery:small_bottle
            this.tag(ModItemTags.VINERY_SMALL_BOTTLE)
                    .addOptional(AetherItems.DIVINE_ENERGY_MIST.getId()) // 神能迷雾
                    .addOptional(AetherItems.SWET_FIZZ.getId()) // 史维特菲士
                    .addOptional(AetherItems.GRAVITITE_DRUNK.getId()) // 重力醉
                    .addOptional(AetherItems.HEALING_ELIXIR.getId()) // 治愈灵药
                    .addOptional(AetherItems.UNBOUND_SKYBORN.getId()); // 无界苍穹
            // vinery:large_bottle
            this.tag(ModItemTags.VINERY_LARGE_BOTTLE)
                    .addOptional(AetherItems.DIVINE_OFFERING_BREW.getId()) // 神饯紫晶酿
                    .addOptional(AetherItems.GINGERBREAD_WARMER.getId()); // 姜饼暖饮

            // 幻想乡乐事柜子
            // youkaisfeasts:wine
            this.tag(ModItemTags.YOUKAISFEASTS_WINE)
                    .addOptional(AetherItems.DIVINE_ENERGY_MIST.getId()) // 神能迷雾
                    .addOptional(AetherItems.SWET_FIZZ.getId()) // 史维特菲士
                    .addOptional(AetherItems.GRAVITITE_DRUNK.getId()) // 重力醉
                    .addOptional(AetherItems.HEALING_ELIXIR.getId()) // 治愈灵药
                    .addOptional(AetherItems.UNBOUND_SKYBORN.getId()); // 无界苍穹
        }
    }
}
