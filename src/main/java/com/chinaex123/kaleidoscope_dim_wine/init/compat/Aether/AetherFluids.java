package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFluidTypes;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

/**
 * 暮色森林联动 - 流体注册
 */
public class AetherFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KaleidoscopeDimensionsWine.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, KaleidoscopeDimensionsWine.MOD_ID);

    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }

    // ==================== 流体ID ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 神饯蓝莓汁
    public static final ResourceLocation ENCHANTED_BERRY_JUICE_ID = AetherFluids.id("enchanted_berry_juice");
    public static final ResourceLocation FLOWING_ENCHANTED_BERRY_JUICE_ID = AetherFluids.id("flowing_enchanted_berry_juice");


    // ==================== 流体属性 ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 神饯蓝莓汁
    public static final Supplier<FluidType> ENCHANTED_BERRY_JUICE_TYPE =
            FLUID_TYPES.register("enchanted_berry_juice", () -> new ModFluidTypes(ENCHANTED_BERRY_JUICE_ID, 0, 6, false, false));


    // ==================== 流体 属性 ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    public static BaseFlowingFluid.Properties ENCHANTED_BERRY_JUICE_PROPERTIES; // 神饯蓝莓汁


    // ==================== 流体 物理和行为====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 神饯蓝莓汁
    public static final Supplier<BaseFlowingFluid.Source> ENCHANTED_BERRY_JUICE =
            FLUIDS.register("enchanted_berry_juice", () -> new BaseFlowingFluid.Source(AetherFluids.ENCHANTED_BERRY_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_ENCHANTED_BERRY_JUICE =
            FLUIDS.register("flowing_enchanted_berry_juice", () -> new BaseFlowingFluid.Flowing(AetherFluids.ENCHANTED_BERRY_JUICE_PROPERTIES));

    static {
        // -------------------- 次元维度 - 暮色森林 --------------------
        // 神饯蓝莓汁
        ENCHANTED_BERRY_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                ENCHANTED_BERRY_JUICE_TYPE,
                ENCHANTED_BERRY_JUICE,
                FLOWING_ENCHANTED_BERRY_JUICE
        ).bucket(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET);
    }
}
