package com.chinaex123.kaleidoscope_dim_wine.data.lootTable;

import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.fml.ModList;

import java.util.function.BiConsumer;

public class ModLootTableProvider implements LootTableSubProvider {

    private final HolderLookup.Provider provider;

    public ModLootTableProvider(HolderLookup.Provider provider) {
        this.provider = provider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            output.accept(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "advancements/twilightforest_wine")),
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(2))
                                    .add(LootItem.lootTableItem(Items.NETHER_STAR).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3))))
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "ore_meter")))) // 矿石感应仪
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "pocket_watch")))) // 兔子的怀表
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "moon_dial")))) // 月相罗盘
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "crumble_horn")))) // 瓦解之号角
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "peacock_feather_fan")))) // 孔雀羽扇
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "moonworm_queen")))) // 月光蠕虫女王
                                    .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "transformation_powder")))) // 转换粉
                            )
            );
        }

        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            output.accept(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "advancements/mead_essence")),
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(TheBumblezoneItems.MEAD_ESSENCE)) // 蜜酒精华
                            )
            );
        }
    }
}
