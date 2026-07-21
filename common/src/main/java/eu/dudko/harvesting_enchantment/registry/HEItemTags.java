package eu.dudko.harvesting_enchantment.registry;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

public class HEItemTags {

    private static final List<TagKey<Item>> DATAGEN_TAGS = new ArrayList<>();

    public static final TagKey<Item> HARVESTING_ENCHANTABLE = create("enchantable/harvesting");

    private static TagKey<Item> create(Identifier id, boolean datagen) {
        TagKey<Item> tag = TagKey.create(BuiltInRegistries.ITEM.key(), id);
        if (datagen) DATAGEN_TAGS.add(tag);
        return tag;
    }

    private static TagKey<Item> create(String id) {
        return create(HarvestingEnchantment.id(id), true);
    }

    @ApiStatus.Internal
    public static List<TagKey<Item>> getDatagenTags() {
        return List.copyOf(DATAGEN_TAGS);
    }


}
