package com.chinaex123.kaleidoscope_dim_wine.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

import java.util.function.Function;

/**
 * 渐变文本助手 - 提供多种动态渐变颜色的文本组件生成工具
 */
public class GradientTextHelper {

    /**
     * 创建七彩彩虹渐变文本（红橙黄绿青蓝紫）
     */
    public static MutableComponent createFullRainbowText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateRainbowColor);
    }

    /**
     * 创建青黄渐变文本（#20E2D7 → #F9FEA5）
     */
    public static MutableComponent createCyanYellowGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateCyanYellowGradientColor);
    }

    /**
     * 创建粉色呼吸文本（基于 #FF00BB）
     */
    public static MutableComponent createPinkBreathingText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePinkBreathingColor);
    }

    /**
     * 创建蓝白渐变文本（#f0f0f4 → #d9def3 → #a1b7ee）
     */
    public static MutableComponent createBlueWhiteGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateBlueWhiteGradientColor);
    }

    /**
     * 创建粉绿黄渐变文本（#ffc8cd → #c8ffcd → #e1e1a0）
     */
    public static MutableComponent createPastelGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePastelGradientColor);
    }

    /**
     * 创建蓝紫渐变文本（#29d6d4 → #00b7e1 → #0093e3 → #3068cd → #77309a）
     */
    public static MutableComponent createBluePurpleGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateBluePurpleGradientColor);
    }

    /**
     * 创建粉蓝渐变文本（#f5edf0 → #dcbddf → #9a99e1 → #008bd0）
     */
    public static MutableComponent createPinkBlueGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePinkBlueGradientColor);
    }

    /**
     * 创建蓝绿渐变文本（#ebf0fd → #b7e0f9 → #73d4e1 → #40c4af → #50af69）
     */
    public static MutableComponent createBlueGreenGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateBlueGreenGradientColor);
    }

    /**
     * 创建紫白渐变文本（#d2b4e2 → #e7d6f1 → #7869a0）
     */
    public static MutableComponent createPurpleWhiteGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePurpleWhiteGradientColor);
    }

    /**
     * 创建暖色渐变文本（#fce8b2 → #bae1eb → #c19bbd → #eaa7b8）
     */
    public static MutableComponent createWarmGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateWarmGradientColor);
    }

    /**
     * 创建粉蓝深渐变文本（#f4a4c0 → #caf0fe → #0056d6）
     */
    public static MutableComponent createPinkBlueDeepGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePinkBlueDeepGradientColor);
    }

    /**
     * 创建马卡龙色渐变文本（#bdffbf → #ffe1d1 → #f4b3ff → #bdf5ff）
     */
    public static MutableComponent createMacaronGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateMacaronGradientColor);
    }

    /**
     * 创建暖黄橙渐变文本（#fff7d7 → #ffcb95 → #ffa489）
     */
    public static MutableComponent createWarmOrangeGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateWarmOrangeGradientColor);
    }

    /**
     * 创建橙黄渐变文本（#FF6B35 → #FF8C42 → #FFB347 → #FFD166 → #FFE77A）
     */
    public static MutableComponent createOrangeYellowGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateOrangeYellowGradientColor);
    }

    /**
     * 创建红橙渐变文本（#E54B4B → #FF6F61 → #FF9A76 → #FFC49B）
     */
    public static MutableComponent createRedOrangeGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateRedOrangeGradientColor);
    }

    /**
     * 创建橙红渐变文本（#E05A47 → #F27E5C → #FFA270 → #FFC285 → #FFDEA0）
     */
    public static MutableComponent createOrangeRedGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateOrangeRedGradientColor);
    }

    /**
     * 创建紫橙渐变文本（#5B4A7A → #A36B8F → #E89F8C → #FFCDA8）
     */
    public static MutableComponent createPurpleOrangeGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePurpleOrangeGradientColor);
    }

    /**
     * 创建青紫粉渐变文本（#24eb94 → #27ddbc → #11bae4 → #ae33f0 → #fa81ab）
     */
    public static MutableComponent createCyanPurplePinkGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateCyanPurplePinkGradientColor);
    }

    /**
     * 创建粉橙绿渐变文本（#e737c6 → #ff9c59 → #c3f3bb）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createPinkOrangeGreenGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePinkOrangeGreenGradientColor);
    }

    /**
     * 创建粉色渐变文本（#FFCCEE → #FF88DD → #FF00BB → #CC0099 → #990077）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createPinkGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculatePinkGradientColor);
    }

    /**
     * 创建柔和七色渐变文本（#ebbbbc → #cfe8ef → #e4ecc4 → #eacbc0 → #dcefd5 → #e4e4c4 → #e0bad4）
     */
    public static MutableComponent createSoftSevenGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateSoftSevenGradientColor);
    }

    /**
     * 创建蓝青渐变文本（#1b2c55 → #3d85a9 → #63cac8 → #b8edff）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createBlueCyanGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateBlueCyanGradientColor);
    }

    /**
     * 创建马卡龙四色渐变文本（#f3e5f5 → #ffe0b2 → #80deea → #ffeeff）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createMacaronFourGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateMacaronFourGradientColor);
    }

    /**
     * 创建马卡龙柔和渐变文本（#ffd1d1 → #f6ffb3 → #95e0e9 → #fbcbfb）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createMacaronSoftGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateMacaronSoftGradientColor);
    }

    /**
     * 创建梦幻四色渐变文本（#ad86d8 → #fe75b3 → #ff816a → #fab10e）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createDreamyFourGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateDreamyFourGradientColor);
    }

    /**
     * 创建深海极光渐变文本（#063e8a → #0081c9 → #00bfba → #42f36d）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createDeepSeaAuroraGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateDeepSeaAuroraGradientColor);
    }

    /**
     * 创建自然四季渐变文本（#3be70a → #c29500 → #c93e26 → #871553）
     * ~红石酱喜欢这个哇qwq~
     */
    public static MutableComponent createNatureSeasonsGradientText(String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated) {
        return createGradientText(text, leftToRight, speed, bold, italic, underlined, strikethrough, obfuscated, ColorCalculator::calculateNatureSeasonsGradientColor);
    }

    /**
     * 创建渐变文本的通用方法
     *
     * @param text 原始文本
     * @param leftToRight 渐变方向
     * @param speed 动画速度
     * @param bold 是否加粗
     * @param italic 是否斜体
     * @param underlined 是否下划线
     * @param strikethrough 是否删除线
     * @param obfuscated 是否乱码
     * @param colorCalculator 颜色计算函数
     * @return 带有渐变动画效果的组件
     */
    private static MutableComponent createGradientText(
            String text, boolean leftToRight, double speed, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated,
            Function<ColorParams, Integer> colorCalculator) {
        if (text == null || text.isEmpty()) {
            return Component.empty();
        }

        long time = System.currentTimeMillis();
        MutableComponent coloredText = Component.empty();
        double preciseTime = (double) time / 100 * speed;
        int textLength = text.length();

        for (int i = 0; i < textLength; i++) {
            char c = text.charAt(i);
            int index = leftToRight ? i : (textLength - 1 - i);

            int color = colorCalculator.apply(new ColorParams(index, textLength, preciseTime));

            Style style = Style.EMPTY.withColor(color)
                    .withBold(bold)
                    .withItalic(italic)
                    .withUnderlined(underlined)
                    .withStrikethrough(strikethrough)
                    .withObfuscated(obfuscated);

            coloredText.append(Component.literal(String.valueOf(c)).withStyle(style));
        }

        return coloredText;
    }

    /**
     * 颜色计算参数记录类
     */
    public record ColorParams(int index, int textLength, double preciseTime) { }
}
