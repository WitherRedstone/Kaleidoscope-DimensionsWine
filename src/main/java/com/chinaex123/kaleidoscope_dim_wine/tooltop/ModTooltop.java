package com.chinaex123.kaleidoscope_dim_wine.tooltop;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
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
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("block.kaleidoscope_dim_wine.doll_001.tooltip").getString();
            tooltip.add(GradientTextHelper.createFullRainbowText(text, false,  0.25, false, false, false, false, false));
        }

        // 玩偶 - Fvue233
        if (stack.getItem() == ModBlocks.DOLL_002.get().asItem()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("block.kaleidoscope_dim_wine.doll_002.tooltip").getString();
            tooltip.add(GradientTextHelper.createNatureSeasonsGradientText(text, false,  1.0, false, false, false, false, false));
        }

        // 绯红葡萄藤 - 相当于作物的种子
        if (stack.getItem() == ModItems.CRIMSON_GRAPEVINE.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.crimson_grapevine").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.crimson_grapevine").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text2, false,  1.0, false, false, false, false, false));
        }

        // 绯红葡萄藤 - 相当于作物的种子
        if (stack.getItem() == ModItems.WARPED_GRAPEVINE.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.warped_grapevine").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.warped_grapevine").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text2, false,  1.0, false, false, false, false, false));
        }

        // 迷梦果
        if (stack.getItem() == ModItems.DREAMFRUIT.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.dreamfruit").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.dreamfruit").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text2, false,  1.0, false, false, false, false, false));
        }

        // 绯红菌露
        if (stack.getItem() == ModItems.CRIMSON_FUNGAL_SAP.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.crimson_fungal_sap").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
        }

        // 诡影菌髓
        if (stack.getItem() == ModItems.WARPED_FUNGAL_SAP.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.warped_fungal_sap").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
        }
    }
}

// 再写一个 的往复渐变

