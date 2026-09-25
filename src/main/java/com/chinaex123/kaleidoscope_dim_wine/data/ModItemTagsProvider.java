package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, KaleidoscopeDimensionsWine.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        /* 酒柜异形酒瓶名单，这种类型的酒只允许放入一瓶 */
        tag(TagMod.BAR_CABINET_IRREGULAR)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));
        /* 窖藏酒柜黑名单，即不允许放入窖藏酒柜的酒 */
        tag(TagMod.CELLAR_CABINET_BLOCKLIST)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("rangers_satchel"))
                .addOptional(KaleidoscopeDimensionsWine.id("embereye"))
                .addOptional(KaleidoscopeDimensionsWine.id("stagcall_monsoon"))
                .addOptional(KaleidoscopeDimensionsWine.id("thornheart"))
                .addOptional(KaleidoscopeDimensionsWine.id("perennial_frost"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));
        /* 倾斜酒架黑名单，即不允许放入倾斜酒架的酒 */
        tag(TagMod.TILTED_RACK_BLOCKLIST)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));
        /* 圆周酒架黑名单，即不允许放入圆周酒架的酒 */
        tag(TagMod.CIRCULAR_RACK_BLOCKLIST)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));
        /* 单体酒架黑名单，即不允许放入单体酒架的酒 */
        tag(TagMod.HOLDER_BLOCKLIST)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));

        /* 鸡尾酒原料颜色分类 */
        // 黑色
        tag(TagMod.COCKTAIL_INGREDIENT_BLACK)
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"));
        // 深蓝色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_BLUE)
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"));
        // 深绿色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_GREEN);
        // 深青色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_AQUA)
                .add(KDWItems.ETHEREAL_NOBLE.get());
        // 深红色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_RED)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("crimson_crescendo"))
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("thornheart"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("blood_moon"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("rangers_satchel"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));
        // 深紫色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_PURPLE)
                .add(KDWItems.CHORUS_COGNAC.get())
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("druids_secret_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("aurora"));
        // 金色
        tag(TagMod.COCKTAIL_INGREDIENT_GOLD)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.DIVINE_EMBRYO_PORT.get())
                .addOptional(KaleidoscopeDimensionsWine.id("snakeskin_liqueur"))
                .addOptional(KaleidoscopeDimensionsWine.id("moorglow_birds_song"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))
                .addOptional(KaleidoscopeDimensionsWine.id("fanta"))
                .addOptional(KaleidoscopeDimensionsWine.id("divinity"));
        // 灰色
        tag(TagMod.COCKTAIL_INGREDIENT_GRAY)
                .addOptional(KaleidoscopeDimensionsWine.id("cave_glowbrew"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"));
        // 深灰色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_GRAY)
                .add(KDWItems.BLACK_BONE_LAFITE.get())
                .add(KDWItems.ABYSSAL_PORTER.get())
                .add(KDWItems.END_STARLIGHT.get());
        // 蓝色
        tag(TagMod.COCKTAIL_INGREDIENT_BLUE)
                .addOptional(KaleidoscopeDimensionsWine.id("swet_fizz"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"));
        // 绿色
        tag(TagMod.COCKTAIL_INGREDIENT_GREEN)
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("sprite"));
        // 青色
        tag(TagMod.COCKTAIL_INGREDIENT_AQUA)
                .addOptional(KaleidoscopeDimensionsWine.id("perennial_frost"))
                .addOptional(KaleidoscopeDimensionsWine.id("stagcall_monsoon"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"));
        // 红色
        tag(TagMod.COCKTAIL_INGREDIENT_RED)
                .add(KDWItems.WART_HENNESSY.get())
                .addOptional(KaleidoscopeDimensionsWine.id("gravitite_drunk"));
        // 浅紫色
        tag(TagMod.COCKTAIL_INGREDIENT_LIGHT_PURPLE)
                .add(KDWItems.SILENT_SHERRY.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get());
        // 黄色
        tag(TagMod.COCKTAIL_INGREDIENT_YELLOW)
                .addOptional(KaleidoscopeDimensionsWine.id("embereye"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_energy_mist"));
        // 白色
        tag(TagMod.COCKTAIL_INGREDIENT_WHITE)
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("pepsi"))
                .addOptional(KaleidoscopeDimensionsWine.id("wind_trace"));


        // 葡萄
        tag(KDWItemTags.GRAPES)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get());
        // 水果
        tag(KDWItemTags.FRUITS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(KaleidoscopeDimensionsWine.id("frostheart_fruit"));
        tag(KDWItemTags.FRUITS_CRIMSON_GRAPE).add(KDWItems.CRIMSON_GRAPE.get());
        tag(KDWItemTags.FRUITS_WARPED_GRAPE).add(KDWItems.WARPED_GRAPE.get());
        tag(KDWItemTags.FRUITS_DREAMFRUIT).add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.FRUITS_FROSTHEART).addOptional(KaleidoscopeDimensionsWine.id("frostheart_fruit"));
        tag(KDWItemTags.HOPS).add(KDWItems.HOP.get());
        tag(KDWItemTags.CROPS_HOP).add(KDWItems.HOP.get());
        tag(KDWItemTags.SEEDS_HOP).add(KDWItems.HOP_SEED.get());

        // 均衡饮食
        tag(KDWItemTags.FRUITS_DIET)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(KaleidoscopeDimensionsWine.id("frostheart_fruit"));

        // 静谧四季
        tag(KDWItemTags.YEAR_ROUND_CROPS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.SUMMER_CROPS)
                .add(KDWItems.HOP_SEED.get());
        tag(KDWItemTags.WINTER_CROPS)
                .addOptional(KaleidoscopeDimensionsWine.id("frostheart_fruit"));

        // 机械动力
        tag(KDWItemTags.UPRIGHT_ON_BELT)
                .add(KDWItems.POP_CAN.get())
                .add(KDWItems.CRIMSON_CRESCENDO.get())
                .add(KDWItems.ETHEREAL_NOBLE.get())
                .add(KDWItems.WART_HENNESSY.get())
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.BLACK_BONE_LAFITE.get())
                .add(KDWItems.CHORUS_COGNAC.get())
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .add(KDWItems.ABYSSAL_PORTER.get())
                .add(KDWItems.SILENT_SHERRY.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get())
                .add(KDWItems.END_STARLIGHT.get())
                .add(KDWItems.DIVINE_EMBRYO_PORT.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("cave_glowbrew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("snakeskin_liqueur"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("rangers_satchel"))
                .addOptional(KaleidoscopeDimensionsWine.id("embereye"))
                .addOptional(KaleidoscopeDimensionsWine.id("stagcall_monsoon"))
                .addOptional(KaleidoscopeDimensionsWine.id("thornheart"))
                .addOptional(KaleidoscopeDimensionsWine.id("druids_secret_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("moorglow_birds_song"))
                .addOptional(KaleidoscopeDimensionsWine.id("perennial_frost"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("sprite"))
                .addOptional(KaleidoscopeDimensionsWine.id("pepsi"))
                .addOptional(KaleidoscopeDimensionsWine.id("fanta"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_energy_mist"))
                .addOptional(KaleidoscopeDimensionsWine.id("swet_fizz"))
                .addOptional(KaleidoscopeDimensionsWine.id("gravitite_drunk"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("aurora"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("blood_moon"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"))
                .addOptional(KaleidoscopeDimensionsWine.id("wind_trace"));

        // 葡园酒香柜子 - 小瓶酒
        tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                .add(KDWItems.POP_CAN.get())
                .add(KDWItems.CRIMSON_CRESCENDO.get())
                .add(KDWItems.ETHEREAL_NOBLE.get())
                .add(KDWItems.WART_HENNESSY.get())
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.BLACK_BONE_LAFITE.get())
                .add(KDWItems.CHORUS_COGNAC.get())
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .add(KDWItems.ABYSSAL_PORTER.get())
                .add(KDWItems.SILENT_SHERRY.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get())
                .add(KDWItems.END_STARLIGHT.get())
                .add(KDWItems.DIVINE_EMBRYO_PORT.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("cave_glowbrew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("snakeskin_liqueur"))
                .addOptional(KaleidoscopeDimensionsWine.id("rangers_satchel"))
                .addOptional(KaleidoscopeDimensionsWine.id("embereye"))
                .addOptional(KaleidoscopeDimensionsWine.id("stagcall_monsoon"))
                .addOptional(KaleidoscopeDimensionsWine.id("thornheart"))
                .addOptional(KaleidoscopeDimensionsWine.id("druids_secret_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("moorglow_birds_song"))
                .addOptional(KaleidoscopeDimensionsWine.id("perennial_frost"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("sprite"))
                .addOptional(KaleidoscopeDimensionsWine.id("pepsi"))
                .addOptional(KaleidoscopeDimensionsWine.id("fanta"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_energy_mist"))
                .addOptional(KaleidoscopeDimensionsWine.id("swet_fizz"))
                .addOptional(KaleidoscopeDimensionsWine.id("gravitite_drunk"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("aurora"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("blood_moon"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("wind_trace"));
        // 大瓶酒
        tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                .addOptional(KaleidoscopeDimensionsWine.id("dead_end_spittle"))
                .addOptional(KaleidoscopeDimensionsWine.id("frostvein_beastblood"))
                .addOptional(KaleidoscopeDimensionsWine.id("giants_hymn"))
                .addOptional(KaleidoscopeDimensionsWine.id("pollen_nectar"))
                .addOptional(KaleidoscopeDimensionsWine.id("honeythorn_mead"))
                .addOptional(KaleidoscopeDimensionsWine.id("beeswax_honey_wine"))
                .addOptional(KaleidoscopeDimensionsWine.id("sweet_crystal_honey"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_offering_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("gingerbread_warmer"))

                .addOptional(KaleidoscopeDimensionsWine.id("divinity"))
                .addOptional(KaleidoscopeDimensionsWine.id("lunar_eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("deep_freeze"))
                .addOptional(KaleidoscopeDimensionsWine.id("blazing_sun"));

        // 幻想乡乐事柜子
        tag(KDWItemTags.YOUKAISFEASTS_WINE)
                .add(KDWItems.POP_CAN.get())
                .add(KDWItems.CRIMSON_CRESCENDO.get())
                .add(KDWItems.ETHEREAL_NOBLE.get())
                .add(KDWItems.WART_HENNESSY.get())
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .add(KDWItems.BLACK_BONE_LAFITE.get())
                .add(KDWItems.CHORUS_COGNAC.get())
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .add(KDWItems.ABYSSAL_PORTER.get())
                .add(KDWItems.SILENT_SHERRY.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get())
                .add(KDWItems.END_STARLIGHT.get())
                .add(KDWItems.DIVINE_EMBRYO_PORT.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(KaleidoscopeDimensionsWine.id("cave_glowbrew"))
                .addOptional(KaleidoscopeDimensionsWine.id("dawnlight_dew"))
                .addOptional(KaleidoscopeDimensionsWine.id("snakeskin_liqueur"))
                .addOptional(KaleidoscopeDimensionsWine.id("rangers_satchel"))
                .addOptional(KaleidoscopeDimensionsWine.id("embereye"))
                .addOptional(KaleidoscopeDimensionsWine.id("stagcall_monsoon"))
                .addOptional(KaleidoscopeDimensionsWine.id("thornheart"))
                .addOptional(KaleidoscopeDimensionsWine.id("druids_secret_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("moorglow_birds_song"))
                .addOptional(KaleidoscopeDimensionsWine.id("perennial_frost"))
                .addOptional(KaleidoscopeDimensionsWine.id("goblins_stash"))
                .addOptional(KaleidoscopeDimensionsWine.id("sprite"))
                .addOptional(KaleidoscopeDimensionsWine.id("pepsi"))
                .addOptional(KaleidoscopeDimensionsWine.id("fanta"))
                .addOptional(KaleidoscopeDimensionsWine.id("royal_honey_brew"))
                .addOptional(KaleidoscopeDimensionsWine.id("divine_energy_mist"))
                .addOptional(KaleidoscopeDimensionsWine.id("swet_fizz"))
                .addOptional(KaleidoscopeDimensionsWine.id("gravitite_drunk"))
                .addOptional(KaleidoscopeDimensionsWine.id("healing_elixir"))
                .addOptional(KaleidoscopeDimensionsWine.id("unbound_skyborn"))

                .addOptional(KaleidoscopeDimensionsWine.id("star_trail"))
                .addOptional(KaleidoscopeDimensionsWine.id("aurora"))
                .addOptional(KaleidoscopeDimensionsWine.id("eclipse"))
                .addOptional(KaleidoscopeDimensionsWine.id("blood_moon"))
                .addOptional(KaleidoscopeDimensionsWine.id("abyss"))
                .addOptional(KaleidoscopeDimensionsWine.id("wind_trace"));

        // 巨物碎片
        tag(KDWItemTags.COLOSSAL)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_sword"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_pickaxe"));
        // 酿酒的水果
        tag(KDWItemTags.WINE_BERRY)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "raspberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blueberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blackberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "maloberry"));
        // 酿酒的云
        tag(KDWItemTags.WINE_CLOUD)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "wispy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "fluffy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "rainy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "snowy_cloud"));
    }
}
