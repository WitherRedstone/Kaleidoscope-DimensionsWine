package com.chinaex123.kaleidoscope_dim_wine.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
    public static final ModConfigSpec.DoubleValue REDCAP_GOBLIN_ESSENCE_CHANCE_0;
    public static final ModConfigSpec.DoubleValue REDCAP_GOBLIN_ESSENCE_CHANCE_1;
    public static final ModConfigSpec.DoubleValue REDCAP_GOBLIN_ESSENCE_CHANCE_2;
    public static final ModConfigSpec.DoubleValue REDCAP_GOBLIN_ESSENCE_CHANCE_3;
    public static final ModConfigSpec.DoubleValue WITHER_COMMAND_LIGHTS_DROP_CHANCE;

    public static final ModConfigSpec.IntValue REDCAP_LOOTING_BONUS_MIN;
    public static final ModConfigSpec.IntValue REDCAP_LOOTING_BONUS_MAX;

    public static final ModConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT;
    public static final ModConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT;

    public static final ModConfigSpec.DoubleValue BEDROCK_FALL_DROP_CHANCE;

    public static final ModConfigSpec SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("Twilightforest Entity Loot");
        REDCAP_GOBLIN_ESSENCE_CHANCE_0 = builder
                .comment(
                        "Chance for Redcap to drop Goblin Essence with no Looting (0.0 to 1.0)",
                        "红帽矮人和红帽工兵无抢夺时掉落哥布林精华的概率（0.0 到 1.0）"
                )
                .defineInRange("redcapGoblinEssenceChanceLevel0", 0.15, 0.0, 1.0);
        REDCAP_GOBLIN_ESSENCE_CHANCE_1 = builder
                .comment(
                        "Chance for Redcap to drop Goblin Essence with Looting I (0.0 to 1.0)",
                        "红帽矮人和红帽工兵抢夺 I 时掉落哥布林精华的概率（0.0 到 1.0）"
                )
                .defineInRange("redcapGoblinEssenceChanceLevel1", 0.20, 0.0, 1.0);
        REDCAP_GOBLIN_ESSENCE_CHANCE_2 = builder
                .comment(
                        "Chance for Redcap to drop Goblin Essence with Looting II (0.0 to 1.0)",
                        "红帽矮人和红帽工兵抢夺 II 时掉落哥布林精华的概率（0.0 到 1.0）"
                )
                .defineInRange("redcapGoblinEssenceChanceLevel2", 0.25, 0.0, 1.0);
        REDCAP_GOBLIN_ESSENCE_CHANCE_3 = builder
                .comment(
                        "Chance for Redcap to drop Goblin Essence with Looting III (0.0 to 1.0)",
                        "红帽矮人和红帽工兵抢夺 III 时掉落哥布林精华的概率（0.0 到 1.0）"
                )
                .defineInRange("redcapGoblinEssenceChanceLevel3", 0.30, 0.0, 1.0);
        REDCAP_LOOTING_BONUS_MIN = builder
                .comment(
                        "Minimum bonus drops per Looting level for Redcap and Redcap Sapper",
                        "红帽矮人和红帽工兵每级抢夺额外掉落的最小数量"
                )
                .defineInRange("redcapLootingBonusMin", 0, 0, 10);
        REDCAP_LOOTING_BONUS_MAX = builder
                .comment(
                        "Maximum bonus drops per Looting level for Redcap and Redcap Sapper",
                        "红帽矮人和红帽工兵每级抢夺额外掉落的最大数量"
                )
                .defineInRange("redcapLootingBonusMax", 1, 0, 10);
        builder.pop();

        builder.push("Anvil Drop Recipes");
        ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT = builder
                .comment(
                        "Minimum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set both min and max to 0 to disable)",
                        "铁砧掉落将凝灰岩转换为凝碳粉时的最小产出数量（将最小和最大都设为0可禁用该配方）"
                )
                .defineInRange("anvilTuffToCarbocretinMinOutput", 1, 0, 64);
        ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT = builder
                .comment(
                        "Maximum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set both min and max to 0 to disable)",
                        "铁砧掉落将凝灰岩转换为凝碳粉时的最大产出数量（将最小和最大都设为0可禁用该配方）"
                )
                .defineInRange("anvilTuffToCarbocretinMaxOutput", 3, 0, 64);
        builder.pop();

        builder.push("Easter Eggs");
        BEDROCK_FALL_DROP_CHANCE = builder
                .comment(
                        "Chance to drop String Lights(Bedrock) when falling on Bedrock (0.0 to 1.0)",
                        "摔落在基岩上掉落小灯串(基岩)的概率（0.0 到 1.0）"
                )
                .defineInRange("bedrockFallDropChance", 0.015, 0.0, 1.0);
        WITHER_COMMAND_LIGHTS_DROP_CHANCE = builder
                .comment(
                        "Chance for Wither to drop String Lights(Command Block) (0.0 to 1.0)",
                        "凋灵掉落小灯串(命令方块)的概率（0.0 到 1.0）"
                )
                .defineInRange("witherCommandLightsDropChance", 0.015, 0.0, 1.0);
        builder.pop();

        SPEC = builder.build();
    }
}
