package com.chinaex123.kaleidoscope_dim_wine.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public interface KDWFoods {

    // 葡萄
    FoodProperties GRAPE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
    // 水果
    FoodProperties FRUITS = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();

    // 龙血瓶
    FoodProperties DRAGON_BLOOD_BOTTLE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 20 * 5, 3), 1.0f) // 凋零
            .build();
}
