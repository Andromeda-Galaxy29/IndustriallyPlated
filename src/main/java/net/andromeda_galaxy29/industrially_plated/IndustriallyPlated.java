package net.andromeda_galaxy29.industrially_plated;

import net.andromeda_galaxy29.industrially_plated.block.ModBlocks;
import net.andromeda_galaxy29.industrially_plated.item.ModCreativeTabs;
import net.andromeda_galaxy29.industrially_plated.item.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(IndustriallyPlated.MODID)
public class IndustriallyPlated {
    public static final String MODID = "industrially_plated";
    public static final Logger LOGGER = LogUtils.getLogger();

    public IndustriallyPlated(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }
}
