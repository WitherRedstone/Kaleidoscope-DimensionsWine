package com.chinaex123.kaleidoscope_dim_wine.item.Crop;

import com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * 霜心果物品 - 可食用的果实，也可作为种子种植
 * <p>
 * 手持霜心果右键点击雪块时，会在雪块上方种植霜心果丛
 */
public class FrostheartFruitItem extends Item {

    public FrostheartFruitItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(Blocks.SNOW)) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);

            if (belowState.is(Blocks.SNOW_BLOCK)) {
                BlockPos plantPos = pos;
                BlockState plantAboveState = level.getBlockState(plantPos.above());

                if (plantAboveState.isAir() && !level.isClientSide) {
                    BlockState bushState = ModBlocks.FROSTHEART_FRUIT_BUSH.get().defaultBlockState();

                    if (bushState.canSurvive(level, plantPos)) {
                        level.setBlockAndUpdate(plantPos, bushState);

                        ItemStack stack = context.getItemInHand();
                        if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                            stack.shrink(1);
                        }

                        return InteractionResult.SUCCESS;
                    }
                }
            }

            return InteractionResult.SUCCESS;
        }

        if (state.is(Blocks.SNOW_BLOCK)) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            if (aboveState.isAir() && !level.isClientSide) {
                BlockState bushState = ModBlocks.FROSTHEART_FRUIT_BUSH.get().defaultBlockState();

                if (bushState.canSurvive(level, abovePos)) {
                    level.setBlockAndUpdate(abovePos, bushState);

                    ItemStack stack = context.getItemInHand();
                    if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                        stack.shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }
            }

            return InteractionResult.SUCCESS;
        }

        return super.useOn(context);
    }

}
