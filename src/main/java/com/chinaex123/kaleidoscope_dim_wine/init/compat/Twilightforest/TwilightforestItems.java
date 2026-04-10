package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFoods;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.FrostheartFruitItem;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;

public class TwilightforestItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 次元维度 - 暮色森林 ====================
    // -------------------- 作物 --------------------
    // 霜心果
    public static final DeferredItem<Item> FROSTHEART_FRUIT =
            ITEMS_REGISTER.register("frostheart_fruit", () -> new FrostheartFruitItem(new Item.Properties().food(ModFoods.FROSTHEART_FRUIT)));
    // -------------------- 物品 --------------------
    // 巨物碎片
    public static final DeferredItem<Item> COLOSSAL_FRAGMENT = ITEMS_REGISTER.register("colossal_fragment", () -> new Item(new Item.Properties()));
    // 哥布林精华
    public static final DeferredItem<Item> GOBLIN_ESSENCE = ITEMS_REGISTER.register("goblin_essence", () -> new Item(new Item.Properties()));
    // -------------------- 流体 --------------------
    // 火炬浆果汁桶
    public static final DeferredItem<Item> TORCHBERRIES_JUICE_BUCKET =
            ITEMS_REGISTER.register("torchberries_juice_bucket", () -> new BucketItem(TwilightforestFluids.TORCHBERRIES_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 霜心果汁桶
    public static final DeferredItem<Item> FROSTHEART_FRUIT_JUICE_BUCKET =
            ITEMS_REGISTER.register("frostheart_fruit_juice_bucket", () -> new BucketItem(TwilightforestFluids.FROSTHEART_FRUIT_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------
    // 洞窟萤火酿
    public static final DeferredHolder<Item, DrinkBlockItem> CAVE_GLOWBREW =
            ITEMS_REGISTER.register("cave_glowbrew", () -> new DrinkBlockItem(TwilightforestBlocks.CAVE_GLOWBREW.get()));
    // 林隙晨露
    public static final DeferredHolder<Item, DrinkBlockItem> DAWNLIGHT_DEW =
            ITEMS_REGISTER.register("dawnlight_dew", () -> new DrinkBlockItem(TwilightforestBlocks.DAWNLIGHT_DEW.get()));
    // 死巷之唾
    public static final DeferredHolder<Item, DrinkBlockItem> DEAD_END_SPITTLE =
            ITEMS_REGISTER.register("dead_end_spittle", () -> new DrinkBlockItem(TwilightforestBlocks.DEAD_END_SPITTLE.get()));
    // 蛇蜕利口酒
    public static final DeferredHolder<Item, DrinkBlockItem> SNAKESKIN_LIQUEUR =
            ITEMS_REGISTER.register("snakeskin_liqueur", () -> new DrinkBlockItem(TwilightforestBlocks.SNAKESKIN_LIQUEUR.get()));
    // 霜脉兽血
    public static final DeferredHolder<Item, DrinkBlockItem> FROSTVEIN_BEASTBLOOD =
            ITEMS_REGISTER.register("frostvein_beastblood", () -> new DrinkBlockItem(TwilightforestBlocks.FROSTVEIN_BEASTBLOOD.get()));
    // 巡林客的背囊
    public static final DeferredHolder<Item, DrinkBlockItem> RANGERS_SATCHEL =
            ITEMS_REGISTER.register("rangers_satchel", () -> new DrinkBlockItem(TwilightforestBlocks.RANGERS_SATCHEL.get()));
    // 烬瞳
    public static final DeferredHolder<Item, DrinkBlockItem> EMBEREYE =
            ITEMS_REGISTER.register("embereye", () -> new DrinkBlockItem(TwilightforestBlocks.EMBEREYE.get()));
    // 鹿鸣季风
    public static final DeferredHolder<Item, DrinkBlockItem> STAGCALL_MONSOON =
            ITEMS_REGISTER.register("stagcall_monsoon", () -> new DrinkBlockItem(TwilightforestBlocks.STAGCALL_MONSOON.get()));
    // 荆棘之心
    public static final DeferredHolder<Item, DrinkBlockItem> THORNHEART =
            ITEMS_REGISTER.register("thornheart", () -> new DrinkBlockItem(TwilightforestBlocks.THORNHEART.get()));
    // 德鲁伊的秘酿
    public static final DeferredHolder<Item, DrinkBlockItem> DRUIDS_SECRET_BREW =
            ITEMS_REGISTER.register("druids_secret_brew", () -> new DrinkBlockItem(TwilightforestBlocks.DRUIDS_SECRET_BREW.get()));
    // 辉夜鸟之歌
    public static final DeferredHolder<Item, DrinkBlockItem> MOORGLOW_BIRDS_SONG =
            ITEMS_REGISTER.register("moorglow_birds_song", () -> new DrinkBlockItem(TwilightforestBlocks.MOORGLOW_BIRDS_SONG.get()));
    // 终年冻土
    public static final DeferredHolder<Item, DrinkBlockItem> PERENNIAL_FROST =
            ITEMS_REGISTER.register("perennial_frost", () -> new DrinkBlockItem(TwilightforestBlocks.PERENNIAL_FROST.get()));
    // 巨人赞歌
    public static final DeferredHolder<Item, DrinkBlockItem> GIANTS_HYMN =
            ITEMS_REGISTER.register("giants_hymn", () -> new DrinkBlockItem(TwilightforestBlocks.GIANTS_HYMN.get()));
    // 地精的私藏
    public static final DeferredHolder<Item, DrinkBlockItem> GOBLINS_STASH =
            ITEMS_REGISTER.register("goblins_stash", () -> new DrinkBlockItem(TwilightforestBlocks.GOBLINS_STASH.get()));

    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
