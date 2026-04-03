package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.effect.ModEffects;
import com.chinaex123.kaleidoscope_dim_wine.event.DrinkBlockEntityTypeEventHandler;
import com.chinaex123.kaleidoscope_dim_wine.fluid.ModFluids;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
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
    }
}
