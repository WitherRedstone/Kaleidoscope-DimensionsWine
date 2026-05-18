package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.compat.Twilightforest.FrostheartFruit.FrostheartFruitBushBlock;
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
public interface TwilightforestBlocks {
    DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeDimensionsWine.MOD_ID);

    // 作物
    RegistryObject<Block> FROSTHEART_FRUIT_BUSH = BLOCK_REGISTER.register("frostheart_fruit_bush", FrostheartFruitBushBlock::new);

    // 酒类
    RegistryObject<Block> CAVE_GLOWBREW = BLOCK_REGISTER.register("cave_glowbrew", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DAWNLIGHT_DEW = BLOCK_REGISTER.register("dawnlight_dew", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DEAD_END_SPITTLE = BLOCK_REGISTER.register("dead_end_spittle", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> SNAKESKIN_LIQUEUR = BLOCK_REGISTER.register("snakeskin_liqueur", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> FROSTVEIN_BEASTBLOOD = BLOCK_REGISTER.register("frostvein_beastblood", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> RANGERS_SATCHEL = BLOCK_REGISTER.register("rangers_satchel", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> EMBEREYE = BLOCK_REGISTER.register("embereye", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> STAGCALL_MONSOON = BLOCK_REGISTER.register("stagcall_monsoon", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> THORNHEART = BLOCK_REGISTER.register("thornheart", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DRUIDS_SECRET_BREW = BLOCK_REGISTER.register("druids_secret_brew", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> MOORGLOW_BIRDS_SONG = BLOCK_REGISTER.register("moorglow_birds_song", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> PERENNIAL_FROST = BLOCK_REGISTER.register("perennial_frost", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> GIANTS_HYMN = BLOCK_REGISTER.register("giants_hymn", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> GOBLINS_STASH = BLOCK_REGISTER.register("goblins_stash", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());

    static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
