package eu.dudko.harvesting_enchantment.platform;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.platform.services.IRegistrationHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.function.Supplier;

public class FabricRegistrationHelper implements IRegistrationHelper {

    @Override
    public <V, T extends V> Supplier<T> register(String name, Registry<V> registry, Supplier<T> supplier) {
        T
                entry =
                Registry.register(registry,
                        ResourceKey.create(registry.key(), HarvestingEnchantment.id(name)),
                        supplier.get());
        return () -> entry;
    }

}