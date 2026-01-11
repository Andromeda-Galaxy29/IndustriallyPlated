package net.andromeda_galaxy29.industrially_plated.block.signage;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SignageBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final MapCodec<SignageBlock> CODEC = simpleCodec(SignageBlock::new);

    protected static final VoxelShape CEILING_AABB = Block.box(1, 14, 1, 15, 16, 15);;
    protected static final VoxelShape FLOOR_AABB = Block.box(1, 0, 1, 15, 2, 15);
    protected static final VoxelShape NORTH_AABB = Block.box(1, 1, 14, 15, 15, 16);
    protected static final VoxelShape SOUTH_AABB = Block.box(1, 1, 0, 15, 15, 2);
    protected static final VoxelShape WEST_AABB = Block.box(14, 1, 1, 16, 15, 15);
    protected static final VoxelShape EAST_AABB = Block.box(0, 1, 1, 2, 15, 15);

    public SignageBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(FACE, AttachFace.WALL));
    }

    @Override
    public @NotNull MapCodec<? extends FaceAttachedHorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        AttachFace face = state.getValue(FACE);

        return switch (face) {
            case CEILING -> CEILING_AABB;
            case FLOOR -> FLOOR_AABB;
            case WALL -> switch (direction) {
                case EAST -> EAST_AABB;
                case WEST -> WEST_AABB;
                case NORTH -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case UP -> FLOOR_AABB;
                case DOWN -> CEILING_AABB;
            };
        };
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE);
    }
}
