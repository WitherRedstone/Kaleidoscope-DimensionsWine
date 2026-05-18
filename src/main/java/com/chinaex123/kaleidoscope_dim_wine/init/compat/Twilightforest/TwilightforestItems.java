package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFoods;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.compat.Twilightforest.FrostheartFruitItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.chinaex123.kaleidoscope_dim_wine.init.KDWItems.registerFluidBucket;

/**
 * 暮色森林联动 - 物品注册
 */
public interface TwilightforestItems {
    DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // 作物
    DeferredItem<Item> FROSTHEART_FRUIT = ITEMS_REGISTER.register("frostheart_fruit", () -> new FrostheartFruitItem(new Item.Properties().food(KDWFoods.FRUITS)));
    
    // 物品
    DeferredItem<Item> COLOSSAL_FRAGMENT = ITEMS_REGISTER.register("colossal_fragment", () -> new Item(new Item.Properties()));
    DeferredItem<Item> GOBLIN_ESSENCE = ITEMS_REGISTER.register("goblin_essence", () -> new Item(new Item.Properties()));

    // 流体
    DeferredItem<Item> TORCHBERRIES_JUICE_BUCKET = registerFluidBucket("torchberries_juice_bucket", TwilightforestFluids.TORCHBERRIES_JUICE);
    DeferredItem<Item> FROSTHEART_FRUIT_JUICE_BUCKET = registerFluidBucket("frostheart_fruit_juice_bucket", TwilightforestFluids.FROSTHEART_FRUIT_JUICE);

    // 酒类
    DeferredItem<Item> CAVE_GLOWBREW = ITEMS_REGISTER.register("cave_glowbrew", () -> new DrinkBlockItem(TwilightforestBlocks.CAVE_GLOWBREW.get()));
    DeferredItem<Item> DAWNLIGHT_DEW = ITEMS_REGISTER.register("dawnlight_dew", () -> new DrinkBlockItem(TwilightforestBlocks.DAWNLIGHT_DEW.get()));
    DeferredItem<Item> DEAD_END_SPITTLE = ITEMS_REGISTER.register("dead_end_spittle", () -> new DrinkBlockItem(TwilightforestBlocks.DEAD_END_SPITTLE.get()));
    DeferredItem<Item> SNAKESKIN_LIQUEUR = ITEMS_REGISTER.register("snakeskin_liqueur", () -> new DrinkBlockItem(TwilightforestBlocks.SNAKESKIN_LIQUEUR.get()));
    DeferredItem<Item> FROSTVEIN_BEASTBLOOD = ITEMS_REGISTER.register("frostvein_beastblood", () -> new DrinkBlockItem(TwilightforestBlocks.FROSTVEIN_BEASTBLOOD.get()));
    DeferredItem<Item> RANGERS_SATCHEL = ITEMS_REGISTER.register("rangers_satchel", () -> new DrinkBlockItem(TwilightforestBlocks.RANGERS_SATCHEL.get()));
    DeferredItem<Item> EMBEREYE = ITEMS_REGISTER.register("embereye", () -> new DrinkBlockItem(TwilightforestBlocks.EMBEREYE.get()));
    DeferredItem<Item> STAGCALL_MONSOON = ITEMS_REGISTER.register("stagcall_monsoon", () -> new DrinkBlockItem(TwilightforestBlocks.STAGCALL_MONSOON.get()));
    DeferredItem<Item> THORNHEART = ITEMS_REGISTER.register("thornheart", () -> new DrinkBlockItem(TwilightforestBlocks.THORNHEART.get()));
    DeferredItem<Item> DRUIDS_SECRET_BREW = ITEMS_REGISTER.register("druids_secret_brew", () -> new DrinkBlockItem(TwilightforestBlocks.DRUIDS_SECRET_BREW.get()));
    DeferredItem<Item> MOORGLOW_BIRDS_SONG = ITEMS_REGISTER.register("moorglow_birds_song", () -> new DrinkBlockItem(TwilightforestBlocks.MOORGLOW_BIRDS_SONG.get()));
    DeferredItem<Item> PERENNIAL_FROST = ITEMS_REGISTER.register("perennial_frost", () -> new DrinkBlockItem(TwilightforestBlocks.PERENNIAL_FROST.get()));
    DeferredItem<Item> GIANTS_HYMN = ITEMS_REGISTER.register("giants_hymn", () -> new DrinkBlockItem(TwilightforestBlocks.GIANTS_HYMN.get()));
    DeferredItem<Item> GOBLINS_STASH = ITEMS_REGISTER.register("goblins_stash", () -> new DrinkBlockItem(TwilightforestBlocks.GOBLINS_STASH.get()));

    static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
