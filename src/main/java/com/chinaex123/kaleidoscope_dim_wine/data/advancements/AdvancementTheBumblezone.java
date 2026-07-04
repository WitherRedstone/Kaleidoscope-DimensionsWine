package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.util.TextUtils;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AdvancementTheBumblezone implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<Advancement> saver, @NotNull ExistingFileHelper existingFileHelper) {

        if (!ModList.get().isLoaded("the_bumblezone")) {
            return;
        }

        Advancement parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
        ResourceKey<Level> DIMTheBumblezone = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("the_bumblezone", "the_bumblezone"));

        // 根成就 → 进入蜜蜂领域
        Advancement EnterTheBumblezone = getAdvancement(parentRoot, Items.HONEYCOMB, "the_bumblezone_enter", FrameType.TASK, true, true, false)
                .addCriterion("has_the_bumblezone_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMTheBumblezone))
                .save(saver, getNameId("the_bumblezone_enter"));


        // 进入蜜蜂领域 → 糖水桶
        Advancement TheBumblezoneSugarWater = getAdvancement(EnterTheBumblezone, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_bucket")), "the_bumblezone_sugar_water_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_the_bumblezone_sugar_water_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_bucket"))))
                .addCriterion("has_the_bumblezone_honey_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_bucket"))))
                .addCriterion("has_the_bumblezone_royal_jelly_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "royal_jelly_bucket"))))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_bumblezone_sugar_water_bucket"));
        // 糖水桶 → 所有蜂蜜酒
        Advancement TheBumblezoneWine = getAdvancement(TheBumblezoneSugarWater, TheBumblezoneItems.SPRITE.get(), "the_bumblezone_wine", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_sprite", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.SPRITE.get()))
                .addCriterion("has_pepsi", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.PEPSI.get()))
                .addCriterion("has_fanta", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.FANTA.get()))
                .addCriterion("has_pollen_nectar", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.POLLEN_NECTAR.get()))
                .addCriterion("has_honeythorn_mead", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.HONEYTHORN_MEAD.get()))
                .addCriterion("has_beeswax_honey_wine", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.BEESWAX_HONEY_WINE.get()))
                .addCriterion("has_sweet_crystal_honey", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get()))
                .addCriterion("has_royal_honey_brew", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.ROYAL_HONEY_BREW.get()))
                .requirements(RequirementsStrategy.AND)
                .save(saver, getNameId("the_bumblezone_wine"));

        // 进入蜜蜂领域 → 凝碳粉
        Advancement TheBumblezoneCarbocretinPowder = getAdvancement(EnterTheBumblezone, TheBumblezoneItems.CARBOCRETIN_POWDER.get(), "the_bumblezone_carbocretin_powder", FrameType.TASK, true, true, false)
                .addCriterion("has_rangers_satchel", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.CARBOCRETIN_POWDER.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_bumblezone_carbocretin_powder"));

        // 进入蜜蜂领域 → 蜜酒精华
        Advancement TheBumblezoneMeadEssence = getAdvancement(EnterTheBumblezone, TheBumblezoneItems.MEAD_ESSENCE.get(), "the_bumblezone_mead_essence", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_raging_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_raging"))))
                .addCriterion("has_knowing_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_knowing"))))
                .addCriterion("has_calming_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_calming"))))
                .addCriterion("has_life_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_life"))))
                .addCriterion("has_radiance_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_radiance"))))
                .addCriterion("has_continuity_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_continuity"))))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.loot(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "advancements/mead_essence")))
                .save(saver, getNameId("the_bumblezone_mead_essence"));
    }

    protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(display,
                        TextUtils.getTranslation(name + ".title"),
                        TextUtils.getTranslation(name + ".desc"),
                        null,
                        frame, showToast, announceToChat, hidden);
    }

    private String getNameId(String id) {
        return KaleidoscopeDimensionsWine.MOD_ID + ":" + id;
    }
}
