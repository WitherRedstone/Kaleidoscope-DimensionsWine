package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.neoforged.fml.ModList;
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

        // 静谧四季 - sereneseasons:year_round_crops
        this.tag(ModItemTags.YEAR_ROUND_CROPS_BLOCK)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果

        // 节气 - eclipticseasons:crops/all_seasons
        this.tag(ModItemTags.CROPS_ALL_SEASONS_BLOCK)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()); // 诡异葡萄藤
        // 节气 - eclipticseasons:crops/dry_average
        this.tag(ModItemTags.CROPS_DRY_AVERAGE)
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果


        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // 静谧四季 - sereneseasons:winter_crops
            this.tag(ModItemTags.WINTER_CROPS_BLOCK).add(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get()); // 迷梦果丛
            // 节气 - eclipticseasons:crops/winter
            this.tag(ModItemTags.CROPS_WINTER).add(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get()); // 迷梦果丛
            // 节气 - eclipticseasons:crops/dry_average
            this.tag(ModItemTags.CROPS_DRY_AVERAGE).add(TwilightforestBlocks.FROSTHEART_FRUIT_BUSH.get()); // 迷梦果丛
        }
    }
}
