package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.andromeda_galaxy29.industrially_plated.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
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
                    .add(ModBlocks.PLATING_BLOCKS.get(color).asItem())
                    .add(ModBlocks.PLATING_GRATES.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).asItem());

            tag(color.getDyedTag())
                    .add(ModBlocks.PLATING_BLOCKS.get(color).asItem())
                    .add(ModBlocks.PLATING_GRATES.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING_STAIRS.get(color).asItem())
                    .add(ModBlocks.CUT_PLATING_SLABS.get(color).asItem());

            tag(ModTags.Items.PLATING_BLOCKS).addOptional(ModBlocks.PLATING_BLOCKS.get(color).getId());
            tag(ModTags.Items.PLATING_GRATES).addOptional(ModBlocks.PLATING_GRATES.get(color).getId());
            tag(ModTags.Items.CUT_PLATING).addOptional(ModBlocks.CUT_PLATING.get(color).getId());
            tag(ModTags.Items.CUT_PLATING_STAIRS).addOptional(ModBlocks.CUT_PLATING_STAIRS.get(color).getId());
            tag(ModTags.Items.CUT_PLATING_SLABS).addOptional(ModBlocks.CUT_PLATING_SLABS.get(color).getId());
        }

        tag(ModTags.Items.HAZARD_SIGNAGE)
                .add(ModBlocks.BLANK_HAZARD_SIGN.asItem())
                .add(ModBlocks.GENERIC_HAZARD_SIGN.asItem())
                .add(ModBlocks.FALLING_HAZARD_SIGN.asItem())
                .add(ModBlocks.TOXICITY_HAZARD_SIGN.asItem())
                .add(ModBlocks.ELECTRICITY_HAZARD_SIGN.asItem())
                .add(ModBlocks.FIRE_HAZARD_SIGN.asItem())
                .add(ModBlocks.HEAT_HAZARD_SIGN.asItem())
                .add(ModBlocks.RADIATION_HAZARD_SIGN.asItem())
                .add(ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN.asItem())
                .add(ModBlocks.BIOHAZARD_SIGN.asItem());

        tag(ModTags.Items.PROHIBITION_SIGNAGE_MATERIALS)
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.RED).asItem())
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.WHITE).asItem());

        tag(ModTags.Items.PROHIBITION_SIGNAGE)
                .add(ModBlocks.BLANK_PROHIBITION_SIGN.asItem())
                .add(ModBlocks.GENERIC_PROHIBITION_SIGN.asItem())
                .add(ModBlocks.NO_ENTRY_SIGN.asItem())
                .add(ModBlocks.NO_SWIMMING_SIGN.asItem())
                .add(ModBlocks.NO_SMOKING_SIGN.asItem())
                .add(ModBlocks.NO_EATING_SIGN.asItem())
                .add(ModBlocks.NO_DRINKING_SIGN.asItem())
                .add(ModBlocks.NO_PETS_SIGN.asItem())
                .add(ModBlocks.NO_OPEN_FIRE_SIGN.asItem())
                .add(ModBlocks.NO_TOUCHING_SIGN.asItem())
                .add(ModBlocks.NO_WEAPONS_SIGN.asItem())
                .add(ModBlocks.NO_MINING_SIGN.asItem())
                .add(ModBlocks.NO_CUTTING_TREES_SIGN.asItem())
                .add(ModBlocks.NO_SHEARING_SIGN.asItem())
                .add(ModBlocks.NO_LITTERING_SIGN.asItem());

        tag(ModTags.Items.SAFETY_SIGNAGE)
                .add(ModBlocks.BLANK_SAFETY_SIGN.asItem())
                .add(ModBlocks.ARROW_SIGN.asItem())
                .add(ModBlocks.EXIT_SIGN.asItem())
                .add(ModBlocks.WALK_SIGN.asItem())
                .add(ModBlocks.DISABLED_ACCESS_SIGN.asItem())
                .add(ModBlocks.STAIRS_SIGN.asItem())
                .add(ModBlocks.LADDER_SIGN.asItem())
                .add(ModBlocks.MEDICAL_CROSS_SIGN.asItem());

        tag(ModTags.Items.FIRE_SAFETY_SIGNAGE)
                .add(ModBlocks.BLANK_FIRE_SAFETY_SIGN.asItem())
                .add(ModBlocks.GENERIC_FIRE_SAFETY_SIGN.asItem())
                .add(ModBlocks.FIRE_SAFETY_ARROW_SIGN.asItem())
                .add(ModBlocks.FIRE_EMERGENCY_EXIT_SIGN.asItem())
                .add(ModBlocks.FIRE_EMERGENCY_STAIRS_SIGN.asItem())
                .add(ModBlocks.FIRE_EMERGENCY_LADDER_SIGN.asItem())
                .add(ModBlocks.FIRE_EMERGENCY_PHONE_SIGN.asItem())
                .add(ModBlocks.FIRE_EXTINGUISHER_SIGN.asItem())
                .add(ModBlocks.FIRE_HOSE_SIGN.asItem())
                .add(ModBlocks.FIRE_HOSE_REEL_SIGN.asItem())
                .add(ModBlocks.FIRE_ALARM_SIGN.asItem());

        tag(ModTags.Items.INSTRUCTION_SIGNAGE)
                .add(ModBlocks.BLANK_INSTRUCTION_SIGN.asItem())
                .add(ModBlocks.GENERIC_INSTRUCTION_SIGN.asItem())
                .add(ModBlocks.WEAR_EAR_PROTECTION_SIGN.asItem())
                .add(ModBlocks.WEAR_HEAD_PROTECTION_SIGN.asItem())
                .add(ModBlocks.WEAR_EYE_PROTECTION_SIGN.asItem())
                .add(ModBlocks.WEAR_RESPIRATOR_SIGN.asItem())
                .add(ModBlocks.WEAR_SAFETY_FOOTWEAR_SIGN.asItem())
                .add(ModBlocks.DISPOSE_OF_TRASH_PROPERLY_SIGN.asItem());

        tag(ModTags.Items.FIRE_DIAMOND_MATERIALS)
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.BLUE).asItem())
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.RED).asItem())
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.YELLOW).asItem())
                .add(ModBlocks.PLATING_BLOCKS.get(DyeColor.WHITE).asItem());
    }
}