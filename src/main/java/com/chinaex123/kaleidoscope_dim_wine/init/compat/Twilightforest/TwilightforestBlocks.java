package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.Crop.FrostheartFruit.FrostheartFruitBushBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TwilightforestBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTER =
            DeferredRegister.createBlocks(KaleidoscopeDimensionsWine.MOD_ID);

    // ==================== 次元维度 - 暮色森林 ====================
    // -------------------- 作物 --------------------
    // 霜心果丛 - 类似甜浆果种下后的方块
    public static final DeferredBlock<Block> FROSTHEART_FRUIT_BUSH = BLOCK_REGISTER.register("frostheart_fruit_bush", FrostheartFruitBushBlock::new);
    // -------------------- 流体 --------------------
    // -------------------- 酒类 --------------------

    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
