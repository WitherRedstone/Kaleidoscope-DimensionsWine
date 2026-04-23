package com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModFluidTypes;
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

/**
 * 天境联动 - 流体注册
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AetherFluids {
    // -------------------- 流体 ID --------------------
    // 神饯蓝莓汁
    public static final ResourceLocation ENCHANTED_BERRY_JUICE_ID = modLoc("enchanted_berry_juice");
    public static final ResourceLocation FLOWING_ENCHANTED_BERRY_JUICE_ID = modLoc("flowing_enchanted_berry_juice");

    // -------------------- FluidType --------------------
    public static final RegistryObject<net.minecraftforge.fluids.FluidType> ENCHANTED_BERRY_JUICE_TYPE = RegistryObject.create(ENCHANTED_BERRY_JUICE_ID, FLUID_TYPES.location(), KaleidoscopeDimensionsWine.MOD_ID);

    // -------------------- Fluid --------------------
    public static final RegistryObject<Fluid> ENCHANTED_BERRY_JUICE = RegistryObject.create(ENCHANTED_BERRY_JUICE_ID, FLUIDS);
    public static final RegistryObject<Fluid> FLOWING_ENCHANTED_BERRY_JUICE = RegistryObject.create(FLOWING_ENCHANTED_BERRY_JUICE_ID, FLUIDS);

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(FLUID_TYPES, helper -> {
            // 神饯蓝莓汁
            helper.register(ENCHANTED_BERRY_JUICE_ID, new ModFluidTypes(ENCHANTED_BERRY_JUICE_ID, 0, 6, false, false));
        });
        event.register(ForgeRegistries.Keys.FLUIDS, helper -> {
            Properties enchantedBerryJuice = new Properties(ENCHANTED_BERRY_JUICE_TYPE, ENCHANTED_BERRY_JUICE, FLOWING_ENCHANTED_BERRY_JUICE)
                    .bucket(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET);

            helper.register(ENCHANTED_BERRY_JUICE.getId(), new Source(enchantedBerryJuice));
            helper.register(FLOWING_ENCHANTED_BERRY_JUICE.getId(), new Flowing(enchantedBerryJuice));
        });
    }

    public static ResourceLocation modLoc(String name) {
        return ResourceLocation.tryBuild(KaleidoscopeDimensionsWine.MOD_ID, name);
    }
}
