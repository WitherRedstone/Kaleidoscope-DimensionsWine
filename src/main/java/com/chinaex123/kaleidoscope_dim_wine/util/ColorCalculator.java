package com.chinaex123.kaleidoscope_dim_wine.util;

/**
 * 颜色计算器 - 提供多种动态渐变颜色的 RGB 值计算工具
 */
public class ColorCalculator {

    /**
     * 计算彩虹渐变颜色值
     * <p>
     * 基于正弦函数生成红橙黄绿青蓝紫的七彩渐变效果，
     * 通过时间参数实现动态流动动画。
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateRainbowColor(GradientTextHelper.ColorParams params) {
        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.166) {
            // 第一阶段：红 → 橙
            p = wave * 6;
            currentRed = (int) (255 + (255 - 255) * p);
            currentGreen = (int) (0 + (165 - 0) * p);
            currentBlue = (int) (0 + (0 - 0) * p);
        } else if (wave < 0.333) {
            // 第二阶段：橙 → 黄
            p = (wave - 0.166) * 6;
            currentRed = (int) (255 + (255 - 255) * p);
            currentGreen = (int) (165 + (255 - 165) * p);
            currentBlue = (int) (0 + (0 - 0) * p);
        } else if (wave < 0.5) {
            // 第三阶段：黄 → 绿
            p = (wave - 0.333) * 6;
            currentRed = (int) (255 + (0 - 255) * p);
            currentGreen = (int) (255 + (255 - 255) * p);
            currentBlue = (int) (0 + (0 - 0) * p);
        } else if (wave < 0.666) {
            // 第四阶段：绿 → 青
            p = (wave - 0.5) * 6;
            currentRed = (int) (0 + (0 - 0) * p);
            currentGreen = (int) (255 + (255 - 255) * p);
            currentBlue = (int) (0 + (255 - 0) * p);
        } else if (wave < 0.833) {
            // 第五阶段：青 → 蓝
            p = (wave - 0.666) * 6;
            currentRed = (int) (0 + (0 - 0) * p);
            currentGreen = (int) (255 + (0 - 255) * p);
            currentBlue = (int) (255 + (255 - 255) * p);
        } else {
            // 第六阶段：蓝 → 紫
            p = (wave - 0.833) * 6;
            currentRed = (int) (0 + (148 - 0) * p);
            currentGreen = (int) (0 + (0 - 0) * p);
            currentBlue = (int) (255 + (255 - 255) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算青紫渐变颜色值（#00dbde 到 #fc00ff）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateCyanYellowGradientColor(GradientTextHelper.ColorParams params) {
        // #20E2D7 (RGB: 32, 226, 215)
        int startRed = 32, startGreen = 226, startBlue = 215;
        // #F9FEA5 (RGB: 249, 254, 165)
        int endRed = 249, endGreen = 254, endBlue = 165;

        // 计算渐变进度（0.0 到 1.0），加入时间实现流动
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 1.0;
        // 使用正弦波使渐变往复流动
        double wave = (Math.sin(progress * Math.PI * 2) + 1) / 2;

        // 线性插值计算当前颜色
        int currentRed = (int) (startRed + (endRed - startRed) * wave);
        int currentGreen = (int) (startGreen + (endGreen - startGreen) * wave);
        int currentBlue = (int) (startBlue + (endBlue - startBlue) * wave);

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉色呼吸颜色值（基于 #FF00BB 的亮度脉动）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePinkBreathingColor(GradientTextHelper.ColorParams params) {
        // #FF00BB (RGB: 255, 0, 187)
        int baseRed = 255, baseGreen = 0, baseBlue = 187;

        // 计算呼吸进度，结合位置和时间
        double breath = Math.sin(params.preciseTime() * 0.5 + (double) params.index() / params.textLength() * Math.PI * 2);
        // 亮度在 0.6 到 1.0 之间脉动
        double brightness = 0.8 + breath * 0.2;

        int currentRed = (int) (baseRed * brightness);
        int currentGreen = (int) (baseGreen * brightness);
        int currentBlue = (int) (baseBlue * brightness);

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算蓝白渐变颜色值（#f0f0f4 → #d9def3 → #a1b7ee 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateBlueWhiteGradientColor(GradientTextHelper.ColorParams params) {
        // #f0f0f4 (RGB: 240, 240, 244)
        int color1Red = 240, color1Green = 240, color1Blue = 244;
        // #d9def3 (RGB: 217, 222, 243)
        int color2Red = 217, color2Green = 222, color2Blue = 243;
        // #a1b7ee (RGB: 161, 183, 238)
        int color3Red = 161, color3Green = 183, color3Blue = 238;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (color1Red + (color2Red - color1Red) * p);
            currentGreen = (int) (color1Green + (color2Green - color1Green) * p);
            currentBlue = (int) (color1Blue + (color2Blue - color1Blue) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (color2Red + (color3Red - color2Red) * p);
            currentGreen = (int) (color2Green + (color3Green - color2Green) * p);
            currentBlue = (int) (color2Blue + (color3Blue - color2Blue) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉绿黄渐变颜色值（#ffc8cd → #c8ffcd → #e1e1a0 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePastelGradientColor(GradientTextHelper.ColorParams params) {
        // #ffc8cd (RGB: 255, 200, 205)
        int color1Red = 255, color1Green = 200, color1Blue = 205;
        // #c8ffcd (RGB: 200, 255, 205)
        int color2Red = 200, color2Green = 255, color2Blue = 205;
        // #e1e1a0 (RGB: 225, 225, 160)
        int color3Red = 225, color3Green = 225, color3Blue = 160;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (color1Red + (color2Red - color1Red) * p);
            currentGreen = (int) (color1Green + (color2Green - color1Green) * p);
            currentBlue = (int) (color1Blue + (color2Blue - color1Blue) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (color2Red + (color3Red - color2Red) * p);
            currentGreen = (int) (color2Green + (color3Green - color2Green) * p);
            currentBlue = (int) (color2Blue + (color3Blue - color2Blue) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算蓝紫渐变颜色值（#29d6d4 → #00b7e1 → #0093e3 → #3068cd → #77309a 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateBluePurpleGradientColor(GradientTextHelper.ColorParams params) {
        // #29d6d4 (RGB: 41, 214, 212)
        int c1r = 41, c1g = 214, c1b = 212;
        // #00b7e1 (RGB: 0, 183, 225)
        int c2r = 0, c2g = 183, c2b = 225;
        // #0093e3 (RGB: 0, 147, 227)
        int c3r = 0, c3g = 147, c3b = 227;
        // #3068cd (RGB: 48, 104, 205)
        int c4r = 48, c4g = 104, c4b = 205;
        // #77309a (RGB: 119, 48, 154)
        int c5r = 119, c5g = 48, c5b = 154;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉蓝渐变颜色值（#f5edf0 → #dcbddf → #9a99e1 → #008bd0 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePinkBlueGradientColor(GradientTextHelper.ColorParams params) {
        // #f5edf0 (RGB: 245, 237, 240)
        int c1r = 245, c1g = 237, c1b = 240;
        // #dcbddf (RGB: 220, 189, 223)
        int c2r = 220, c2g = 189, c2b = 223;
        // #9a99e1 (RGB: 154, 153, 225)
        int c3r = 154, c3g = 153, c3b = 225;
        // #008bd0 (RGB: 0, 139, 208)
        int c4r = 0, c4g = 139, c4b = 208;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算蓝绿渐变颜色值（#ebf0fd → #b7e0f9 → #73d4e1 → #40c4af → #50af69 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateBlueGreenGradientColor(GradientTextHelper.ColorParams params) {
        // #ebf0fd (RGB: 235, 240, 253)
        int c1r = 235, c1g = 240, c1b = 253;
        // #b7e0f9 (RGB: 183, 224, 249)
        int c2r = 183, c2g = 224, c2b = 249;
        // #73d4e1 (RGB: 115, 212, 225)
        int c3r = 115, c3g = 212, c3b = 225;
        // #40c4af (RGB: 64, 196, 175)
        int c4r = 64, c4g = 196, c4b = 175;
        // #50af69 (RGB: 80, 175, 105)
        int c5r = 80, c5g = 175, c5b = 105;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算紫白渐变颜色值（#d2b4e2 → #e7d6f1 → #7869a0 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePurpleWhiteGradientColor(GradientTextHelper.ColorParams params) {
        // #d2b4e2 (RGB: 210, 180, 226)
        int c1r = 210, c1g = 180, c1b = 226;
        // #e7d6f1 (RGB: 231, 214, 241)
        int c2r = 231, c2g = 214, c2b = 241;
        // #7869a0 (RGB: 120, 105, 160)
        int c3r = 120, c3g = 105, c3b = 160;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算暖色渐变颜色值（#fce8b2 → #bae1eb → #c19bbd → #eaa7b8 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateWarmGradientColor(GradientTextHelper.ColorParams params) {
        // #fce8b2 (RGB: 252, 232, 178)
        int c1r = 252, c1g = 232, c1b = 178;
        // #bae1eb (RGB: 186, 225, 235)
        int c2r = 186, c2g = 225, c2b = 235;
        // #c19bbd (RGB: 193, 155, 189)
        int c3r = 193, c3g = 155, c3b = 189;
        // #eaa7b8 (RGB: 234, 167, 184)
        int c4r = 234, c4g = 167, c4b = 184;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉蓝深渐变颜色值（#f4a4c0 → #caf0fe → #0056d6 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePinkBlueDeepGradientColor(GradientTextHelper.ColorParams params) {
        // #f4a4c0 (RGB: 244, 164, 192)
        int c1r = 244, c1g = 164, c1b = 192;
        // #caf0fe (RGB: 202, 240, 254)
        int c2r = 202, c2g = 240, c2b = 254;
        // #0056d6 (RGB: 0, 86, 214)
        int c3r = 0, c3g = 86, c3b = 214;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算马卡龙色渐变颜色值（#bdffbf → #ffe1d1 → #f4b3ff → #bdf5ff 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateMacaronGradientColor(GradientTextHelper.ColorParams params) {
        // #bdffbf (RGB: 189, 255, 191)
        int c1r = 189, c1g = 255, c1b = 191;
        // #ffe1d1 (RGB: 255, 225, 209)
        int c2r = 255, c2g = 225, c2b = 209;
        // #f4b3ff (RGB: 244, 179, 255)
        int c3r = 244, c3g = 179, c3b = 255;
        // #bdf5ff (RGB: 189, 245, 255)
        int c4r = 189, c4g = 245, c4b = 255;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算暖黄橙渐变颜色值（#fff7d7 → #ffcb95 → #ffa489 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateWarmOrangeGradientColor(GradientTextHelper.ColorParams params) {
        // #fff7d7 (RGB: 255, 247, 215)
        int c1r = 255, c1g = 247, c1b = 215;
        // #ffcb95 (RGB: 255, 203, 149)
        int c2r = 255, c2g = 203, c2b = 149;
        // #ffa489 (RGB: 255, 164, 137)
        int c3r = 255, c3g = 164, c3b = 137;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算橙黄渐变颜色值（#FF6B35 → #FF8C42 → #FFB347 → #FFD166 → #FFE77A 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateOrangeYellowGradientColor(GradientTextHelper.ColorParams params) {
        // #FF6B35 (RGB: 255, 107, 53)
        int c1r = 255, c1g = 107, c1b = 53;
        // #FF8C42 (RGB: 255, 140, 66)
        int c2r = 255, c2g = 140, c2b = 66;
        // #FFB347 (RGB: 255, 179, 71)
        int c3r = 255, c3g = 179, c3b = 71;
        // #FFD166 (RGB: 255, 209, 102)
        int c4r = 255, c4g = 209, c4b = 102;
        // #FFE77A (RGB: 255, 231, 122)
        int c5r = 255, c5g = 231, c5b = 122;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算红橙渐变颜色值（#E54B4B → #FF6F61 → #FF9A76 → #FFC49B 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateRedOrangeGradientColor(GradientTextHelper.ColorParams params) {
        // #E54B4B (RGB: 229, 75, 75)
        int c1r = 229, c1g = 75, c1b = 75;
        // #FF6F61 (RGB: 255, 111, 97)
        int c2r = 255, c2g = 111, c2b = 97;
        // #FF9A76 (RGB: 255, 154, 118)
        int c3r = 255, c3g = 154, c3b = 118;
        // #FFC49B (RGB: 255, 196, 155)
        int c4r = 255, c4g = 196, c4b = 155;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算橙红渐变颜色值（#E05A47 → #F27E5C → #FFA270 → #FFC285 → #FFDEA0 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateOrangeRedGradientColor(GradientTextHelper.ColorParams params) {
        // #E05A47 (RGB: 224, 90, 71)
        int c1r = 224, c1g = 90, c1b = 71;
        // #F27E5C (RGB: 242, 126, 92)
        int c2r = 242, c2g = 126, c2b = 92;
        // #FFA270 (RGB: 255, 162, 112)
        int c3r = 255, c3g = 162, c3b = 112;
        // #FFC285 (RGB: 255, 194, 133)
        int c4r = 255, c4g = 194, c4b = 133;
        // #FFDEA0 (RGB: 255, 222, 160)
        int c5r = 255, c5g = 222, c5b = 160;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算紫橙渐变颜色值（#5B4A7A → #A36B8F → #E89F8C → #FFCDA8 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePurpleOrangeGradientColor(GradientTextHelper.ColorParams params) {
        // #5B4A7A (RGB: 91, 74, 122)
        int c1r = 91, c1g = 74, c1b = 122;
        // #A36B8F (RGB: 163, 107, 143)
        int c2r = 163, c2g = 107, c2b = 143;
        // #E89F8C (RGB: 232, 159, 140)
        int c3r = 232, c3g = 159, c3b = 140;
        // #FFCDA8 (RGB: 255, 205, 168)
        int c4r = 255, c4g = 205, c4b = 168;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算青紫粉渐变颜色值（#24eb94 → #27ddbc → #11bae4 → #ae33f0 → #fa81ab 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateCyanPurplePinkGradientColor(GradientTextHelper.ColorParams params) {
        // #24eb94 (RGB: 36, 235, 148)
        int c1r = 36, c1g = 235, c1b = 148;
        // #27ddbc (RGB: 39, 221, 188)
        int c2r = 39, c2g = 221, c2b = 188;
        // #11bae4 (RGB: 17, 186, 228)
        int c3r = 17, c3g = 186, c3b = 228;
        // #ae33f0 (RGB: 174, 51, 240)
        int c4r = 174, c4g = 51, c4b = 240;
        // #fa81ab (RGB: 250, 129, 171)
        int c5r = 250, c5g = 129, c5b = 171;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉橙绿渐变颜色值（#e737c6 → #ff9c59 → #c3f3bb 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePinkOrangeGreenGradientColor(GradientTextHelper.ColorParams params) {
        // #e737c6 (RGB: 231, 55, 198)
        int c1r = 231, c1g = 55, c1b = 198;
        // #ff9c59 (RGB: 255, 156, 89)
        int c2r = 255, c2g = 156, c2b = 89;
        // #c3f3bb (RGB: 195, 243, 187)
        int c3r = 195, c3g = 243, c3b = 187;

        // 计算渐变进度，使用正弦波实现往复循环
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 2.0;
        // 转换为 0→1→0 的往复进度
        double wave = progress < 1.0 ? progress : (2.0 - progress);

        int currentRed, currentGreen, currentBlue;
        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            double p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else {
            // 第二阶段：color2 → color3
            double p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算粉色渐变颜色值（#FFCCEE → #FF88DD → #FF00BB → #CC0099 → #990077 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculatePinkGradientColor(GradientTextHelper.ColorParams params) {
        // #FFCCEE (RGB: 255, 204, 238)
        int c1r = 255, c1g = 204, c1b = 238;
        // #FF88DD (RGB: 255, 136, 221)
        int c2r = 255, c2g = 136, c2b = 221;
        // #FF00BB (RGB: 255, 0, 187)
        int c3r = 255, c3g = 0, c3b = 187;
        // #CC0099 (RGB: 204, 0, 153)
        int c4r = 204, c4g = 0, c4b = 153;
        // #990077 (RGB: 153, 0, 119)
        int c5r = 153, c5g = 0, c5b = 119;

        // 计算渐变进度（0.0 到 4.0），实现五色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 4.0;
        // 转换为 0→2→0 的往复进度
        double wave = progress < 2.0 ? progress : (4.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算柔和七色渐变颜色值（#ebbbbc → #cfe8ef → #e4ecc4 → #eacbc0 → #dcefd5 → #e4e4c4 → #e0bad4 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateSoftSevenGradientColor(GradientTextHelper.ColorParams params) {
        // #ebbbbc (RGB: 235, 187, 188)
        int c1r = 235, c1g = 187, c1b = 188;
        // #cfe8ef (RGB: 207, 232, 239)
        int c2r = 207, c2g = 232, c2b = 239;
        // #e4ecc4 (RGB: 228, 236, 196)
        int c3r = 228, c3g = 236, c3b = 196;
        // #eacbc0 (RGB: 234, 203, 192)
        int c4r = 234, c4g = 203, c4b = 192;
        // #dcefd5 (RGB: 220, 239, 213)
        int c5r = 220, c5g = 239, c5b = 213;
        // #e4e4c4 (RGB: 228, 228, 196)
        int c6r = 228, c6g = 228, c6b = 196;
        // #e0bad4 (RGB: 224, 186, 212)
        int c7r = 224, c7g = 186, c7b = 212;

        // 计算渐变进度（0.0 到 6.0），实现七色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 6.0;
        // 转换为 0→3→0 的往复进度
        double wave = progress < 3.0 ? progress : (6.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 1.0) {
            // 第一阶段：color1 → color2
            p = wave;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 2.0) {
            // 第二阶段：color2 → color3
            p = wave - 1.0;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else if (wave < 3.0) {
            // 第三阶段：color3 → color4
            p = wave - 2.0;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        } else if (wave < 4.0) {
            // 第四阶段：color4 → color5
            p = wave - 3.0;
            currentRed = (int) (c4r + (c5r - c4r) * p);
            currentGreen = (int) (c4g + (c5g - c4g) * p);
            currentBlue = (int) (c4b + (c5b - c4b) * p);
        } else if (wave < 5.0) {
            // 第五阶段：color5 → color6
            p = wave - 4.0;
            currentRed = (int) (c5r + (c6r - c5r) * p);
            currentGreen = (int) (c5g + (c6g - c5g) * p);
            currentBlue = (int) (c5b + (c6b - c5b) * p);
        } else {
            // 第六阶段：color6 → color7
            p = wave - 5.0;
            currentRed = (int) (c6r + (c7r - c6r) * p);
            currentGreen = (int) (c6g + (c7g - c6g) * p);
            currentBlue = (int) (c6b + (c7b - c6b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算蓝青渐变颜色值（#1b2c55 → #3d85a9 → #63cac8 → #b8edff 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateBlueCyanGradientColor(GradientTextHelper.ColorParams params) {
        // #1b2c55 (RGB: 27, 44, 85)
        int c1r = 27, c1g = 44, c1b = 85;
        // #3d85a9 (RGB: 61, 133, 169)
        int c2r = 61, c2g = 133, c2b = 169;
        // #63cac8 (RGB: 99, 202, 200)
        int c3r = 99, c3g = 202, c3b = 200;
        // #b8edff (RGB: 184, 237, 255)
        int c4r = 184, c4g = 237, c4b = 255;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算马卡龙四色渐变颜色值（#f3e5f5 → #ffe0b2 → #80deea → #ffeeff 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateMacaronFourGradientColor(GradientTextHelper.ColorParams params) {
        // #f3e5f5 (RGB: 243, 229, 245)
        int c1r = 243, c1g = 229, c1b = 245;
        // #ffe0b2 (RGB: 255, 224, 178)
        int c2r = 255, c2g = 224, c2b = 178;
        // #80deea (RGB: 128, 222, 234)
        int c3r = 128, c3g = 222, c3b = 234;
        // #ffeeff (RGB: 255, 238, 255)
        int c4r = 255, c4g = 238, c4b = 255;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算马卡龙柔和渐变颜色值（#ffd1d1 → #f6ffb3 → #95e0e9 → #fbcbfb 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateMacaronSoftGradientColor(GradientTextHelper.ColorParams params) {
        // #ffd1d1 (RGB: 255, 209, 209)
        int c1r = 255, c1g = 209, c1b = 209;
        // #f6ffb3 (RGB: 246, 255, 179)
        int c2r = 246, c2g = 255, c2b = 179;
        // #95e0e9 (RGB: 149, 224, 233)
        int c3r = 149, c3g = 224, c3b = 233;
        // #fbcbfb (RGB: 251, 203, 251)
        int c4r = 251, c4g = 203, c4b = 251;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算梦幻四色渐变颜色值（#ad86d8 → #fe75b3 → #ff816a → #fab10e 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateDreamyFourGradientColor(GradientTextHelper.ColorParams params) {
        // #ad86d8 (RGB: 173, 134, 216)
        int c1r = 173, c1g = 134, c1b = 216;
        // #fe75b3 (RGB: 254, 117, 179)
        int c2r = 254, c2g = 117, c2b = 179;
        // #ff816a (RGB: 255, 129, 106)
        int c3r = 255, c3g = 129, c3b = 106;
        // #fab10e (RGB: 250, 177, 14)
        int c4r = 250, c4g = 177, c4b = 14;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算深海极光渐变颜色值（#063e8a → #0081c9 → #00bfba → #42f36d 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateDeepSeaAuroraGradientColor(GradientTextHelper.ColorParams params) {
        // #063e8a (RGB: 6, 62, 138)
        int c1r = 6, c1g = 62, c1b = 138;
        // #0081c9 (RGB: 0, 129, 201)
        int c2r = 0, c2g = 129, c2b = 201;
        // #00bfba (RGB: 0, 191, 186)
        int c3r = 0, c3g = 191, c3b = 186;
        // #42f36d (RGB: 66, 243, 109)
        int c4r = 66, c4g = 243, c4b = 109;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }

    /**
     * 计算自然四季渐变颜色值（#3be70a → #c29500 → #c93e26 → #871553 往复循环）
     *
     * @param params 颜色计算参数
     * @return RGB 颜色值（格式：0xRRGGBB）
     */
    public static int calculateNatureSeasonsGradientColor(GradientTextHelper.ColorParams params) {
        // #3be70a (RGB: 59, 231, 10)
        int c1r = 59, c1g = 231, c1b = 10;
        // #c29500 (RGB: 194, 149, 0)
        int c2r = 194, c2g = 149, c2b = 0;
        // #c93e26 (RGB: 201, 62, 38)
        int c3r = 201, c3g = 62, c3b = 38;
        // #871553 (RGB: 135, 21, 83)
        int c4r = 135, c4g = 21, c4b = 83;

        // 计算渐变进度（0.0 到 3.0），实现四色往复
        double progress = ((double) params.index() / params.textLength() + params.preciseTime() / 10) % 3.0;
        // 转换为 0→1.5→0 的往复进度
        double wave = progress < 1.5 ? progress : (3.0 - progress);

        int currentRed, currentGreen, currentBlue;
        double p;

        if (wave < 0.5) {
            // 第一阶段：color1 → color2
            p = wave * 2;
            currentRed = (int) (c1r + (c2r - c1r) * p);
            currentGreen = (int) (c1g + (c2g - c1g) * p);
            currentBlue = (int) (c1b + (c2b - c1b) * p);
        } else if (wave < 1.0) {
            // 第二阶段：color2 → color3
            p = (wave - 0.5) * 2;
            currentRed = (int) (c2r + (c3r - c2r) * p);
            currentGreen = (int) (c2g + (c3g - c2g) * p);
            currentBlue = (int) (c2b + (c3b - c2b) * p);
        } else {
            // 第三阶段：color3 → color4
            p = (wave - 1.0) * 2;
            currentRed = (int) (c3r + (c4r - c3r) * p);
            currentGreen = (int) (c3g + (c4g - c3g) * p);
            currentBlue = (int) (c3b + (c4b - c3b) * p);
        }

        return (currentRed << 16) | (currentGreen << 8) | currentBlue;
    }
}
