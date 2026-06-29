package com.chinaex123.kaleidoscope_dim_wine.data;

import com.chinaex123.kaleidoscope_dim_wine.KaleidoscopeDimensionsWine;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItemTags;
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

        // 葡萄
        tag(KDWItemTags.GRAPES)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get());
        // 水果
        tag(KDWItemTags.FRUITS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit"));
        tag(KDWItemTags.FRUITS_CRIMSON_GRAPE).add(KDWItems.CRIMSON_GRAPE.get());
        tag(KDWItemTags.FRUITS_WARPED_GRAPE).add(KDWItems.WARPED_GRAPE.get());
        tag(KDWItemTags.FRUITS_DREAMFRUIT).add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.FRUITS_FROSTHEART).addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit"));

        tag(KDWItemTags.HOPS).add(KDWItems.HOP.get());
        tag(KDWItemTags.CROPS_HOP).add(KDWItems.HOP.get());
        tag(KDWItemTags.SEEDS_HOP).add(KDWItems.HOP_SEED.get());

        // 均衡饮食
        tag(KDWItemTags.FRUITS_DIET)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit"));

        // 静谧四季
        tag(KDWItemTags.YEAR_ROUND_CROPS)
                .add(KDWItems.CRIMSON_GRAPE.get())
                .add(KDWItems.WARPED_GRAPE.get())
                .add(KDWItems.DREAMFRUIT.get());
        tag(KDWItemTags.SUMMER_CROPS)
                .add(KDWItems.HOP_SEED.get());
        tag(KDWItemTags.WINTER_CROPS)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostheart_fruit"));

        // 机械动力
        tag(KDWItemTags.UPRIGHT_ON_BELT)
                .add(KDWItems.POP_CAN.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "crimson_crescendo"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "ethereal_noble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wart_hennessy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "blaze_martell"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "magma_royal_salute"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "black_bone_lafite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "chorus_cognac"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dragons_breath_brandy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "abyssal_porter"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "silent_sherry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "forgotten_margarita"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "phantom_dream_bubble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "end_starlight"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_embryo_port"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "draconic_blood_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "stagcall_monsoon"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "thornheart"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "giants_hymn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "gingerbread_warmer"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "unbound_skyborn"));

        // 葡园酒香柜子 - 小瓶酒
        tag(KDWItemTags.VINERY_SMALL_BOTTLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "crimson_crescendo"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "ethereal_noble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wart_hennessy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "blaze_martell"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "black_bone_lafite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "chorus_cognac"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dragons_breath_brandy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "abyssal_porter"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "silent_sherry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "forgotten_margarita"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "phantom_dream_bubble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "end_starlight"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_embryo_port"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "draconic_blood_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "unbound_skyborn"));
        // 大瓶酒
        tag(KDWItemTags.VINERY_LARGE_BOTTLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "magma_royal_salute"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dawnlight_dew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dead_end_spittle"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "frostvein_beastblood"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "stagcall_monsoon"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "thornheart"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "giants_hymn"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_offering_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "gingerbread_warmer"));

        // 幻想乡乐事柜子
        tag(KDWItemTags.YOUKAISFEASTS_WINE)
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "crimson_crescendo"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "ethereal_noble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "wart_hennessy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "blaze_martell"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "black_bone_lafite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "chorus_cognac"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "dragons_breath_brandy"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "abyssal_porter"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "silent_sherry"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "forgotten_margarita"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "phantom_dream_bubble"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "end_starlight"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_embryo_port"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "draconic_blood_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "cave_glowbrew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "snakeskin_liqueur"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "rangers_satchel"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "embereye"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "druids_secret_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "moorglow_birds_song"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "perennial_frost"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "goblins_stash"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sprite"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pepsi"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "fanta"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "pollen_nectar"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "honeythorn_mead"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "beeswax_honey_wine"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "sweet_crystal_honey"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "royal_honey_brew"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "divine_energy_mist"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "swet_fizz"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "gravitite_drunk"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "healing_elixir"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("kaleidoscope_dim_wine", "unbound_skyborn"));

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
