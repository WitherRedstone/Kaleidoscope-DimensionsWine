package com.chinaex123.kaleidoscope_dim_wine.fluid;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
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

    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }

    // -------------------- 流体ID --------------------
    // 绯红葡萄汁
    public static final ResourceLocation CRIMSON_GRAPE_JUICE_ID = ModFluids.id("crimson_grape_juice");
    public static final ResourceLocation FLOWING_CRIMSON_GRAPE_JUICE_ID = ModFluids.id("flowing_crimson_grape_juice");
    // 诡异葡萄汁
    public static final ResourceLocation WARPED_GRAPE_JUICE_ID = ModFluids.id("warped_grape_juice");
    public static final ResourceLocation FLOWING_WARPED_GRAPE_JUICE_ID = ModFluids.id("flowing_warped_grape_juice");
    // 迷梦果汁
    public static final ResourceLocation DREAMFRUIT_JUICE_ID = ModFluids.id("dreamfruit_juice");
    public static final ResourceLocation FLOWING_DREAMFRUIT_JUICE_ID = ModFluids.id("flowing_dreamfruit_juice");
    // 龙血
    public static final ResourceLocation DRAGON_BLOOD_ID = ModFluids.id("dragon_blood");
    public static final ResourceLocation FLOWING_DRAGON_BLOOD_ID = ModFluids.id("flowing_dragon_blood");

    // -------------------- 流体属性 --------------------
    // 参数：流体 ID，掉落伤害，光亮等级，滋润耕地，无限生成
    // 绯红葡萄汁
    public static final Supplier<FluidType> CRIMSON_GRAPE_JUICE_TYPE =
            FLUID_TYPES.register("crimson_grape_juice", () -> new ModFluidTypes(CRIMSON_GRAPE_JUICE_ID, 0, 0, true, false));
    // 诡异葡萄汁
    public static final Supplier<FluidType> WARPED_GRAPE_JUICE_TYPE =
            FLUID_TYPES.register("warped_grape_juice", () -> new ModFluidTypes(WARPED_GRAPE_JUICE_ID, 0, 0, true, false));
    // 迷梦果汁
    public static final Supplier<FluidType> DREAMFRUIT_JUICE_TYPE =
            FLUID_TYPES.register("dreamfruit_juice", () -> new ModFluidTypes(DREAMFRUIT_JUICE_ID, 0, 3, true, false));
    // 龙血
    public static final Supplier<FluidType> DRAGON_BLOOD_TYPE =
            FLUID_TYPES.register("dragon_blood", () -> new ModFluidTypes(DRAGON_BLOOD_ID, 0, 6, false, false));

    // -------------------- 流体 Properties --------------------
    public static BaseFlowingFluid.Properties CRIMSON_GRAPE_JUICE_PROPERTIES; // 绯红葡萄汁
    public static BaseFlowingFluid.Properties WARPED_GRAPE_JUICE_PROPERTIES; // 诡异葡萄汁
    public static BaseFlowingFluid.Properties DREAMFRUIT_JUICE_PROPERTIES; // 迷梦果汁
    public static BaseFlowingFluid.Properties DRAGON_BLOOD_PROPERTIES; // 龙血

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
    // 迷梦果汁
    public static final Supplier<BaseFlowingFluid.Source> DREAMFRUIT_JUICE =
            FLUIDS.register("dreamfruit_juice", () -> new BaseFlowingFluid.Source(ModFluids.DREAMFRUIT_JUICE_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_DREAMFRUIT_JUICE =
            FLUIDS.register("flowing_dreamfruit_juice", () -> new BaseFlowingFluid.Flowing(ModFluids.DREAMFRUIT_JUICE_PROPERTIES));
    // 龙血
    public static final Supplier<BaseFlowingFluid.Source> DRAGON_BLOOD =
            FLUIDS.register("dragon_blood", () -> new BaseFlowingFluid.Source(ModFluids.DRAGON_BLOOD_PROPERTIES));
    public static final Supplier<BaseFlowingFluid.Flowing> FLOWING_DRAGON_BLOOD =
            FLUIDS.register("flowing_dragon_blood", () -> new BaseFlowingFluid.Flowing(ModFluids.DRAGON_BLOOD_PROPERTIES));

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
        // 迷梦果汁
        DREAMFRUIT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
                DREAMFRUIT_JUICE_TYPE,
                DREAMFRUIT_JUICE,
                FLOWING_DREAMFRUIT_JUICE
        ).bucket(ModItems.DREAMFRUIT_JUICE_BUCKET);
        // 龙血
        DRAGON_BLOOD_PROPERTIES = new BaseFlowingFluid.Properties(
                DRAGON_BLOOD_TYPE,
                DRAGON_BLOOD,
                FLOWING_DRAGON_BLOOD
        ).bucket(ModItems.DRAGON_BLOOD_BUCKET)
                .block(ModBlocks.DRAGON_BLOOD_FLUID)
                .explosionResistance(100.0F) // 抗爆性
                .slopeFindDistance(4) // 流动查找距离
                .levelDecreasePerBlock(1) // 液面下降等级
                .tickRate(10); // 流动速度
    }
}
