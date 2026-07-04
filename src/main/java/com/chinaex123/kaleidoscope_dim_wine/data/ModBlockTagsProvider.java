package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlockTags;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_COMMAND.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get());
        // 木镐挖掘
        tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_COMMAND.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get());

        // 小灯串
        tag(KDWBlockTags.STRING_LIGHTS)
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get())
                .add(KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_COMMAND.get())
                .add(KDWBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get());

        // 作物
        tag(KDWBlockTags.CROPS)
                .add(KDWBlocks.HOP_CROP.get());

        // 静谧四季 - 全年
        tag(KDWBlockTags.YEAR_ROUND_CROPS_BLOCK)
                .add(KDWBlocks.CRIMSON_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_PLANT.get())
                .add(KDWBlocks.DREAMFRUIT_VINE_PLANT.get());
        // 静谧四季 - 夏天
        tag(KDWBlockTags.SUMMER_CROPS_BLOCK)
                .add(KDWBlocks.HOP_CROP.get());
        // 静谧四季 - 冬天
        tag(KDWBlockTags.WINTER_CROPS_BLOCK)
                .addOptional(BuiltInRegistries.BLOCK.getKey(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get()));

        // 节气 - 所有季节
        tag(KDWBlockTags.CROPS_ALL_SEASONS_BLOCK)
                .add(KDWBlocks.CRIMSON_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_PLANT.get());
        // 节气 - 夏天
        tag(KDWBlockTags.CROPS_SUMMER)
                .add(KDWBlocks.HOP_CROP.get());
        // 节气 - 冬天
        tag(KDWBlockTags.CROPS_WINTER)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit_bush"));

        // 节气 - 干旱环境
        tag(KDWBlockTags.CROPS_DRY_AVERAGE)
                .add(KDWBlocks.CRIMSON_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_TRELLIS.get())
                .add(KDWBlocks.WARPED_GRAPEVINE_PLANT.get())
                .add(KDWBlocks.DREAMFRUIT_VINE.get())
                .add(KDWBlocks.DREAMFRUIT_VINE_PLANT.get())
                .add(KDWBlocks.HOP_CROP.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit_bush"));
    }
}
