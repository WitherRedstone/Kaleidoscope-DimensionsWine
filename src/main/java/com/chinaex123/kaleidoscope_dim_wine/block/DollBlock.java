package com.chinaex123.kaleidoscope_dim_wine.block;

import com.chinaex123.kaleidoscope_dim_wine.util.DollShapes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 玩偶方块 - 具有方向性和精确碰撞箱的装饰性方块
 */
public class DollBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<DollBlock> CODEC = MapCodec.unit(DollBlock::new);

    public DollBlock() {
        super(Properties.of().strength(1.5F, 6.0F).mapColor(MapColor.WOOL).sound(SoundType.WOOL));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return DollShapes.getShape(state.getValue(FACING));
    }
}
