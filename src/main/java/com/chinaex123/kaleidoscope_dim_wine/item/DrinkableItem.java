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

/**
 * 可饮用物品
 * <p>支持自定义饮用时长、容器返回和药水效果</p>
 */
public class DrinkableItem extends Item {

    /** 饮用后返回的容器物品（如空瓶） */
    private final ItemStack containerItem;

    /** 饮用持续时间（tick） */
    private final int useDuration;

    /** 饮用后获得的药水效果列表 */
    private final List<MobEffectInstance> effects;

    /**
     * 构造可饮用物品（默认配置）
     *
     * @param properties 物品属性
     */
    public DrinkableItem(Properties properties) {
        this(properties, null, 32, List.of());
    }

    /**
     * 构造可饮用物品（带容器）
     *
     * @param properties   物品属性
     * @param containerItem 饮用后返回的容器物品
     */
    public DrinkableItem(Properties properties, ItemStack containerItem) {
        this(properties, containerItem, 32, List.of());
    }

    /**
     * 构造可饮用物品（带容器和自定义时长）
     *
     * @param properties   物品属性
     * @param containerItem 饮用后返回的容器物品
     * @param useDuration  饮用持续时间（tick）
     */
    public DrinkableItem(Properties properties, ItemStack containerItem, int useDuration) {
        this(properties, containerItem, useDuration, List.of());
    }

    /**
     * 构造可饮用物品（完整配置）
     *
     * @param properties   物品属性
     * @param containerItem 饮用后返回的容器物品
     * @param useDuration  饮用持续时间（tick）
     * @param effects      饮用后获得的药水效果列表
     */
    public DrinkableItem(Properties properties, ItemStack containerItem, int useDuration, List<MobEffectInstance> effects) {
        super(properties);
        this.containerItem = containerItem;
        this.useDuration = useDuration;
        this.effects = effects;
    }

    /**
     * 完成饮用时的处理
     * <p>应用药水效果并返回容器物品</p>
     *
     * @param stack  当前物品堆
     * @param level  等级
     * @param entity 使用物品的实体
     * @return 使用后的物品堆
     */
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

    /**
     * 获取饮用持续时间
     *
     * @param stack  物品堆
     * @return 饮用持续时间（tick）
     */
    @Override
    public int getUseDuration(ItemStack stack) {
        return useDuration;
    }

    /**
     * 获取使用动画类型
     *
     * @param stack 物品堆
     * @return 饮用动画
     */
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
