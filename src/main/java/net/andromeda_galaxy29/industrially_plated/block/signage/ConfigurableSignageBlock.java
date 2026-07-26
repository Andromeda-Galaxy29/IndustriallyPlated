package net.andromeda_galaxy29.industrially_plated.block.signage;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class ConfigurableSignageBlock extends SignageBlock{
    public static final BooleanProperty WAXED = BooleanProperty.create("waxed");

    public ConfigurableSignageBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(WAXED, false));
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!state.getValue(WAXED)) {
            config(state, level, pos, player, hitResult);
            level.playSound(null, pos, SoundEvents.ITEM_FRAME_ROTATE_ITEM, SoundSource.BLOCKS);
        } else {
            level.playSound(null, pos, SoundEvents.WAXED_SIGN_INTERACT_FAIL, SoundSource.BLOCKS);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.getItem() instanceof HoneycombItem && !state.getValue(WAXED)) {
            stack.consume(1, player);

            level.setBlockAndUpdate(pos, state.setValue(WAXED, true));
            level.levelEvent(LevelEvent.PARTICLES_AND_SOUND_WAX_ON, pos, 0);

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else if (stack.getItem().canPerformAction(stack, ItemAbilities.AXE_WAX_OFF) && state.getValue(WAXED)) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));

            level.setBlockAndUpdate(pos, state.setValue(WAXED, false));
            level.playSound(null, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS);
            level.levelEvent(LevelEvent.PARTICLES_WAX_OFF, pos, 0);

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public @NotNull InteractionResult config(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag tooltipFlag) {
        tooltips.add(Component.translatable("tooltip.industrially_plated.wax").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WAXED);
    }
}
