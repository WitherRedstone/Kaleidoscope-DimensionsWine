package com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFluidTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

/**
 * 永恒星光联动 - 流体注册
 */
public class EternalStarlightFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KaleidoscopeDimensionsWine.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, KaleidoscopeDimensionsWine.MOD_ID);
    
    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }

    // ==================== 流体ID ====================
    // -------------------- 次元维度 - 永恒星光 --------------------
    // 月辉浆果汁
    public static final ResourceLocation LUNAR_BERRIES_JUICE_ID = EternalStarlightFluids.id("lunar_berries_juice");
    public static final ResourceLocation FLOWING_LUNAR_BERRIES_JUICE_ID = EternalStarlightFluids.id("flowing_lunar_berries_juice");
    // 渊海果汁
    public static final ResourceLocation ABYSSAL_FRUIT_JUICE_ID = EternalStarlightFluids.id("abyssal_fruit_juice");
    public static final ResourceLocation FLOWING_ABYSSAL_FRUIT_JUICE_ID = EternalStarlightFluids.id("flowing_abyssal_fruit_juice");
    // 银辛果汁
    public static final ResourceLocation SILVER_PUNGENCY_FRUIT_JUICE_ID = EternalStarlightFluids.id("silver_pungency_fruit_juice");
    public static final ResourceLocation FLOWING_SILVER_PUNGENCY_FRUIT_JUICE_ID = EternalStarlightFluids.id("flowing_silver_pungency_fruit_juice");


    // ==================== 流体属性 ====================
    // -------------------- 次元维度 - 永恒星光 --------------------
    // 月辉浆果汁
    public static final Supplier<FluidType> LUNAR_BERRIES_JUICE_TYPE =
            FLUID_TYPES.register("lunar_berries_juice", () -> new ModFluidTypes(LUNAR_BERRIES_JUICE_ID, 0, 0, false, false));
    // 渊海果汁
    public static final Supplier<FluidType> ABYSSAL_FRUIT_JUICE_TYPE =
            FLUID_TYPES.register("abyssal_fruit_juice", () -> new ModFluidTypes(ABYSSAL_FRUIT_JUICE_ID, 0, 0, false, false));
    // 银辛果汁
    public static final Supplier<FluidType> SILVER_PUNGENCY_FRUIT_JUICE_TYPE =
            FLUID_TYPES.register("silver_pungency_fruit_juice", () -> new ModFluidTypes(SILVER_PUNGENCY_FRUIT_JUICE_ID, 0, 0, false, false));


    // ==================== 流体 属性 ====================
    // -------------------- 次元维度 - 永恒星光 --------------------
    public static BaseFlowingFluid.Properties LUNAR_BERRIES_JUICE_PROPERTIES; // 月辉浆果汁
    public static BaseFlowingFluid.Properties ABYSSAL_FRUIT_JUICE_PROPERTIES; // 渊海果汁
    public static BaseFlowingFluid.Properties SILVER_PUNGENCY_FRUIT_JUICE_PROPERTIES; // 银辛果汁


    // ==================== 流体 物理和行为====================
    // -------------------- 次元维度 - 永恒星光 --------------------
    // 月辉浆果汁
    public static final Supplier<BaseFlowingFluid.Source> LUNAR_BERRIES_JUICE =
            FLUIDS.register("lunar_berries_juice", () -> new BaseFlowingFluid.Source(EternalStarlightFluids.LUNAR_BERRIES_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_LUNAR_BERRIES_JUICE =
            FLUIDS.register("flowing_lunar_berries_juice", () -> new BaseFlowingFluid.Flowing(EternalStarlightFluids.LUNAR_BERRIES_JUICE_PROPERTIES));
    // 渊海果汁
    public static final Supplier<BaseFlowingFluid.Source> ABYSSAL_FRUIT_JUICE =
            FLUIDS.register("abyssal_fruit_juice", () -> new BaseFlowingFluid.Source(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_ABYSSAL_FRUIT_JUICE =
            FLUIDS.register("flowing_abyssal_fruit_juice", () -> new BaseFlowingFluid.Flowing(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE_PROPERTIES));
    // 银辛果汁
    public static final Supplier<BaseFlowingFluid.Source> SILVER_PUNGENCY_FRUIT_JUICE =
            FLUIDS.register("silver_pungency_fruit_juice", () -> new BaseFlowingFluid.Source(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_SILVER_PUNGENCY_FRUIT_JUICE =
            FLUIDS.register("flowing_silver_pungency_fruit_juice", () -> new BaseFlowingFluid.Flowing(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE_PROPERTIES));

    static {
        // -------------------- 次元维度 - 永恒星光 --------------------
        // 月辉浆果汁
        LUNAR_BERRIES_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                LUNAR_BERRIES_JUICE_TYPE,
                LUNAR_BERRIES_JUICE,
                FLOWING_LUNAR_BERRIES_JUICE
        ).bucket(EternalStarlightItems.LUNAR_BERRIES_JUICE_BUCKET);
        // 渊海果汁
        ABYSSAL_FRUIT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                ABYSSAL_FRUIT_JUICE_TYPE,
                ABYSSAL_FRUIT_JUICE,
                FLOWING_ABYSSAL_FRUIT_JUICE
        ).bucket(EternalStarlightItems.ABYSSAL_FRUIT_JUICE_BUCKET);
        // 银辛果汁
        SILVER_PUNGENCY_FRUIT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                SILVER_PUNGENCY_FRUIT_JUICE_TYPE,
                SILVER_PUNGENCY_FRUIT_JUICE,
                FLOWING_SILVER_PUNGENCY_FRUIT_JUICE
        ).bucket(EternalStarlightItems.SILVER_PUNGENCY_FRUIT_JUICE_BUCKET);
    }
}
