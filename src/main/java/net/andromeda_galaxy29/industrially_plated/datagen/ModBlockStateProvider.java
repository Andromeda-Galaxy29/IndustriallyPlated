package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IndustriallyPlated.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DyeColor color : DyeColor.values()) {

            simpleBlock(ModBlocks.PLATING_BLOCKS.get(color).get());

            DeferredBlock<WaterloggedTransparentBlock> platingGrate = ModBlocks.PLATING_GRATES.get(color);
            simpleBlock(platingGrate.get(),
                    models().withExistingParent(name(platingGrate), mcLoc("cube_all"))
                            .texture("all", modLoc("block/" + name(platingGrate)))
                            .renderType(mcLoc("cutout")));

            simpleBlock(ModBlocks.CUT_PLATING.get(color).get());

            stairsBlock(ModBlocks.CUT_PLATING_STAIRS.get(color).get(),
                    modLoc("block/" + name(ModBlocks.CUT_PLATING.get(color))));

            slabBlock(ModBlocks.CUT_PLATING_SLABS.get(color).get(),
                    modLoc("block/" + name(ModBlocks.CUT_PLATING.get(color))),
                    modLoc("block/" + name(ModBlocks.CUT_PLATING.get(color))));
        }

        simpleBlock(ModBlocks.HAZARD_STRIPE_BLOCK.get());
        simpleBlock(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get());
        simpleBlock(ModBlocks.CAUTION_STRIPE_BLOCK.get());

        signageBlock(ModBlocks.BLANK_HAZARD_SIGN.get(),
                models().withExistingParent(name(ModBlocks.BLANK_HAZARD_SIGN), modLoc("sign"))
                        .texture("front", modLoc("block/" + name(ModBlocks.BLANK_HAZARD_SIGN))));
    }

    private String name(DeferredBlock deferredBlock) {
        return deferredBlock.getKey().location().getPath();
    }

    private void signageBlock(Block block, ModelFile model){
        EnumProperty<AttachFace> face = BlockStateProperties.ATTACH_FACE;
        DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;
        getVariantBuilder(block).forAllStates((state) -> ConfiguredModel.builder()
                .modelFile(model)
                .rotationX(state.getValue(face).ordinal() * -90)
                .rotationY((int) (state.getValue(facing).toYRot() + (state.getValue(face) != AttachFace.WALL ? 180 : 0)) % 360)
                .build());
    }
}
