package eu.dudko.harvesting_enchantment.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.registry.HEEnchantmentEffectComponentTypes;
import eu.dudko.harvesting_enchantment.registry.HEItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public class HEEnchantments {

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        register(context,
                "harvesting",
                Enchantment
                        .enchantment(Enchantment.definition(items.getOrThrow(HEItemTags.HARVESTING_ENCHANTABLE),
                                1,
                                1,
                                Enchantment.constantCost(15),
                                Enchantment.constantCost(65),
                                8,
                                EquipmentSlotGroup.HAND))
                        .withEffect(HEEnchantmentEffectComponentTypes.HARVEST_CROPS.get())
                        .withCustomName(_ -> Component.translatableWithFallback(
                                "enchantment.harvesting_enchantment.harvesting.name",
                                "Harvesting")));
    }

    private static void register(BootstrapContext<Enchantment> context, String name, Enchantment.Builder builder) {
        Identifier id = HarvestingEnchantment.id(name);
        context.register(ResourceKey.create(Registries.ENCHANTMENT, id), builder.build(id));
    }

}
