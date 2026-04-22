package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.CrimsonGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.DreamfruitCropWildVineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.WarpedGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.DrinkableItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.BottleBlockItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    public static final DeferredItem<Item> MOD_LOGO = ITEMS_REGISTER.register("mod_logo", () -> new Item(new Item.Properties()));
    // 天使之翼
    public static final DeferredItem<Item> ANGEL_WINGS = ITEMS_REGISTER.register("angel_wings", () -> new Item(new Item.Properties()));
        // 天使之羽
    public static final DeferredItem<Item> ANGEL_FEATHER = ITEMS_REGISTER.register("angel_feather", () -> new Item(new Item.Properties()));

    // -------------------- 瓶装 --------------------
    // 空竹杯
//    public static final DeferredItem<Item> EMPTY_BAMBOO_CUP = ITEMS_REGISTER.register("empty_bamboo_cup", () ->
//            new BottleBlockItem(ModBlocks.EMPTY_BAMBOO_CUP.get(), new Item.Properties()));
    // 易拉罐
    public static final DeferredItem<Item> POP_CAN = ITEMS_REGISTER.register("pop_can", () ->
            new BottleBlockItem(ModBlocks.POP_CAN.get(), new Item.Properties()));

    // ==================== 次元维度 - 下界 ====================
    // -------------------- 作物 --------------------
    // 绯红葡萄藤 - 相当于作物的种子
    public static final DeferredItem<Item> CRIMSON_GRAPEVINE = ITEMS_REGISTER.register("crimson_grapevine", CrimsonGrapevineItem::new);
     // 绯红葡萄 - 结出的果实
    public static final DeferredItem<Item> CRIMSON_GRAPE = ITEMS_REGISTER.register("crimson_grape", () ->
             new Item(new Item.Properties().food(ModFoods.CRIMSON_GRAPE)));
    // 诡异葡萄藤 - 相当于作物的种子
    public static final DeferredItem<Item> WARPED_GRAPEVINE = ITEMS_REGISTER.register("warped_grapevine", WarpedGrapevineItem::new);
    // 诡异葡萄 - 结出的果实
    public static final DeferredItem<Item> WARPED_GRAPE = ITEMS_REGISTER.register("warped_grape", () ->
            new Item(new Item.Properties().food(ModFoods.WARPED_GRAPE)));
    // -------------------- 物品 --------------------
    // 绯红菌露
    public static final DeferredItem<Item> CRIMSON_FUNGAL_SAP = ITEMS_REGISTER.register("crimson_fungal_sap", () -> new Item(new Item.Properties()));
    // 诡影菌髓
    public static final DeferredItem<Item> WARPED_FUNGAL_SAP = ITEMS_REGISTER.register("warped_fungal_sap", () -> new Item(new Item.Properties()));
    // -------------------- 流体 --------------------
    // 绯红葡萄汁桶
    public static final DeferredItem<Item> CRIMSON_GRAPE_JUICE_BUCKET =
            ITEMS_REGISTER.register("crimson_grape_juice_bucket", () -> new BucketItem(ModFluids.CRIMSON_GRAPE_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 诡异葡萄汁桶
    public static final DeferredItem<Item> WARPED_GRAPE_JUICE_BUCKET =
            ITEMS_REGISTER.register("warped_grape_juice_bucket", () -> new BucketItem(ModFluids.WARPED_GRAPE_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------
    // 绯红绝响
    public static final DeferredHolder<Item, DrinkBlockItem> CRIMSON_CRESCENDO = ITEMS_REGISTER.register("crimson_crescendo", () ->
            new DrinkBlockItem(ModBlocks.CRIMSON_CRESCENDO.get()));
    // 诡影尊爵
    public static final DeferredHolder<Item, DrinkBlockItem> ETHEREAL_NOBLE = ITEMS_REGISTER.register("ethereal_noble", () ->
            new DrinkBlockItem(ModBlocks.ETHEREAL_NOBLE.get()));
    // 疣域轩尼诗
    public static final DeferredHolder<Item, DrinkBlockItem> WART_HENNESSY = ITEMS_REGISTER.register("wart_hennessy", () ->
            new DrinkBlockItem(ModBlocks.WART_HENNESSY.get()));
    // 烈焰马爹利
    public static final DeferredHolder<Item, DrinkBlockItem> BLAZE_MARTELL = ITEMS_REGISTER.register("blaze_martell", () ->
            new DrinkBlockItem(ModBlocks.BLAZE_MARTELL.get()));
    // 岩浆皇家礼炮
    public static final DeferredHolder<Item, DrinkBlockItem> MAGMA_ROYAL_SALUTE = ITEMS_REGISTER.register("magma_royal_salute", () ->
            new DrinkBlockItem(ModBlocks.MAGMA_ROYAL_SALUTE.get()));
    // 黑骨拉菲
    public static final DeferredHolder<Item, DrinkBlockItem> BLACK_BONE_LAFITE = ITEMS_REGISTER.register("black_bone_lafite", () ->
            new DrinkBlockItem(ModBlocks.BLACK_BONE_LAFITE.get()));


    // ==================== 次元维度 - 末地 ====================
    // -------------------- 作物 --------------------
    // 迷梦果
    public static final DeferredItem<Item> DREAMFRUIT = ITEMS_REGISTER.register("dreamfruit", () ->
            new DreamfruitCropWildVineItem(new Item.Properties().food(ModFoods.DREAMFRUIT)));
    // -------------------- 物品 --------------------
    // 龙血瓶
    public static final DeferredItem<Item> DRAGON_BLOOD_BOTTLE = ITEMS_REGISTER.register("dragon_blood_bottle", () ->
            new DrinkableItem(new Item.Properties().food(ModFoods.DRAGON_BLOOD_BOTTLE), new ItemStack(Items.GLASS_BOTTLE)));
    // -------------------- 流体 --------------------
    // 迷梦果汁桶
    public static final DeferredItem<Item> DREAMFRUIT_JUICE_BUCKET =
            ITEMS_REGISTER.register("dreamfruit_juice_bucket", () -> new BucketItem(ModFluids.DREAMFRUIT_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 龙血桶
    public static final DeferredItem<Item> DRAGON_BLOOD_BUCKET =
            ITEMS_REGISTER.register("dragon_blood_bucket", () -> new BucketItem(ModFluids.DRAGON_BLOOD.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------
    // 紫颂干邑
    public static final DeferredHolder<Item, DrinkBlockItem> CHORUS_COGNAC = ITEMS_REGISTER.register("chorus_cognac", () ->
            new DrinkBlockItem(ModBlocks.CHORUS_COGNAC.get()));
    // 龙息白兰地
    public static final DeferredHolder<Item, DrinkBlockItem> DRAGONS_BREATH_BRANDY = ITEMS_REGISTER.register("dragons_breath_brandy", () ->
            new DrinkBlockItem(ModBlocks.DRAGONS_BREATH_BRANDY.get()));
    // 深渊波特
    public static final DeferredHolder<Item, DrinkBlockItem> ABYSSAL_PORTER = ITEMS_REGISTER.register("abyssal_porter", () ->
            new DrinkBlockItem(ModBlocks.ABYSSAL_PORTER.get()));
    // 静默雪莉
    public static final DeferredHolder<Item, DrinkBlockItem> SILENT_SHERRY = ITEMS_REGISTER.register("silent_sherry", () ->
            new DrinkBlockItem(ModBlocks.SILENT_SHERRY.get()));
    // 遗忘玛格丽特
    public static final DeferredHolder<Item, DrinkBlockItem> FORGOTTEN_MARGARITA = ITEMS_REGISTER.register("forgotten_margarita", () ->
            new DrinkBlockItem(ModBlocks.FORGOTTEN_MARGARITA.get()));
    // 幻梦泡影
    public static final DeferredHolder<Item, DrinkBlockItem> PHANTOM_DREAM_BUBBLE = ITEMS_REGISTER.register("phantom_dream_bubble", () ->
            new DrinkBlockItem(ModBlocks.PHANTOM_DREAM_BUBBLE.get()));
    // 终末星光
    public static final DeferredHolder<Item, DrinkBlockItem> END_STARLIGHT = ITEMS_REGISTER.register("end_starlight", () ->
            new DrinkBlockItem(ModBlocks.END_STARLIGHT.get()));
    // 神血波尔多
    public static final DeferredHolder<Item, DrinkBlockItem> DIVINE_EMBRYO_PORT = ITEMS_REGISTER.register("divine_embryo_port", () ->
            new DrinkBlockItem(ModBlocks.DIVINE_EMBRYO_PORT.get()));
    // 龙血酒
    public static final DeferredHolder<Item, DrinkBlockItem> DRACONIC_BLOOD_WINE = ITEMS_REGISTER.register("draconic_blood_wine", () ->
            new DrinkBlockItem(ModBlocks.DRACONIC_BLOOD_WINE.get()));

    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
