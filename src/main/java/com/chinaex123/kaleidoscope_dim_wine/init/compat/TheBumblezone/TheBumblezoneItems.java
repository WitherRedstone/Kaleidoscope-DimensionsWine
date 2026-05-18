package com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.MeadEssence;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 蜜蜂领域联动 - 物品注册
 */
public interface TheBumblezoneItems {
    DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeDimensionsWine.MOD_ID);

    // 物品
    RegistryObject<Item> MEAD_ESSENCE = ITEMS_REGISTER.register("mead_essence", MeadEssence::new);
    RegistryObject<Item> CARBOCRETIN_POWDER = ITEMS_REGISTER.register("carbocretin_powder", () -> new Item(new Item.Properties()));
    
    // 酒类
    RegistryObject<Item> SPRITE = ITEMS_REGISTER.register("sprite", () -> new DrinkBlockItem(TheBumblezoneBlocks.SPRITE.get()));
    RegistryObject<Item> PEPSI = ITEMS_REGISTER.register("pepsi", () -> new DrinkBlockItem(TheBumblezoneBlocks.PEPSI.get()));
    RegistryObject<Item> FANTA = ITEMS_REGISTER.register("fanta", () -> new DrinkBlockItem(TheBumblezoneBlocks.FANTA.get()));
    RegistryObject<Item> POLLEN_NECTAR = ITEMS_REGISTER.register("pollen_nectar", () -> new DrinkBlockItem(TheBumblezoneBlocks.POLLEN_NECTAR.get()));
    RegistryObject<Item> HONEYTHORN_MEAD = ITEMS_REGISTER.register("honeythorn_mead", () -> new DrinkBlockItem(TheBumblezoneBlocks.HONEYTHORN_MEAD.get()));
    RegistryObject<Item> BEESWAX_HONEY_WINE = ITEMS_REGISTER.register("beeswax_honey_wine", () -> new DrinkBlockItem(TheBumblezoneBlocks.BEESWAX_HONEY_WINE.get()));
    RegistryObject<Item> SWEET_CRYSTAL_HONEY = ITEMS_REGISTER.register("sweet_crystal_honey", () -> new DrinkBlockItem(TheBumblezoneBlocks.SWEET_CRYSTAL_HONEY.get()));
    RegistryObject<Item> ROYAL_HONEY_BREW = ITEMS_REGISTER.register("royal_honey_brew", () -> new DrinkBlockItem(TheBumblezoneBlocks.ROYAL_HONEY_BREW.get()));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
