package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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

    private static final TagKey<Item> CHEMICAL_REPLICATORS = TagKey.create(
            Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "chemical_replicators")
    );

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

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // c:fruits
            this.tag(ModItemTags.FRUITS).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 迷梦果
            // c:fruits/frostheart_fruit
            this.tag(ModItemTags.FRUITS_FROSTHEART).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
            // diet:fruits
            this.tag(ModItemTags.FRUITS_DIET).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(ModItemTags.WINTER_CROPS).addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.FROSTHEART_FRUIT.get())); // 霜心果
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
            this.tag(ModItemTags.UPRIGHT_ON_BELT)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TwilightforestItems.CAVE_GLOWBREW.get())) // 洞窟萤火酿
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
        }


        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // 让物品呈现直立状态
            // create:upright_on_belt
            this.tag(ModItemTags.UPRIGHT_ON_BELT)
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SPRITE.get())) // 雪碧
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.PEPSI.get())) // 可乐
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.FANTA.get())) // 芬达
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.POLLEN_NECTAR.get())) // 花粉甜酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.HONEYTHORN_MEAD.get())) // 蜜刺佳酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())) // 蜂蜡陈酿
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())) // 甜蜜水晶
                    .addOptional(BuiltInRegistries.ITEM.getKey(TheBumblezoneItems.ROYAL_HONEY_BREW.get())); // 蜂王特酿
        }
    }
}
