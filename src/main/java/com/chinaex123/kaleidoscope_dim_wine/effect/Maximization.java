package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * 巨大化：增大玩家体型
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
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
    private static final ResourceLocation SAFE_FALL_DISTANCE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "maximization_safe_fall_distance");

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            // 实体体型缩放 - 实体体型缩放 = 如果(等级 < 4) 则 (等级 + 1) × 0.8 否则 最小值(等级, 上限15)
            double scale = amplifier < 4 ? (amplifier + 1) * 0.8 : Math.min(4.0 + (amplifier - 4), 15.0);
            updateAttribute(entity, Attributes.SCALE, SCALE_MODIFIER, scale, AttributeModifier.Operation.ADD_VALUE);
            // 自动上台阶高度 - 步进高度 = 最小值(0.5 + 等级 × 0.5)
            updateAttribute(entity, Attributes.STEP_HEIGHT, STEP_HEIGHT_MODIFIER, 0.5 + amplifier * 0.5, AttributeModifier.Operation.ADD_VALUE);
            // 实体交互范围 - 实体交互范围 = 1 + 等级
            updateAttribute(entity, Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, 1 + amplifier, AttributeModifier.Operation.ADD_VALUE);
            // 方块交互范围 - 方块交互范围 = 1 + 等级
            updateAttribute(entity, Attributes.BLOCK_INTERACTION_RANGE, BLOCK_INTERACTION_RANGE_MODIFIER, 1 + amplifier, AttributeModifier.Operation.ADD_VALUE);
            // 攻击伤害 - 攻击伤害 = 最小值(1.5 + 等级 × 0.5, 上限100)
            double attackDamage = Math.min(1.5 + amplifier * 0.5, 100.0);
            updateAttribute(entity, Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, attackDamage, AttributeModifier.Operation.ADD_VALUE);
            // 最大生命值 - 最大生命值 = 最小值(等级 × 10, 上限200)
            double maxHealth = (amplifier + 1) * 10.0;
            if (maxHealth > 200.0) maxHealth = 200.0;
            updateAttribute(entity, Attributes.MAX_HEALTH, MAX_HEALTH_MODIFIER, maxHealth, AttributeModifier.Operation.ADD_VALUE);
            // 移动速度 - 移动速度 = -最小值(等级 × 0.25%, 上限50%)
            double movementSpeed = (amplifier + 1) * (-0.025);
            if (movementSpeed < -0.5) movementSpeed = -0.5;
            updateAttribute(entity, Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_MODIFIER, movementSpeed, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
            // 跳跃力度 - 跳跃强度 = -最小值(等级 × 0.5%, 上限2%)
            double jumpStrength = (amplifier + 1) * (-0.005);
            if (jumpStrength < -0.02) jumpStrength = -0.02;
            updateAttribute(entity, Attributes.JUMP_STRENGTH, JUMP_STRENGTH_MODIFIER, jumpStrength, AttributeModifier.Operation.ADD_VALUE);
            // 安全坠落高度 - 安全坠落距离 = (等级 + 1) × 0.5
            updateAttribute(entity, Attributes.SAFE_FALL_DISTANCE, SAFE_FALL_DISTANCE_MODIFIER, (amplifier + 1) * 0.5, AttributeModifier.Operation.ADD_VALUE);
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
        removeBonus(entity, Attributes.SAFE_FALL_DISTANCE, SAFE_FALL_DISTANCE_MODIFIER);
    }

    private static void removeBonus(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation id) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            instance.removeModifier(id);
        }
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;

        var effect = player.getEffect(KDWEffects.MAXIMIZATION);
        if (effect != null) {
            Maximization maximization = (Maximization) KDWEffects.MAXIMIZATION.get();
            maximization.applyEffectTick(player, effect.getAmplifier());
            player.setHealth(player.getMaxHealth());
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
