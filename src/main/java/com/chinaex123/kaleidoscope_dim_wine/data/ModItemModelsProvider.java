package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

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
        basicDrinkItem(ModItems.CRIMSON_CRESCENDO); // 绯红绝响
        basicDrinkItem(ModItems.ETHEREAL_NOBLE); // 诡影尊爵
        basicDrinkItem(ModItems.WART_HENNESSY); // 疣域轩尼诗
        basicDrinkItem(ModItems.BLAZE_MARTELL); // 烈焰马爹利
        basicDrinkItem(ModItems.MAGMA_ROYAL_SALUTE); // 岩浆皇家礼炮
        basicDrinkItem(ModItems.BLACK_BONE_LAFITE); // 黑骨拉菲


        // ==================== 次元维度 - 末地 ====================
        // -------------------- 作物 --------------------
        basicItem(ModItems.DREAMFRUIT.get()); // 迷梦果
        // -------------------- 物品 --------------------
        basicItem(ModItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶
        // -------------------- 流体 --------------------
        basicItem(ModItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
        basicItem(ModItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶
        // -------------------- 酒类 --------------------
        basicDrinkItem(ModItems.CHORUS_COGNAC); // 紫颂干邑
        basicDrinkItem(ModItems.DRAGONS_BREATH_BRANDY); // 龙息白兰地
        basicDrinkItem(ModItems.ABYSSAL_PORTER); // 深渊波特
        basicDrinkItem(ModItems.SILENT_SHERRY); // 静默雪莉
        basicDrinkItem(ModItems.FORGOTTEN_MARGARITA); // 遗忘玛格丽特
        basicDrinkItem(ModItems.PHANTOM_DREAM_BUBBLE); // 幻梦泡影
        basicDrinkItem(ModItems.END_STARLIGHT); // 终末星光
        basicDrinkItem(ModItems.DIVINE_EMBRYO_PORT); // 神血波尔多
        basicDrinkItem(ModItems.DRACONIC_BLOOD_WINE); // 龙血酒


        // ==================== 次元维度 - 暮色森林 ====================
        // -------------------- 作物 --------------------
        basicItem(ModItems.FROSTHEART_FRUIT.getId()); // 霜心果
        // -------------------- 物品 --------------------
        // -------------------- 流体 --------------------
        basicItem(ModItems.TORCHBERRIES_JUICE_BUCKET.getId()); // 火炬浆果汁桶
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

    /**
     * 酒类物品贴图路径（路径：textures/item/drink）
     */
    private void basicDrinkItem(DeferredHolder<Item, ? extends Item> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "item/drink/" + itemName));
    }
}
