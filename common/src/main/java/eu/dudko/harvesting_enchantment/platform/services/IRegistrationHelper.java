package eu.dudko.harvesting_enchantment.platform.services;

import net.minecraft.core.Registry;

import java.util.function.Supplier;

public interface IRegistrationHelper {

    <V, T extends V> Supplier<T> register(String name, Registry<V> registry, Supplier<T> supplier);

}