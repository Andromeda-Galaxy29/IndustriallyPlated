package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {

    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        for (DyeColor color : DyeColor.values()) {
            dropSelf(ModBlocks.PLATING_BLOCKS.get(color).get());
            dropSelf(ModBlocks.PLATING_GRATES.get(color).get());
            dropSelf(ModBlocks.CUT_PLATING.get(color).get());
            dropSelf(ModBlocks.CUT_PLATING_STAIRS.get(color).get());

            Block cutPlatingSlab = ModBlocks.CUT_PLATING_SLABS.get(color).get();
            add(cutPlatingSlab, createSlabItemTable(cutPlatingSlab));
        }

        dropSelf(ModBlocks.HAZARD_STRIPE_BLOCK.get());
        dropSelf(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get());

        dropSelf(ModBlocks.BLANK_HAZARD_SIGN.get());
    }
}
