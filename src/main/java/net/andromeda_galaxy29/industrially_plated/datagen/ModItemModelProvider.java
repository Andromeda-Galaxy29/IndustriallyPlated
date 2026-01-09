package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IndustriallyPlated.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (DyeColor color : DyeColor.values()) {
            simpleBlockItem(ModBlocks.PLATING_BLOCKS.get(color).get());
            simpleBlockItem(ModBlocks.CUT_PLATING.get(color).get());
            simpleBlockItem(ModBlocks.PLATING_GRATES.get(color).get());
        }
    }
}
