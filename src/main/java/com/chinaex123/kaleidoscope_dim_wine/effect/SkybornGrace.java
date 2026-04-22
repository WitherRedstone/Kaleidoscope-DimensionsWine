package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.mixin.EntityMixin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 苍穹之赐：增加移动速度并可以鞘翅飞行
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class SkybornGrace extends MobEffect {

    private static final ResourceLocation WINGS_SPEED_MODIFIER =
            ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wings_speed");

    private static final Set<UUID> FLYING_PLAYERS = new HashSet<>();

    public SkybornGrace(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            var instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                instance.removeModifier(WINGS_SPEED_MODIFIER);
                instance.addTransientModifier(new AttributeModifier(
                        WINGS_SPEED_MODIFIER,
                        0.10 * (amplifier + 1),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ));
            }
        }
        return true;
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        if (player.hasEffect(com.chinaex123.kaleidoscope_dim_wine.init.ModEffects.SKYBORN_GRACE)) {
            UUID playerId = player.getUUID();

            if (!player.onGround() && player.getDeltaMovement().y < -0.1) {
                FLYING_PLAYERS.add(playerId);
                ((EntityMixin) (Object) player).invokeSetSharedFlag(7, true);
            } else if (player.onGround()) {
                FLYING_PLAYERS.remove(playerId);
                ((EntityMixin) (Object) player).invokeSetSharedFlag(7, false);
            } else if (FLYING_PLAYERS.contains(playerId)) {
                ((EntityMixin) (Object) player).invokeSetSharedFlag(7, true);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof SkybornGrace) {
            LivingEntity entity = event.getEntity();
            var unboundEffect = entity.getEffect(ModEffects.UNBOUND_GRACE);
            if (unboundEffect != null) {
                entity.removeEffect(ModEffects.UNBOUND_GRACE);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        if (event.getEffect().value() instanceof SkybornGrace) {
            LivingEntity entity = event.getEntity();
            var instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                instance.removeModifier(WINGS_SPEED_MODIFIER);
            }

            FLYING_PLAYERS.remove(entity.getUUID());
            ((EntityMixin) (Object) entity).invokeSetSharedFlag(7, false);
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().value() instanceof SkybornGrace) {
            LivingEntity entity = event.getEntity();
            var instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                instance.removeModifier(WINGS_SPEED_MODIFIER);
            }

            FLYING_PLAYERS.remove(entity.getUUID());
            ((EntityMixin) (Object) entity).invokeSetSharedFlag(7, false);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
