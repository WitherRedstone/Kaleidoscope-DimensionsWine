package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.datamap.data.DrinkEffectData;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
                .ifPresent(json -> futures.add(DataProvider.saveStable(cache, json,
                        this.pathProvider.json(KaleidoscopeDimensionsWine.id(name))))));
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Drink Effect Data";
    }

    private void gather() {
        addWithLevel2Effects(KDWItems.BOCCHI,
                List.of(effect(MobEffects.NIGHT_VISION, 90, 0, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 480, 0, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 1440, 0, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 2880, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.ABYSSAL_PORTER,
                List.of(effect(MobEffects.DAMAGE_BOOST, 60, 0, 1.0F), effect(MobEffects.NIGHT_VISION, 30, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 180, 1, 1.0F), effect(MobEffects.NIGHT_VISION, 120, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 300, 2, 1.0F), effect(MobEffects.NIGHT_VISION, 240, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 600, 3, 1.0F), effect(MobEffects.NIGHT_VISION, 360, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.BLACK_BONE_LAFITE, 35,
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 60, 0, 1.0F), effect(MobEffects.WITHER, 30, 0, 1.0F)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 180, 1, 1.0F), effect(MobEffects.WITHER, 20, 0, 1.0F)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 300, 2, 1.0F), effect(MobEffects.WITHER, 10, 0, 1.0F)),
                List.of(effect(KDWEffects.WITHERED_SLASH.get(), 600, 3, 1.0F), effect(MobEffects.WITHER, 5, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.BLAZE_MARTELL,
                List.of(effect(KDWEffects.RAGE.get(), 60, 0, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 30, 0, 1.0F)),
                List.of(effect(KDWEffects.RAGE.get(), 180, 1, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 120, 0, 1.0F)),
                List.of(effect(KDWEffects.RAGE.get(), 300, 2, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 240, 0, 1.0F)),
                List.of(effect(KDWEffects.RAGE.get(), 600, 3, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 360, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.BUDWEISER_BEER,
                List.of(effect(MobEffects.JUMP, 60, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 30, 0, 1.0F)),
                List.of(effect(MobEffects.JUMP, 180, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 120, 0, 1.0F)),
                List.of(effect(MobEffects.JUMP, 300, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 240, 0, 1.0F)),
                List.of(effect(MobEffects.JUMP, 600, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 360, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.CHORUS_COGNAC,
                List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3, 1.0F))
        );

        addWithLevel2Effects(KDWItems.CRIMSON_CRESCENDO,
                List.of(effect(MobEffects.FIRE_RESISTANCE, 60, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 150, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 300, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 600, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.DIVINE_EMBRYO_PORT,
                List.of(effect(KDWEffects.PARADOX.get(), 60, 0, 1.0F)),
                List.of(effect(KDWEffects.PARADOX.get(), 180, 1, 1.0F)),
                List.of(effect(KDWEffects.PARADOX.get(), 300, 2, 1.0F)),
                List.of(effect(KDWEffects.PARADOX.get(), 600, 3, 1.0F))
        );

        addFull(KDWItems.DRACONIC_BLOOD_WINE,
                List.of(effect(MobEffects.CONFUSION, 30, 0, 1.0F)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 45, 0, 1.0F)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 60, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 30, 0, 1.0F)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 20, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 180, 1, 1.0F), effect(MobEffects.LUCK, 120, 3, 1.0F)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 10, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 300, 2, 1.0F), effect(MobEffects.LUCK, 180, 5, 1.0F)),
                List.of(effect(ModEffects.SLIGHTLY_TIPSY.get(), 5, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 600, 3, 1.0F), effect(MobEffects.LUCK, 240, 9, 1.0F))
        );

        addWithLevel2Effects(KDWItems.DRAGONS_BREATH_BRANDY,
                List.of(effect(MobEffects.NIGHT_VISION, 90, 0, 1.0F), effect(MobEffects.DIG_SPEED, 90, 0, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 480, 0, 1.0F), effect(MobEffects.DIG_SPEED, 120, 1, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 1440, 0, 1.0F), effect(MobEffects.DIG_SPEED, 480, 2, 1.0F)),
                List.of(effect(MobEffects.NIGHT_VISION, 2880, 0, 1.0F), effect(MobEffects.DIG_SPEED, 1440, 3, 1.0F))
        );

        addWithLevel2Effects(KDWItems.END_STARLIGHT,
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 30, 0, 1.0F), effect(MobEffects.REGENERATION, 30, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 120, 1, 1.0F), effect(MobEffects.REGENERATION, 120, 1, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 240, 2, 1.0F), effect(MobEffects.REGENERATION, 180, 2, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_RESISTANCE, 300, 3, 1.0F), effect(MobEffects.REGENERATION, 240, 3, 1.0F))
        );

        addWithLevel2Effects(KDWItems.ETHEREAL_NOBLE,
                List.of(effect(MobEffects.INVISIBILITY, 60, 0, 1.0F)),
                List.of(effect(MobEffects.INVISIBILITY, 180, 0, 1.0F)),
                List.of(effect(MobEffects.INVISIBILITY, 300, 0, 1.0F)),
                List.of(effect(MobEffects.INVISIBILITY, 600, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.FORGOTTEN_MARGARITA,
                List.of(effect(KDWEffects.PAYBACK.get(), 60, 0, 1.0F)),
                List.of(effect(KDWEffects.PAYBACK.get(), 180, 1, 1.0F)),
                List.of(effect(KDWEffects.PAYBACK.get(), 300, 2, 1.0F)),
                List.of(effect(KDWEffects.PAYBACK.get(), 600, 3, 1.0F))
        );

        addWithLevel2Effects(AetherItems.GINGERBREAD_WARMER,
                List.of(effect(MobEffects.LUCK, 90, 0, 1.0F)),
                List.of(effect(MobEffects.LUCK, 480, 4, 1.0F)),
                List.of(effect(MobEffects.LUCK, 1440, 15, 1.0F)),
                List.of(effect(MobEffects.LUCK, 2880, 30, 1.0F))
        );

        addWithLevel2Effects(KDWItems.MAGMA_ROYAL_SALUTE,
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 60, 0, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 30, 0, 1.0F)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 180, 1, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 120, 0, 1.0F)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 300, 2, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 240, 0, 1.0F)),
                List.of(effect(KDWEffects.FIRE_ATTACK.get(), 600, 3, 1.0F), effect(MobEffects.FIRE_RESISTANCE, 360, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.PHANTOM_DREAM_BUBBLE,
                List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2, 1.0F)),
                List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3, 1.0F))
        );

        addWithLevel2Effects(KDWItems.SILENT_SHERRY,
                List.of(effect(MobEffects.DAMAGE_BOOST, 60, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 180, 0, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 300, 1, 1.0F)),
                List.of(effect(MobEffects.DAMAGE_BOOST, 600, 2, 1.0F))
        );

        addWithLevel2Effects(AetherItems.UNBOUND_SKYBORN,
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 30, 0, 1.0F)),
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 120, 0, 1.0F)),
                List.of(effect(KDWEffects.SKYBORN_GRACE.get(), 240, 0, 1.0F)),
                List.of(effect(KDWEffects.UNBOUND_GRACE.get(), 360, 0, 1.0F))
        );

        addWithLevel2Effects(KDWItems.WART_HENNESSY,
                List.of(effect(MobEffects.FIRE_RESISTANCE, 60, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 180, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 300, 0, 1.0F)),
                List.of(effect(MobEffects.FIRE_RESISTANCE, 600, 0, 1.0F))
        );

        // ==================== 暮色森林联动 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            addWithLevel2Effects(TwilightforestItems.RANGERS_SATCHEL,
                    List.of(effect(MobEffects.GLOWING, 60, 0, 1.0F)),
                    List.of(effect(MobEffects.GLOWING, 180, 1, 1.0F)),
                    List.of(effect(MobEffects.GLOWING, 300, 2, 1.0F)),
                    List.of(effect(MobEffects.GLOWING, 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.SNAKESKIN_LIQUEUR,
                    List.of(),
                    List.of(),
                    List.of(),
                    List.of()
            );

            addWithLevel2Effects(TwilightforestItems.DAWNLIGHT_DEW,
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 60, 0, 1.0F)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 180, 1, 1.0F)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 300, 2, 1.0F)),
                    List.of(effect(MobEffects.MOVEMENT_SPEED, 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.DEAD_END_SPITTLE,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.CAVE_GLOWBREW,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.DRUIDS_SECRET_BREW,
                    List.of(effect(KDWEffects.HARDENED.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HARDENED.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.EMBEREYE,
                    List.of(effect(MobEffects.NIGHT_VISION, 90, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 60, 0, 1.0F)),
                    List.of(effect(MobEffects.NIGHT_VISION, 480, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 180, 1, 1.0F)),
                    List.of(effect(MobEffects.NIGHT_VISION, 1440, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 300, 2, 1.0F)),
                    List.of(effect(MobEffects.NIGHT_VISION, 2880, 0, 1.0F), effect(KDWEffects.BLOODTHIRSTY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.FROSTVEIN_BEASTBLOOD,
                    List.of(effect(KDWEffects.FROSTFALL.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.GIANTS_HYMN,
                    List.of(effect(MobEffects.DAMAGE_BOOST, 30, 0, 1.0F)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 120, 1, 1.0F)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 240, 2, 1.0F)),
                    List.of(effect(MobEffects.DAMAGE_BOOST, 360, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.GOBLINS_STASH,
                    List.of(effect(MobEffects.DIG_SPEED, 30, 0, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 120, 1, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 240, 2, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 360, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.MOORGLOW_BIRDS_SONG,
                    List.of(effect(MobEffects.SLOW_FALLING, 60, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 30, 0, 1.0F)),
                    List.of(effect(MobEffects.SLOW_FALLING, 180, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 120, 0, 1.0F)),
                    List.of(effect(MobEffects.SLOW_FALLING, 300, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 240, 1, 1.0F)),
                    List.of(effect(MobEffects.SLOW_FALLING, 600, 0, 1.0F), effect(MobEffects.MOVEMENT_SPEED, 360, 2, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.PERENNIAL_FROST,
                    List.of(effect(KDWEffects.FROSTFALL.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.FROSTFALL.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.STAGCALL_MONSOON,
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.NATURE_BLESSING.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TwilightforestItems.THORNHEART,
                    List.of(effect(MobEffects.ABSORPTION, 60, 0, 1.0F)),
                    List.of(effect(MobEffects.ABSORPTION, 180, 1, 1.0F)),
                    List.of(effect(MobEffects.ABSORPTION, 300, 2, 1.0F)),
                    List.of(effect(MobEffects.ABSORPTION, 600, 3, 1.0F))
            );

            }

        // ==================== 蜜蜂领域联动 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            addWithLevel2Effects(TheBumblezoneItems.BEESWAX_HONEY_WINE,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.FANTA,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.HONEYTHORN_MEAD,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.PEPSI,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.POLLEN_NECTAR,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F), effect(MobEffects.DAMAGE_BOOST, 30, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F), effect(MobEffects.DAMAGE_BOOST, 120, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F), effect(MobEffects.DAMAGE_BOOST, 180, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F), effect(MobEffects.DAMAGE_BOOST, 240, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.ROYAL_HONEY_BREW,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F), effect(MobEffects.DAMAGE_RESISTANCE, 30, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F), effect(MobEffects.DAMAGE_RESISTANCE, 120, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F), effect(MobEffects.DAMAGE_RESISTANCE, 240, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F), effect(MobEffects.DAMAGE_RESISTANCE, 360, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.SPRITE,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F))
            );

            addWithLevel2Effects(TheBumblezoneItems.SWEET_CRYSTAL_HONEY,
                    List.of(effect(KDWEffects.HAPPY.get(), 60, 0, 1.0F), effect(MobEffects.HEALTH_BOOST, 30, 0, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 180, 1, 1.0F), effect(MobEffects.HEALTH_BOOST, 120, 1, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 300, 2, 1.0F), effect(MobEffects.HEALTH_BOOST, 180, 2, 1.0F)),
                    List.of(effect(KDWEffects.HAPPY.get(), 600, 3, 1.0F), effect(MobEffects.HEALTH_BOOST, 240, 3, 1.0F))
            );

            }

        // ==================== 天境联动 ====================
        if (ModList.get().isLoaded("aether")) {
            addWithLevel2Effects(AetherItems.DIVINE_ENERGY_MIST,
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 60, 0, 1.0F),
                            effect(MobEffects.INVISIBILITY, 30, 0, 1.0F),
                            effect(MobEffects.HUNGER, 30, 0, 1.0F)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 180, 1, 1.0F),
                            effect(MobEffects.INVISIBILITY, 120, 0, 1.0F),
                            effect(MobEffects.HUNGER, 20, 0, 1.0F)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 300, 2, 1.0F),
                            effect(MobEffects.INVISIBILITY, 240, 0, 1.0F),
                            effect(MobEffects.HUNGER, 10, 0, 1.0F)
                    ),
                    List.of(
                            effect(MobEffects.MOVEMENT_SPEED, 600, 3, 1.0F),
                            effect(MobEffects.INVISIBILITY, 360, 0, 1.0F),
                            effect(MobEffects.HUNGER, 5, 0, 1.0F)
                    )
            );

            addWithLevel2Effects(AetherItems.DIVINE_OFFERING_BREW,
                    List.of(effect(MobEffects.DIG_SPEED, 60, 0, 1.0F), effect(MobEffects.NIGHT_VISION, 30, 0, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 180, 1, 1.0F), effect(MobEffects.NIGHT_VISION, 120, 0, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 300, 2, 1.0F), effect(MobEffects.NIGHT_VISION, 240, 0, 1.0F)),
                    List.of(effect(MobEffects.DIG_SPEED, 600, 3, 1.0F), effect(MobEffects.NIGHT_VISION, 360, 0, 1.0F))
            );

            addWithLevel2Effects(AetherItems.GRAVITITE_DRUNK,
                    List.of(effect(MobEffects.JUMP, 60, 0, 1.0F), effect(MobEffects.SLOW_FALLING, 60, 0, 1.0F)),
                    List.of(effect(MobEffects.JUMP, 180, 1, 1.0F), effect(MobEffects.SLOW_FALLING, 180, 0, 1.0F)),
                    List.of(effect(MobEffects.JUMP, 300, 2, 1.0F), effect(MobEffects.SLOW_FALLING, 300, 0, 1.0F)),
                    List.of(effect(MobEffects.JUMP, 600, 3, 1.0F), effect(MobEffects.SLOW_FALLING, 600, 0, 1.0F))
            );

            addWithLevel2Effects(AetherItems.HEALING_ELIXIR,
                    List.of(effect(MobEffects.REGENERATION, 30, 0, 1.0F), effect(MobEffects.HEAL, 0, 0, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1, 1.0F), effect(MobEffects.HEAL, 0, 1, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2, 1.0F), effect(MobEffects.HEAL, 0, 2, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 360, 4, 1.0F), effect(MobEffects.HEAL, 0, 3, 1.0F))
            );

            addWithLevel2Effects(AetherItems.SWET_FIZZ,
                    List.of(effect(MobEffects.REGENERATION, 30, 0, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 120, 1, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 240, 2, 1.0F)),
                    List.of(effect(MobEffects.REGENERATION, 360, 3, 1.0F))
            );

            }
    }

    /** 等级 1 反胃 30s 的标准饮品，参数依次为等级 3、4、5、6 的专属效果 */
    @SafeVarargs
    private void addWithLevel2Effects(RegistryObject<Item> item, List<DrinkEffectData.Entry>... levelAbove1) {
        addWithLevel2Effects(item, 30, levelAbove1);
    }

    /** 等级 1 反胃时长可自定义的标准饮品 */
    @SafeVarargs
    private void addWithLevel2Effects(RegistryObject<Item> item, int confusionDuration,
                                      List<DrinkEffectData.Entry>... levelAbove1) {
        int length = levelAbove1.length;
        if (length == 0) {
            throw new IllegalArgumentException("等级 2 以上至少需要一个等级的效果");
        }
        List<List<DrinkEffectData.Entry>> effects = new ArrayList<>(SLIGHTLY_TIPSY_DURATIONS.length + 1);
        // 等级 1：反胃
        effects.add(List.of(new DrinkEffectData.Entry(MobEffects.CONFUSION, confusionDuration, 0, 1.0F)));
        // 等级 2-6：固定附带微醺，再叠加专属效果
        for (int i = 0; i < SLIGHTLY_TIPSY_DURATIONS.length; i++) {
            List<DrinkEffectData.Entry> extra = levelAbove1[Math.min(i, length - 1)];
            List<DrinkEffectData.Entry> merged = new ArrayList<>(extra.size() + 1);
            merged.add(new DrinkEffectData.Entry(ModEffects.SLIGHTLY_TIPSY.get(), SLIGHTLY_TIPSY_DURATIONS[i], 0, 1.0F));
            merged.addAll(extra);
            effects.add(List.copyOf(merged));
        }
        this.data.put(registryName(item), new DrinkEffectData(item.get(), effects));
    }

    /** 效果完全不标准时，直接给出 6 个等级 */
    @SafeVarargs
    private void addFull(RegistryObject<Item> item, List<DrinkEffectData.Entry>... levels) {
        this.data.put(registryName(item), new DrinkEffectData(item.get(), List.of(levels)));
    }

    /** 文件名取物品的注册名 */
    private static String registryName(RegistryObject<Item> item) {
        return ForgeRegistries.ITEMS.getKey(item.get()).getPath();
    }

    private static DrinkEffectData.Entry effect(MobEffect effect, int duration, int amplifier, float probability) {
        return new DrinkEffectData.Entry(effect, duration, amplifier, probability);
    }
}
