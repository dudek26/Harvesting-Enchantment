package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.data.HELang;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class HEPolishLangProvider extends LanguageProvider {

    public HEPolishLangProvider(PackOutput output) {
        super(output, HarvestingEnchantment.MOD_ID, "pl_pl");
    }

    @Override
    protected void addTranslations() {
        HELang.getEntries().forEach(entry -> add(entry.key(), entry.polish()));
    }

}
