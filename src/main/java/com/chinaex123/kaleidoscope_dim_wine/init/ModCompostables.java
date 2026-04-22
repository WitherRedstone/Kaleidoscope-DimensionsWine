package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModCompostables {
    public static void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 注册堆肥
            ComposterBlock.COMPOSTABLES.put(ModItems.CRIMSON_GRAPEVINE.get(), 0.3F); // 绯红葡萄藤 - 相当于作物的种子
            ComposterBlock.COMPOSTABLES.put(ModItems.CRIMSON_GRAPE.get(), 0.65F); // 绯红葡萄 - 结出的果实
            ComposterBlock.COMPOSTABLES.put(ModItems.WARPED_GRAPEVINE.get(), 0.3F); // 诡异葡萄藤 - 相当于作物的种子
            ComposterBlock.COMPOSTABLES.put(ModItems.WARPED_GRAPE.get(), 0.65F); // 诡异葡萄 - 结出的果实
            ComposterBlock.COMPOSTABLES.put(ModItems.CRIMSON_FUNGAL_SAP.get(), 0.25F); // 绯红菌露
            ComposterBlock.COMPOSTABLES.put(ModItems.WARPED_FUNGAL_SAP.get(), 0.25F); // 诡影菌髓
            // ==================== 次元维度 - 末地 ====================
            ComposterBlock.COMPOSTABLES.put(ModItems.DREAMFRUIT.get(), 0.65F); // 迷梦果

            // ==================== 次元维度 - 暮色森林 ====================
            if (ModList.get().isLoaded("twilightforest")) {
                ComposterBlock.COMPOSTABLES.put(TwilightforestItems.FROSTHEART_FRUIT.get(), 0.65F); // 霜心果
            }
        });
    }
}
