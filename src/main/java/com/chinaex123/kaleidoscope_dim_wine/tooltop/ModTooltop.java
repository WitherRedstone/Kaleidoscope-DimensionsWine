package com.chinaex123.kaleidoscope_dim_wine.tooltop;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.util.GradientTextHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = "kaleidoscope_dim_wine")
public class ModTooltop {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        // 玩偶 - ChinaEX123_BILI
        if (stack.getItem() == ModBlocks.DOLL_001.get().asItem()) {
            String text = Component.translatable("block.kaleidoscope_dim_wine.doll_001.tooltip").getString();
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            tooltip.add(GradientTextHelper.createFullRainbowText(text, false,  0.25, false, false, false, false, false));
        }
        // 玩偶 - Fvue233
        if (stack.getItem() == ModBlocks.DOLL_002.get().asItem()) {
            String text = Component.translatable("block.kaleidoscope_dim_wine.doll_001.tooltip").getString();
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            tooltip.add(GradientTextHelper.createNatureSeasonsGradientText(text, false,  1.0, false, false, false, false, false));
        }
    }
}

// 再写一个 的往复渐变

