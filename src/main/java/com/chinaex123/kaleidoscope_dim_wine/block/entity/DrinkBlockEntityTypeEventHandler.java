package com.chinaex123.kaleidoscope_dim_wine.block.entity;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.ArrayList;
import java.util.List;

public final class DrinkBlockEntityTypeEventHandler {

    private static final ResourceLocation TAVERN_DRINK_BE = ResourceLocation.tryBuild("kaleidoscope_tavern", "drink");

    public static void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        BuiltInRegistries.BLOCK_ENTITY_TYPE.getOptional(TAVERN_DRINK_BE).ifPresent(drinkType -> {
            List<Block> blocks = new ArrayList<>();

            // ==================== 次元维度 - 下界 ====================
            blocks.add(ModBlocks.CRIMSON_CRESCENDO.get()); // 绯红绝响
            blocks.add(ModBlocks.ETHEREAL_NOBLE.get()); // 以太贵族
            blocks.add(ModBlocks.WART_HENNESSY.get()); // 疣状轩尼诗
            blocks.add(ModBlocks.BLAZE_MARTELL.get()); // 烈焰马爹利
            blocks.add(ModBlocks.MAGMA_ROYAL_SALUTE.get()); // 岩浆皇家礼炮
            blocks.add(ModBlocks.BLACK_BONE_LAFITE.get()); // 黑骨拉菲

            // ==================== 次元维度 - 末地 ====================
            blocks.add(ModBlocks.CHORUS_COGNAC.get()); // 紫颂干邑
            blocks.add(ModBlocks.DRAGONS_BREATH_BRANDY.get()); // 龙息白兰地
            blocks.add(ModBlocks.ABYSSAL_PORTER.get()); // 深渊波特
            blocks.add(ModBlocks.SILENT_SHERRY.get()); // 静默雪莉
            blocks.add(ModBlocks.FORGOTTEN_MARGARITA.get()); // 遗忘玛格丽特
            blocks.add(ModBlocks.PHANTOM_DREAM_BUBBLE.get()); // 幻梦泡影
            blocks.add(ModBlocks.END_STARLIGHT.get()); // 终末星光
            blocks.add(ModBlocks.DIVINE_EMBRYO_PORT.get()); // 神血波尔多
            blocks.add(ModBlocks.DRACONIC_BLOOD_WINE.get()); // 龙血酒

            // ==================== 次元维度 - 暮色森林 ====================
            if (ModList.get().isLoaded("twilightforest")) {
                blocks.add(TwilightforestBlocks.CAVE_GLOWBREW.get()); // 洞窟萤火酿
                blocks.add(TwilightforestBlocks.DAWNLIGHT_DEW.get()); // 林隙晨露
                blocks.add(TwilightforestBlocks.DEAD_END_SPITTLE.get()); // 死巷之唾
                blocks.add(TwilightforestBlocks.SNAKESKIN_LIQUEUR.get()); // 蛇蜕利口酒
                blocks.add(TwilightforestBlocks.FROSTVEIN_BEASTBLOOD.get()); // 霜脉兽血
                blocks.add(TwilightforestBlocks.RANGERS_SATCHEL.get()); // 巡林客的背囊
                blocks.add(TwilightforestBlocks.EMBEREYE.get()); // 烬瞳
                blocks.add(TwilightforestBlocks.STAGCALL_MONSOON.get()); // 鹿鸣季风
                blocks.add(TwilightforestBlocks.THORNHEART.get()); // 荆棘之心
                blocks.add(TwilightforestBlocks.DRUIDS_SECRET_BREW.get()); // 德鲁伊的秘酿
                blocks.add(TwilightforestBlocks.MOORGLOW_BIRDS_SONG.get()); // 辉夜鸟之歌
                blocks.add(TwilightforestBlocks.PERENNIAL_FROST.get()); // 终年冻土
                blocks.add(TwilightforestBlocks.GIANTS_HYMN.get()); // 巨人赞歌
                blocks.add(TwilightforestBlocks.GOBLINS_STASH.get()); // 地精的私藏
            }

            event.modify(drinkType, blocks.toArray(new Block[0]));
        });
    }
}
