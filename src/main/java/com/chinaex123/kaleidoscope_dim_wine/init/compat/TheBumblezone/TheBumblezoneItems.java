package com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.MeadEssence;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 蜜蜂领域联动 - 物品注册
 */
public interface TheBumblezoneItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // 物品
    DeferredItem<Item> MEAD_ESSENCE = ITEMS_REGISTER.register("mead_essence", MeadEssence::new);
    DeferredItem<Item> CARBOCRETIN_POWDER = ITEMS_REGISTER.register("carbocretin_powder", () -> new Item(new Item.Properties()));

    // 酒类
    DeferredItem<Item> SPRITE = ITEMS_REGISTER.register("sprite", () -> new DrinkBlockItem(TheBumblezoneBlocks.SPRITE.get()));
    DeferredItem<Item> PEPSI = ITEMS_REGISTER.register("pepsi", () -> new DrinkBlockItem(TheBumblezoneBlocks.PEPSI.get()));
    DeferredItem<Item> FANTA = ITEMS_REGISTER.register("fanta", () -> new DrinkBlockItem(TheBumblezoneBlocks.FANTA.get()));
    DeferredItem<Item> POLLEN_NECTAR = ITEMS_REGISTER.register("pollen_nectar", () -> new DrinkBlockItem(TheBumblezoneBlocks.POLLEN_NECTAR.get()));
    DeferredItem<Item> HONEYTHORN_MEAD = ITEMS_REGISTER.register("honeythorn_mead", () -> new DrinkBlockItem(TheBumblezoneBlocks.HONEYTHORN_MEAD.get()));
    DeferredItem<Item> BEESWAX_HONEY_WINE = ITEMS_REGISTER.register("beeswax_honey_wine", () -> new DrinkBlockItem(TheBumblezoneBlocks.BEESWAX_HONEY_WINE.get()));
    DeferredItem<Item> SWEET_CRYSTAL_HONEY = ITEMS_REGISTER.register("sweet_crystal_honey", () -> new DrinkBlockItem(TheBumblezoneBlocks.SWEET_CRYSTAL_HONEY.get()));
    DeferredItem<Item> ROYAL_HONEY_BREW = ITEMS_REGISTER.register("royal_honey_brew", () -> new DrinkBlockItem(TheBumblezoneBlocks.ROYAL_HONEY_BREW.get()));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
