package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFoods;
import com.chinaex123.kaleidoscope_dim_wine.item.Crop.FrostheartFruitItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;

public class TwilightforestItems {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 次元维度 - 暮色森林 ====================
    // -------------------- 作物 --------------------
    // 霜心果
    public static final DeferredItem<Item> FROSTHEART_FRUIT =
            ITEMS_REGISTER.register("frostheart_fruit", () -> new FrostheartFruitItem(new Item.Properties().food(ModFoods.FROSTHEART_FRUIT)));
    // -------------------- 物品 --------------------
    // -------------------- 流体 --------------------
    // 火炬浆果汁桶
    public static final DeferredItem<Item> TORCHBERRIES_JUICE_BUCKET =
            ITEMS_REGISTER.register("torchberries_juice_bucket", () -> new BucketItem(TwilightforestFluids.TORCHBERRIES_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // 霜心果汁桶
    public static final DeferredItem<Item> FROSTHEART_FRUIT_JUICE_BUCKET =
            ITEMS_REGISTER.register("frostheart_fruit_juice_bucket", () -> new BucketItem(TwilightforestFluids.FROSTHEART_FRUIT_JUICE.get(),
                    new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    // -------------------- 酒类 --------------------

    public static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
