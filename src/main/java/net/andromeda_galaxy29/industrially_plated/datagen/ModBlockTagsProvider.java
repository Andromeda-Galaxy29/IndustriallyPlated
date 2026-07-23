package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
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
            ResourceLocation[] platingBlocks = {
                    ModBlocks.PLATING_BLOCKS.get(color).getId(),
                    ModBlocks.PLATING_GRATES.get(color).getId(),
                    ModBlocks.CUT_PLATING.get(color).getId(),
                    ModBlocks.CUT_PLATING_STAIRS.get(color).getId(),
                    ModBlocks.CUT_PLATING_SLABS.get(color).getId()
            };

            for (ResourceLocation block : platingBlocks) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(block);
                tag(BlockTags.NEEDS_STONE_TOOL).addOptional(block);
                tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addOptional(block);
                tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).addOptional(block);
            }
        }

        Block[] metalBlocks = {
                // Stripe blocks
                ModBlocks.HAZARD_STRIPE_BLOCK.get(),
                ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get(),
                // Hazard signage
                ModBlocks.BLANK_HAZARD_SIGN.get(),
                ModBlocks.GENERIC_HAZARD_SIGN.get(),
                ModBlocks.FALLING_HAZARD_SIGN.get(),
                ModBlocks.TOXICITY_HAZARD_SIGN.get(),
                ModBlocks.ELECTRICITY_HAZARD_SIGN.get(),
                ModBlocks.FIRE_HAZARD_SIGN.get(),
                ModBlocks.HEAT_HAZARD_SIGN.get(),
                ModBlocks.RADIATION_HAZARD_SIGN.get(),
                ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN.get(),
                ModBlocks.BIOHAZARD_SIGN.get(),
                //Prohibition signage
                ModBlocks.BLANK_PROHIBITION_SIGN.get(),
                ModBlocks.GENERIC_PROHIBITION_SIGN.get(),
                ModBlocks.NO_ENTRY_SIGN.get(),
                ModBlocks.NO_SWIMMING_SIGN.get(),
                ModBlocks.NO_SMOKING_SIGN.get(),
                ModBlocks.NO_EATING_SIGN.get(),
                ModBlocks.NO_DRINKING_SIGN.get(),
                ModBlocks.NO_PETS_SIGN.get(),
                ModBlocks.NO_OPEN_FIRE_SIGN.get(),
                ModBlocks.NO_TOUCHING_SIGN.get(),
                ModBlocks.NO_WEAPONS_SIGN.get(),
                ModBlocks.NO_MINING_SIGN.get(),
                ModBlocks.NO_CUTTING_TREES_SIGN.get(),
                ModBlocks.NO_SHEARING_SIGN.get(),
                ModBlocks.NO_LITTERING_SIGN.get(),
                // Safety signage
                ModBlocks.BLANK_SAFETY_SIGN.get(),
                ModBlocks.ARROW_SIGN.get(),
                ModBlocks.EXIT_SIGN.get(),
                ModBlocks.WALK_SIGN.get(),
                ModBlocks.DISABLED_ACCESS_SIGN.get(),
                ModBlocks.STAIRS_SIGN.get(),
                ModBlocks.LADDER_SIGN.get(),
                ModBlocks.MEDICAL_CROSS_SIGN.get(),
                // Fire safety signage
                ModBlocks.BLANK_FIRE_SAFETY_SIGN.get(),
                ModBlocks.GENERIC_FIRE_SAFETY_SIGN.get(),
                ModBlocks.FIRE_SAFETY_ARROW_SIGN.get(),
                ModBlocks.FIRE_EMERGENCY_EXIT_SIGN.get(),
                ModBlocks.FIRE_EMERGENCY_STAIRS_SIGN.get(),
                ModBlocks.FIRE_EMERGENCY_LADDER_SIGN.get(),
                ModBlocks.FIRE_EMERGENCY_PHONE_SIGN.get(),
                ModBlocks.FIRE_EXTINGUISHER_SIGN.get(),
                ModBlocks.FIRE_HOSE_SIGN.get(),
                ModBlocks.FIRE_HOSE_REEL_SIGN.get(),
                ModBlocks.FIRE_ALARM_SIGN.get(),
                // Instruction signage
                ModBlocks.BLANK_INSTRUCTION_SIGN.get(),
                ModBlocks.GENERIC_INSTRUCTION_SIGN.get(),
                ModBlocks.WEAR_EAR_PROTECTION_SIGN.get(),
                ModBlocks.WEAR_HEAD_PROTECTION_SIGN.get(),
                ModBlocks.WEAR_EYE_PROTECTION_SIGN.get(),
                ModBlocks.WEAR_RESPIRATOR_SIGN.get(),
                ModBlocks.WEAR_SAFETY_FOOTWEAR_SIGN.get(),
                ModBlocks.DISPOSE_OF_TRASH_PROPERLY_SIGN.get(),
                // Fire diamond
                ModBlocks.FIRE_DIAMOND_SIGN.get()
        };

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(metalBlocks);
        tag(BlockTags.NEEDS_STONE_TOOL).add(metalBlocks);
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(metalBlocks);
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).add(metalBlocks);
    }
}