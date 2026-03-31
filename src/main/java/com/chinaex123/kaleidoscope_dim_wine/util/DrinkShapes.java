package com.chinaex123.kaleidoscope_dim_wine.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 酒类 BlockEntity 的碰撞箱
 */
public class DrinkShapes {

    public static final VoxelShape[] STANDARD_BOTTLE_SHAPES = new VoxelShape[] {
            Block.box(6, 0, 6, 10, 16, 10),
            Block.box(2, 0, 6, 14, 16, 10),
            Block.box(2, 0, 10, 14, 16, 14),
            Block.box(6, 0, 2, 10, 16, 14),
            Block.box(2, 0, 2, 14, 16, 14)
    };

    public static VoxelShape[] getStandardBottleShapes() {
        return STANDARD_BOTTLE_SHAPES;
    }
}
