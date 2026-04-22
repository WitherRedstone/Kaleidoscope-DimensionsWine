package com.chinaex123.kaleidoscope_dim_wine.data.lootTable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(PackOutput pack, CompletableFuture<HolderLookup.Provider> registries) {
        super(pack, Set.of(), List.of(
                new SubProviderEntry(ModBlockLootTablesProvider::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.ADVANCEMENT_REWARD)
        ), registries);
    }
}
