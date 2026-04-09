package com.chinaex123.kaleidoscope_dim_wine.block.Crop.FrostheartFruit;

import com.chinaex123.kaleidoscope_dim_wine.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * 霜心果丛方块 - 类似甜浆果丛的作物方块
 * <p>
 * 成熟后右键可收获霜心果，只能种植在雪块上
 */
public class FrostheartFruitBushBlock extends SweetBerryBushBlock {
    public FrostheartFruitBushBlock() {
        super(Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (belowState.is(Blocks.SNOW_BLOCK)) {
            return true;
        }

        if (belowState.is(Blocks.SNOW)) {
            BlockPos furtherBelowPos = belowPos.below();
            BlockState furtherBelowState = level.getBlockState(furtherBelowPos);
            return furtherBelowState.is(Blocks.SNOW_BLOCK);
        }

        return false;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int age = state.getValue(AGE);
        boolean isMature = age == 3;

        if (!isMature) {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }

        if (!level.isClientSide) {
            level.setBlock(pos, state.setValue(AGE, 1), 2);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            ItemStack frostheartFruit = new ItemStack(ModItems.FROSTHEART_FRUIT.get());
            popResource(level, pos, frostheartFruit);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.FROSTHEART_FRUIT.get());
    }
}
