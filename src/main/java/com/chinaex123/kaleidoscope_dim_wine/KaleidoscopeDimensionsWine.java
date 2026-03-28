package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.event.DrinkBlockEntityTypeEventHandler;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(KaleidoscopeDimensionsWine.MOD_ID)
public class KaleidoscopeDimensionsWine {
    public static final String MOD_ID = "kaleidoscope_dim_wine";

    public KaleidoscopeDimensionsWine(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        //ModBlockEntities.register(modEventBus);

        modEventBus.addListener(DrinkBlockEntityTypeEventHandler::onBlockEntityTypeAddBlocks);
    }
}
