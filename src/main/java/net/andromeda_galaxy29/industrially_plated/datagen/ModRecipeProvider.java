package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        Block grayPlatingBlock = ModBlocks.PLATING_BLOCKS.get(DyeColor.GRAY).get();
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Tags.Items.INGOTS_IRON), RecipeCategory.BUILDING_BLOCKS, grayPlatingBlock)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput, modLoc("stonecutting/" + name(grayPlatingBlock)));

        for (DyeColor color : DyeColor.values()) {
            Block platingBlock = ModBlocks.PLATING_BLOCKS.get(color).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, platingBlock, 8)
                    .group(modLocString("plating_block_dyeing"))
                    .pattern("PPP")
                    .pattern("PDP")
                    .pattern("PPP")
                    .define('P', grayPlatingBlock)
                    .define('D', color.getTag())
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(platingBlock) + "_dyeing"));
            //TODO: More dyeing recipes, make them accept any color of block

            Block platingGrate = ModBlocks.PLATING_GRATES.get(color).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, platingGrate, 4)
                    .group(modLocString("plating_grates"))
                    .pattern(" P ")
                    .pattern("P P")
                    .pattern(" P ")
                    .define('P', platingBlock)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(platingGrate)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, platingGrate, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(platingGrate)));

            Block cutPlating = ModBlocks.CUT_PLATING.get(color).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlating, 4)
                    .group(modLocString("cut_plating"))
                    .pattern("PP")
                    .pattern("PP")
                    .define('P', platingBlock)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlating)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlating, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlating)));

            Block cutPlatingStairs = ModBlocks.CUT_PLATING_STAIRS.get(color).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 4)
                    .group(modLocString("cut_plating_stairs"))
                    .pattern("C  ")
                    .pattern("CC ")
                    .pattern("CCC")
                    .define('C', cutPlating)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingStairs)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(cutPlating), RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 1)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingStairs)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlatingStairs, 4)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingStairs) + "_from_plating_block"));

            Block cutPlatingSlab = ModBlocks.CUT_PLATING_SLABS.get(color).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 6)
                    .group(modLocString("cut_plating_slabs"))
                    .pattern("CCC")
                    .define('C', cutPlating)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("shaped/" + name(cutPlatingSlab)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(cutPlating), RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 2)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingSlab)));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(platingBlock), RecipeCategory.BUILDING_BLOCKS, cutPlatingSlab, 8)
                    .unlockedBy("has_gray_plating_block", has(grayPlatingBlock))
                    .save(recipeOutput, modLoc("stonecutting/" + name(cutPlatingSlab) + "_from_plating_block"));
        }
    }

    private String name(Block block) {
        return BuiltInRegistries.ITEM.getKey(block.asItem()).getPath();
    }

    public ResourceLocation modLoc(String name) {
        return ResourceLocation.fromNamespaceAndPath(IndustriallyPlated.MODID, name);
    }

    public String modLocString(String name) {
        return IndustriallyPlated.MODID + ":" + name;
    }
}
