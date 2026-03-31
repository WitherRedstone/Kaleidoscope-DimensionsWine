package com.chinaex123.kaleidoscope_dim_wine.event.Crop;

import com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape.WarpedGrapevineTrellisBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
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
 * 绯红葡萄藤物品 - 右键普通藤架时，将其替换为绯红葡萄藤
 */
public class WarpedGrapevineItem extends Item {

    public WarpedGrapevineItem() {
        super(new Properties());
    }

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
                    BlockState headBlockState = ModBlocks.WARPED_GRAPEVINE.get().defaultBlockState();
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
                        BlockState plantBlockState = ModBlocks.WARPED_GRAPEVINE_PLANT.get().defaultBlockState();
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
            if (plantState.is(ModBlocks.WARPED_GRAPEVINE_PLANT.get()) ||
                    plantState.is(ModBlocks.WARPED_GRAPEVINE.get())) {
                BlockPos furtherBelowPos = plantPos.below();
                BlockState furtherBelowState = level.getBlockState(furtherBelowPos);

                if (furtherBelowState.isAir()) {
                    if (!level.isClientSide) {
                        BlockState newPlantState = ModBlocks.WARPED_GRAPEVINE_PLANT.get().defaultBlockState();
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
            if (!belowTrellis.is(Blocks.WARPED_NYLIUM)) {
                return InteractionResult.FAIL;
            }

            if (!level.isClientSide) {
                // 获取藤架的朝向和含水状态
                BlockState newState = ModBlocks.WARPED_GRAPEVINE_TRELLIS.get()
                        .defaultBlockState();

                // 复制藤架的属性（如果有）
                if (state.hasProperty(GrapevineTrellisBlock.TYPE)) {
                    newState = newState.setValue(WarpedGrapevineTrellisBlock.TYPE,
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
