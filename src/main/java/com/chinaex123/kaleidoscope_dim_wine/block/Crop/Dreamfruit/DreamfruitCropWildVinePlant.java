package com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 迷梦果藤植物方块 - 向下生长的藤蔓植物主体方块
 * <p>
 * 构成果藤的中间节段，支持骨粉催熟（受顶部方块修剪状态影响）
 * <p>
 * 每个节段都能结果，右键点击可收获迷梦果
 */
public class DreamfruitCropWildVinePlant extends GrowingPlantBodyBlock implements BonemealableBlock {
    public static final MapCodec<DreamfruitCropWildVinePlant> CODEC = simpleCodec((p) -> new DreamfruitCropWildVinePlant());
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public DreamfruitCropWildVinePlant() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_FRUIT, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (state.getValue(HAS_FRUIT)) {
            Block.popResource(level, pos, new ItemStack(ModItems.DREAMFRUIT.get(), 1));
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState newState = state.setValue(HAS_FRUIT, Boolean.FALSE);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HAS_FRUIT);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);
        return relativeState.is(ModBlocks.DREAMFRUIT_VINE.get()) ||
                relativeState.is(ModBlocks.DREAMFRUIT_VINE_PLANT.get()) ||
                this.canAttachTo(relativeState) ||
                relativeState.isFaceSturdy(level, relative, this.growthDirection);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.DREAMFRUIT.get());
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof GrapevineTrellisBlock;
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.DREAMFRUIT_VINE.get();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();
        return BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).map((headPos) -> {
            BlockState blockState = level.getBlockState(headPos);
            return blockState.is(headBlock) && !(Boolean) blockState.getValue(DreamfruitCropWildVineHead.SHEARED);
        }).orElse(false);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // 藤蔓节段使用骨粉时，直接让整株藤蔓的所有头部方块结果
        GrowingPlantHeadBlock headBlock = this.getHeadBlock();
        BlockUtil.getTopConnectedBlock(level, pos, state.getBlock(), this.growthDirection, headBlock).ifPresent((headPos) -> {
            BlockState headState = level.getBlockState(headPos);
            if (headState.is(headBlock) && !(Boolean) headState.getValue(DreamfruitCropWildVineHead.SHEARED)) {
                // 直接结果，不触发生长
                level.setBlock(headPos, headState.setValue(DreamfruitCropWildVineHead.HAS_FRUIT, Boolean.TRUE), 2);
            }
        });

        // 同时让当前节段也结果
        if (!state.getValue(HAS_FRUIT)) {
            level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
        }
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }

    static {
        PROPERTIES = Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY);
    }
}
