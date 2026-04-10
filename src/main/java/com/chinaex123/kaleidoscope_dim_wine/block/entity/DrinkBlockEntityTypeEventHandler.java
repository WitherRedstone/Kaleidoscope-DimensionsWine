package com.chinaex123.kaleidoscope_dim_wine.block.entity;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
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
        BuiltInRegistries.BLOCK_ENTITY_TYPE.getOptional(TAVERN_DRINK_BE).ifPresent(drinkType -> {
            event.modify(drinkType,
                    // ==================== 次元维度 - 下界 ====================
                    ModBlocks.CRIMSON_CRESCENDO.get(), // 绯红绝响
                    ModBlocks.ETHEREAL_NOBLE.get(), // 以太贵族
                    ModBlocks.WART_HENNESSY.get(), // 疣状轩尼诗
                    ModBlocks.BLAZE_MARTELL.get(), // 烈焰马爹利
                    ModBlocks.MAGMA_ROYAL_SALUTE.get(), // 岩浆皇家礼炮
                    ModBlocks.BLACK_BONE_LAFITE.get(), // 黑骨拉菲

                    // ==================== 次元维度 - 末地 ====================
                    ModBlocks.CHORUS_COGNAC.get(), // 紫颂干邑
                    ModBlocks.DRAGONS_BREATH_BRANDY.get(), // 龙息白兰地
                    ModBlocks.ABYSSAL_PORTER.get(), // 深渊波特
                    ModBlocks.SILENT_SHERRY.get(), // 静默雪莉
                    ModBlocks.FORGOTTEN_MARGARITA.get(), // 遗忘玛格丽特
                    ModBlocks.PHANTOM_DREAM_BUBBLE.get(), // 幻梦泡影
                    ModBlocks.END_STARLIGHT.get(), // 终末星光
                    ModBlocks.DIVINE_EMBRYO_PORT.get(), // 神血波尔多
                    ModBlocks.DRACONIC_BLOOD_WINE.get() // 龙血酒

                    // ==================== 次元维度 - 暮色森林 ====================

            );
        });
    }
}