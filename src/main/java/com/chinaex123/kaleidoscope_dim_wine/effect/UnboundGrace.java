package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
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

@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class UnboundGrace extends MobEffect {

    private static final Set<UUID> FLYING_PLAYERS = new HashSet<>();

    public UnboundGrace(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        var player = event.player;
        if (player.hasEffect(KDWEffects.UNBOUND_GRACE.get())) {
            var skybornEffect = player.getEffect(KDWEffects.SKYBORN_GRACE.get());
            if (skybornEffect != null) {
                player.removeEffect(KDWEffects.SKYBORN_GRACE.get());
            }

            UUID playerId = player.getUUID();

            player.getAbilities().mayfly = true;
            FLYING_PLAYERS.add(playerId);

            AttributeInstance instance = player.getAttribute(Attributes.FLYING_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:unbound_mining_speed",
                        5,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                );
                if (!player.onGround()) {

                    if (!instance.hasModifier(modifier)) {
                        instance.addTransientModifier(modifier);
                    }
                } else {
                    instance.removeModifier(modifier);
                }
            }
        } else if (FLYING_PLAYERS.contains(player.getUUID())) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            FLYING_PLAYERS.remove(player.getUUID());
        }
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        if (event.getEffect() instanceof UnboundGrace) {
            var entity = event.getEntity();
            if (entity instanceof net.minecraft.world.entity.player.Player player) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                FLYING_PLAYERS.remove(player.getUUID());
                player.onUpdateAbilities();
            }

            AttributeInstance instance = entity.getAttribute(Attributes.FLYING_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:unbound_mining_speed",
                        5,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                );
                instance.removeModifier(modifier);
            }
        }
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() instanceof UnboundGrace) {
            var entity = event.getEntity();
            if (entity instanceof net.minecraft.world.entity.player.Player player) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                FLYING_PLAYERS.remove(player.getUUID());
                player.onUpdateAbilities();
            }

            AttributeInstance instance = entity.getAttribute(Attributes.FLYING_SPEED);
            if (instance != null) {
                AttributeModifier modifier = new AttributeModifier(
                        "kaleidoscope_dim_wine:unbound_mining_speed",
                        5,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                );
                instance.removeModifier(modifier);
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, AttributeMap attributes, int amplifier) {
        if (entity instanceof Player player) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            FLYING_PLAYERS.remove(player.getUUID());
            player.onUpdateAbilities();
        }

        AttributeInstance instance = entity.getAttribute(Attributes.FLYING_SPEED);
        if (instance != null) {
            AttributeModifier modifier = new AttributeModifier(
                    "kaleidoscope_dim_wine:unbound_mining_speed",
                    5,
                    AttributeModifier.Operation.MULTIPLY_TOTAL
            );
            instance.removeModifier(modifier);
        }
        super.removeAttributeModifiers(entity, attributes, amplifier);
    }
}
