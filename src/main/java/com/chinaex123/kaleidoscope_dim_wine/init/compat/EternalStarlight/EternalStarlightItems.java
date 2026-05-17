package com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 永恒星光联动 - 物品注册
 */
public class EternalStarlightItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 流体 --------------------
    // 月辉浆果汁桶
    public static final DeferredItem<Item> LUNAR_BERRIES_JUICE_BUCKET = ITEMS_REGISTER.register("lunar_berries_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 渊海果汁桶
    public static final DeferredItem<Item> ABYSSAL_FRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("abyssal_fruit_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 银辛果汁桶
    public static final DeferredItem<Item> SILVER_PUNGENCY_FRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("silver_pungency_fruit_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // -------------------- 酒类 --------------------
    // 神圣裁决
    public static final DeferredItem<Item> DIVINITY = ITEMS_REGISTER.register("divinity", () ->
            new DrinkBlockItem(EternalStarlightBlocks.DIVINITY.get()));
    // 星轨
    public static final DeferredItem<Item> STAR_TRAIL = ITEMS_REGISTER.register("star_trail", () ->
            new DrinkBlockItem(EternalStarlightBlocks.STAR_TRAIL.get()));
    // 极光
    public static final DeferredItem<Item> AURORA = ITEMS_REGISTER.register("aurora", () ->
            new DrinkBlockItem(EternalStarlightBlocks.AURORA.get()));
    // 日蚀
    public static final DeferredItem<Item> ECLIPSE = ITEMS_REGISTER.register("eclipse", () ->
            new DrinkBlockItem(EternalStarlightBlocks.ECLIPSE.get()));
    // 月蚀
    public static final DeferredItem<Item> LUNAR_ECLIPSE = ITEMS_REGISTER.register("lunar_eclipse", () ->
            new DrinkBlockItem(EternalStarlightBlocks.LUNAR_ECLIPSE.get()));
    // 深寒
    public static final DeferredItem<Item> DEEP_FREEZE = ITEMS_REGISTER.register("deep_freeze", () ->
            new DrinkBlockItem(EternalStarlightBlocks.DEEP_FREEZE.get()));
    // 血月
    public static final DeferredItem<Item> BLOOD_MOON = ITEMS_REGISTER.register("blood_moon", () ->
            new DrinkBlockItem(EternalStarlightBlocks.BLOOD_MOON.get()));
    // 深渊
    public static final DeferredItem<Item> ABYSS = ITEMS_REGISTER.register("abyss", () ->
            new DrinkBlockItem(EternalStarlightBlocks.ABYSS.get()));
    // 烈阳
    public static final DeferredItem<Item> BLAZING_SUN = ITEMS_REGISTER.register("blazing_sun", () ->
            new DrinkBlockItem(EternalStarlightBlocks.BLAZING_SUN.get()));
    // 风痕
    public static final DeferredItem<Item> WIND_TRACE = ITEMS_REGISTER.register("wind_trace", () ->
            new DrinkBlockItem(EternalStarlightBlocks.WIND_TRACE.get()));

    public static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
