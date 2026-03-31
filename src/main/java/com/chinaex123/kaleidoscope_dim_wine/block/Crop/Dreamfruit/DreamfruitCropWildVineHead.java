package com.chinaex123.kaleidoscope_dim_wine.block.Crop.Dreamfruit;

import com.chinaex123.kaleidoscope_dim_wine.block.ModBlocks;
import com.chinaex123.kaleidoscope_dim_wine.item.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
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
import net.neoforged.neoforge.common.ItemAbilities;

/**
 * 迷梦果藤作物方块 - 向下生长的藤蔓植物顶部方块
 * <p>
 * 支持骨粉催熟和剪刀修剪，修剪后停止生长
 * <p>
 * 成熟后会结出迷梦果，右键点击可收获
 */
public class DreamfruitCropWildVineHead extends GrowingPlantHeadBlock implements BonemealableBlock {
    public static final MapCodec<DreamfruitCropWildVineHead> CODEC = simpleCodec((p) -> new DreamfruitCropWildVineHead());
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");
    private static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 16.0F, 15.0F);
    private static final BlockBehaviour.Properties PROPERTIES;

    public DreamfruitCropWildVineHead() {
        super(PROPERTIES, Direction.DOWN, SHAPE, false, 0.15);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SHEARED, false).setValue(HAS_FRUIT, false));
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
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(ModItems.DREAMFRUIT.get())) {
            BlockPos below = pos.relative(this.growthDirection);
            BlockState belowState = level.getBlockState(below);

            if (belowState.isAir() || belowState.canBeReplaced()) {
                // 放置头部方块（新的藤蔓顶部）
                BlockState headState = ModBlocks.DREAMFRUIT_VINE.get().defaultBlockState();
                if (headState.canSurvive(level, below)) {
                    level.setBlockAndUpdate(below, headState);
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }

                // 如果头部不能生存，改放身体方块
                BlockState plantState = ModBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
                if (plantState.canSurvive(level, below)) {
                    level.setBlockAndUpdate(below, plantState);
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        if (stack.canPerformAction(ItemAbilities.SHEARS_CARVE)) {
            if (state.getValue(SHEARED)) {
                return ItemInteractionResult.CONSUME;
            } else {
                level.setBlockAndUpdate(pos, state.setValue(SHEARED, true).setValue(HAS_FRUIT, false));
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
        builder.add(SHEARED, HAS_FRUIT);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos relative = pos.relative(this.growthDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relative);

        // 检查上方方块是否是末地石或紫珀块
        boolean isEndStone = relativeState.is(Blocks.END_STONE);
        boolean isPurpur = relativeState.is(Blocks.PURPUR_BLOCK);

        if (!isEndStone && !isPurpur) {
            return false;
        }

        // 检查下方是否有足够的空间
        BlockPos below = pos.relative(this.growthDirection);
        BlockState belowState = level.getBlockState(below);
        return belowState.isAir() || belowState.canBeReplaced();
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return state.is(BlockTags.LEAVES) ||
                state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.getBlock() instanceof GrapevineTrellisBlock;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.DREAMFRUIT.get());
    }

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!(Boolean)state.getValue(SHEARED)) {
            // 尝试向下生长（10% 概率）
            BlockPos below = pos.relative(this.growthDirection);
            BlockState belowState = level.getBlockState(below);

            if ((belowState.isAir() || belowState.canBeReplaced()) && !state.getValue(HAS_FRUIT)) {
                BlockState plantState = ModBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
                if (plantState.canSurvive(level, below)) {
                    if (random.nextInt(10) == 0) {
                        // 将当前头部转换为身体方块
                        level.setBlockAndUpdate(pos, plantState);
                        // 在下方生成新的头部方块
                        BlockState newHeadState = ModBlocks.DREAMFRUIT_VINE.get().defaultBlockState();
                        level.setBlockAndUpdate(below, newHeadState);
                    }
                    return;
                }
            }

            // 不能生长时，概率结果
            if (!state.getValue(HAS_FRUIT) && random.nextInt(5) == 0) {
                level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        if (!(Boolean)state.getValue(SHEARED)) {
            BlockPos below = pos.relative(this.growthDirection);
            BlockState belowState = level.getBlockState(below);

            // 如果下方是空气或可替换方块，可以生长
            if (belowState.isAir() || belowState.canBeReplaced()) {
                return true;
            }

            // 如果不能生长，检查是否可以结果
            return !state.getValue(HAS_FRUIT);
        }
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.getValue(SHEARED)) {
            return;
        }

        // 尝试向下生长
        BlockPos below = pos.relative(this.growthDirection);
        BlockState belowState = level.getBlockState(below);

        if ((belowState.isAir() || belowState.canBeReplaced()) && !state.getValue(HAS_FRUIT)) {
            BlockState plantState = ModBlocks.DREAMFRUIT_VINE_PLANT.get().defaultBlockState();
            if (plantState.canSurvive(level, below)) {
                // 将当前头部转换为身体方块
                level.setBlockAndUpdate(pos, plantState);
                // 在下方生成新的头部方块
                BlockState newHeadState = ModBlocks.DREAMFRUIT_VINE.get().defaultBlockState();
                level.setBlockAndUpdate(below, newHeadState);
            }
        } else if (!state.getValue(HAS_FRUIT)) {
            // 如果不能生长，则结果
            level.setBlock(pos, state.setValue(HAS_FRUIT, Boolean.TRUE), 2);
        }
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
        return ModBlocks.DREAMFRUIT_VINE_PLANT.get();
    }

    static {
        PROPERTIES = Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY);
    }
}
