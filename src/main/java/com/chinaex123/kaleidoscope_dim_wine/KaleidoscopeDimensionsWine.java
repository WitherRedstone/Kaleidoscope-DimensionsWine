package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.*;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModRecipes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(KaleidoscopeDimensionsWine.MOD_ID)
public class KaleidoscopeDimensionsWine {
    public static final String MOD_ID = "kaleidoscope_dim_wine";
    public static final Logger LOGGER = LoggerFactory.getLogger(KaleidoscopeDimensionsWine.class);

    public KaleidoscopeDimensionsWine(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        ModEffects.register(modEventBus);

        ModCreativeTabs.register(modEventBus);
        context.registerConfig(ModConfig.Type.COMMON, ServerConfig.SPEC);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        modEventBus.addListener(this::onCommonSetup);

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            TwilightforestBlocks.register(modEventBus);
            TwilightforestItems.register(modEventBus);
        }

        // ==================== 次元维度 - 蜜蜂领域 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            TheBumblezoneBlocks.register(modEventBus);
            TheBumblezoneItems.register(modEventBus);
        }

        // ==================== 次元维度 - 天境 ====================
        if (ModList.get().isLoaded("aether")) {
            AetherBlocks.register(modEventBus);
            AetherItems.register(modEventBus);
        }
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        ModCompostables.setup(event);
    }
}
