package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 铁砧粉碎配方
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class AnvilDropRecipe {

    // 配方映射：输入物品 -> 配方数据
    private static final Map<Item, RecipeData> RECIPES = new HashMap<>();

    // 标记是否已初始化
    private static boolean initialized = false;

    // 初始化配方
    private static void initRecipes() {
        if (!initialized) {
            // 格式：registerRecipe(输入物品，最小输入数量，最大输入数量，输出物品，每个产出最小值，每个产出最大值)
            if (ModList.get().isLoaded("the_bumblezone")) {
                registerRecipeIfEnabled(Items.TUFF, 1, 1, TheBumblezoneItems.CARBOCRETIN_POWDER, ServerConfig.ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT, ServerConfig.ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT);
            }



            initialized = true;
        }
    }

    /**
     * 条件注册配方（配置为0时不注册）
     */
    private static void registerRecipeIfEnabled(Item input, int minInput, int maxInput, Supplier<Item> output,
                                                ModConfigSpec.IntValue minOutputConfig, ModConfigSpec.IntValue maxOutputConfig) {
        int minOutput = minOutputConfig.get();
        int maxOutput = maxOutputConfig.get();

        if (minOutput > 0 || maxOutput > 0) {
            registerRecipe(input, minInput, maxInput, output, minOutput, maxOutput);
        }
    }

    /**
     * 注册配方
     * @param input 输入物品
     * @param minInput 最小输入数量
     * @param maxInput 最大输入数量
     * @param output 输出物品 Supplier
     * @param minOutputPerInput 每个输入产出最小值
     * @param maxOutputPerInput 每个输入产出最大值
     */
    public static void registerRecipe(Item input, int minInput, int maxInput, Supplier<Item> output, int minOutputPerInput, int maxOutputPerInput) {
        RECIPES.put(input, new RecipeData(output.get(), minInput, maxInput, minOutputPerInput, maxOutputPerInput));
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        // 确保配方已初始化
        initRecipes();

        Entity entity = event.getEntity();

        if (entity instanceof FallingBlockEntity fallingBlock) {
            // 检查是否是铁砧
            if (!isAnvil(fallingBlock.getBlockState().getBlock())) {
                return;
            }

            Level level = fallingBlock.level();
            BlockPos pos = fallingBlock.blockPosition();

            // 使用 AABB 搜寻下方很近的物品（确保已经接触）
            net.minecraft.world.phys.AABB searchBox = fallingBlock.getBoundingBox().inflate(0.3).move(0, -0.2, 0);

            for (Entity nearbyEntity : level.getEntities(fallingBlock, searchBox)) {
                if (nearbyEntity instanceof ItemEntity itemEntity) {
                    ItemStack itemStack = itemEntity.getItem();
                    Item inputItem = itemStack.getItem();

                    // 检查是否有对应的配方
                    if (RECIPES.containsKey(inputItem)) {
                        // 检查距离，确保真的接触了
                        double distance = fallingBlock.distanceTo(itemEntity);
                        if (distance > 0.8) {
                            continue;
                        }

                        int inputAmount = itemStack.getCount();
                        RecipeData recipe = RECIPES.get(inputItem);

                        // 智能匹配：只要数量在范围内就转换
                        // 如果超过最大范围，按最大范围的倍数分批处理
                        int totalOutput = 0;
                        int remaining = inputAmount;

                        while (remaining > 0) {
                            // 计算本次处理的數量（不超过 maxInput）
                            int currentBatch = Math.min(remaining, recipe.maxInput);

                            // 检查是否达到最小输入要求
                            if (currentBatch >= recipe.minInput) {
                                // 计算这次的输出
                                for (int i = 0; i < currentBatch; i++) {
                                    totalOutput += recipe.minOutput + level.random.nextInt(
                                            recipe.maxOutput - recipe.minOutput + 1
                                    );
                                }
                                remaining -= currentBatch;
                            } else {
                                // 剩余数量不足最小要求，停止处理
                                break;
                            }
                        }

                        if (totalOutput <= 0) {
                            continue; // 没有成功转换
                        }

                        // 消耗输入物品
                        itemEntity.discard();

                        // 掉落输出物品
                        popResource(level, pos, new ItemStack(recipe.output, totalOutput));
                    }
                }
            }
        }
    }

    /**
     * 检查是否是铁砧类方块
     */
    private static boolean isAnvil(net.minecraft.world.level.block.Block block) {
        return block == Blocks.ANVIL ||
                block == Blocks.CHIPPED_ANVIL ||
                block == Blocks.DAMAGED_ANVIL;
    }

    private static void popResource(Level level, BlockPos pos, ItemStack stack) {
        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;

        net.minecraft.world.entity.item.ItemEntity entity = new net.minecraft.world.entity.item.ItemEntity(level, x, y, z, stack);
        entity.setDefaultPickUpDelay();
        level.addFreshEntity(entity);
    }

    /**
     * 配方数据类
     */
    private static class RecipeData {
        public final Item output;
        public final int minInput;
        public final int maxInput;
        public final int minOutput;
        public final int maxOutput;

        public RecipeData(Item output, int minInput, int maxInput, int minOutput, int maxOutput) {
            this.output = output;
            this.minInput = minInput;
            this.maxInput = maxInput;
            this.minOutput = minOutput;
            this.maxOutput = maxOutput;
        }
    }
}
