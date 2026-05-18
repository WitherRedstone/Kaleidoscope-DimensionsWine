package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.config.KDWConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;

/**
 * 通用游戏事件监听器
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class ModCommonEvent {

    /**
     * 监听玩家摔落事件，当玩家摔落在基岩上时有概率掉落基岩小灯串
     *
     * @param event 摔落事件对象
     */
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (player.isCreative() || player.isSpectator()) {
            return;
        }

        // 检测是否有实际摔落伤害
        if (event.getDistance() <= 2.0f) {
            return;
        }

        // 检测玩家脚下是否为基岩方块
        BlockPos belowPos = player.blockPosition().below();
        if (player.level().getBlockState(belowPos).is(Blocks.BEDROCK)) {
            // 根据配置文件概率生成基岩小灯串物品
            if (player.getRandom().nextFloat() < KDWConfig.BEDROCK_FALL_DROP_CHANCE.get()) {
                ItemStack stack = new ItemStack(KDWBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get());
                player.spawnAtLocation(stack);
            }
        }
    }

    /**
     * 监听玩家死亡事件，防止蜜酒精华掉落
     *
     * @param event 死亡事件对象
     */
    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (player.isCreative() || player.isSpectator()) {
            return;
        }

        // 遍历玩家物品栏，清除所有蜜酒精华
        for (ItemStack stack : player.getInventory().items) {
            if (ModList.get().isLoaded("the_bumblezone") && stack.is(TheBumblezoneItems.MEAD_ESSENCE.get())) {
                stack.setCount(0);
            }
        }
    }

    /**
     * 监听爆炸事件，防止蜜酒精华被爆炸摧毁
     *
     * @param event 爆炸事件对象
     */
    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate event) {
        // 从受影响的实体列表中移除蜜酒精华物品实体
        event.getAffectedEntities().removeIf(entity -> {
            if (entity instanceof ItemEntity itemEntity) {
                return ModList.get().isLoaded("the_bumblezone") && itemEntity.getItem().is(TheBumblezoneItems.MEAD_ESSENCE.get());
            }
            return false;
        });
    }

    /**
     * 监听从闪电击中事件，防止蜜酒精华被闪电摧毁
     *
     * @param event 闪电击中事件对象
     */
    @SubscribeEvent
    public static void onLightningStrike(EntityStruckByLightningEvent event) {
        // 如果被击中的实体是蜜酒精华物品，则取消事件
        if (event.getEntity() instanceof ItemEntity itemEntity) {
            if (ModList.get().isLoaded("the_bumblezone") && itemEntity.getItem().is(TheBumblezoneItems.MEAD_ESSENCE.get())) {
                event.setCanceled(true);
            }
        }
    }
}
