package eu.dudko.harvesting_enchantment.registry;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class HEEnchantments {

    public static final ResourceKey<Enchantment> HARVESTING = key("harvesting");

    private static ResourceKey<Enchantment> key(Identifier id) {
        return ResourceKey.create(Registries.ENCHANTMENT, id);
    }

    private static ResourceKey<Enchantment> key(String name) {
        return key(HarvestingEnchantment.id(name));
    }

}
