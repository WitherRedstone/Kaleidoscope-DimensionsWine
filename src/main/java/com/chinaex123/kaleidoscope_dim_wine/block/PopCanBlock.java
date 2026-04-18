package com.chinaex123.kaleidoscope_dim_wine.block;

import com.chinaex123.kaleidoscope_dim_wine.util.DrinkShapes;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.BottleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 空瓶方块碰撞箱
 */
public class PopCanBlock extends BottleBlock {

    public PopCanBlock() {
        super();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        int index = switch (direction) {
            case NORTH -> 0;
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 4;
        };
        return DrinkShapes.SHORT_BOTTLE_SHAPES[index];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return getShape(state, level, pos, context);
    }
}
