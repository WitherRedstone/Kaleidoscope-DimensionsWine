package com.chinaex123.kaleidoscope_dim_wine.data.lootTable;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class BlockLootTable extends BlockLootSubProvider {
    public final Set<Block> knownBlocks = new HashSet<>();

    public BlockLootTable(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        // 绯红葡萄藤 - 绯红葡萄藤架生长的果实
        add(ModBlocks.CRIMSON_GRAPE_CROP.get(), this.createItemWithCountTable(ModItems.CRIMSON_GRAPE.get(), UniformGenerator.between(1, 2)));
        // 绯红葡萄藤架 - 替换藤架的方块，也就相当于酒馆葡萄藤右键藤架替换的方块
        add(ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get(), this.createMultiItemTable(com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems.TRELLIS.get(), ModItems.CRIMSON_GRAPEVINE.get()));
        // 野生绯红葡萄藤 - 向下生长的藤蔓植物顶部方块
        dropOther(ModBlocks.CRIMSON_GRAPEVINE.get(), ModItems.CRIMSON_GRAPEVINE.get());
        // 野生绯红葡萄藤植物 - 向下生长的藤蔓植物主体方块
        dropOther(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get(), ModItems.CRIMSON_GRAPEVINE.get());

        // 诡异葡萄藤 - 诡异葡萄藤架生长的果实
        add(ModBlocks.WARPED_GRAPE_CROP.get(), this.createItemWithCountTable(ModItems.WARPED_GRAPE.get(), UniformGenerator.between(1, 2)));
        // 诡异葡萄藤架 - 替换藤架的方块，也就相当于酒馆葡萄藤右键藤架替换的方块
        add(ModBlocks.WARPED_GRAPEVINE_TRELLIS.get(), this.createMultiItemTable(com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems.TRELLIS.get(), ModItems.WARPED_GRAPEVINE.get()));
        // 野生诡异葡萄藤 - 向下生长的藤蔓植物顶部方块
        dropOther(ModBlocks.WARPED_GRAPEVINE.get(), ModItems.WARPED_GRAPEVINE.get());
        // 野生诡异葡萄藤植物 - 向下生长的藤蔓植物主体方块
        dropOther(ModBlocks.WARPED_GRAPEVINE_PLANT.get(), ModItems.WARPED_GRAPEVINE.get());
    }

    @Override
    public void add(Block block, LootTable.Builder builder) {
        this.knownBlocks.add(block);
        super.add(block, builder);
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    public LootTable.Builder createMultiItemTable(ItemLike... items) {
        LootTable.Builder builder = LootTable.lootTable();
        for (ItemLike item : items) {
            LootPool.Builder pool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(item));
            builder.withPool(this.applyExplosionCondition(item, pool));
        }
        return builder;
    }

    protected LootTable.Builder createItemWithCountTable(ItemLike item, NumberProvider countProvider) {
        LootTable.Builder builder = LootTable.lootTable();
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .apply(SetItemCountFunction.setCount(countProvider))
                .add(LootItem.lootTableItem(item));
        builder.withPool(this.applyExplosionCondition(item, pool));
        return builder;
    }
}


//public class ModLootTableProvider extends LootTableProvider {
//    public ModLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
//        super(packOutput, Set.of(), List.of(
//                new SubProviderEntry(BlockLoots::new, LootContextParamSets.BLOCK)
//        ), registries);
//    }
//
//    public static class BlockLoots extends BlockLootSubProvider {
//        protected BlockLoots(HolderLookup.Provider provider) {
//            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
//        }
//
//        @Override
//        protected void generate() {
//            dropOther(ModBlocks.CRIMSON_GRAPEVINE.get(), ModItems.CRIMSON_GRAPEVINE.get());
//            dropOther(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get(), ModItems.CRIMSON_GRAPEVINE.get());
//
//            this.add(ModBlocks.CRIMSON_GRAPEVINE.get(), LootTable.lootTable()
//                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.CRIMSON_GRAPEVINE.get()))));
//            this.add(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get(), LootTable.lootTable()
//                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.CRIMSON_GRAPEVINE.get()))));
//        }
//
//        @Override
//        protected @NotNull Iterable<Block> getKnownBlocks() {
//            return Set.of(
//                    ModBlocks.CRIMSON_GRAPEVINE.get(),
//                    ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()
//            );
//        }
//    }
//}
