package com.chinaex123.kaleidoscope_dim_wine.block.Crop.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;

/**
 * 绯红葡萄藤作物方块 - 向下生长的藤蔓植物顶部方块
 * <p>
 * 支持骨粉催熟和剪刀修剪，修剪后停止生长
 */
public class CrimsonGrapeCropWildGrapevine extends GrowingPlantHeadBlock implements BonemealableBlock {
    public static final MapCodec<CrimsonGrapeCropWildGrapevine> CODEC = simpleCodec((p) -> new CrimsonGrapeCropWildGrapevine());
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public CrimsonGrapeCropWildGrapevine() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false, 0.15);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SHEARED, false));
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.canPerformAction(ItemAbilities.SHEARS_CARVE)) {
            if (state.getValue(SHEARED)) {
                return ItemInteractionResult.CONSUME;
            } else {
                level.setBlockAndUpdate(pos, state.setValue(SHEARED, true));
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                player.playSound(SoundEvents.SHEEP_SHEAR);
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHEARED);
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
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
    }

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!(Boolean)state.getValue(SHEARED)) {
            super.randomTick(state, level, pos, random);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !(Boolean)state.getValue(SHEARED) && super.isValidBonemealTarget(level, pos, state);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return 1;
    }

    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.CRIMSON_GRAPEVINE_PLANT.get();
    }

    static {
        PROPERTIES = Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY);
    }
}
