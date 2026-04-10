package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/**
 * 霜降：攻击生物时，使生物获得霜寒效果
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Frostfall extends MobEffect {

    public Frostfall(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Post event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            var effect = attacker.getEffect(ModEffects.FROSTFALL);
            if (effect != null) {
                int amplifier = effect.getAmplifier();
                LivingEntity target = event.getEntity();

                target.addEffect(new MobEffectInstance(ModEffects.FROSTBITE, 100, amplifier));
            }
        }
    }
}
