package net.andromeda_galaxy29.industrially_plated.block;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(IndustriallyPlated.MODID);

    public static final Map<DyeColor, DeferredBlock<Block>> PLATING_BLOCKS = registerDyedBlocks("plating_block",
            (color) -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).mapColor(color)
            )
    );

    public static final Map<DyeColor, DeferredBlock<WaterloggedTransparentBlock>> PLATING_GRATES = registerDyedBlocks("plating_grate",
            (color) -> new WaterloggedTransparentBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE).mapColor(color)
            )
    );

    public static final Map<DyeColor, DeferredBlock<Block>> CUT_PLATING = registerDyedBlocks("cut_plating",
            (color) -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(color)
            )
    );

    public static final Map<DyeColor, DeferredBlock<StairBlock>> CUT_PLATING_STAIRS = registerDyedBlocks("cut_plating_stairs",
            (color) -> new StairBlock(
                    CUT_PLATING.get(color).get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_STAIRS).mapColor(color)
            )
    );

    public static final Map<DyeColor, DeferredBlock<SlabBlock>> CUT_PLATING_SLABS = registerDyedBlocks("cut_plating_slab",
            (color) -> new SlabBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_SLAB).mapColor(color)
            )
    );

    public static <T extends Block> Map<DyeColor, DeferredBlock<T>> registerDyedBlocks(String nameTemplate, Function<DyeColor, T> function) {
        Map<DyeColor, DeferredBlock<T>> map = new HashMap<>();
        for (DyeColor color : DyeColor.values()) {
            map.put(color, registerBlockWithItem(color.getName() + "_" + nameTemplate, () -> function.apply(color)));
        }
        return map;
    }

    public static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Supplier<T> supplier) {
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));
        return deferredBlock;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
