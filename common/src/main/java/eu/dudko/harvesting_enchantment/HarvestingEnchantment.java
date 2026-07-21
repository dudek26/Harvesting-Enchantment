package eu.dudko.harvesting_enchantment;

import eu.dudko.harvesting_enchantment.registry.HEEnchantmentEffectComponentTypes;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HarvestingEnchantment {

    public static final String MOD_ID = "harvesting_enchantment";
    public static final String MOD_NAME = "Harvesting Enchantment";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        HEEnchantmentEffectComponentTypes.init();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

}