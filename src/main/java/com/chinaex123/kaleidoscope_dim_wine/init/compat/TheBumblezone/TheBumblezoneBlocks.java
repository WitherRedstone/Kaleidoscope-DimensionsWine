package com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 蜜蜂领域联动 - 方块注册
 */
public class TheBumblezoneBlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 酒类 --------------------
    // 雪碧
    public static final RegistryObject<Block> SPRITE = BLOCK_REGISTER.register("sprite", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 可乐
    public static final RegistryObject<Block> PEPSI = BLOCK_REGISTER.register("pepsi", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 芬达
    public static final RegistryObject<Block> FANTA = BLOCK_REGISTER.register("fanta", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 花粉甜酿
    public static final RegistryObject<Block> POLLEN_NECTAR = BLOCK_REGISTER.register("pollen_nectar", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜜刺佳酿
    public static final RegistryObject<Block> HONEYTHORN_MEAD = BLOCK_REGISTER.register("honeythorn_mead", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜂蜡陈酿
    public static final RegistryObject<Block> BEESWAX_HONEY_WINE = BLOCK_REGISTER.register("beeswax_honey_wine", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 甜蜜水晶
    public static final RegistryObject<Block> SWEET_CRYSTAL_HONEY = BLOCK_REGISTER.register("sweet_crystal_honey", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());
    // 蜂王特酿
    public static final RegistryObject<Block> ROYAL_HONEY_BREW = BLOCK_REGISTER.register("royal_honey_brew", () ->
            DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getShortBottleShapes()).build().get());

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
