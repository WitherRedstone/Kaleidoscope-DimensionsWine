package com.chinaex123.kaleidoscope_dim_wine.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

/**
 * 翅膀渲染层：将翅膀作为玩家模型的附加层渲染
 */
public class WingsRenderer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public WingsRenderer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    /**
     * 渲染翅膀图层
     *
     * @param matrixStack 矩阵堆栈，用于变换
     * @param buffer 多重缓冲区，用于渲染
     * @param packedLight 打包的光照值
     * @param player 玩家实体
     * @param limbSwing 肢体摆动值
     * @param limbSwingAmount 肢体摆动幅度
     * @param partialTicks 部分刻，用于插值动画
     * @param ageInTicks 存在时间（刻）
     * @param netHeadYaw 头部偏航角
     * @param headPitch 头部俯仰角
     */
    @Override
    public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight,
                       AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        PlayerModel<AbstractClientPlayer> playerModel = this.getParentModel();

        if (!player.isAlive()) return;

        WingsRendererLogic.render(matrixStack, buffer, packedLight, player, playerModel);
    }
}
