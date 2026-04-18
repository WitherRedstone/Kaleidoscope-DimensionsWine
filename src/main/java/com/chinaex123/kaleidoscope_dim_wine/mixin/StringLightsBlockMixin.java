package com.chinaex123.kaleidoscope_dim_wine.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.block.deco.StringLightsBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

/**
 * 扩展彩灯替换机制，支持自定义物品
 */
@Mixin(StringLightsBlock.class)
public class StringLightsBlockMixin {

    private static final Map<Item, String> ITEM_TO_BLOCK_NAME = Map.of(
            Items.CHORUS_FRUIT, "string_entity_shulker", // 小灯串（潜影贝-无色）
            Items.FEATHER, "string_entity_chicken", // 小灯串（小鸡仔）
            Items.HONEYCOMB, "string_lights_entity_bee" // 小灯串（蜜蜂）
    );

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    private void onUseItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir) {
        Item item = stack.getItem();
        String blockName = ITEM_TO_BLOCK_NAME.get(item);

        if (blockName != null) {
            StringLightsBlock targetBlock = getBlockByName(blockName);

            if (targetBlock != null) {
                BlockState transform = targetBlock.defaultBlockState()
                        .setValue(StringLightsBlock.FACING, state.getValue(StringLightsBlock.FACING))
                        .setValue(StringLightsBlock.WATERLOGGED, state.getValue(StringLightsBlock.WATERLOGGED));

                level.setBlockAndUpdate(pos, transform);
                level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS);
                level.levelEvent(player, 2001, pos, Block.getId(state));

                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                cir.setReturnValue(ItemInteractionResult.SUCCESS);
            }
        }
    }

    private static StringLightsBlock getBlockByName(String name) {
        try {
            Class<?> modBlocksClass = Class.forName("com.chinaex123.kaleidoscope_dim_wine.init.ModBlocks");
            Object block = modBlocksClass.getField(name.toUpperCase()).get(null);
            return (StringLightsBlock) ((net.neoforged.neoforge.registries.DeferredBlock<?>) block).get();
        } catch (Exception e) {
            return null;
        }
    }
}
