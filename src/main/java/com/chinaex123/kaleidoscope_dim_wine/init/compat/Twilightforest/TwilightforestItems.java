package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFoods;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.FrostheartFruitItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.JuiceBucketItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

/**
 * 暮色森林联动 - 物品注册
 */
public class TwilightforestItems {
    public static final DeferredRegister<Item> ITEMS_REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 作物 --------------------
    // 霜心果
    public static final RegistryObject<Item> FROSTHEART_FRUIT = ITEMS_REGISTER.register("frostheart_fruit", () ->
            new FrostheartFruitItem(new Item.Properties().food(ModFoods.FROSTHEART_FRUIT)));
    // -------------------- 物品 --------------------
    // 巨物碎片
    public static final RegistryObject<Item> COLOSSAL_FRAGMENT = ITEMS_REGISTER.register("colossal_fragment", () -> new Item(new Item.Properties()));
    // 哥布林精华
    public static final RegistryObject<Item> GOBLIN_ESSENCE = ITEMS_REGISTER.register("goblin_essence", () -> new Item(new Item.Properties()));
    // -------------------- 流体 --------------------
    // 火炬浆果汁桶
    public static final RegistryObject<Item> TORCHBERRIES_JUICE_BUCKET = ITEMS_REGISTER.register("torchberries_juice_bucket", () ->
            new JuiceBucketItem(TwilightforestFluids.TORCHBERRIES_JUICE));
    // 霜心果汁桶
    public static final RegistryObject<Item> FROSTHEART_FRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("frostheart_fruit_juice_bucket", () ->
            new JuiceBucketItem(TwilightforestFluids.FROSTHEART_FRUIT_JUICE));
    // -------------------- 酒类 --------------------
    // 洞窟萤火酿
    public static final RegistryObject<Item> CAVE_GLOWBREW = ITEMS_REGISTER.register("cave_glowbrew", () ->
            new DrinkBlockItem(TwilightforestBlocks.CAVE_GLOWBREW.get()));
    // 林隙晨露
    public static final RegistryObject<Item> DAWNLIGHT_DEW = ITEMS_REGISTER.register("dawnlight_dew", () ->
            new DrinkBlockItem(TwilightforestBlocks.DAWNLIGHT_DEW.get()));
    // 死巷之唾
    public static final RegistryObject<Item> DEAD_END_SPITTLE = ITEMS_REGISTER.register("dead_end_spittle", () ->
            new DrinkBlockItem(TwilightforestBlocks.DEAD_END_SPITTLE.get()));
    // 蛇蜕利口酒
    public static final RegistryObject<Item> SNAKESKIN_LIQUEUR = ITEMS_REGISTER.register("snakeskin_liqueur", () ->
            new DrinkBlockItem(TwilightforestBlocks.SNAKESKIN_LIQUEUR.get()));
    // 霜脉兽血
    public static final RegistryObject<Item> FROSTVEIN_BEASTBLOOD = ITEMS_REGISTER.register("frostvein_beastblood", () ->
            new DrinkBlockItem(TwilightforestBlocks.FROSTVEIN_BEASTBLOOD.get()));
    // 巡林客的背囊
    public static final RegistryObject<Item> RANGERS_SATCHEL = ITEMS_REGISTER.register("rangers_satchel", () ->
            new DrinkBlockItem(TwilightforestBlocks.RANGERS_SATCHEL.get()));
    // 烬瞳
    public static final RegistryObject<Item> EMBEREYE = ITEMS_REGISTER.register("embereye", () ->
            new DrinkBlockItem(TwilightforestBlocks.EMBEREYE.get()));
    // 鹿鸣季风
    public static final RegistryObject<Item> STAGCALL_MONSOON = ITEMS_REGISTER.register("stagcall_monsoon", () ->
            new DrinkBlockItem(TwilightforestBlocks.STAGCALL_MONSOON.get()));
    // 荆棘之心
    public static final RegistryObject<Item> THORNHEART = ITEMS_REGISTER.register("thornheart", () ->
            new DrinkBlockItem(TwilightforestBlocks.THORNHEART.get()));
    // 德鲁伊的秘酿
    public static final RegistryObject<Item> DRUIDS_SECRET_BREW = ITEMS_REGISTER.register("druids_secret_brew", () ->
            new DrinkBlockItem(TwilightforestBlocks.DRUIDS_SECRET_BREW.get()));
    // 辉夜鸟之歌
    public static final RegistryObject<Item> MOORGLOW_BIRDS_SONG = ITEMS_REGISTER.register("moorglow_birds_song", () ->
            new DrinkBlockItem(TwilightforestBlocks.MOORGLOW_BIRDS_SONG.get()));
    // 终年冻土
    public static final RegistryObject<Item> PERENNIAL_FROST = ITEMS_REGISTER.register("perennial_frost", () ->
            new DrinkBlockItem(TwilightforestBlocks.PERENNIAL_FROST.get()));
    // 巨人赞歌
    public static final RegistryObject<Item> GIANTS_HYMN = ITEMS_REGISTER.register("giants_hymn", () ->
            new DrinkBlockItem(TwilightforestBlocks.GIANTS_HYMN.get()));
    // 地精的私藏
    public static final RegistryObject<Item> GOBLINS_STASH = ITEMS_REGISTER.register("goblins_stash", () ->
            new DrinkBlockItem(TwilightforestBlocks.GOBLINS_STASH.get()));

    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
