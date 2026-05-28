package com.chinaex123.kaleidoscope_dim_wine.block.crop.vanilla.Hop;

import com.chinaex123.kaleidoscope_dim_wine.init.KDWItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 啤酒花作物方块类
 * <p>
 * 实现特殊作物：
 * - age 0-6：在地面正常生长，共7个生长阶段
 * <p>
 * 特性：
 * - 支持骨粉催熟
 * - 成熟后可右键收获，自动重置为幼苗状态
 * - 需要光照等级 >= 9 才能生长
 */
public class HopCrop extends CropBlock {
    /** 最大年龄值 */
    public static final int MAX_AGE = 6;
    /** 年龄属性，范围 0-6，共7个生长阶段 */
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);

    /** 各年龄阶段的碰撞箱形状数组，索引对应 age 值 */
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 0
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 1
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 2
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 3
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 4
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0),   // age 5
            Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 16.0)    // age 6
    };

    /**
     * 构造函数
     * @param properties 方块属性配置
     */
    public HopCrop(Properties properties) {
        super(properties);
    }

    /**
     * 根据当前年龄获取方块的碰撞箱形状
     * @param state 方块状态
     * @param level 世界访问接口
     * @param pos 方块位置
     * @param context 碰撞上下文
     * @return 对应年龄的碰撞箱形状
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }

    /**
     * 创建方块状态定义，添加 AGE 属性
     * @param builder 状态构建器
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    /**
     * 获取最大年龄值
     * @return 最大年龄 6
     */
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    /**
     * 获取年龄属性
     * @return AGE 属性实例
     */
    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    /**
     * 获取基础种子物品
     * @return 啤酒花种子物品
     */
    @Override
    protected ItemLike getBaseSeedId() {
        return KDWItems.HOP_SEED.get();
    }

    /**
     * 检查方块能否在此位置生存
     * @param state 当前方块状态
     * @param level 世界读取接口
     * @param pos 方块位置
     * @return 是否可以生存
     */
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos);
    }

    /**
     * 随机刻 tick 处理，控制作物自然生长
     * 生长条件：
     * - 光照等级 >= 9
     * - 未达到最大年龄
     * - 随机概率判定（受生长速度影响）
     * @param state 当前方块状态
     * @param level 服务端世界
     * @param pos 方块位置
     * @param random 随机数生成器
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                float f = getGrowthSpeed(this, level, pos);
                if (random.nextInt((int) (25.0F / f) + 1) == 0) {
                    level.setBlock(pos, this.getStateForAge(age + 1), 3);
                }
            }
        }
    }

    /**
     * 骨粉催熟处理
     * 计算下一个年龄值，考虑骨粉加速效果
     * @param level 世界实例
     * @param pos 方块位置
     * @param state 当前方块状态
     */
    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int nextAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int maxAge = this.getMaxAge();
        if (nextAge > maxAge) {
            nextAge = maxAge;
        }
        level.setBlock(pos, this.getStateForAge(nextAge), 3);
    }

    /**
     * 无物品交互处理（右键点击）
     * 当作物完全成熟（age=6）时：
     * - 重置为幼苗状态（age=0）
     * - 掉落啤酒花物品
     * - 返回成功交互结果
     * @param state 当前方块状态
     * @param level 世界实例
     * @param pos 方块位置
     * @param player 玩家实体
     * @param hand 交互手
     * @param hitResult 方块命中结果
     * @return 交互结果
     */
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (this.getAge(state) == this.getMaxAge()) {
                level.setBlock(pos, this.getStateForAge(0), 3);
                int count = 3 + level.random.nextInt(6);
                popResource(level, pos, new ItemStack(KDWItems.HOP.get(), count));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    /**
     * 强制方块始终获得最高亮度
     * 禁用环境光遮蔽影响
     */
    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 1;  // 返回最大亮度值
    }

    /**
     * 获取方块的阴影亮度
     * 返回 1.0F 表示不受阴影影响
     */
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    /**
     * 方块是否产生环境光遮蔽
     * 返回 false 禁用 AO
     */
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    /**
     * 方块的间接光照强度
     * 返回最大值
     */
    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;  // 允许光照完全通过
    }
}
