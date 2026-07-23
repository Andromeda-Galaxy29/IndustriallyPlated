package net.andromeda_galaxy29.industrially_plated.block;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.signage.DirectionalSignageBlock;
import net.andromeda_galaxy29.industrially_plated.block.signage.MirrorableSignageBlock;
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

    // Plating blocks
    public static final Map<DyeColor, DeferredBlock<Block>> PLATING_BLOCKS = registerDyedBlocks("plating_block",
            (color) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<WaterloggedTransparentBlock>> PLATING_GRATES = registerDyedBlocks("plating_grate",
            (color) -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<Block>> CUT_PLATING = registerDyedBlocks("cut_plating",
            (color) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<StairBlock>> CUT_PLATING_STAIRS = registerDyedBlocks("cut_plating_stairs",
            (color) -> new StairBlock(
                    CUT_PLATING.get(color).get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_STAIRS).mapColor(color)));

    public static final Map<DyeColor, DeferredBlock<SlabBlock>> CUT_PLATING_SLABS = registerDyedBlocks("cut_plating_slab",
            (color) -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER_SLAB).mapColor(color)));

    // Stripe blocks
    public static final DeferredBlock<Block> HAZARD_STRIPE_BLOCK = registerBlockWithItem("hazard_stripe_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(DyeColor.YELLOW)));

    public static final DeferredBlock<Block> RADIATION_HAZARD_STRIPE_BLOCK = registerBlockWithItem("radiation_hazard_stripe_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER).mapColor(MapColor.TERRACOTTA_YELLOW)));

    // Hazard signage
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

    // Prohibition signage
    public static final DeferredBlock<SignageBlock> BLANK_PROHIBITION_SIGN = registerBlockWithItem("blank_prohibition_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())
                    .mapColor(DyeColor.PINK)));

    public static final DeferredBlock<SignageBlock> GENERIC_PROHIBITION_SIGN = registerBlockWithItem("generic_prohibition_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_ENTRY_SIGN = registerBlockWithItem("no_entry_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_SWIMMING_SIGN = registerBlockWithItem("no_swimming_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_SMOKING_SIGN = registerBlockWithItem("no_smoking_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_EATING_SIGN = registerBlockWithItem("no_eating_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_DRINKING_SIGN = registerBlockWithItem("no_drinking_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_PETS_SIGN = registerBlockWithItem("no_pets_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_OPEN_FIRE_SIGN = registerBlockWithItem("no_open_fire_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_TOUCHING_SIGN = registerBlockWithItem("no_touching_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_WEAPONS_SIGN = registerBlockWithItem("no_weapons_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_MINING_SIGN = registerBlockWithItem("no_mining_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_CUTTING_TREES_SIGN = registerBlockWithItem("no_cutting_trees_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_SHEARING_SIGN = registerBlockWithItem("no_shearing_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> NO_LITTERING_SIGN = registerBlockWithItem("no_littering_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_PROHIBITION_SIGN.get())));

    // Safety signage
    public static final DeferredBlock<SignageBlock> BLANK_SAFETY_SIGN = registerBlockWithItem("blank_safety_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())
                    .mapColor(DyeColor.GREEN)));

    public static final DeferredBlock<DirectionalSignageBlock> ARROW_SIGN = registerBlockWithItem("arrow_sign",
            () -> new DirectionalSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> EXIT_SIGN = registerBlockWithItem("exit_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> WALK_SIGN = registerBlockWithItem("walk_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> DISABLED_ACCESS_SIGN = registerBlockWithItem("disabled_access_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> STAIRS_SIGN = registerBlockWithItem("stairs_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> LADDER_SIGN = registerBlockWithItem("ladder_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> MEDICAL_CROSS_SIGN = registerBlockWithItem("medical_cross_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_SAFETY_SIGN.get())));

    // Fire safety signage
    public static final DeferredBlock<SignageBlock> BLANK_FIRE_SAFETY_SIGN = registerBlockWithItem("blank_fire_safety_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())
                    .mapColor(DyeColor.RED)));

    public static final DeferredBlock<SignageBlock> GENERIC_FIRE_SAFETY_SIGN = registerBlockWithItem("generic_fire_safety_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<DirectionalSignageBlock> FIRE_SAFETY_ARROW_SIGN = registerBlockWithItem("fire_safety_arrow_sign",
            () -> new DirectionalSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> FIRE_EMERGENCY_EXIT_SIGN = registerBlockWithItem("fire_emergency_exit_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<MirrorableSignageBlock> FIRE_EMERGENCY_STAIRS_SIGN = registerBlockWithItem("fire_emergency_stairs_sign",
            () -> new MirrorableSignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_EMERGENCY_LADDER_SIGN = registerBlockWithItem("fire_emergency_ladder_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_EMERGENCY_PHONE_SIGN = registerBlockWithItem("fire_emergency_phone_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_EXTINGUISHER_SIGN = registerBlockWithItem("fire_extinguisher_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_HOSE_SIGN = registerBlockWithItem("fire_hose_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_HOSE_REEL_SIGN = registerBlockWithItem("fire_hose_reel_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    public static final DeferredBlock<SignageBlock> FIRE_ALARM_SIGN = registerBlockWithItem("fire_alarm_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_FIRE_SAFETY_SIGN.get())));

    // Instruction signage
    public static final DeferredBlock<SignageBlock> BLANK_INSTRUCTION_SIGN = registerBlockWithItem("blank_instruction_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())
                    .mapColor(DyeColor.BLUE)));

    public static final DeferredBlock<SignageBlock> GENERIC_INSTRUCTION_SIGN = registerBlockWithItem("generic_instruction_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> WEAR_EAR_PROTECTION_SIGN = registerBlockWithItem("wear_ear_protection_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> WEAR_HEAD_PROTECTION_SIGN = registerBlockWithItem("wear_head_protection_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> WEAR_EYE_PROTECTION_SIGN = registerBlockWithItem("wear_eye_protection_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> WEAR_RESPIRATOR_SIGN = registerBlockWithItem("wear_respirator_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> WEAR_SAFETY_FOOTWEAR_SIGN = registerBlockWithItem("wear_safety_footwear_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    public static final DeferredBlock<SignageBlock> DISPOSE_OF_TRASH_PROPERLY_SIGN = registerBlockWithItem("dispose_of_trash_properly_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_INSTRUCTION_SIGN.get())));

    // Fire diamond
    public static final DeferredBlock<SignageBlock> FIRE_DIAMOND_SIGN = registerBlockWithItem("fire_diamond_sign",
            () -> new SignageBlock(BlockBehaviour.Properties.ofFullCopy(BLANK_HAZARD_SIGN.get())
                    .mapColor(DyeColor.GRAY)));


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
