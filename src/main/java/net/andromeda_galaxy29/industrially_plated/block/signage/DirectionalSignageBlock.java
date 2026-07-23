package net.andromeda_galaxy29.industrially_plated.block.signage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class DirectionalSignageBlock extends ConfigurableSignageBlock{
    public static final EnumProperty<SignageDirection> DIRECTION =
            EnumProperty.create("direction", SignageDirection.class);

    public DirectionalSignageBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(DIRECTION, SignageDirection.RIGHT));
    }

    @Override
    public @NotNull InteractionResult config(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.setBlockAndUpdate(pos, state.setValue(DIRECTION, SignageDirection.values()[(state.getValue(DIRECTION).ordinal() + 1) % 8]));
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DIRECTION);
    }
}
