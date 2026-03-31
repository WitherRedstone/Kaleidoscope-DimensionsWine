package com.chinaex123.kaleidoscope_dim_wine.server;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class DragonBloodSpawnHandler {

    @SubscribeEvent
    public static void onEnderDragonDeath(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide()) {
            return; // 客户端直接返回，不做任何处理
        }

        if (event.getEntity() instanceof EnderDragon dragon) {
            ServerLevel level = (ServerLevel) dragon.level();
            BlockPos dragonPos = dragon.blockPosition();

            // 在末影龙死亡位置周围生成龙血流体
            spawnDragonBlood(level, dragonPos);
        }
    }

    private static void spawnDragonBlood(ServerLevel level, BlockPos centerPos) {
        // 以末影龙死亡位置为中心，在半径 5 格范围内随机生成 3-8 个龙血源
        int radius = 5; // 半径范围
        int minCount = 3;  // 最少生成数量
        int maxCount = 8;  // 最多生成数量
        int bloodCount = minCount + level.random.nextInt(maxCount - minCount + 1); // 3-8 个

        for (int i = 0; i < bloodCount; i++) {
            // 随机位置
            int offsetX = level.random.nextInt(radius * 2 + 1) - radius;
            int offsetZ = level.random.nextInt(radius * 2 + 1) - radius;
            BlockPos pos = centerPos.offset(offsetX, 0, offsetZ);

            // 向下找到地面
            BlockPos groundPos = findGroundPosition(level, pos);

            if (groundPos != null) {
                // 放置龙血流体方块
                level.setBlock(groundPos, ModBlocks.DRAGON_BLOOD_FLUID.get().defaultBlockState(),
                        Block.UPDATE_ALL);
            }
        }
    }

    private static BlockPos findGroundPosition(ServerLevel level, BlockPos pos) {
        // 从当前位置向下查找，直到找到非空气方块
        BlockPos currentPos = pos;

        // 最多向下搜索 256 格
        for (int y = 0; y < 256; y++) {
            if (!level.getBlockState(currentPos).isAir()) {
                // 找到固体方块，返回其上方
                BlockPos result = currentPos.above();

                // 额外检查：确保位置可以放置流体（不是固体方块）
                if (level.getBlockState(result).isAir() || level.getFluidState(result).isEmpty()) {
                    return result;
                }
                return null; // 上方被占用
            }
            currentPos = currentPos.below();
        }

        return null;
    }
}