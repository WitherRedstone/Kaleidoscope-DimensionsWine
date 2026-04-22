package com.chinaex123.kaleidoscope_dim_wine.loot;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
public class EntityLootInjector {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableId = event.getName();

        if (ModList.get().isLoaded("twilightforest")) {
            if (tableId.equals(ResourceLocation.fromNamespaceAndPath("twilightforest", "entities/redcap"))) {
                List<? extends Double> chances = ServerConfig.REDCAP_GOBLIN_ESSENCE_LOOTING_CHANCES.get();

                LootPool bonusPool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 1.0f))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.MOB_LOOTING,
                                chances.get(0).floatValue(),
                                chances.get(1).floatValue(),
                                chances.get(2).floatValue(),
                                chances.get(3).floatValue()))
                        .add(LootItem.lootTableItem(TwilightforestItems.GOBLIN_ESSENCE.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.MOB_LOOTING))
                        .name("kaleidoscope_dim_wine:goblin_essence_redcap")
                        .build();
                event.getTable().addPool(bonusPool);
            }
        }

        if (tableId.equals(ResourceLocation.withDefaultNamespace("entities/wither"))) {
            LootPool bonusPool = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(1.0f, 1.0f))
                    .when(LootItemRandomChanceCondition.randomChance(ServerConfig.WITHER_COMMAND_LIGHTS_DROP_CHANCE.get().floatValue()))
                    .add(LootItem.lootTableItem(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                    .name("kaleidoscope_dim_wine:string_lights_block_command")
                    .build();
            event.getTable().addPool(bonusPool);
        }

        if (ModList.get().isLoaded("aether")) {
            if (tableId.equals(ResourceLocation.fromNamespaceAndPath("aether","entities/valkyrie"))) {
                LootPool bonusPool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(ServerConfig.ANGEL_WINGS_DROP_CHANCE.get().floatValue()))
                        .add(LootItem.lootTableItem(ModItems.ANGEL_WINGS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(ServerConfig.ANGEL_WINGS_DROP_MIN.get(), ServerConfig.ANGEL_WINGS_DROP_MAX.get())))
                        .name("kaleidoscope_dim_wine:angel_wings")
                        .build();
                event.getTable().addPool(bonusPool);
            }
        }
    }
}
