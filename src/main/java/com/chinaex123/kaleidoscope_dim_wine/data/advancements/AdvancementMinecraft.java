package com.chinaex123.kaleidoscope_dim_wine.data.advancements;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.util.TextUtils;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 本体相关成就
 */
public class AdvancementMinecraft implements AdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {

        // 根成就
        AdvancementHolder Root = Advancement.Builder.advancement()
                // 形参：成就图标，标题，描述，背景图片，图标类型，右上角成就弹出，在聊天栏显示，成就栏隐藏图标
                .display(ModItems.MOD_LOGO.get(),
                        TextUtils.getTranslation("root.title"),
                        TextUtils.getTranslation("root.desc"),
                        ResourceLocation.withDefaultNamespace("textures/block/smooth_stone.png"),
                        AdvancementType.TASK, true, true, false)
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(saver, getNameId("root"));


        // ==================== 次元维度 - 下界 ====================
        // 根成就 → 进入下界
        AdvancementHolder EnterNether = getAdvancement(Root, Items.NETHERRACK, "nether_enter", AdvancementType.TASK, true, true, false)
                .addCriterion("has_nether_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.NETHER))
                .save(saver, getNameId("nether_enter"));
        // 进入下界 → 下界葡萄藤
        AdvancementHolder NetherGrapevine = getAdvancement(EnterNether, ModItems.CRIMSON_GRAPEVINE.get(), "nether_grapevine", AdvancementType.TASK, true, true, false)
                .addCriterion("has_crimson_grape_vine", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRIMSON_GRAPEVINE.get())) // 绯红葡萄藤
                .addCriterion("has_warped_grape_vine", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WARPED_GRAPEVINE.get())) // 诡异葡萄藤
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("nether_grapevine"));
        // 下界葡萄藤 → 绯红诡异菌露
        AdvancementHolder NetherFungalSap = getAdvancement(NetherGrapevine, ModItems.CRIMSON_FUNGAL_SAP.get(), "nether_fungal_sap", AdvancementType.TASK, true, true, false)
                .addCriterion("has_crimson_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRIMSON_FUNGAL_SAP.get())) // 绯红菌露
                .addCriterion("has_warped_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WARPED_FUNGAL_SAP.get())) // 诡异菌露
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("nether_fungal_sap"));

        // 下界葡萄藤 → 绯红诡异葡萄汁
        AdvancementHolder NetherGrapeJuice = getAdvancement(NetherGrapevine, ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get(), "nether_grape_juice", AdvancementType.TASK, true, true, false)
                .addCriterion("has_crimson_grape_juice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRIMSON_GRAPE_JUICE_BUCKET.get())) // 绯红葡萄汁
                .addCriterion("has_warped_grape_juice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WARPED_GRAPE_JUICE_BUCKET.get())) // 诡异葡萄汁
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("nether_grape_juice"));
        // 绯红诡异葡萄汁 → 所有下界酒
        AdvancementHolder NetherWine = getAdvancement(NetherGrapeJuice, ModItems.CRIMSON_CRESCENDO.get(), "nether_wine", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_crimson_fungal_sap", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRIMSON_CRESCENDO.get())) // 绯红绝响
                .addCriterion("has_ethereal_noble", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHEREAL_NOBLE.get())) // 诡影尊爵
                .addCriterion("has_wart_hennessy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WART_HENNESSY.get())) // 疣域轩尼诗
                .addCriterion("has_blaze_martell", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLAZE_MARTELL.get())) // 烈焰马爹利
                .addCriterion("has_magma_royal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MAGMA_ROYAL_SALUTE.get())) // 岩浆皇家礼炮
                .addCriterion("has_black_bone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLACK_BONE_LAFITE.get())) // 黑骨拉菲
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(500))
                .save(saver, getNameId("nether_wine"));


        // ==================== 次元维度 - 末地 ====================
        // 根成就 → 进入末地
        AdvancementHolder EnterTheEnd = getAdvancement(Root, Items.END_STONE, "the_end_enter", AdvancementType.TASK, true, true, false)
                .addCriterion("has_the_end_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.END))
                .save(saver, getNameId("the_end_enter"));
        // 进入末地 → 迷梦果
        AdvancementHolder TheEndDreamfruit = getAdvancement(EnterTheEnd, ModItems.DREAMFRUIT.get(), "the_end_dreamfruit", AdvancementType.TASK, true, true, false)
                .addCriterion("has_dreamfruit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DREAMFRUIT.get())) // 迷梦果
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_end_dreamfruit"));
        // 迷梦果 → 迷梦果汁
        AdvancementHolder TheEndDreamfruitJuiceBucket = getAdvancement(TheEndDreamfruit, ModItems.DREAMFRUIT_JUICE_BUCKET.get(), "the_end_dreamfruit_juice_bucket", AdvancementType.TASK, true, true, false)
                .addCriterion("has_dreamfruit_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DREAMFRUIT_JUICE_BUCKET.get())) // 迷梦果汁
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_end_dreamfruit_juice_bucket"));
        // 迷梦果汁 → 所有末地酒
        AdvancementHolder TheEndWine = getAdvancement(TheEndDreamfruitJuiceBucket, ModItems.CHORUS_COGNAC.get(), "the_end_wine", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_chorus_cognac", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHORUS_COGNAC.get())) // 紫颂干邑
                .addCriterion("has_dragons_breath_brandy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGONS_BREATH_BRANDY.get())) // 龙息白兰地
                .addCriterion("has_abyssal_porter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ABYSSAL_PORTER.get())) // 深渊波特
                .addCriterion("has_silent_sherry", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SILENT_SHERRY.get())) // 静默雪莉
                .addCriterion("has_forgotten_margarita", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FORGOTTEN_MARGARITA.get())) // 遗忘玛格丽特
                .addCriterion("has_phantom_dream_bubble", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PHANTOM_DREAM_BUBBLE.get())) // 幻梦泡影
                .addCriterion("has_end_starlight", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.END_STARLIGHT.get())) // 终末星光
                .addCriterion("has_divine_embryo_port", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DIVINE_EMBRYO_PORT.get())) // 神血波尔多
                .addCriterion("has_draconic_blood_wine", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRACONIC_BLOOD_WINE.get())) // 龙血酒
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(300))
                .save(saver, getNameId("the_end_wine"));

        // 迷梦果 → 龙血
        AdvancementHolder TheEndDragonBloodBucket = getAdvancement(TheEndDreamfruit, ModItems.DRAGON_BLOOD_BUCKET.get(), "the_end_dragon_blood_bucket", AdvancementType.TASK, true, true, false)
                .addCriterion("has_dragon_blood_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_BLOOD_BUCKET.get())) // 龙血桶
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_end_dragon_blood_bucket"));
        // 龙血 → 龙血瓶
        AdvancementHolder TheEndDragonBloodBottle = getAdvancement(TheEndDragonBloodBucket, ModItems.DRAGON_BLOOD_BOTTLE.get(), "the_end_dragon_blood_bottle", AdvancementType.TASK, true, true, false)
                .addCriterion("has_dragon_blood_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_BLOOD_BOTTLE.get())) // 龙血瓶
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getNameId("the_end_dragon_blood_bottle"));
    }

    /**
     * 创建带父成就的Builder
     * @param parent 父成就
     * @param display 显示图标
     * @param name 成就名称（用于生成翻译key）
     * @param frame 成就类型
     * @param showToast 是否显示弹窗
     * @param announceToChat 是否在聊天栏公告
     * @param hidden 是否隐藏
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