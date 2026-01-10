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
                            output.accept(ModBlocks.PLATING_BLOCKS.get(color).get());
                            output.accept(ModBlocks.PLATING_GRATES.get(color).get());
                            output.accept(ModBlocks.CUT_PLATING.get(color).get());
                            output.accept(ModBlocks.CUT_PLATING_STAIRS.get(color).get());
                            output.accept(ModBlocks.CUT_PLATING_SLABS.get(color).get());
                        }
                        output.accept(ModBlocks.HAZARD_STRIPE_BLOCK.get());
                        output.accept(ModBlocks.RADIATION_HAZARD_STRIPE_BLOCK.get());
                        output.accept(ModBlocks.CAUTION_STRIPE_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
