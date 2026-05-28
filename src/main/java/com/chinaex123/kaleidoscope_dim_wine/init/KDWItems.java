package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.CrimsonGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.DreamfruitCropWildVineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.crop.WarpedGrapevineItem;
import com.chinaex123.kaleidoscope_dim_wine.item.DrinkableItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.BottleBlockItem;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface KDWItems {
    DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeDimensionsWine.MOD_ID);
    RegistryObject<Item> MOD_LOGO = ITEMS_REGISTER.register("mod_logo", () -> new Item(new Item.Properties()));

    // ==================== 次元维度 - 主世界 ====================
    // 物品
    RegistryObject<Item> ANGEL_WINGS = ITEMS_REGISTER.register("angel_wings", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    RegistryObject<Item> ANGEL_FEATHER = ITEMS_REGISTER.register("angel_feather", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    // 作物
    RegistryObject<Item> HOP = ITEMS_REGISTER.register("hop", () -> new Item(new Item.Properties().food(KDWFoods.GRAPE)));
    RegistryObject<Item> HOP_SEED = ITEMS_REGISTER.register("hop_seed", () -> new ItemNameBlockItem(KDWBlocks.HOP_CROP.get(), new Item.Properties()));

    // 瓶装
    RegistryObject<Item> POP_CAN = ITEMS_REGISTER.register("pop_can", () -> new BottleBlockItem(KDWBlocks.POP_CAN.get(), new Item.Properties()));

    // ==================== 次元维度 - 下界 ====================
    // 作物
    RegistryObject<Item> CRIMSON_GRAPEVINE = ITEMS_REGISTER.register("crimson_grapevine", CrimsonGrapevineItem::new);
    RegistryObject<Item> CRIMSON_GRAPE = ITEMS_REGISTER.register("crimson_grape", () -> new Item(new Item.Properties().food(KDWFoods.GRAPE)));
    RegistryObject<Item> WARPED_GRAPEVINE = ITEMS_REGISTER.register("warped_grapevine", WarpedGrapevineItem::new);
    RegistryObject<Item> WARPED_GRAPE = ITEMS_REGISTER.register("warped_grape", () -> new Item(new Item.Properties().food(KDWFoods.GRAPE)));

    // 物品
    RegistryObject<Item> CRIMSON_FUNGAL_SAP = ITEMS_REGISTER.register("crimson_fungal_sap", () -> new Item(new Item.Properties()));
    RegistryObject<Item> WARPED_FUNGAL_SAP = ITEMS_REGISTER.register("warped_fungal_sap", () -> new Item(new Item.Properties()));

    // 流体
    RegistryObject<Item> CRIMSON_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("crimson_grape_juice_bucket", () ->
            new BucketItem(KDWFluids.CRIMSON_GRAPE_JUICE, new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    RegistryObject<Item> WARPED_GRAPE_JUICE_BUCKET = ITEMS_REGISTER.register("warped_grape_juice_bucket", () ->
            new BucketItem(KDWFluids.WARPED_GRAPE_JUICE, new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));

    // 酒类
    RegistryObject<Item> CRIMSON_CRESCENDO = ITEMS_REGISTER.register("crimson_crescendo", () -> new DrinkBlockItem(KDWBlocks.CRIMSON_CRESCENDO.get()));
    RegistryObject<Item> ETHEREAL_NOBLE = ITEMS_REGISTER.register("ethereal_noble", () -> new DrinkBlockItem(KDWBlocks.ETHEREAL_NOBLE.get()));
    RegistryObject<Item> WART_HENNESSY = ITEMS_REGISTER.register("wart_hennessy", () -> new DrinkBlockItem(KDWBlocks.WART_HENNESSY.get()));
    RegistryObject<Item> BLAZE_MARTELL = ITEMS_REGISTER.register("blaze_martell", () -> new DrinkBlockItem(KDWBlocks.BLAZE_MARTELL.get()));
    RegistryObject<Item> MAGMA_ROYAL_SALUTE = ITEMS_REGISTER.register("magma_royal_salute", () -> new DrinkBlockItem(KDWBlocks.MAGMA_ROYAL_SALUTE.get()));
    RegistryObject<Item> BLACK_BONE_LAFITE = ITEMS_REGISTER.register("black_bone_lafite", () -> new DrinkBlockItem(KDWBlocks.BLACK_BONE_LAFITE.get()));


    // ==================== 次元维度 - 末地 ====================
    // 作物
    RegistryObject<Item> DREAMFRUIT = ITEMS_REGISTER.register("dreamfruit", () -> new DreamfruitCropWildVineItem(new Item.Properties().food(KDWFoods.FRUITS)));

    // 物品
    RegistryObject<Item> DRAGON_BLOOD_BOTTLE = ITEMS_REGISTER.register("dragon_blood_bottle", () ->
            new DrinkableItem(new Item.Properties().food(KDWFoods.DRAGON_BLOOD_BOTTLE), new ItemStack(Items.GLASS_BOTTLE)));

    // 流体
    RegistryObject<Item> DREAMFRUIT_JUICE_BUCKET = ITEMS_REGISTER.register("dreamfruit_juice_bucket", () ->
            new BucketItem(KDWFluids.DREAMFRUIT_JUICE, new Item.Properties().stacksTo(16).craftRemainder(Items.BUCKET)));
    RegistryObject<Item> DRAGON_BLOOD_BUCKET = ITEMS_REGISTER.register("dragon_blood_bucket", () ->
            new BucketItem(KDWFluids.DRAGON_BLOOD, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    // 酒类
    RegistryObject<Item> CHORUS_COGNAC = ITEMS_REGISTER.register("chorus_cognac", () -> new DrinkBlockItem(KDWBlocks.CHORUS_COGNAC.get()));
    RegistryObject<Item> DRAGONS_BREATH_BRANDY = ITEMS_REGISTER.register("dragons_breath_brandy", () -> new DrinkBlockItem(KDWBlocks.DRAGONS_BREATH_BRANDY.get()));
    RegistryObject<Item> ABYSSAL_PORTER = ITEMS_REGISTER.register("abyssal_porter", () -> new DrinkBlockItem(KDWBlocks.ABYSSAL_PORTER.get()));
    RegistryObject<Item> SILENT_SHERRY = ITEMS_REGISTER.register("silent_sherry", () -> new DrinkBlockItem(KDWBlocks.SILENT_SHERRY.get()));
    RegistryObject<Item> FORGOTTEN_MARGARITA = ITEMS_REGISTER.register("forgotten_margarita", () -> new DrinkBlockItem(KDWBlocks.FORGOTTEN_MARGARITA.get()));
    RegistryObject<Item> PHANTOM_DREAM_BUBBLE = ITEMS_REGISTER.register("phantom_dream_bubble", () -> new DrinkBlockItem(KDWBlocks.PHANTOM_DREAM_BUBBLE.get()));
    RegistryObject<Item> END_STARLIGHT = ITEMS_REGISTER.register("end_starlight", () -> new DrinkBlockItem(KDWBlocks.END_STARLIGHT.get()));
    RegistryObject<Item> DIVINE_EMBRYO_PORT = ITEMS_REGISTER.register("divine_embryo_port", () -> new DrinkBlockItem(KDWBlocks.DIVINE_EMBRYO_PORT.get()));
    RegistryObject<Item> DRACONIC_BLOOD_WINE = ITEMS_REGISTER.register("draconic_blood_wine", () -> new DrinkBlockItem(KDWBlocks.DRACONIC_BLOOD_WINE.get()));

    static void register(IEventBus eventBus){
        ITEMS_REGISTER.register(eventBus);
    }
}
