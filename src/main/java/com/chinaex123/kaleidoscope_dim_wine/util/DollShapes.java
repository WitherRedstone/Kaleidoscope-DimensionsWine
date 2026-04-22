package com.chinaex123.kaleidoscope_dim_wine.util;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 玩偶的碰撞箱
 */
public class DollShapes {
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            // Head (头部)
            Block.box(4.35, 6, 5.75, 11.65, 13.3, 13.05),
            Block.box(4, 6, 5.4, 12, 14, 13.4),

            // Body (身体)
            Block.box(5.6, 0, 8, 10.4, 6, 10.8),
            Block.box(5.5, -0.1, 7.9, 10.5, 6.1, 10.9),

            // RightHand (右手)
            Block.box(9.5, -0.25, 8.4, 11.5, 5.75, 10.4),
            Block.box(9.4, -0.35, 8.3, 11.6, 5.85, 10.5),

            // LeftHand (左手)
            Block.box(4.5, -0.25, 8.4, 6.5, 5.75, 10.4),
            Block.box(4.4, -0.35, 8.3, 6.6, 5.85, 10.5),

            // RightLeg (右腿)
            Block.box(8, 0, 2.4, 10, 2, 8.4),
            Block.box(7.9, -0.1, 2.3, 10.1, 2.1, 8.5),

            // LeftLeg (左腿)
            Block.box(6, 0, 2.4, 8, 2, 8.4),
            Block.box(5.9, -0.1, 2.3, 8.1, 2.1, 8.5)
    );

    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(4.35, 6, 2.95, 11.65, 13.3, 10.25),
            Block.box(4, 6, 2.6, 12, 14, 10.6),
            Block.box(5.6, 0, 5.2, 10.4, 6, 8),
            Block.box(5.5, -0.1, 5.1, 10.5, 6.1, 8.1),
            Block.box(4.5, -0.25, 5.6, 6.5, 5.75, 7.6),
            Block.box(4.4, -0.35, 5.5, 6.6, 5.85, 7.7),
            Block.box(9.5, -0.25, 5.6, 11.5, 5.75, 7.6),
            Block.box(9.4, -0.35, 5.5, 11.6, 5.85, 7.7),
            Block.box(6, 0, 7.6, 8, 2, 13.6),
            Block.box(5.9, -0.1, 7.5, 8.1, 2.1, 13.7),
            Block.box(8, 0, 7.6, 10, 2, 13.6),
            Block.box(7.9, -0.1, 7.5, 10.1, 2.1, 13.7)
    );

    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(2.95, 6, 4.35, 10.25, 13.3, 11.65),
            Block.box(2.6, 6, 4, 10.6, 14, 12),
            Block.box(5.2, 0, 5.6, 8, 6, 10.4),
            Block.box(5.1, -0.1, 5.5, 8.1, 6.1, 10.5),
            Block.box(5.6, -0.25, 4.5, 7.6, 5.75, 6.5),
            Block.box(5.5, -0.35, 4.4, 7.7, 5.85, 6.6),
            Block.box(5.6, -0.25, 9.5, 7.6, 5.75, 11.5),
            Block.box(5.5, -0.35, 9.4, 7.7, 5.85, 11.6),
            Block.box(7.6, 0, 6, 13.6, 2, 8),
            Block.box(7.5, -0.1, 5.9, 13.7, 2.1, 8.1),
            Block.box(7.6, 0, 8, 13.6, 2, 10),
            Block.box(7.5, -0.1, 7.9, 13.7, 2.1, 10.1)
    );

    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(5.75, 6, 4.35, 13.05, 13.3, 11.65),
            Block.box(5.4, 6, 4, 13.4, 14, 12),
            Block.box(8, 0, 5.2, 10.8, 6, 8),
            Block.box(7.9, -0.1, 5.1, 10.9, 6.1, 8.1),
            Block.box(8.4, -0.25, 9.5, 10.4, 5.75, 11.5),
            Block.box(8.3, -0.35, 9.4, 10.5, 5.85, 11.6),
            Block.box(8.4, -0.25, 4.5, 10.4, 5.75, 6.5),
            Block.box(8.3, -0.35, 4.4, 10.5, 5.85, 6.6),
            Block.box(2.4, 0, 8, 8.4, 2, 10),
            Block.box(2.3, -0.1, 7.9, 8.5, 2.1, 10.1),
            Block.box(2.4, 0, 6, 8.4, 2, 8),
            Block.box(2.3, -0.1, 5.9, 8.5, 2.1, 8.1)
    );

    public static VoxelShape getShape(Direction facing) {
        return switch (facing) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }
}
