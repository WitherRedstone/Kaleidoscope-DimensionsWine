package com.chinaex123.kaleidoscope_dim_wine.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class KDWConfig {
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
    public static final ModConfigSpec.DoubleValue GRASS_HOP_SEED_DROP_CHANCE;

    public static final ModConfigSpec SPEC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("entity_loot");

        builder.push("twilightforest_entity_loot");
        REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES = builder
                .comment("Drop chances for Goblin Essence from Redcap [no Looting, Looting I, Looting II, Looting III]")
                .defineList("redcapGoblinEssenceLootingChances",
                        java.util.Arrays.asList(0.15, 0.20, 0.25, 0.30),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        REDCAP_LOOTING_BONUS_MIN = builder
                .comment("Minimum bonus drops per Looting level for Redcap and Redcap Sapper")
                .defineInRange("redcapLootingBonusMin", 1, 0, 10);
        REDCAP_LOOTING_BONUS_MAX = builder
                .comment("Maximum bonus drops per Looting level for Redcap and Redcap Sapper")
                .defineInRange("redcapLootingBonusMax", 1, 0, 10);
        builder.pop();

        builder.push("aether_entity_loot");
        ANGEL_WINGS_DROP_CHANCE = builder
                .comment("Chance for Valkyrie Queen to drop Angel Wings")
                .defineInRange("angelWingsDropChance", 1.0, 0.0, 1.0);
        ANGEL_WINGS_DROP_MIN = builder
                .comment("Minimum number of Angel Wings dropped by Valkyrie Queen")
                .defineInRange("angelWingsDropMin", 1, 0, 64);
        ANGEL_WINGS_DROP_MAX = builder
                .comment("Maximum number of Angel Wings dropped by Valkyrie Queen")
                .defineInRange("angelWingsDropMax", 1, 0, 64);
        builder.pop();

        builder.pop();


        builder.push("block_loot");
        CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment("Chances for Crimson Nylium to drop Crimson Fungal Sap [no Fortune, Fortune I, Fortune II, Fortune III]")
                .defineList("crimsonNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        CRIMSON_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment("Base count of Crimson Fungal Sap dropped from Crimson Nylium")
                .defineInRange("crimsonNyliumFungalSapCount", 1, 0, 64);
        WARPED_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment("Chances for Warped Nylium to drop Warped Fungal Sap [no Fortune, Fortune I, Fortune II, Fortune III]")
                .defineList("warpedNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        WARPED_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment("Base count of Warped Fungal Sap dropped from Warped Nylium")
                .defineInRange("warpedNyliumFungalSapCount", 1, 0, 64);
        GRASS_HOP_SEED_DROP_CHANCE = builder
                .comment("Chance for grass to drop Hop Seed when broken")
                .defineInRange("grassHopSeedDropChance", 0.05, 0.0, 1.0);
        builder.pop();


        builder.push("anvil_drop_recipes");
        ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT = builder
                .comment("Minimum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set 0 to disable)")
                .defineInRange("anvilTuffToCarbocretinMinOutput", 1, 0, 64);
        ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT = builder
                .comment("Maximum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set 0 to disable)")
                .defineInRange("anvilTuffToCarbocretinMaxOutput", 3, 0, 64);
        builder.pop();

        builder.push("easter_eggs");
        BEDROCK_FALL_DROP_CHANCE = builder
                .comment("Chance to drop String Lights(Bedrock) when falling on Bedrock")
                .defineInRange("bedrockFallDropChance", 0.015, 0.0, 1.0);
        WITHER_COMMAND_LIGHTS_DROP_CHANCE = builder
                .comment("Chance for Wither to drop String Lights(Command Block)")
                .defineInRange("witherCommandLightsDropChance", 0.015, 0.0, 1.0);
        builder.pop();

        SPEC = builder.build();
    }
}
