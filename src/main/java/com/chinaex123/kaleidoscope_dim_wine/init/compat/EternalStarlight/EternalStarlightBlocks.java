package com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 永恒星光联动 - 方块注册
 */
public interface EternalStarlightBlocks {
    DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // 酒类
    DeferredHolder<Block, Block> DIVINITY = BLOCK_REGISTER.register("divinity", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> STAR_TRAIL = BLOCK_REGISTER.register("star_trail", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> AURORA = BLOCK_REGISTER.register("aurora", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> ECLIPSE = BLOCK_REGISTER.register("eclipse", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> LUNAR_ECLIPSE = BLOCK_REGISTER.register("lunar_eclipse", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> DEEP_FREEZE = BLOCK_REGISTER.register("deep_freeze", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> BLOOD_MOON = BLOCK_REGISTER.register("blood_moon", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> ABYSS = BLOCK_REGISTER.register("abyss", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> BLAZING_SUN = BLOCK_REGISTER.register("blazing_sun", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> WIND_TRACE = BLOCK_REGISTER.register("wind_trace", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());

    static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
