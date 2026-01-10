package net.andromeda_galaxy29.industrially_plated.datagen;

import net.andromeda_galaxy29.industrially_plated.IndustriallyPlated;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = IndustriallyPlated.MODID)
public class ModDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(packOutput, Set.of(), List.of(
                        new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)
                ), lookupProvider)
        );

        ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        event.getGenerator().addProvider(event.includeServer(), modBlockTagsProvider);
        event.getGenerator().addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, modBlockTagsProvider.contentsGetter(), existingFileHelper));

        event.getGenerator().addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
    }
}
