package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.registry.HEEnchantments;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class HEEnchantmentTagsProvider extends EnchantmentTagsProvider {

    public HEEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, HarvestingEnchantment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(EnchantmentTags.NON_TREASURE).addOptional(HEEnchantments.HARVESTING);
        tag(EnchantmentTags.TOOLTIP_ORDER).addOptional(HEEnchantments.HARVESTING);
    }

}
