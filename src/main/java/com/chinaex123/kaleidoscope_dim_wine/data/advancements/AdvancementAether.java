package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.util.TextUtils;
import net.minecraft.advancements.*;
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
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * 天境联动相关成就
 */
public class AdvancementAether implements AdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper) {

        if (!ModList.get().isLoaded("aether")) {
            return;
        }

        AdvancementHolder parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
        ResourceKey<Level> DIMAether = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("aether", "the_aether"));

        // 根成就 → 进入天境
        AdvancementHolder EnterAether = getAdvancement(parentRoot, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "aether_grass_block")), "aether_enter", AdvancementType.TASK, true, true, false)
                .addCriterion("has_aether_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMAether))
                .save(saver, getNameId("aether_enter"));


        // 进入天境 → 神饯蓝莓汁桶
        AdvancementHolder AetherJuice = getAdvancement(EnterAether, AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get(), "aether_enchanted_berry_juice_bucket", AdvancementType.TASK, true, true, false)
                .addCriterion("has_divine_offering_brew", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.ENCHANTED_BERRY_JUICE_BUCKET.get())) // 神饯蓝莓汁桶
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("aether_enchanted_berry_juice_bucket"));
        // 神饯蓝莓汁桶 → 所有天境酒
        AdvancementHolder AetherWine = getAdvancement(AetherJuice, AetherItems.DIVINE_OFFERING_BREW.get(), "aether_wine", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_divine_offering_brew", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.DIVINE_OFFERING_BREW.get())) // 神饯紫晶酿
                .addCriterion("has_divine_energy_mist", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.DIVINE_ENERGY_MIST.get())) // 神能迷雾
                .addCriterion("has_swet_fizz", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.SWET_FIZZ.get())) // 史维特菲士
                .addCriterion("has_gravitite_drunk", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.GRAVITITE_DRUNK.get())) // 重力醉
                .addCriterion("has_healing_elixir", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.HEALING_ELIXIR.get())) // 治愈灵药
                .addCriterion("has_gingerbread_warmer", InventoryChangeTrigger.TriggerInstance.hasItems(AetherItems.GINGERBREAD_WARMER.get())) // 姜饼暖饮
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(500))
                .save(saver, getNameId("aether_wine"));
    }

    /**
     * 创建带父成就的Builder
     */
    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
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