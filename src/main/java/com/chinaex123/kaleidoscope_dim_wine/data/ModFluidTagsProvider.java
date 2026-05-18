package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluidTags;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluids;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        this.tag(KDWFluidTags.JUICE_GRAPE)
                .add(ModFluids.GRAPE_JUICE.get())
                .add(ModFluids.ICE_GRAPE_JUICE.get())
                .add(ModFluids.GOLD_GRAPE_JUICE.get())
                .add(ModFluids.GREEN_GRAPE_JUICE.get())
                .add(ModFluids.SWEET_BERRIES_JUICE.get())
                .add(ModFluids.GLOW_BERRIES_JUICE.get())
                .add(KDWFluids.CRIMSON_GRAPE_JUICE.get())
                .add(KDWFluids.WARPED_GRAPE_JUICE.get());
        this.tag(KDWFluidTags.JUICE_GRAPE_CRIMSON)
                .add(KDWFluids.CRIMSON_GRAPE_JUICE.get());
        this.tag(KDWFluidTags.JUICE_GRAPE_WARPED)
                .add(KDWFluids.WARPED_GRAPE_JUICE.get());

        this.tag(KDWFluidTags.JUICE_FRUIT)
                .add(KDWFluids.DREAMFRUIT_JUICE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit_juice"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "torchberries_juice"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "enchanted_berry_juice"));
        this.tag(KDWFluidTags.JUICE_FRUIT_DREAMFRUIT)
                .add(KDWFluids.DREAMFRUIT_JUICE.get());
        this.tag(KDWFluidTags.JUICE_FRUIT_FROSTHEART_FRUIT)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit_juice"));
        this.tag(KDWFluidTags.JUICE_FRUIT_TORCHBERRIES)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "torchberries_juice"));
        this.tag(KDWFluidTags.JUICE_FRUIT_ENCHANTED_BERRY)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "enchanted_berry_juice"));
    }
}
