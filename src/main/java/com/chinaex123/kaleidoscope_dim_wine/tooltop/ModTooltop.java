//package com.chinaex123.kaleidoscope_dim_wine.tooltop;
//
//import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.ItemStack;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
//
//import java.util.List;
//
//@EventBusSubscriber(modid = "kaleidoscope_dim_wine")
//public class ModTooltop {
//
//    @SubscribeEvent
//    public static void onItemTooltip(ItemTooltipEvent event) {
//        ItemStack stack = event.getItemStack();
//        List<Component> tooltip = event.getToolTip();
//
//        // 绯红葡萄藤
//        if (stack.getItem() == ModItems.CRIMSON_GRAPEVINE.get()) {
//            tooltip.add(Component.translatable("item.kaleidoscope_dim_wine.crimson_grapevine.tooltip").withStyle(ChatFormatting.GREEN));
//        }
//    }
//}
