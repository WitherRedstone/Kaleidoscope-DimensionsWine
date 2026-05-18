package com.chinaex123.kaleidoscope_dim_wine.block.crop.compat.Twilightforest.FrostheartFruit;

import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Collections;
import java.util.List;

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

        // 下方直接是雪块
        if (belowState.is(Blocks.SNOW_BLOCK)) {
            return true;
        }

        // 下方是雪层，且雪层下方是雪块
        if (belowState.is(Blocks.SNOW)) {
            BlockPos furtherBelowPos = belowPos.below();
            BlockState furtherBelowState = level.getBlockState(furtherBelowPos);
            return furtherBelowState.is(Blocks.SNOW_BLOCK);
        }

        return false;
    }

    /**
     * 处理玩家空手右键点击霜心果灌木的逻辑
     * <p>
     * **不同生长阶段的交互行为**：
     * - **AGE=0/1（幼苗期）**：交由父类处理，通常无反应
     * - **AGE=2（生长期）**：直接返回成功，但不执行收获（防止误触）
     * - **AGE=3（成熟期）**：执行收获操作
     *   - 重置年龄为 1
     *   - 播放采摘音效
     *   - 掉落霜心果物品
     *
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hitResult  命中结果信息
     * @return 交互结果，根据生长阶段返回 SUCCESS 或交由父类处理
     */
    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int age = state.getValue(AGE);

        // age=2 时，空手右键直接返回成功
        if (age == 2) {
            return InteractionResult.SUCCESS;
        }

        // age=3 时，自己处理收获
        if (age == 3) {
            if (!level.isClientSide) {
                level.setBlock(pos, state.setValue(AGE, 1), 2);
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                popResource(level, pos, new ItemStack(TwilightforestItems.FROSTHEART_FRUIT.get()));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        // age=0 或 1 时，交给父类处理
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    /**
     * 处理玩家使用物品右键点击霜心果灌木的逻辑
     * <p>
     * 直接委托给父类处理，不添加额外的物品交互逻辑
     * 通常用于处理骨粉催熟等通用行为
     *
     * @param stack      被使用的物品
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hand       使用的手（主手或副手）
     * @param hitResult  命中结果信息
     * @return 父类的交互结果
     */
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    /**
     * 获取玩家中键拾取此方块时获得的物品
     * <p>
     * 返回霜心果物品，用于创造模式下的方块复制
     *
     * @param state   当前方块状态
     * @param target  命中结果信息
     * @param level   世界读取器
     * @param pos     方块位置
     * @param player  执行拾取的玩家
     * @return 包含霜心果物品的 ItemStack
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(TwilightforestItems.FROSTHEART_FRUIT.get());
    }

    /**
     * 获取霜心果灌木被破坏时的掉落物列表
     * <p>
     * **掉落规则**：
     * - 仅当灌木成熟（AGE=3）时，掉落 1 个霜心果
     * - 未成熟的灌木不掉落任何物品
     *
     * @param state 当前方块状态
     * @param params 战利品参数构建器
     * @return 包含掉落物的列表，未成熟时返回空列表
     */
    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        // 只有成熟时才掉落果实
        if (state.getValue(AGE) == 3) {
            return Collections.singletonList(new ItemStack(TwilightforestItems.FROSTHEART_FRUIT.get()));
        }
        return Collections.emptyList();
    }

    /**
     * 执行骨粉对霜心果灌木的催熟效果
     * <p>
     * **催熟逻辑**：
     * - 当灌木年龄小于 3（未成熟）时，增加 1 点年龄值
     * - 已达到最大年龄（AGE=3）时不执行任何操作
     *
     * @param level  服务器世界等级
     * @param random 随机数生成器
     * @param pos    方块位置
     * @param state  当前方块状态
     */
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = state.getValue(AGE);

        // 未成熟时增加年龄
        if (age < 3) {
            level.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }
}
