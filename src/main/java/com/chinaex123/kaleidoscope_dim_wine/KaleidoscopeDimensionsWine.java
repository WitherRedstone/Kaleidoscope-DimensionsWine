package com.chinaex123.kaleidoscope_dim_wine;

import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.data.recipe.ModRecipes;
import com.chinaex123.kaleidoscope_dim_wine.event.EffectAttributeRemoveHandler;
import com.chinaex123.kaleidoscope_dim_wine.init.*;
import com.chinaex123.kaleidoscope_dim_wine.block.entity.DrinkBlockEntityTypeEventHandler;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.neoforged.fml.ModList;
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
        modEventBus.addListener(DrinkBlockEntityTypeEventHandler::onBlockEntityTypeAddBlocks);

        ModEffects.register(modEventBus);
        NeoForge.EVENT_BUS.register(EffectAttributeRemoveHandler.class);

        ModCreativeTabs.register(modEventBus);
        modContainer.registerConfig(Type.COMMON, ServerConfig.SPEC);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            TwilightforestBlocks.register(modEventBus);
            TwilightforestItems.register(modEventBus);
            TwilightforestFluids.FLUID_TYPES.register(modEventBus);
            TwilightforestFluids.FLUIDS.register(modEventBus);
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
            AetherFluids.FLUID_TYPES.register(modEventBus);
            AetherFluids.FLUIDS.register(modEventBus);
        }

        // ==================== 次元维度 - 永恒星光 ====================
        if (ModList.get().isLoaded("eternal_starlight")) {
            EternalStarlightBlocks.register(modEventBus);
            EternalStarlightItems.register(modEventBus);
            EternalStarlightFluids.FLUID_TYPES.register(modEventBus);
            EternalStarlightFluids.FLUIDS.register(modEventBus);
        }
    }
}
