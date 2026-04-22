package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.mixin.EntityMixin;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 苍穹之赐：增加移动速度并可以鞘翅飞行
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class SkybornGrace extends MobEffect {

    private static final Set<UUID> FLYING_PLAYERS = new HashSet<>();

    public SkybornGrace(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof net.minecraft.world.entity.player.Player player) {
            var unboundEffect = player.getEffect(ModEffects.UNBOUND_GRACE.get());
            if (unboundEffect != null) {
                player.removeEffect(ModEffects.UNBOUND_GRACE.get());
            }
        }

        if (!entity.level().isClientSide()) {
            AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:wings_speed",
                        0.10 * (amplifier + 1),
                        AttributeModifier.Operation.MULTIPLY_BASE
                );

                if (!instance.hasModifier(modifier)) {
                    instance.addTransientModifier(modifier);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        var player = event.player;
        if (player.hasEffect(ModEffects.SKYBORN_GRACE.get())) {
            UUID playerId = player.getUUID();

            if (!player.onGround() && player.getDeltaMovement().y < -0.1) {
                FLYING_PLAYERS.add(playerId);
                setPlayerFlying(player, true);
            } else if (player.onGround()) {
                FLYING_PLAYERS.remove(playerId);
                setPlayerFlying(player, false);
            } else if (FLYING_PLAYERS.contains(playerId)) {
                setPlayerFlying(player, true);
            }
        }
    }

    private static void setPlayerFlying(Player player, boolean flying) {
        EntityMixin mixin = (EntityMixin) (Object) player;
        mixin.invokeSetSharedFlag(7, flying);
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        if (event.getEffect() instanceof SkybornGrace) {
            LivingEntity entity = event.getEntity();
            AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:wings_speed",
                        0.10,
                        AttributeModifier.Operation.MULTIPLY_BASE
                );
                instance.removeModifier(modifier);
            }

            FLYING_PLAYERS.remove(entity.getUUID());
            ((EntityMixin) (Object) entity).invokeSetSharedFlag(7, false);
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() instanceof SkybornGrace) {
            LivingEntity entity = event.getEntity();
            AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:wings_speed",
                        0.10,
                        AttributeModifier.Operation.MULTIPLY_BASE
                );
                instance.removeModifier(modifier);
            }

            FLYING_PLAYERS.remove(entity.getUUID());
            ((EntityMixin) (Object) entity).invokeSetSharedFlag(7, false);
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, net.minecraft.world.entity.ai.attributes.AttributeMap attributes, int amplifier) {
        AttributeInstance instance = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (instance != null) {
            AttributeModifier modifier = new AttributeModifier(
                    "kaleidoscope_dim_wine:wings_speed",
                    0.10 * (amplifier + 1),
                    AttributeModifier.Operation.MULTIPLY_BASE
            );
            instance.removeModifier(modifier);
        }

        FLYING_PLAYERS.remove(entity.getUUID());
        ((EntityMixin) (Object) entity).invokeSetSharedFlag(7, false);

        super.removeAttributeModifiers(entity, attributes, amplifier);
    }
}
