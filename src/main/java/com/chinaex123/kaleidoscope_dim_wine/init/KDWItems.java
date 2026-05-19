package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.CrimsonGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.DreamfruitCropWildVineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.WarpedGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.DrinkableItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.BottleBlockItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface KDWItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);
    DeferredItem<Item> MOD_LOGO = ITEMS_REGISTER.register("mod_logo", () -> new Item(new Item.Properties()));

    // ==================== 次元维度 - 主世界 ====================
    // 物品
    DeferredItem<Item> ANGEL_WINGS = ITEMS_REGISTER.register("angel_wings", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    DeferredItem<Item> ANGEL_FEATHER = ITEMS_REGISTER.register("angel_feather", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    // 瓶装
    DeferredItem<Item> POP_CAN = ITEMS_REGISTER.register("pop_can", () -> new BottleBlockItem(KDWBlocks.POP_CAN.get(), new Item.Properties()));

    // ==================== 次元维度 - 下界 ====================
    // -------------------- 作物 --------------------
    // 绯红葡萄藤 - 相当于作物的种子
    DeferredItem<Item> CRIMSON_GRAPEVINE = ITEMS_REGISTER.register("crimson_grapevine", CrimsonGrapevineItem::new);
    // 绯红葡萄 - 结出的果实
    DeferredItem<Item> CRIMSON_GRAPE = ITEMS_REGISTER.register("crimson_grape", () -> new Item(new Item.Properties().food(KDWFoods.GRAPE)));
    // 诡异葡萄藤 - 相当于作物的种子
    DeferredItem<Item> WARPED_GRAPEVINE = ITEMS_REGISTER.register("warped_grapevine", WarpedGrapevineItem::new);
    // 诡异葡萄 - 结出的果实
    DeferredItem<Item> WARPED_GRAPE = ITEMS_REGISTER.register("warped_grape", () -> new Item(new Item.Properties().food(KDWFoods.GRAPE)));

    // 物品
    DeferredItem<Item> CRIMSON_FUNGAL_SAP = ITEMS_REGISTER.register("crimson_fungal_sap", () -> new Item(new Item.Properties()));
    DeferredItem<Item> WARPED_FUNGAL_SAP = ITEMS_REGISTER.register("warped_fungal_sap", () -> new Item(new Item.Properties()));

     // 流体
     DeferredItem<Item> CRIMSON_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("crimson_grape_juice_bucket", () ->
             new BucketItem(KDWFluids.CRIMSON_GRAPE_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    DeferredItem<Item> WARPED_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("warped_grape_juice_bucket", () ->
            new BucketItem(KDWFluids.WARPED_GRAPE_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // 酒类
    DeferredItem<Item> CRIMSON_CRESCENDO = ITEMS_REGISTER.register("crimson_crescendo", () -> new DrinkBlockItem(KDWBlocks.CRIMSON_CRESCENDO.get()));
    DeferredItem<Item> ETHEREAL_NOBLE = ITEMS_REGISTER.register("ethereal_noble", () -> new DrinkBlockItem(KDWBlocks.ETHEREAL_NOBLE.get()));
    DeferredItem<Item> WART_HENNESSY = ITEMS_REGISTER.register("wart_hennessy", () -> new DrinkBlockItem(KDWBlocks.WART_HENNESSY.get()));
    DeferredItem<Item> BLAZE_MARTELL = ITEMS_REGISTER.register("blaze_martell", () -> new DrinkBlockItem(KDWBlocks.BLAZE_MARTELL.get()));
    DeferredItem<Item> MAGMA_ROYAL_SALUTE = ITEMS_REGISTER.register("magma_royal_salute", () -> new DrinkBlockItem(KDWBlocks.MAGMA_ROYAL_SALUTE.get()));
    DeferredItem<Item> BLACK_BONE_LAFITE = ITEMS_REGISTER.register("black_bone_lafite", () -> new DrinkBlockItem(KDWBlocks.BLACK_BONE_LAFITE.get()));

    // ==================== 次元维度 - 末地 ====================
    // 作物
    DeferredItem<Item> DREAMFRUIT = ITEMS_REGISTER.register("dreamfruit", () -> new DreamfruitCropWildVineItem(new Item.Properties().food(KDWFoods.FRUITS)));

    // 物品
    DeferredItem<Item> DRAGON_BLOOD_BOTTLE = ITEMS_REGISTER.register("dragon_blood_bottle", () ->
            new DrinkableItem(new Item.Properties().food(KDWFoods.DRAGON_BLOOD_BOTTLE), new ItemStack(Items.GLASS_BOTTLE)));

    // 流体
    DeferredItem<Item> DREAMFRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("dreamfruit_juice_bucket", () ->
            new BucketItem(KDWFluids.DREAMFRUIT_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    DeferredItem<Item> DRAGON_BLOOD_BUCKET = ITEMS_REGISTER.register("dragon_blood_bucket", () ->
            new BucketItem(KDWFluids.DRAGON_BLOOD.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // 酒类
    DeferredItem<Item> CHORUS_COGNAC = ITEMS_REGISTER.register("chorus_cognac", () -> new DrinkBlockItem(KDWBlocks.CHORUS_COGNAC.get()));
    DeferredItem<Item> DRAGONS_BREATH_BRANDY = ITEMS_REGISTER.register("dragons_breath_brandy", () -> new DrinkBlockItem(KDWBlocks.DRAGONS_BREATH_BRANDY.get()));
    DeferredItem<Item> ABYSSAL_PORTER = ITEMS_REGISTER.register("abyssal_porter", () -> new DrinkBlockItem(KDWBlocks.ABYSSAL_PORTER.get()));
    DeferredItem<Item> SILENT_SHERRY = ITEMS_REGISTER.register("silent_sherry", () -> new DrinkBlockItem(KDWBlocks.SILENT_SHERRY.get()));
    DeferredItem<Item> FORGOTTEN_MARGARITA = ITEMS_REGISTER.register("forgotten_margarita", () -> new DrinkBlockItem(KDWBlocks.FORGOTTEN_MARGARITA.get()));
    DeferredItem<Item> PHANTOM_DREAM_BUBBLE = ITEMS_REGISTER.register("phantom_dream_bubble", () -> new DrinkBlockItem(KDWBlocks.PHANTOM_DREAM_BUBBLE.get()));
    DeferredItem<Item> END_STARLIGHT = ITEMS_REGISTER.register("end_starlight", () -> new DrinkBlockItem(KDWBlocks.END_STARLIGHT.get()));
    DeferredItem<Item> DIVINE_EMBRYO_PORT = ITEMS_REGISTER.register("divine_embryo_port", () -> new DrinkBlockItem(KDWBlocks.DIVINE_EMBRYO_PORT.get()));
    DeferredItem<Item> DRACONIC_BLOOD_WINE = ITEMS_REGISTER.register("draconic_blood_wine", () -> new DrinkBlockItem(KDWBlocks.DRACONIC_BLOOD_WINE.get()));

    static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
