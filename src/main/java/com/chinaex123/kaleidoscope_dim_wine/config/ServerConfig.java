package com.chinaex123.kaleidoscope_dim_wine.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static final ModConfigSpec.DoubleValue CRIMSON_GRAPE_DOLL_CHANCE;
    public static final ModConfigSpec.DoubleValue WARPED_GRAPE_DOLL_CHANCE;

    public static final ModConfigSpec SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("Doll Drops");
        CRIMSON_GRAPE_DOLL_CHANCE = builder
                .comment(
                        "Percentage chance of dropping DOLL 001 when harvesting Warped Grape (0.0 to disable)",
                        "采摘绯红葡萄时掉落 DOLL 001 的百分比概率（设为 0.0 可禁用）"
                )
                .defineInRange("crimsonGrapeDollChance", 0.01, 0.0, 1.0);
        WARPED_GRAPE_DOLL_CHANCE = builder
                .comment(
                        "Percentage chance of dropping DOLL 002 when harvesting Crimson Grape (0.0 to disable)",
                        "采摘诡异葡萄时掉落 DOLL 002 的百分比概率（设为 0.0 可禁用）"
                )
                .defineInRange("dreamfruitDollChance", 0.01, 0.0, 1.0);

        builder.pop();

        SPEC = builder.build();
    }
}
