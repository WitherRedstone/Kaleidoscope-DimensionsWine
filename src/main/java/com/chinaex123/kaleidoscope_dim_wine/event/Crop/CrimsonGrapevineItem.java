package com.chinaex123.kaleidoscope_dim_wine.event.Crop;

import com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape.CrimsonGrapevineTrellisBlock;
import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

/**
 * 绯红葡萄藤物品 - 右键普通藤架时，将其替换为绯红葡萄藤
 */
public class CrimsonGrapevineItem extends Item {

    public CrimsonGrapevineItem() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        // 如果点击的是普通藤架
        if (state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get())) {
            if (!level.isClientSide) {
                // 获取藤架的朝向和含水状态
                BlockState newState = ModBlocks.CRIMSON_GRAPEVINE_TRELLIS.get()
                        .defaultBlockState();

                // 复制藤架的属性（如果有）
                if (state.hasProperty(GrapevineTrellisBlock.TYPE)) {
                    newState = newState.setValue(CrimsonGrapevineTrellisBlock.TYPE,
                            state.getValue(GrapevineTrellisBlock.TYPE));
                }
                if (state.hasProperty(GrapevineTrellisBlock.WATERLOGGED)) {
                    BooleanProperty waterlogged = GrapevineTrellisBlock.WATERLOGGED;
                    if (newState.hasProperty(waterlogged)) {
                        newState = newState.setValue(waterlogged, state.getValue(waterlogged));
                    }
                }

                level.setBlockAndUpdate(pos, newState);

                // 消耗物品
                ItemStack stack = context.getItemInHand();
                if (!context.getPlayer().isCreative()) {
                    stack.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }
        
        return super.useOn(context);
    }
}
