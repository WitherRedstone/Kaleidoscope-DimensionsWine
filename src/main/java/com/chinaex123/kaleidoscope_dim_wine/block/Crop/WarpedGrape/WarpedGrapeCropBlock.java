package com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape;

import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
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
 * 诡异葡萄果实 - 长在诡异葡萄藤下方的作物
 * 使用剪刀可以收获诡异葡萄
 */
public class WarpedGrapeCropBlock extends GrapeCropBlock {

    public WarpedGrapeCropBlock() {
        super();
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.canPerformAction(ItemAbilities.SHEARS_HARVEST) && this.isMaxAge(state)) {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            Block.popResource(level, pos, new ItemStack(ModItems.WARPED_GRAPE.get(), 3));
            heldItem.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.playSound(SoundEvents.BEEHIVE_SHEAR);
            return ItemInteractionResult.SUCCESS;
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }
    
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.WARPED_GRAPE.get());
    }
}
