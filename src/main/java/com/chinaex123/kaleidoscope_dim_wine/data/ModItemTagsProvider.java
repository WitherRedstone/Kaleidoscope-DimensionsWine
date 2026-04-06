package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.tag.ModItemTags;
import joptsimple.internal.Rows;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider  extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        // -------------------- 作物 --------------------
        // c:fruits/crimson_grape
        this.tag(ModItemTags.FRUITS_CRIMSON_GRAPE).add(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        // c:fruits/warped_grape
        this.tag(ModItemTags.FRUITS_WARPED_GRAPE).add(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
        // diet:fruits
        this.tag(ModItemTags.FRUITS)
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果

        // 静谧四季
        this.tag(ModItemTags.YEAR_ROUND_CROPS) // sereneseasons:year_round_crops
                .add(ModItems.CRIMSON_GRAPE.get()) // 绯红葡萄
                .add(ModItems.WARPED_GRAPE.get()) // 诡异葡萄
                .add(ModItems.DREAMFRUIT.get()); // 迷梦果
    }
}
