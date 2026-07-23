package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.registry.HEBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class HEBlockTagsProvider extends BlockTagsProvider {

    public HEBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, HarvestingEnchantment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        HEBlockTags.getDatagenTags().forEach(this::tag);
    }
}
