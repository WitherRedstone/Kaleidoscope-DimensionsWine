package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Aether.AetherItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.EternalStarlight.EternalStarlightItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.TheBumblezone.TheBumblezoneItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestFluids;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.builder.BarrelBuilder;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.builder.PressingTubBuilder;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModFluids;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        modRecipes(recipeOutput);
        PressingTubRecipes(recipeOutput);
        BarrelTubRecipes(recipeOutput);
    }

    /** 模组配方 */
    private void modRecipes(RecipeOutput recipeOutput) {

        // ==================== 小彩蛋 ====================
        // 玩偶 - ChinaEX123_BILI
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.DOLL_001.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.LIGHT_BLUE_WOOL)
                .unlockedBy("has_doll_1", has(Items.LIGHT_BLUE_WOOL))
                .save(recipeOutput);
        // 玩偶 - Fvue233
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.DOLL_002.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.PINK_WOOL)
                .unlockedBy("has_doll_2", has(Items.PINK_WOOL))
                .save(recipeOutput);
        // 玩偶 - Agens_Eland
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.DOLL_003.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.MAGENTA_WOOL)
                .unlockedBy("has_doll_3", has(Items.MAGENTA_WOOL))
                .save(recipeOutput);
        // 玩偶 - SCXSYGL
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.DOLL_004.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.LIGHT_GRAY_WOOL)
                .unlockedBy("has_doll_4", has(Items.LIGHT_GRAY_WOOL))
                .save(recipeOutput);
        // 玩偶 - nade__shiko
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.DOLL_005.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.YELLOW_WOOL)
                .unlockedBy("has_doll_5", has(Items.YELLOW_WOOL))
                .save(recipeOutput);

        // ==================== 次元维度 - 小装饰 ====================
        // 小灯串（潜影贝-无色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get(),8)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("CCC")
                .define('A', Items.CHAIN)
                .define('B', Items.LANTERN)
                .define('C', Items.CHORUS_FRUIT)
                .unlockedBy("has_string_lights_entity_shulker_chain", has(Items.CHAIN))
                .unlockedBy("has_string_lights_entity_shulker_lantern", has(Items.LANTERN))
                .unlockedBy("has_string_lights_entity_shulker_chorus_fruit", has(Items.CHORUS_FRUIT))
                .save(recipeOutput);
        // 小灯串（潜影贝-白色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.WHITE_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-橙色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.ORANGE_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_orange_dye", has(Items.ORANGE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-品红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.MAGENTA_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-淡蓝色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIGHT_BLUE_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_light_blue_dye", has(Items.LIGHT_BLUE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黄色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.YELLOW_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黄绿色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIME_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-粉红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.PINK_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-灰色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GRAY_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_gray_dye", has(Items.GRAY_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-淡灰色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIGHT_GRAY_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_light_gray_dye", has(Items.LIGHT_GRAY_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-青色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.CYAN_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-紫色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.PURPLE_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_purple_dye", has(Items.PURPLE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-蓝色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BLUE_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-棕色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BROWN_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_brown_dye", has(Items.BROWN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-绿色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GREEN_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.RED_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_red_dye", has(Items.RED_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黑色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BLACK_DYE)
                .define('B', KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(KDWBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE))
                .save(recipeOutput);
        // 小灯串（小鸡仔）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get(),8)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("CCC")
                .define('A', Items.CHAIN)
                .define('B', Items.LANTERN)
                .define('C', Items.FEATHER)
                .unlockedBy("has_string_lights_entity_chicken_chain", has(Items.CHAIN))
                .unlockedBy("has_string_lights_entity_chicken_lantern", has(Items.LANTERN))
                .unlockedBy("has_string_lights_entity_chicken_feather", has(Items.FEATHER))
                .save(recipeOutput);
        // 小灯串（蜜蜂）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWBlocks.STRING_LIGHTS_ENTITY_BEE.get(),8)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("CCC")
                .define('A', Items.CHAIN)
                .define('B', Items.LANTERN)
                .define('C', Items.HONEYCOMB)
                .unlockedBy("has_string_lights_entity_bee_chain", has(Items.CHAIN))
                .unlockedBy("has_string_lights_entity_bee_lantern", has(Items.LANTERN))
                .unlockedBy("has_string_lights_entity_bee_honeycomb", has(Items.HONEYCOMB))
                .save(recipeOutput);

        // ==================== 次元维度 - 物品 ====================
        // 龙血瓶
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, KDWItems.DRAGON_BLOOD_BOTTLE.get(),4)
                .requires(KDWItems.DRAGON_BLOOD_BUCKET)
                .requires(Items.GLASS_BOTTLE,4 )
                .unlockedBy("has_dragon_blood_bucket", has(KDWItems.DRAGON_BLOOD_BUCKET.get()))
                .save(recipeOutput);
        // 巨物碎片
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TwilightforestItems.COLOSSAL_FRAGMENT.get(),16)
                .requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                .unlockedBy("has_colossal", has(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal"))))
                .save(recipeOutput.withConditions(modLoaded("twilightforest")));
        // 天使之羽
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KDWItems.ANGEL_FEATHER.get(),8)
                .requires(KDWItems.ANGEL_WINGS)
                .unlockedBy("has_angel_wings", has(KDWItems.ANGEL_WINGS))
                .save(recipeOutput);
        // 易拉罐
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KDWItems.POP_CAN.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GLASS_BOTTLE)
                .define('B', Tags.Items.NUGGETS_IRON)
                .unlockedBy("has_pop_can_glass_bottle", has(Items.GLASS_BOTTLE))
                .unlockedBy("has_pop_can_nuggets_iron", has(Tags.Items.NUGGETS_IRON))
                .save(recipeOutput);
    }

    /** 森罗物语：酒馆 - 果盆 */
    private void PressingTubRecipes(RecipeOutput output) {

        // 绯红葡萄
        PressingTubBuilder.builder()
                .setIngredient(KDWItems.CRIMSON_GRAPE)
                .setFluid(KDWFluids.CRIMSON_GRAPE_JUICE.get())
                .save(output);
        // 诡异葡萄
        PressingTubBuilder.builder()
                .setIngredient(KDWItems.WARPED_GRAPE)
                .setFluid(KDWFluids.WARPED_GRAPE_JUICE.get())
                .save(output);
        // 迷梦果         
        PressingTubBuilder.builder()
                .setIngredient(KDWItems.DREAMFRUIT)
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .save(output);

        // 暮色森林联动
        if (ModList.get().isLoaded("twilightforest")) {
            // 火炬浆果汁
            PressingTubBuilder.builder()
                    .setIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries")))
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            // 霜心果汁
            PressingTubBuilder.builder()
                    .setIngredient(TwilightforestItems.FROSTHEART_FRUIT)
                    .setFluid(TwilightforestFluids.FROSTHEART_FRUIT_JUICE.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
        }

        // 天境联动
        if (ModList.get().isLoaded("aether")) {
            // 神饯蓝莓汁
            PressingTubBuilder.builder()
                    .setIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "enchanted_berry")))
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .save(output.withConditions(modLoaded("aether")));
        }

        // 永恒星光联动
        if (ModList.get().isLoaded("eternal_starlight")) {
            // 渊海果汁
            PressingTubBuilder.builder()
                    .setIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "abyssal_fruit")))
                    .setFluid(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            // 月辉浆果汁
            PressingTubBuilder.builder()
                    .setIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "lunar_berries")))
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            // 银辛果汁
            PressingTubBuilder.builder()
                    .setIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "silver_pungency_fruit")))
                    .setFluid(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
        }

    }

    /** 森罗物语：酒馆 - 酒桶 */
    private void BarrelTubRecipes(RecipeOutput output) {

        BarrelBuilder.builder()
                .setFluid(Fluids.WATER)
                .addIngredient(KDWItemTags.HOPS)
                .addIngredient(Tags.Items.SEEDS_WHEAT)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.BUDWEISER_BEER.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(ModFluids.GLOW_BERRIES_JUICE.get())
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.PINK_PETALS)
                .addIngredient(Items.BLUE_ORCHID)
                .addIngredient(Items.DANDELION)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.BOCCHI.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.INK_SAC)
                .addIngredient(Items.ECHO_SHARD)
                .addIngredient(Items.WITHER_ROSE)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.ABYSSAL_PORTER.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.CRIMSON_GRAPE_JUICE.get())
                .addIngredient(Items.WITHER_SKELETON_SKULL)
                .addIngredient(Items.WITHER_ROSE)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.BLACK_BONE_LAFITE.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(Fluids.LAVA)
                .addIngredient(Items.BLAZE_ROD)
                .addIngredient(Items.BLAZE_POWDER)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.BLAZE_MARTELL.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FRUIT)
                .addIngredient(Items.SUGAR)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.CHORUS_COGNAC.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.CRIMSON_GRAPE_JUICE.get())
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WEEPING_VINES)
                .addIngredient(KDWItems.CRIMSON_FUNGAL_SAP)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.CRIMSON_CRESCENDO.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DRAGON_BLOOD.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.DRAGON_BREATH)
                .addIngredient(Items.GOLDEN_APPLE)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.DIVINE_EMBRYO_PORT.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DRAGON_BLOOD.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.CHORUS_FRUIT)
                .addIngredient(Items.GOLDEN_CARROT)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.DRACONIC_BLOOD_WINE.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.DRAGON_BREATH)
                .addIngredient(Items.BLAZE_POWDER)
                .addIngredient(Tags.Items.GEMS_AMETHYST)
                .addIngredient(Items.SUGAR)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(Items.ENDER_PEARL)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.END_STARLIGHT.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.WARPED_GRAPE_JUICE.get())
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.TWISTING_VINES)
                .addIngredient(KDWItems.WARPED_FUNGAL_SAP)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.ETHEREAL_NOBLE.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.PRISMARINE_SHARD)
                .addIngredient(Items.GLOW_INK_SAC)
                .addIngredient(Items.GOLDEN_APPLE)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.FORGOTTEN_MARGARITA.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(Fluids.LAVA)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(Items.BLAZE_ROD)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FRUIT)
                .addIngredient(Items.PHANTOM_MEMBRANE)
                .addIngredient(Items.GLOW_BERRIES)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.PHANTOM_DREAM_BUBBLE.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(KDWFluids.DREAMFRUIT_JUICE.get())
                .addIngredient(Items.CHORUS_FLOWER)
                .addIngredient(Items.FERMENTED_SPIDER_EYE)
                .addIngredient(Items.END_ROD)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.SILENT_SHERRY.get())
                .save(output);
        BarrelBuilder.builder()
                .setFluid(Fluids.LAVA)
                .addIngredient(Items.NETHER_WART)
                .addIngredient(Items.GHAST_TEAR)
                .setCarrier(ModItems.EMPTY_BOTTLE)
                .setResult(KDWItems.WART_HENNESSY.get())
                .save(output);

        // ==================== 暮色森林联动 ====================
        if (ModList.get().isLoaded("twilightforest")) {
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "firefly")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "liveroot")))
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.CAVE_GLOWBREW.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "mayapple")))
                    .addIngredient(Items.SWEET_BERRIES)
                    .addIngredient(Items.HONEYCOMB)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.DAWNLIGHT_DEW.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "maze_slime_ball")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/knightmetal")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.DEAD_END_SPITTLE.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "liveroot")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "armor_shard")))
                    .addIngredient(Tags.Items.INGOTS_COPPER)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.DRUIDS_SECRET_BREW.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "borer_essence")))
                    .addIngredient(Items.BLAZE_ROD)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.EMBEREYE.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.FROSTHEART_FRUIT_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "arctic_fur")))
                    .addIngredient(KDWItemTags.WINE_BERRY)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.FROSTVEIN_BEASTBLOOD.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(TwilightforestItems.COLOSSAL_FRAGMENT)
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "magic_beans")))
                    .addIngredient(KDWItemTags.WINE_CLOUD)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.GIANTS_HYMN.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(TwilightforestItems.GOBLIN_ESSENCE)
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "root_strand")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "mushgloom")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.GOBLINS_STASH.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "raven_feather")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "root_strand")))
                    .addIngredient(Items.BLAZE_POWDER)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.MOORGLOW_BIRDS_SONG.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.FROSTHEART_FRUIT_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "arctic_fur")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "borer_essence")))
                    .addIngredient(Items.BLUE_ICE)
                    .addIngredient(Items.SNOW_BLOCK)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.PERENNIAL_FROST.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "mushgloom")))
                    .addIngredient(Items.MOSS_BLOCK)
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "venison_jerky")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.RANGERS_SATCHEL.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "naga_scale")))
                    .addIngredient(KDWItemTags.WINE_BERRY)
                    .addIngredient(Items.BLUE_ICE)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.SNAKESKIN_LIQUEUR.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "raw_venison")))
                    .addIngredient(Items.GLOWSTONE_DUST)
                    .addIngredient(Items.APPLE)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.STAGCALL_MONSOON.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
            BarrelBuilder.builder()
                    .setFluid(TwilightforestFluids.TORCHBERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("twilightforest", "thorn_rose")))
                    .addIngredient(TwilightforestItems.FROSTHEART_FRUIT)
                    .addIngredient(Items.SWEET_BERRIES)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TwilightforestItems.THORNHEART.get())
                    .save(output.withConditions(modLoaded("twilightforest")));
        }

        // ==================== 蜜蜂领域联动 ====================
        if (ModList.get().isLoaded("the_bumblezone")) {
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_fluid_still")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "beehive_beeswax")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pollen_puff")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TheBumblezoneItems.BEESWAX_HONEY_WINE.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_still")))
                    .addIngredient(KDWItems.CARBOCRETIN_POWDER)
                    .addIngredient(Items.SUGAR)
                    .addIngredient(Items.ORANGE_DYE)
                    .setCarrier(KDWItems.POP_CAN)
                    .setResult(TheBumblezoneItems.FANTA.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_fluid_still")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "bee_stinger")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pollen_puff")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TheBumblezoneItems.HONEYTHORN_MEAD.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_still")))
                    .addIngredient(KDWItems.CARBOCRETIN_POWDER)
                    .addIngredient(Items.SUGAR)
                    .addIngredient(Items.INK_SAC)
                    .setCarrier(KDWItems.POP_CAN)
                    .setResult(TheBumblezoneItems.PEPSI.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_still")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pile_of_pollen")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pile_of_pollen")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pile_of_pollen")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TheBumblezoneItems.POLLEN_NECTAR.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "royal_jelly_fluid_still")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "royal_jelly_block")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_crystal_shards")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "pollen_puff")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TheBumblezoneItems.ROYAL_HONEY_BREW.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "sugar_water_still")))
                    .addIngredient(KDWItems.CARBOCRETIN_POWDER)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(KDWItems.POP_CAN)
                    .setResult(TheBumblezoneItems.SPRITE.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "honey_fluid_still")))
                    .addIngredient(Items.AMETHYST_SHARD)
                    .addIngredient(Items.AMETHYST_SHARD)
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("the_bumblezone", "glistering_honey_crystal")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(TheBumblezoneItems.SWEET_CRYSTAL_HONEY.get())
                    .save(output.withConditions(modLoaded("the_bumblezone")));
        }

        // ==================== 天境联动 ====================
        if (ModList.get().isLoaded("aether")) {
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "ambrosium_shard")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "aechor_petal")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.DIVINE_ENERGY_MIST.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "zanite_gemstone")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "golden_amber")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.DIVINE_OFFERING_BREW.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "gingerbread_man")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "candy_cane")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.GINGERBREAD_WARMER.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "enchanted_gravitite")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "cold_aercloud")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.GRAVITITE_DRUNK.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "healing_stone")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "white_apple")))
                    .addIngredient(ItemTags.FLOWERS)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.HEALING_ELIXIR.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "swet_ball")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "blue_gummy_swet")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.SWET_FIZZ.get())
                    .save(output.withConditions(modLoaded("aether")));
            BarrelBuilder.builder()
                    .setFluid(AetherFluids.ENCHANTED_BERRY_JUICE.get())
                    .addIngredient(KDWItems.ANGEL_FEATHER)
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "healing_stone")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "ambrosium_shard")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("aether", "golden_amber")))
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(AetherItems.UNBOUND_SKYBORN.get())
                    .save(output.withConditions(modLoaded("aether")));
        }

        // ==================== 永恒星光联动 ====================
        if (ModList.get().isLoaded("eternal_starlight")) {
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "ashen_snowball")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "lunar_grass")))
                    .addIngredient(Items.PHANTOM_MEMBRANE)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.WIND_TRACE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/amaramber")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "starfire")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods/blaze")))
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.ECLIPSE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "banyin_sapling")))
                    .addIngredient(Items.ECHO_SHARD)
                    .addIngredient(Tags.Items.FOODS_FRUIT)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.ABYSS.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "flowglaze")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "blue_starlight_crystal_shard")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "red_starlight_crystal_shard")))
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.AURORA.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/thermal_springstone")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "starfire")))
                    .addIngredient(Items.BLAZE_POWDER)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.BLAZING_SUN.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.SILVER_PUNGENCY_FRUIT_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "red_starlight_crystal_shard")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/amaramber")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "foods/cooked_meat")))
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.BLOOD_MOON.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.ABYSSAL_FRUIT_JUICE.get())
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "gems/glacite")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "reinforced_ice")))
                    .addIngredient(Items.BLUE_ICE)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.DEEP_FREEZE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "ether")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "soul_dew")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "starlit_diamond")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "starfire")))
                    .addIngredient(Items.AMETHYST_SHARD)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.DIVINITY.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "lunaris_cactus_gel")))
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "lunar_grass")))
                    .addIngredient(Items.PHANTOM_MEMBRANE)
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.LUNAR_ECLIPSE.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
            BarrelBuilder.builder()
                    .setFluid(EternalStarlightFluids.LUNAR_BERRIES_JUICE.get())
                    .addIngredient(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("eternal_starlight", "lunaris_cactus_gel")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "gems/starcore")))
                    .addIngredient(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "gems/starlit_diamond")))
                    .addIngredient(Items.SUGAR)
                    .setCarrier(ModItems.EMPTY_BOTTLE)
                    .setResult(EternalStarlightItems.STAR_TRAIL.get())
                    .save(output.withConditions(modLoaded("eternal_starlight")));
        }
    }

}
