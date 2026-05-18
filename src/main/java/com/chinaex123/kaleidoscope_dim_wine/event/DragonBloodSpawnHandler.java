package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 监听末影龙死亡事件，在死亡位置生成龙血流体
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class DragonBloodSpawnHandler {

    /**
     * 处理末影龙死亡事件，在死亡位置生成龙血流体
     * <p>
     * **触发条件**：
     * - 仅在服务端执行，客户端直接返回不处理
     * - 仅当死亡实体为末影龙（EnderDragon）时触发
     * <p>
     * **执行流程**：
     * - 获取末影龙的死亡位置坐标
     * - 调用 spawnDragonBlood 方法在周围区域生成龙血流体方块
     * - 为玩家提供获取龙血奖励的机会
     *
     * @param event 生物死亡事件
     */
    @SubscribeEvent
    public static void onEnderDragonDeath(LivingDeathEvent event) {
        // 客户端不处理
        if (event.getEntity().level().isClientSide()) {
            return;
        }

        // 检查是否为末影龙
        if (event.getEntity() instanceof EnderDragon dragon) {
            ServerLevel level = (ServerLevel) dragon.level();
            BlockPos dragonPos = dragon.blockPosition();

            // 在末影龙死亡位置周围生成龙血流体
            spawnDragonBlood(level, dragonPos);
        }
    }

    /**
     * 在末影龙死亡位置周围生成龙血流体方块
     * <p>
     * **生成规则**：
     * - 以末影龙死亡位置为中心点，半径 5 格范围内
     * - 随机生成 3-8 个龙血源方块（数量随机）
     * - 每个龙血源会在水平方向随机偏移，并自动降落到地面
     * <p>
     * **生成流程**：
     * 1. 计算本次生成的龙血源数量（3-8 个之间随机）
     * 2. 对每个龙血源：
     *    - 在半径范围内随机选择水平坐标（X、Z 轴）
     *    - 从该位置向下查找地面（调用 findGroundPosition）
     *    - 在地面位置放置龙血流体方块
     *
     * @param level     服务器世界等级
     * @param centerPos 中心位置（末影龙死亡坐标）
     */
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
                level.setBlock(groundPos, KDWBlocks.DRAGON_BLOOD_FLUID.get().defaultBlockState(),
                        Block.UPDATE_ALL);
            }
        }
    }

    /**
     * 从指定位置向下查找地面，返回适合放置龙血流体的位置
     * <p>
     * **搜索逻辑**：
     * - 从给定位置开始，垂直向下逐格检测
     * - 最多向下搜索 256 格（整个世界高度）
     * - 当遇到第一个非空气方块时，返回其上方的位置
     * <p>
     * **有效性验证**：
     * - 确保目标位置是空气或空流体状态（可放置流体）
     * - 如果上方被固体方块占用，则返回 null 表示无法放置
     *
     * @param level 服务器世界等级
     * @param pos   起始搜索位置
     * @return 适合放置龙血的地面位置，如果找不到则返回 null
     */
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