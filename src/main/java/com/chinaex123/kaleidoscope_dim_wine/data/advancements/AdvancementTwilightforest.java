package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
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

public class AdvancementTwilightforest implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<Advancement> saver, @NotNull ExistingFileHelper existingFileHelper) {

        if (!ModList.get().isLoaded("twilightforest")) {
            return;
        }

        Advancement parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
        ResourceKey<Level> DIMTwilightForest = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("twilightforest", "twilight_forest"));

        // 根成就 → 进入暮色森林
        Advancement EnterTwilightForest = getAdvancement(parentRoot, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "twilight_portal_miniature_structure")), "twilightforest_enter", FrameType.TASK, true, true, false)
                .addCriterion("has_twilightforest_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMTwilightForest))
                .save(saver, getNameId("twilightforest_enter"));


        // 进入暮色森林 → 火炬浆果
        Advancement TwilightforestTorchberries = getAdvancement(EnterTwilightForest, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries")), "twilightforest_torchberries", FrameType.TASK, true, true, false)
                .addCriterion("has_torchberries", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries"))))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_torchberries"));
        // 火炬浆果 → 火炬浆果汁桶
        Advancement TwilightforestTorchberriesJuiceBucket = getAdvancement(TwilightforestTorchberries, TwilightforestItems.TORCHBERRIES_JUICE_BUCKET.get(), "twilightforest_torchberries_juice_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_torchberries_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries"))))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_torchberries_juice_bucket"));
        // 火炬浆果汁桶 → 所有暮色酒
        Advancement TwilightforestWine = getAdvancement(TwilightforestTorchberriesJuiceBucket, TwilightforestItems.RANGERS_SATCHEL.get(), "twilightforest_wine", FrameType.CHALLENGE, true, true, false)
                .addCriterion("has_cave_glowbrew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.CAVE_GLOWBREW.get()))
                .addCriterion("has_dawnlight_dew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DAWNLIGHT_DEW.get()))
                .addCriterion("has_dead_end_spittle", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DEAD_END_SPITTLE.get()))
                .addCriterion("has_snakeskin_liqueur", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.SNAKESKIN_LIQUEUR.get()))
                .addCriterion("has_frostvein_beastblood", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get()))
                .addCriterion("has_rangers_satchel", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.RANGERS_SATCHEL.get()))
                .addCriterion("has_embereye", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.EMBEREYE.get()))
                .addCriterion("has_stagcall_monsoon", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.STAGCALL_MONSOON.get()))
                .addCriterion("has_thornheart", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.THORNHEART.get()))
                .addCriterion("has_druids_secret_brew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DRUIDS_SECRET_BREW.get()))
                .addCriterion("has_moorglow_birds_song", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.MOORGLOW_BIRDS_SONG.get()))
                .addCriterion("has_perennial_frost", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.PERENNIAL_FROST.get()))
                .addCriterion("has_giants_hymn", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GIANTS_HYMN.get()))
                .addCriterion("has_goblins_stash", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GOBLINS_STASH.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.loot(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "advancements/twilightforest_wine")))
                .save(saver, getNameId("twilightforest_wine"));

        // 进入暮色森林 → 霜心果
        Advancement TwilightforestFrostheartFruit = getAdvancement(EnterTwilightForest, TwilightforestItems.FROSTHEART_FRUIT.get(), "twilightforest_frostheart_fruit", FrameType.TASK, true, true, false)
                .addCriterion("has_frostheart_fruit", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTHEART_FRUIT.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_frostheart_fruit"));
        // 霜心果 → 霜心果汁桶
        Advancement TwilightforestFrostheartFruitJuiceBucket = getAdvancement(TwilightforestFrostheartFruit, TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.get(), "twilightforest_frostheart_fruit_juice_bucket", FrameType.TASK, true, true, false)
                .addCriterion("has_frostheart_fruit_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_frostheart_fruit_juice_bucket"));

        // 进入暮色森林 → 哥布林精华
        Advancement TwilightforestGoblinEssence = getAdvancement(EnterTwilightForest, TwilightforestItems.GOBLIN_ESSENCE.get(), "twilightforest_goblin_essence", FrameType.TASK, true, true, false)
                .addCriterion("has_goblin_essence", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GOBLIN_ESSENCE.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_goblin_essence"));
        // 哥布林精华 → 巨物碎片
        Advancement TwilightforestColossalFragment = getAdvancement(TwilightforestGoblinEssence, TwilightforestItems.COLOSSAL_FRAGMENT.get(), "twilightforest_colossal_fragment", FrameType.TASK, true, true, false)
                .addCriterion("has_colossal_fragment", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.COLOSSAL_FRAGMENT.get()))
                .requirements(RequirementsStrategy.OR)
                .save(saver, getNameId("twilightforest_colossal_fragment"));
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
