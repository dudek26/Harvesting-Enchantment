package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.data.HELang;
import eu.dudko.harvesting_enchantment.registry.HEEnchantments;
import eu.dudko.harvesting_enchantment.registry.HEItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public class HEEnchantmentsBootstrap {

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        register(context,
                HEEnchantments.HARVESTING,
                Enchantment
                        .enchantment(Enchantment.definition(items.getOrThrow(HEItemTags.HARVESTING_ENCHANTABLE),
                                1,
                                1,
                                Enchantment.constantCost(15),
                                Enchantment.constantCost(65),
                                8,
                                EquipmentSlotGroup.HAND))
                        .withCustomName(_ -> HELang.HARVESTING_ENCHANTMENT.asComponent()));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

}
