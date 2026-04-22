package com.chinaex123.kaleidoscope_dim_wine.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    // 绯红葡萄
    public static final FoodProperties CRIMSON_GRAPE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
    // 诡异葡萄
    public static final FoodProperties WARPED_GRAPE = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
    // 迷梦果
    public static final FoodProperties DREAMFRUIT = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();
    // 龙血瓶
    public static final FoodProperties DRAGON_BLOOD_BOTTLE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 20 * 5, 3), 1.0f) // 凋零
            .build();
    // 霜心果
    public static final FoodProperties FROSTHEART_FRUIT = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();
}
