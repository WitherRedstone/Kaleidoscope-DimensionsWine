package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.DollBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.PopCanBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.CrimsonGrapeCropBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.CrimsonGrapeCropWildGrapevineHead;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.CrimsonGrapeCropWildGrapevinePlant;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.CrimsonGrapevineTrellisBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Dreamfruit.DreamfruitCropWildVineHead;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Dreamfruit.DreamfruitCropWildVinePlant;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Hop.HopCrop;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.WarpedGrape.WarpedGrapeCropBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.WarpedGrape.WarpedGrapeCropWildGrapevineHead;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.WarpedGrape.WarpedGrapeCropWildGrapevinePlant;
import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.WarpedGrape.WarpedGrapevineTrellisBlock;
import com.chinaex123.kaleidoscope_dim_wine.compat.kaleidoscope_doll.KaleidoscopeDollBlock;
import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.block.deco.StringLightsBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.item.StringLightsBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface KDWBlocks {
    DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeDimensionsWine.MOD_ID);

    // 小彩蛋
    RegistryObject<Block> DOLL_001 = registerConditionalDoll("doll_001", Rarity.RARE); // 玩偶 - ChinaEX123_BILI
    RegistryObject<Block> DOLL_002 = registerConditionalDoll("doll_002", Rarity.RARE); // 玩偶 - Fvue233
    RegistryObject<Block> DOLL_003 = registerConditionalDoll("doll_003", Rarity.RARE); // 玩偶 - Agens_Eland

    // 小灯串
    RegistryObject<Block> STRING_LIGHTS_BLOCK_COMMAND = registerStringLights("string_lights_block_command", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_BLOCK_BEDROCK = registerStringLights("string_lights_block_bedrock", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER = registerStringLights("string_lights_entity_shulker", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_WHITE = registerStringLights("string_lights_entity_shulker_white", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_ORANGE = registerStringLights("string_lights_entity_shulker_orange", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_MAGENTA = registerStringLights("string_lights_entity_shulker_magenta", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE = registerStringLights("string_lights_entity_shulker_light_blue", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_YELLOW = registerStringLights("string_lights_entity_shulker_yellow", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_LIME = registerStringLights("string_lights_entity_shulker_lime", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_PINK = registerStringLights("string_lights_entity_shulker_pink", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_GRAY = registerStringLights("string_lights_entity_shulker_gray", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY = registerStringLights("string_lights_entity_shulker_light_gray", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_CYAN = registerStringLights("string_lights_entity_shulker_cyan", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_PURPLE = registerStringLights("string_lights_entity_shulker_purple", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_BLUE = registerStringLights("string_lights_entity_shulker_blue", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_BROWN = registerStringLights("string_lights_entity_shulker_brown", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_GREEN = registerStringLights("string_lights_entity_shulker_green", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_RED = registerStringLights("string_lights_entity_shulker_red", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_SHULKER_BLACK = registerStringLights("string_lights_entity_shulker_black", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_CHICKEN = registerStringLights("string_lights_entity_chicken", () -> new StringLightsBlock(null));
    RegistryObject<Block> STRING_LIGHTS_ENTITY_BEE = registerStringLights("string_lights_entity_bee", () -> new StringLightsBlock(null));


    // ==================== 次元维度 - 主世界 ====================
    // 作物
    RegistryObject<HopCrop> HOP_CROP = BLOCK_REGISTER.register("hop_crop", () -> new HopCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    // 瓶装
    RegistryObject<Block> POP_CAN = BLOCK_REGISTER.register("pop_can", PopCanBlock::new);

    // ==================== 次元维度 - 下界 ====================
    // 作物
    RegistryObject<Block> CRIMSON_GRAPE_CROP = BLOCK_REGISTER.register("crimson_grape_crop", CrimsonGrapeCropBlock::new);
    RegistryObject<Block> CRIMSON_GRAPEVINE_TRELLIS = BLOCK_REGISTER.register("crimson_grapevine_trellis", CrimsonGrapevineTrellisBlock::new);
    RegistryObject<Block> CRIMSON_GRAPEVINE = BLOCK_REGISTER.register("crimson_grapevine", CrimsonGrapeCropWildGrapevineHead::new);
    RegistryObject<Block> CRIMSON_GRAPEVINE_PLANT = BLOCK_REGISTER.register("crimson_grapevine_plant", CrimsonGrapeCropWildGrapevinePlant::new);
    RegistryObject<Block> WARPED_GRAPE_CROP = BLOCK_REGISTER.register("warped_grape_crop", WarpedGrapeCropBlock::new);
    RegistryObject<Block> WARPED_GRAPEVINE_TRELLIS = BLOCK_REGISTER.register("warped_grapevine_trellis", WarpedGrapevineTrellisBlock::new);
    RegistryObject<Block> WARPED_GRAPEVINE = BLOCK_REGISTER.register("warped_grapevine", WarpedGrapeCropWildGrapevineHead::new);
    RegistryObject<Block> WARPED_GRAPEVINE_PLANT = BLOCK_REGISTER.register("warped_grapevine_plant", WarpedGrapeCropWildGrapevinePlant::new);

    // 酒类
    RegistryObject<Block> CRIMSON_CRESCENDO = BLOCK_REGISTER.register("crimson_crescendo", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> ETHEREAL_NOBLE = BLOCK_REGISTER.register("ethereal_noble", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> WART_HENNESSY = BLOCK_REGISTER.register("wart_hennessy", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> BLAZE_MARTELL = BLOCK_REGISTER.register("blaze_martell", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> MAGMA_ROYAL_SALUTE = BLOCK_REGISTER.register("magma_royal_salute", () -> DrinkBlock.create().maxCount(3).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> BLACK_BONE_LAFITE = BLOCK_REGISTER.register("black_bone_lafite", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());


    // ==================== 次元维度 - 末地 ====================
    // 流体
    RegistryObject<LiquidBlock> DRAGON_BLOOD_FLUID = BLOCK_REGISTER.register("dragon_blood_fluid", () ->
            new LiquidBlock(() -> (FlowingFluid) KDWFluids.DRAGON_BLOOD.get(), BlockBehaviour.Properties.of()
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

    // 作物
    RegistryObject<Block> DREAMFRUIT_VINE = BLOCK_REGISTER.register("dreamfruit_vine", DreamfruitCropWildVineHead::new);
    RegistryObject<Block> DREAMFRUIT_VINE_PLANT = BLOCK_REGISTER.register("dreamfruit_vine_plant", DreamfruitCropWildVinePlant::new);

    // 酒类
    RegistryObject<Block> CHORUS_COGNAC = BLOCK_REGISTER.register("chorus_cognac", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DRAGONS_BREATH_BRANDY = BLOCK_REGISTER.register("dragons_breath_brandy", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> ABYSSAL_PORTER = BLOCK_REGISTER.register("abyssal_porter", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> SILENT_SHERRY = BLOCK_REGISTER.register("silent_sherry", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> FORGOTTEN_MARGARITA = BLOCK_REGISTER.register("forgotten_margarita", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> PHANTOM_DREAM_BUBBLE = BLOCK_REGISTER.register("phantom_dream_bubble", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> END_STARLIGHT = BLOCK_REGISTER.register("end_starlight", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DIVINE_EMBRYO_PORT = BLOCK_REGISTER.register("divine_embryo_port", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());
    RegistryObject<Block> DRACONIC_BLOOD_WINE = BLOCK_REGISTER.register("draconic_blood_wine", () -> DrinkBlock.create().maxCount(4).shapes(DrinkShapes.getStandardBottleShapes()).build().get());

    static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block, Rarity rarity) {
        KDWItems.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
    }

    static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block) {
        KDWItems.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> blocks = BLOCK_REGISTER.register(name, block);
        registerBlockItems(name, blocks, rarity);
        return blocks;
    }

    static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block) {
        RegistryObject<T> blocks = BLOCK_REGISTER.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    private static RegistryObject<Block> registerConditionalDoll(String name, Rarity rarity) {
        return registerBlocks(name, () -> {
            if (KaleidoscopeDollBlock.isKaleidoscopeDollLoaded()) {
                Block doll = KaleidoscopeDollBlock.createKaleidoscopeDoll();
                return doll != null ? doll : new DollBlock();
            } else {
                return new DollBlock();
            }
        }, rarity);
    }

    private static RegistryObject<Block> registerStringLights(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = BLOCK_REGISTER.register(name, blockSupplier);
        KDWItems.ITEMS_REGISTER.register(name, () -> new StringLightsBlockItem(block));
        return block;
    }

    static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
