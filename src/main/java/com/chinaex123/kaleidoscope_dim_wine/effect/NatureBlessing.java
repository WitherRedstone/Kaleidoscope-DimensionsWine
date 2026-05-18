package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 自然祝福：周围植物生长加速
 */
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class NatureBlessing extends MobEffect {

    private static final Map<UUID, Integer> playerTickMap = new HashMap<>();

    public NatureBlessing(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        LivingEntity entity = event.getEntity();

        if (entity.level().isClientSide()) {
            return;
        }

        var effect = entity.getEffect(KDWEffects.NATURE_BLESSING);
        if (effect == null) {
            playerTickMap.remove(entity.getUUID());
            return;
        }

        int amplifier = effect.getAmplifier();
        int intervalTicks = 100 - (amplifier + 1) * 10;

        UUID playerId = entity.getUUID();
        int ticks = playerTickMap.getOrDefault(playerId, 0) + 1;

        if (ticks < intervalTicks) {
            playerTickMap.put(playerId, ticks);
            return;
        }

        playerTickMap.put(playerId, 0);

        ServerLevel level = (ServerLevel) entity.level();
        BlockPos centerPos = entity.blockPosition();
        AABB area = new AABB(centerPos).inflate(2);

        BlockPos.betweenClosedStream(area).forEach(pos -> {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof BonemealableBlock bonemealable) {
                if (bonemealable.isValidBonemealTarget(level, pos, state)) {
                    bonemealable.performBonemeal(level, level.random, pos, state);
                    level.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                            pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                            5, 0.3, 0.3, 0.3, 0.02);
                }
            }
        });
    }
}
