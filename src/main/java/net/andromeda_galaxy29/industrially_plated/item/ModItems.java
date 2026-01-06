package net.andromeda_galaxy29.industrially_plated.item;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(IndustriallyPlated.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
