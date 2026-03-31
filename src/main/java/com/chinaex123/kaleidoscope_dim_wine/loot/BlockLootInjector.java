package com.chinaex123.kaleidoscope_dim_wine.loot;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class BlockLootInjector {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableId = event.getName();

        // 获取附魔注册表查找器：查找时运附魔，增加掉落数量
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup =
                event.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> fortuneHolder = enchantmentLookup.getOrThrow(Enchantments.FORTUNE);

        // 绯红菌核 掉落池
        if (tableId.equals(ResourceLocation.withDefaultNamespace("blocks/crimson_nylium"))) {
            // 绯红菌露
            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(BonusLevelTableCondition.bonusLevelFlatChance(fortuneHolder, 0.05f, 0.075f, 0.10f, 0.15f))
                    .add(LootItem.lootTableItem(ModItems.CRIMSON_FUNGAL_SAP.get()))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(ApplyBonusCount.addOreBonusCount(fortuneHolder))
                    .name("kaleidoscope_dim_wine:crimson_fungal_sap_from_weeping_vines")
                    .build();
            event.getTable().addPool(bonusPool);
        }

        // 诡异菌核 掉落池
        if (tableId.equals(ResourceLocation.withDefaultNamespace("blocks/warped_nylium"))) {
            // 诡影菌髓
            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(BonusLevelTableCondition.bonusLevelFlatChance(fortuneHolder, 0.05f, 0.075f, 0.10f, 0.15f))
                    .add(LootItem.lootTableItem(ModItems.WARPED_FUNGAL_SAP.get()))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(ApplyBonusCount.addOreBonusCount(fortuneHolder))
                    .name("kaleidoscope_dim_wine:warped_fungal_sap_from_weeping_vines")
                    .build();
            event.getTable().addPool(bonusPool);
        }


//        float[] chancePerLevel = {0.025f, 0.05f, 0.075f, 0.10f}; // 时运概率
//        // 绯红葡萄藤
//        // 概率和数量受时运影响？但是抢夺的概率
//        if (tableId.equals(ResourceLocation.withDefaultNamespace("blocks/weeping_vines"))) {
//            LootPool bonusPool = LootPool.lootPool()
//                    .setRolls(ConstantValue.exactly(1.0f))
//                    .when(LootItemRandomChanceWithEnchantedBonusCondition
//                            .randomChanceAndLootingBoost(event.getRegistries(), 0.025f, 0.025f)) // 基础概率，每级时运改概率
//                    .add(LootItem.lootTableItem(ModItems.CRIMSON_GRAPEVINE.get()))
//                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
//                    .apply(ApplyBonusCount.addOreBonusCount(fortuneHolder))  // 数量受时运影响
//                    .name("kaleidoscope_dim_wine:crimson_grapevine_from_weeping_vines")
//                    .build();
//            event.getTable().addPool(bonusPool);
//        }
    }
}
