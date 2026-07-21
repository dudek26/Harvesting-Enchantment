package eu.dudko.harvesting_enchantment.registry;

import eu.dudko.harvesting_enchantment.platform.Services;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Unit;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class HEEnchantmentEffectComponentTypes {

    public static void init() {

    }

    public static final Supplier<DataComponentType<Unit>>
            HARVEST_CROPS =
            register("harvest_crops", b -> b.persistent(Unit.CODEC));

    private static <T> Supplier<DataComponentType<T>> register(String id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Services.REGISTRATION.register(id,
                BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,
                () -> builder.apply(DataComponentType.builder()).build());
    }

}