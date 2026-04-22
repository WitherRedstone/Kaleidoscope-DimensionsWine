package com.chinaex123.kaleidoscope_dim_wine.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DrinkableItem extends Item {
    private final ItemStack containerItem;
    private final int useDuration;
    private final List<MobEffectInstance> effects;

    public DrinkableItem(Properties properties) {
        this(properties, null, 32, List.of());
    }

    public DrinkableItem(Properties properties, ItemStack containerItem) {
        this(properties, containerItem, 32, List.of());
    }

    public DrinkableItem(Properties properties, ItemStack containerItem, int useDuration) {
        this(properties, containerItem, useDuration, List.of());
    }

    public DrinkableItem(Properties properties, ItemStack containerItem, int useDuration, List<MobEffectInstance> effects) {
        super(properties);
        this.containerItem = containerItem;
        this.useDuration = useDuration;
        this.effects = effects;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {
            for (MobEffectInstance effect : effects) {
                entity.addEffect(new MobEffectInstance(effect));
            }
        }
        ItemStack result = super.finishUsingItem(stack, level, entity);
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            if (containerItem != null) {
                if (stack.isEmpty()) {
                    return containerItem.copy();
                }
                player.getInventory().add(containerItem.copy());
            }
        }
        return result;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return useDuration;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
