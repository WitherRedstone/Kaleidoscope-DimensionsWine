package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/**
 * 嗜血：攻击时，恢复相当于造成伤害 10% 的生命值
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Bloodthirsty extends MobEffect {

    private static final float BASE_HEAL_RATIO = 0.10F; // 基础吸血比例
    private static final float EXTRA_HEAL_PER_LEVEL = 0.10F; // 每级额外吸血比例

    public Bloodthirsty(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onLivingDamageDealt(LivingDamageEvent.Post event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            // 先检查是否有效果
            var effect = attacker.getEffect(KDWEffects.BLOODTHIRSTY);
            if (effect == null) {
                return;
            }

            int amplifier = effect.getAmplifier();

            // 计算恢复量
            float healRatio = BASE_HEAL_RATIO + (EXTRA_HEAL_PER_LEVEL * amplifier);
            float healAmount = event.getNewDamage() * healRatio;

            // 治疗攻击者
            attacker.heal(healAmount);
        }
    }
}
