package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
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
 * 蜜蜂领域联动相关成就
 */
public class AdvancementTheBumblezone implements AdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper) {

        // 如果没有安装蜜蜂领域模组，则不生成成就
        if (!ModList.get().isLoaded("the_bumblezone")) {
            return;
        }

        AdvancementHolder parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
        ResourceKey<Level> DIMTheBumblezone = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("the_bumblezone", "the_bumblezone"));

        // 根成就 → 进入蜜蜂领域
        AdvancementHolder EnterTheBumblezone = getAdvancement(parentRoot, Items.HONEYCOMB, "the_bumblezone_enter", AdvancementType.TASK, true, true, false)
                .addCriterion("has_the_bumblezone_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMTheBumblezone))
                .save(saver, getNameId("the_bumblezone_enter"));


        // 进入蜜蜂领域 → 糖水桶
        AdvancementHolder TheBumblezoneSugarWater = getAdvancement(EnterTheBumblezone, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_bucket")), "the_bumblezone_sugar_water_bucket", AdvancementType.TASK, true, true, false)
                .addCriterion("has_the_bumblezone_sugar_water_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_bucket")))) // 糖水桶
                .addCriterion("has_the_bumblezone_honey_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_bucket")))) // 蜂蜜桶
                .addCriterion("has_the_bumblezone_royal_jelly_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "royal_jelly_bucket")))) // 蜂王浆桶
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_bumblezone_sugar_water_bucket"));
        // 糖水桶 → 所有蜂蜜酒
        AdvancementHolder TheBumblezoneWine = getAdvancement(TheBumblezoneSugarWater, TheBumblezoneItems.SPRITE.get(), "the_bumblezone_wine", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_sprite", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.SPRITE.get())) // 雪碧
                .addCriterion("has_pepsi", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.PEPSI.get())) // 可乐
                .addCriterion("has_fanta", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.FANTA.get())) // 芬达
                .addCriterion("has_pollen_nectar", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.POLLEN_NECTAR.get())) // 花粉甜酿
                .addCriterion("has_honeythorn_mead", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.HONEYTHORN_MEAD.get())) // 蜜刺佳酿
                .addCriterion("has_beeswax_honey_wine", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())) // 蜂蜡陈酿
                .addCriterion("has_sweet_crystal_honey", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())) // 甜蜜水晶
                .addCriterion("has_royal_honey_brew", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.ROYAL_HONEY_BREW.get())) // 蜂王特酿
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(500))
                .save(saver, getNameId("the_bumblezone_wine"));

        // 进入蜜蜂领域 → 凝碳粉
        AdvancementHolder TheBumblezoneCarbocretinPowder = getAdvancement(EnterTheBumblezone, TheBumblezoneItems.CARBOCRETIN_POWDER.get(), "the_bumblezone_carbocretin_powder", AdvancementType.TASK, true, true, false)
                .addCriterion("has_rangers_satchel", InventoryChangeTrigger.TriggerInstance.hasItems(TheBumblezoneItems.CARBOCRETIN_POWDER.get())) // 凝碳粉
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_bumblezone_carbocretin_powder"));

        // 进入蜜蜂领域 → 蜜酒精华
        AdvancementHolder TheBumblezoneMeadEssence = getAdvancement(EnterTheBumblezone, TheBumblezoneItems.MEAD_ESSENCE.get(), "the_bumblezone_mead_essence", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_raging_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_raging"))))
                .addCriterion("has_knowing_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_knowing"))))
                .addCriterion("has_calming_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_calming"))))
                .addCriterion("has_life_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_life"))))
                .addCriterion("has_radiance_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_radiance"))))
                .addCriterion("has_continuity_essence", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "essence_continuity"))))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.loot(ResourceKey.create(Registries.LOOT_TABLE,
                        ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "advancements/mead_essence"))))
                .save(saver, getNameId("the_bumblezone_mead_essence"));






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