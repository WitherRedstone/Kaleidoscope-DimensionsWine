package com.chinaex123.kaleidoscope_dim_wine.fluid;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class DragonBlood {

    private static final String DRAGON_BLOOD_NBT_KEY = "DragonBloodData"; // 这个功能的数据
    private static final String TIME_IN_FLUID_KEY = "TimeInFluid"; // 再留体内的时间
    private static final String HAS_REWARD_KEY = "HasReward"; // 是否已经获得过奖励
    private static final int REWARD_TIME_TICKS = 20 * 20; // 坚持的时间
    private static final int CLEAR_SIZE = 3; // 流体消失的半径

    /**
     * 处理玩家死亡后克隆事件，复制龙血奖励状态
     * <p>
     * 当玩家死亡时触发，将原玩家的龙血 NBT 数据复制到新玩家实体：
     * - 复制持久化数据中的 DRAGON_BLOOD_NBT_KEY 标签
     * - 如果已获得奖励（HAS_REWARD_KEY=true），立即应用生命值提升效果
     * - 将新玩家的生命值设置为最大值
     *
     * **注意**：仅在服务端执行实际的效果应用逻辑
     *
     * @param event 玩家克隆事件
     */
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // 非死亡情况不处理
        if (!event.isWasDeath()) return;

        Player original = event.getOriginal();
        Player player = event.getEntity();

        // 复制 NBT 数据
        CompoundTag oldData = original.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        player.getPersistentData().put(DRAGON_BLOOD_NBT_KEY, oldData.copy());

        // 如果是服务端且已获得奖励，立即应用并设为满血
        if (!player.level().isClientSide() && oldData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
            player.setHealth(player.getMaxHealth());
        }
    }

    /**
     * 处理玩家刻事件，检测玩家在龙血流体中的状态
     * <p>
     * **服务端专用**：客户端直接返回，不执行任何逻辑
     *
     * **检测流程**：
     * 1. 检测玩家当前位置是否处于龙血流体中（方块或流体状态）
     * 2. **在流体中**：
     *    - 累计停留时间（tick 计数）
     *    - 施加 20 刻（1 秒）的凋零 I 效果
     *    - 停留满奖励 tick 数且未获得奖励时，给予奖励并重置计时
     * 3. **离开流体**：
     *    - 重置停留时间为 0
     *
     * @param event 玩家刻事件（Post）
     */
    @SubscribeEvent
    public static void onPlayerTick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
        if (event.phase != net.minecraftforge.event.TickEvent.Phase.END) {
            return;
        }

        Player player = event.player;
        Level level = player.level();

        // 客户端不处理
        if (level.isClientSide()) {
            return;
        }

        // 检测是否在龙血流体中
        BlockPos playerPos = player.blockPosition();
        boolean isInDragonBlood = level.getBlockState(playerPos).getBlock() == KDWBlocks.DRAGON_BLOOD_FLUID.get() ||
                level.getFluidState(playerPos).is(KDWFluids.DRAGON_BLOOD.get());

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);

        if (isInDragonBlood) {
            // 累计停留时间并施加凋零效果
            int timeInFluid = dragonBloodData.getInt(TIME_IN_FLUID_KEY) + 1;
            dragonBloodData.putInt(TIME_IN_FLUID_KEY, timeInFluid);

            player.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1));

            // 达到奖励条件时给予奖励
            if (timeInFluid >= REWARD_TIME_TICKS && !dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
                giveReward(player, level, playerPos);
                dragonBloodData.putBoolean(HAS_REWARD_KEY, true);
                dragonBloodData.putInt(TIME_IN_FLUID_KEY, 0);
            }
        } else {
            // 离开流体时重置计时
            dragonBloodData.putInt(TIME_IN_FLUID_KEY, 0);
        }

        player.getPersistentData().put(DRAGON_BLOOD_NBT_KEY, dragonBloodData);
    }

    /**
     * 处理玩家登录事件，应用已获得的龙血奖励效果
     * <p>
     * **服务端专用**：客户端直接返回，不执行任何逻辑
     *
     * **检测流程**：
     * - 读取玩家的龙血 NBT 数据
     * - 如果已获得奖励（HAS_REWARD_KEY=true），立即应用生命值提升效果
     * - 确保玩家登录时能立即获得之前获得的增益效果
     *
     * @param event 玩家登录事件
     */
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) {
            return;
        }

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        if (dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
        }
    }

    /**
     * 处理玩家复活事件，应用已获得的龙血奖励效果
     * <p>
     * **服务端专用**：客户端直接返回，不执行任何逻辑
     *
     * **检测流程**：
     * - 读取玩家的龙血 NBT 数据
     * - 如果已获得奖励（HAS_REWARD_KEY=true），立即应用生命值提升效果
     * - 将玩家的生命值设置为最大值，确保复活时能立即获得增益
     *
     * @param event 玩家复活事件
     */
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) {
            return;
        }

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        if (dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
        }
        player.setHealth(player.getMaxHealth());
    }

    /**
     * 给予玩家龙血奖励效果
     * <p>
     * **奖励内容**：
     * - 应用生命值提升效果（永久增益）
     * - 将玩家生命值恢复至最大值
     * - 清除当前位置的龙血流体方块
     *
     * @param player 要给予奖励的玩家
     * @param level  游戏世界
     * @param pos    玩家当前位置（龙血流体位置）
     */
    private static void giveReward(Player player, Level level, BlockPos pos) {
        // 应用生命提升效果并回满血
        applyHealthBoost(player);
        player.setHealth(player.getMaxHealth());

        // 清除龙血流体
        clearDragonBlood(level, pos);
    }

    /**
     * 为玩家应用龙血的生命值提升效果
     * <p>
     * **效果说明**：
     * - 永久增加 10 点最大生命值
     * - 使用模组的唯一 ID（dragon_blood_health）标识修饰器
     * - 检查是否已存在该修饰器，避免重复叠加
     *
     * **注意事项**：
     * - 该效果是永久性的，即使玩家死亡也会保留
     * - 通过 PlayerClone 事件在死亡时复制数据
     *
     * @param player 要应用效果的玩家
     */
    private static void applyHealthBoost(Player player) {
        var healthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (healthAttr != null) {
            String modifierId = KaleidoscopeDimensionsWine.MOD_ID + ":dragon_blood_health";

            boolean hasModifier = false;
            for (AttributeModifier existing : healthAttr.getModifiers()) {
                if (existing.getName().equals(modifierId)) {
                    hasModifier = true;
                    break;
                }
            }

            if (!hasModifier) {
                AttributeModifier modifier = new AttributeModifier(
                        modifierId,
                        10.0,
                        AttributeModifier.Operation.ADDITION
                );
                healthAttr.addPermanentModifier(modifier);
            }
        }
    }

    /**
     * 清除指定位置周围的龙血流体方块
     * <p>
     * **清除范围**：
     * - 以给定位置为中心，形成 CLEAR_SIZE×CLEAR_SIZE×CLEAR_SIZE 的立方体区域
     * - 遍历区域内的所有方块位置
     * - 将检测到的龙血流体方块替换为空气
     *
     * **用途**：
     * - 在玩家获得龙血奖励后清理现场
     * - 防止龙血流体无限存在或被滥用
     *
     * @param level      游戏世界
     * @param centerPos 中心位置（清除区域的中心点）
     */
    private static void clearDragonBlood(Level level, BlockPos centerPos) {
        // 计算偏移量，确保以中心点对称
        int offset = (CLEAR_SIZE - 1) / 2;

        // 遍历立方体区域内的所有位置
        for (int x = -offset; x <= offset; x++) {
            for (int y = -offset; y <= offset; y++) {
                for (int z = -offset; z <= offset; z++) {
                    BlockPos currentPos = centerPos.offset(x, y, z);

                    // 如果是龙血流体方块，则清除
                    if (level.getBlockState(currentPos).getBlock() == KDWBlocks.DRAGON_BLOOD_FLUID.get()) {
                        level.setBlockAndUpdate(currentPos, Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }
    }
}