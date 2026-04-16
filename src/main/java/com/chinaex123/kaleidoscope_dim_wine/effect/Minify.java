package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * 迷你化 - 缩小玩家体型
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Minify extends MobEffect {

    public Minify(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    private static final ResourceLocation SCALE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_scale");
    private static final ResourceLocation STEP_HEIGHT_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_step_height");
    private static final ResourceLocation ATTACK_DAMAGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_attack_damage");
    private static final ResourceLocation MAX_HEALTH_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_max_health");
    private static final ResourceLocation ENTITY_INTERACTION_RANGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_entity_interaction_range");
    private static final ResourceLocation BLOCK_INTERACTION_RANGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_block_interaction_range");
    private static final ResourceLocation MOVEMENT_SPEED_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_movement_speed");
    private static final ResourceLocation JUMP_STRENGTH_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_jump_strength");
    private static final ResourceLocation SAFE_FALL_DISTANCE_MODIFIER = ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "minify_safe_fall_distance");

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            // 实体体型缩放 - 实体体型缩放 = 最大值(0.01, 1.0 - (等级 + 1) × 0.15)
            double scale = Math.max(0.01, 1.0 - (amplifier + 1) * 0.15);
            updateAttribute(entity, Attributes.SCALE, SCALE_MODIFIER, scale - 1.0, AttributeModifier.Operation.ADD_VALUE);
            // 自动上台阶高度 - 自动上台阶高度 = -(0.05 + 等级 × 0.05)
            updateAttribute(entity, Attributes.STEP_HEIGHT, STEP_HEIGHT_MODIFIER, -(0.05 + amplifier * 0.05), AttributeModifier.Operation.ADD_VALUE);
            // 实体交互范围 - 实体交互范围 = -最小值((等级 + 1) × 0.25, 0.75)
            double entityRange = Math.min((amplifier + 1) * 0.25, 1.0 - 0.25);
            updateAttribute(entity, Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, -entityRange, AttributeModifier.Operation.ADD_VALUE);
            // 方块交互范围 - 方块交互范围 = -最小值((等级 + 1) × 0.25, 0.75)
            double blockRange = Math.min((amplifier + 1) * 0.25, 1.0 - 0.25);
            updateAttribute(entity, Attributes.BLOCK_INTERACTION_RANGE, BLOCK_INTERACTION_RANGE_MODIFIER, -blockRange, AttributeModifier.Operation.ADD_VALUE);
            // 攻击伤害 - 攻击伤害 = -最小值((等级 + 1) × 0.5, 0.5)
            double attackDamage = Math.min((amplifier + 1) * 0.5, 0.5);
            updateAttribute(entity, Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, -attackDamage, AttributeModifier.Operation.ADD_VALUE);
            // 最大生命值 - 最大生命值 = -最小值((等级 + 1) × 2.0, 基础最大生命值 - 2.0)
            double maxHealthReduction = Math.min((amplifier + 1) * 2.0, entity.getAttributeBaseValue(Attributes.MAX_HEALTH) - 2.0);
            updateAttribute(entity, Attributes.MAX_HEALTH, MAX_HEALTH_MODIFIER, -maxHealthReduction, AttributeModifier.Operation.ADD_VALUE);
            // 移动速度 - 移动速度 = 最小值((等级 + 1) × 0.05, 1.0)
            double movementSpeed = Math.min((amplifier + 1) * 0.05, 1.0);
            updateAttribute(entity, Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_MODIFIER, movementSpeed, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
            // 跳跃力度 - 跳跃力度 = 最小值(0.08 + (等级 + 1) × 0.05, 5)
            double jumpStrength = Math.min(0.08 + (amplifier + 1) * 0.05, 5);
            updateAttribute(entity, Attributes.JUMP_STRENGTH, JUMP_STRENGTH_MODIFIER, jumpStrength, AttributeModifier.Operation.ADD_VALUE);
            // 安全坠落高度 - 安全坠落高度 = (等级 + 1) × 0.5
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

        var effect = player.getEffect(ModEffects.MINIFY);
        if (effect != null) {
            Minify minify = (Minify) ModEffects.MINIFY.get();
            minify.applyEffectTick(player, effect.getAmplifier());
            player.setHealth(player.getMaxHealth());
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
