package com.chinaex123.kaleidoscope_dim_wine.event;

import com.chinaex123.kaleidoscope_dim_wine.effect.Maximization;
import com.chinaex123.kaleidoscope_dim_wine.effect.Minify;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

/**
 * 监听有属性效果移除事件，清理属性修饰器
 */
public class EffectAttributeRemoveHandler {

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        // 巨大化：清理属性修饰器
        if (event.getEffect().value() instanceof Maximization) {
            LivingEntity entity = event.getEntity();
            Maximization.removeAllBonuses(entity);
        }
        // 迷你化：清理属性修饰器
        else if (event.getEffect().value() instanceof Minify) {
            LivingEntity entity = event.getEntity();
            Minify.removeAllBonuses(entity);
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        // 巨大化：清理属性修饰器
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof Maximization) {
            LivingEntity entity = event.getEntity();
            Maximization.removeAllBonuses(entity);
        }
        // 迷你化：清理属性修饰器
        else if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof Minify) {
            LivingEntity entity = event.getEntity();
            Minify.removeAllBonuses(entity);
        }
    }
}
