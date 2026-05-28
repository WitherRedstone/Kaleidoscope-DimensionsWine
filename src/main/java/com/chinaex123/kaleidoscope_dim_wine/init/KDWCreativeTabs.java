package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.item.BottleBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class KDWCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeDimensionsWine.MOD_ID);

    public static final Supplier<CreativeModeTab> KALEIDOSCOPE_DIM_WINE_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dim_wine_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(KDWItems.CRIMSON_GRAPE.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dim_wine_tab"))
                    .displayItems((parameters, output) -> {
                        // -------------------- 小彩蛋 --------------------
                        output.accept(KDWBlocks.DOLL_001.get()); // 玩偶 - ChinaEX123_BILI
                        output.accept(KDWBlocks.DOLL_002.get()); // 玩偶 - Fvue233
                        output.accept(KDWBlocks.DOLL_003.get()); // 玩偶 - Agens_Eland
                        // -------------------- 瓶装 --------------------
                        output.accept(KDWItems.POP_CAN.get()); // 易拉罐
                        output.accept(KDWItems.ANGEL_WINGS.get()); // 天使之翼
                        output.accept(KDWItems.ANGEL_FEATHER.get()); // 天使之羽
                        // -------------------- 流体桶 --------------------
                        output.accept(KDWItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
                        output.accept(KDWItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
                        output.accept(KDWItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
                        output.accept(KDWItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶
                        // -------------------- 作物 --------------------
                        output.accept(KDWItems.HOP.get()); // 啤酒花
                        output.accept(KDWItems.HOP_SEED.get()); // 啤酒花种子
                        output.accept(KDWItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
                        output.accept(KDWItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
                        output.accept(KDWItems.CRIMSON_GRAPE.get()); // 绯红葡萄
                        output.accept(KDWItems.WARPED_GRAPE.get()); // 诡异葡萄
                        output.accept(KDWItems.DREAMFRUIT.get()); // 迷梦果
                        // -------------------- 物品 --------------------
                        output.accept(KDWItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
                        output.accept(KDWItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
                        output.accept(KDWItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶
                        // -------------------- 酒类 --------------------
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.CRIMSON_CRESCENDO)); // 绯红绝响
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.ETHEREAL_NOBLE)); // 诡影尊爵
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.WART_HENNESSY)); // 疣域轩尼诗
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.BLAZE_MARTELL)); // 烈焰马爹利
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.MAGMA_ROYAL_SALUTE)); // 岩浆皇家礼炮
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.BLACK_BONE_LAFITE)); // 黑骨拉菲
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.CHORUS_COGNAC)); // 紫颂干邑
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.DRAGONS_BREATH_BRANDY)); // 龙息白兰地
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.ABYSSAL_PORTER)); // 深渊波特
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.SILENT_SHERRY)); // 静默雪莉
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.FORGOTTEN_MARGARITA)); // 遗忘玛格丽特
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.PHANTOM_DREAM_BUBBLE)); // 幻梦泡影
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.END_STARLIGHT)); // 终末星光
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.DIVINE_EMBRYO_PORT)); // 神血波尔多
                        output.accept(BottleBlockItem.getMaxLevelDrink(KDWItems.DRACONIC_BLOOD_WINE)); // 龙血酒


                        // ==================== 次元维度 - 暮色森林 ====================
                        if (ModList.get().isLoaded("twilightforest")) {
                            // -------------------- 流体桶 --------------------
                            output.accept(TwilightforestItems.TORCHBERRIES_JUICE_BUCKET.get()); // 火炬浆果汁桶
                            output.accept(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.get()); // 霜心果汁桶
                            // -------------------- 作物 --------------------
                            output.accept(TwilightforestItems.FROSTHEART_FRUIT.get()); // 霜心果
                            // -------------------- 物品 --------------------
                            output.accept(TwilightforestItems.COLOSSAL_FRAGMENT.get()); // 巨物碎片
                            output.accept(TwilightforestItems.GOBLIN_ESSENCE.get()); // 哥布林精华
                            // -------------------- 酒类 --------------------
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.CAVE_GLOWBREW)); // 洞窟萤火酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.DAWNLIGHT_DEW)); // 林隙晨露
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.DEAD_END_SPITTLE)); // 死巷之唾
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.SNAKESKIN_LIQUEUR)); // 蛇蜕利口酒
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.FROSTVEIN_BEASTBLOOD)); // 霜脉兽血
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.RANGERS_SATCHEL)); // 巡林客的背囊
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.EMBEREYE)); // 烬瞳
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.STAGCALL_MONSOON)); // 鹿鸣季风
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.THORNHEART)); // 荆棘之心
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.DRUIDS_SECRET_BREW)); // 德鲁伊的秘酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.MOORGLOW_BIRDS_SONG)); // 辉夜鸟之歌
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.PERENNIAL_FROST)); // 终年冻土
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.GIANTS_HYMN)); // 巨人赞歌
                            output.accept(BottleBlockItem.getMaxLevelDrink(TwilightforestItems.GOBLINS_STASH)); // 地精的私藏
                        }


                        // ==================== 次元维度 - 蜜蜂领域 ====================
                        if (ModList.get().isLoaded("the_bumblezone")) {
                            // -------------------- 物品 --------------------
                            output.accept(TheBumblezoneItems.MEAD_ESSENCE.get()); // 蜜酒精华
                            output.accept(TheBumblezoneItems.CARBOCRETIN_POWDER.get()); // 凝碳粉
                            // -------------------- 酒类 --------------------
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.SPRITE)); // 雪碧
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.PEPSI)); // 可乐
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.FANTA)); // 芬达
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.POLLEN_NECTAR)); // 花粉甜酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.HONEYTHORN_MEAD)); // 蜜刺佳酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.BEESWAX_HONEY_WINE)); // 蜂蜡陈酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.SWEET_CRYSTAL_HONEY)); // 甜蜜水晶
                            output.accept(BottleBlockItem.getMaxLevelDrink(TheBumblezoneItems.ROYAL_HONEY_BREW)); // 蜂王特酿
                        }


                        // ==================== 次元维度 - 天境 ====================
                        if (ModList.get().isLoaded("aether")) {
                            // -------------------- 物品 --------------------
                            output.accept(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get()); // 神饯蓝莓汁桶
                            // -------------------- 酒类 --------------------
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.DIVINE_OFFERING_BREW)); // 神饯紫晶酿
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.DIVINE_ENERGY_MIST)); // 神能迷雾
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.SWET_FIZZ)); // 史维特菲士
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.GRAVITITE_DRUNK)); // 重力醉
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.HEALING_ELIXIR)); // 治愈灵药
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.GINGERBREAD_WARMER)); // 姜饼暖饮
                            output.accept(BottleBlockItem.getMaxLevelDrink(AetherItems.UNBOUND_SKYBORN)); // 无界苍穹
                        }



                    })
                    .build());

    public static final Supplier<CreativeModeTab> KALEIDOSCOPE_DIM_WINE_DECORATIVE_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dim_wine_decorative_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dim_wine_decorative_tab"))
                    .displayItems((parameters, output) -> {

                        // ==================== 次元维度 - 小装饰 ====================
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()); // 小灯串（潜影贝-无色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()); // 小灯串（潜影贝-白色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()); // 小灯串（潜影贝-橙色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()); // 小灯串（潜影贝-品红色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()); // 小灯串（潜影贝-淡蓝色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()); // 小灯串（潜影贝-黄色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()); // 小灯串（潜影贝-黄绿色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()); // 小灯串（潜影贝-粉红色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()); // 小灯串（潜影贝-灰色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()); // 小灯串（潜影贝-淡灰色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()); // 小灯串（潜影贝-青色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()); // 小灯串（潜影贝-紫色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()); // 小灯串（潜影贝-蓝色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()); // 小灯串（潜影贝-棕色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()); // 小灯串（潜影贝-绿色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()); // 小灯串（潜影贝-红色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()); // 小灯串（潜影贝-黑色）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()); // 小灯串（小鸡仔）
                        output.accept(KDWBlocks.STRING_LIGHTS_ENTITY_BEE.get()); // 小灯串（蜜蜂）

                        output.accept(KDWBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()); // 小灯串（命令方块）
                        output.accept(KDWBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
