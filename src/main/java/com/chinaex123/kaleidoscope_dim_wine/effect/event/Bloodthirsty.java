package com.chinaex123.kaleidoscope_dim_wine.effect.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/**
 * 嗜血：攻击时，恢复相当于造成伤害 10% 的生命值
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Bloodthirsty {

    /**
     * 处理造成伤害事件 - 恢复生命值
     */
    @SubscribeEvent
    public static void onLivingDamageDealt(LivingDamageEvent.Post event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            int amplifier = 0;

            // 检查攻击者是否有嗜血效果
            if (attacker.hasEffect(ModEffects.BLOODTHIRSTY)) {
                amplifier = attacker.getEffect(ModEffects.BLOODTHIRSTY).getAmplifier();
            }

            if (amplifier >= 0) {
                // 计算恢复量：基础 10%，每级增加 10%
                float healAmount = event.getNewDamage() * (0.10F * (amplifier + 1));

                // 治疗攻击者
                attacker.heal(healAmount);
            }
        }
    }
}
