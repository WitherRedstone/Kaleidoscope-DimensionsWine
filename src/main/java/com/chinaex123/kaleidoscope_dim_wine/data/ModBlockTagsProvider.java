package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.tag.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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

        // 静谧四季
        this.tag(ModItemTags.YEAR_ROUND_CROPS_BLOCK) // sereneseasons:year_round_crops
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果

        // 节气
        this.tag(ModItemTags.CROPS_ALL_SEASONS_BLOCK) // eclipticseasons:crops/all_seasons
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()); // 诡异葡萄藤
        this.tag(ModItemTags.CROPS_DRY_AVERAGE) // eclipticseasons:crops/dry_average
                .add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()) // 绯红葡萄藤
                .add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) // 诡异葡萄藤
                .add(ModBlocks.DREAMFRUIT_VINE_PLANT.get()); // 迷梦果
    }
}
