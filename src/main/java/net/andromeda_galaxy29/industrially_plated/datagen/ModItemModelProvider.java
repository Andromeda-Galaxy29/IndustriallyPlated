package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
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
            simpleBlockItem(ModBlocks.PLATING_GRATES.get(color).get());
            simpleBlockItem(ModBlocks.CUT_PLATING.get(color).get());
            simpleBlockItem(ModBlocks.CUT_PLATING_STAIRS.get(color).get());
            simpleBlockItem(ModBlocks.CUT_PLATING_SLABS.get(color).get());
        }

        simpleBlockItem(ModBlocks.HAZARD_STRIPE_BLOCK.get());
        simpleBlockItem(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get());

        simpleBlockItem(ModBlocks.BLANK_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.GENERIC_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.FALLING_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.TOXICITY_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.ELECTRICITY_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.HEAT_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.RADIATION_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN.get());
        simpleBlockItem(ModBlocks.BIOHAZARD_SIGN.get());

        simpleBlockItem(ModBlocks.BLANK_PROHIBITION_SIGN.get());
        simpleBlockItem(ModBlocks.GENERIC_PROHIBITION_SIGN.get());
        simpleBlockItem(ModBlocks.NO_ENTRY_SIGN.get());
        simpleBlockItem(ModBlocks.NO_SWIMMING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_SMOKING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_EATING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_DRINKING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_PETS_SIGN.get());
        simpleBlockItem(ModBlocks.NO_OPEN_FIRE_SIGN.get());
        simpleBlockItem(ModBlocks.NO_TOUCHING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_WEAPONS_SIGN.get());
        simpleBlockItem(ModBlocks.NO_MINING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_CUTTING_TREES_SIGN.get());
        simpleBlockItem(ModBlocks.NO_SHEARING_SIGN.get());
        simpleBlockItem(ModBlocks.NO_LITTERING_SIGN.get());

        simpleBlockItem(ModBlocks.BLANK_SAFETY_SIGN.get());
        customBlockItem(ModBlocks.ARROW_SIGN.get(), "block/arrow_sign_right");
        simpleBlockItem(ModBlocks.EXIT_SIGN.get());
        simpleBlockItem(ModBlocks.WALK_SIGN.get());
        simpleBlockItem(ModBlocks.DISABLED_ACCESS_SIGN.get());
        simpleBlockItem(ModBlocks.STAIRS_SIGN.get());
        simpleBlockItem(ModBlocks.LADDER_SIGN.get());
        simpleBlockItem(ModBlocks.MEDICAL_CROSS_SIGN.get());

        simpleBlockItem(ModBlocks.BLANK_FIRE_SAFETY_SIGN.get());
        simpleBlockItem(ModBlocks.GENERIC_FIRE_SAFETY_SIGN.get());
        customBlockItem(ModBlocks.FIRE_SAFETY_ARROW_SIGN.get(), "block/fire_safety_arrow_sign_right");
        simpleBlockItem(ModBlocks.FIRE_EMERGENCY_EXIT_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_EMERGENCY_STAIRS_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_EMERGENCY_LADDER_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_EMERGENCY_PHONE_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_EXTINGUISHER_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_HOSE_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_HOSE_REEL_SIGN.get());
        simpleBlockItem(ModBlocks.FIRE_ALARM_SIGN.get());

        simpleBlockItem(ModBlocks.BLANK_INSTRUCTION_SIGN.get());
        simpleBlockItem(ModBlocks.GENERIC_INSTRUCTION_SIGN.get());
        simpleBlockItem(ModBlocks.WEAR_EAR_PROTECTION_SIGN.get());
        simpleBlockItem(ModBlocks.WEAR_HEAD_PROTECTION_SIGN.get());
        simpleBlockItem(ModBlocks.WEAR_EYE_PROTECTION_SIGN.get());
        simpleBlockItem(ModBlocks.WEAR_RESPIRATOR_SIGN.get());
        simpleBlockItem(ModBlocks.WEAR_SAFETY_FOOTWEAR_SIGN.get());
        simpleBlockItem(ModBlocks.DISPOSE_OF_TRASH_PROPERLY_SIGN.get());

        simpleBlockItem(ModBlocks.FIRE_DIAMOND_SIGN.get());
    }

    public ItemModelBuilder customBlockItem(Block block, String path) {
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        return withExistingParent(location.toString(), ResourceLocation.fromNamespaceAndPath(location.getNamespace(), path));
    }
}
