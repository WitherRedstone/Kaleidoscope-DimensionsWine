package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.datamap.data.DrinkEffectData;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DrinkEffectDataGen implements DataProvider {
    /** 等级 2-6 固定附带的微醺时长 */
    private static final int[] SLIGHTLY_TIPSY_DURATIONS = {45, 30, 20, 10, 5};

    private final PackOutput.PathProvider pathProvider;
    private final Map<String, DrinkEffectData> data = new LinkedHashMap<>();
    private final Map<String, String> conditions = new LinkedHashMap<>();

    public DrinkEffectDataGen(PackOutput output) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "datamap/drink_effect");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        gather();
        List<CompletableFuture<?>> futures = new ArrayList<>();
        this.data.forEach((name, drinkEffect) -> DrinkEffectData.CODEC
                .encodeStart(JsonOps.INSTANCE, drinkEffect)
                .resultOrPartial(error -> KaleidoscopeDimensionsWine.LOGGER
                        .error("饮品效果 {} 编码失败: {}", name, error))
                .ifPresent(json -> {
                    addCondition(json, this.conditions.get(name));
                    futures.add(DataProvider.saveStable(cache, json,
                            this.pathProvider.json(KaleidoscopeDimensionsWine.id(name))));
                }));
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Drink Effect Data";
    }

    private void gather() {
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
        addWithLevel2Effects(KDWItems.BLACK_BONE_LAFITE, 35,
                List.of(effect(KDWEffects.WITHERED_SLASH, 60, 0), effect(MobEffects.WITHER, 30, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH, 180, 1), effect(MobEffects.WITHER, 20, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH, 300, 2), effect(MobEffects.WITHER, 10, 0)),
                List.of(effect(KDWEffects.WITHERED_SLASH, 600, 3), effect(MobEffects.WITHER, 5, 0))
        );
        addWithLevel2Effects(KDWItems.BLAZE_MARTELL,
                List.of(effect(KDWEffects.RAGE, 60, 0), effect(MobEffects.FIRE_RESISTANCE, 30, 0)),
                List.of(effect(KDWEffects.RAGE, 180, 1), effect(MobEffects.FIRE_RESISTANCE, 120, 0)),
                List.of(effect(KDWEffects.RAGE, 300, 2), effect(MobEffects.FIRE_RESISTANCE, 240, 0)),
                List.of(effect(KDWEffects.RAGE, 600, 3), effect(MobEffects.FIRE_RESISTANCE, 360, 0))
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
                List.of(effect(KDWEffects.PARADOX, 60, 0)),
                List.of(effect(KDWEffects.PARADOX, 180, 1)),
                List.of(effect(KDWEffects.PARADOX, 300, 2)),
                List.of(effect(KDWEffects.PARADOX, 600, 3))
        );
        addFull(KDWItems.DRACONIC_BLOOD_WINE,
                List.of(effect(MobEffects.CONFUSION, 30, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY, 45, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY, 60, 0), effect(KDWEffects.BLOODTHIRSTY, 30, 0)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY, 20, 0), effect(KDWEffects.BLOODTHIRSTY, 180, 1), effect(MobEffects.LUCK, 120, 3)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY, 10, 0), effect(KDWEffects.BLOODTHIRSTY, 300, 2), effect(MobEffects.LUCK, 180, 5)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY, 5, 0), effect(KDWEffects.BLOODTHIRSTY, 600, 3), effect(MobEffects.LUCK, 240, 9))
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
                List.of(effect(KDWEffects.PAYBACK, 60, 0)),
                List.of(effect(KDWEffects.PAYBACK, 180, 1)),
                List.of(effect(KDWEffects.PAYBACK, 300, 2)),
                List.of(effect(KDWEffects.PAYBACK, 600, 3))
        );
        addWithLevel2Effects(KDWItems.MAGMA_ROYAL_SALUTE,
                List.of(effect(KDWEffects.FIRE_ATTACK, 60, 0), effect(MobEffects.FIRE_RESISTANCE, 30, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK, 180, 1), effect(MobEffects.FIRE_RESISTANCE, 120, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK, 300, 2), effect(MobEffects.FIRE_RESISTANCE, 240, 0)),
                List.of(effect(KDWEffects.FIRE_ATTACK, 600, 3), effect(MobEffects.FIRE_RESISTANCE, 360, 0))
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
        addWithLevel2Effects(KDWItems.WART_HENNESSY,
                List.of(effect(MobEffects.FIRE_RESISTANCE, 60, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 180, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 300, 0)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 600, 0))
        );

        // ==================== 暮色森林联动 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            addWithLevel2Effects("twilightforest", TwilightforestItems.SNAKESKIN_LIQUEUR,
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.CAVE_GLOWBREW,
                    List.of(effect(KDWEffects.HARDENED, 60, 0)),
                    List.of(effect(KDWEffects.HARDENED, 180, 1)),
                    List.of(effect(KDWEffects.HARDENED, 300, 2)),
                    List.of(effect(KDWEffects.HARDENED, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.DAWNLIGHT_DEW,
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.DEAD_END_SPITTLE,
                    List.of(effect(KDWEffects.HARDENED, 60, 0)),
                    List.of(effect(KDWEffects.HARDENED, 180, 1)),
                    List.of(effect(KDWEffects.HARDENED, 300, 2)),
                    List.of(effect(KDWEffects.HARDENED, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.DRUIDS_SECRET_BREW,
                    List.of(effect(KDWEffects.HARDENED, 60, 0)),
                    List.of(effect(KDWEffects.HARDENED, 180, 1)),
                    List.of(effect(KDWEffects.HARDENED, 300, 2)),
                    List.of(effect(KDWEffects.HARDENED, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.EMBEREYE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(KDWEffects.BLOODTHIRSTY, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(KDWEffects.BLOODTHIRSTY, 180, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(KDWEffects.BLOODTHIRSTY, 300, 2)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(KDWEffects.BLOODTHIRSTY, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.FROSTVEIN_BEASTBLOOD,
                    List.of(effect(KDWEffects.FROSTFALL, 60, 0)),
                    List.of(effect(KDWEffects.FROSTFALL, 180, 1)),
                    List.of(effect(KDWEffects.FROSTFALL, 300, 2)),
                    List.of(effect(KDWEffects.FROSTFALL, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.GIANTS_HYMN,
                    List.of(effect(KDWEffects.MAXIMIZATION, 30, 0)),
                    List.of(effect(KDWEffects.MAXIMIZATION, 120, 1)),
                    List.of(effect(KDWEffects.MAXIMIZATION, 240, 2)),
                    List.of(effect(KDWEffects.MAXIMIZATION, 360, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.GOBLINS_STASH,
                    List.of(effect(KDWEffects.MINIFY, 30, 0)),
                    List.of(effect(KDWEffects.MINIFY, 120, 1)),
                    List.of(effect(KDWEffects.MINIFY, 240, 2)),
                    List.of(effect(KDWEffects.MINIFY, 360, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.MOORGLOW_BIRDS_SONG,
                    List.of(effect(MobEffects.SLOW_FALLING, 60, 0), effect(MobEffects.MOVEMENT_SPEED, 30, 0)),
                    List.of(effect(MobEffects.SLOW_FALLING, 180, 0), effect(MobEffects.MOVEMENT_SPEED, 120, 0)),
                    List.of(effect(MobEffects.SLOW_FALLING, 300, 0), effect(MobEffects.MOVEMENT_SPEED, 240, 1)),
                    List.of(effect(MobEffects.SLOW_FALLING, 600, 0), effect(MobEffects.MOVEMENT_SPEED, 360, 2))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.PERENNIAL_FROST,
                    List.of(effect(KDWEffects.FROSTFALL, 60, 0)),
                    List.of(effect(KDWEffects.FROSTFALL, 180, 1)),
                    List.of(effect(KDWEffects.FROSTFALL, 300, 2)),
                    List.of(effect(KDWEffects.FROSTFALL, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.RANGERS_SATCHEL,
                    List.of(effect(MobEffects.GLOWING, 60, 0)),
                    List.of(effect(MobEffects.GLOWING, 180, 1)),
                    List.of(effect(MobEffects.GLOWING, 300, 2)),
                    List.of(effect(MobEffects.GLOWING, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.STAGCALL_MONSOON,
                    List.of(effect(KDWEffects.NATURE_BLESSING, 60, 0)),
                    List.of(effect(KDWEffects.NATURE_BLESSING, 180, 1)),
                    List.of(effect(KDWEffects.NATURE_BLESSING, 300, 2)),
                    List.of(effect(KDWEffects.NATURE_BLESSING, 600, 3))
            );
            addWithLevel2Effects("twilightforest", TwilightforestItems.THORNHEART,
                    List.of(effect(MobEffects.ABSORPTION, 60, 0)),
                    List.of(effect(MobEffects.ABSORPTION, 180, 1)),
                    List.of(effect(MobEffects.ABSORPTION, 300, 2)),
                    List.of(effect(MobEffects.ABSORPTION, 600, 3))
            );

            }

        // ==================== 蜜蜂领域联动 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.BEESWAX_HONEY_WINE,
                    List.of(effect(KDWEffects.HAPPY, 60, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.FANTA,
                    List.of(effect(KDWEffects.HAPPY, 60, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.HONEYTHORN_MEAD,
                    List.of(effect(KDWEffects.HAPPY, 60, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.PEPSI,
                    List.of(effect(KDWEffects.HAPPY, 60, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.POLLEN_NECTAR,
                    List.of(effect(KDWEffects.HAPPY, 60, 0), effect(MobEffects.DAMAGE_BOOST, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1), effect(MobEffects.DAMAGE_BOOST, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2), effect(MobEffects.DAMAGE_BOOST, 180, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3), effect(MobEffects.DAMAGE_BOOST, 240, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.ROYAL_HONEY_BREW,
                    List.of(effect(KDWEffects.HAPPY, 60, 0), effect(MobEffects.DAMAGE_RESISTANCE, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1), effect(MobEffects.DAMAGE_RESISTANCE, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2), effect(MobEffects.DAMAGE_RESISTANCE, 240, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3), effect(MobEffects.DAMAGE_RESISTANCE, 360, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.SPRITE,
                    List.of(effect(KDWEffects.HAPPY, 60, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3))
            );
            addWithLevel2Effects("the_bumblezone", TheBumblezoneItems.SWEET_CRYSTAL_HONEY,
                    List.of(effect(KDWEffects.HAPPY, 60, 0), effect(MobEffects.HEALTH_BOOST, 30, 0)),
                    List.of(effect(KDWEffects.HAPPY, 180, 1), effect(MobEffects.HEALTH_BOOST, 120, 1)),
                    List.of(effect(KDWEffects.HAPPY, 300, 2), effect(MobEffects.HEALTH_BOOST, 180, 2)),
                    List.of(effect(KDWEffects.HAPPY, 600, 3), effect(MobEffects.HEALTH_BOOST, 240, 3))
            );

            }

        // ==================== 天境联动 ====================
        if (ModList.get().isLoaded("aether")) {
            addWithLevel2Effects(AetherItems.GINGERBREAD_WARMER,
                    List.of(effect(MobEffects.LUCK, 90, 0)),
                    List.of(effect(MobEffects.LUCK, 480, 4)),
                    List.of(effect(MobEffects.LUCK, 1440, 15)),
                    List.of(effect(MobEffects.LUCK, 2880, 30))
            );

            addWithLevel2Effects(AetherItems.UNBOUND_SKYBORN,
                    List.of(effect(KDWEffects.SKYBORN_GRACE, 30, 0)),
                    List.of(effect(KDWEffects.SKYBORN_GRACE, 120, 0)),
                    List.of(effect(KDWEffects.SKYBORN_GRACE, 240, 0)),
                    List.of(effect(KDWEffects.UNBOUND_GRACE, 360, 0))
            );

            addWithLevel2Effects("aether", AetherItems.DIVINE_ENERGY_MIST,
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0), effect(MobEffects.INVISIBILITY, 30, 0), effect(MobEffects.HUNGER, 30, 0)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1), effect(MobEffects.INVISIBILITY, 120, 0), effect(MobEffects.HUNGER, 20, 0)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2), effect(MobEffects.INVISIBILITY, 240, 0), effect(MobEffects.HUNGER, 10, 0)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3), effect(MobEffects.INVISIBILITY, 360, 0), effect(MobEffects.HUNGER, 5, 0))
            );

            addWithLevel2Effects("aether", AetherItems.DIVINE_OFFERING_BREW,
                    List.of(effect(MobEffects.DIG_SPEED, 60, 0), effect(MobEffects.NIGHT_VISION, 30, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 180, 1), effect(MobEffects.NIGHT_VISION, 120, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 300, 2), effect(MobEffects.NIGHT_VISION, 240, 0)),
                    List.of(effect(MobEffects.DIG_SPEED, 600, 3), effect(MobEffects.NIGHT_VISION, 360, 0))
            );

            addWithLevel2Effects("aether", AetherItems.GRAVITITE_DRUNK,
                    List.of(effect(MobEffects.JUMP, 60, 0), effect(MobEffects.SLOW_FALLING, 60, 0)),
                    List.of(effect(MobEffects.JUMP, 180, 1), effect(MobEffects.SLOW_FALLING, 180, 0)),
                    List.of(effect(MobEffects.JUMP, 300, 2), effect(MobEffects.SLOW_FALLING, 300, 0)),
                    List.of(effect(MobEffects.JUMP, 600, 3), effect(MobEffects.SLOW_FALLING, 600, 0))
            );

            addWithLevel2Effects("aether", AetherItems.HEALING_ELIXIR,
                    List.of(effect(MobEffects.REGENERATION, 30, 0), effect(MobEffects.HEAL, 0, 0)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1), effect(MobEffects.HEAL, 0, 1)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2), effect(MobEffects.HEAL, 0, 2)),
                    List.of(effect(MobEffects.REGENERATION, 360, 4), effect(MobEffects.HEAL, 0, 3))
            );

            addWithLevel2Effects("aether", AetherItems.SWET_FIZZ,
                    List.of(effect(MobEffects.REGENERATION, 30, 0)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2)),
                    List.of(effect(MobEffects.REGENERATION, 360, 3))
            );

            }

        // ==================== 永恒星光联动 ====================
        if (ModList.get().isLoaded("eternal_starlight")) {
            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.ABYSS,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.WATER_BREATHING, 90, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.WATER_BREATHING, 480, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.WATER_BREATHING, 1440, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.WATER_BREATHING, 2880, 0))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.AURORA,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.JUMP, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.JUMP, 180, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.JUMP, 300, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.JUMP, 600, 1))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.BLAZING_SUN,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.FIRE_RESISTANCE, 90, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.FIRE_RESISTANCE, 480, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.FIRE_RESISTANCE, 1440, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.FIRE_RESISTANCE, 2880, 0))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.BLOOD_MOON,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.REGENERATION, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.REGENERATION, 180, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.REGENERATION, 300, 2)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.REGENERATION, 600, 3))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.DEEP_FREEZE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.DAMAGE_RESISTANCE, 60, 0), effect(MobEffects.MOVEMENT_SLOWDOWN, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 1), effect(MobEffects.DAMAGE_RESISTANCE, 180, 0), effect(MobEffects.MOVEMENT_SLOWDOWN, 180, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 2), effect(MobEffects.DAMAGE_RESISTANCE, 300, 1), effect(MobEffects.MOVEMENT_SLOWDOWN, 300, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 3), effect(MobEffects.DAMAGE_RESISTANCE, 600, 2), effect(MobEffects.MOVEMENT_SLOWDOWN, 600, 2))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.DIVINITY,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.DAMAGE_BOOST, 30, 0), effect(MobEffects.REGENERATION, 30, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.DAMAGE_BOOST, 120, 1), effect(MobEffects.REGENERATION, 120, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.DAMAGE_BOOST, 240, 2), effect(MobEffects.REGENERATION, 240, 2)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.DAMAGE_BOOST, 360, 3), effect(MobEffects.REGENERATION, 360, 3))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.ECLIPSE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.FIRE_RESISTANCE, 60, 0), effect(MobEffects.GLOWING, 20, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.FIRE_RESISTANCE, 180, 0), effect(MobEffects.GLOWING, 120, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.FIRE_RESISTANCE, 300, 0), effect(MobEffects.GLOWING, 240, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.FIRE_RESISTANCE, 600, 0), effect(MobEffects.GLOWING, 360, 0))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.LUNAR_ECLIPSE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.INVISIBILITY, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.INVISIBILITY, 180, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.INVISIBILITY, 300, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.INVISIBILITY, 600, 0))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.STAR_TRAIL,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.DIG_SPEED, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.DIG_SPEED, 180, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.DIG_SPEED, 2, 300)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.DIG_SPEED, 600, 3))
            );

            addWithLevel2Effects("eternal_starlight", EternalStarlightItems.WIND_TRACE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0), effect(MobEffects.MOVEMENT_SPEED, 60, 0)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0), effect(MobEffects.MOVEMENT_SPEED, 180, 1)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0), effect(MobEffects.MOVEMENT_SPEED, 300, 2)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0), effect(MobEffects.MOVEMENT_SPEED, 600, 3))
            );

            }
    }

    @SafeVarargs
    private void addWithLevel2Effects(DeferredItem<Item> item, List<DrinkEffectData.Entry>... levelAbove1) {
        addWithLevel2Effects(item, 30, levelAbove1);
    }

    @SafeVarargs
    private void addWithLevel2Effects(DeferredItem<Item> item, int confusionDuration,
                                      List<DrinkEffectData.Entry>... levelAbove1) {
        put(BuiltInRegistries.ITEM.getKey(item.get()).getPath(), null, item, confusionDuration, levelAbove1);
    }

    @SafeVarargs
    private void addWithLevel2Effects(String modId, DeferredItem<Item> item,
                                      List<DrinkEffectData.Entry>... levelAbove1) {
        put(BuiltInRegistries.ITEM.getKey(item.get()).getPath(), modId, item, 30, levelAbove1);
    }

    @SafeVarargs
    private void addFull(DeferredItem<Item> item, List<DrinkEffectData.Entry>... levels) {
        addFull(null, item, levels);
    }

    @SafeVarargs
    private void addFull(String modId, DeferredItem<Item> item, List<DrinkEffectData.Entry>... levels) {
        String name = BuiltInRegistries.ITEM.getKey(item.get()).getPath();
        if (modId != null) {
            this.conditions.put(name, modId);
        }
        this.data.put(name, new DrinkEffectData(item.get().builtInRegistryHolder(), List.of(levels)));
    }

    @SafeVarargs
    private void put(String name, String modId, DeferredItem<Item> item, int confusionDuration,
                     List<DrinkEffectData.Entry>... levelAbove1) {
        int length = levelAbove1.length;
        if (length == 0) {
            throw new IllegalArgumentException("等级 2 以上至少需要一个等级的效果");
        }
        if (modId != null) {
            this.conditions.put(name, modId);
        }
        List<List<DrinkEffectData.Entry>> effects = new ArrayList<>(SLIGHTLY_TIPSY_DURATIONS.length + 1);
        // 等级 1：反胃
        effects.add(List.of(new DrinkEffectData.Entry(MobEffects.CONFUSION, confusionDuration, 0, 1.0F)));
        // 等级 2-6：固定附带微醺，再叠加专属效果
        for (int i = 0; i < SLIGHTLY_TIPSY_DURATIONS.length; i++) {
            List<DrinkEffectData.Entry> extra = levelAbove1[Math.min(i, length - 1)];
            List<DrinkEffectData.Entry> merged = new ArrayList<>(extra.size() + 1);
            merged.add(new DrinkEffectData.Entry(ModEffects.SLIGHTLY_TIPSY, SLIGHTLY_TIPSY_DURATIONS[i], 0, 1.0F));
            merged.addAll(extra);
            effects.add(List.copyOf(merged));
        }
        this.data.put(name, new DrinkEffectData(item.get().builtInRegistryHolder(), effects));
    }

    private static DrinkEffectData.Entry effect(Holder<MobEffect> effect, int duration, int amplifier) {
        return new DrinkEffectData.Entry(effect, duration, amplifier, 1.0F);
    }

    private static DrinkEffectData.Entry effect(Holder<MobEffect> effect, int duration, int amplifier, float probability) {
        return new DrinkEffectData.Entry(effect, duration, amplifier, probability);
    }

    private static void addCondition(JsonElement element, String modId) {
        if (modId == null || !element.isJsonObject()) {
            return;
        }
        JsonObject condition = new JsonObject();
        condition.addProperty("type", "neoforge:mod_loaded");
        condition.addProperty("modid", modId);
        JsonArray conditions = new JsonArray();
        conditions.add(condition);
        element.getAsJsonObject().add("neoforge:conditions", conditions);
    }
}
