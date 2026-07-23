package eu.dudko.harvesting_enchantment.fabric;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import net.fabricmc.api.ModInitializer;

public class HarvestingEnchantmentFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        HarvestingEnchantment.init();
    }
}
