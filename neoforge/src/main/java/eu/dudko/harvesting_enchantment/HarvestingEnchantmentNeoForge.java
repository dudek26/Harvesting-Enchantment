package eu.dudko.harvesting_enchantment;

import eu.dudko.harvesting_enchantment.data.HEBlockTagsProvider;
import eu.dudko.harvesting_enchantment.data.HEEnchantments;
import eu.dudko.harvesting_enchantment.data.HEItemTagsProvider;
import eu.dudko.harvesting_enchantment.platform.NeoForgeRegistrationHelper;
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
        NeoForgeRegistrationHelper.init(eventBus);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(HEBlockTagsProvider::new);
        event.createProvider(HEItemTagsProvider::new);

        event.createDatapackRegistryObjects(new RegistrySetBuilder().add(Registries.ENCHANTMENT,
                HEEnchantments::bootstrap));
    }
}