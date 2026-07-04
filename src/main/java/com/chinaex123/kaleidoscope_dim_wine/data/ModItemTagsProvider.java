package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
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
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"));
        /* 窖藏酒柜黑名单，即不允许放入窖藏酒柜的酒 */
        tag(TagMod.CELLAR_CABINET_BLOCKLIST);
        /* 倾斜酒架黑名单，即不允许放入倾斜酒架的酒 */
        tag(TagMod.TILTED_RACK_BLOCKLIST)
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"));
        /* 圆周酒架黑名单，即不允许放入圆周酒架的酒 */
        tag(TagMod.CIRCULAR_RACK_BLOCKLIST)
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"));
        /* 单体酒架黑名单，即不允许放入单体酒架的酒 */
        tag(TagMod.HOLDER_BLOCKLIST)
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"));

        /* 鸡尾酒原料颜色分类 */
        // 黑色
        tag(TagMod.COCKTAIL_INGREDIENT_BLACK);
        // 深蓝色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_BLUE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "goblins_stash"));
        // 深绿色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_GREEN);
        // 深青色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_AQUA)
                .add(KDWItems.ETHEREAL_NOBLE.get());
        // 深红色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_RED)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.MAGMA_ROYAL_SALUTE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "crimson_crescendo"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "thornheart"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "rangers_satchel"));
        // 深紫色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_PURPLE)
                .add(KDWItems.CHORUS_COGNAC.get())
                .add(KDWItems.DRAGONS_BREATH_BRANDY.get())
                .add(KDWItems.DRACONIC_BLOOD_WINE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "druids_secret_brew"));
        // 金色
        tag(TagMod.COCKTAIL_INGREDIENT_GOLD)
                .add(KDWItems.BLAZE_MARTELL.get())
                .add(KDWItems.DIVINE_EMBRYO_PORT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "unbound_skyborn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "fanta"));
        // 灰色
        tag(TagMod.COCKTAIL_INGREDIENT_GRAY)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"));
        // 深灰色
        tag(TagMod.COCKTAIL_INGREDIENT_DARK_GRAY)
                .add(KDWItems.BLACK_BONE_LAFITE.get())
                .add(KDWItems.ABYSSAL_PORTER.get())
                .add(KDWItems.END_STARLIGHT.get());
        // 蓝色
        tag(TagMod.COCKTAIL_INGREDIENT_BLUE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"));
        // 绿色
        tag(TagMod.COCKTAIL_INGREDIENT_GREEN)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sprite"));
        // 青色
        tag(TagMod.COCKTAIL_INGREDIENT_AQUA)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "stagcall_monsoon"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"));
        // 红色
        tag(TagMod.COCKTAIL_INGREDIENT_RED)
                .add(KDWItems.WART_HENNESSY.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gravitite_drunk"));
        // 浅紫色
        tag(TagMod.COCKTAIL_INGREDIENT_LIGHT_PURPLE)
                .add(KDWItems.SILENT_SHERRY.get())
                .add(KDWItems.FORGOTTEN_MARGARITA.get())
                .add(KDWItems.PHANTOM_DREAM_BUBBLE.get());
        // 黄色
        tag(TagMod.COCKTAIL_INGREDIENT_YELLOW)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_energy_mist"));
        // 白色
        tag(TagMod.COCKTAIL_INGREDIENT_WHITE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pepsi"));



        // 葡萄
        tag(KDWItemTags.GRAPES)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get());
        // 水果
        tag(KDWItemTags.FRUITS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit"));
        tag(KDWItemTags.FRUITS_CRIMSON_GRAPE).add(KDWItems.CRIMSON_GRAPE.get());
        tag(KDWItemTags.FRUITS_WARPED_GRAPE).add(KDWItems.WARPED_GRAPE.get());
        tag(KDWItemTags.FRUITS_DREAMFRUIT).add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.FRUITS_FROSTHEART).addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit"));
        tag(KDWItemTags.HOPS).add(KDWItems.HOP.get());
        tag(KDWItemTags.CROPS_HOP).add(KDWItems.HOP.get());
        tag(KDWItemTags.SEEDS_HOP).add(KDWItems.HOP_SEED.get());

        // 均衡饮食
        tag(KDWItemTags.FRUITS_DIET)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit"));

        // 静谧四季
        tag(KDWItemTags.YEAR_ROUND_CROPS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.SUMMER_CROPS)
                .add(KDWItems.HOP_SEED.get());
        tag(KDWItemTags.WINTER_CROPS)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostheart_fruit"));

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
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "stagcall_monsoon"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "thornheart"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "unbound_skyborn"));

        // 葡园酒香柜子 - 小瓶酒
        tag(KDWItemTags.VINERY_SMALL_BOTTLE)
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
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "unbound_skyborn"));
        // 大瓶酒
        tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "magma_royal_salute"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "stagcall_monsoon"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "thornheart"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "giants_hymn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gingerbread_warmer"));

        // 幻想乡乐事柜子
        tag(KDWItemTags.YOUKAISFEASTS_WINE)
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
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionsWine.MOD_ID, "unbound_skyborn"));

        // 巨物碎片
        tag(KDWItemTags.COLOSSAL)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_sword"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "giant_pickaxe"));
        // 酿酒的水果
        tag(KDWItemTags.WINE_BERRY)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "raspberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blueberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "blackberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "maloberry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "torchberries"));
        // 酿酒的云
        tag(KDWItemTags.WINE_CLOUD)
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "wispy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "fluffy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "rainy_cloud"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("twilightforest", "snowy_cloud"));
    }
}
