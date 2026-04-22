//package com.chinaex123.kaleidoscope_dim_wine.data.advancements;
//
//import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
//import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
//import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
//import com.chinaex123.kaleidoscope_dim_wine.util.TextUtils;
//import net.minecraft.advancements.*;
//import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
//import net.minecraft.advancements.critereon.InventoryChangeTrigger;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.ItemLike;
//import net.minecraft.world.level.Level;
//import net.neoforged.fml.ModList;
//import net.neoforged.neoforge.common.data.AdvancementProvider;
//import net.neoforged.neoforge.common.data.ExistingFileHelper;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.function.Consumer;
//
///**
// * 暮色森林联动相关成就
// */
//public class AdvancementTwilightforest implements AdvancementProvider.AdvancementGenerator {
//
//    @Override
//    public void generate(@NotNull HolderLookup.Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper) {
//
//        if (!ModList.get().isLoaded("twilightforest")) {
//            return;
//        }
//
//        AdvancementHolder parentRoot = Advancement.Builder.advancement().build(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "root"));
//        ResourceKey<Level> DIMTwilightForest = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("twilightforest", "twilight_forest"));
//
//        // 根成就 → 进入暮色森林
//        AdvancementHolder EnterTwilightForest = getAdvancement(parentRoot, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "twilight_portal_miniature_structure")), "twilightforest_enter", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_twilightforest_enter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DIMTwilightForest))
//                .save(saver, getNameId("twilightforest_enter"));
//
//
//        // 进入暮色森林 → 火炬浆果
//        AdvancementHolder TwilightforestTorchberries = getAdvancement(EnterTwilightForest, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries")), "twilightforest_torchberries", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_torchberries", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries")))) // 火炬浆果
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_torchberries"));
//        // 火炬浆果 → 火炬浆果汁桶
//        AdvancementHolder TwilightforestTorchberriesJuiceBucket = getAdvancement(TwilightforestTorchberries, TwilightforestItems.TORCHBERRIES_JUICE_BUCKET.get(), "twilightforest_torchberries_juice_bucket", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_torchberries_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries")))) // 火炬浆果
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_torchberries_juice_bucket"));
//        // 火炬浆果汁桶 → 所有暮色酒
//        AdvancementHolder TwilightforestWine = getAdvancement(TwilightforestTorchberriesJuiceBucket, TwilightforestItems.RANGERS_SATCHEL.get(), "twilightforest_wine", AdvancementType.CHALLENGE, true, true, false)
//                .addCriterion("has_cave_glowbrew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.CAVE_GLOWBREW.get())) // 洞窟萤火酿
//                .addCriterion("has_dawnlight_dew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DAWNLIGHT_DEW.get())) // 林隙晨露
//                .addCriterion("has_dead_end_spittle", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DEAD_END_SPITTLE.get())) // 死巷之唾
//                .addCriterion("has_snakeskin_liqueur", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.SNAKESKIN_LIQUEUR.get())) // 蛇蜕利口酒
//                .addCriterion("has_frostvein_beastblood", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get())) // 霜脉兽血
//                .addCriterion("has_rangers_satchel", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.RANGERS_SATCHEL.get())) // 巡林客的背囊
//                .addCriterion("has_embereye", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.EMBEREYE.get())) // 烬瞳
//                .addCriterion("has_stagcall_monsoon", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.STAGCALL_MONSOON.get())) // 鹿鸣季风
//                .addCriterion("has_thornheart", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.THORNHEART.get())) // 荆棘之心
//                .addCriterion("has_druids_secret_brew", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.DRUIDS_SECRET_BREW.get())) // 德鲁伊的秘酿
//                .addCriterion("has_moorglow_birds_song", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.MOORGLOW_BIRDS_SONG.get())) // 辉夜鸟之歌
//                .addCriterion("has_perennial_frost", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.PERENNIAL_FROST.get())) // 终年冻土
//                .addCriterion("has_giants_hymn", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GIANTS_HYMN.get())) // 巨人赞歌
//                .addCriterion("has_goblins_stash", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GOBLINS_STASH.get())) // 地精的私藏
//                .requirements(AdvancementRequirements.Strategy.AND)
//                .rewards(AdvancementRewards.Builder.loot(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "advancements/twilightforest_wine"))))
//                .save(saver, getNameId("twilightforest_wine"));
//
//        // 进入暮色森林 → 霜心果
//        AdvancementHolder TwilightforestFrostheartFruit = getAdvancement(EnterTwilightForest, TwilightforestItems.FROSTHEART_FRUIT.get(), "twilightforest_frostheart_fruit", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_frostheart_fruit", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTHEART_FRUIT.get())) // 霜心果
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_frostheart_fruit"));
//        // 霜心果 → 霜心果汁桶
//        AdvancementHolder TwilightforestFrostheartFruitJuiceBucket = getAdvancement(TwilightforestFrostheartFruit, TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.get(), "twilightforest_frostheart_fruit_juice_bucket", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_frostheart_fruit_juice_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.FROSTHEART_FRUIT_JUICE_BUCKET.get())) // 霜心果
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_frostheart_fruit_juice_bucket"));
//
//        // 进入暮色森林 → 哥布林精华
//        AdvancementHolder TwilightforestGoblinEssence = getAdvancement(EnterTwilightForest, TwilightforestItems.GOBLIN_ESSENCE.get(), "twilightforest_goblin_essence", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_goblin_essence", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.GOBLIN_ESSENCE.get())) // 哥布林精华
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_goblin_essence"));
//        // 哥布林精华 → 巨物碎片
//        AdvancementHolder TwilightforestColossalFragment = getAdvancement(TwilightforestGoblinEssence, TwilightforestItems.COLOSSAL_FRAGMENT.get(), "twilightforest_colossal_fragment", AdvancementType.TASK, true, true, false)
//                .addCriterion("has_colossal_fragment", InventoryChangeTrigger.TriggerInstance.hasItems(TwilightforestItems.COLOSSAL_FRAGMENT.get())) // 巨物碎片
//                .requirements(AdvancementRequirements.Strategy.OR)
//                .save(saver, getNameId("twilightforest_colossal_fragment"));
//    }
//
//    /**
//     * 创建带父成就的Builder
//     * @param parent 父成就
//     * @param display 显示图标
//     * @param name 成就名称（用于生成翻译key）
//     * @param frame 成就类型
//     * @param showToast 是否显示弹窗
//     * @param announceToChat 是否在聊天栏公告
//     * @param hidden 是否隐藏
//     */
//    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
//        return Advancement.Builder.advancement()
//                .parent(parent)
//                .display(display,
//                        TextUtils.getTranslation(name + ".title"),
//                        TextUtils.getTranslation(name + ".desc"),
//                        null,
//                        frame, showToast, announceToChat, hidden);
//    }
//
//    private String getNameId(String id) {
//        return KaleidoscopeDimensionsWine.MOD_ID + ":" + id;
//    }
//}
