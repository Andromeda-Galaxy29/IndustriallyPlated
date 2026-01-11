package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.andromeda_galaxy29.industrially_plated.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        DeferredBlock grayPlatingBlock = ModBlocks.PLATING_BLOCKS.get(DyeColor.GRAY);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Tags.Items.INGOTS_IRON), RecipeCategory.BUILDING_BLOCKS, grayPlatingBlock)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput, modLoc("stonecutting/" + name(grayPlatingBlock)));

        for (DyeColor color : DyeColor.values()) {
            // Plating Block
            DeferredBlock platingBlock = ModBlocks.PLATING_BLOCKS.get(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, platingBlock, 8)
                    .group(modLocString("plating_block_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', ModTags.Items.PLATING_BLOCKS)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(platingBlock) + "_dyeing"));

            // Plating Grate
            DeferredBlock platingGrate = ModBlocks.PLATING_GRATES.get(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, platingGrate, 4)
                    .group(modLocString("plating_grates"))
                    .pattern(" P ")
                    .pattern("P P")
                    .pattern(" P ")
                    .define('P', platingBlock)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(platingGrate)));

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, platingGrate, 8)
                    .group(modLocString("plating_grate_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', ModTags.Items.PLATING_GRATES)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(platingGrate) + "_dyeing"));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, platingGrate, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(platingGrate)));

            // Cut Plating
            DeferredBlock cutPlating = ModBlocks.CUT_PLATING.get(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlating, 4)
                    .group(modLocString("cut_plating"))
                    .pattern("PP")
                    .pattern("PP")
                    .define('P', platingBlock)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlating)));

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlating, 8)
                    .group(modLocString("cut_plating_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', ModTags.Items.CUT_PLATING)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlating) + "_dyeing"));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlating, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlating)));

            // Cut Plating Stairs
            DeferredBlock cutPlatingStairs = ModBlocks.CUT_PLATING_STAIRS.get(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 4)
                    .group(modLocString("cut_plating_stairs"))
                    .pattern("C  ")
                    .pattern("CC ")
                    .pattern("CCC")
                    .define('C', cutPlating)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingStairs)));

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 8)
                    .group(modLocString("cut_plating_stairs_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', ModTags.Items.CUT_PLATING_STAIRS)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingStairs) + "_dyeing"));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(cutPlating), RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 1)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingStairs)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingStairs) + "_from_plating_block"));

            // Cut Plating Slab
            DeferredBlock cutPlatingSlab = ModBlocks.CUT_PLATING_SLABS.get(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 6)
                    .group(modLocString("cut_plating_slabs"))
                    .pattern("CCC")
                    .define('C', cutPlating)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingSlab)));

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 8)
                    .group(modLocString("cut_plating_slab_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', ModTags.Items.CUT_PLATING_SLABS)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingSlab) + "_dyeing"));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(cutPlating), RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 2)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingSlab)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 8)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingSlab) + "_from_plating_block"));
        }

        // Stripe blocks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZARD_STRIPE_BLOCK, 2)
                .requires(ModTags.Items.PLATING_BLOCKS)
                .requires(Tags.Items.DYES_YELLOW)
                .requires(Tags.Items.DYES_BLACK)
                .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                .save(recipeOutput, modLoc("shapeless/" + name(ModBlocks.HAZARD_STRIPE_BLOCK)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK, 2)
                .requires(ModTags.Items.PLATING_BLOCKS)
                .requires(Tags.Items.DYES_YELLOW)
                .requires(Tags.Items.DYES_MAGENTA)
                .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                .save(recipeOutput, modLoc("shapeless/" + name(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAUTION_STRIPE_BLOCK, 2)
                .requires(ModTags.Items.PLATING_BLOCKS)
                .requires(Tags.Items.DYES_RED)
                .requires(Tags.Items.DYES_WHITE)
                .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                .save(recipeOutput, modLoc("shapeless/" + name(ModBlocks.CAUTION_STRIPE_BLOCK)));

        // Hazard signs
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.HAZARD_SIGNAGE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLANK_HAZARD_SIGN, 1)
                .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                .save(recipeOutput, modLoc("stonecutting/hazard_sign_clearing"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.PLATING_BLOCKS.get(DyeColor.YELLOW)), RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLANK_HAZARD_SIGN, 4)
                .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                .save(recipeOutput, modLoc("stonecutting/" + name(ModBlocks.BLANK_HAZARD_SIGN)));
    }

    private String name(DeferredBlock deferredBlock) {
        return deferredBlock.getKey().location().getPath();
    }

    public ResourceLocation modLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(IndustriallyPlated.MODID, name);
    }

    public String modLocString(String name) {
        return IndustriallyPlated.MODID + ":" + name;
    }
}
