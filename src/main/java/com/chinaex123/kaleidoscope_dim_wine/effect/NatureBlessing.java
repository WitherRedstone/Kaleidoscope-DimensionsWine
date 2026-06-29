package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 自然祝福：周围植物生长加速
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class NatureBlessing extends MobEffect {

    private static final int BASE_INTERVAL_TICKS = 100; // 基础间隔100 tick
    private static final int INTERVAL_REDUCTION_PER_LEVEL = 10; // 每级减少10 tick
    private static final int EFFECT_RADIUS = 2; // 影响范围半径 (块)

    private static final Map<UUID, Integer> playerTickMap = new HashMap<>(); // 玩家tick映射

    public NatureBlessing(int color) {
        super(MobEffectCategory.NEUTRAL, color);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        LivingEntity entity = event.player;

        if (entity.level().isClientSide()) {
            return;
        }

        MobEffectInstance effect = entity.getEffect(KDWEffects.NATURE_BLESSING.get());
        if (effect == null) {
            playerTickMap.remove(entity.getUUID());
            return;
        }

        int amplifier = effect.getAmplifier();
        int intervalTicks = BASE_INTERVAL_TICKS - (amplifier + 1) * INTERVAL_REDUCTION_PER_LEVEL;

        UUID playerId = entity.getUUID();
        int ticks = playerTickMap.getOrDefault(playerId, 0) + 1;

        if (ticks < intervalTicks) {
            playerTickMap.put(playerId, ticks);
            return;
        }

        playerTickMap.put(playerId, 0);

        if (!(entity.level() instanceof ServerLevel level)) {
            return;
        }

        BlockPos centerPos = entity.blockPosition();
        AABB area = new AABB(centerPos).inflate(EFFECT_RADIUS);

        BlockPos.betweenClosedStream(area).forEach(pos -> {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof BonemealableBlock bonemealable) {
                if (bonemealable.isValidBonemealTarget(level, pos, state, false)) {
                    if (bonemealable.isBonemealSuccess(level, level.random, pos, state)) {
                        bonemealable.performBonemeal(level, level.random, pos, state);
                        level.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                5, 0.3, 0.3, 0.3, 0.02);
                    }
                }
            }
        });
    }
}
