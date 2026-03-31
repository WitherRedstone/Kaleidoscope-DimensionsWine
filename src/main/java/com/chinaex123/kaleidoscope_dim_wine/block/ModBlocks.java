package com.chinaex123.kaleidoscope_dim_wine.block;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape.*;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape.*;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit.*;
import com.chinaex123.kaleidoscope_dim_wine.fluid.ModFluids;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTER =
            DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 次元维度 - 下界 ====================
    // -------------------- 作物 --------------------
    // 绯红葡萄藤 - 绯红葡萄藤架生长的果实
    public static final DeferredBlock<Block> CRIMSON_GRAPE_CROP = BLOCK_REGISTER.register("crimson_grape_crop", CrimsonGrapeCropBlock::new);
    // 绯红葡萄藤架 - 替换藤架的方块，也就相当于酒馆葡萄藤右键藤架替换的方块
    public static final DeferredBlock<Block> CRIMSON_GRAPEVINE_TRELLIS = BLOCK_REGISTER.register("crimson_grapevine_trellis", CrimsonGrapevineTrellisBlock::new);
    // 野生绯红葡萄藤 - 向下生长的藤蔓植物顶部方块
    public static final DeferredBlock<Block> CRIMSON_GRAPEVINE = BLOCK_REGISTER.register("crimson_grapevine", CrimsonGrapeCropWildGrapevineHead::new);
    // 野生绯红葡萄藤植物 - 向下生长的藤蔓植物主体方块
    public static final DeferredBlock<Block> CRIMSON_GRAPEVINE_PLANT = BLOCK_REGISTER.register("crimson_grapevine_plant", CrimsonGrapeCropWildGrapevinePlant::new);

    // 诡异葡萄藤 - 诡异葡萄藤架生长的果实
    public static final DeferredBlock<Block> WARPED_GRAPE_CROP = BLOCK_REGISTER.register("warped_grape_crop", WarpedGrapeCropBlock::new);
    // 诡异葡萄藤架 - 替换藤架的方块，也就相当于酒馆葡萄藤右键藤架替换的方块
    public static final DeferredBlock<Block> WARPED_GRAPEVINE_TRELLIS = BLOCK_REGISTER.register("warped_grapevine_trellis", WarpedGrapevineTrellisBlock::new);
    // 野生绯红葡萄藤
    public static final DeferredBlock<Block> WARPED_GRAPEVINE = BLOCK_REGISTER.register("warped_grapevine", WarpedGrapeCropWildGrapevineHead::new);
    // 野生绯红葡萄藤植物
    public static final DeferredBlock<Block> WARPED_GRAPEVINE_PLANT = BLOCK_REGISTER.register("warped_grapevine_plant", WarpedGrapeCropWildGrapevinePlant::new);
    // -------------------- 酒类 --------------------
    // 绯红绝响
    public static final DeferredHolder<Block, Block> CRIMSON_CRESCENDO =
            BLOCK_REGISTER.register("crimson_crescendo", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 诡影尊爵
    public static final DeferredHolder<Block, Block> ETHEREAL_NOBLE =
            BLOCK_REGISTER.register("ethereal_noble", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 疣域轩尼诗
    public static final DeferredHolder<Block, Block> WART_HENNESSY =
            BLOCK_REGISTER.register("wart_hennessy", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 烈焰马爹利
    public static final DeferredHolder<Block, Block> BLAZE_MARTELL =
            BLOCK_REGISTER.register("blaze_martell", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 岩浆皇家礼炮
    public static final DeferredHolder<Block, Block> MAGMA_ROYAL_SALUTE =
            BLOCK_REGISTER.register("magma_royal_salute", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 黑骨拉菲
    public static final DeferredHolder<Block, Block> BLACK_BONE_LAFITE =
            BLOCK_REGISTER.register("black_bone_lafite", () -> DrinkBlock.create().maxCount(16).shapes(DrinkShapes.getStandardBottleShapes()).build().get());


    // ==================== 次元维度 - 末地 ====================
    // -------------------- 作物 --------------------
    // 野生迷梦果藤 - 向下生长的藤蔓植物顶部方块
    public static final DeferredBlock<Block> DREAMFRUIT_VINE = BLOCK_REGISTER.register("dreamfruit_vine", DreamfruitCropWildVineHead::new);
    // 野生迷梦果藤植物 - 向下生长的藤蔓植物主体方块
    public static final DeferredBlock<Block> DREAMFRUIT_VINE_PLANT = BLOCK_REGISTER.register("dreamfruit_vine_plant", DreamfruitCropWildVinePlant::new);
    // -------------------- 流体 --------------------
    public static final DeferredBlock<LiquidBlock> DRAGON_BLOOD_FLUID_BLOCK =
            BLOCK_REGISTER.register("dragon_blood_fluid_block", () -> new LiquidBlock(ModFluids.DRAGON_BLOOD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)
                    .friction(0.6F)
                    .speedFactor(0.5F)
                    .jumpFactor(0.5F)
                    .mapColor(MapColor.COLOR_RED)
                    .sound(SoundType.HONEY_BLOCK)));

    // -------------------- 酒类 --------------------

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
