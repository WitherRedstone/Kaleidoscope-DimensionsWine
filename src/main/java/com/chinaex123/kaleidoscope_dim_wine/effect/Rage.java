package com.chinaex123.kaleidoscope_dim_wine.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

/**
 * 狂怒：增加攻击速度和伤害
 */
public class Rage extends MobEffect {
    public Rage(int color) {
        super(MobEffectCategory.BENEFICIAL, color);

        // 添加攻击速度属性修饰符：每级 +1.0
        this.addAttributeModifier(
                Attributes.ATTACK_SPEED,
                "d684d262-e6f8-fd39-6aa7-b4fabdf297c7",
                1.0,
                AttributeModifier.Operation.ADDITION)
        ;

        // 添加攻击力属性修饰符：每级 +1.5
        this.addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                "7d0a92b7-a0cb-9e6b-2c79-0ac244f9053b",
                1.5,
                AttributeModifier.Operation.ADDITION
        );
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
    }
}
