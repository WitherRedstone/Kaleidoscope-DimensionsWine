package com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Dreamfruit;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;

/**
 * 迷梦果藤作物方块 - 向下生长的藤蔓植物顶部方块
 * <p>
 * 支持骨粉催熟和剪刀修剪，修剪后停止生长
 * <p>
 * 成熟后会结出迷梦果，右键点击可收获
 */
public class DreamfruitCropWildVineHead extends GrowingPlantHeadBlock implements BonemealableBlock {
    public static final MapCodec<DreamfruitCropWildVineHead> CODEC = simpleCodec((p) -> new DreamfruitCropWildVineHead());
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public DreamfruitCropWildVineHead() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false, 0.15);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SHEARED, false).setValue(HAS_FRUIT, false));
    }

    /**
     * 处理玩家空手右键点击迷梦果藤头部的逻辑
     * <p>
     * 当藤蔓结果时（HAS_FRUIT=true），执行收获操作：
     * - 掉落 1 个迷梦果
     * - 播放采摘浆果的音效（音量随机）
     * - 将方块状态设置为未结果
     * - 触发方块变更游戏事件
     *
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hit        命中结果信息
     * @return 如果成功收获则返回 SUCCESS，否则返回 PASS
     */
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        // 检查是否结果，如果结果则进行收获
        if (state.getValue(HAS_FRUIT)) {
            // 掉落产物并播放音效
            Block.popResource(level, pos, new ItemStack(KDWItems.DREAMFRUIT.get(), 1));
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState newState = state.setValue(HAS_FRUIT, Boolean.FALSE);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    /**
     * 处理玩家使用物品右键点击迷梦果藤头部的逻辑
     * <p>
     * **迷梦果种植**：
     * - 手持迷梦果时，可在藤蔓下方延伸新的节段
     * - 优先尝试放置头部方块，若无法生存则改用身体方块
     * - 创造模式下不消耗物品
     * <p>
     * **剪刀修剪**：
     * - 使用剪刀修剪藤蔓，设置 SHEARED 状态阻止生长
     * - 同时清除果实状态（HAS_FRUIT=false）
     * - 已修剪的藤蔓不再响应剪刀操作
     *
     * @param stack      被使用的物品
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hand       使用的手（主手或副手）
     * @param hitResult  命中结果信息
     * @return 交互结果，成功则返回 SUCCESS，已修剪则返回 CONSUME，否则交由父类处理
     */
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 手持迷梦果时，尝试向下延伸藤蔓
        if (stack.is(KDWItems.DREAMFRUIT.get())) {
            BlockPos below = pos.relative(this.growthDirection);
            BlockState belowState = level.getBlockState(below);

            if (belowState.isAir() || belowState.canBeReplaced()) {
                // 放置头部方块（新的藤蔓顶部）
                BlockState headState = KDWBlocks.DREAMFRUIT_VINE.get().defaultBlockState();
                if (headState.canSurvive(level, below)) {
                    level.setBlockAndUpdate(below, headState);
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }

                // 如果头部不能生存，改放身体方块
                BlockState plantState = KDWBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
                if (plantState.canSurvive(level, below)) {
                    level.setBlockAndUpdate(below, plantState);
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        // 使用剪刀修剪藤蔓
        if (stack.canPerformAction(ItemAbilities.SHEARS_CARVE)) {
            if (state.getValue(SHEARED)) {
                return ItemInteractionResult.CONSUME;
            } else {
                level.setBlockAndUpdate(pos, state.setValue(SHEARED, true).setValue(HAS_FRUIT, false));
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                player.playSound(SoundEvents.SHEEP_SHEAR);
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    /**
     * 创建迷梦果藤头部的方块状态定义
     * <p>
     * 添加以下属性到方块状态：
     * - SHEARED：标记藤蔓是否被剪刀修剪过（修剪后停止生长）
     * - HAS_FRUIT：标记藤蔓是否结有果实（可收获）
     *
     * @param builder 方块状态构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHEARED, HAS_FRUIT);
    }

    /**
     * 检查迷梦果藤头部方块是否能在指定位置生存
     * <p>
     * 验证上方方块是否为以下类型之一：
     * - 迷梦果藤头部方块
     * - 迷梦果藤身体方块
     * - 末地石（END_STONE）
     * - 紫珀块（PURPUR_BLOCK）
     * <p>
     * 藤蔓必须依附于这些特定方块才能存在
     *
     * @param state 当前方块状态
     * @param level 世界读取器
     * @param pos   方块位置
     * @return 如果方块能在此位置生存则返回 true，否则返回 false
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 获取上方相邻方块的状态
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);

        // 检查是否为同种藤蔓的节段
        if (relativeState.is(KDWBlocks.DREAMFRUIT_VINE.get()) ||
                relativeState.is(KDWBlocks.DREAMFRUIT_VINE_PLANT.get())) {
            return true;
        }

        // 检查是否为末地石或紫珀块
        boolean isEndStone = relativeState.is(Blocks.END_STONE);
        boolean isPurpur = relativeState.is(Blocks.PURPUR_BLOCK);

        return isEndStone || isPurpur;
    }

    /**
     * 检查迷梦果藤头部是否能附着到指定方块上
     * <p>
     * 允许附着到以下类型的方块：
     * - 树叶（任意类型，BlockTags.LEAVES）
     * - 模组中的标准藤架方块
     * - 任何实现 GrapevineTrellisBlock 的藤架方块
     *
     * @param state 目标方块的状态
     * @return 如果藤蔓可以附着到该方块则返回 true，否则返回 false
     */
    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof GrapevineTrellisBlock;
    }

    /**
     * 获取玩家中键拾取此方块时获得的物品
     * <p>
     * 返回迷梦果物品，用于创造模式下的方块复制
     *
     * @param state   当前方块状态
     * @param target  命中结果信息
     * @param level   世界读取器
     * @param pos     方块位置
     * @param player  执行拾取的玩家
     * @return 包含迷梦果物品的 ItemStack
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(KDWItems.DREAMFRUIT.get());
    }

    /**
     * 迷梦果藤头部的随机刻生长逻辑
     * <p>
     * 生长流程：
     * 1. **修剪检查**：被剪刀修剪过的藤蔓（SHEARED=true）停止所有生长
     * <p>
     * 2. **成熟阶段（AGE≥25）**：
     *    - 若未结果，则将 HAS_FRUIT 设为 true，使藤蔓结果
     * <p>
     * 3. **生长期（AGE<25）**：
     *    - 下方为空气且可生长时，调用父类方法向下延伸
     *    - 若无法生长（有阻挡），则有 20% 概率（1/5）直接结果
     *
     * @param state   当前方块状态
     * @param level   服务器世界等级
     * @param pos     方块位置
     * @param random  随机数生成器
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 只有未修剪的藤蔓才能生长
        if (!(Boolean)state.getValue(SHEARED)) {
            // 年龄达到 25 时，开始结果
            if (state.getValue(AGE) >= 25) {
                if (!state.getValue(HAS_FRUIT)) {
                    level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
                }
            } else {
                // 年龄未满 25 时，尝试向下生长或提前结果
                BlockPos below = pos.relative(this.growthDirection);
                BlockState belowState = level.getBlockState(below);

                if ((belowState.isAir() || belowState.canBeReplaced()) && this.canGrowInto(belowState)) {
                    super.randomTick(state, level, pos, random);
                } else if (!state.getValue(HAS_FRUIT) && random.nextInt(5) == 0) {
                    level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
                }
            }
        }
    }

    /**
     * 检查迷梦果藤头部是否是有效的骨粉目标
     * <p>
     * 固定返回 true，表示藤蔓头部始终可以成为骨粉的目标
     * 实际的催熟效果由 isBonemealSuccess 和 performBonemeal 方法控制
     *
     * @param level 世界读取器
     * @param pos   方块位置
     * @param state 当前方块状态
     * @return 始终返回 true
     */
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    /**
     * 检查骨粉催熟迷梦果藤头部是否成功
     * <p>
     * 固定返回 true，表示骨粉催熟始终会成功
     * 具体的催熟效果（生长或结果）由 performBonemeal 方法实现
     *
     * @param level  游戏世界
     * @param random 随机数生成器
     * @param pos    方块位置
     * @param state  当前方块状态
     * @return 始终返回 true
     */
    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    /**
     * 执行骨粉对迷梦果藤头部的催熟效果
     * <p>
     * 催熟逻辑：
     * 1. **成熟阶段（AGE≥25）**：
     *    - 若未结果，则将 HAS_FRUIT 设为 true，使藤蔓立即结果
     * <p>
     * 2. **生长期（AGE<25）**：
     *    - 尝试向下生长，每次增长 1 格（由 getBlocksToGrowWhenBonemealed 决定）
     *    - 每生长一节，AGE 值增加 1，上限为 25
     *    - 若无法生长（k=0，遇到阻挡），则有概率直接结果
     *
     * @param level  服务器世界等级
     * @param random 随机数生成器
     * @param pos    方块位置
     * @param state  当前方块状态
     */
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // 年龄达到 25 时，直接结果
        if (state.getValue(AGE) >= 25) {
            if (!state.getValue(HAS_FRUIT)) {
                level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
            }
        } else {
            // 年龄未满 25 时，尝试向下生长
            BlockPos blockpos = pos.relative(this.growthDirection);
            int i = Math.min(state.getValue(AGE) + 1, 25);
            int j = this.getBlocksToGrowWhenBonemealed(random);

            int k;
            for(k = 0; k < j && this.canGrowInto(level.getBlockState(blockpos)); ++k) {
                level.setBlockAndUpdate(blockpos, state.setValue(AGE, i));
                blockpos = blockpos.relative(this.growthDirection);
                i = Math.min(i + 1, 25);
            }

            // 如果无法生长且未结果，则直接结果
            if (k == 0 && !state.getValue(HAS_FRUIT)) {
                level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
            }
        }
    }

    /**
     * 获取使用骨粉时迷梦果藤头部每次催熟生长的方块数量
     * <p>
     * 固定返回 1，表示每次骨粉催熟会让藤蔓向下生长 1 格
     *
     * @param randomSource 随机数生成器（未使用）
     * @return 生长步数，固定为 1
     */
    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return 1;
    }

    /**
     * 检查迷梦果藤头部是否能生长到指定方块位置
     * <p>
     * 只有当目标位置为空气时才能生长，确保藤蔓不会替换其他方块
     *
     * @param state 目标位置的方块状态
     * @return 如果目标位置是空气则返回 true，否则返回 false
     */
    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    /**
     * 获取与此头部方块关联的身体方块
     * <p>
     * 返回迷梦果藤的身体方块实例，用于藤蔓向下生长时生成新的节段
     *
     * @return 迷梦果藤身体方块实例
     */
    @Override
    protected Block getBodyBlock() {
        return KDWBlocks.DREAMFRUIT_VINE_PLANT.get();
    }

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    static {
        PROPERTIES = Properties.of()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .noCollission()
                .instabreak()
                .sound(SoundType.CAVE_VINES)
                .pushReaction(PushReaction.DESTROY);
    }
}
