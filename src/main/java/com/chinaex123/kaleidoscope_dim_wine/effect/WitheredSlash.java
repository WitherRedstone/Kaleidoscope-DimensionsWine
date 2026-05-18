package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

/**
 * 枯斩：攻击敌人可以虚弱敌人并对其造成凋零
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class WitheredSlash extends MobEffect {
    public WitheredSlash(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onPlayerAttack(net.minecraftforge.event.entity.living.LivingDamageEvent event) {
        // 检查攻击者是否是玩家
        if (!(event.getSource().getEntity() instanceof Player attacker)) {
            return;
        }

        // 检查玩家是否拥有 枯斩 效果
        var effectInstance = attacker.getEffect(KDWEffects.WITHERED_SLASH.get());
        if (effectInstance != null) {
            LivingEntity target = event.getEntity();
            int amplifier = effectInstance.getAmplifier(); // 效果等级

            // 应用凋零效果（等级随效果等级提升，持续时间也增加）
            target.addEffect(new MobEffectInstance(
                    MobEffects.WITHER, 20 * (3 + amplifier), amplifier, false, false
            ));

            // 应用虚弱效果（等级随效果等级提升）
            target.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS, 20 * 5, amplifier, false, false
            ));
        }
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
    }
}
