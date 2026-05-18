package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluids;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.chinaex123.kaleidoscope_dim_wine.init.KDWItems.registerFluidBucket;

/**
 * 天境联动 - 物品注册
 */
public interface AetherItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // 流体
    DeferredItem<Item> ENCHANTED_BERRY_JUICE_BUCKET = registerFluidBucket("enchanted_berry_juice_bucket", AetherFluids.ENCHANTED_BERRY_JUICE);

    // 酒类
    DeferredItem<Item> DIVINE_OFFERING_BREW = ITEMS_REGISTER.register("divine_offering_brew", () -> new DrinkBlockItem(AetherBlocks.DIVINE_OFFERING_BREW.get()));
    DeferredItem<Item> DIVINE_ENERGY_MIST = ITEMS_REGISTER.register("divine_energy_mist", () -> new DrinkBlockItem(AetherBlocks.DIVINE_ENERGY_MIST.get()));
    DeferredItem<Item> SWET_FIZZ = ITEMS_REGISTER.register("swet_fizz", () -> new DrinkBlockItem(AetherBlocks.SWET_FIZZ.get()));
    DeferredItem<Item> GRAVITITE_DRUNK = ITEMS_REGISTER.register("gravitite_drunk", () -> new DrinkBlockItem(AetherBlocks.GRAVITITE_DRUNK.get()));
    DeferredItem<Item> HEALING_ELIXIR = ITEMS_REGISTER.register("healing_elixir", () -> new DrinkBlockItem(AetherBlocks.HEALING_ELIXIR.get()));
    DeferredItem<Item> GINGERBREAD_WARMER = ITEMS_REGISTER.register("gingerbread_warmer", () -> new DrinkBlockItem(AetherBlocks.GINGERBREAD_WARMER.get()));
    DeferredItem<Item> UNBOUND_SKYBORN = ITEMS_REGISTER.register("unbound_skyborn", () -> new DrinkBlockItem(AetherBlocks.UNBOUND_SKYBORN.get()));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
