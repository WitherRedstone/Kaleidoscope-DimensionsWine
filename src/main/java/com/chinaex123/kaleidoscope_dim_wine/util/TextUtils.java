package com.chinaex123.kaleidoscope_dim_wine.util;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/**
 * 根据键名获取成就的翻译文本
 */
public class TextUtils {
    public static MutableComponent getTranslation(String key) {
        return Component.translatable("advancements." + KaleidoscopeDimensionsWine.MOD_ID + "." + key);
    }

    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("advancements." + KaleidoscopeDimensionsWine.MOD_ID + "." + key, args);
    }
}