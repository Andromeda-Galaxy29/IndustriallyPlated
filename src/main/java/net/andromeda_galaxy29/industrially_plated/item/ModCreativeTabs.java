package net.andromeda_galaxy29.industrially_plated.item;

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

    public static final Supplier<CreativeModeTab> INDUSTRIALLY_PLATED_TAB = CREATIVE_MODE_TABS.register("industrially_plated",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLATING_BLOCKS.get(DyeColor.GRAY).get()))
                    .title(Component.translatable("itemGroup.industrially_plated"))
                    .displayItems((itemDisplayParameters, output) -> {
                        DyeColor[] dyeOrder = {
                                DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
                                DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
                                DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
                                DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
                        };

                        for (DyeColor color : dyeOrder) {
                            output.accept(ModBlocks.PLATING_BLOCKS.get(color));
                            output.accept(ModBlocks.PLATING_GRATES.get(color));
                            output.accept(ModBlocks.CUT_PLATING.get(color));
                            output.accept(ModBlocks.CUT_PLATING_STAIRS.get(color));
                            output.accept(ModBlocks.CUT_PLATING_SLABS.get(color));
                        }

                        output.accept(ModBlocks.HAZARD_STRIPE_BLOCK);
                        output.accept(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK);

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

                        output.accept(ModBlocks.BLANK_SAFETY_SIGN);
                        output.accept(ModBlocks.ARROW_SIGN);
                        output.accept(ModBlocks.EXIT_SIGN);
                        output.accept(ModBlocks.WALK_SIGN);
                        output.accept(ModBlocks.STAIRS_SIGN);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
