package com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluidTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.FLUIDS;
import static net.minecraftforge.registries.ForgeRegistries.Keys.FLUID_TYPES;

/**
 * 暮色联动 - 流体注册
 */
public class TwilightforestFluids {
    // -------------------- 流体 ID --------------------
    // 火炬浆果汁
    public static final ResourceLocation TORCHBERRIES_JUICE_ID = modLoc("torchberries_juice");
    public static final ResourceLocation FLOWING_TORCHBERRIES_JUICE_ID = modLoc("flowing_torchberries_juice");
    // 霜心果汁
    public static final ResourceLocation FROSTHEART_FRUIT_JUICE_ID = modLoc("frostheart_fruit_juice");
    public static final ResourceLocation FLOWING_FROSTHEART_FRUIT_JUICE_ID = modLoc("flowing_frostheart_fruit_juice");

    // -------------------- FluidType --------------------
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> TORCHBERRIES_JUICE_TYPE = RegistryObject.create(TORCHBERRIES_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> FROSTHEART_FRUIT_JUICE_TYPE = RegistryObject.create(FROSTHEART_FRUIT_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- Fluid --------------------
    public static final RegistryObject<Fluid> TORCHBERRIES_JUICE = RegistryObject.create(TORCHBERRIES_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_TORCHBERRIES_JUICE = RegistryObject.create(FLOWING_TORCHBERRIES_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FROSTHEART_FRUIT_JUICE = RegistryObject.create(FROSTHEART_FRUIT_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_FROSTHEART_FRUIT_JUICE = RegistryObject.create(FLOWING_FROSTHEART_FRUIT_JUICE_ID, FLUIDS);

    @SubscribeEvent
    public static void registerFluids(RegisterEvent event) {
        event.register(FLUID_TYPES, helper -> {
            // 火炬浆果汁
            helper.register(TORCHBERRIES_JUICE_ID, new KDWFluidTypes(TORCHBERRIES_JUICE_ID, 0, 6, false, false));
            // 霜心果汁
            helper.register(FROSTHEART_FRUIT_JUICE_ID, new KDWFluidTypes(FROSTHEART_FRUIT_JUICE_ID, 0, 0, false, false));
        });
        event.register(ForgeRegistries.Keys.FLUIDS, helper -> {
            Properties torchberriesJuice = new Properties(TORCHBERRIES_JUICE_TYPE, TORCHBERRIES_JUICE, FLOWING_TORCHBERRIES_JUICE)
                    .bucket(TwilightforestItems.TORCHBERRIES_JUICE_BUCKET);

            Properties frostheartFruitJuice = new Properties(FROSTHEART_FRUIT_JUICE_TYPE, FROSTHEART_FRUIT_JUICE, FLOWING_FROSTHEART_FRUIT_JUICE)
                    .bucket(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET);

            helper.register(TORCHBERRIES_JUICE.getId(), new Source(torchberriesJuice));
            helper.register(FLOWING_TORCHBERRIES_JUICE.getId(), new Flowing(torchberriesJuice));

            helper.register(FROSTHEART_FRUIT_JUICE.getId(), new Source(frostheartFruitJuice));
            helper.register(FLOWING_FROSTHEART_FRUIT_JUICE.getId(), new Flowing(frostheartFruitJuice));
        });
    }

    public static ResourceLocation modLoc(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }

    public static void register(IEventBus eventBus) {
        eventBus.addListener(TwilightforestFluids::registerFluids);
    }
}
