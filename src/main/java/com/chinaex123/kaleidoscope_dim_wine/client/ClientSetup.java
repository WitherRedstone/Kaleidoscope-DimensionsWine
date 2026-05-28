package com.chinaex123.kaleidoscope_dim_wine.client;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.client.render.WingsRenderer;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = KaleidoscopeDimensionsWine.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = KaleidoscopeDimensionsWine.MOD_ID, value = Dist.CLIENT)
public class ClientSetup {

    public ClientSetup(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {}

    /**
     * 注册渲染器图层：为所有玩家皮肤添加翅膀渲染层
     *
     * @param event 添加图层事件
     */
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.AddLayers event) {
        var minecraft = Minecraft.getInstance();
        var dispatcher = minecraft.getEntityRenderDispatcher();

        for (var entry : dispatcher.getSkinMap().entrySet()) {
            PlayerRenderer renderer = (PlayerRenderer) entry.getValue();
            renderer.addLayer(new WingsRenderer(renderer));
        }
    }
}
