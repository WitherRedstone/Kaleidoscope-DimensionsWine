package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 天境联动 - 方块注册
 */
public interface AetherBlocks {
    DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // 酒类
    DeferredHolder<Block, Block> DIVINE_OFFERING_BREW = BLOCK_REGISTER.register("divine_offering_brew", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> DIVINE_ENERGY_MIST = BLOCK_REGISTER.register("divine_energy_mist", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> SWET_FIZZ = BLOCK_REGISTER.register("swet_fizz", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> GRAVITITE_DRUNK = BLOCK_REGISTER.register("gravitite_drunk", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> HEALING_ELIXIR = BLOCK_REGISTER.register("healing_elixir", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> GINGERBREAD_WARMER = BLOCK_REGISTER.register("gingerbread_warmer", () -> DrinkBlock.create().maxCount(2).irregular().shapes(DrinkShapes.getShortBottleShapes()).build().get());
    DeferredHolder<Block, Block> UNBOUND_SKYBORN = BLOCK_REGISTER.register("unbound_skyborn", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());

    static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
