package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 霜寒：使生物冻结
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class Frostbite extends MobEffect {

    private static final Map<UUID, Integer> entityTickMap = new HashMap<>();

    public Frostbite(int color) {
        super(MobEffectCategory.HARMFUL, color);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED,
                "ce9dbc2a-ee3f-43f5-9df7-f7f1ee4915a9",
                -0.15,
                AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity.canFreeze() && amplifier > 0) {
            entity.setIsInPowderSnow(true);
            entity.setTicksFrozen(entity.getTicksFrozen() + (amplifier + 1) * 40);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.level.isClientSide()) {
            return;
        }

        ServerLevel level = (ServerLevel) event.level;
        for (LivingEntity entity : level.players()) {
            if (entity.hasEffect(KDWEffects.FROSTBITE.get())) {
                UUID entityId = entity.getUUID();
                int ticks = entityTickMap.getOrDefault(entityId, 0) + 1;

                if (ticks >= 20) {
                    entityTickMap.put(entityId, 0);
                    level.sendParticles(ParticleTypes.SNOWFLAKE,
                            entity.getX(), entity.getY() + entity.getBbHeight() / 2, entity.getZ(),
                            5, 0.3, 0.3, 0.3, 0.02);
                } else {
                    entityTickMap.put(entityId, ticks);
                }
            }
        }
    }
}
