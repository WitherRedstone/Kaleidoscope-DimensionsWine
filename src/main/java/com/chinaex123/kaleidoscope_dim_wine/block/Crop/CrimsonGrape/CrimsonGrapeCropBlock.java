package com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapeCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

/**
 * 绯红葡萄果实 - 长在绯红葡萄藤下方的作物
 * 使用剪刀可以收获绯红葡萄
 */
public class CrimsonGrapeCropBlock extends GrapeCropBlock {
    
    public CrimsonGrapeCropBlock() {
        super();
    }
    
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CRIMSON_GRAPE.get());
    }
}
