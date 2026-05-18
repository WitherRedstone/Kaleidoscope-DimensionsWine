package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.util.TextUtils;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class AdvancementMinecraft implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {

        Advancement Root = Advancement.Builder.advancement()
                .display(KDWItems.MOD_LOGO.get(),
                        TextUtils.getTranslation("root.title"),
                        TextUtils.getTranslation("root.desc"),
                        ResourceLocation.withDefaultNamespace("textures/block/smooth_stone.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(saver, getNameId("root"));


        // ==================== 次元维度 - 下界 ====================
        Advancement EnterNether = getAdvancement(Root, Items.NETHERRACK, "nether_enter", FrameType.TASK, true, true, false)
                .addCriterion("has_nether_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.NETHER))
                .save(saver, getNameId("nether_enter"));
        Advancement NetherGrapevine = getAdvancement(EnterNether, KDWItems.CRIMSON_GRAPEVINE.get(), "nether_grapevine", FrameType.TASK, true, true, false)
                .addCriterion("has_crimson_grape_vine", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.CRIMSON_GRAPEVINE.get()))
                .addCriterion("has_warped_grape_vine", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.WARPED_GRAPEVINE.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("nether_grapevine"));
        Advancement NetherFungalSap = getAdvancement(NetherGrapevine, KDWItems.CRIMSON_FUNGAL_SAP.get(), "nether_fungal_sap", FrameType.TASK, true, true, false)
                .addCriterion("has_crimson_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.CRIMSON_FUNGAL_SAP.get()))
                .addCriterion("has_warped_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.WARPED_FUNGAL_SAP.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("nether_fungal_sap"));

        Advancement NetherGrapeJuice = getAdvancement(NetherGrapevine, KDWItems.CRIMSON_GRAPE_JUICE_BUCKET.get(), "nether_grape_juice", FrameType.TASK, true, true, false)
                .addCriterion("has_crimson_grape_juice", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.CRIMSON_GRAPE_JUICE_BUCKET.get()))
                .addCriterion("has_warped_grape_juice", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.WARPED_GRAPE_JUICE_BUCKET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("nether_grape_juice"));
        Advancement NetherWine = getAdvancement(NetherGrapeJuice, KDWItems.CRIMSON_CRESCENDO.get(), "nether_wine", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_crimson_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.CRIMSON_CRESCENDO.get()))
                .addCriterion("has_ethereal_noble", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.ETHEREAL_NOBLE.get()))
                .addCriterion("has_wart_hennessy", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.WART_HENNESSY.get()))
                .addCriterion("has_blaze_martell", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.BLAZE_MARTELL.get()))
                .addCriterion("has_magma_royal", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.MAGMA_ROYAL_SALUTE.get()))
                .addCriterion("has_black_bone", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.BLACK_BONE_LAFITE.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(500).build())
                .save(saver, getNameId("nether_wine"));


        // ==================== 次元维度 - 末地 ====================
        Advancement EnterTheEnd = getAdvancement(Root, Items.END_STONE, "the_end_enter", FrameType.TASK, true, true, false)
                .addCriterion("has_the_end_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.END))
                .save(saver, getNameId("the_end_enter"));
        Advancement TheEndDreamfruit = getAdvancement(EnterTheEnd, KDWItems.DREAMFRUIT.get(), "the_end_dreamfruit", FrameType.TASK, true, true, false)
                .addCriterion("has_dreamfruit", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DREAMFRUIT.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_end_dreamfruit"));
        Advancement TheEndDreamfruitJuiceBucket = getAdvancement(TheEndDreamfruit, KDWItems.DREAMFRUIT_JUICE_BUCKET.get(), "the_end_dreamfruit_juice_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_dreamfruit_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DREAMFRUIT_JUICE_BUCKET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_end_dreamfruit_juice_bucket"));
        Advancement TheEndWine = getAdvancement(TheEndDreamfruitJuiceBucket, KDWItems.CHORUS_COGNAC.get(), "the_end_wine", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_chorus_cognac", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.CHORUS_COGNAC.get()))
                .addCriterion("has_dragons_breath_brandy", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DRAGONS_BREATH_BRANDY.get()))
                .addCriterion("has_abyssal_porter", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.ABYSSAL_PORTER.get()))
                .addCriterion("has_silent_sherry", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.SILENT_SHERRY.get()))
                .addCriterion("has_forgotten_margarita", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.FORGOTTEN_MARGARITA.get()))
                .addCriterion("has_phantom_dream_bubble", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.PHANTOM_DREAM_BUBBLE.get()))
                .addCriterion("has_end_starlight", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.END_STARLIGHT.get()))
                .addCriterion("has_divine_embryo_port", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DIVINE_EMBRYO_PORT.get()))
                .addCriterion("has_draconic_blood_wine", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DRACONIC_BLOOD_WINE.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(300).build())
                .save(saver, getNameId("the_end_wine"));

        Advancement TheEndDragonBloodBucket = getAdvancement(TheEndDreamfruit, KDWItems.DRAGON_BLOOD_BUCKET.get(), "the_end_dragon_blood_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_dragon_blood_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DRAGON_BLOOD_BUCKET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_end_dragon_blood_bucket"));
        Advancement TheEndDragonBloodBottle = getAdvancement(TheEndDragonBloodBucket, KDWItems.DRAGON_BLOOD_BOTTLE.get(), "the_end_dragon_blood_bottle", FrameType.TASK, true, true, false)
                .addCriterion("has_dragon_blood_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(KDWItems.DRAGON_BLOOD_BOTTLE.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("the_end_dragon_blood_bottle"));
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
