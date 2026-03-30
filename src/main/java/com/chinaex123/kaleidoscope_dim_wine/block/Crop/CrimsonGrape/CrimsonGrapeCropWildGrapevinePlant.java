package com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 绯红葡萄藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成葡萄藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 */
public class CrimsonGrapeCropWildGrapevinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    public static final MapCodec<CrimsonGrapeCropWildGrapevinePlant> CODEC = simpleCodec((p) -> new CrimsonGrapeCropWildGrapevinePlant());
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public CrimsonGrapeCropWildGrapevinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);
        return relativeState.is(ModBlocks.CRIMSON_GRAPEVINE.get()) ||
                relativeState.is(ModBlocks.CRIMSON_GRAPEVINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CRIMSON_GRAPEVINE.get());
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.CRIMSON_GRAPEVINE.get();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();
        return BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).map((headPos) -> {
            BlockState blockState = level.getBlockState(headPos);
            return blockState.is(headBlock) && !(Boolean) blockState.getValue(CrimsonGrapeCropWildGrapevine.SHEARED);
        }).orElse(false);
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }

    static {
        PROPERTIES = Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY);
    }
}
