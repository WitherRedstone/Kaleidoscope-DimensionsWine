package com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.config.ServerConfig;
import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapeCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.ItemAbilities;

/**
 * 绯红葡萄果实 - 长在绯红葡萄藤下方的作物
 * 使用剪刀可以收获绯红葡萄
 */
public class CrimsonGrapeCropBlock extends GrapeCropBlock {
    
    public CrimsonGrapeCropBlock() {
        super();
    }

    /**
     * 处理玩家使用物品右键点击绯红葡萄作物的逻辑
     * <p>
     * 当玩家手持剪刀且作物已成熟时，可以收获作物：
     * - 破坏作物方块
     * - 掉落 3 个绯红葡萄
     * - 消耗剪刀耐久度
     * - 播放剪羊毛音效
     *
     * @param stack      被使用的物品（未指定用途）
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hand       使用的手（主手或副手）
     * @param hitResult  命中结果信息
     * @return 交互结果，成功则返回 SUCCESS，否则交由父类处理
     */
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 获取玩家手中的物品
        ItemStack heldItem = player.getItemInHand(hand);

        // 检查是否为剪刀且作物已成熟
        if (heldItem.canPerformAction(ItemAbilities.SHEARS_HARVEST) && this.isMaxAge(state)) {
            // 收获作物并掉落产物
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            Block.popResource(level, pos, new ItemStack(ModItems.CRIMSON_GRAPE.get(), 3));

            heldItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.playSound(SoundEvents.BEEHIVE_SHEAR);
            return ItemInteractionResult.SUCCESS;
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    /**
     * 获取玩家中键拾取此方块时获得的物品
     * <p>
     * 返回绯红葡萄物品，用于创造模式下的方块复制
     *
     * @param state   当前方块状态
     * @param target  命中结果信息
     * @param level   世界读取器
     * @param pos     方块位置
     * @param player  执行拾取的玩家
     * @return 包含绯红葡萄物品的 ItemStack
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CRIMSON_GRAPE.get());
    }
}
