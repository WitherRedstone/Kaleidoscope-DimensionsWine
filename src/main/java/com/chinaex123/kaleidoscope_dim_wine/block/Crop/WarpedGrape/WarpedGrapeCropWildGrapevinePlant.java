package com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 诡异葡萄藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成葡萄藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 */
public class WarpedGrapeCropWildGrapevinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public WarpedGrapeCropWildGrapevinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
    }

    /**
     * 检查诡异葡萄藤身体方块是否能在指定位置生存
     * <p>
     * 验证上方方块是否为以下类型之一：
     * - 诡异葡萄藤头部方块
     * - 诡异葡萄藤身体方块
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
        return relativeState.is(ModBlocks.WARPED_GRAPEVINE.get()) ||
                relativeState.is(ModBlocks.WARPED_GRAPEVINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    /**
     * 检查诡异葡萄藤身体方块是否能附着到指定方块上
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
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof GrapevineTrellisBlock;
    }

    /**
     * 获取与此身体方块关联的头部方块
     * <p>
     * 返回诡异葡萄藤的头部方块实例，用于藤蔓生长系统的内部逻辑
     *
     * @return 诡异葡萄藤头部方块实例
     */
    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.WARPED_GRAPEVINE.get();
    }

    /**
     * 检查诡异葡萄藤身体方块是否是有效的骨粉目标
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
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        // 获取关联的头部方块
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();

        // 查找顶部连接的头部方块并检查其状态
        return BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).map((headPos) -> {
            BlockState blockState = level.getBlockState(headPos);
            return blockState.is(headBlock) && !blockState.getValue(WarpedGrapeCropWildGrapevineHead.SHEARED);
        }).orElse(false);
    }

    /**
     * 获取玩家中键拾取此方块时获得的物品
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.WARPED_GRAPEVINE.get());
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
