package com.chinaex123.kaleidoscope_dim_wine.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ServerConfig {
    public static final ModConfigSpec.ConfigValue<List<? extends Double>> REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES;
    public static final ModConfigSpec.DoubleValue WITHER_COMMAND_LIGHTS_DROP_CHANCE;
    public static final ModConfigSpec.DoubleValue ANGEL_WINGS_DROP_CHANCE;
    public static final ModConfigSpec.IntValue ANGEL_WINGS_DROP_MIN;
    public static final ModConfigSpec.IntValue ANGEL_WINGS_DROP_MAX;

    public static final ModConfigSpec.IntValue REDCAP_LOOTING_BONUS_MIN;
    public static final ModConfigSpec.IntValue REDCAP_LOOTING_BONUS_MAX;

    public static final ModConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT;
    public static final ModConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT;

    public static final ModConfigSpec.DoubleValue BEDROCK_FALL_DROP_CHANCE;

    public static final ModConfigSpec.ConfigValue<List<? extends Double>> CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES;
    public static final ModConfigSpec.IntValue CRIMSON_NYLIUM_FUNGAL_SAP_COUNT;
    public static final ModConfigSpec.ConfigValue<List<? extends Double>> WARPED_NYLIUM_FUNGAL_SAP_CHANCES;
    public static final ModConfigSpec.IntValue WARPED_NYLIUM_FUNGAL_SAP_COUNT;


    public static final ModConfigSpec SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("Entity Loot");

        builder.push("Twilightforest Entity Loot");
        REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES = builder
                .comment(
                        "Drop chances for Goblin Essence from Redcap [no Looting, Looting I, Looting II, Looting III]",
                        "红帽矮人和红帽工兵掉落哥布林精华的概率 [无抢夺, 抢夺I, 抢夺II, 抢夺III]"
                )
                .defineList("redcapGoblinEssenceLootingChances",
                        java.util.Arrays.asList(0.15, 0.20, 0.25, 0.30),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
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

        builder.push("Aether Entity Loot");
        ANGEL_WINGS_DROP_CHANCE = builder
                .comment(
                        "Chance for Valkyrie Queen to drop Angel Wings (0.0 to 1.0)",
                        "武神女王掉落天使之翼的概率（0.0 到 1.0）"
                )
                .defineInRange("angelWingsDropChance", 1.0, 0.0, 1.0);
        ANGEL_WINGS_DROP_MIN = builder
                .comment(
                        "Minimum number of Angel Wings dropped by Valkyrie Queen",
                        "武神女王掉落天使之翼的最小数量"
                )
                .defineInRange("angelWingsDropMin", 1, 0, 64);
        ANGEL_WINGS_DROP_MAX = builder
                .comment(
                        "Maximum number of Angel Wings dropped by Valkyrie Queen",
                        "武神女王掉落天使之翼的最大数量"
                )
                .defineInRange("angelWingsDropMax", 1, 0, 64);
        builder.pop();

        builder.pop();


        builder.push("Block Loot");
        builder.push("Nether Nylium Loot");
        CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment(
                        "Chances for Crimson Nylium to drop Crimson Fungal Sap [no Fortune, Fortune I, Fortune II, Fortune III]",
                        "绯红菌核掉落绯红菌露的概率 [无时运, 时运I, 时运II, 时运III]"
                )
                .defineList("crimsonNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        CRIMSON_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment(
                        "Base count of Crimson Fungal Sap dropped from Crimson Nylium",
                        "绯红菌核掉落绯红菌露的基础数量"
                )
                .defineInRange("crimsonNyliumFungalSapCount", 1, 0, 64);

        WARPED_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment(
                        "Chances for Warped Nylium to drop Warped Fungal Sap [no Fortune, Fortune I, Fortune II, Fortune III]",
                        "诡异菌核掉落诡影菌髓的概率 [无时运, 时运I, 时运II, 时运III]"
                )
                .defineList("warpedNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        WARPED_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment(
                        "Base count of Warped Fungal Sap dropped from Warped Nylium",
                        "诡异菌核掉落诡影菌髓的基础数量"
                )
                .defineInRange("warpedNyliumFungalSapCount", 1, 0, 64);
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
