package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 霜降：攻击生物时，使生物获得霜寒效果
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Frostfall extends MobEffect {

    public Frostfall(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            var effect = attacker.getEffect(KDWEffects.FROSTFALL.get());
            if (effect != null) {
                int amplifier = effect.getAmplifier();
                LivingEntity target = event.getEntity();

                target.addEffect(new MobEffectInstance(KDWEffects.FROSTBITE.get(), 100, amplifier));
            }
        }
    }
}
