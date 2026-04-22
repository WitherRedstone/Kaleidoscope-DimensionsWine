package com.chinaex123.kaleidoscope_dim_wine.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * Entity Mixin：提供访问 protected 方法 setSharedFlag 的接口，用于控制实体共享标志
 */
@Mixin(Entity.class)
public interface EntityMixin {
    @Invoker("setSharedFlag")
    void invokeSetSharedFlag(int id, boolean value);
}
