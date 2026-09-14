package com.chinaex123.kaleidoscope_dim_wine.item;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.github.ysbbbbbb.kaleidoscopetavern.item.DrinkBlockItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * 易拉罐饮料物品类
 * <p>
 * 在饮用完成后将空易拉罐返还给玩家。
 */
public class PopCanDrinkItem extends DrinkBlockItem {

    /**
     * 构造易拉罐饮料物品
     *
     * @param block 关联的方块
     */
    public PopCanDrinkItem(Block block) {
        super(block);
    }

    /**
     * 完成使用物品时的处理
     * <p>
     * 当玩家饮用完饮料后，消耗饮料并将空易拉罐返还给玩家
     *
     * @param stack 被使用的物品栈
     * @param level 世界对象
     * @param entity 使用物品的实体
     * @return 使用后剩余的物品栈
     */
    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // 调用父类的状态效果添加方法
        this.addDrinkEffect(stack, level, entity);

        // 仅在服务端处理，且使用者必须是玩家
        if (!level.isClientSide() && entity instanceof Player player) {
            // 消耗一个饮料物品
            stack.shrink(1);

            // 创建空易拉罐物品
            ItemStack popCan = new ItemStack(KDWItems.POP_CAN.get());

            // 如果饮料已被完全消耗（物品栈为空），直接返回空罐
            if (stack.isEmpty()) {
                return popCan;
            }

            // 否则将空罐添加到玩家背包
            player.getInventory().add(popCan);
        }
        // 返回剩余物品栈
        return stack;
    }
}