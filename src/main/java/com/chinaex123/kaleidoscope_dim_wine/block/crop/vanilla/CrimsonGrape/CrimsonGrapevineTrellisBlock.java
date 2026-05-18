package com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.CrimsonGrape;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWBlocks;
import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import com.github.ysbbbbbb.kaleidoscopetavern.block.plant.GrapevineTrellisBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.block.properties.TrellisType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * 绯红葡萄藤 - 可以种植在普通藤架上的藤蔓作物
 * 使用方式：手持绯红葡萄藤右键普通藤架，藤架会变成此方块
 */
public class CrimsonGrapevineTrellisBlock extends GrapevineTrellisBlock {

    public CrimsonGrapevineTrellisBlock() {
        super();
    }

    /**
     * 处理玩家使用物品右键点击绯红葡萄藤架的逻辑
     * <p>
     * 当玩家手持剪刀时，可以剪下葡萄藤：
     * - 将藤架方块恢复为普通藤架状态
     * - 保留原有的类型（TYPE）和水流（WATERLOGGED）属性
     * - 掉落一个绯红葡萄藤物品
     * - 消耗剪刀耐久度
     * - 播放剪蜂箱音效
     *
     * @param state      当前方块状态
     * @param level      游戏世界
     * @param pos        方块位置
     * @param player     操作的玩家
     * @param hand       使用的手（主手或副手）
     * @param hitResult  命中结果信息
     * @return 交互结果，成功则返回 SUCCESS，否则交由父类处理
     */
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        // 如果玩家拿的是剪刀，可以剪下葡萄藤
        ItemStack itemInHand = player.getItemInHand(hand);
        if (itemInHand.is(Items.SHEARS)) {
            // 恢复为普通藤架并保留属性
            BlockState newState = com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()
                    .defaultBlockState()
                    .setValue(TYPE, state.getValue(TYPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            level.setBlockAndUpdate(pos, newState);
            Block.popResource(level, pos, KDWItems.CRIMSON_GRAPEVINE.get().getDefaultInstance());
            itemInHand.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            player.playSound(SoundEvents.BEEHIVE_SHEAR);
            return InteractionResult.SUCCESS;
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    /**
     * 检查绯红葡萄藤架是否能在指定位置生存
     * <p>
     * 验证周围六个方向是否存在以下方块之一：
     * - 标准藤架方块（TRELLIS）
     * - 任意实现 GrapevineTrellisBlock 的藤架方块
     * <p>
     * 藤架必须依附于其他藤架才能存在，防止悬空放置
     *
     * @param state 当前方块状态
     * @param level 世界读取器
     * @param pos   方块位置
     * @return 如果周围有藤架支撑则返回 true，否则返回 false
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 检查周围是否有藤架类方块
        for (Direction dir : Direction.values()) {
            BlockState neighbor = level.getBlockState(pos.relative(dir));
            if (neighbor.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                    neighbor.getBlock() instanceof GrapevineTrellisBlock) {
                return true;
            }
        }
        return false;
    }

    /**
     * 更新绯红葡萄藤架的形状状态
     * <p>
     * 当相邻方块发生变化时调用，用于更新藤架的连接形态
     * 委托给父类处理具体的连接逻辑和类型设置
     *
     * @param state       当前方块状态
     * @param direction   相邻方块的方向
     * @param neighborState 相邻方块的状态
     * @param level       世界访问器
     * @param pos         当前方块位置
     * @param neighborPos 相邻方块位置
     * @return 更新后的方块状态
     */
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        // 调用父类方法来更新藤架类型（连接逻辑）
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    /**
     * 检查指定方块状态是否与当前绯红葡萄藤藤架属于同一类型
     * <p>
     * 用于判断藤架之间的连接关系，允许与以下方块连接：
     * - 标准藤架方块（TRELLIS）
     * - 其他绯红葡萄藤藤架方块
     *
     * @param state 待检查的方块状态
     * @return 如果方块类型相同或兼容则返回 true，否则返回 false
     */
    @Override
    public boolean sameType(BlockState state) {
        // 允许与普通藤架、其他绯红葡萄藤藤架连接
        return state.is(com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks.TRELLIS.get()) ||
                state.is(KDWBlocks.CRIMSON_GRAPEVINE_TRELLIS.get());
    }

    /**
     * 检查绯红葡萄藤架是否可以生长
     * <p>
     * 验证条件：
     * - SINGLE类型且未成熟时，下方必须为绯红菌岩
     * - 其他情况使用父类默认生长检查逻辑
     *
     * @param level 世界读取器
     * @param pos   方块位置
     * @param state 当前方块状态
     * @return 如果可以生长则返回 true，否则返回 false
     */
    @Override
    public boolean canGrow(LevelReader level, BlockPos pos, BlockState state) {
        if (state.getValue(TYPE) == TrellisType.SINGLE && !this.isMaxAge(state)) {
            // 检查下方是否为绯红菌岩
            return level.getBlockState(pos.below()).is(Blocks.CRIMSON_NYLIUM);
        }
        return super.canGrow(level, pos, state);
    }

    /**
     * 执行绯红葡萄藤架的生长逻辑
     * <p>
     * 生长流程：
     * 1. **SINGLE 类型处理**：
     *    - 检查下方方块是否满足生长条件
     *    - 未成熟时增加年龄值
     *    - 成熟后进入多方向生长阶段
     * <p>
     * 2. **成熟阶段（MAX_AGE）**：
     *    - 遍历预设方向（东西南北）尝试延伸藤蔓
     *    - 找到可生长的位置后生成新的藤架节段
     *    - 若无法延伸，则在下方生成绯红葡萄果实作物
     * <p>
     * 3. **非 SINGLE 类型**：
     *    - 直接设置为最大年龄
     *
     * @param level 游戏世界
     * @param pos   藤架方块位置
     * @param state 当前方块状态
     */
    @Override
    public void doGrow(Level level, BlockPos pos, BlockState state) {
        // 如果是 single 状态
        if (state.getValue(TYPE) == TrellisType.SINGLE && !this.isMaxAge(state)) {
            BlockState belowState = level.getBlockState(pos.below());
            // 先检查下方是否满足生长条件
            if (!belowState.is(Blocks.CRIMSON_NYLIUM)) {
                return;
            }
            // 如果没有达到最大年龄，直接增加年龄
            level.setBlockAndUpdate(pos, state.cycle(AGE));
            return;
        }

        // 如果已经达到最大年龄，此时尝试往各个方向检查
        if (isMaxAge(state)) {
            for (Direction direction : CHECK_DIRECTION) {
                BlockPos checkPos = pos.relative(direction);
                BlockState checkState = level.getBlockState(checkPos);
                if (this.canGrowInto(checkState)) {
                    BlockState growIntoState = this.getGrowIntoState(direction, checkState);
                    level.setBlockAndUpdate(checkPos, growIntoState);
                    return;
                }
            }

            // 如果所有方向都检查完了都不能生长，那么检查下方是否有两格空位，生长葡萄
            if (canGrowGrape(level, pos)) {
                // 生成绯红葡萄果实
                level.setBlockAndUpdate(pos.below(), KDWBlocks.CRIMSON_GRAPE_CROP.get().defaultBlockState());
            }
        } else {
            // 其他朝向的，直接加满
            level.setBlockAndUpdate(pos, state.setValue(AGE, MAX_AGE));
        }
    }

    /**
     * 绯红葡萄藤架的随机刻逻辑
     * <p>
     * 每次随机刻有概率触发一次生长，加快自然生长速度
     *
     * @param state   当前方块状态
     * @param level   服务器世界等级
     * @param pos     方块位置
     * @param random  随机数生成器
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 每3次随机刻有1次概率生长（约33%概率）
        if (random.nextInt(3) == 0) {
            doGrow(level, pos, state);
        }
    }

    /**
     * 获取玩家中键拾取此方块时获得的物品
     */
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(KDWItems.CRIMSON_GRAPEVINE.get());
    }
}
