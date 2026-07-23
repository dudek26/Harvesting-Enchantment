package eu.dudko.harvesting_enchantment.neoforge;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.neoforge.data.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(HarvestingEnchantment.MOD_ID)
@EventBusSubscriber(modid = HarvestingEnchantment.MOD_ID)
public class HarvestingEnchantmentNeoForge {

    public HarvestingEnchantmentNeoForge(IEventBus eventBus) {
        HarvestingEnchantment.init();
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(HEBlockTagsProvider::new);
        event.createProvider(HEItemTagsProvider::new);
        event.createProvider(HEEnchantmentTagsProvider::new);

        event.createDatapackRegistryObjects(new RegistrySetBuilder().add(Registries.ENCHANTMENT,
                HEEnchantmentsBootstrap::bootstrap));

        event.createProvider(HEEnglishLangProvider::new);
        event.createProvider(HEPolishLangProvider::new);
    }
}