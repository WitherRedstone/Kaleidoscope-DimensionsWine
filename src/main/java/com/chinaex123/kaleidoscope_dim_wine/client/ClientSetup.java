package com.chinaex123.kaleidoscope_dim_wine.client;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.client.render.WingsRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 玩家渲染器的自定义图层
 */
@Mod.EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    /**
     * 注册渲染器图层：为所有玩家皮肤添加翅膀渲染层
     *
     * @param event 添加图层事件
     */
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.AddLayers event) {
        var minecraft = net.minecraft.client.Minecraft.getInstance();
        var dispatcher = minecraft.getEntityRenderDispatcher();

        for (var entry : dispatcher.getSkinMap().entrySet()) {
            PlayerRenderer renderer = (PlayerRenderer) entry.getValue();
            renderer.addLayer(new WingsRenderer(renderer));
        }
    }
}
