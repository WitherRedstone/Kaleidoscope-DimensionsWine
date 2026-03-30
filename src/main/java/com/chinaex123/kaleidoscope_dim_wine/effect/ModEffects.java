package com.chinaex123.kaleidoscope_dim_wine.effect;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.effect.event.FireAttack;
import com.chinaex123.kaleidoscope_dim_wine.effect.event.Rage;
import com.chinaex123.kaleidoscope_dim_wine.effect.event.WitheredSlash;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, KaleidoscopeDimensionsWine.MOD_ID);

    // 枯斩 - 攻击敌人可以对方并对敌人造成凋零
    public static final DeferredHolder<MobEffect, MobEffect> WITHERED_SLASH =
            EFFECTS.register("withered_slash", () -> new WitheredSlash(0x3A2E1F));
    // 狂怒 - 增加攻击速度和伤害
    public static final DeferredHolder<MobEffect, MobEffect> RAGE =
            EFFECTS.register("rage", () -> new Rage(0x3A2E1F));
    // 火焰攻击 - 攻击敌人时使对方燃烧
    public static final DeferredHolder<MobEffect, MobEffect> FIRE_ATTACK =
            EFFECTS.register("fire_attack", () -> new FireAttack(0x3A2E1F));

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }
}
