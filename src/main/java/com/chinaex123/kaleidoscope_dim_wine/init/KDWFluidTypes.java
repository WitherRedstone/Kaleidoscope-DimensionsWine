package com.chinaex123.kaleidoscope_dim_wine.init;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class KDWFluidTypes extends FluidType {
    private final ResourceLocation id;
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;

    public KDWFluidTypes(ResourceLocation id, FluidType.Properties properties) {
        super(properties);
        this.id = id;
        this.stillTexture = ResourceLocation.fromNamespaceAndPath(this.id.getNamespace(), "block/%s_still".formatted(id.getPath()));
        this.flowingTexture = ResourceLocation.fromNamespaceAndPath(this.id.getNamespace(), "block/%s_flow".formatted(id.getPath()));
    }

    // 参数：流体 ID，掉落伤害，光亮等级，滋润耕地，无限生成
    public KDWFluidTypes(ResourceLocation id, float Distance, int lightLevel, boolean canHydrate, boolean ConvertToSource) {
        this(id, Properties.create()
                .descriptionId(Util.makeDescriptionId("block", id)) // 设置流体的本地化名称 Key
                .fallDistanceModifier(Distance) // 掉落伤害修正
                .canHydrate(canHydrate)  // 滋润耕地
                .lightLevel(lightLevel) // 光照等级
                .canConvertToSource(ConvertToSource)  // 无限生成
                .canExtinguish(true) // 可以灭火
                .canDrown(true) // 可以淹死生物
                .canPushEntity(true) // 可以推动实体
                .canSwim(true)  // 可以游泳
                .supportsBoating(true) // 划船
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL) // 用桶装流体
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)); // 倒出流体
    }

    // 通过 ID 获取流体类型
    public ResourceLocation getId() {return this.id;}

    // 控制生物寻路系统对流体方块的路径判断的方法
    @Override
    public BlockPathTypes getBlockPathType(@NotNull FluidState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @Nullable Mob mob, boolean canFluidLog) {
        return canFluidLog ? super.getBlockPathType(state, level, pos, mob, true) : null;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            public @NotNull ResourceLocation getStillTexture() {
                return KDWFluidTypes.this.stillTexture;
            }

            public @NotNull ResourceLocation getFlowingTexture() {
                return KDWFluidTypes.this.flowingTexture;
            }
        });
    }
}
