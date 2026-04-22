package com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 蜜蜂领域联动 - 方块注册
 */
public class TheBumblezoneBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTER =
            DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 酒类 --------------------
    // 雪碧
    public static final DeferredHolder<Block, Block> SPRITE = BLOCK_REGISTER.register("sprite", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 可乐
    public static final DeferredHolder<Block, Block> PEPSI = BLOCK_REGISTER.register("pepsi", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 芬达
    public static final DeferredHolder<Block, Block> FANTA = BLOCK_REGISTER.register("fanta", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 花粉甜酿
    public static final DeferredHolder<Block, Block> POLLEN_NECTAR = BLOCK_REGISTER.register("pollen_nectar", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜜刺佳酿
    public static final DeferredHolder<Block, Block> HONEYTHORN_MEAD = BLOCK_REGISTER.register("honeythorn_mead", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜂蜡陈酿
    public static final DeferredHolder<Block, Block> BEESWAX_HONEY_WINE = BLOCK_REGISTER.register("beeswax_honey_wine", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 甜蜜水晶
    public static final DeferredHolder<Block, Block> SWEET_CRYSTAL_HONEY = BLOCK_REGISTER.register("sweet_crystal_honey", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜂王特酿
    public static final DeferredHolder<Block, Block> ROYAL_HONEY_BREW = BLOCK_REGISTER.register("royal_honey_brew", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
