package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IndustriallyPlated.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        for (DyeColor color : DyeColor.values()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get())
                    .add(ModBlocks.PLATING_GRATES.get(color).get())
                    .add(ModBlocks.CUT_PLATING.get(color).get())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get());

            tag(BlockTags.NEEDS_STONE_TOOL)
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get())
                    .add(ModBlocks.PLATING_GRATES.get(color).get())
                    .add(ModBlocks.CUT_PLATING.get(color).get())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get());

            tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get())
                    .add(ModBlocks.PLATING_GRATES.get(color).get())
                    .add(ModBlocks.CUT_PLATING.get(color).get())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get());

            tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get())
                    .add(ModBlocks.PLATING_GRATES.get(color).get())
                    .add(ModBlocks.CUT_PLATING.get(color).get())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get());
        }

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.CAUTION_STRIPE_BLOCK.get())
                .add(ModBlocks.BLANK_HAZARD_SIGN.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.CAUTION_STRIPE_BLOCK.get())
                .add(ModBlocks.BLANK_HAZARD_SIGN.get());

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.CAUTION_STRIPE_BLOCK.get())
                .add(ModBlocks.BLANK_HAZARD_SIGN.get());

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get())
                .add(ModBlocks.CAUTION_STRIPE_BLOCK.get())
                .add(ModBlocks.BLANK_HAZARD_SIGN.get());
    }
}