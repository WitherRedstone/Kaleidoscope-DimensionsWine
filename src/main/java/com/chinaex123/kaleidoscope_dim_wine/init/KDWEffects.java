package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.effect.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public interface KDWEffects {
    DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, KaleidoscopeDimensionsWine.MOD_ID);

    // 枯斩：攻击敌人可以对方并对敌人造成凋零
    RegistryObject<MobEffect> WITHERED_SLASH = EFFECTS.register("withered_slash", () -> new WitheredSlash(0x5A4A3A));
    // 狂怒：增加攻击速度和伤害
    RegistryObject<MobEffect> RAGE = EFFECTS.register("rage", () -> new Rage(0xC41E3A));
    // 火焰攻击：攻击敌人时使对方燃烧
    RegistryObject<MobEffect> FIRE_ATTACK = EFFECTS.register("fire_attack", () -> new FireAttack(0xFF6B00));
    // 后发制人：抵消一次受到的伤害，并提升下一次攻击造成的伤害
    RegistryObject<MobEffect> PAYBACK = EFFECTS.register("payback", () -> new Payback(0x4A90C4));
    // 嗜血：攻击时，恢复相当于造成伤害 25% 的生命值
    RegistryObject<MobEffect> BLOODTHIRSTY = EFFECTS.register("bloodthirsty", () -> new Bloodthirsty(0x8B0000));
    // 悖论：伤害转治疗，治疗时反伤。死亡时若带效果，以半颗心复活并清除效果
    RegistryObject<MobEffect> PARADOX = EFFECTS.register("paradox", () -> new Paradox(0x9B30FF));
    // 硬化：按百分比减免所有来源的伤害
    RegistryObject<MobEffect> HARDENED = EFFECTS.register("hardened", () -> new Hardened(0x8B4513));
    // 自然祝福：周围植物生长加速
    RegistryObject<MobEffect> NATURE_BLESSING = EFFECTS.register("nature_blessing", () -> new NatureBlessing(0x228B22));
    // 霜寒：使生物冻结
    RegistryObject<MobEffect> FROSTBITE = EFFECTS.register("frostbite", () -> new Frostbite(0x00BFFF));
    // 霜降：攻击生物时，使生物获得霜寒效果
    RegistryObject<MobEffect> FROSTFALL = EFFECTS.register("frostfall", () -> new Frostfall(0x87CEEB));
    // 高兴：增加移动速度，攻击或受伤时移除
    RegistryObject<MobEffect> HAPPY = EFFECTS.register("happy", () -> new Happy(0xFFD700));
    // 苍穹之赐：增加移动速度并可以鞘翅飞行
    RegistryObject<MobEffect> SKYBORN_GRACE = EFFECTS.register("skyborn_grace", () -> new SkybornGrace(0x97CAE4));
    // 无界之赐：启用创造飞行并在空中时移除挖掘惩罚
    RegistryObject<MobEffect> UNBOUND_GRACE = EFFECTS.register("unbound_grace", () -> new UnboundGrace(0x97CAE4));

     static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }
}
