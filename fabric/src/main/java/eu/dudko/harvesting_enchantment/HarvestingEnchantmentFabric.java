package eu.dudko.harvesting_enchantment;

import net.fabricmc.api.ModInitializer;

public class HarvestingEnchantmentFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        HarvestingEnchantment.init();
    }
}
