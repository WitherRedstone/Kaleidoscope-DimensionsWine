package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        basicItem(ModItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
        basicItem(ModItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        basicItem(ModItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
        basicItem(ModItems.WARPED_GRAPE.get()); // 诡异葡萄
        // -------------------- 物品 --------------------
        basicItem(ModItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
        basicItem(ModItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
        // -------------------- 流体 --------------------
        basicItem(ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
        basicItem(ModItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
        // -------------------- 酒类 --------------------
//        basicItem(ModItems.CRIMSON_CRESCENDO.get()); // 绯红绝响
        basicItem(ModItems.ETHEREAL_NOBLE.get()); // 诡影尊爵
        basicItem(ModItems.WART_HENNESSY.get()); // 疣域轩尼诗
        basicItem(ModItems.BLAZE_MARTELL.get()); // 烈焰马爹利
//        basicItem(ModItems.MAGMA_ROYAL_SALUTE.get()); // 岩浆皇家礼炮
//        basicItem(ModItems.BLACK_BONE_LAFITE.get()); // 黑骨拉菲


        // ==================== 次元维度 - 末地 ====================
        // -------------------- 作物 --------------------
//        basicItem(ModItems.DREAMFRUIT.get()); // 迷梦果
        // -------------------- 物品 --------------------
        basicItem(ModItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶
        // -------------------- 流体 --------------------
//        basicItem(ModItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
        basicItem(ModItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶
        // -------------------- 酒类 --------------------
//        basicItem(ModItems.CHORUS_COGNAC.get()); // 紫颂干邑
//        basicItem(ModItems.DRAGONS_BREATH_BRANDY.get()); // 龙息白兰地
//        basicItem(ModItems.ABYSSAL_PORTER.get()); // 深渊波特
//        basicItem(ModItems.SILENT_SHERRY.get()); // 静默雪莉
//        basicItem(ModItems.FORGOTTEN_MARGARITA.get()); // 遗忘玛格丽特
//        basicItem(ModItems.PHANTOM_DREAM_BUBBLE.get()); // 幻梦泡影
//        basicItem(ModItems.END_STARLIGHT.get()); // 终末星光
//        basicItem(ModItems.DIVINE_EMBRYO_PORT.get()); // 神血波尔多
//        basicItem(ModItems.DRACONIC_BLOOD.get()); // 龙血酒


        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        // -------------------- 物品 --------------------
        // -------------------- 流体 --------------------
        // -------------------- 酒类 --------------------


        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        // -------------------- 物品 --------------------
        // -------------------- 流体 --------------------
        // -------------------- 酒类 --------------------


        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        // -------------------- 物品 --------------------
        // -------------------- 流体 --------------------
        // -------------------- 酒类 --------------------


        // ==================== 次元维度 - 下界 ====================
        // -------------------- 作物 --------------------
        // -------------------- 物品 --------------------
        // -------------------- 流体 --------------------
        // -------------------- 酒类 --------------------
    }
}
