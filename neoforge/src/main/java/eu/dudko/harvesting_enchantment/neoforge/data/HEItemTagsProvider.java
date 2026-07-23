package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.registry.HEItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class HEItemTagsProvider extends ItemTagsProvider {

    public HEItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, HarvestingEnchantment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        HEItemTags.getDatagenTags().forEach(this::tag);
        tag(HEItemTags.HARVESTING_ENCHANTABLE).addOptionalTag(ItemTags.HOES);
    }
}
