package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeDimensionsWine.MOD_ID);

    public static final Supplier<CreativeModeTab> KALEIDOSCOPE_DIM_WINE_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dim_wine_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CRIMSON_GRAPE.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dim_wine_tab"))
                    .displayItems((parameters, output) -> {
                        // -------------------- 小彩蛋 --------------------
                        output.accept(ModBlocks.DOLL_001.get()); // 玩偶 - ChinaEX123_BILI
                        output.accept(ModBlocks.DOLL_002.get()); // 玩偶 - Fvue233
                        output.accept(ModBlocks.DOLL_003.get()); // 玩偶 - Agens_Eland
                        // -------------------- 瓶装 --------------------
//                        output.accept(ModItems.EMPTY_BAMBOO_CUP.get()); // 空竹杯
                        output.accept(ModItems.POP_CAN.get()); // 易拉罐
                        output.accept(ModItems.ANGEL_WINGS.get()); // 天使之翼
                        output.accept(ModItems.ANGEL_FEATHER.get()); // 天使之羽
                        // -------------------- 流体桶 --------------------
                        output.accept(ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
                        output.accept(ModItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
                        output.accept(ModItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
                        output.accept(ModItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶
                        // -------------------- 作物 --------------------
                        output.accept(ModItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
                        output.accept(ModItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
                        output.accept(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
                        output.accept(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
                        output.accept(ModItems.DREAMFRUIT.get()); // 迷梦果
                        // -------------------- 物品 --------------------
                        output.accept(ModItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
                        output.accept(ModItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
                        output.accept(ModItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶
                        // -------------------- 酒类 --------------------
                        output.accept(ModItems.CRIMSON_CRESCENDO.get()); // 绯红绝响
                        output.accept(ModItems.ETHEREAL_NOBLE.get()); // 诡影尊爵
                        output.accept(ModItems.WART_HENNESSY.get()); // 疣域轩尼诗
                        output.accept(ModItems.BLAZE_MARTELL.get()); // 烈焰马爹利
                        output.accept(ModItems.MAGMA_ROYAL_SALUTE.get()); // 岩浆皇家礼炮
                        output.accept(ModItems.BLACK_BONE_LAFITE.get()); // 黑骨拉菲
                        output.accept(ModItems.CHORUS_COGNAC.get()); // 紫颂干邑
                        output.accept(ModItems.DRAGONS_BREATH_BRANDY.get()); // 龙息白兰地
                        output.accept(ModItems.ABYSSAL_PORTER.get()); // 深渊波特
                        output.accept(ModItems.SILENT_SHERRY.get()); // 静默雪莉
                        output.accept(ModItems.FORGOTTEN_MARGARITA.get()); // 遗忘玛格丽特
                        output.accept(ModItems.PHANTOM_DREAM_BUBBLE.get()); // 幻梦泡影
                        output.accept(ModItems.END_STARLIGHT.get()); // 终末星光
                        output.accept(ModItems.DIVINE_EMBRYO_PORT.get()); // 神血波尔多
                        output.accept(ModItems.DRACONIC_BLOOD_WINE.get()); // 龙血酒


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
                            output.accept(TwilightforestItems.CAVE_GLOWBREW.get()); // 洞窟萤火酿
                            output.accept(TwilightforestItems.DAWNLIGHT_DEW.get()); // 林隙晨露
                            output.accept(TwilightforestItems.DEAD_END_SPITTLE.get()); // 死巷之唾
                            output.accept(TwilightforestItems.SNAKESKIN_LIQUEUR.get()); // 蛇蜕利口酒
                            output.accept(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get()); // 霜脉兽血
                            output.accept(TwilightforestItems.RANGERS_SATCHEL.get()); // 巡林客的背囊
                            output.accept(TwilightforestItems.EMBEREYE.get()); // 烬瞳
                            output.accept(TwilightforestItems.STAGCALL_MONSOON.get()); // 鹿鸣季风
                            output.accept(TwilightforestItems.THORNHEART.get()); // 荆棘之心
                            output.accept(TwilightforestItems.DRUIDS_SECRET_BREW.get()); // 德鲁伊的秘酿
                            output.accept(TwilightforestItems.MOORGLOW_BIRDS_SONG.get()); // 辉夜鸟之歌
                            output.accept(TwilightforestItems.PERENNIAL_FROST.get()); // 终年冻土
                            output.accept(TwilightforestItems.GIANTS_HYMN.get()); // 巨人赞歌
                            output.accept(TwilightforestItems.GOBLINS_STASH.get()); // 地精的私藏
                        }


                        // ==================== 次元维度 - 蜜蜂领域 ====================
                        if (ModList.get().isLoaded("the_bumblezone")) {
                            // -------------------- 物品 --------------------
                            output.accept(TheBumblezoneItems.MEAD_ESSENCE.get()); // 蜜酒精华
                            output.accept(TheBumblezoneItems.CARBOCRETIN_POWDER.get()); // 凝碳粉
                            // -------------------- 酒类 --------------------
                            output.accept(TheBumblezoneItems.SPRITE.get()); // 雪碧
                            output.accept(TheBumblezoneItems.PEPSI.get()); // 可乐
                            output.accept(TheBumblezoneItems.FANTA.get()); // 芬达
                            output.accept(TheBumblezoneItems.POLLEN_NECTAR.get()); // 花粉甜酿
                            output.accept(TheBumblezoneItems.HONEYTHORN_MEAD.get()); // 蜜刺佳酿
                            output.accept(TheBumblezoneItems.BEESWAX_HONEY_WINE.get()); // 蜂蜡陈酿
                            output.accept(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get()); // 甜蜜水晶
                            output.accept(TheBumblezoneItems.ROYAL_HONEY_BREW.get()); // 蜂王特酿
                        }


                        // ==================== 次元维度 - 天境 ====================
                        if (ModList.get().isLoaded("aether")) {
                            // -------------------- 物品 --------------------
                            output.accept(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get()); // 神饯蓝莓汁桶
                            // -------------------- 酒类 --------------------
                            output.accept(AetherItems.DIVINE_OFFERING_BREW.get()); // 神饯紫晶酿
                            output.accept(AetherItems.DIVINE_ENERGY_MIST.get()); // 神能迷雾
                            output.accept(AetherItems.SWET_FIZZ.get()); // 史维特菲士
                            output.accept(AetherItems.GRAVITITE_DRUNK.get()); // 重力醉
                            output.accept(AetherItems.HEALING_ELIXIR.get()); // 治愈灵药
                            output.accept(AetherItems.GINGERBREAD_WARMER.get()); // 姜饼暖饮
                            output.accept(AetherItems.UNBOUND_SKYBORN.get()); // 无界苍穹
                        }



                    })
                    .build());

    public static final Supplier<CreativeModeTab> KALEIDOSCOPE_DIM_WINE_DECORATIVE_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dim_wine_decorative_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dim_wine_decorative_tab"))
                    .displayItems((parameters, output) -> {

                        // ==================== 次元维度 - 小装饰 ====================
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()); // 小灯串（潜影贝-无色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get()); // 小灯串（潜影贝-白色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get()); // 小灯串（潜影贝-橙色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get()); // 小灯串（潜影贝-品红色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get()); // 小灯串（潜影贝-淡蓝色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get()); // 小灯串（潜影贝-黄色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get()); // 小灯串（潜影贝-黄绿色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get()); // 小灯串（潜影贝-粉红色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get()); // 小灯串（潜影贝-灰色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get()); // 小灯串（潜影贝-淡灰色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get()); // 小灯串（潜影贝-青色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get()); // 小灯串（潜影贝-紫色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get()); // 小灯串（潜影贝-蓝色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get()); // 小灯串（潜影贝-棕色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get()); // 小灯串（潜影贝-绿色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get()); // 小灯串（潜影贝-红色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get()); // 小灯串（潜影贝-黑色）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get()); // 小灯串（小鸡仔）
                        output.accept(ModBlocks.STRING_LIGHTS_ENTITY_BEE.get()); // 小灯串（蜜蜂）

                        output.accept(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()); // 小灯串（命令方块）
                        output.accept(ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get()); // 小灯串（基岩）

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
