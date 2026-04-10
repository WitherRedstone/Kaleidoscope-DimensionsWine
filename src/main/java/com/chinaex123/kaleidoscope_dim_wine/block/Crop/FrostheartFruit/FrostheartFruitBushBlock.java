package com.chinaex123.kaleidoscope_dim_wine.block.Crop.FrostheartFruit;

import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * 霜心果丛方块 - 类似甜浆果丛的作物方块
 * <p>
 * 成熟后右键可收获霜心果，只能种植在雪块上
 */
public class FrostheartFruitBushBlock extends SweetBerryBushBlock {
    public FrostheartFruitBushBlock() {
        super(Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    }

    /**
     * 检查霜心果灌木是否能在指定位置生存
     * <p>
     * **生存条件**：
     * - 下方直接是雪块（SNOW_BLOCK）
     * - 或者下方是雪层（SNOW），且雪层下方是雪块
     * <p>
     * 该植物仅能生长在雪块之上，确保其只在寒冷的雪地环境中存活
     *
     * @param state 当前方块状态
     * @param level 世界读取器
     * @param pos   方块位置
     * @return 如果满足生存条件则返回 true，否则返回 false
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 获取下方方块的状态
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        // 情况1：下方直接是雪块
        if (belowState.is(Blocks.SNOW_BLOCK)) {
            return true;
        }

        // 情况2：下方是雪层，且雪层下方是雪块
        if (belowState.is(Blocks.SNOW)) {
            BlockPos furtherBelowPos = belowPos.below();
            BlockState furtherBelowState = level.getBlockState(furtherBelowPos);
            return furtherBelowState.is(Blocks.SNOW_BLOCK);
        }

        return false;
    }

    /**
     * 处理玩家使用物品右键点击霜心果灌木的逻辑
     * <p>
     * **收获逻辑**：
     * - 仅当灌木成熟（AGE=3）时允许收获
     * - 未成熟时交由父类处理（通常无反应）
     *
     * **收获效果**：
     * - 将灌木年龄重置为 1（保留幼苗状态，可继续生长）
     * - 播放采摘浆果的音效（音调随机）
     * - 掉落 1 个霜心果物品
     *
     * @param stack      被使用的物品
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hand       使用的手（主手或副手）
     * @param hitResult  命中结果信息
     * @return 交互结果，成功则返回 SUCCESS，否则交由父类处理
     */
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 获取当前年龄并检查是否成熟
        int age = state.getValue(AGE);
        boolean isMature = age == 3;

        // 未成熟时不处理
        if (!isMature) {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }

        // 服务端执行收获逻辑
        if (!level.isClientSide) {
            // 重置年龄为 1
            level.setBlock(pos, state.setValue(AGE, 1), 2);

            // 播放采摘音效
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            // 掉落霜心果
            ItemStack frostheartFruit = new ItemStack(TwilightforestItems.FROSTHEART_FRUIT.get());
            popResource(level, pos, frostheartFruit);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(TwilightforestItems.FROSTHEART_FRUIT.get());
    }
}
