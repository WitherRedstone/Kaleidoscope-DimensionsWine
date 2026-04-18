package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.item.MeadEssence;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class MeadEssenceRepairRecipe extends CustomRecipe {

    public MeadEssenceRepairRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(@NotNull CraftingInput input, @NotNull Level level) {
        boolean hasEssence = false;
        boolean hasWine = false;

        // 遍历合成输入中的所有物品
        for (ItemStack stack : input.items()) {
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof MeadEssence) {
                    if (hasEssence) return false; // 只能有一个精华

                    // 如果精华耐久是满的，则不允许合成
                    if (stack.getDamageValue() == 0) {
                        return false;
                    }

                    hasEssence = true;
                } else {
                    // 检查是否有酒的品质组件
                    if (hasBrewLevel(stack)) {
                        hasWine = true;
                    } else {
                        return false; // 不允许有其他无关物品
                    }
                }
            }
        }
        return hasEssence && hasWine;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingInput input, HolderLookup.Provider registries) {
        ItemStack essence = ItemStack.EMPTY;
        int totalQuality = 0;

        for (ItemStack stack : input.items()) {
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof MeadEssence) {
                    essence = stack.copy();
                } else {
                    totalQuality += getBrewLevel(stack);
                }
            }
        }

        if (!essence.isEmpty() && totalQuality > 0) {
            // 修复耐久：当前耐久值 - 品质总和
            int currentDamage = essence.getDamageValue();
            int newDamage = Math.max(0, currentDamage - totalQuality);
            essence.setDamageValue(newDamage);
        }

        return essence;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipes.MEAD_ESSENCE_REPAIR_SERIALIZER.get();
    }

    // 关键方法：定义合成后各个格子的剩余物品
    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingInput input) {
        // 1. 先获取默认的处理结果（通常这会保留所有物品，包括容器）
        NonNullList<ItemStack> remaining = super.getRemainingItems(input);

        // 2. 遍历输入，找到蜜酒精华的位置，将其手动设为“消耗”（EMPTY）
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.getItem() instanceof MeadEssence) {
                remaining.set(i, ItemStack.EMPTY); // 只有精华被消耗
                break;
            }
        }

        return remaining;
    }

    // 辅助方法：检查是否有品质
    private boolean hasBrewLevel(ItemStack stack) {
        Optional<DataComponentType<?>> opt = BuiltInRegistries.DATA_COMPONENT_TYPE.getOptional(
                ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "brew_level")
        );
        return opt.isPresent() && stack.has(opt.get());
    }

    // 辅助方法：获取品质等级
    @SuppressWarnings("unchecked")
    private int getBrewLevel(ItemStack stack) {
        Optional<DataComponentType<?>> opt = BuiltInRegistries.DATA_COMPONENT_TYPE.getOptional(
                ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "brew_level")
        );
        if (opt.isEmpty()) return 0;
        DataComponentType<Integer> type = (DataComponentType<Integer>) (Object) opt.get();
        return stack.getOrDefault(type, 0);
    }
}
