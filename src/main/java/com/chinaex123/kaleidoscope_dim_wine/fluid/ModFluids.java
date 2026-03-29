package com.chinaex123.kaleidoscope_dim_wine.fluid;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.fluid.JuiceFluidType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KaleidoscopeDimensionsWine.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- 流体ID --------------------
    // 绯红葡萄汁
    public static final ResourceLocation CRIMSON_GRAPE_JUICE_ID = KaleidoscopeDimensionsWine.id("crimson_grape_juice");
    public static final ResourceLocation FLOWING_CRIMSON_GRAPE_JUICE_ID = KaleidoscopeDimensionsWine.id("flowing_crimson_grape_juice");
    // 诡异葡萄汁
    public static final ResourceLocation WARPED_GRAPE_JUICE_ID = KaleidoscopeDimensionsWine.id("warped_grape_juice");
    public static final ResourceLocation FLOWING_WARPED_GRAPE_JUICE_ID = KaleidoscopeDimensionsWine.id("flowing_warped_grape_juice");

    // -------------------- 流体属性 --------------------
    // 绯红葡萄汁
    public static final Supplier<FluidType> CRIMSON_GRAPE_JUICE_TYPE =
            FLUID_TYPES.register("crimson_grape_juice", () -> new JuiceFluidType(CRIMSON_GRAPE_JUICE_ID, 0));
    // 诡异葡萄汁
    public static final Supplier<FluidType> WARPED_GRAPE_JUICE_TYPE =
            FLUID_TYPES.register("warped_grape_juice", () -> new JuiceFluidType(WARPED_GRAPE_JUICE_ID, 0));

    // -------------------- 流体 Properties --------------------
    public static BaseFlowingFluid.Properties CRIMSON_GRAPE_JUICE_PROPERTIES; // 绯红葡萄汁
    public static BaseFlowingFluid.Properties WARPED_GRAPE_JUICE_PROPERTIES; // 诡异葡萄汁

    // -------------------- 流体 --------------------
    // 绯红葡萄汁
    public static final Supplier<BaseFlowingFluid.Source> CRIMSON_GRAPE_JUICE =
            FLUIDS.register("crimson_grape_juice", () -> new BaseFlowingFluid.Source(ModFluids.CRIMSON_GRAPE_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_CRIMSON_GRAPE_JUICE =
            FLUIDS.register("flowing_crimson_grape_juice", () -> new BaseFlowingFluid.Flowing(ModFluids.CRIMSON_GRAPE_JUICE_PROPERTIES));
    // 诡异葡萄汁
    public static final Supplier<BaseFlowingFluid.Source> WARPED_GRAPE_JUICE =
            FLUIDS.register("warped_grape_juice", () -> new BaseFlowingFluid.Source(ModFluids.WARPED_GRAPE_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_WARPED_GRAPE_JUICE =
            FLUIDS.register("flowing_warped_grape_juice", () -> new BaseFlowingFluid.Flowing(ModFluids.WARPED_GRAPE_JUICE_PROPERTIES));

    static {
        // 绯红葡萄汁
        CRIMSON_GRAPE_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                CRIMSON_GRAPE_JUICE_TYPE,
                CRIMSON_GRAPE_JUICE,
                FLOWING_CRIMSON_GRAPE_JUICE
        ).bucket(ModItems.CRIMSON_GRAPE_JUICE_BUCKET);

        // 诡异葡萄汁
        WARPED_GRAPE_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                WARPED_GRAPE_JUICE_TYPE,
                WARPED_GRAPE_JUICE,
                FLOWING_WARPED_GRAPE_JUICE
        ).bucket(ModItems.WARPED_GRAPE_JUICE_BUCKET);
    }
}
