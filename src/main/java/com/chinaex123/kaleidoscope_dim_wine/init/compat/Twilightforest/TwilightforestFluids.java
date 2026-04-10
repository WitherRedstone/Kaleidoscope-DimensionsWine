package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFluidTypes;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFluids;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class TwilightforestFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KaleidoscopeDimensionsWine.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, KaleidoscopeDimensionsWine.MOD_ID);

    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }

    // ==================== 流体ID ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 火炬浆果汁
    public static final ResourceLocation TORCHBERRIES_JUICE_ID = TwilightforestFluids.id("torchberries_juice");
    public static final ResourceLocation FLOWING_TORCHBERRIES_JUICE_ID = TwilightforestFluids.id("flowing_torchberries_juice");
    // 霜心果汁
    public static final ResourceLocation FROSTHEART_FRUIT_JUICE_ID = TwilightforestFluids.id("frostheart_fruit_juice");
    public static final ResourceLocation FLOWING_FROSTHEART_FRUIT_JUICE_ID = TwilightforestFluids.id("flowing_frostheart_fruit_juice");


    // ==================== 流体属性 ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 火炬浆果汁
    public static final Supplier<FluidType> TORCHBERRIES_JUICE_TYPE =
            FLUID_TYPES.register("torchberries_juice", () -> new ModFluidTypes(TORCHBERRIES_JUICE_ID, 0, 6, false, false));
    // 霜心果汁
    public static final Supplier<FluidType> FROSTHEART_FRUIT_JUICE_TYPE =
            FLUID_TYPES.register("frostheart_fruit_juice", () -> new ModFluidTypes(FROSTHEART_FRUIT_JUICE_ID, 0, 0, false, false));


    // ==================== 流体 属性 ====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    public static BaseFlowingFluid.Properties TORCHBERRIES_JUICE_PROPERTIES; // 火炬浆果汁
    public static BaseFlowingFluid.Properties FROSTHEART_FRUIT_JUICE_PROPERTIES; // 霜心果汁


    // ==================== 流体 物理和行为====================
    // -------------------- 次元维度 - 暮色森林 --------------------
    // 火炬浆果汁
    public static final Supplier<BaseFlowingFluid.Source> TORCHBERRIES_JUICE =
            FLUIDS.register("torchberries_juice", () -> new BaseFlowingFluid.Source(TwilightforestFluids.TORCHBERRIES_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_TORCHBERRIES_JUICE =
            FLUIDS.register("flowing_torchberries_juice", () -> new BaseFlowingFluid.Flowing(TwilightforestFluids.TORCHBERRIES_JUICE_PROPERTIES));
    // 霜心果汁
    public static final Supplier<BaseFlowingFluid.Source> FROSTHEART_FRUIT_JUICE =
            FLUIDS.register("frostheart_fruit_juice", () -> new BaseFlowingFluid.Source(TwilightforestFluids.FROSTHEART_FRUIT_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_FROSTHEART_FRUIT_JUICE =
            FLUIDS.register("flowing_frostheart_fruit_juice", () -> new BaseFlowingFluid.Flowing(TwilightforestFluids.FROSTHEART_FRUIT_JUICE_PROPERTIES));

    static {
        // -------------------- 次元维度 - 暮色森林 --------------------
        // 火炬浆果汁
        TORCHBERRIES_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                TORCHBERRIES_JUICE_TYPE,
                TORCHBERRIES_JUICE,
                FLOWING_TORCHBERRIES_JUICE
        ).bucket(TwilightforestItems.TORCHBERRIES_JUICE_BUCKET);
        // 霜心果汁
        FROSTHEART_FRUIT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                FROSTHEART_FRUIT_JUICE_TYPE,
                FROSTHEART_FRUIT_JUICE,
                FLOWING_FROSTHEART_FRUIT_JUICE
        ).bucket(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET);
    }
}
