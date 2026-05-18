package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.UnknownNullability;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(KDWItems.MOD_LOGO.get()); // 模组logo
        basicItem(KDWItems.ANGEL_WINGS.get()); // 天使之翼
        basicItem(KDWItems.ANGEL_FEATHER.get()); // 天使之羽
        // ==================== 瓶装 ====================
//        basicItem(ModItems.EMPTY_BAMBOO_CUP.get()); // 空竹杯
        basicItem(KDWItems.POP_CAN.get()); // 易拉罐

        // ==================== 次元维度 - 下界 ====================
        // -------------------- 流体 --------------------
        basicItem(KDWItems.CRIMSON_GRAPE_JUICE_BUCKET.get()); // 绯红葡萄汁桶
        basicItem(KDWItems.WARPED_GRAPE_JUICE_BUCKET.get()); // 诡异葡萄汁桶
        // -------------------- 作物 --------------------
        basicItem(KDWItems.CRIMSON_GRAPEVINE.get()); // 绯红葡萄藤
        basicItem(KDWItems.CRIMSON_GRAPE.get()); // 绯红葡萄
        basicItem(KDWItems.WARPED_GRAPEVINE.get()); // 诡异葡萄藤
        basicItem(KDWItems.WARPED_GRAPE.get()); // 诡异葡萄
        // -------------------- 物品 --------------------
        basicItem(KDWItems.CRIMSON_FUNGAL_SAP.get()); // 绯红菌露
        basicItem(KDWItems.WARPED_FUNGAL_SAP.get()); // 诡影菌髓
        // -------------------- 酒类 --------------------
        basicDrinkItem(KDWItems.CRIMSON_CRESCENDO); // 绯红绝响
        basicDrinkItem(KDWItems.ETHEREAL_NOBLE); // 诡影尊爵
        basicDrinkItem(KDWItems.WART_HENNESSY); // 疣域轩尼诗
        basicDrinkItem(KDWItems.BLAZE_MARTELL); // 烈焰马爹利
        basicDrinkItem(KDWItems.MAGMA_ROYAL_SALUTE); // 岩浆皇家礼炮
        basicDrinkItem(KDWItems.BLACK_BONE_LAFITE); // 黑骨拉菲


        // ==================== 次元维度 - 末地 ====================
        // -------------------- 流体 --------------------
        basicItem(KDWItems.DREAMFRUIT_JUICE_BUCKET.get()); // 迷梦果汁桶
        basicItem(KDWItems.DRAGON_BLOOD_BUCKET.get()); // 龙血桶
        // -------------------- 作物 --------------------
        basicItem(KDWItems.DREAMFRUIT.get()); // 迷梦果
        // -------------------- 物品 --------------------
        basicItem(KDWItems.DRAGON_BLOOD_BOTTLE.get()); // 龙血瓶
        // -------------------- 酒类 --------------------
        basicDrinkItem(KDWItems.CHORUS_COGNAC); // 紫颂干邑
        basicDrinkItem(KDWItems.DRAGONS_BREATH_BRANDY); // 龙息白兰地
        basicDrinkItem(KDWItems.ABYSSAL_PORTER); // 深渊波特
        basicDrinkItem(KDWItems.SILENT_SHERRY); // 静默雪莉
        basicDrinkItem(KDWItems.FORGOTTEN_MARGARITA); // 遗忘玛格丽特
        basicDrinkItem(KDWItems.PHANTOM_DREAM_BUBBLE); // 幻梦泡影
        basicDrinkItem(KDWItems.END_STARLIGHT); // 终末星光
        basicDrinkItem(KDWItems.DIVINE_EMBRYO_PORT); // 神血波尔多
        basicDrinkItem(KDWItems.DRACONIC_BLOOD_WINE); // 龙血酒


        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // -------------------- 流体 --------------------
            basicItem(TwilightforestItems.TORCHBERRIES_JUICE_BUCKET.getId()); // 火炬浆果汁桶
            basicItem(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.getId()); // 霜心果汁桶
            // -------------------- 作物 --------------------
            basicItem(TwilightforestItems.FROSTHEART_FRUIT.getId()); // 霜心果
            // -------------------- 物品 --------------------
            basicItem(TwilightforestItems.COLOSSAL_FRAGMENT.getId()); // 巨物碎片
            basicItem(TwilightforestItems.GOBLIN_ESSENCE.getId()); // 哥布林精华
            // -------------------- 酒类 --------------------
            compatTwilightforestDrinkItem(TwilightforestItems.CAVE_GLOWBREW); // 洞窟萤火酿
            compatTwilightforestDrinkItem(TwilightforestItems.DAWNLIGHT_DEW); // 林隙晨露
            compatTwilightforestDrinkItem(TwilightforestItems.DEAD_END_SPITTLE); // 死巷之唾
            compatTwilightforestDrinkItem(TwilightforestItems.SNAKESKIN_LIQUEUR); // 蛇蜕利口酒
            compatTwilightforestDrinkItem(TwilightforestItems.FROSTVEIN_BEASTBLOOD); // 霜脉兽血
            compatTwilightforestDrinkItem(TwilightforestItems.RANGERS_SATCHEL); // 巡林客的背囊
            compatTwilightforestDrinkItem(TwilightforestItems.EMBEREYE); // 烬瞳
            compatTwilightforestDrinkItem(TwilightforestItems.STAGCALL_MONSOON); // 鹿鸣季风
            compatTwilightforestDrinkItem(TwilightforestItems.THORNHEART); // 荆棘之心
            compatTwilightforestDrinkItem(TwilightforestItems.DRUIDS_SECRET_BREW); // 德鲁伊的秘酿
            compatTwilightforestDrinkItem(TwilightforestItems.MOORGLOW_BIRDS_SONG); // 辉夜鸟之歌
            compatTwilightforestDrinkItem(TwilightforestItems.PERENNIAL_FROST); // 终年冻土
            compatTwilightforestDrinkItem(TwilightforestItems.GIANTS_HYMN); // 巨人赞歌
            compatTwilightforestDrinkItem(TwilightforestItems.GOBLINS_STASH); // 地精的私藏
        }


        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // -------------------- 物品 --------------------
            basicItem(TheBumblezoneItems.CARBOCRETIN_POWDER.get()); // 凝碳粉
            // -------------------- 酒类 --------------------
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.SPRITE); // 雪碧
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.PEPSI); // 可乐
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.FANTA); // 芬达
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.POLLEN_NECTAR); // 花粉甜酿
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.HONEYTHORN_MEAD); // 蜜刺佳酿
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.BEESWAX_HONEY_WINE); // 蜂蜡陈酿
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.SWEET_CRYSTAL_HONEY); // 甜蜜水晶
            compatTheBumblezoneDrinkItem(TheBumblezoneItems.ROYAL_HONEY_BREW); // 蜂王特酿
        }


        // ==================== 次元维度 - 天境 ====================
        if (ModList.get().isLoaded("aether")) {
            // -------------------- 物品 --------------------
            basicItem(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get()); // 神饯蓝莓汁桶
            // -------------------- 酒类 --------------------
            compatAetherDrinkItem(AetherItems.DIVINE_OFFERING_BREW); // 神饯紫晶酿
            compatAetherDrinkItem(AetherItems.DIVINE_ENERGY_MIST); // 神能迷雾
            compatAetherDrinkItem(AetherItems.SWET_FIZZ); // 史维特菲士
            compatAetherDrinkItem(AetherItems.GRAVITITE_DRUNK); // 重力醉
            compatAetherDrinkItem(AetherItems.HEALING_ELIXIR); // 治愈灵药
            compatAetherDrinkItem(AetherItems.GINGERBREAD_WARMER); // 姜饼暖饮
            compatAetherDrinkItem(AetherItems.UNBOUND_SKYBORN); // 无界苍穹
        }
    }

    /**
     * 酒类物品贴图路径（路径：textures/item/drink）
     */
    private void basicDrinkItem(@UnknownNullability RegistryObject<Item> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "item/drink/" + itemName));
    }

    /**
     * 联动酒类 - 暮色森林（路径：item/drink/compat/twilightforest）
     */
    private void compatTwilightforestDrinkItem(RegistryObject<Item> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "item/drink/compat/twilightforest/" + itemName));
    }

    /**
     * 联动酒类 - 蜜蜂领域（路径：item/drink/compat/the_bumblezone）
     */
    private void compatTheBumblezoneDrinkItem(RegistryObject<Item> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "item/drink/compat/the_bumblezone/" + itemName));
    }

    /**
     * 联动酒类 - 天境（路径：item/drink/compat/aether）
     */
    private void compatAetherDrinkItem(RegistryObject<Item> item) {
        String itemName = item.getId().getPath();
        ItemModelBuilder builder = withExistingParent(itemName, ResourceLocation.withDefaultNamespace("item/generated"));
        builder.texture("layer0", ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "item/drink/compat/aether/" + itemName));
    }
}
