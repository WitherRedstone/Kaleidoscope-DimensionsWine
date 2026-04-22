package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 硬化：按百分比减免所有来源的伤害
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Hardened extends MobEffect {

    public Hardened(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        var effect = entity.getEffect(ModEffects.HARDENED.get());

        if (effect != null) {
            int amplifier = effect.getAmplifier();
            float damageReduction = Math.min((amplifier + 1) * 0.05F, 2.0F);

            if (damageReduction > 0) {
                float originalDamage = event.getAmount();
                float reducedDamage = originalDamage * (1.0F - damageReduction);
                event.setAmount(Math.max(0, reducedDamage));
            }
        }
    }
}
