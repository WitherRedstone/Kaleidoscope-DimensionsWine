package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.DollBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.PopCanBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.*;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Dreamfruit.*;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.WarpedGrape.*;
import com.chinaex123.kaleidoscope_dim_wine.compat.kaleidoscope_doll.KaleidoscopeDollBlock;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.block.deco.StringLightsBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.item.StringLightsBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class KDWBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTER =
            DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 小彩蛋 ====================
    // 玩偶 - ChinaEX123_BILI
    public static final DeferredBlock<Block> DOLL_001 = registerConditionalDoll("doll_001", Rarity.RARE);
    // 玩偶 - Fvue233
    public static final DeferredBlock<Block> DOLL_002 = registerConditionalDoll("doll_002", Rarity.RARE);
    // 玩偶 - Agens_Eland
    public static final DeferredBlock<Block> DOLL_003 = registerConditionalDoll("doll_003", Rarity.RARE);

    // ==================== 次元维度 - 小装饰 ====================
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER = registerStringLights("string_lights_entity_shulker", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-无色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_WHITE = registerStringLights("string_lights_entity_shulker_white", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-白色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_ORANGE = registerStringLights("string_lights_entity_shulker_orange", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-橙色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_MAGENTA = registerStringLights("string_lights_entity_shulker_magenta", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-品红色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE = registerStringLights("string_lights_entity_shulker_light_blue", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-淡蓝色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_YELLOW = registerStringLights("string_lights_entity_shulker_yellow", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-黄色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_LIME = registerStringLights("string_lights_entity_shulker_lime", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-黄绿色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_PINK = registerStringLights("string_lights_entity_shulker_pink", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-粉红色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_GRAY = registerStringLights("string_lights_entity_shulker_gray", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-灰色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY = registerStringLights("string_lights_entity_shulker_light_gray", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-淡灰色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_CYAN = registerStringLights("string_lights_entity_shulker_cyan", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-青色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_PURPLE = registerStringLights("string_lights_entity_shulker_purple", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-紫色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_BLUE = registerStringLights("string_lights_entity_shulker_blue", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-蓝色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_BROWN = registerStringLights("string_lights_entity_shulker_brown", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-棕色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_GREEN = registerStringLights("string_lights_entity_shulker_green", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-绿色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_RED = registerStringLights("string_lights_entity_shulker_red", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-红色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_SHULKER_BLACK = registerStringLights("string_lights_entity_shulker_black", () -> new StringLightsBlock(null)); // 小灯串（潜影贝-黑色）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_CHICKEN = registerStringLights("string_lights_entity_chicken", () -> new StringLightsBlock(null)); // 小灯串（小鸡仔）
    public static final DeferredBlock<Block> STRING_LIGHTS_ENTITY_BEE = registerStringLights("string_lights_entity_bee", () -> new StringLightsBlock(null)); // 小灯串（蜜蜂）

    public static final DeferredBlock<Block> STRING_LIGHTS_BLOCK_COMMAND = registerStringLights("string_lights_block_command", () -> new StringLightsBlock(null)); // 小灯串（命令方块）
    public static final DeferredBlock<Block> STRING_LIGHTS_BLOCK_BEDROCK = registerStringLights("string_lights_block_bedrock", () -> new StringLightsBlock(null)); // 小灯串（基岩）

    // -------------------- 瓶装 --------------------
    // 空竹杯
//    public static final DeferredBlock<Block> EMPTY_BAMBOO_CUP = BLOCK_REGISTER.register("empty_bamboo_cup", () -> new BottleBlock());
    // 易拉罐
    public static final DeferredBlock<Block> POP_CAN = BLOCK_REGISTER.register("pop_can", PopCanBlock::new);

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
            BLOCK_REGISTER.register("crimson_crescendo", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 诡影尊爵
    public static final DeferredHolder<Block, Block> ETHEREAL_NOBLE =
            BLOCK_REGISTER.register("ethereal_noble", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 疣域轩尼诗
    public static final DeferredHolder<Block, Block> WART_HENNESSY =
            BLOCK_REGISTER.register("wart_hennessy", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 烈焰马爹利
    public static final DeferredHolder<Block, Block> BLAZE_MARTELL =
            BLOCK_REGISTER.register("blaze_martell", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 岩浆皇家礼炮
    public static final DeferredHolder<Block, Block> MAGMA_ROYAL_SALUTE =
            BLOCK_REGISTER.register("magma_royal_salute", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 黑骨拉菲
    public static final DeferredHolder<Block, Block> BLACK_BONE_LAFITE =
            BLOCK_REGISTER.register("black_bone_lafite", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());


    // ==================== 次元维度 - 末地 ====================
    // -------------------- 流体 --------------------
    // 龙血
    public static final DeferredBlock<LiquidBlock> DRAGON_BLOOD_FLUID =
            BLOCK_REGISTER.register("dragon_blood_fluid", () -> new LiquidBlock(KDWFluids.DRAGON_BLOOD.get(), BlockBehaviour.Properties.of()
                    .noLootTable() // 不掉落
                    .liquid() // 液体
                    .replaceable() // 可替换
                    .noCollission() // 无碰撞
                    .strength(100.0F) // 硬度
                    .friction(0.6F) // 摩擦
                    .speedFactor(0.5F) // 移动速度
                    .jumpFactor(0.5F) // 跳跃速度
                    .mapColor(MapColor.COLOR_RED)
                    .sound(SoundType.HONEY_BLOCK)
            ));
    // -------------------- 作物 --------------------
    // 野生迷梦果藤 - 向下生长的藤蔓植物顶部方块
    public static final DeferredBlock<Block> DREAMFRUIT_VINE = BLOCK_REGISTER.register("dreamfruit_vine", DreamfruitCropWildVineHead::new);
    // 野生迷梦果藤植物 - 向下生长的藤蔓植物主体方块
    public static final DeferredBlock<Block> DREAMFRUIT_VINE_PLANT = BLOCK_REGISTER.register("dreamfruit_vine_plant", DreamfruitCropWildVinePlant::new);
    // -------------------- 酒类 --------------------
    // 紫颂干邑
    public static final DeferredHolder<Block, Block> CHORUS_COGNAC =
            BLOCK_REGISTER.register("chorus_cognac", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 龙息白兰地
    public static final DeferredHolder<Block, Block> DRAGONS_BREATH_BRANDY =
            BLOCK_REGISTER.register("dragons_breath_brandy", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 深渊波特
    public static final DeferredHolder<Block, Block> ABYSSAL_PORTER =
            BLOCK_REGISTER.register("abyssal_porter", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 静默雪莉
    public static final DeferredHolder<Block, Block> SILENT_SHERRY =
            BLOCK_REGISTER.register("silent_sherry", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 遗忘玛格丽特
    public static final DeferredHolder<Block, Block> FORGOTTEN_MARGARITA =
            BLOCK_REGISTER.register("forgotten_margarita", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 幻梦泡影
    public static final DeferredHolder<Block, Block> PHANTOM_DREAM_BUBBLE =
            BLOCK_REGISTER.register("phantom_dream_bubble", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 终末星光
    public static final DeferredHolder<Block, Block> END_STARLIGHT =
            BLOCK_REGISTER.register("end_starlight", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 神血波尔多
    public static final DeferredHolder<Block, Block> DIVINE_EMBRYO_PORT =
            BLOCK_REGISTER.register("divine_embryo_port", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    // 龙血酒
    public static final DeferredHolder<Block, Block> DRACONIC_BLOOD_WINE =
            BLOCK_REGISTER.register("draconic_blood_wine", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block, Rarity rarity) {
        KDWItems.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        KDWItems.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block, Rarity rarity) {
        DeferredBlock<T> blocks = BLOCK_REGISTER.register(name, block);
        registerBlockItems(name, blocks, rarity);
        return blocks;
    }

    public static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block) {
        DeferredBlock<T> blocks = BLOCK_REGISTER.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    private static DeferredBlock<Block> registerConditionalDoll(String name, Rarity rarity) {
        return registerBlocks(name, () -> {
            if (KaleidoscopeDollBlock.isKaleidoscopeDollLoaded()) {
                Block doll = KaleidoscopeDollBlock.createKaleidoscopeDoll();
                return doll != null ? doll : new DollBlock();
            } else {
                return new DollBlock();
            }
        }, rarity);
    }

    private static DeferredBlock<Block> registerStringLights(String name, Supplier<Block> blockSupplier) {
        DeferredBlock<Block> block = BLOCK_REGISTER.register(name, blockSupplier);
        KDWItems.ITEMS_REGISTER.register(name, () -> new StringLightsBlockItem(block));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
