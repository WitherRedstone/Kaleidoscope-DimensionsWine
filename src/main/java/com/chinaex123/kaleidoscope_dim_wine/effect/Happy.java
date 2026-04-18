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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/**
 * 高兴：增加移动速度，攻击或受伤时移除
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Happy extends MobEffect {

    private static final ResourceLocation HAPPY_SPEED_MODIFIER =
            ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "happy_speed");

    public Happy(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            var instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                instance.removeModifier(HAPPY_SPEED_MODIFIER);
                instance.addTransientModifier(new AttributeModifier(
                        HAPPY_SPEED_MODIFIER,
                        0.15 * (amplifier + 1),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ));
            }
        }
        return true;
    }

    private static void removeBonus(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation id) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            instance.removeModifier(id);
        }
    }

    /**
     * 监听受到伤害事件 - 移除高兴效果
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(ModEffects.HAPPY)) {
            removeBonus(entity, Attributes.MOVEMENT_SPEED, HAPPY_SPEED_MODIFIER);
            entity.removeEffect(ModEffects.HAPPY);
        }
    }

    /**
     * 监听攻击事件 - 移除高兴效果
     */
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Post event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(ModEffects.HAPPY)) {
                removeBonus(attacker, Attributes.MOVEMENT_SPEED, HAPPY_SPEED_MODIFIER);
                attacker.removeEffect(ModEffects.HAPPY);
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
