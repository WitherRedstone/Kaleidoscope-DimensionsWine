package com.chinaex123.kaleidoscope_dim_wine.tooltop;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.chinaex123.kaleidoscope_dim_wine.util.GradientTextHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = "kaleidoscope_dim_wine")
public class ModTooltop {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        // ==================== 次元维度 - 小彩蛋 ====================
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

        // 玩偶 - Agens_Eland
        if (stack.getItem() == ModBlocks.DOLL_003.get().asItem()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("block.kaleidoscope_dim_wine.doll_003.tooltip").getString();
            tooltip.add(GradientTextHelper.createNatureSeasonsGradientText(text, false,  1.0, false, false, false, false, false));
        }

        // ==================== 次元维度 - 装饰 ====================
        // 小灯串（基岩）
        if (stack.getItem() == ModBlocks.STRING_LIGHTS_BLOCK_BEDROCK.get().asItem()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.string_lights_block_bedrock.1").getString();
            tooltip.add(GradientTextHelper.createDreamyFourGradientText(text, false,  1.0, false, false, false, false, false));
            String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.string_lights_block_bedrock.2").getString();
            tooltip.add(GradientTextHelper.createDreamyFourGradientText(text2, false,  1.0, false, false, false, false, false));
        }

        // ==================== 次元维度 - 本体 ====================
        // 天使之翼
        if (stack.getItem() == ModItems.ANGEL_WINGS.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.angel_wings").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
        }

        // ==================== 次元维度 - 下界 ====================
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

        // ==================== 次元维度 - 末地 ====================
        // 迷梦果
        if (stack.getItem() == ModItems.DREAMFRUIT.get()) {
            // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
            String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.dreamfruit").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.dreamfruit").getString();
            tooltip.add(GradientTextHelper.createPinkGradientText(text2, false,  1.0, false, false, false, false, false));
        }

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // 霜心果
            if (stack.getItem() == TwilightforestItems.FROSTHEART_FRUIT.get()) {
                // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
                String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.frostheart_fruit").getString();
                tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
                String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.growing_environment.frostheart_fruit").getString();
                tooltip.add(GradientTextHelper.createPinkGradientText(text2, false,  1.0, false, false, false, false, false));
            }
            // 哥布林精华
            if (stack.getItem() == TwilightforestItems.GOBLIN_ESSENCE.get()) {
                // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
                String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.goblin_essence").getString();
                tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            }
        }

        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            // 蜜酒精华
            if (stack.getItem() == TheBumblezoneItems.MEAD_ESSENCE.get()) {
                // 检查耐久是否耗尽
                if (stack.getDamageValue() >= stack.getMaxDamage()) {
                    // 耗尽时的提示
                    String depletedText = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.depleted").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(depletedText, false, 1.0, false, false, false, false, false));
                } else {
                    // 正常状态下的提示
                    String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.1").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(text, false,  1.0, false, false, false, false, false));
                    String text2 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.2").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(text2, false,  1.0, false, false, false, false, false));
                    String text3 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.3").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(text3, false,  1.0, false, false, false, false, false));
                    String text4 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.4").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(text4, false,  1.0, false, false, false, false, false));
                    String text5 = Component.translatable("jei.info.kaleidoscope_dim_wine.items.info.mead_essence.5").getString();
                    tooltip.add(GradientTextHelper.createDreamyFourGradientText(text5, false,  1.0, false, false, false, false, false));
                }
            }
            // 凝碳粉
            if (stack.getItem() == TheBumblezoneItems.CARBOCRETIN_POWDER.get()) {
                // 形参：原始文本, 渐变方向（true=从左到右，false=从右到左）, 动画速度, 是否加粗, 是否斜体, 是否下划线, 是否删除线, 是否乱码
                String text = Component.translatable("jei.info.kaleidoscope_dim_wine.items.requirement.carbocretin_powder").getString();
                tooltip.add(GradientTextHelper.createPinkGradientText(text, false,  1.0, false, false, false, false, false));
            }
        }
    }
}
