package com.chinaex123.kaleidoscope_dim_wine.loot;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.config.KDWConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class BlockLootInjector {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableId = event.getName();

        // 绯红菌核 掉落池
        if (tableId.equals(ResourceLocation.withDefaultNamespace("blocks/crimson_nylium"))) {
            List<? extends Double> chances = KDWConfig.CRIMSON_NYLIUM_FUNGAL_SAP_CHANCES.get();
            int baseCount = KDWConfig.CRIMSON_NYLIUM_FUNGAL_SAP_COUNT.get();

            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                            chances.get(0).floatValue(),
                            chances.get(1).floatValue(),
                            chances.get(2).floatValue(),
                            chances.get(3).floatValue()))
                    .add(LootItem.lootTableItem(KDWItems.CRIMSON_FUNGAL_SAP.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(baseCount)))
                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                    )
                    .name("kaleidoscope_dim_wine:crimson_fungal_sap")
                    .build();
            event.getTable().addPool(bonusPool);
        }

        // 诡异菌核 掉落池
        if (tableId.equals(ResourceLocation.withDefaultNamespace("blocks/warped_nylium"))) {
            List<? extends Double> chances = KDWConfig.WARPED_NYLIUM_FUNGAL_SAP_CHANCES.get();
            int baseCount = KDWConfig.WARPED_NYLIUM_FUNGAL_SAP_COUNT.get();

            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                            chances.get(0).floatValue(),
                            chances.get(1).floatValue(),
                            chances.get(2).floatValue(),
                            chances.get(3).floatValue()))
                    .add(LootItem.lootTableItem(KDWItems.WARPED_FUNGAL_SAP.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(baseCount)))
                            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                    )
                    .name("kaleidoscope_dim_wine:warped_fungal_sap")
                    .build();
            event.getTable().addPool(bonusPool);
        }
    }
}
