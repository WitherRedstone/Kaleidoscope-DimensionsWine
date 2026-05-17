package com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
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
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 迷梦果藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成果藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 * <p>
 * 每个节段都能结果，右键点击可收获迷梦果
 */
public class DreamfruitCropWildVinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public DreamfruitCropWildVinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_FRUIT, false));
    }

    /**
     * 创建迷梦果藤身体方块的方块状态定义
     * <p>
     * 添加 HAS_FRUIT 属性到方块状态，用于标记藤蔓是否结有果实（可收获）
     *
     * @param builder 方块状态构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HAS_FRUIT);
    }

    /**
     * 检查迷梦果藤身体方块是否能在指定位置生存
     * <p>
     * 验证上方方块是否为以下类型之一：
     * - 迷梦果藤头部方块
     * - 迷梦果藤身体方块
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
        return relativeState.is(ModBlocks.DREAMFRUIT_VINE.get()) ||
                relativeState.is(ModBlocks.DREAMFRUIT_VINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    /**
     * 检查迷梦果藤身体方块是否能附着到指定方块上
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
     * 获取与此身体方块关联的头部方块
     * <p>
     * 返回迷梦果藤的头部方块实例，用于藤蔓生长系统的内部逻辑
     *
     * @return 迷梦果藤头部方块实例
     */
    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.DREAMFRUIT_VINE.get();
    }

    /**
     * 检查迷梦果藤身体方块是否是有效的骨粉目标
     * <p>
     * 固定返回 true，表示身体方块始终可以成为骨粉的目标
     * 实际的催熟效果（结果）由 performBonemeal 方法控制
     *
     * @param level 世界读取器
     * @param pos   方块位置
     * @param state 当前方块状态
     * @return 始终返回 true
     */
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (state.getValue(HAS_FRUIT)) {
            if (!level.isClientSide()) {
                Block.popResource(level, pos, new ItemStack(ModItems.DREAMFRUIT.get(), 1));
                float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
                level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
                BlockState newState = state.setValue(HAS_FRUIT, Boolean.FALSE);
                level.setBlock(pos, newState, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    /**
     * 检查骨粉催熟迷梦果藤身体方块是否成功
     * <p>
     * 固定返回 true，表示骨粉催熟始终会成功
     * 具体的催熟效果（结果）由 performBonemeal 方法实现
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
     * 执行骨粉对迷梦果藤身体方块的催熟效果
     * <p>
     * 催熟逻辑：
     * - **已结果（HAS_FRUIT=true）**：收获果实，掉落 1 个迷梦果，播放采摘音效，重置为未结果状态
     * - **未结果（HAS_FRUIT=false）**：直接让藤蔓结果（设置 HAS_FRUIT=true）
     *
     * @param level  服务器世界等级
     * @param random 随机数生成器
     * @param pos    方块位置
     * @param state  当前方块状态
     */
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // 已结果则收获，未结果则催熟
        if (state.getValue(HAS_FRUIT)) {
            // 收获果实并播放音效
            Block.popResource(level, pos, new ItemStack(ModItems.DREAMFRUIT.get(), 1));
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState newState = state.setValue(HAS_FRUIT, Boolean.FALSE);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
        } else {
            // 未结果则直接结果
            level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
        }
    }

    /**
     * 迷梦果藤身体方块的随机刻逻辑
     * <p>
     * 当藤蔓未结果时，有 20% 的概率（1/5）自然结果
     * 已结果的藤蔓不执行任何操作
     *
     * @param state   当前方块状态
     * @param level   服务器世界等级
     * @param pos     方块位置
     * @param random  随机数生成器
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 未结果时有概率自然结果
        if (!state.getValue(HAS_FRUIT) && random.nextInt(5) == 0) {
            level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
        }
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

    /**
     * 获取玩家中键拾取此方块时获得的物品
     */
    @Override
    public ItemStack getCloneItemStack(net.minecraft.world.level.BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(ModItems.DREAMFRUIT.get());
    }
}
