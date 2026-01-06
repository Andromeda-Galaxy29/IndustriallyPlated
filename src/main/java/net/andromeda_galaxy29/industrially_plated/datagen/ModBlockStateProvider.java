package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IndustriallyPlated.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DyeColor color : DyeColor.values()) {
            simpleBlock(ModBlocks.PLATING_BLOCKS.get(color).get());
        }
    }
}
