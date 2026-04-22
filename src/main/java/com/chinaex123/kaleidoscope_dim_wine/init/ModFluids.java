package com.chinaex123.kaleidoscope_dim_wine.init;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.FLUIDS;
import static net.minecraftforge.registries.ForgeRegistries.Keys.FLUID_TYPES;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFluids {
    // -------------------- 流体 ID --------------------
    // 绯红葡萄汁
    public static final ResourceLocation CRIMSON_GRAPE_JUICE_ID = modLoc("crimson_grape_juice");
    public static final ResourceLocation FLOWING_CRIMSON_GRAPE_JUICE_ID = modLoc("flowing_crimson_grape_juice");
    // 诡异葡萄汁
    public static final ResourceLocation WARPED_GRAPE_JUICE_ID = modLoc("warped_grape_juice");
    public static final ResourceLocation FLOWING_WARPED_GRAPE_JUICE_ID = modLoc("flowing_warped_grape_juice");
    // 迷梦果汁
    public static final ResourceLocation DREAMFRUIT_JUICE_ID = modLoc("dreamfruit_juice");
    public static final ResourceLocation FLOWING_DREAMFRUIT_JUICE_ID = modLoc("flowing_dreamfruit_juice");
    // 龙血
    public static final ResourceLocation DRAGON_BLOOD_ID = modLoc("dragon_blood");
    public static final ResourceLocation FLOWING_DRAGON_BLOOD_ID = modLoc("flowing_dragon_blood");

    // -------------------- FluidType --------------------
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> CRIMSON_GRAPE_JUICE_TYPE = RegistryObject.create(CRIMSON_GRAPE_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> WARPED_GRAPE_JUICE_TYPE = RegistryObject.create(WARPED_GRAPE_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> DREAMFRUIT_JUICE_TYPE = RegistryObject.create(DREAMFRUIT_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> DRAGON_BLOOD_TYPE = RegistryObject.create(DRAGON_BLOOD_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- Fluid --------------------
    public static final RegistryObject<Fluid> CRIMSON_GRAPE_JUICE = RegistryObject.create(CRIMSON_GRAPE_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_CRIMSON_GRAPE_JUICE = RegistryObject.create(FLOWING_CRIMSON_GRAPE_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> WARPED_GRAPE_JUICE = RegistryObject.create(WARPED_GRAPE_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_WARPED_GRAPE_JUICE = RegistryObject.create(FLOWING_WARPED_GRAPE_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> DREAMFRUIT_JUICE = RegistryObject.create(DREAMFRUIT_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_DREAMFRUIT_JUICE = RegistryObject.create(FLOWING_DREAMFRUIT_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> DRAGON_BLOOD = RegistryObject.create(DRAGON_BLOOD_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_DRAGON_BLOOD = RegistryObject.create(FLOWING_DRAGON_BLOOD_ID, FLUIDS);

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(FLUID_TYPES, helper -> {
            // 绯红葡萄汁
            helper.register(CRIMSON_GRAPE_JUICE_ID, new ModFluidTypes(CRIMSON_GRAPE_JUICE_ID, 0, 0, true, false));
            // 诡异葡萄汁
            helper.register(WARPED_GRAPE_JUICE_ID, new ModFluidTypes(WARPED_GRAPE_JUICE_ID, 0, 0, true, false));
            // 迷梦果汁
            helper.register(DREAMFRUIT_JUICE_ID, new ModFluidTypes(DREAMFRUIT_JUICE_ID, 0, 3, true, false));
            // 龙血
            helper.register(DRAGON_BLOOD_ID, new ModFluidTypes(DRAGON_BLOOD_ID, 0, 6, false, false));
        });
        event.register(ForgeRegistries.Keys.FLUIDS, helper -> {
            Properties crimsonGrapeJuice = new Properties(CRIMSON_GRAPE_JUICE_TYPE, CRIMSON_GRAPE_JUICE, FLOWING_CRIMSON_GRAPE_JUICE)
                    .bucket(ModItems.CRIMSON_GRAPE_JUICE_BUCKET);

            Properties warpedGrapeJuice = new Properties(WARPED_GRAPE_JUICE_TYPE, WARPED_GRAPE_JUICE, FLOWING_WARPED_GRAPE_JUICE)
                    .bucket(ModItems.WARPED_GRAPE_JUICE_BUCKET);

            Properties dreamfruitJuice = new Properties(DREAMFRUIT_JUICE_TYPE, DREAMFRUIT_JUICE, FLOWING_DREAMFRUIT_JUICE)
                    .bucket(ModItems.DREAMFRUIT_JUICE_BUCKET);

            Properties dragonBlood = new Properties(DRAGON_BLOOD_TYPE, DRAGON_BLOOD, FLOWING_DRAGON_BLOOD)
                    .bucket(ModItems.DRAGON_BLOOD_BUCKET)
                    .block(ModBlocks.DRAGON_BLOOD_FLUID)
                    .explosionResistance(100.0F) // 抗爆性
                    .slopeFindDistance(4) // 流动查找距离
                    .levelDecreasePerBlock(1) // 液面下降等级
                    .tickRate(10); // 流动速度

            helper.register(CRIMSON_GRAPE_JUICE.getId(), new Source(crimsonGrapeJuice));
            helper.register(FLOWING_CRIMSON_GRAPE_JUICE.getId(), new Flowing(crimsonGrapeJuice));

            helper.register(WARPED_GRAPE_JUICE.getId(), new Source(warpedGrapeJuice));
            helper.register(FLOWING_WARPED_GRAPE_JUICE.getId(), new Flowing(warpedGrapeJuice));

            helper.register(DREAMFRUIT_JUICE.getId(), new Source(dreamfruitJuice));
            helper.register(FLOWING_DREAMFRUIT_JUICE.getId(), new Flowing(dreamfruitJuice));

            helper.register(DRAGON_BLOOD.getId(), new Source(dragonBlood));
            helper.register(FLOWING_DRAGON_BLOOD.getId(), new Flowing(dragonBlood));
        });
    }

    public static ResourceLocation modLoc(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }
}
