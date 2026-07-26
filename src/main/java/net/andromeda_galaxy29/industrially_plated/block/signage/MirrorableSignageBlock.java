package net.andromeda_galaxy29.industrially_plated.block.signage;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MirrorableSignageBlock extends ConfigurableSignageBlock {
    public static final BooleanProperty MIRRORED = BooleanProperty.create("mirrored");

    public MirrorableSignageBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(MIRRORED, false));
    }

    @Override
    public @NotNull InteractionResult config(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.setBlockAndUpdate(pos, state.setValue(MIRRORED, !state.getValue(MIRRORED)));
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag tooltipFlag) {
        tooltips.add(Component.translatable("tooltip.industrially_plated.mirror").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, tooltips, tooltipFlag);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(MIRRORED);
    }
}
