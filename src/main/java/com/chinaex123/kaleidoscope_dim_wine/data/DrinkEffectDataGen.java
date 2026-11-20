package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.datamap.data.DrinkEffectData;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.ToIntFunction;

public class DrinkEffectDataGen implements DataProvider {
    private static final int[] SLIGHTLY_TIPSY_DURATIONS = {45, 30, 30, 20, 10};

    private static final ToIntFunction<String> ORDER_FIELDS = Util.make(new Object2IntOpenHashMap<>(), map -> {
        map.put("item", 0);
        map.defaultReturnValue(1);
    });

    private final Map<String, DrinkEffectData> data = Maps.newLinkedHashMap();
    private final PackOutput output;

    public DrinkEffectDataGen(PackOutput output) {
        this.output = output;
    }

    private void addEntry() {
        addWithLevel2Effects(KDWItems.BOCCHI,
                List.of(effect(MobEffects.NIGHT_VISION, 90, 0)),
                List.of(effect(MobEffects.NIGHT_VISION, 480, 0)),
                List.of(effect(MobEffects.NIGHT_VISION, 1440, 0)),
                List.of(effect(MobEffects.NIGHT_VISION, 2880, 0))
        );

        addWithLevel2Effects(KDWItems.ABYSSAL_PORTER,
                List.of(effect(MobEffects.DAMAGE_BOOST, 60, 0), effect(MobEffects.NIGHT_VISION, 30, 0)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 180, 1), effect(MobEffects.NIGHT_VISION, 120, 0)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 300, 2), effect(MobEffects.NIGHT_VISION, 240, 0)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 600, 3), effect(MobEffects.NIGHT_VISION, 360, 0))
        );

        addWithLevel2Effects(KDWItems.BLACK_BONE_LAFITE,
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 60, 0), effect(MobEffects.WITHER, 30, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 180, 1), effect(MobEffects.WITHER, 20, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 300, 2), effect(MobEffects.WITHER, 10, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 600, 3), effect(MobEffects.WITHER, 5, 0))
        );

        addWithLevel2Effects(KDWItems.BLAZE_MARTELL,
                List.of(effect(KDWEffects.RAGE.get(), 60, 0), effect(MobEffects.FIRE_RESISTANCE, 30, 0)),
                List.of(effect(KDWEffects.RAGE.get(), 180, 1), effect(MobEffects.FIRE_RESISTANCE, 120, 0)),
                List.of(effect(KDWEffects.RAGE.get(), 300, 2), effect(MobEffects.FIRE_RESISTANCE, 240, 0)),
                List.of(effect(KDWEffects.RAGE.get(), 600, 3), effect(MobEffects.FIRE_RESISTANCE, 360, 0))
        );

        addWithLevel2Effects(KDWItems.BUDWEISER_BEER,
                List.of(effect(MobEffects.JUMP, 60, 0), effect(MobEffects.MOVEMENT_SPEED, 30, 0)),
                List.of(effect(MobEffects.JUMP, 180, 0), effect(MobEffects.MOVEMENT_SPEED, 120, 0)),
                List.of(effect(MobEffects.JUMP, 300, 0), effect(MobEffects.MOVEMENT_SPEED, 240, 0)),
                List.of(effect(MobEffects.JUMP, 600, 0), effect(MobEffects.MOVEMENT_SPEED, 360, 0))
        );

        addWithLevel2Effects(KDWItems.CHORUS_COGNAC,
                List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3))
        );

        addWithLevel2Effects(KDWItems.CRIMSON_CRESCENDO,
                List.of(effect(MobEffects.FIRE_RESISTANCE, 60, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 150, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 300, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 600, 0))
        );

        addWithLevel2Effects(KDWItems.DIVINE_EMBRYO_PORT,
                List.of(effect(KDWEffects.PARADOX.get(), 60, 0)),
                List.of(effect(KDWEffects.PARADOX.get(), 180, 1)),
                List.of(effect(KDWEffects.PARADOX.get(), 300, 2)),
                List.of(effect(KDWEffects.PARADOX.get(), 600, 3))
        );

        addAllLevels(KDWItems.DRACONIC_BLOOD_WINE,
                List.of(effect(MobEffects.CONFUSION, 30, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 45, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 60, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 30, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 20, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 180, 1), effect(MobEffects.LUCK, 120, 3)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 10, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 300, 2), effect(MobEffects.LUCK, 180, 5)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 5, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 600, 3), effect(MobEffects.LUCK, 240, 9))
        );

        addWithLevel2Effects(KDWItems.DRAGONS_BREATH_BRANDY,
                List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.DIG_SPEED, 90, 0)),
                List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.DIG_SPEED, 120, 1)),
                List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.DIG_SPEED, 480, 2)),
                List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.DIG_SPEED, 1440, 3))
        );

        addWithLevel2Effects(KDWItems.END_STARLIGHT,
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 30, 0), effect(MobEffects.REGENERATION, 30, 0)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 120, 1), effect(MobEffects.REGENERATION, 120, 1)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 240, 2), effect(MobEffects.REGENERATION, 180, 2)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 300, 3), effect(MobEffects.REGENERATION, 240, 3))
        );

        addWithLevel2Effects(KDWItems.ETHEREAL_NOBLE,
                List.of(effect(MobEffects.INVISIBILITY, 60, 0)),
                List.of(effect(MobEffects.INVISIBILITY, 180, 0)),
                List.of(effect(MobEffects.INVISIBILITY, 300, 0)),
                List.of(effect(MobEffects.INVISIBILITY, 600, 0))
        );

        addWithLevel2Effects(KDWItems.FORGOTTEN_MARGARITA,
                List.of(effect(KDWEffects.PAYBACK.get(), 60, 0)),
                List.of(effect(KDWEffects.PAYBACK.get(), 180, 1)),
                List.of(effect(KDWEffects.PAYBACK.get(), 300, 2)),
                List.of(effect(KDWEffects.PAYBACK.get(), 600, 3))
        );

        addWithLevel2Effects(AetherItems.GINGERBREAD_WARMER,
                List.of(effect(MobEffects.LUCK, 90, 0)),
                List.of(effect(MobEffects.LUCK, 480, 4)),
                List.of(effect(MobEffects.LUCK, 1440, 15)),
                List.of(effect(MobEffects.LUCK, 2880, 30))
        );

        addWithLevel2Effects(KDWItems.MAGMA_ROYAL_SALUTE,
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 60, 0), effect(MobEffects.FIRE_RESISTANCE, 30, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 180, 1), effect(MobEffects.FIRE_RESISTANCE, 120, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 300, 2), effect(MobEffects.FIRE_RESISTANCE, 240, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 600, 3), effect(MobEffects.FIRE_RESISTANCE, 360, 0))
        );

        addWithLevel2Effects(KDWItems.PHANTOM_DREAM_BUBBLE,
                List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3))
        );

        addWithLevel2Effects(KDWItems.SILENT_SHERRY,
                List.of(effect(MobEffects.DAMAGE_BOOST, 60, 0)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 180, 0)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 300, 1)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 600, 2))
        );

        addWithLevel2Effects(AetherItems.UNBOUND_SKYBORN,
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 30, 0)),
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 120, 0)),
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 240, 0)),
                List.of(effect(KDWEffects.UNBOUND_GRACE.get(), 360, 0))
        );

        addWithLevel2Effects(KDWItems.WART_HENNESSY,
                List.of(effect(MobEffects.FIRE_RESISTANCE, 60, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 180, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 300, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 600, 0))
        );

        // ==================== 暮色森林联动 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            addWithLevel2Effects(TwilightforestItems.RANGERS_SATCHEL,
                    List.of(effect(MobEffects.GLOWING, 60, 0)),
                    List.of(effect(MobEffects.GLOWING, 180, 1)),
                    List.of(effect(MobEffects.GLOWING, 300, 2)),
                    List.of(effect(MobEffects.GLOWING, 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.SNAKESKIN_LIQUEUR,
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            );

            addWithLevel2Effects(TwilightforestItems.DAWNLIGHT_DEW,
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.DEAD_END_SPITTLE,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.CAVE_GLOWBREW,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.DRUIDS_SECRET_BREW,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.EMBEREYE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 180, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 300, 2)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(KDWEffects.BLOODTHIRSTY.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.FROSTVEIN_BEASTBLOOD,
                    List.of(effect(KDWEffects.FROSTFALL.get(), 60, 0)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 180, 1)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 300, 2)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.GIANTS_HYMN,
                    List.of(effect(MobEffects.DAMAGE_BOOST, 30, 0)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 120, 1)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 240, 2)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 360, 3))
            );

            addWithLevel2Effects(TwilightforestItems.GOBLINS_STASH,
                    List.of(effect(MobEffects.DIG_SPEED, 30, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 120, 1)),
                    List.of(effect(MobEffects.DIG_SPEED, 240, 2)),
                    List.of(effect(MobEffects.DIG_SPEED, 360, 3))
            );

            addWithLevel2Effects(TwilightforestItems.MOORGLOW_BIRDS_SONG,
                    List.of(effect(MobEffects.SLOW_FALLING, 60, 0), effect(MobEffects.MOVEMENT_SPEED, 30, 0)),
                    List.of(effect(MobEffects.SLOW_FALLING, 180, 0), effect(MobEffects.MOVEMENT_SPEED, 120, 0)),
                    List.of(effect(MobEffects.SLOW_FALLING, 300, 0), effect(MobEffects.MOVEMENT_SPEED, 240, 1)),
                    List.of(effect(MobEffects.SLOW_FALLING, 600, 0), effect(MobEffects.MOVEMENT_SPEED, 360, 2))
            );

            addWithLevel2Effects(TwilightforestItems.PERENNIAL_FROST,
                    List.of(effect(KDWEffects.FROSTFALL.get(), 60, 0)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 180, 1)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 300, 2)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.STAGCALL_MONSOON,
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 60, 0)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 180, 1)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 300, 2)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 600, 3))
            );

            addWithLevel2Effects(TwilightforestItems.THORNHEART,
                    List.of(effect(MobEffects.ABSORPTION, 60, 0)),
                    List.of(effect(MobEffects.ABSORPTION, 180, 1)),
                    List.of(effect(MobEffects.ABSORPTION, 300, 2)),
                    List.of(effect(MobEffects.ABSORPTION, 600, 3))
            );

            }

        // ==================== 蜜蜂领域联动 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            addWithLevel2Effects(TheBumblezoneItems.BEESWAX_HONEY_WINE,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.FANTA,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.HONEYTHORN_MEAD,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.PEPSI,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.POLLEN_NECTAR,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0), effect(MobEffects.DAMAGE_BOOST, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1), effect(MobEffects.DAMAGE_BOOST, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2), effect(MobEffects.DAMAGE_BOOST, 180, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3), effect(MobEffects.DAMAGE_BOOST, 240, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.ROYAL_HONEY_BREW,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0), effect(MobEffects.DAMAGE_RESISTANCE, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1), effect(MobEffects.DAMAGE_RESISTANCE, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2), effect(MobEffects.DAMAGE_RESISTANCE, 240, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3), effect(MobEffects.DAMAGE_RESISTANCE, 360, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.SPRITE,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3))
            );

            addWithLevel2Effects(TheBumblezoneItems.SWEET_CRYSTAL_HONEY,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0), effect(MobEffects.HEALTH_BOOST, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1), effect(MobEffects.HEALTH_BOOST, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2), effect(MobEffects.HEALTH_BOOST, 180, 2)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3), effect(MobEffects.HEALTH_BOOST, 240, 3))
            );

            }

        // ==================== 天境联动 ====================
        if (ModList.get().isLoaded("aether")) {
            addWithLevel2Effects(AetherItems.DIVINE_ENERGY_MIST,
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 60, 0),
                            effect(MobEffects.INVISIBILITY, 30, 0),
                            effect(MobEffects.HUNGER, 30, 0)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 180, 1),
                            effect(MobEffects.INVISIBILITY, 120, 0),
                            effect(MobEffects.HUNGER, 20, 0)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 300, 2),
                            effect(MobEffects.INVISIBILITY, 240, 0),
                            effect(MobEffects.HUNGER, 10, 0)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 600, 3),
                            effect(MobEffects.INVISIBILITY, 360, 0),
                            effect(MobEffects.HUNGER, 5, 0)
                    )
            );

            addWithLevel2Effects(AetherItems.DIVINE_OFFERING_BREW,
                    List.of(effect(MobEffects.DIG_SPEED, 60, 0), effect(MobEffects.NIGHT_VISION, 30, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 180, 1), effect(MobEffects.NIGHT_VISION, 120, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 300, 2), effect(MobEffects.NIGHT_VISION, 240, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 600, 3), effect(MobEffects.NIGHT_VISION, 360, 0))
            );

            addWithLevel2Effects(AetherItems.GRAVITITE_DRUNK,
                    List.of(effect(MobEffects.JUMP, 60, 0), effect(MobEffects.SLOW_FALLING, 60, 0)),
                    List.of(effect(MobEffects.JUMP, 180, 1), effect(MobEffects.SLOW_FALLING, 180, 0)),
                    List.of(effect(MobEffects.JUMP, 300, 2), effect(MobEffects.SLOW_FALLING, 300, 0)),
                    List.of(effect(MobEffects.JUMP, 600, 3), effect(MobEffects.SLOW_FALLING, 600, 0))
            );

            addWithLevel2Effects(AetherItems.HEALING_ELIXIR,
                    List.of(effect(MobEffects.REGENERATION, 30, 0), effect(MobEffects.HEAL, 0, 0)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1), effect(MobEffects.HEAL, 0, 1)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2), effect(MobEffects.HEAL, 0, 2)),
                    List.of(effect(MobEffects.REGENERATION, 360, 4), effect(MobEffects.HEAL, 0, 3))
            );

            addWithLevel2Effects(AetherItems.SWET_FIZZ,
                    List.of(effect(MobEffects.REGENERATION, 30, 0)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2)),
                    List.of(effect(MobEffects.REGENERATION, 360, 3))
            );

            }
    }


    @SafeVarargs
    public final void add(RegistryObject<Item> key, List<DrinkEffectData.Entry>... levelAbove2) {
        var itemKey = ForgeRegistries.ITEMS.getKey(key.get());
        if (itemKey == null) {
            throw new IllegalArgumentException("Item not registered: " + key.getId());
        }
        this.add(itemKey.getPath(), key, levelAbove2);
    }

    private DrinkEffectData.Entry effect(MobEffect effect, int duration, int amplifier) {
        return new DrinkEffectData.Entry(effect, duration, amplifier, 1f);
    }

    private void addCocktail(RegistryObject<Item> key, DrinkEffectData.Entry... entries) {
        var itemKey = ForgeRegistries.ITEMS.getKey(key.get());
        if (itemKey == null) {
            throw new IllegalArgumentException("Item not registered: " + key.getId());
        }
        this.add(itemKey.getPath(), new DrinkEffectData(key.get(), List.of(List.of(entries))));
    }

    @SafeVarargs
    public final void add(String fileName, RegistryObject<Item> key, List<DrinkEffectData.Entry>... levelAbove2) {
        int length = levelAbove2.length;
        if (length == 0) {
            throw new IllegalArgumentException("At least one level above 2 must be provided");
        }
        this.addWithLevel2Effects(fileName, key,
                List.of(),
                levelAbove2[0],
                levelAbove2[Math.min(1, length - 1)],
                levelAbove2[Math.min(2, length - 1)],
                levelAbove2[Math.min(3, length - 1)]
        );
    }

    @SafeVarargs
    private void addWithLevel2Effects(RegistryObject<Item> key, List<DrinkEffectData.Entry>... levelAbove1) {
        var itemKey = ForgeRegistries.ITEMS.getKey(key.get());
        if (itemKey == null) {
            throw new IllegalArgumentException("Item not registered: " + key.getId());
        }
        this.addWithLevel2Effects(itemKey.getPath(), key, levelAbove1);
    }

    @SafeVarargs
    private void addWithLevel2Effects(String fileName, RegistryObject<Item> key,
                                      List<DrinkEffectData.Entry>... levelAbove1) {
        int length = levelAbove1.length;
        if (length == 0) {
            throw new IllegalArgumentException("At least one level above 1 must be provided");
        }

        var effects = Lists.<List<DrinkEffectData.Entry>>newArrayListWithExpectedSize(SLIGHTLY_TIPSY_DURATIONS.length + 1);
        // 等级 1，固定为反胃 30s
        effects.add(List.of(new DrinkEffectData.Entry(MobEffects.CONFUSION, 30, 0, 1f)));
        // 等级 2-6，除难以下咽外，都会额外附带对应时长的微醺效果
        for (int i = 0; i < SLIGHTLY_TIPSY_DURATIONS.length; i++) {
            effects.add(withSlightlyTipsy(SLIGHTLY_TIPSY_DURATIONS[i], levelAbove1[Math.min(i, length - 1)]));
        }

        this.add(fileName, new DrinkEffectData(key.get(), effects));
    }

    public void addAllLevels(RegistryObject<? extends Item> key,
                             List<DrinkEffectData.Entry> level1,
                             List<DrinkEffectData.Entry> level2,
                             List<DrinkEffectData.Entry> level3,
                             List<DrinkEffectData.Entry> level4,
                             List<DrinkEffectData.Entry> level5,
                             List<DrinkEffectData.Entry> level6) {
        var itemKey = BuiltInRegistries.ITEM.getKey(key.get());
        var effects = Lists.newArrayList(level1, level2, level3, level4, level5, level6);
        this.add(itemKey.getPath(), new DrinkEffectData(key.get(), effects));
    }

    private List<DrinkEffectData.Entry> withSlightlyTipsy(int duration, List<DrinkEffectData.Entry> entries) {
        var result = Lists.<DrinkEffectData.Entry>newArrayListWithExpectedSize(entries.size() + 1);
        result.add(effect(ModEffects.SLIGHTLY_TIPSY.get(), duration, 0));
        result.addAll(entries);
        return result;
    }

    public void add(String fileName, DrinkEffectData value) {
        this.data.put(fileName, value);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        this.addEntry();

        List<CompletableFuture<?>> futures = Lists.newArrayList();
        var pathProvider = this.output.createPathProvider(PackOutput.Target.DATA_PACK, "datamap/drink_effect");

        for (var entry : data.entrySet()) {
            DrinkEffectData.CODEC
                    .encodeStart(JsonOps.INSTANCE, entry.getValue())
                    .resultOrPartial(KaleidoscopeDimensionsWine.LOGGER::error)
                    .ifPresent(json -> {
                        var filePath = pathProvider.json(KaleidoscopeDimensionsWine.id(entry.getKey()));
                        var future = this.saveStable(cache, json, filePath);
                        futures.add(future);
                    });
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @SuppressWarnings("all")
    private CompletableFuture<?> saveStable(CachedOutput output, JsonElement json, Path path) {
        return CompletableFuture.runAsync(() -> {
            try {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                HashingOutputStream hashing = new HashingOutputStream(Hashing.sha1(), stream);

                try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(hashing, StandardCharsets.UTF_8))) {
                    writer.setSerializeNulls(false);
                    writer.setIndent("  ");
                    GsonHelper.writeValue(writer, json, Comparator.comparingInt(ORDER_FIELDS));
                }

                output.writeIfNeeded(path, stream.toByteArray(), hashing.hash());
            } catch (IOException ioexception) {
                KaleidoscopeDimensionsWine.LOGGER.error("Failed to save file to {}", path, ioexception);
            }
        }, Util.backgroundExecutor());
    }

    @Override
    public String getName() {
        return "Drink Effect Data";
    }
}
