package com.chinaex123.kaleidoscope_dim_wine.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 酒的碰撞箱
 */
public class DrinkShapes {

    public static final VoxelShape[] STANDARD_BOTTLE = shapeGen(2, 16);
    public static final VoxelShape[] SHORT_BOTTLE = shapeGen(2, 8);
    public static final VoxelShape[] WIDE_SHORT_CAN = shapeGen(3, 8);
    public static final VoxelShape[] WIDE_TALL_BOTTLE = shapeGen(3, 16);

    public static final VoxelShape[] IRREGULAR_TALL = irregularShapes3(13, 12);
    public static final VoxelShape[] IRREGULAR_SHORT = irregularShapes3(12, 12);
    public static final VoxelShape[] IRREGULAR_CORNER_TALL = irregularShapes2(13, 12);
    public static final VoxelShape[] IRREGULAR_CORNER_SHORT = irregularShapes2(12, 12);
    public static final VoxelShape[] IRREGULAR_CORNER_TWO = irregularShapes2(16, 16);

    public static VoxelShape[] shapeGen(int size, int height) {
        return new VoxelShape[]{
                Block.box(8 - size, 0, 8 - size, 8 + size, height, 8 + size),
                Block.box(8 - size - 4, 0, 8 - size, 8 + size + 4, height, 8 + size),
                Shapes.or(
                        Block.box(8 - size - 4, 0, 8 + 1, 8 + size + 4, height, 8 + size + 4),
                        Block.box(8 - size, 0, 8 - size - 4, 8 + size, height, 8 + size + 4)
                ),
                Block.box(8 - size - 4, 0, 8 - size - 4, 8 + size + 4, height, 8 + size + 4),
        };
    }

    public static VoxelShape[] irregularShapes3(int h1, int h2) {
        return new VoxelShape[]{
                Block.box(3, 0, 6, 13, h1, 10),
                Block.box(1, 0, 3, 15, h2, 12),
                Block.box(1, 0, 1, 16, h2, 13)
        };
    }

    public static VoxelShape[] irregularShapes2(int h1, int h2) {
        return new VoxelShape[]{
                Block.box(3, 0, 6, 13, h1, 10),
                Block.box(1, 0, 3, 15, h2, 12)
        };
    }

    public static VoxelShape[] getStandardBottleShapes() {
        return STANDARD_BOTTLE;
    }

    public static VoxelShape[] getShortBottleShapes() {
        return SHORT_BOTTLE;
    }
}