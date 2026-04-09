package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.resources.ResourceLocation;

/**
 * 巨大化：增大玩家体型
 */
public class Maximization extends MobEffect {

    public Maximization(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    private static final ResourceLocation SCALE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_scale");
    private static final ResourceLocation STEP_HEIGHT_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_step_height");
    private static final ResourceLocation ATTACK_DAMAGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_attack_damage");
    private static final ResourceLocation MAX_HEALTH_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_max_health");
    private static final ResourceLocation ENTITY_INTERACTION_RANGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_entity_interaction_range");
    private static final ResourceLocation BLOCK_INTERACTION_RANGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_block_interaction_range");
    private static final ResourceLocation MOVEMENT_SPEED_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_movement_speed");
    private static final ResourceLocation JUMP_STRENGTH_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_jump_strength");

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            // 实体体型缩放
            double scale = amplifier < 4 ? (amplifier + 1) * 0.8 : Math.min(4.0 + (amplifier - 4), 15.0);
            updateAttribute(entity, Attributes.SCALE, SCALE_MODIFIER, scale, AttributeModifier.Operation.ADD_VALUE);
            // 自动上台阶高度
            updateAttribute(entity, Attributes.STEP_HEIGHT, STEP_HEIGHT_MODIFIER, 0.5 + amplifier * 0.5, AttributeModifier.Operation.ADD_VALUE);
            // 实体交互范围
            updateAttribute(entity, Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, 1 + amplifier, AttributeModifier.Operation.ADD_VALUE);
            // 方块交互范围
            updateAttribute(entity, Attributes.BLOCK_INTERACTION_RANGE, BLOCK_INTERACTION_RANGE_MODIFIER, 1 + amplifier, AttributeModifier.Operation.ADD_VALUE);
            // 攻击伤害
            double attackDamage = Math.min(1.5 + amplifier * 0.5, 100.0);
            updateAttribute(entity, Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, attackDamage, AttributeModifier.Operation.ADD_VALUE);
            // 最大生命值
            double maxHealth = Math.min(amplifier * 25.0, 400.0);
            updateAttribute(entity, Attributes.MAX_HEALTH, MAX_HEALTH_MODIFIER, maxHealth, AttributeModifier.Operation.ADD_VALUE);
            // 移动速度
            double movementSpeed = amplifier * (-0.05);
            if (movementSpeed < -0.8) movementSpeed = -0.8;
            updateAttribute(entity, Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_MODIFIER, movementSpeed, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
            // 跳跃力度
            double jumpStrength = amplifier * (-0.005);
            if (jumpStrength < -0.005) jumpStrength = -0.2;
            updateAttribute(entity, Attributes.JUMP_STRENGTH, JUMP_STRENGTH_MODIFIER, jumpStrength, AttributeModifier.Operation.ADD_VALUE);
        }
        return true;
    }

    private void updateAttribute(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            AttributeModifier existing = instance.getModifier(id);
            if (existing == null || existing.amount() != amount) {
                instance.removeModifier(id);
                instance.addTransientModifier(new AttributeModifier(id, amount, operation));
            }
        }
    }

    public static void removeAllBonuses(LivingEntity entity) {
        removeBonus(entity, Attributes.SCALE, SCALE_MODIFIER);
        removeBonus(entity, Attributes.STEP_HEIGHT, STEP_HEIGHT_MODIFIER);
        removeBonus(entity, Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER);
        removeBonus(entity, Attributes.MAX_HEALTH, MAX_HEALTH_MODIFIER);
        removeBonus(entity, Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER);
        removeBonus(entity, Attributes.BLOCK_INTERACTION_RANGE, BLOCK_INTERACTION_RANGE_MODIFIER);
        removeBonus(entity, Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_MODIFIER);
        removeBonus(entity, Attributes.JUMP_STRENGTH, JUMP_STRENGTH_MODIFIER);
    }

    private static void removeBonus(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation id) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            instance.removeModifier(id);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
