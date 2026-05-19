package com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluids;
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
public interface EternalStarlightItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // 流体
    DeferredItem<Item> LUNAR_BERRIES_JUICE_BUCKET = ITEMS_REGISTER.register("lunar_berries_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    DeferredItem<Item> ABYSSAL_FRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("abyssal_fruit_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    DeferredItem<Item> SILVER_PUNGENCY_FRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("silver_pungency_fruit_juice_bucket", () ->
            new BucketItem(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // 酒类
    DeferredItem<Item> DIVINITY = ITEMS_REGISTER.register("divinity", () -> new DrinkBlockItem(EternalStarlightBlocks.DIVINITY.get()));
    DeferredItem<Item> STAR_TRAIL = ITEMS_REGISTER.register("star_trail", () -> new DrinkBlockItem(EternalStarlightBlocks.STAR_TRAIL.get()));
    DeferredItem<Item> AURORA = ITEMS_REGISTER.register("aurora", () -> new DrinkBlockItem(EternalStarlightBlocks.AURORA.get()));
    DeferredItem<Item> ECLIPSE = ITEMS_REGISTER.register("eclipse", () -> new DrinkBlockItem(EternalStarlightBlocks.ECLIPSE.get()));
    DeferredItem<Item> LUNAR_ECLIPSE = ITEMS_REGISTER.register("lunar_eclipse", () -> new DrinkBlockItem(EternalStarlightBlocks.LUNAR_ECLIPSE.get()));
    DeferredItem<Item> DEEP_FREEZE = ITEMS_REGISTER.register("deep_freeze", () -> new DrinkBlockItem(EternalStarlightBlocks.DEEP_FREEZE.get()));
    DeferredItem<Item> BLOOD_MOON = ITEMS_REGISTER.register("blood_moon", () -> new DrinkBlockItem(EternalStarlightBlocks.BLOOD_MOON.get()));
    DeferredItem<Item> ABYSS = ITEMS_REGISTER.register("abyss", () -> new DrinkBlockItem(EternalStarlightBlocks.ABYSS.get()));
    DeferredItem<Item> BLAZING_SUN = ITEMS_REGISTER.register("blazing_sun", () -> new DrinkBlockItem(EternalStarlightBlocks.BLAZING_SUN.get()));
    DeferredItem<Item> WIND_TRACE = ITEMS_REGISTER.register("wind_trace", () -> new DrinkBlockItem(EternalStarlightBlocks.WIND_TRACE.get()));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
