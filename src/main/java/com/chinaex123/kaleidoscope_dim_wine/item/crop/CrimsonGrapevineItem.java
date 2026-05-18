package com.chinaex123.kaleidoscope_dim_wine.item.crop;

import com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape.CrimsonGrapevineTrellisBlock;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

/**
 * 绯红葡萄藤物品 - 用于种植绯红葡萄藤的种子
 * <p>
 * 可放置在绯红葡萄藤架或下界疣块上，点击方块底部会向下生长藤蔓
 */
public class CrimsonGrapevineItem extends Item {

    public CrimsonGrapevineItem() {
        super(new Item.Properties());
    }

    /**
     * 处理绯红葡萄藤物品右键点击方块的使用逻辑
     * <p>
     * **种植模式**（点击方块底部）：
     * 1. **向下种植藤蔓**：
     *    - 检测下方是否为空气，是则种植绯红葡萄藤
     *    - 优先放置头部方块（藤蔓顶部），若无法生存则改用身体方块
     *    - 非创造模式下消耗物品
     * <p>
     * 2. **延伸现有藤蔓**：
     *    - 若下方已是藤蔓节段，继续向下延伸身体方块
     *    - 检查更下方的空间是否可用
     * <p>
     * **替换模式**（点击普通藤架）：
     * - 仅当藤架下方为绯红菌岩时才允许替换
     * - 将普通藤架升级为绯红葡萄藤架
     * - 保留原藤架的类型（TYPE）和含水（WATERLOGGED）属性
     * - 消耗绯红葡萄藤物品
     *
     * @param context 使用上下文（包含玩家、物品、位置等信息）
     * @return 交互结果：成功则返回 SUCCESS，失败则返回 FAIL 或交由父类处理
     */
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Direction clickedFace = context.getClickedFace();

        // 如果点击的是方块的底部（向上点击）
        if (clickedFace == Direction.DOWN) {
            BlockPos plantPos = pos.below();
            BlockState plantState = level.getBlockState(plantPos);

            // 如果下方是空气，尝试种植植物
            if (plantState.isAir()) {
                if (!level.isClientSide) {
                    // 优先放置头部方块（藤蔓顶部）
                    BlockState headBlockState = KDWBlocks.CRIMSON_GRAPEVINE.get().defaultBlockState();
                    if (headBlockState.canSurvive(level, plantPos)) {
                        // 在下方种植植物
                        level.setBlockAndUpdate(plantPos, headBlockState);

                        // 如果不是创造模式，消耗物品
                        ItemStack stack = context.getItemInHand();
                        if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                            stack.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    } else {
                        // 头部不能生存，改放身体方块
                        BlockState plantBlockState = KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get().defaultBlockState();
                        if (plantBlockState.canSurvive(level, plantPos)) {
                            level.setBlockAndUpdate(plantPos, plantBlockState);

                            ItemStack stack = context.getItemInHand();
                            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                                stack.shrink(1);
                            }
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
                return InteractionResult.SUCCESS;
            }

            // 如果下方已经是植物方块，继续向下延伸
            if (plantState.is(KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get()) ||
                    plantState.is(KDWBlocks.CRIMSON_GRAPEVINE.get())) {
                BlockPos furtherBelowPos = plantPos.below();
                BlockState furtherBelowState = level.getBlockState(furtherBelowPos);

                if (furtherBelowState.isAir()) {
                    if (!level.isClientSide) {
                        BlockState newPlantState = KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get().defaultBlockState();
                        if (newPlantState.canSurvive(level, furtherBelowPos)) {
                            level.setBlockAndUpdate(furtherBelowPos, newPlantState);

                            ItemStack stack = context.getItemInHand();
                            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                                stack.shrink(1);
                            }
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }

        // 如果点击的是普通藤架
        if (state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get())) {
            // 检查藤架下方是否是草方块
            BlockState belowTrellis = level.getBlockState(pos.below());
            if (!belowTrellis.is(Blocks.CRIMSON_NYLIUM)) {
                return InteractionResult.FAIL;
            }

            if (!level.isClientSide) {
                // 获取藤架的朝向和含水状态
                BlockState newState = KDWBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()
                        .defaultBlockState();

                // 复制藤架的属性
                if (state.hasProperty(GrapevineTrellisBlock.TYPE)) {
                    newState = newState.setValue(CrimsonGrapevineTrellisBlock.TYPE,
                            state.getValue(GrapevineTrellisBlock.TYPE));
                }
                if (state.hasProperty(GrapevineTrellisBlock.WATERLOGGED)) {
                    BooleanProperty waterlogged = GrapevineTrellisBlock.WATERLOGGED;
                    if (newState.hasProperty(waterlogged)) {
                        newState = newState.setValue(waterlogged, state.getValue(waterlogged));
                    }
                }

                level.setBlockAndUpdate(pos, newState);

                // 消耗物品
                ItemStack stack = context.getItemInHand();
                if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                    stack.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return super.useOn(context);
    }
}
