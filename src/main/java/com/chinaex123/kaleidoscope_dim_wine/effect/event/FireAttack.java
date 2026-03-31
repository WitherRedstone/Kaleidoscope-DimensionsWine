package com.chinaex123.kaleidoscope_dim_wine.effect.event;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.effect.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 火焰攻击：攻击时使敌人燃烧
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class FireAttack extends MobEffect {

    public FireAttack(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    /**
     * 监听玩家攻击事件，当玩家有火焰攻击效果时，使目标燃烧并增加火焰伤害
     */
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) {
            return;
        }

        var effectInstance = attacker.getEffect(ModEffects.FIRE_ATTACK);
        if (effectInstance != null && !event.getEntity().level().isClientSide()) {
            LivingEntity target = event.getEntity();
            int amplifier = effectInstance.getAmplifier(); // 效果等级

            // 如果目标免疫火焰，只生成粒子效果
            if (target.fireImmune()) {
                // 生成火焰粒子（等级越高，粒子越多）
                int particleCount = 20 + (amplifier * 10);
                for (int i = 0; i < particleCount; ++i) {
                    double px = target.getX() + (double) (target.level().getRandom().nextFloat() * target.getBbWidth() * 2.0F) - (double) target.getBbWidth();
                    double py = target.getY() + (double) (target.level().getRandom().nextFloat() * target.getBbHeight());
                    double pz = target.getZ() + (double) (target.level().getRandom().nextFloat() * target.getBbWidth() * 2.0F) - (double) target.getBbWidth();
                    target.level().addParticle(ParticleTypes.FLAME, px, py, pz, 0.02D, 0.02D, 0.02D);
                }
            } else {
                // 使目标燃烧：基础 15 秒，每级增加 5 秒
                int burnTicks = 300 + (amplifier * 100);
                target.setRemainingFireTicks(burnTicks);

                // 立即造成额外的火焰伤害（等级越高，伤害越高）
                float fireDamage = 2.0f + (amplifier * 1.0f); // 等级 I=2 伤害，等级 II=3 伤害，等级 III=4 伤害
                target.hurt(target.damageSources().onFire(), fireDamage);
            }
        }
    }
}
