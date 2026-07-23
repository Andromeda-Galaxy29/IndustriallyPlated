package net.andromeda_galaxy29.industrially_plated.block.signage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

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
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(MIRRORED);
    }
}
