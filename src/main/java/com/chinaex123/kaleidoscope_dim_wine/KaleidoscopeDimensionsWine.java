package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.event.MaximizationEventHandler;
import com.chinaex123.kaleidoscope_dim_wine.init.*;
import com.chinaex123.kaleidoscope_dim_wine.block.entity.DrinkBlockEntityTypeEventHandler;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(KaleidoscopeDimensionsWine.MOD_ID)
public class KaleidoscopeDimensionsWine {
    public static final String MOD_ID = "kaleidoscope_dim_wine";
    public static final Logger LOGGER = LoggerFactory.getLogger(KaleidoscopeDimensionsWine.class);

    public KaleidoscopeDimensionsWine(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModFluids.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEffects.register(modEventBus);
        modEventBus.addListener(DrinkBlockEntityTypeEventHandler::onBlockEntityTypeAddBlocks);
        modContainer.registerConfig(Type.COMMON, ServerConfig.SPEC);

        NeoForge.EVENT_BUS.register(MaximizationEventHandler.class);
    }
}
