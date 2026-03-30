//package com.chinaex123.kaleidoscope_dim_wine.data;
//
//import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
//import net.minecraft.core.Holder;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.loot.BlockLootSubProvider;
//import net.minecraft.world.flag.FeatureFlags;
//import net.minecraft.world.level.block.Block;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Set;
//
//public class ModBlockLootTablesProvider extends BlockLootSubProvider {
//    protected ModBlockLootTablesProvider(HolderLookup.Provider registries) {
//        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
//    }
//
//    @Override
//    protected void generate() {
//        dropSelf(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()); // 绯红葡萄藤植物 - 掉落绯红葡萄藤
//        dropSelf(ModBlocks.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤（头部）- 掉落绯红葡萄藤
//        dropSelf(ModBlocks.WARPED_GRAPEVINE_PLANT.get()); // 诡异葡萄藤植物 - 掉落诡异葡萄藤
//        dropSelf(ModBlocks.WARPED_GRAPEVINE.get()); // 诡异葡萄藤（头部）- 掉落诡异葡萄藤
//    }
//
//    @Override
//    protected @NotNull Iterable<Block> getKnownBlocks() {
//        return java.util.List.of(
//                ModBlocks.CRIMSON_GRAPEVINE_PLANT.get(),
//                ModBlocks.CRIMSON_GRAPEVINE.get(),
//                ModBlocks.WARPED_GRAPEVINE_PLANT.get(),
//                ModBlocks.WARPED_GRAPEVINE.get()
//        );
//    }
//}
