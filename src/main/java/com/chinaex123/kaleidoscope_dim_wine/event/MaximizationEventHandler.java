package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.effect.Maximization;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

/**
 * 监听巨大化效果移除事件，清理属性修饰器
 */
public class MaximizationEventHandler {

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        if (event.getEffect().value() instanceof Maximization) {
            LivingEntity entity = event.getEntity();
            Maximization.removeAllBonuses(entity);
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof Maximization) {
            LivingEntity entity = event.getEntity();
            Maximization.removeAllBonuses(entity);
        }
    }
}
