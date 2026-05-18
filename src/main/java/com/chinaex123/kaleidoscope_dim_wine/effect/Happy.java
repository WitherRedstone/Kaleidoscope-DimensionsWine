package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

/**
 * 高兴：增加移动速度，攻击或受伤时移除
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Happy extends MobEffect {

    public Happy(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:happy_speed",
                        0.15 * (amplifier + 1),
                        AttributeModifier.Operation.ADDITION
                );

                if (!instance.hasModifier(modifier)) {
                    instance.addTransientModifier(modifier);
                }
            }
        }
    }

    private static void removeBonus(LivingEntity entity, AttributeInstance instance) {
        if (instance != null) {
            AttributeModifier modifier = new AttributeModifier(
                    "kaleidoscope_dim_wine:happy_speed",
                    0.15,
                    AttributeModifier.Operation.ADDITION
            );
            instance.removeModifier(modifier);
        }
    }

    /**
     * 监听受到伤害事件 - 移除高兴效果
     */
    @SubscribeEvent
    public static void onLivingDamage(net.minecraftforge.event.entity.living.LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(KDWEffects.HAPPY.get())) {
            removeBonus(entity, entity.getAttribute(Attributes.MOVEMENT_SPEED));
            entity.removeEffect(KDWEffects.HAPPY.get());
        }
    }

    /**
     * 监听攻击事件 - 移除高兴效果
     */
    @SubscribeEvent
    public static void onPlayerAttack(net.minecraftforge.event.entity.living.LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(KDWEffects.HAPPY.get())) {
                removeBonus(attacker, attacker.getAttribute(Attributes.MOVEMENT_SPEED));
                attacker.removeEffect(KDWEffects.HAPPY.get());
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, net.minecraft.world.entity.ai.attributes.AttributeMap attributes, int amplifier) {
        AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (instance != null) {
            AttributeModifier modifier = new AttributeModifier(
                    "kaleidoscope_dim_wine:happy_speed",
                    0.15 * (amplifier + 1),
                    AttributeModifier.Operation.ADDITION
            );
            instance.removeModifier(modifier);
        }
        super.removeAttributeModifiers(entity, attributes, amplifier);
    }
}
