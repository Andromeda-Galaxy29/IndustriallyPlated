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
        dropSelf(ModBlocks.GENERIC_HAZARD_SIGN.get());
        dropSelf(ModBlocks.FALLING_HAZARD_SIGN.get());
        dropSelf(ModBlocks.TOXICITY_HAZARD_SIGN.get());
        dropSelf(ModBlocks.ELECTRICITY_HAZARD_SIGN.get());
        dropSelf(ModBlocks.FIRE_HAZARD_SIGN.get());
        dropSelf(ModBlocks.HEAT_HAZARD_SIGN.get());
        dropSelf(ModBlocks.RADIATION_HAZARD_SIGN.get());
        dropSelf(ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN.get());
        dropSelf(ModBlocks.BIOHAZARD_SIGN.get());

        dropSelf(ModBlocks.BLANK_PROHIBITION_SIGN.get());
        dropSelf(ModBlocks.GENERIC_PROHIBITION_SIGN.get());
        dropSelf(ModBlocks.NO_ENTRY_SIGN.get());
        dropSelf(ModBlocks.NO_SWIMMING_SIGN.get());
        dropSelf(ModBlocks.NO_SMOKING_SIGN.get());
        dropSelf(ModBlocks.NO_EATING_SIGN.get());
        dropSelf(ModBlocks.NO_DRINKING_SIGN.get());
        dropSelf(ModBlocks.NO_PETS_SIGN.get());
        dropSelf(ModBlocks.NO_OPEN_FIRE_SIGN.get());
        dropSelf(ModBlocks.NO_TOUCHING_SIGN.get());
        dropSelf(ModBlocks.NO_WEAPONS_SIGN.get());
        dropSelf(ModBlocks.NO_MINING_SIGN.get());
        dropSelf(ModBlocks.NO_CUTTING_TREES_SIGN.get());
        dropSelf(ModBlocks.NO_SHEARING_SIGN.get());

        dropSelf(ModBlocks.BLANK_SAFETY_SIGN.get());
        dropSelf(ModBlocks.ARROW_SIGN.get());
        dropSelf(ModBlocks.EXIT_SIGN.get());
        dropSelf(ModBlocks.WALK_SIGN.get());
        dropSelf(ModBlocks.DISABLED_ACCESS_SIGN.get());
        dropSelf(ModBlocks.STAIRS_SIGN.get());
        dropSelf(ModBlocks.LADDER_SIGN.get());
        dropSelf(ModBlocks.MEDICAL_CROSS_SIGN.get());
    }
}
