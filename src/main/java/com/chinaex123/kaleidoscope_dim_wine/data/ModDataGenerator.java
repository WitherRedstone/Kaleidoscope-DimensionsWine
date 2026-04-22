package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
//import com.chinaex123.kaleidoscope_dim_wine.data.advancements.ModAdvancements;
//import com.chinaex123.kaleidoscope_dim_wine.data.lootTable.LootTableGenerator;
//import com.chinaex123.kaleidoscope_dim_wine.data.recipe.ModRecipesProvider;
import com.chinaex123.kaleidoscope_dim_wine.data.lootTable.LootTableGenerator;
import com.chinaex123.kaleidoscope_dim_wine.data.recipe.ModRecipesProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ModItemModelsProvider(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new LootTableGenerator(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider,
                CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModRecipesProvider(packOutput));
//        generator.addProvider(event.includeServer(), new ModAdvancements(packOutput, lookupProvider, existingFileHelper));
    }
}
