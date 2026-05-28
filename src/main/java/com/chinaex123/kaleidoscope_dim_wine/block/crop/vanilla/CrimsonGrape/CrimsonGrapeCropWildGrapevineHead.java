package com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;

/**
 * 绯红葡萄藤作物方块 - 向下生长的藤蔓植物顶部方块
 * <p>
 * 支持骨粉催熟和剪刀修剪，修剪后停止生长
 */
public class CrimsonGrapeCropWildGrapevineHead extends GrowingPlantHeadBlock implements BonemealableBlock {
    public static final MapCodec<CrimsonGrapeCropWildGrapevineHead> CODEC = simpleCodec((p) -> new CrimsonGrapeCropWildGrapevineHead());
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public CrimsonGrapeCropWildGrapevineHead() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false, 0.15);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SHEARED, false));
    }

    /**
     * 处理玩家使用物品右键点击绯红葡萄藤头部的逻辑
     * <p>
     * 当玩家手持剪刀时，可以修剪藤蔓：
     * - 已修剪的藤蔓不执行任何操作
     * - 未修剪的藤蔓设置为 SHEARED 状态，阻止其继续生长
     * - 消耗剪刀耐久度
     * - 播放剪羊毛音效
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
        // 检查是否为剪刀
        if (stack.canPerformAction(ItemAbilities.SHEARS_CARVE)) {
            // 已修剪则不处理
            if (state.getValue(SHEARED)) {
                return ItemInteractionResult.CONSUME;
            } else {
                // 修剪藤蔓并设置状态
                level.setBlockAndUpdate(pos, state.setValue(SHEARED, true));
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                player.playSound(SoundEvents.SHEEP_SHEAR);
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    /**
     * 创建绯红葡萄藤头部的方块状态定义
     * <p>
     * 添加 SHEARED 属性，用于标记藤蔓是否被剪刀修剪过
     * 修剪后的藤蔓将停止向下生长
     *
     * @param builder 方块状态构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHEARED);
    }

    /**
     * 检查绯红葡萄藤头部方块是否能在指定位置生存
     * <p>
     * 验证上方方块是否为以下类型之一：
     * - 绯红葡萄藤头部方块
     * - 绯红葡萄藤身体方块
     * - 可附着的方块（树叶、藤架等）
     * - 具有坚固表面的方块
     *
     * @param state 当前方块状态
     * @param level 世界读取器
     * @param pos   方块位置
     * @return 如果方块能在此位置生存则返回 true，否则返回 false
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 获取上方相邻方块的位置和状态
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);

        // 检查上方方块是否满足生存条件
        return relativeState.is(KDWBlocks.CRIMSON_GRAPEVINE.get()) ||
                relativeState.is(KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    /**
     * 检查绯红葡萄藤头部是否能附着到指定方块上
     * <p>
     * 允许附着到以下类型的方块：
     * - 树叶（任意类型）
     * - 模组中的标准藤架方块
     * - 任何实现 GrapevineTrellisBlock 的藤架方块
     *
     * @param state 目标方块的状态
     * @return 如果藤蔓可以附着到该方块则返回 true，否则返回 false
     */
    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof GrapevineTrellisBlock;
    }

    /**
     * 绯红葡萄藤头部的随机刻逻辑
     * <p>
     * 当藤蔓未被修剪时，调用父类的生长逻辑使其向下延伸
     * 被剪刀修剪过的藤蔓（SHEARED=true）将停止自然生长
     *
     * @param state   当前方块状态
     * @param level   服务器世界等级
     * @param pos     方块位置
     * @param random  随机数生成器
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 只有未修剪的藤蔓才能自然生长
        if (!(Boolean)state.getValue(SHEARED)) {
            super.randomTick(state, level, pos, random);
        }
    }

    /**
     * 检查绯红葡萄藤头部是否是有效的骨粉目标
     * <p>
     * 验证条件：
     * - 藤蔓未被剪刀修剪（SHEARED=false）
     * - 满足父类的骨粉目标条件（可以向下生长）
     *
     * @param level 世界读取器
     * @param pos   方块位置
     * @param state 当前方块状态
     * @return 如果可以被骨粉催熟则返回 true，否则返回 false
     */
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !(Boolean)state.getValue(SHEARED) && super.isValidBonemealTarget(level, pos, state);
    }

    /**
     * 获取使用骨粉时绯红葡萄藤头部每次催熟生长的方块数量
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
     * 检查绯红葡萄藤头部是否能生长到指定方块位置
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
     * 返回绯红葡萄藤的身体方块实例，用于藤蔓向下生长时生成新的节段
     *
     * @return 绯红葡萄藤身体方块实例
     */
    @Override
    protected Block getBodyBlock() {
        return KDWBlocks.CRIMSON_GRAPEVINE_PLANT.get();
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
