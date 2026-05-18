package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFoods;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.FrostheartFruitItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.chinaex123.kaleidoscope_dim_wine.init.KDWItems.registerFluidBucket;

/**
 * 暮色森林联动 - 物品注册
 */
public interface TwilightforestItems {
    DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeDimensionsWine.MOD_ID);

    // 作物
    RegistryObject<Item> FROSTHEART_FRUIT = ITEMS_REGISTER.register("frostheart_fruit", () -> new FrostheartFruitItem(new Item.Properties().food(KDWFoods.FRUITS)));

    // 物品
    RegistryObject<Item> COLOSSAL_FRAGMENT = ITEMS_REGISTER.register("colossal_fragment", () -> new Item(new Item.Properties()));
    RegistryObject<Item> GOBLIN_ESSENCE = ITEMS_REGISTER.register("goblin_essence", () -> new Item(new Item.Properties()));

    // 流体
    RegistryObject<Item> TORCHBERRIES_JUICE_BUCKET = registerFluidBucket("torchberries_juice_bucket", TwilightforestFluids.TORCHBERRIES_JUICE);
    RegistryObject<Item> FROSTHEART_FRUIT_JUICE_BUCKET = registerFluidBucket("frostheart_fruit_juice_bucket", TwilightforestFluids.FROSTHEART_FRUIT_JUICE);

    // 酒类
    RegistryObject<Item> CAVE_GLOWBREW = ITEMS_REGISTER.register("cave_glowbrew", () -> new DrinkBlockItem(TwilightforestBlocks.CAVE_GLOWBREW.get()));
    RegistryObject<Item> DAWNLIGHT_DEW = ITEMS_REGISTER.register("dawnlight_dew", () -> new DrinkBlockItem(TwilightforestBlocks.DAWNLIGHT_DEW.get()));
    RegistryObject<Item> DEAD_END_SPITTLE = ITEMS_REGISTER.register("dead_end_spittle", () -> new DrinkBlockItem(TwilightforestBlocks.DEAD_END_SPITTLE.get()));
    RegistryObject<Item> SNAKESKIN_LIQUEUR = ITEMS_REGISTER.register("snakeskin_liqueur", () -> new DrinkBlockItem(TwilightforestBlocks.SNAKESKIN_LIQUEUR.get()));
    RegistryObject<Item> FROSTVEIN_BEASTBLOOD = ITEMS_REGISTER.register("frostvein_beastblood", () -> new DrinkBlockItem(TwilightforestBlocks.FROSTVEIN_BEASTBLOOD.get()));
    RegistryObject<Item> RANGERS_SATCHEL = ITEMS_REGISTER.register("rangers_satchel", () -> new DrinkBlockItem(TwilightforestBlocks.RANGERS_SATCHEL.get()));
    RegistryObject<Item> EMBEREYE = ITEMS_REGISTER.register("embereye", () -> new DrinkBlockItem(TwilightforestBlocks.EMBEREYE.get()));
    RegistryObject<Item> STAGCALL_MONSOON = ITEMS_REGISTER.register("stagcall_monsoon", () -> new DrinkBlockItem(TwilightforestBlocks.STAGCALL_MONSOON.get()));
    RegistryObject<Item> THORNHEART = ITEMS_REGISTER.register("thornheart", () -> new DrinkBlockItem(TwilightforestBlocks.THORNHEART.get()));
    RegistryObject<Item> DRUIDS_SECRET_BREW = ITEMS_REGISTER.register("druids_secret_brew", () -> new DrinkBlockItem(TwilightforestBlocks.DRUIDS_SECRET_BREW.get()));
    RegistryObject<Item> MOORGLOW_BIRDS_SONG = ITEMS_REGISTER.register("moorglow_birds_song", () -> new DrinkBlockItem(TwilightforestBlocks.MOORGLOW_BIRDS_SONG.get()));
    RegistryObject<Item> PERENNIAL_FROST = ITEMS_REGISTER.register("perennial_frost", () -> new DrinkBlockItem(TwilightforestBlocks.PERENNIAL_FROST.get()));
    RegistryObject<Item> GIANTS_HYMN = ITEMS_REGISTER.register("giants_hymn", () -> new DrinkBlockItem(TwilightforestBlocks.GIANTS_HYMN.get()));
    RegistryObject<Item> GOBLINS_STASH = ITEMS_REGISTER.register("goblins_stash", () -> new DrinkBlockItem(TwilightforestBlocks.GOBLINS_STASH.get()));

    static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
