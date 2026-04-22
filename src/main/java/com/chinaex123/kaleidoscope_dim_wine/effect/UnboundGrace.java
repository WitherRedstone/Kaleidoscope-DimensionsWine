package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * 无界之赐：启用创造飞行并在空中时移除挖掘惩罚
 */
@EventBusSubscriber
public class UnboundGrace extends MobEffect {

    private static final ResourceLocation FLYING_MODIFIER =
            ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "unbound_flying");

    private static final ResourceLocation MINING_SPEED_MODIFIER =
            ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "unbound_mining_speed");

    public UnboundGrace(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
        this.addAttributeModifier(NeoForgeMod.CREATIVE_FLIGHT, FLYING_MODIFIER, 1, Operation.ADD_VALUE);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        if (player.hasEffect(ModEffects.UNBOUND_GRACE)) {
            var instance = player.getAttribute(Attributes.BLOCK_BREAK_SPEED);
            if (instance != null) {
                if (!player.onGround()) {
                    if (instance.getModifier(MINING_SPEED_MODIFIER) == null) {
                        instance.addTransientModifier(new AttributeModifier(
                                MINING_SPEED_MODIFIER,
                                5,
                                Operation.ADD_MULTIPLIED_TOTAL
                        ));
                    }
                } else {
                    instance.removeModifier(MINING_SPEED_MODIFIER);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof UnboundGrace) {
            var entity = event.getEntity();
            var skybornEffect = entity.getEffect(ModEffects.SKYBORN_GRACE);
            if (skybornEffect != null) {
                entity.removeEffect(ModEffects.SKYBORN_GRACE);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        if (event.getEffect().value() instanceof UnboundGrace) {
            var entity = event.getEntity();
            var instance = entity.getAttribute(Attributes.BLOCK_BREAK_SPEED);
            if (instance != null) {
                instance.removeModifier(MINING_SPEED_MODIFIER);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof UnboundGrace) {
            var entity = event.getEntity();
            var instance = entity.getAttribute(Attributes.BLOCK_BREAK_SPEED);
            if (instance != null) {
                instance.removeModifier(MINING_SPEED_MODIFIER);
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
