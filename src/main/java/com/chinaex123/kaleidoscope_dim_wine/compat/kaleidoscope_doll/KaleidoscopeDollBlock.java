package com.chinaex123.kaleidoscope_dim_wine.compat.kaleidoscope_doll;

import net.minecraft.world.level.block.Block;

public final class KaleidoscopeDollBlock {

    private static final String DOLL_BLOCK_CLASS = "com.github.ysbbbbbb.kaleidoscopedoll.block.DollBlock";
    private static Boolean isLoaded = null;

    public static boolean isKaleidoscopeDollLoaded() {
        if (isLoaded == null) {
            try {
                Class.forName(DOLL_BLOCK_CLASS);
                isLoaded = true;
            } catch (ClassNotFoundException e) {
                isLoaded = false;
            }
        }
        return isLoaded;
    }

    public static Block createKaleidoscopeDoll() {
        try {
            Class<?> kaleidoDollClass = Class.forName(DOLL_BLOCK_CLASS);
            return (Block) kaleidoDollClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private KaleidoscopeDollBlock() {}
}
