package com.chinaex123.kaleidoscope_dim_wine.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class KDWConfig {
    public static final ForgeConfigSpec.BooleanValue DRAGON_BLOOD_SPAWN_ENABLED;

    public static final ForgeConfigSpec.ConfigValue<List<? extends Double>> REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES;
    public static final ForgeConfigSpec.IntValue REDCAP_LOOTING_BONUS_MIN;
    public static final ForgeConfigSpec.IntValue REDCAP_LOOTING_BONUS_MAX;

    public static final ForgeConfigSpec.DoubleValue ANGEL_WINGS_DROP_CHANCE;
    public static final ForgeConfigSpec.IntValue ANGEL_WINGS_DROP_MIN;
    public static final ForgeConfigSpec.IntValue ANGEL_WINGS_DROP_MAX;

    public static final ForgeConfigSpec.ConfigValue<List<? extends Double>> CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES;
    public static final ForgeConfigSpec.IntValue CRIMSON_NYLIUM_FUNGAL_SAP_COUNT;
    public static final ForgeConfigSpec.ConfigValue<List<? extends Double>> WARPED_NYLIUM_FUNGAL_SAP_CHANCES;
    public static final ForgeConfigSpec.IntValue WARPED_NYLIUM_FUNGAL_SAP_COUNT;
    public static final ForgeConfigSpec.DoubleValue GRASS_HOP_SEED_DROP_CHANCE;

    public static final ForgeConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT;
    public static final ForgeConfigSpec.IntValue ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT;

    public static final ForgeConfigSpec.DoubleValue BEDROCK_FALL_DROP_CHANCE;
    public static final ForgeConfigSpec.DoubleValue WITHER_COMMAND_LIGHTS_DROP_CHANCE;

    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("通用配置").push("Common Config");
        DRAGON_BLOOD_SPAWN_ENABLED = builder
                .comment("末影龙死亡后是否生成龙血流体")
                .comment("Whether to spawn Dragon Blood fluid after Ender Dragon death")
                .define("dragonBloodSpawnEnabled", true);
        builder.pop();

        builder.comment("实体战利品").push("Entity Loot");
        builder.comment("[暮色森林]实体战利品掉落").push("Twilight Forest Entity Loot");
        REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES = builder
                .comment("红帽矮人和红帽工兵掉落哥布林精华的概率（%） [无抢夺, 抢夺I, 抢夺II, 抢夺III]")
                .comment("Drop chances for Goblin Essence from Redcap (%) [no Looting, Looting I, Looting II, Looting III]")
                .defineList("redcapGoblinEssenceLootingChances",
                        Arrays.asList(0.15, 0.20, 0.25, 0.30),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        REDCAP_LOOTING_BONUS_MIN = builder
                .comment("红帽矮人和红帽工兵每级抢夺额外掉落的最小数量")
                .comment("Minimum bonus drops per Looting level for Redcap and Redcap Sapper")
                .defineInRange("redcapLootingBonusMin", 0, 0, 10);
        REDCAP_LOOTING_BONUS_MAX = builder
                .comment("红帽矮人和红帽工兵每级抢夺额外掉落的最大数量")
                .comment("Maximum bonus drops per Looting level for Redcap and Redcap Sapper")
                .defineInRange("redcapLootingBonusMax", 1, 0, 10);
        builder.pop();

        builder.comment("[天境]实体战利品掉落").push("Aether Entity Loot");
        ANGEL_WINGS_DROP_CHANCE = builder
                .comment("武神女王掉落天使之翼的概率（%）")
                .comment("Chance for Valkyrie Queen to drop Angel Wings (%)")
                .defineInRange("angelWingsDropChance", 1.0, 0.0, 1.0);
        ANGEL_WINGS_DROP_MIN = builder
                .comment("武神女王掉落天使之翼的最小数量")
                .comment("Minimum number of Angel Wings dropped by Valkyrie Queen")
                .defineInRange("angelWingsDropMin", 1, 0, 64);
        ANGEL_WINGS_DROP_MAX = builder
                .comment("武神女王掉落天使之翼的最大数量")
                .comment("Maximum number of Angel Wings dropped by Valkyrie Queen")
                .defineInRange("angelWingsDropMax", 1, 0, 64);
        builder.pop();

        builder.pop();


        builder.comment("方块战利品").push("Block Loot");
        CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment("绯红菌核掉落绯红菌露的概率（%） [无时运, 时运I, 时运II, 时运III]")
                .comment("Chances for Crimson Nylium to drop Crimson Fungal Sap (%) [no Fortune, Fortune I, Fortune II, Fortune III]")
                .defineList("crimsonNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        CRIMSON_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment("绯红菌核掉落绯红菌露的基础数量")
                .comment("Base count of Crimson Fungal Sap dropped from Crimson Nylium")
                .defineInRange("crimsonNyliumFungalSapCount", 1, 0, 64);
        WARPED_NYLIUM_FUNGAL_SAP_CHANCES = builder
                .comment("诡异菌核掉落诡影菌髓的概率（%） [无时运, 时运I, 时运II, 时运III]")
                .comment("Chances for Warped Nylium to drop Warped Fungal Sap (%) [no Fortune, Fortune I, Fortune II, Fortune III]")
                .defineList("warpedNyliumFungalSapChances",
                        List.of(0.05, 0.075, 0.10, 0.15),
                        obj -> obj instanceof Double && (Double) obj >= 0.0 && (Double) obj <= 1.0);
        WARPED_NYLIUM_FUNGAL_SAP_COUNT = builder
                .comment("诡异菌核掉落诡影菌髓的基础数量")
                .comment("Base count of Warped Fungal Sap dropped from Warped Nylium")
                .defineInRange("warpedNyliumFungalSapCount", 1, 0, 64);
        GRASS_HOP_SEED_DROP_CHANCE = builder
                .comment("草掉落啤酒花种子的概率（%）")
                .comment("Chance for grass to drop Hop Seed when broken (%)")
                .defineInRange("grassHopSeedDropChance", 0.05, 0.0, 1.0);
        builder.pop();


        builder.comment("下落的铁砧配方").push("Anvil Drop Recipes");
        ANVIL_TUFF_TO_CARBOCRETIN_MIN_OUTPUT = builder
                .comment("铁砧掉落将凝灰岩转换为凝碳粉时的最小产出数量（设为0禁用该配方）")
                .comment("Minimum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set 0 to disable)")
                .defineInRange("anvilTuffToCarbocretinMinOutput", 1, 0, 64);
        ANVIL_TUFF_TO_CARBOCRETIN_MAX_OUTPUT = builder
                .comment("铁砧掉落将凝灰岩转换为凝碳粉时的最大产出数量（设为0禁用该配方）")
                .comment("Maximum output amount when converting Tuff to Carbocretin Powder via Anvil Drop (set 0 to disable)")
                .defineInRange("anvilTuffToCarbocretinMaxOutput", 3, 0, 64);
        builder.pop();

        
        builder.comment("小彩蛋").push("Easter Eggs");
        BEDROCK_FALL_DROP_CHANCE = builder
                .comment("摔落在基岩上掉落小灯串(基岩)的概率（%）")
                .comment("Chance to drop String Lights(Bedrock) when falling on Bedrock (%)")
                .defineInRange("bedrockFallDropChance", 0.015, 0.0, 1.0);
        WITHER_COMMAND_LIGHTS_DROP_CHANCE = builder
                .comment("凋灵掉落小灯串(命令方块)的概率（%）")
                .comment("Chance for Wither to drop String Lights(Command Block) (%)")
                .defineInRange("witherCommandLightsDropChance", 0.015, 0.0, 1.0);
        builder.pop();

        SPEC = builder.build();
    }
}
