package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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

            simpleBlock(ModBlocks.CUT_PLATING.get(color).get());

            DeferredBlock<WaterloggedTransparentBlock> platingGrate = ModBlocks.PLATING_GRATES.get(color);
            simpleBlock(platingGrate.get(),
                    models().withExistingParent(name(platingGrate), mcLoc("cube_all"))
                            .texture("all", modLoc("block/" + name(platingGrate)))
                            .renderType(mcLoc("cutout")));
        }
    }

    private String name(DeferredBlock deferredBlock) {
        return deferredBlock.getKey().location().getPath();
    }
}
