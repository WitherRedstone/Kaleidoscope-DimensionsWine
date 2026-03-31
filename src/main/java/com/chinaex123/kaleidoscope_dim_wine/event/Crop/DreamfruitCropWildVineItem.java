package com.chinaex123.kaleidoscope_dim_wine.event.Crop;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DreamfruitCropWildVineItem  extends Item {

    public DreamfruitCropWildVineItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Direction clickedFace = context.getClickedFace();

        // 如果点击的是方块的底部（向上点击）
        if (clickedFace == Direction.DOWN) {
            // 检查点击的方块是否是末地石或紫珀块
            boolean isEndStone = state.is(Blocks.END_STONE);
            boolean isPurpur = state.is(Blocks.PURPUR_BLOCK);

            if (!isEndStone && !isPurpur) {
                return InteractionResult.FAIL;
            }

            BlockPos plantPos = pos.below();
            BlockState plantState = level.getBlockState(plantPos);

            // 如果下方是空气，尝试种植植物
            if (plantState.isAir()) {
                if (!level.isClientSide) {
                    // 优先放置头部方块（藤蔓顶部）
                    BlockState headBlockState = ModBlocks.DREAMFRUIT_VINE.get().defaultBlockState();
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
                        BlockState plantBlockState = ModBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
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
            if (plantState.is(ModBlocks.DREAMFRUIT_VINE_PLANT.get()) ||
                    plantState.is(ModBlocks.DREAMFRUIT_VINE.get())) {
                BlockPos furtherBelowPos = plantPos.below();
                BlockState furtherBelowState = level.getBlockState(furtherBelowPos);

                if (furtherBelowState.isAir()) {
                    if (!level.isClientSide) {
                        BlockState newPlantState = ModBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
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

        return super.useOn(context);
    }
}
