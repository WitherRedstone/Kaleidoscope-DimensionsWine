package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.compat.Twilightforest.FrostheartFruit.FrostheartFruitBushBlock;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 暮色森林联动 - 方块注册
 */
public class TwilightforestBlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 作物 --------------------
    // 霜心果丛 - 类似甜浆果种下后的方块
    public static final RegistryObject<Block> FROSTHEART_FRUIT_BUSH = BLOCK_REGISTER.register("frostheart_fruit_bush", FrostheartFruitBushBlock::new);
    // -------------------- 酒类 --------------------
    // 洞窟萤火酿
    public static final RegistryObject<Block> CAVE_GLOWBREW = BLOCK_REGISTER.register("cave_glowbrew", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 林隙晨露
    public static final RegistryObject<Block> DAWNLIGHT_DEW = BLOCK_REGISTER.register("dawnlight_dew", () ->
            DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 死巷之唾
    public static final RegistryObject<Block> DEAD_END_SPITTLE = BLOCK_REGISTER.register("dead_end_spittle", () ->
            DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 蛇蜕利口酒
    public static final RegistryObject<Block> SNAKESKIN_LIQUEUR = BLOCK_REGISTER.register("snakeskin_liqueur", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 霜脉兽血
    public static final RegistryObject<Block> FROSTVEIN_BEASTBLOOD = BLOCK_REGISTER.register("frostvein_beastblood", () ->
            DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 巡林客的背囊
    public static final RegistryObject<Block> RANGERS_SATCHEL = BLOCK_REGISTER.register("rangers_satchel", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 烬瞳
    public static final RegistryObject<Block> EMBEREYE = BLOCK_REGISTER.register("embereye", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 鹿鸣季风
    public static final RegistryObject<Block> STAGCALL_MONSOON = BLOCK_REGISTER.register("stagcall_monsoon", () ->
            DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 荆棘之心
    public static final RegistryObject<Block> THORNHEART = BLOCK_REGISTER.register("thornheart", () ->
            DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 德鲁伊的秘酿
    public static final RegistryObject<Block> DRUIDS_SECRET_BREW = BLOCK_REGISTER.register("druids_secret_brew", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 辉夜鸟之歌
    public static final RegistryObject<Block> MOORGLOW_BIRDS_SONG = BLOCK_REGISTER.register("moorglow_birds_song", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 终年冻土
    public static final RegistryObject<Block> PERENNIAL_FROST = BLOCK_REGISTER.register("perennial_frost", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 巨人赞歌
    public static final RegistryObject<Block> GIANTS_HYMN = BLOCK_REGISTER.register("giants_hymn", () ->
            DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 地精的私藏
    public static final RegistryObject<Block> GOBLINS_STASH = BLOCK_REGISTER.register("goblins_stash", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
