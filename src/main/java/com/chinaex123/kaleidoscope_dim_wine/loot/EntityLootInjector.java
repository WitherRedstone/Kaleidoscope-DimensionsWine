package com.chinaex123.kaleidoscope_dim_wine.loot;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.config.KDWConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
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
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;

import java.util.List;

@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class EntityLootInjector {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableId = event.getName();

        // 获取附魔注册表查找器：查找时运附魔，增加掉落数量
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = event.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> lootingHolder = enchantmentLookup.getOrThrow(Enchantments.LOOTING);

        if (ModList.get().isLoaded("twilightforest")) {
            // 红帽矮人和红帽工兵
            if (tableId.equals(ResourceLocation.fromNamespaceAndPath("twilightforest", "entities/redcap"))) {
                List<? extends Double> chances = KDWConfig.REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES.get();

                LootPool bonusPool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 1.0f))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(lootingHolder,
                                chances.get(0).floatValue(),
                                chances.get(1).floatValue(),
                                chances.get(2).floatValue(),
                                chances.get(3).floatValue()))
                        .add(LootItem.lootTableItem(TwilightforestItems.GOBLIN_ESSENCE.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(ApplyBonusCount.addUniformBonusCount(lootingHolder))
                        .name("kaleidoscope_dim_wine:goblin_essence_redcap")
                        .build();
                event.getTable().addPool(bonusPool);
            }
        }

        // 凋灵
        if (tableId.equals(ResourceLocation.withDefaultNamespace("entities/wither"))) {
            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(1.0f, 1.0f))
                    .when(LootItemRandomChanceCondition.randomChance(KDWConfig.WITHER_COMMAND_LIGHTS_DROP_CHANCE.get().floatValue()))
                    .add(LootItem.lootTableItem(KDWBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                    .name("kaleidoscope_dim_wine:string_lights_block_command")
                    .build();
            event.getTable().addPool(bonusPool);
        }

        if (ModList.get().isLoaded("aether")) {
            // 女武神
            if (tableId.equals(ResourceLocation.fromNamespaceAndPath("aether","entities/valkyrie"))) {
                LootPool bonusPool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(KDWConfig.ANGEL_WINGS_DROP_CHANCE.get().floatValue()))
                        .add(LootItem.lootTableItem(KDWItems.ANGEL_WINGS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(KDWConfig.ANGEL_WINGS_DROP_MIN.get(), KDWConfig.ANGEL_WINGS_DROP_MAX.get())))
                        .name("kaleidoscope_dim_wine:angel_wings")
                        .build();
                event.getTable().addPool(bonusPool);
            }
        }
    }
}
