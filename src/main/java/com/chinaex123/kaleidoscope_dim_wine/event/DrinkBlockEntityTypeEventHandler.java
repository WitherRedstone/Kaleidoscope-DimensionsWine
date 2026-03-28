package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

/**
 * 将本模组的所有 DrinkBlock 方块注册到 kaleidoscope_tavern 的 DrinkBlockEntity 中
 * <p>
 * 作用：解决使用 DrinkBlock.create() 创建的方块在放置时因 BlockEntity 验证失败而崩溃的问题
 */
public final class DrinkBlockEntityTypeEventHandler {

    private static final ResourceLocation TAVERN_DRINK_BE = ResourceLocation.tryBuild("kaleidoscope_tavern", "drink");

    public static void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        if (!ModList.get().isLoaded("kaleidoscope_tavern")) {
            return;
        }
        BuiltInRegistries.BLOCK_ENTITY_TYPE.getOptional(TAVERN_DRINK_BE).ifPresent(drinkType -> {
            Block[] drinks = new Block[] {
                    ModBlocks.CRIMSON_CRESCENDO.get(), // 绯红绝响
                    ModBlocks.ETHEREAL_NOBLE.get(), // 以太贵族
                    ModBlocks.WART_HENNESSY.get(), // 疣状轩尼诗
                    ModBlocks.BLAZE_MARTELL.get(), // 烈焰马爹利
                    ModBlocks.MAGMA_ROYAL_SALUTE.get(), // 岩浆皇家礼炮
                    ModBlocks.BLACK_BONE_LAFITE.get() // 黑骨拉菲
            };
            for (Block drink : drinks) {
                event.modify(drinkType, drink);
            }
        });
    }
}