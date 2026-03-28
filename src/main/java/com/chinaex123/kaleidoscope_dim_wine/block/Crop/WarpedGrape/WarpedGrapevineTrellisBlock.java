package com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.block.properties.TrellisType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.CommonHooks;

/**
 * 诡异葡萄藤 - 可以种植在普通藤架上的藤蔓作物
 * 使用方式：手持诡异葡萄藤右键普通藤架，藤架会变成此方块
 */
public class WarpedGrapevineTrellisBlock extends GrapevineTrellisBlock {

    public WarpedGrapevineTrellisBlock() {
        super();
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 检查周围是否有藤架类方块
        for (Direction dir : Direction.values()) {
            BlockState neighbor = level.getBlockState(pos.relative(dir));
            if (neighbor.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                    neighbor.getBlock() instanceof GrapevineTrellisBlock) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doGrow(Level level, BlockPos pos, BlockState state) {
        // 如果是 single 状态
        if (state.getValue(TYPE) == TrellisType.SINGLE) {
            // 先检查下方是否满足生长条件
            BlockState belowState = level.getBlockState(pos.below());
            if (!belowSupportGrow(belowState)) {
                return;
            }
            // 如果没有达到最大年龄，直接增加年龄
            if (!isMaxAge(state)) {
                level.setBlockAndUpdate(pos, state.cycle(AGE));
                CommonHooks.fireCropGrowPost(level, pos, state);
                return;
            }
        }

        // 如果已经达到最大年龄，此时尝试往各个方向检查
        if (isMaxAge(state)) {
            for (Direction direction : CHECK_DIRECTION) {
                BlockPos checkPos = pos.relative(direction);
                BlockState checkState = level.getBlockState(checkPos);
                if (this.canGrowInto(checkState)) {
                    BlockState growIntoState = this.getGrowIntoState(direction, checkState);
                    level.setBlockAndUpdate(checkPos, growIntoState);
                    CommonHooks.fireCropGrowPost(level, checkPos, checkState);
                    return;
                }
            }

            // 如果所有方向都检查完了都不能生长，那么检查下方是否有两格空位，生长葡萄
            if (canGrowGrape(level, pos)) {
                // 生成绯红葡萄果实
                level.setBlockAndUpdate(pos.below(), ModBlocks.WARPED_GRAPE_CROP.get().defaultBlockState());
                CommonHooks.fireCropGrowPost(level, pos.below(), state);
            }
        } else {
            // 其他朝向的，直接加满
            level.setBlockAndUpdate(pos, state.setValue(AGE, MAX_AGE));
            CommonHooks.fireCropGrowPost(level, pos, state);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.WARPED_GRAPEVINE.get());
    }
}
