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

        simpleBlockItem(ModBlocks.BLANK_SAFETY_SIGN.get());
        customBlockItem(ModBlocks.ARROW_SIGN.get(), "block/arrow_sign_right");
    }

    public ItemModelBuilder customBlockItem(Block block, String path) {
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        return withExistingParent(location.toString(), ResourceLocation.fromNamespaceAndPath(location.getNamespace(), path));
    }
}
