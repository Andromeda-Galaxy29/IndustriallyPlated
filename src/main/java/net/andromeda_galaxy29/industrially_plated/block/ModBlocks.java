package net.andromeda_galaxy29.industrially_plated.block;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.signage.SignageBlock;
import net.andromeda_galaxy29.industrially_plated.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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
            (color) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<WaterloggedTransparentBlock>> PLATING_GRATES = registerDyedBlocks("plating_grate",
            (color) -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<Block>> CUT_PLATING = registerDyedBlocks("cut_plating",
            (color) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<StairBlock>> CUT_PLATING_STAIRS = registerDyedBlocks("cut_plating_stairs",
            (color) -> new StairBlock(
                    CUT_PLATING.get(color).get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_STAIRS).mapColor(color)
            ));

    public static final Map<DyeColor, DeferredBlock<SlabBlock>> CUT_PLATING_SLABS = registerDyedBlocks("cut_plating_slab",
            (color) -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_SLAB).mapColor(color)));

    public static final DeferredBlock<Block> HAZARD_STRIPE_BLOCK = registerBlockWithItem("hazard_stripe_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(DyeColor.YELLOW)));

    public static final DeferredBlock<Block> RADIATION_HAZARD_STRIPE_BLOCK = registerBlockWithItem("radiation_hazard_stripe_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(MapColor.TERRACOTTA_YELLOW)));

    public static final DeferredBlock<SignageBlock> BLANK_HAZARD_SIGN = registerBlockWithItem("blank_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)
                    .noOcclusion()
                    .mapColor(DyeColor.YELLOW)));

    public static final DeferredBlock<SignageBlock> GENERIC_HAZARD_SIGN = registerBlockWithItem("generic_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FALLING_HAZARD_SIGN = registerBlockWithItem("falling_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> TOXICITY_HAZARD_SIGN = registerBlockWithItem("toxicity_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> ELECTRICITY_HAZARD_SIGN = registerBlockWithItem("electricity_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_HAZARD_SIGN = registerBlockWithItem("fire_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> HEAT_HAZARD_SIGN = registerBlockWithItem("heat_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> RADIATION_HAZARD_SIGN = registerBlockWithItem("radiation_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> MAGENTA_RADIATION_HAZARD_SIGN = registerBlockWithItem("magenta_radiation_hazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));

    public static final DeferredBlock<SignageBlock> BIOHAZARD_SIGN = registerBlockWithItem("biohazard_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())));



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
