package com.chinaex123.kaleidoscope_dim_wine.item;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.event.Crop.CrimsonGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.event.Crop.DreamfruitCropWildVineItem;
import com.chinaex123.kaleidoscope_dim_wine.event.Crop.WarpedGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.fluid.ModFluids;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 次元维度 - 下界 ====================
    // -------------------- 作物 --------------------
    // 绯红葡萄藤 - 相当于作物的种子
    public static final DeferredItem<Item> CRIMSON_GRAPEVINE =
            ITEMS_REGISTER.register("crimson_grapevine", CrimsonGrapevineItem::new);
     // 绯红葡萄 - 结出的果实
    public static final DeferredItem<Item> CRIMSON_GRAPE =
            ITEMS_REGISTER.register("crimson_grape", () -> new Item(new Item.Properties().food(ModFoods.CRIMSON_GRAPE)));
    // 诡异葡萄藤 - 相当于作物的种子
    public static final DeferredItem<Item> WARPED_GRAPEVINE =
            ITEMS_REGISTER.register("warped_grapevine", WarpedGrapevineItem::new);
    // 诡异葡萄 - 结出的果实
    public static final DeferredItem<Item> WARPED_GRAPE =
            ITEMS_REGISTER.register("warped_grape", () -> new Item(new Item.Properties().food(ModFoods.WARPED_GRAPE)));
    // -------------------- 物品 --------------------
    // 绯红菌露
    public static final DeferredItem<Item> CRIMSON_FUNGAL_SAP = ITEMS_REGISTER.register("crimson_fungal_sap", () -> new Item(new Item.Properties()));
    // 诡影菌髓
    public static final DeferredItem<Item> WARPED_FUNGAL_SAP = ITEMS_REGISTER.register("warped_fungal_sap", () -> new Item(new Item.Properties()));
    // -------------------- 流体 --------------------
    // 绯红葡萄汁桶
    public static final DeferredItem<Item> CRIMSON_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("crimson_grape_juice_bucket", () ->
            new BucketItem(ModFluids.CRIMSON_GRAPE_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 诡异葡萄汁桶
    public static final DeferredItem<Item> WARPED_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("warped_grape_juice_bucket", () ->
            new BucketItem(ModFluids.WARPED_GRAPE_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------
    // 绯红绝响
    public static final DeferredHolder<Item, DrinkBlockItem> CRIMSON_CRESCENDO =
            ITEMS_REGISTER.register("crimson_crescendo", () -> new DrinkBlockItem(ModBlocks.CRIMSON_CRESCENDO.get()));
    // 诡影尊爵
    public static final DeferredHolder<Item, DrinkBlockItem> ETHEREAL_NOBLE =
            ITEMS_REGISTER.register("ethereal_noble", () -> new DrinkBlockItem(ModBlocks.ETHEREAL_NOBLE.get()));
    // 疣域轩尼诗
    public static final DeferredHolder<Item, DrinkBlockItem> WART_HENNESSY =
            ITEMS_REGISTER.register("wart_hennessy", () -> new DrinkBlockItem(ModBlocks.WART_HENNESSY.get()));
    // 烈焰马爹利
    public static final DeferredHolder<Item, DrinkBlockItem> BLAZE_MARTELL =
            ITEMS_REGISTER.register("blaze_martell", () -> new DrinkBlockItem(ModBlocks.BLAZE_MARTELL.get()));
    // 岩浆皇家礼炮
    public static final DeferredHolder<Item, DrinkBlockItem> MAGMA_ROYAL_SALUTE =
            ITEMS_REGISTER.register("magma_royal_salute", () -> new DrinkBlockItem(ModBlocks.MAGMA_ROYAL_SALUTE.get()));
    // 黑骨拉菲
    public static final DeferredHolder<Item, DrinkBlockItem> BLACK_BONE_LAFITE =
            ITEMS_REGISTER.register("black_bone_lafite", () -> new DrinkBlockItem(ModBlocks.BLACK_BONE_LAFITE.get()));


    // ==================== 次元维度 - 末地 ====================
    // -------------------- 作物 --------------------
    // 迷梦果
    public static final DeferredItem<Item> DREAMFRUIT =
            ITEMS_REGISTER.register("dreamfruit", () -> new DreamfruitCropWildVineItem(new Item.Properties().food(ModFoods.DREAMFRUIT)));
    // -------------------- 流体 --------------------
    // -------------------- 酒类 --------------------




    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
