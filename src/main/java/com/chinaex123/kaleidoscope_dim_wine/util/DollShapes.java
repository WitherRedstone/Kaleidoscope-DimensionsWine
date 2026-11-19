package com.chinaex123.kaleidoscope_dim_wine.util;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.Map;

/**
 * 玩偶的碰撞箱。
 * <p>
 * 所有玩偶共用一个整体盒体碰撞箱，正好框住模型（含 ±22.5° 倾斜的手臂与腿部）。
 * 模型朝向为 NORTH，其余水平朝向由 NORTH 的碰撞箱绕 Y 轴旋转得到。
 */
public final class DollShapes {

    /** 玩偶的体型，用于区分外观 */
    public enum DollType {
        STEVE,
        ALEX
    }

    /** 朝北时覆盖整体模型的碰撞箱。 */
    private static final VoxelShape NORTH = Block.box(3.75, 0.0, 2.3, 12.85, 14.5, 13.4);

    /** 各朝向的碰撞箱。 */
    private static final Map<Direction, VoxelShape> SHAPES = rotateAll(NORTH);

    private DollShapes() {
    }

    /**
     * 获取指定体型与朝向的碰撞箱。
     * <p>
     * 所有体型共用同一碰撞箱；朝向不在缓存中时回退到 NORTH。
     *
     * @param type   玩偶体型
     * @param facing 朝向
     * @return 碰撞箱
     */
    public static VoxelShape getShape(DollType type, Direction facing) {
        return SHAPES.getOrDefault(facing, SHAPES.get(Direction.NORTH));
    }

    /**
     * 以 NORTH 朝向的碰撞箱生成四个水平朝向的碰撞箱。
     *
     * @param north NORTH 朝向的碰撞箱
     * @return 朝向到碰撞箱的映射
     */
    private static Map<Direction, VoxelShape> rotateAll(VoxelShape north) {
        Map<Direction, VoxelShape> shapes = new EnumMap<>(Direction.class);
        shapes.put(Direction.NORTH, north);
        shapes.put(Direction.EAST, rotate(north, Direction.EAST));
        shapes.put(Direction.SOUTH, rotate(north, Direction.SOUTH));
        shapes.put(Direction.WEST, rotate(north, Direction.WEST));
        return shapes;
    }

    /**
     * 将 NORTH 朝向的碰撞箱绕 Y 轴旋转到指定朝向。
     * <p>
     * 直接返回 NORTH 或逐个盒体按对应变换旋转后合并；
     * 未知朝向直接使用原盒体。
     *
     * @param north  NORTH 朝向的碰撞箱
     * @param facing 目标朝向
     * @return 旋转后的碰撞箱
     */
    private static VoxelShape rotate(VoxelShape north, Direction facing) {
        if (facing == Direction.NORTH) {
            return north;
        }
        VoxelShape result = Shapes.empty();
        for (AABB box : north.toAabbs()) {
            VoxelShape rotated = switch (facing) {
                // (x, z) -> (1 - z, x)
                case EAST -> Shapes.box(1.0 - box.maxZ, box.minY, box.minX,
                        1.0 - box.minZ, box.maxY, box.maxX);
                // (x, z) -> (1 - x, 1 - z)
                case SOUTH -> Shapes.box(1.0 - box.maxX, box.minY, 1.0 - box.maxZ,
                        1.0 - box.minX, box.maxY, 1.0 - box.minZ);
                // (x, z) -> (z, 1 - x)
                case WEST -> Shapes.box(box.minZ, box.minY, 1.0 - box.maxX,
                        box.maxZ, box.maxY, 1.0 - box.minX);
                default -> Shapes.box(box.minX, box.minY, box.minZ,
                        box.maxX, box.maxY, box.maxZ);
            };
            result = Shapes.or(result, rotated);
        }
        return result;
    }
}