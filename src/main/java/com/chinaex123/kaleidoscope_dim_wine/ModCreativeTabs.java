package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeDimensionsWine.MOD_ID);

    public static final Supplier<CreativeModeTab> KALEIDOSCOPE_DIM_WINE_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dim_wine_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CRIMSON_GRAPE.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dim_wine_tab"))
                    .displayItems((parameters, output) -> {

                        // ==================== 流体桶 ====================
                        // -------------------- 下界 --------------------
                        output.accept(ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
                        output.accept(ModItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
                        // -------------------- 末地 --------------------
                        output.accept(ModItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
                        output.accept(ModItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶


                        // ==================== 作物 ====================
                        // -------------------- 下界 --------------------
                        output.accept(ModItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
                        output.accept(ModItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
                        output.accept(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
                        output.accept(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
                        // -------------------- 末地 --------------------
                        output.accept(ModItems.DREAMFRUIT.get()); // 迷梦果


                        // ==================== 物品 ====================
                        // -------------------- 下界 --------------------
                        output.accept(ModItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
                        output.accept(ModItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
                        // -------------------- 末地 --------------------
                        output.accept(ModItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶


                        // ==================== 酒类 ====================
                        // -------------------- 下界 --------------------
                        output.accept(ModItems.CRIMSON_CRESCENDO.get()); // 绯红绝响
                        output.accept(ModItems.ETHEREAL_NOBLE.get()); // 诡影尊爵
                        output.accept(ModItems.WART_HENNESSY.get()); // 疣域轩尼诗
                        output.accept(ModItems.BLAZE_MARTELL.get()); // 烈焰马爹利
                        output.accept(ModItems.MAGMA_ROYAL_SALUTE.get()); // 岩浆皇家礼炮
                        output.accept(ModItems.BLACK_BONE_LAFITE.get()); // 黑骨拉菲
                        // -------------------- 末地 --------------------
                        output.accept(ModItems.CHORUS_COGNAC.get()); // 紫颂干邑
                        output.accept(ModItems.DRAGONS_BREATH_BRANDY.get()); // 龙息白兰地
                        output.accept(ModItems.ABYSSAL_PORTER.get()); // 深渊波特
                        output.accept(ModItems.SILENT_SHERRY.get()); // 静默雪莉
                        output.accept(ModItems.FORGOTTEN_MARGARITA.get()); // 遗忘玛格丽特
                        output.accept(ModItems.PHANTOM_DREAM_BUBBLE.get()); // 幻梦泡影
                        output.accept(ModItems.END_STARLIGHT.get()); // 终末星光
                        output.accept(ModItems.DIVINE_EMBRYO_PORT.get()); // 神血波尔多
                        output.accept(ModItems.DRACONIC_BLOOD_WINE.get()); // 龙血酒





                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
