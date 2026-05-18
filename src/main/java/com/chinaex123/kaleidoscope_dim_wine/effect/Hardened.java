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
 * 硬化：按百分比减免所有来源的伤害
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Hardened extends MobEffect {

    public Hardened(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        var effect = entity.getEffect(KDWEffects.HARDENED);

        if (effect != null) {
            int amplifier = effect.getAmplifier();
            float damageReduction = Math.min((amplifier + 1) * 0.05F, 2.0F);

            if (damageReduction > 0) {
                float originalDamage = event.getOriginalDamage();
                float reducedDamage = originalDamage * (1.0F - damageReduction);
                event.setNewDamage(Math.max(0, reducedDamage));
            }
        }
    }
}
