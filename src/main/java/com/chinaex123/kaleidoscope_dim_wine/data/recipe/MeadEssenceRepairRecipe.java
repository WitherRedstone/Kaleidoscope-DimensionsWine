package com.chinaex123.kaleidoscope_dim_wine.data.recipe;

import com.chinaex123.kaleidoscope_dim_wine.item.MeadEssence;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MeadEssenceRepairRecipe extends CustomRecipe {

    public MeadEssenceRepairRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(@NotNull CraftingContainer inv, @NotNull Level level) {
        boolean hasEssence = false;
        boolean hasWine = false;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof MeadEssence) {
                    if (hasEssence) return false;
                    if (stack.getDamageValue() == 0) {
                        return false;
                    }
                    hasEssence = true;
                } else {
                    if (hasBrewLevel(stack)) {
                        hasWine = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return hasEssence && hasWine;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer inv, RegistryAccess registryAccess) {
        ItemStack essence = ItemStack.EMPTY;
        int totalQuality = 0;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() instanceof MeadEssence) {
                    essence = stack.copy();
                } else {
                    totalQuality += getBrewLevel(stack);
                }
            }
        }

        if (!essence.isEmpty() && totalQuality > 0) {
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

    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingContainer inv) {
        NonNullList<ItemStack> remaining = super.getRemainingItems(inv);

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack.getItem() instanceof MeadEssence) {
                remaining.set(i, ItemStack.EMPTY);
                break;
            }
        }

        return remaining;
    }

    private boolean hasBrewLevel(ItemStack stack) {
        return stack.hasTag() && stack.getTag().contains("BrewLevel");
    }

    private int getBrewLevel(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains("BrewLevel")) {
            return stack.getTag().getInt("BrewLevel");
        }
        return 0;
    }
}
