package com.chinaex123.kaleidoscope_dim_wine.block.Crop.WarpedGrape;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 诡异葡萄藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成葡萄藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 */
public class WarpedGrapeCropWildGrapevinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    public static final MapCodec<WarpedGrapeCropWildGrapevinePlant> CODEC = simpleCodec((p) -> new WarpedGrapeCropWildGrapevinePlant());
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public WarpedGrapeCropWildGrapevinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);
        return relativeState.is(ModBlocks.WARPED_GRAPEVINE.get()) ||
                relativeState.is(ModBlocks.WARPED_GRAPEVINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.WARPED_GRAPEVINE.get();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();
        return BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).map((headPos) -> {
            BlockState blockState = level.getBlockState(headPos);
            return blockState.is(headBlock) && !(Boolean) blockState.getValue(WarpedGrapeCropWildGrapevine.SHEARED);
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
