package com.chinaex123.kaleidoscope_dim_wine.event.Fluid;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class DragonBlood {

    private static final String DRAGON_BLOOD_NBT_KEY = "DragonBloodData"; // 这个功能的数据
    private static final String TIME_IN_FLUID_KEY = "TimeInFluid"; // 再留体内的时间
    private static final String HAS_REWARD_KEY = "HasReward"; // 是否已经获得过奖励
    private static final int REWARD_TIME_TICKS = 20 * 60 * 3; // 坚持的时间
    private static final int CLEAR_SIZE = 3; // 流体消失的半径

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) return;

        Player original = event.getOriginal();
        Player player = event.getEntity();

        // 复制 NBT 数据
        CompoundTag oldData = original.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        player.getPersistentData().put(DRAGON_BLOOD_NBT_KEY, oldData.copy());

        // 如果是服务端且已获得奖励，立即应用并设为满血
        if (!player.level().isClientSide() && oldData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
            player.setHealth(player.getMaxHealth());
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide()) {
            return;
        }

        BlockPos playerPos = player.blockPosition();
        boolean isInDragonBlood = level.getBlockState(playerPos).getBlock() == ModBlocks.DRAGON_BLOOD_FLUID.get() ||
                level.getFluidState(playerPos).is(ModFluids.DRAGON_BLOOD.get());

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);

        if (isInDragonBlood) {
            int timeInFluid = dragonBloodData.getInt(TIME_IN_FLUID_KEY) + 1;
            dragonBloodData.putInt(TIME_IN_FLUID_KEY, timeInFluid);

            player.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1));

            if (timeInFluid >= REWARD_TIME_TICKS && !dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
                giveReward(player, level, playerPos);
                dragonBloodData.putBoolean(HAS_REWARD_KEY, true);
                dragonBloodData.putInt(TIME_IN_FLUID_KEY, 0);
            }
        } else {
            dragonBloodData.putInt(TIME_IN_FLUID_KEY, 0);
        }

        player.getPersistentData().put(DRAGON_BLOOD_NBT_KEY, dragonBloodData);
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        if (dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }

        CompoundTag dragonBloodData = player.getPersistentData().getCompound(DRAGON_BLOOD_NBT_KEY);
        if (dragonBloodData.getBoolean(HAS_REWARD_KEY)) {
            applyHealthBoost(player);
            player.setHealth(player.getMaxHealth());
        }
    }

    private static void giveReward(Player player, Level level, BlockPos pos) {
        applyHealthBoost(player);
        player.setHealth(player.getMaxHealth());
        clearDragonBlood(level, pos);
    }

    private static void applyHealthBoost(Player player) {
        var healthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (healthAttr != null) {
            ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dragon_blood_health");
            if (!healthAttr.hasModifier(modifierId)) {
                healthAttr.addPermanentModifier(new AttributeModifier(
                        modifierId,
                        10.0,
                        AttributeModifier.Operation.ADD_VALUE
                ));
            }
        }
    }

    private static void clearDragonBlood(Level level, BlockPos centerPos) {
        int offset = (CLEAR_SIZE - 1) / 2;
        for (int x = -offset; x <= offset; x++) {
            for (int y = -offset; y <= offset; y++) {
                for (int z = -offset; z <= offset; z++) {
                    BlockPos currentPos = centerPos.offset(x, y, z);
                    if (level.getBlockState(currentPos).getBlock() == ModBlocks.DRAGON_BLOOD_FLUID.get()) {
                        level.setBlockAndUpdate(currentPos, Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }
    }
}