package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 天境联动 - 物品注册
 */
public interface AetherItems {
    DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeDimensionsWine.MOD_ID);

    // 流体
    RegistryObject<Item> ENCHANTED_BERRY_JUICE_BUCKET = ITEMS_REGISTER.register("enchanted_berry_juice_bucket", () ->
            new BucketItem(AetherFluids.ENCHANTED_BERRY_JUICE, new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // 神饯紫晶酿
    RegistryObject<Item> DIVINE_OFFERING_BREW = ITEMS_REGISTER.register("divine_offering_brew", () -> new DrinkBlockItem(AetherBlocks.DIVINE_OFFERING_BREW.get()));
    RegistryObject<Item> DIVINE_ENERGY_MIST = ITEMS_REGISTER.register("divine_energy_mist", () -> new DrinkBlockItem(AetherBlocks.DIVINE_ENERGY_MIST.get()));
    RegistryObject<Item> SWET_FIZZ = ITEMS_REGISTER.register("swet_fizz", () -> new DrinkBlockItem(AetherBlocks.SWET_FIZZ.get()));
    RegistryObject<Item> GRAVITITE_DRUNK = ITEMS_REGISTER.register("gravitite_drunk", () -> new DrinkBlockItem(AetherBlocks.GRAVITITE_DRUNK.get()));
    RegistryObject<Item> HEALING_ELIXIR = ITEMS_REGISTER.register("healing_elixir", () -> new DrinkBlockItem(AetherBlocks.HEALING_ELIXIR.get()));
    RegistryObject<Item> GINGERBREAD_WARMER = ITEMS_REGISTER.register("gingerbread_warmer", () -> new DrinkBlockItem(AetherBlocks.GINGERBREAD_WARMER.get()));
    RegistryObject<Item> UNBOUND_SKYBORN = ITEMS_REGISTER.register("unbound_skyborn", () -> new DrinkBlockItem(AetherBlocks.UNBOUND_SKYBORN.get()));

    static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}
