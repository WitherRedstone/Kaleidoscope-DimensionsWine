package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 嗜血：攻击时，恢复相当于造成伤害 10% 的生命值
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Bloodthirsty extends MobEffect {

    public Bloodthirsty(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    /**
     * 处理造成伤害事件 - 恢复生命值
     */
    @SubscribeEvent
    public static void onLivingDamageDealt(net.minecraftforge.event.entity.living.LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            int amplifier = 0;

            // 检查攻击者是否有嗜血效果
            if (attacker.hasEffect(ModEffects.BLOODTHIRSTY.get())) {
                amplifier = attacker.getEffect(ModEffects.BLOODTHIRSTY.get()).getAmplifier();
            }

            if (amplifier >= 0) {
                // 计算恢复量：基础 10%，每级增加 10%
                float healAmount = event.getAmount() * (0.10F * (amplifier + 1));

                // 治疗攻击者
                attacker.heal(healAmount);
            }
        }
    }
}
