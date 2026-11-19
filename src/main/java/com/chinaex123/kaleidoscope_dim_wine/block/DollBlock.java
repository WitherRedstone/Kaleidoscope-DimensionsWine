package com.chinaex123.kaleidoscope_dim_wine.block;

import com.chinaex123.kaleidoscope_dim_wine.util.DollShapes;
import com.chinaex123.kaleidoscope_dim_wine.util.DollShapes.DollType;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 玩偶方块。
 * <p>
 * 带水平朝向的玩偶装饰方块，使用羊毛材质与音效；
 * 碰撞箱按玩偶体型（Steve 或 Alex）与朝向从 DollShapes 获取，
 * 放置时朝向玩家所在的水平方向。
 */
public class DollBlock extends HorizontalDirectionalBlock {

    /** 方块编解码器。 */
    public static final MapCodec<DollBlock> CODEC = MapCodec.unit(DollBlock::new);

    /** 玩偶体型。 */
    private final DollType dollType;

    /**
     * 以 Steve 体型构造玩偶方块。
     */
    public DollBlock() {
        this(DollType.STEVE);
    }

    /**
     * 构造玩偶方块。
     *
     * @param dollType 玩偶体型
     */
    public DollBlock(DollType dollType) {
        super(Properties.of().strength(1.5F, 6.0F).mapColor(MapColor.WOOL).sound(SoundType.WOOL));
        this.dollType = dollType;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    /**
     * 获取玩偶体型。
     *
     * @return 玩偶体型
     */
    public DollType getDollType() {
        return this.dollType;
    }

    /**
     * 放置时朝向玩家所在的水平方向。
     *
     * @param context 放置上下文
     * @return 初始方块状态
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    /**
     * 创建方块状态定义。
     *
     * @param builder 状态定义构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * 获取方块碰撞箱。
     * <p>
     * 按玩偶体型与当前朝向返回对应碰撞箱。
     *
     * @param state   方块状态
     * @param level   方块获取器
     * @param pos     方块位置
     * @param context 碰撞上下文
     * @return 碰撞箱
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return DollShapes.getShape(this.dollType, state.getValue(FACING));
    }

    /**
     * 获取方块编解码器。
     *
     * @return 方块编解码器
     */
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
