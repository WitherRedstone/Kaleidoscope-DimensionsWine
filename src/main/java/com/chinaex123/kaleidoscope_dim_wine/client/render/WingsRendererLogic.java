package com.chinaex123.kaleidoscope_dim_wine.client.render;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWEffects;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 翅膀渲染逻辑：处理翅膀扇动动画和渲染
 */
public class WingsRendererLogic {
    private static final double FLAP_FREQUENCY = 0.5; // 翅膀扇动频率（每秒周期数）
    private static final double MAX_ANGLE = 25.0; // 翅膀最大展开角度（度）
    private static final double CLOSED_ANGLE = -30.0; // 翅膀闭合角度（度），负值表示向内收

    // 存储每个玩家的当前翅膀角度
    private static final Map<Player, Double> playerAngles = new WeakHashMap<>();
    // 存储每个玩家上次飞行的时间戳
    private static final Map<Player, Long> playerLastFlyingTime = new WeakHashMap<>();
    // 存储每个玩家上一 tick 的 Y 坐标
    private static final Map<Player, Double> playerPrevY = new WeakHashMap<>();

    /**
     * 渲染翅膀
     */
    public static void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight,
                              AbstractClientPlayer player, PlayerModel<?> playerModel) {

        if (!player.isAlive()) return;

        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        if (level == null) return;

        // 检查玩家是否有翅膀效果
        if (!checkWingsBuff(player)) return;

        // 获取玩家当前的翅膀状态
        double currentAngle = playerAngles.getOrDefault(player, CLOSED_ANGLE);
        long lastFlyingTime = playerLastFlyingTime.getOrDefault(player, 0L);
        double prevY = playerPrevY.getOrDefault(player, player.getY());

        // 判断玩家是否在飞行或上升
        boolean isFlying = player.isFallFlying() || player.getAbilities().flying;
        boolean isGrounded = player.onGround();
        boolean isRising = (player.getY() - prevY) > 0.05;

        long now = System.currentTimeMillis();
        if (isFlying || isRising) {
            lastFlyingTime = now;
            playerLastFlyingTime.put(player, now);
        }

        // 判断是否应该展开翅膀（飞行中、最近飞行过、或在空中）
        boolean recentlyFlying = (now - lastFlyingTime) < 300;
        boolean shouldOpenWings = isFlying || recentlyFlying || (!isGrounded && !isFlying);

        // 计算目标角度：飞行时扇动，否则闭合
        double targetAngle = shouldOpenWings
                ? MAX_ANGLE * Math.sin(2 * Math.PI * FLAP_FREQUENCY * (now / 1000.0))
                : CLOSED_ANGLE;

        // 平滑过渡到目标角度
        currentAngle += (targetAngle - currentAngle) * 0.1;

        playerAngles.put(player, currentAngle);
        playerPrevY.put(player, player.getY());

        // 渲染左右两个翅膀
        for (int i = -1; i <= 1; i += 2) {
            double dir = i; // -1 为左翼，1 为右翼

            matrixStack.pushPose();
            // 将矩阵变换到玩家身体位置
            playerModel.body.translateAndRotate(matrixStack);

            // 设置翅膀相对于身体的位置
            matrixStack.translate(dir * -0.5, 0.1, 0.35);
            matrixStack.scale(0.9f, 0.9f, 0.9f);

            // 设置翅膀的基础旋转
            matrixStack.mulPose(new Quaternionf().rotateXYZ(
                    0f,
                    (float) ((Math.PI / 2.f) - dir * (Math.PI / 2.f - Math.PI / 6.f)),
                    (float) Math.PI
            ));

            matrixStack.translate(-0.5, 0, 0);
            // 应用翅膀扇动角度
            matrixStack.mulPose(new Quaternionf().rotateY((float) Math.toRadians(dir * currentAngle)));
            matrixStack.translate(0.5, 0, 0);

            // 渲染翅膀物品模型
            mc.getItemRenderer().render(
                    getWingItemStack(),
                    ItemDisplayContext.NONE,
                    false,
                    matrixStack,
                    buffer,
                    packedLight,
                    0,
                    getWingModel()
            );

            matrixStack.popPose();
        }
    }

    /**
     * 获取翅膀物品堆叠
     */
    private static ItemStack getWingItemStack() {
        return new ItemStack(KDWItems.ANGEL_WINGS.get());
    }

    /**
     * 获取翅膀物品的烘焙模型
     */
    private static BakedModel getWingModel() {
        Minecraft mc = Minecraft.getInstance();
        return mc.getItemRenderer().getModel(getWingItemStack(), mc.level, null, 0);
    }

    /**
     * 检查玩家是否有翅膀效果
     */
    public static boolean checkWingsBuff(Player player) {
        return player.hasEffect(KDWEffects.SKYBORN_GRACE) ||
                player.hasEffect(KDWEffects.UNBOUND_GRACE);
    }
}
