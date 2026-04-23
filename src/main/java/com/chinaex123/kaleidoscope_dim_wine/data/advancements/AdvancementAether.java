package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AdvancementAether implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<Advancement> saver, @NotNull ExistingFileHelper existingFileHelper) {

        if (!ModList.get().isLoaded("aether")) {
            return;
        }

        Advancement parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
        ResourceKey<Level> DIMAether = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("aether", "the_aether"));

        // 根成就 → 进入天境
        Advancement EnterAether = getAdvancement(parentRoot, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "aether_grass_block")), "aether_enter", FrameType.TASK, true, true, false)
                .addCriterion("has_aether_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMAether))
                .save(saver, getNameId("aether_enter"));


        // 进入天境 → 神饯蓝莓汁桶
        Advancement AetherJuice = getAdvancement(EnterAether, AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get(), "aether_enchanted_berry_juice_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_divine_offering_brew", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("aether_enchanted_berry_juice_bucket"));
        // 神饯蓝莓汁桶 → 所有天境酒
        Advancement AetherWine = getAdvancement(AetherJuice, AetherItems.DIVINE_OFFERING_BREW.get(), "aether_wine", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_divine_offering_brew", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.DIVINE_OFFERING_BREW.get()))
                .addCriterion("has_divine_energy_mist", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.DIVINE_ENERGY_MIST.get()))
                .addCriterion("has_swet_fizz", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.SWET_FIZZ.get()))
                .addCriterion("has_gravitite_drunk", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.GRAVITITE_DRUNK.get()))
                .addCriterion("has_healing_elixir", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.HEALING_ELIXIR.get()))
                .addCriterion("has_gingerbread_warmer", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.GINGERBREAD_WARMER.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(500).build())
                .save(saver, getNameId("aether_wine"));
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
