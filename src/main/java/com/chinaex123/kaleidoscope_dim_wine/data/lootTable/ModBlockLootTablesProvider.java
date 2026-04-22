package com.chinaex123.kaleidoscope_dim_wine.data.lootTable;

import com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit.DreamfruitCropWildVineHead;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit.DreamfruitCropWildVinePlant;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public final Set<Block> knownBlocks = new HashSet<>();

    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        // ==================== 小彩蛋 ====================
        dropSelf(ModBlocks.DOLL_001.get());
        dropSelf(ModBlocks.DOLL_002.get());
        dropSelf(ModBlocks.DOLL_003.get());
        // ==================== 小彩蛋 ====================
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()); // 小灯串（潜影贝-无色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()); // 小灯串（潜影贝-白色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()); // 小灯串（潜影贝-橙色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()); // 小灯串（潜影贝-品红色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()); // 小灯串（潜影贝-淡蓝色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()); // 小灯串（潜影贝-黄色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()); // 小灯串（潜影贝-黄绿色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()); // 小灯串（潜影贝-粉红色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()); // 小灯串（潜影贝-灰色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()); // 小灯串（潜影贝-淡灰色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()); // 小灯串（潜影贝-青色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()); // 小灯串（潜影贝-紫色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()); // 小灯串（潜影贝-蓝色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()); // 小灯串（潜影贝-棕色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()); // 小灯串（潜影贝-绿色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()); // 小灯串（潜影贝-红色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()); // 小灯串（潜影贝-黑色）
        dropSelf(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()); // 小灯串（小鸡仔）

        dropSelf(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()); // 小灯串（命令方块）
        dropSelf(ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

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

        // ==================== 次元维度 - 末地 ====================
        // 野生迷梦果藤 - 向下生长的藤蔓植物顶部方块
        this.vinesWithBerries(ModBlocks.DREAMFRUIT_VINE.get(), ModItems.DREAMFRUIT.get(), DreamfruitCropWildVineHead.HAS_FRUIT);
        // 野生迷梦果藤植物 - 向下生长的藤蔓植物主体方块
        this.vinesWithBerries(ModBlocks.DREAMFRUIT_VINE_PLANT.get(), ModItems.DREAMFRUIT.get(), DreamfruitCropWildVinePlant.HAS_FRUIT);

    }

    /**
     * 添加方块及其战利品表到注册器
     * <p>
     * 将方块添加到已知方块集合中，以便后续追踪和管理
     * 然后调用父类方法完成战利品表的实际注册
     *
     * @param block   要注册的方块
     * @param builder 战利品表构建器
     */
    @Override
    public void add(Block block, LootTable.Builder builder) {
        // 记录已知的方块
        this.knownBlocks.add(block);
        super.add(block, builder);
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    /**
     * 创建包含多个物品的战利品表构建器
     * <p>
     * 为每个物品创建一个独立的战利品池，每个池固定掉落 1 个物品
     * 自动应用爆炸破坏条件（被爆炸破坏时不掉落）
     *
     * @param items 要掉落的物品列表（可变参数）
     * @return 包含所有物品池的战利品表构建器
     */
    public LootTable.Builder createMultiItemTable(ItemLike... items) {
        LootTable.Builder builder = LootTable.lootTable();

        // 为每个物品创建独立的战利品池
        for (ItemLike item : items) {
            LootPool.Builder pool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(item));
            builder.withPool(this.applyExplosionCondition(item, pool));
        }
        return builder;
    }

    /**
     * 创建带有自定义数量掉落物品的战利品表构建器
     * <p>
     * 创建一个固定 1 次投掷的战利品池，使用提供的数量生成器决定掉落数量
     * 自动应用爆炸破坏条件（被爆炸破坏时不掉落）
     *
     * @param item          要掉落的物品
     * @param countProvider 数量生成器（用于控制掉落数量范围）
     * @return 包含该物品的战利品表构建器
     */
    protected LootTable.Builder createItemWithCountTable(ItemLike item, NumberProvider countProvider) {
        LootTable.Builder builder = LootTable.lootTable();

        // 创建战利品池并设置数量函数
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .apply(SetItemCountFunction.setCount(countProvider))
                .add(LootItem.lootTableItem(item));
        builder.withPool(this.applyExplosionCondition(item, pool));
        return builder;
    }

    /**
     * 为结果藤蔓方块添加战利品表
     * <p>
     * 仅当藤蔓的指定布尔属性为 true（已结果）时才掉落浆果物品
     * 用于迷梦果藤等需要条件掉落的藤蔓植物
     *
     * @param block      藤蔓方块
     * @param berryItem  浆果物品（掉落物）
     * @param property   判断是否结果的布尔属性（如 HAS_FRUIT）
     */
    private void vinesWithBerries(Block block, ItemLike berryItem, BooleanProperty property) {
        this.add(block, blockState ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, true)))
                                .add(LootItem.lootTableItem(berryItem)))
        );
    }
}
