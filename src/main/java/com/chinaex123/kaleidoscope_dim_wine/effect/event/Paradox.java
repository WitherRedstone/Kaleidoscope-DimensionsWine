package com.chinaex123.kaleidoscope_dim_wine.effect.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * 悖论：受伤时转为治疗，治疗时转为受伤，死亡时半心复活
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Paradox extends MobEffect {

    public Paradox(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    // 标记正在处理反转，防止循环触发
    private static final Set<LivingEntity> processingEntities = new HashSet<>();

    /**
     * 处理受到伤害事件 - 转为治疗
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();

        if (target.hasEffect(ModEffects.PARADOX) && !processingEntities.contains(target)) {
            float damage = event.getOriginalDamage();

            // 抵消伤害
            event.setNewDamage(0.0F);

            // 标记正在处理
            processingEntities.add(target);

            // 转为等量治疗
            target.heal(damage);

            // 移除标记
            processingEntities.remove(target);
        }
    }

    /**
     * 接受治疗事件 - 转为伤害
     */
    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        LivingEntity target = event.getEntity();

        if (target.hasEffect(ModEffects.PARADOX) && !processingEntities.contains(target)) {
            float healAmount = event.getAmount();

            // 取消治疗
            event.setCanceled(true);

            // 标记正在处理
            processingEntities.add(target);

            // 转为等量伤害
            target.hurt(target.damageSources().magic(), healAmount);

            // 移除标记
            processingEntities.remove(target);
        }
    }

    /**
     * 死亡事件 - 半心复活
     */
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();

        if (target.hasEffect(ModEffects.PARADOX)) {
            // 取消死亡
            event.setCanceled(true);

            // 设置为半颗心（1.0 生命值）
            target.setHealth(1.0F);

            // 清除效果
            target.removeEffect(ModEffects.PARADOX);
        }
    }
}
