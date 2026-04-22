package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.chinaex123.kaleidoscope_dim_wine.init.compat.Twilightforest.TwilightforestItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput p0utput) {
        super(p0utput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeOutput) {
        // ==================== 小彩蛋 ====================
        // 玩偶 - ChinaEX123_BILI
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DOLL_001.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.LIGHT_BLUE_WOOL)
                .unlockedBy("has_doll_1", has(Items.LIGHT_BLUE_WOOL))
                .save(recipeOutput);
        // 玩偶 - Fvue233
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DOLL_002.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.PINK_WOOL)
                .unlockedBy("has_doll_2", has(Items.PINK_WOOL))
                .save(recipeOutput);
        // 玩偶 - Agens_Eland
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DOLL_003.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Items.MAGENTA_WOOL)
                .unlockedBy("has_doll_3", has(Items.MAGENTA_WOOL))
                .save(recipeOutput);

        // ==================== 次元维度 - 小装饰 ====================
        // 小灯串（潜影贝-无色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get(),8)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_WHITE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.WHITE_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-橙色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_ORANGE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.ORANGE_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_orange_dye", has(Items.ORANGE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-品红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_MAGENTA.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.MAGENTA_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-淡蓝色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_BLUE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIGHT_BLUE_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_light_blue_dye", has(Items.LIGHT_BLUE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黄色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_YELLOW.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.YELLOW_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黄绿色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIME.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIME_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-粉红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PINK.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.PINK_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-灰色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GRAY.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GRAY_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_gray_dye", has(Items.GRAY_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-淡灰色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_LIGHT_GRAY.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.LIGHT_GRAY_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_light_gray_dye", has(Items.LIGHT_GRAY_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-青色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_CYAN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.CYAN_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-紫色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_PURPLE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.PURPLE_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_purple_dye", has(Items.PURPLE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-蓝色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLUE.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BLUE_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-棕色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BROWN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BROWN_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_brown_dye", has(Items.BROWN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-绿色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_GREEN.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GREEN_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-红色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_RED.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.RED_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_red_dye", has(Items.RED_DYE))
                .save(recipeOutput);
        // 小灯串（潜影贝-黑色）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_SHULKER_BLACK.get(), 8)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.BLACK_DYE)
                .define('B', ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get())
                .unlockedBy("has_string_lights_entity_shulker", has(ModBlocks.STRING_LIGHTS_ENTITY_SHULKER.get()))
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE))
                .save(recipeOutput);
        // 小灯串（小鸡仔）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_CHICKEN.get(),8)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRING_LIGHTS_ENTITY_BEE.get(),8)
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DRAGON_BLOOD_BOTTLE.get(),4)
                .requires(ModItems.DRAGON_BLOOD_BUCKET.get())
                .requires(Items.GLASS_BOTTLE,4 )
                .unlockedBy("has_dragon_blood_bucket", has(ModItems.DRAGON_BLOOD_BUCKET.get()))
                .save(recipeOutput);
        // 巨物碎片
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition("twilightforest"))
                .addRecipe(shapelessRecipe -> ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TwilightforestItems.COLOSSAL_FRAGMENT.get(),16)
                        .requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal")))
                        .unlockedBy("has_colossal", has(ItemTags.create(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal"))))
                        .save(shapelessRecipe))
                .build(recipeOutput, ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "colossal_fragment_from_colossal"));
        // 天使之羽
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANGEL_FEATHER.get(),8)
                .requires(ModItems.ANGEL_WINGS.get())
                .unlockedBy("has_angel_wings", has(ModItems.ANGEL_WINGS.get()))
                .save(recipeOutput);

        // 易拉罐
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POP_CAN.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.GLASS_BOTTLE)
                .define('B', Tags.Items.NUGGETS_IRON)
                .unlockedBy("has_pop_can_glass_bottle", has(Items.GLASS_BOTTLE))
                .unlockedBy("has_pop_can_nuggets_iron", has(Tags.Items.NUGGETS_IRON))
                .save(recipeOutput);
    }
}
