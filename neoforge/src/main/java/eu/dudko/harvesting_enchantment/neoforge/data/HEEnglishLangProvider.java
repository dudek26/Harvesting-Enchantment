package eu.dudko.harvesting_enchantment.neoforge.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;
import eu.dudko.harvesting_enchantment.data.HELang;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class HEEnglishLangProvider extends LanguageProvider {

    public HEEnglishLangProvider(PackOutput output) {
        super(output, HarvestingEnchantment.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        HELang.getEntries().forEach(entry -> add(entry.key(), entry.english()));
    }

}
