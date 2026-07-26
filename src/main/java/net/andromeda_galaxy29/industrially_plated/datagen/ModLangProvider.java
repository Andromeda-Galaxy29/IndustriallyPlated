package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, IndustriallyPlated.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addTooltipTranslations();
        addTabTranslations();
        addBlockTranslations();
    }

    private void addTooltipTranslations() {
        add("tooltip.industrially_plated.mirror", "- Right click to mirror");
        add("tooltip.industrially_plated.rotate_cw", "- Right click to rotate clockwise");
        add("tooltip.industrially_plated.rotate_ccw", "- Crouch + right click to rotate counter-clockwise");
        add("tooltip.industrially_plated.wax", "- Can be waxed to lock the current state. Use axe to unlock");
    }

    private void addTabTranslations() {
        add("itemGroup.industrially_plated.blocks", "Industrially Plated: Blocks");
        add("itemGroup.industrially_plated.signage", "Industrially Plated: Signage");
    }

    private String getDyeName(DyeColor color) {
        String[] words = color.getName().split("_");
        return String.join(" ", Arrays.stream(words)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).toList());
    }

    private void addBlockTranslations() {
        for (DyeColor color : DyeColor.values()) {
            addBlock(ModBlocks.PLATING_BLOCKS.get(color), getDyeName(color) + " Plating Block");
            addBlock(ModBlocks.PLATING_GRATES.get(color), getDyeName(color) + " Plating Grate");
            addBlock(ModBlocks.CUT_PLATING.get(color), getDyeName(color) + " Cut Plating");
            addBlock(ModBlocks.CUT_PLATING_STAIRS.get(color), getDyeName(color) + " Cut Plating Stairs");
            addBlock(ModBlocks.CUT_PLATING_SLABS.get(color), getDyeName(color) + " Cut Plating Slab");
        }

        addBlock(ModBlocks.HAZARD_STRIPE_BLOCK, "Hazard Stripe Block");
        addBlock(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK, "Radiation Hazard Stripe Block");

        addBlock(ModBlocks.BLANK_HAZARD_SIGN, "Blank Hazard Sign");
        addBlock(ModBlocks.GENERIC_HAZARD_SIGN, "Generic Hazard Sign");
        addBlock(ModBlocks.FALLING_HAZARD_SIGN, "Falling Hazard Sign");
        addBlock(ModBlocks.TOXICITY_HAZARD_SIGN, "Toxicity Hazard Sign");
        addBlock(ModBlocks.ELECTRICITY_HAZARD_SIGN, "Electricity Hazard Sign");
        addBlock(ModBlocks.FIRE_HAZARD_SIGN, "Fire Hazard Sign");
        addBlock(ModBlocks.HEAT_HAZARD_SIGN, "Heat Hazard Sign");
        addBlock(ModBlocks.RADIATION_HAZARD_SIGN, "Radiation Hazard Sign");
        addBlock(ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN, "Magenta Radiation Hazard Sign");
        addBlock(ModBlocks.BIOHAZARD_SIGN, "Biohazard sign");

        addBlock(ModBlocks.BLANK_PROHIBITION_SIGN, "Blank Prohibition Sign");
        addBlock(ModBlocks.GENERIC_PROHIBITION_SIGN, "Generic Prohibition Sign");
        addBlock(ModBlocks.NO_ENTRY_SIGN, "No Entry Sign");
        addBlock(ModBlocks.NO_SWIMMING_SIGN, "No Swimming Sign");
        addBlock(ModBlocks.NO_SMOKING_SIGN, "No Smoking Sign");
        addBlock(ModBlocks.NO_EATING_SIGN, "No Eating Sign");
        addBlock(ModBlocks.NO_DRINKING_SIGN, "No Drinking Sign");
        addBlock(ModBlocks.NO_PETS_SIGN, "No Pets Sign");
        addBlock(ModBlocks.NO_OPEN_FIRE_SIGN, "No Open Fire Sign");
        addBlock(ModBlocks.NO_TOUCHING_SIGN, "No Touching Sign");
        addBlock(ModBlocks.NO_WEAPONS_SIGN, "No Weapons Sign");
        addBlock(ModBlocks.NO_MINING_SIGN, "No Mining Sign");
        addBlock(ModBlocks.NO_CUTTING_TREES_SIGN, "No Cutting Trees Sign");
        addBlock(ModBlocks.NO_SHEARING_SIGN, "No Shearing Sign");
        addBlock(ModBlocks.NO_LITTERING_SIGN, "No Littering Sign");

        addBlock(ModBlocks.BLANK_SAFETY_SIGN, "Blank Safety Sign");
        addBlock(ModBlocks.ARROW_SIGN, "Arrow Sign");
        addBlock(ModBlocks.EXIT_SIGN, "Exit Sign");
        addBlock(ModBlocks.WALK_SIGN, "Walk Sign");
        addBlock(ModBlocks.DISABLED_ACCESS_SIGN, "Disabled Access Sign");
        addBlock(ModBlocks.STAIRS_SIGN, "Stairs Sign");
        addBlock(ModBlocks.LADDER_SIGN, "Ladder Sign");
        addBlock(ModBlocks.MEDICAL_CROSS_SIGN, "Medical Cross Sign");

        addBlock(ModBlocks.BLANK_FIRE_SAFETY_SIGN, "Blank Fire Safety Sign");
        addBlock(ModBlocks.GENERIC_FIRE_SAFETY_SIGN, "Generic Fire Safety Sign");
        addBlock(ModBlocks.FIRE_SAFETY_ARROW_SIGN, "Fire Safety Arrow Sign");
        addBlock(ModBlocks.FIRE_EMERGENCY_EXIT_SIGN, "Fire Emergency Exit Sign");
        addBlock(ModBlocks.FIRE_EMERGENCY_STAIRS_SIGN, "Fire Emergency Stairs Sign");
        addBlock(ModBlocks.FIRE_EMERGENCY_LADDER_SIGN, "Fire Emergency Ladder Sign");
        addBlock(ModBlocks.FIRE_EMERGENCY_PHONE_SIGN, "Fire Emergency Phone Sign");
        addBlock(ModBlocks.FIRE_EXTINGUISHER_SIGN, "Fire Extinguisher Sign");
        addBlock(ModBlocks.FIRE_HOSE_SIGN, "Fire Hose Sign");
        addBlock(ModBlocks.FIRE_HOSE_REEL_SIGN, "Fire Hose Reel Sign");
        addBlock(ModBlocks.FIRE_ALARM_SIGN, "Fire Alarm Sign");

        addBlock(ModBlocks.BLANK_INSTRUCTION_SIGN, "Blank Instruction Sign");
        addBlock(ModBlocks.GENERIC_INSTRUCTION_SIGN, "Generic Instruction Sign");
        addBlock(ModBlocks.WEAR_EAR_PROTECTION_SIGN, "Wear Ear Protection Sign");
        addBlock(ModBlocks.WEAR_HEAD_PROTECTION_SIGN, "Wear Head Protection Sign");
        addBlock(ModBlocks.WEAR_EYE_PROTECTION_SIGN, "Wear Eye Protection Sign");
        addBlock(ModBlocks.WEAR_RESPIRATOR_SIGN, "Wear Respirator Sign");
        addBlock(ModBlocks.WEAR_SAFETY_FOOTWEAR_SIGN, "Wear Safety Footwear Sign");
        addBlock(ModBlocks.DISPOSE_OF_TRASH_PROPERLY_SIGN, "Dispose of Waste Properly Sign");

        addBlock(ModBlocks.FIRE_DIAMOND_SIGN, "Fire Diamond Sign");
    }
}
