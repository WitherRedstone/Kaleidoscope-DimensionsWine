package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlockTags;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // 镐子挖掘
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()) // 小灯串（潜影贝-无色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()) // 小灯串（潜影贝-白色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()) // 小灯串（潜影贝-橙色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()) // 小灯串（潜影贝-品红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()) // 小灯串（潜影贝-淡蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()) // 小灯串（潜影贝-黄色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()) // 小灯串（潜影贝-黄绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()) // 小灯串（潜影贝-粉红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()) // 小灯串（潜影贝-灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()) // 小灯串（潜影贝-淡灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()) // 小灯串（潜影贝-青色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()) // 小灯串（潜影贝-紫色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()) // 小灯串（潜影贝-蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()) // 小灯串（潜影贝-棕色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()) // 小灯串（潜影贝-绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()) // 小灯串（潜影贝-红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()) // 小灯串（潜影贝-黑色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()) // 小灯串（小鸡仔）

                .add(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()) // 小灯串（命令方块）
                .add(ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

        // 需要木镐挖掘
        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()) // 小灯串（潜影贝-无色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()) // 小灯串（潜影贝-白色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()) // 小灯串（潜影贝-橙色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()) // 小灯串（潜影贝-品红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()) // 小灯串（潜影贝-淡蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()) // 小灯串（潜影贝-黄色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()) // 小灯串（潜影贝-黄绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()) // 小灯串（潜影贝-粉红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()) // 小灯串（潜影贝-灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()) // 小灯串（潜影贝-淡灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()) // 小灯串（潜影贝-青色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()) // 小灯串（潜影贝-紫色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()) // 小灯串（潜影贝-蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()) // 小灯串（潜影贝-棕色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()) // 小灯串（潜影贝-绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()) // 小灯串（潜影贝-红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()) // 小灯串（潜影贝-黑色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()) // 小灯串（小鸡仔）

                .add(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()) // 小灯串（命令方块）
                .add(ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

        // 小彩灯
        this.tag(ModBlockTags.STRING_LIGHTS)
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()) // 小灯串（潜影贝-无色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()) // 小灯串（潜影贝-白色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()) // 小灯串（潜影贝-橙色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()) // 小灯串（潜影贝-品红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()) // 小灯串（潜影贝-淡蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()) // 小灯串（潜影贝-黄色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()) // 小灯串（潜影贝-黄绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()) // 小灯串（潜影贝-粉红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()) // 小灯串（潜影贝-灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()) // 小灯串（潜影贝-淡灰色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()) // 小灯串（潜影贝-青色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()) // 小灯串（潜影贝-紫色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()) // 小灯串（潜影贝-蓝色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()) // 小灯串（潜影贝-棕色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()) // 小灯串（潜影贝-绿色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()) // 小灯串（潜影贝-红色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()) // 小灯串（潜影贝-黑色）
                .add(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()) // 小灯串（小鸡仔）

                .add(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()) // 小灯串（命令方块）
                .add(ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

        // 静谧四季 - sereneseasons:year_round_crops
        this.tag(ModBlockTags.YEAR_ROUND_CROPS_BLOCK)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果

        // 节气 - eclipticseasons:crops/all_seasons
        this.tag(ModBlockTags.CROPS_ALL_SEASONS_BLOCK)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()); // 诡异葡萄藤
        // 节气 - eclipticseasons:crops/dry_average
        this.tag(ModBlockTags.CROPS_DRY_AVERAGE)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(ModBlockTags.WINTER_CROPS_BLOCK).addOptional(BuiltInRegistries.BLOCK.getKey(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get())); // 迷梦果丛
            // 节气 - eclipticseasons:crops/winter
            this.tag(ModBlockTags.CROPS_WINTER).addOptional(BuiltInRegistries.BLOCK.getKey(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get())); // 迷梦果丛
            // 节气 - eclipticseasons:crops/dry_average
            this.tag(ModBlockTags.CROPS_DRY_AVERAGE).addOptional(BuiltInRegistries.BLOCK.getKey(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get())); // 迷梦果丛
        }
    }
}
