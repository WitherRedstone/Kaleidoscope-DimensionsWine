package com.chinaex123.kaleidoscope_dim_wine.effect.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

// 狂怒 效果机制 - 增加攻击速度和伤害
public class Rage extends MobEffect {
    public Rage(int color) {
        super(MobEffectCategory.BENEFICIAL, color);

        // 添加攻击速度属性修饰符：每级 +1.0
        this.addAttributeModifier(
                Attributes.ATTACK_SPEED,
                ResourceLocation.parse("d684d262-e6f8-fd39-6aa7-b4fabdf297c7"),
                1.0,
                AttributeModifier.Operation.ADD_VALUE)
        ;

        // 添加攻击力属性修饰符：每级 +1.5
        this.addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                ResourceLocation.parse("7d0a92b7-a0cb-9e6b-2c79-0ac244f9053b"),
                1.5,
                AttributeModifier.Operation.ADD_VALUE
        );
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
