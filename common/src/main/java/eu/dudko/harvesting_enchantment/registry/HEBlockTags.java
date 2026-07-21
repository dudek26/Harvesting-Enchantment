package eu.dudko.harvesting_enchantment.registry;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

public class HEBlockTags {

    private static final List<TagKey<Block>> DATAGEN_TAGS = new ArrayList<>();

    public static final TagKey<Block> NON_HARVESTABLE = create("non_harvestable");

    private static TagKey<Block> create(Identifier id, boolean datagen) {
        TagKey<Block> tag = TagKey.create(BuiltInRegistries.BLOCK.key(), id);
        if (datagen) DATAGEN_TAGS.add(tag);
        return tag;
    }

    private static TagKey<Block> create(String id) {
        return create(HarvestingEnchantment.id(id), true);
    }

    @ApiStatus.Internal
    public static List<TagKey<Block>> getDatagenTags() {
        return List.copyOf(DATAGEN_TAGS);
    }


}
