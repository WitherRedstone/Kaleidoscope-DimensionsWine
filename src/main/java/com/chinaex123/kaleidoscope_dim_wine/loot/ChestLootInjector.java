//package com.chinaex123.kaleidoscope_dim_wine.loot;
//
//import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
//import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
//import net.minecraft.resources.ResourceLocation;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.event.LootTableLoadEvent;
//import net.minecraft.world.level.storage.loot.LootPool;
//import net.minecraft.world.level.storage.loot.entries.LootItem;
//import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
//import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
//import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
//
//@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID)
//public class ChestLootInjector {
//
//    @SubscribeEvent
//    public static void onLootTableLoad(LootTableLoadEvent event) {
//        ResourceLocation tableId = event.getName();
//
//        // 末地城宝藏箱子
//        if (tableId.equals(ResourceLocation.withDefaultNamespace("chests/end_city_treasure"))) {
//            LootPool bonusPool = LootPool.lootPool()
//                    .setRolls(UniformGenerator.between(1.0f, 1.0f)) // 设置投掷次数（抽取几次）
//                    .when(LootItemRandomChanceCondition.randomChance(0.01f)) // 概率
//                    .add(LootItem.lootTableItem(ModBlocks.STRING_LIGHTS_BLOCK_COMMAND.get())) // 小灯串（基岩）
//                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))) // 数量
//                    .name("kaleidoscope_dim_wine:string_lights_block_command_bonus")
//                    .build();
//            event.getTable().addPool(bonusPool);
//        }
//    }
//}
