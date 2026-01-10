package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, IndustriallyPlated.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        for (DyeColor color : DyeColor.values()) {
            tag(Tags.Items.DYED)
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get().asItem())
                    .add(ModBlocks.PLATING_GRATES.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get().asItem());

            tag(color.getDyedTag())
                    .add(ModBlocks.PLATING_BLOCKS.get(color).get().asItem())
                    .add(ModBlocks.PLATING_GRATES.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).get().asItem())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).get().asItem());
        }
    }
}