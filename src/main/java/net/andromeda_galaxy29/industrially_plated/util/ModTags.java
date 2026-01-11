package net.andromeda_galaxy29.industrially_plated.util;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(IndustriallyPlated.MODID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(IndustriallyPlated.MODID, name));
        }

        public static final TagKey<Item> PLATING_BLOCKS = createTag("plating_blocks");
        public static final TagKey<Item> PLATING_GRATES = createTag("plating_grates");
        public static final TagKey<Item> CUT_PLATING = createTag("cut_plating");
        public static final TagKey<Item> CUT_PLATING_STAIRS = createTag("cut_plating_stairs");
        public static final TagKey<Item> CUT_PLATING_SLABS = createTag("cut_plating_slabs");
        public static final TagKey<Item> HAZARD_SIGNAGE = createTag("hazard_signage");
    }
}
