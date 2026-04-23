package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModAdvancements extends ForgeAdvancementProvider {

    public ModAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(
                new AdvancementMinecraft(),
                new AdvancementTwilightforest(),
                new AdvancementTheBumblezone(),
                new AdvancementAether()
        ));
    }
}
