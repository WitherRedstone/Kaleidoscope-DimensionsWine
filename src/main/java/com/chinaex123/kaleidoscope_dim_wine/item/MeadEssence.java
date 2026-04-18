package com.chinaex123.kaleidoscope_dim_wine.item;

import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.BarrelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * 蜜酒精华 - 右键酿酒桶提升酿造品质
 */
public class MeadEssence extends Item {

    public MeadEssence() {
        super(new Properties().stacksTo(1).durability(10).rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        // 当耐久耗尽时，返回一个带有最大耐久的物品
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
            return itemStack.copy();
        }
        return ItemStack.EMPTY;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack handStack = context.getItemInHand();

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        // 检查物品是否已耗尽
        if (handStack.getDamageValue() >= handStack.getMaxDamage()) {
            if (player != null) {
                player.displayClientMessage(Component.translatable("message.kaleidoscope_dim_wine.mead_essence.depleted")
                        .withStyle(style -> style.withColor(TextColor.parseColor("#AAAAAA").getOrThrow())), true);
            }
            return InteractionResult.PASS;
        }

        BlockState state = level.getBlockState(pos);

        if (!(state.getBlock() instanceof BarrelBlock barrelBlock)) {
            return InteractionResult.PASS;
        }

        try {
            // 获取 BlockEntity 实例
            var getBarrelMethod = barrelBlock.getClass().getMethod("getBarrelEntity", Level.class, BlockPos.class, BlockState.class);
            Object barrelEntityObj = getBarrelMethod.invoke(barrelBlock, level, pos, state);

            if (barrelEntityObj == null) {
                return InteractionResult.PASS;
            }

            // 获取输出物品处理器
            var outputMethod = barrelEntityObj.getClass().getMethod("getOutput");
            ItemStackHandler output = (ItemStackHandler) outputMethod.invoke(barrelEntityObj);

            if (output == null) {
                return InteractionResult.PASS;
            }

            ItemStack barrelStack = output.getStackInSlot(0);

            if (barrelStack.isEmpty()) {
                if (player != null) {
                    player.displayClientMessage(Component.translatable("message.kaleidoscope_dim_wine.mead_essence.no_brew")
                            .withStyle(style -> style.withColor(TextColor.parseColor("#FF5555").getOrThrow())), true);
                }
                return InteractionResult.PASS;
            }

            // 获取 brew_level 组件类型
            Optional<DataComponentType<?>> brewLevelOpt = BuiltInRegistries.DATA_COMPONENT_TYPE.getOptional(
                    ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "brew_level")
            );

            if (brewLevelOpt.isEmpty()) {
                return InteractionResult.PASS;
            }

            DataComponentType<Integer> brewLevelType = (DataComponentType<Integer>) (Object) brewLevelOpt.get();

            // 通过反射找到并读取方块内部的 brewLevel 字段（权威数据源）
            java.lang.reflect.Field brewField = null;
            java.lang.reflect.Field[] fields = barrelEntityObj.getClass().getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                if (field.getType() == int.class && field.getName().toLowerCase().contains("brew")) {
                    field.setAccessible(true);
                    brewField = field;
                    break;
                }
            }

            // 优先使用方块内部的等级，如果没有则使用物品组件的等级
            int currentLevel = 0;
            if (brewField != null) {
                currentLevel = brewField.getInt(barrelEntityObj);
            } else {
                currentLevel = barrelStack.getOrDefault(brewLevelType, 0);
            }

            if (currentLevel >= 7) {
                if (player != null) {
                    player.displayClientMessage(Component.translatable("message.kaleidoscope_dim_wine.mead_essence.max_quality")
                            .withStyle(style -> style.withColor(TextColor.parseColor("#FFFF55").getOrThrow())), true);
                }
                return InteractionResult.PASS;
            }

            // 计算新等级：在当前真实品质的基础上 +1
            int increaseAmount = currentLevel == 0 ? 2 : 1;
            int newLevel = Math.min(currentLevel + increaseAmount, 7);

            // 先改方块内部字段，再改物品组件，防止自动逻辑覆盖
            if (brewField != null) {
                brewField.setInt(barrelEntityObj, newLevel);
            }

            barrelStack.set(brewLevelType, newLevel);
            output.setStackInSlot(0, barrelStack);

            // 标记更改并强制同步
            if (barrelEntityObj instanceof net.minecraft.world.level.block.entity.BlockEntity be) {
                be.setChanged();
            }

            level.getChunkAt(pos).setUnsaved(true);
            level.sendBlockUpdated(pos, state, state, 3);

            // 消耗耐久（手动设置以支持耗尽后保留物品）
            if (player != null && !player.isCreative()) {
                int nextDamage = handStack.getDamageValue() + 1;
                int maxDamage = handStack.getMaxDamage();

                // 确保耐久不会超过最大值
                handStack.setDamageValue(Math.min(nextDamage, maxDamage));

                // 如果耐久刚刚达到最大值，播放损坏音效
                if (handStack.getDamageValue() >= maxDamage) {
                    level.playSound(null, pos, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F + level.random.nextFloat() * 0.4F);
                }
            }

            // 发送提升品质的提示
            if (player != null) {
                player.displayClientMessage(Component.translatable("message.kaleidoscope_dim_wine.mead_essence.quality_up")
                        .withStyle(style -> style.withColor(TextColor.parseColor("#55FF55").getOrThrow())), true);
                player.getCooldowns().addCooldown(this, 20 * 30);
            }

            return InteractionResult.CONSUME;

        } catch (Exception e) {
            return InteractionResult.PASS;
        }
    }
}
