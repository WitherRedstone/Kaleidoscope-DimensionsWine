package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.compat.Twilightforest.FrostheartFruit.FrostheartFruitBushBlock;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 暮色森林联动 - 方块注册
 */
public interface TwilightforestBlocks {
    DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // 作物
    DeferredBlock<Block> FROSTHEART_FRUIT_BUSH = BLOCK_REGISTER.register("frostheart_fruit_bush", FrostheartFruitBushBlock::new);
    
    // 酒类
    DeferredHolder<Block, Block> CAVE_GLOWBREW = BLOCK_REGISTER.register("cave_glowbrew", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> DAWNLIGHT_DEW = BLOCK_REGISTER.register("dawnlight_dew", () -> DrinkBlock.create().maxCount(2).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> DEAD_END_SPITTLE = BLOCK_REGISTER.register("dead_end_spittle", () -> DrinkBlock.create().maxCount(2).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> SNAKESKIN_LIQUEUR = BLOCK_REGISTER.register("snakeskin_liqueur", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> FROSTVEIN_BEASTBLOOD = BLOCK_REGISTER.register("frostvein_beastblood", () -> DrinkBlock.create().maxCount(2).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> RANGERS_SATCHEL = BLOCK_REGISTER.register("rangers_satchel", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> EMBEREYE = BLOCK_REGISTER.register("embereye", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> STAGCALL_MONSOON = BLOCK_REGISTER.register("stagcall_monsoon", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> THORNHEART = BLOCK_REGISTER.register("thornheart", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> DRUIDS_SECRET_BREW = BLOCK_REGISTER.register("druids_secret_brew", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> MOORGLOW_BIRDS_SONG = BLOCK_REGISTER.register("moorglow_birds_song", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> PERENNIAL_FROST = BLOCK_REGISTER.register("perennial_frost", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> GIANTS_HYMN = BLOCK_REGISTER.register("giants_hymn", () -> DrinkBlock.create().maxCount(2).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    DeferredHolder<Block, Block> GOBLINS_STASH = BLOCK_REGISTER.register("goblins_stash", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());

    static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
