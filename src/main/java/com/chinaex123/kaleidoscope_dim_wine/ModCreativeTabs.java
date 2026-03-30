package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
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

                        // ==================== 次元维度 - 下界 ====================
                        // -------------------- 作物 --------------------
                        output.accept(ModItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
                        output.accept(ModItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
                        output.accept(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
                        output.accept(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
                        // -------------------- 物品 --------------------
                        output.accept(ModItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
                        output.accept(ModItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
                        // -------------------- 酒类 --------------------
                        output.accept(ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
                        output.accept(ModItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
                        // -------------------- 酒类 --------------------
                        output.accept(ModItems.CRIMSON_CRESCENDO.get()); // 绯红绝响
                        output.accept(ModItems.ETHEREAL_NOBLE.get()); // 诡影尊爵
                        output.accept(ModItems.WART_HENNESSY.get()); // 疣域轩尼诗
                        output.accept(ModItems.BLAZE_MARTELL.get()); // 烈焰马爹利
                        output.accept(ModItems.MAGMA_ROYAL_SALUTE.get()); // 岩浆皇家礼炮
                        output.accept(ModItems.BLACK_BONE_LAFITE.get()); // 黑骨拉菲

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
