package com.chinaex123.kaleidoscope_dim_wine.block;

import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.BottleBlock;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * 易拉罐方块
 * <p>继承自 BottleBlock，用于表示各种易拉罐饮料</p>
 * <p>碰撞箱尺寸：6x8x6（比标准酒瓶更小）</p>
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PopCanBlock extends BottleBlock {

    /** 易拉罐方块的形状 */
    private static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 8.0, 11.0);

    public PopCanBlock() {
        super();
    }

    /**
     * 获取方块的视觉形状
     *
     * @param state   方块状态
     * @param level   区块读取器
     * @param pos     方块位置
     * @param context 碰撞上下文
     * @return 方块的 voxel 形状
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    /**
     * 获取方块的碰撞形状
     *
     * @param state   方块状态
     * @param level   区块读取器
     * @param pos     方块位置
     * @param context 碰撞上下文
     * @return 方块的碰撞 voxel 形状
     */
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
