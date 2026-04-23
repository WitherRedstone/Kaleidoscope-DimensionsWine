package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/**
 * 天境联动 - 物品注册
 */
public class AetherItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 物品 --------------------
    // 神饯蓝莓汁桶
    public static final DeferredItem<Item> ENCHANTED_BERRY_JUICE_BUCKET = ITEMS_REGISTER.register("enchanted_berry_juice_bucket", () ->
            new BucketItem(AetherFluids.ENCHANTED_BERRY_JUICE.get(), new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------
    // 神饯紫晶酿
    public static final DeferredHolder<Item, DrinkBlockItem> DIVINE_OFFERING_BREW = ITEMS_REGISTER.register("divine_offering_brew", () ->
            new DrinkBlockItem(AetherBlocks.DIVINE_OFFERING_BREW.get()));
    // 神能迷雾
    public static final DeferredHolder<Item, DrinkBlockItem> DIVINE_ENERGY_MIST = ITEMS_REGISTER.register("divine_energy_mist", () ->
            new DrinkBlockItem(AetherBlocks.DIVINE_ENERGY_MIST.get()));
    // 史维特菲士
    public static final DeferredHolder<Item, DrinkBlockItem> SWET_FIZZ = ITEMS_REGISTER.register("swet_fizz", () ->
            new DrinkBlockItem(AetherBlocks.SWET_FIZZ.get()));
    // 重力醉
    public static final DeferredHolder<Item, DrinkBlockItem> GRAVITITE_DRUNK = ITEMS_REGISTER.register("gravitite_drunk", () ->
            new DrinkBlockItem(AetherBlocks.GRAVITITE_DRUNK.get()));
    // 治愈灵药
    public static final DeferredHolder<Item, DrinkBlockItem> HEALING_ELIXIR = ITEMS_REGISTER.register("healing_elixir", () ->
            new DrinkBlockItem(AetherBlocks.HEALING_ELIXIR.get()));
    // 姜饼暖饮
    public static final DeferredHolder<Item, DrinkBlockItem> GINGERBREAD_WARMER = ITEMS_REGISTER.register("gingerbread_warmer", () ->
            new DrinkBlockItem(AetherBlocks.GINGERBREAD_WARMER.get()));
    // 无界苍穹
    public static final DeferredHolder<Item, DrinkBlockItem> UNBOUND_SKYBORN = ITEMS_REGISTER.register("unbound_skyborn", () ->
            new DrinkBlockItem(AetherBlocks.UNBOUND_SKYBORN.get()));

    public static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
