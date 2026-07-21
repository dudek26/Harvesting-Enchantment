package eu.dudko.harvesting_enchantment.platform;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.platform.services.IRegistrationHelper;
import net.minecraft.core.Registry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NeoForgeRegistrationHelper implements IRegistrationHelper {

    private static final Map<Registry<?>, DeferredRegister<?>> REGISTERS = new HashMap<>();

    @SuppressWarnings("unchecked")
    private static <T> DeferredRegister<T> getRegister(Registry<T> registry) {
        return (DeferredRegister<T>) REGISTERS.computeIfAbsent(registry,
                key -> DeferredRegister.create(key, HarvestingEnchantment.MOD_ID));
    }

    @Override
    public <V, T extends V> Supplier<T> register(String name, Registry<V> registry, Supplier<T> supplier) {
        return getRegister(registry).register(name, supplier);
    }

    public static void init(IEventBus eventBus) {
        REGISTERS.values().forEach(register -> register.register(eventBus));
    }

}