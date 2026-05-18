package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class DataMaps extends DataMapProvider {
    protected DataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    @SuppressWarnings({"deprecation", "removal"})
    protected void gather() {
        // 堆肥
        builder(NeoForgeDataMaps.COMPOSTABLES)
                // ==================== 次元维度 - 下界 ====================
                // -------------------- 作物 --------------------
                .add(KDWItems.CRIMSON_GRAPEVINE.get().builtInRegistryHolder(), new Compostable(0.3F), false) // 绯红葡萄藤 - 相当于作物的种子
                .add(KDWItems.CRIMSON_GRAPE.get().builtInRegistryHolder(), new Compostable(0.65F), false) // 绯红葡萄 - 结出的果实
                .add(KDWItems.WARPED_GRAPEVINE.get().builtInRegistryHolder(), new Compostable(0.3F), false) // 诡异葡萄藤 - 相当于作物的种子
                .add(KDWItems.WARPED_GRAPE.get().builtInRegistryHolder(), new Compostable(0.65F), false) // 诡异葡萄 - 结出的果实
                .add(KDWItems.CRIMSON_FUNGAL_SAP.get().builtInRegistryHolder(), new Compostable(0.25F), false) // 绯红菌露
                .add(KDWItems.WARPED_FUNGAL_SAP.get().builtInRegistryHolder(), new Compostable(0.25F), false) // 诡影菌髓
                // ==================== 次元维度 - 末地 ====================
                .add(KDWItems.DREAMFRUIT.get().builtInRegistryHolder(), new Compostable(0.65F), false); // 迷梦果

        // ==================== 次元维度 - 暮色森林 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            // 堆肥
            builder(NeoForgeDataMaps.COMPOSTABLES)
                    .add(TwilightforestItems.FROSTHEART_FRUIT.get().builtInRegistryHolder(), new Compostable(0.65F), false); // 霜心果
        }

        // 熔炉燃料
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(KDWItems.CRIMSON_GRAPEVINE.get().builtInRegistryHolder(), new FurnaceFuel(20), false) // 绯红葡萄藤 - 相当于作物的种子
                .add(KDWItems.WARPED_GRAPEVINE.get().builtInRegistryHolder(), new FurnaceFuel(20), false); // 诡异葡萄藤 - 相当于作物的种子
    }
}
