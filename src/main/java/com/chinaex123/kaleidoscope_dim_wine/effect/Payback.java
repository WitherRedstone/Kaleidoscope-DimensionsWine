package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * 后发制人：抵消一次伤害，下次攻击伤害大幅提升，攻击后效果消失。
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Payback extends MobEffect {

    public Payback(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    // 存储可以增伤的玩家
    private static final Set<Player> paybackPlayers = new HashSet<>();

    /**
     * 处理受到伤害事件 - 抵消伤害
     */
    @SubscribeEvent
    public static void onLivingDamageReceived(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();

        if (target instanceof Player player && player.hasEffect(KDWEffects.PAYBACK)) {
            // 如果已经标记过，不再抵消
            if (paybackPlayers.contains(player)) {
                return;
            }

            // 抵消这次伤害
            event.setNewDamage(0.0F);

            // 标记该玩家下次攻击增伤
            paybackPlayers.add(player);
        }
    }

    /**
     * 处理造成伤害事件 - 应用增伤并移除效果
     */
    @SubscribeEvent
    public static void onLivingDamageDealt(LivingDamageEvent.Pre event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (paybackPlayers.contains(player)) {
                float originalDamage = event.getOriginalDamage();
                float newDamage = originalDamage * 3.0F;

                // 设置 3 倍伤害
                event.setNewDamage(newDamage);

                // 移除状态效果
                player.removeEffect(KDWEffects.PAYBACK);

                // 清除标记
                paybackPlayers.remove(player);
            }
        }
    }
}
