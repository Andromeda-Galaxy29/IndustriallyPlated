package net.andromeda_galaxy29.industrially_plated.item;

import com.ninni.dye_depot.registry.DDDyes;
import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriallyPlated.MODID);

    public static final Supplier<CreativeModeTab> INDUSTRIALLY_PLATED_BLOCKS_TAB = CREATIVE_MODE_TABS.register("industrially_plated_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLATING_BLOCKS.get(DyeColor.GRAY).get()))
                    .title(Component.translatable("itemGroup.industrially_plated.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        DyeColor[] dyeOrder = {
                                DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
                                DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
                                DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
                                DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
                        };

                        if (IndustriallyPlated.DYE_DEPOT) {
                            dyeOrder = new DyeColor[]{
                                    DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
                                    DyeColor.BROWN, DDDyes.MAROON.get(), DDDyes.ROSE.get(), DyeColor.RED,
                                    DDDyes.CORAL.get(), DDDyes.GINGER.get(), DyeColor.ORANGE, DDDyes.TAN.get(),
                                    DDDyes.BEIGE.get(), DyeColor.YELLOW, DDDyes.AMBER.get(), DDDyes.OLIVE.get(),
                                    DyeColor.LIME, DDDyes.FOREST.get(), DyeColor.GREEN, DDDyes.VERDANT.get(),
                                    DDDyes.TEAL.get(), DyeColor.CYAN, DDDyes.MINT.get(), DDDyes.AQUA.get(),
                                    DyeColor.LIGHT_BLUE, DyeColor.BLUE, DDDyes.SLATE.get(), DDDyes.NAVY.get(),
                                    DDDyes.INDIGO.get(), DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
                            };
                        }

                        for (DyeColor color : dyeOrder) {
                            output.accept(ModBlocks.PLATING_BLOCKS.get(color));
                            output.accept(ModBlocks.PLATING_GRATES.get(color));
                            output.accept(ModBlocks.CUT_PLATING.get(color));
                            output.accept(ModBlocks.CUT_PLATING_STAIRS.get(color));
                            output.accept(ModBlocks.CUT_PLATING_SLABS.get(color));
                        }

                        output.accept(ModBlocks.HAZARD_STRIPE_BLOCK);
                        output.accept(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK);
                    }).build());

    public static final Supplier<CreativeModeTab> INDUSTRIALLY_PLATED_SIGNAGE_TAB = CREATIVE_MODE_TABS.register("industrially_plated_signage",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RADIATION_HAZARD_SIGN.get()))
                    .title(Component.translatable("itemGroup.industrially_plated.signage"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Hazard signage
                        output.accept(ModBlocks.BLANK_HAZARD_SIGN);
                        output.accept(ModBlocks.GENERIC_HAZARD_SIGN);
                        output.accept(ModBlocks.FALLING_HAZARD_SIGN);
                        output.accept(ModBlocks.TOXICITY_HAZARD_SIGN);
                        output.accept(ModBlocks.ELECTRICITY_HAZARD_SIGN);
                        output.accept(ModBlocks.FIRE_HAZARD_SIGN);
                        output.accept(ModBlocks.HEAT_HAZARD_SIGN);
                        output.accept(ModBlocks.RADIATION_HAZARD_SIGN);
                        output.accept(ModBlocks.MAGENTA_RADIATION_HAZARD_SIGN);
                        output.accept(ModBlocks.BIOHAZARD_SIGN);
                        // Prohibition signage
                        output.accept(ModBlocks.BLANK_PROHIBITION_SIGN);
                        output.accept(ModBlocks.GENERIC_PROHIBITION_SIGN);
                        output.accept(ModBlocks.NO_ENTRY_SIGN);
                        output.accept(ModBlocks.NO_SWIMMING_SIGN);
                        output.accept(ModBlocks.NO_SMOKING_SIGN);
                        output.accept(ModBlocks.NO_EATING_SIGN);
                        output.accept(ModBlocks.NO_DRINKING_SIGN);
                        output.accept(ModBlocks.NO_PETS_SIGN);
                        output.accept(ModBlocks.NO_OPEN_FIRE_SIGN);
                        output.accept(ModBlocks.NO_TOUCHING_SIGN);
                        output.accept(ModBlocks.NO_WEAPONS_SIGN);
                        output.accept(ModBlocks.NO_MINING_SIGN);
                        output.accept(ModBlocks.NO_CUTTING_TREES_SIGN);
                        output.accept(ModBlocks.NO_SHEARING_SIGN);
                        output.accept(ModBlocks.NO_LITTERING_SIGN);
                        // Safety signage
                        output.accept(ModBlocks.BLANK_SAFETY_SIGN);
                        output.accept(ModBlocks.ARROW_SIGN);
                        output.accept(ModBlocks.EXIT_SIGN);
                        output.accept(ModBlocks.WALK_SIGN);
                        output.accept(ModBlocks.DISABLED_ACCESS_SIGN);
                        output.accept(ModBlocks.STAIRS_SIGN);
                        output.accept(ModBlocks.LADDER_SIGN);
                        output.accept(ModBlocks.MEDICAL_CROSS_SIGN);
                        // Instruction signage
                        output.accept(ModBlocks.BLANK_INSTRUCTION_SIGN);
                        output.accept(ModBlocks.GENERIC_INSTRUCTION_SIGN);
                        output.accept(ModBlocks.WEAR_EAR_PROTECTION_SIGN);
                        output.accept(ModBlocks.WEAR_HEAD_PROTECTION_SIGN);
                        output.accept(ModBlocks.WEAR_EYE_PROTECTION_SIGN);
                        output.accept(ModBlocks.WEAR_RESPIRATOR_SIGN);
                        output.accept(ModBlocks.WEAR_SAFETY_FOOTWEAR_SIGN);
                        output.accept(ModBlocks.DISPOSE_OF_TRASH_PROPERLY_SIGN);
                        // Fire diamond
                        output.accept(ModBlocks.FIRE_DIAMOND_SIGN);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
