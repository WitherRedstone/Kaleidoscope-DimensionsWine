package com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 绯红葡萄藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成葡萄藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 */
public class CrimsonGrapeCropWildGrapevinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    public static final MapCodec<CrimsonGrapeCropWildGrapevinePlant> CODEC = simpleCodec((p) -> new CrimsonGrapeCropWildGrapevinePlant());
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public CrimsonGrapeCropWildGrapevinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
    }

    /**
     * 检查绯红葡萄藤身体方块是否能在指定位置生存
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
     * 获取玩家中键拾取此方块时获得的物品
     * <p>
     * 返回绯红葡萄藤物品，用于创造模式下的方块复制
     *
     * @param state   当前方块状态
     * @param target  命中结果信息
     * @param level   世界读取器
     * @param pos     方块位置
     * @param player  执行拾取的玩家
     * @return 包含绯红葡萄藤物品的 ItemStack
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(KDWItems.CRIMSON_GRAPEVINE.get());
    }

    /**
     * 检查绯红葡萄藤是否能附着到指定方块上
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
     * 获取与此身体方块关联的头部方块
     * <p>
     * 返回绯红葡萄藤的头部方块实例，用于藤蔓生长系统的内部逻辑
     *
     * @return 绯红葡萄藤头部方块实例
     */
    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) KDWBlocks.CRIMSON_GRAPEVINE.get();
    }

    /**
     * 检查绯红葡萄藤身体方块是否是有效的骨粉目标
     * <p>
     * 验证条件：
     * - 存在与当前身体方块连接的头部方块
     * - 头部方块未被剪刀修剪（SHEARED=false）
     * <p>
     * 只有当头部方块处于可生长状态时，身体方块才能被骨粉催熟
     *
     * @param level 世界读取器
     * @param pos   方块位置
     * @param state 当前方块状态
     * @return 如果可以被骨粉催熟则返回 true，否则返回 false
     */
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        // 获取关联的头部方块
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();

        // 查找顶部连接的头部方块并检查其状态
        return BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).map((headPos) -> {
            BlockState blockState = level.getBlockState(headPos);
            return blockState.is(headBlock) && !(Boolean) blockState.getValue(CrimsonGrapeCropWildGrapevineHead.SHEARED);
        }).orElse(false);
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }

    static {
        PROPERTIES = Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.CAVE_VINES)
                .pushReaction(PushReaction.DESTROY);
    }
}
