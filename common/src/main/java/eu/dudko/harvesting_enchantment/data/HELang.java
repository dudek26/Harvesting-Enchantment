package eu.dudko.harvesting_enchantment.data;

import eu.dudko.harvesting_enchantment.HarvestingEnchantment;

import java.util.ArrayList;
import java.util.List;

public class HELang {

    private static final List<LangEntry> ENTRIES = new ArrayList<>();

    public static LangEntry
            HARVESTING_ENCHANTMENT =
            addEntry(namespacedKey("enchantment", "harvesting.name"), "Harvesting", "Żniwo");

    public static List<LangEntry> getEntries() {
        return List.copyOf(ENTRIES);
    }

    private static LangEntry addEntry(LangEntry entry) {
        ENTRIES.add(entry);
        return entry;
    }

    private static LangEntry addEntry(String key, String english, String polish) {
        return addEntry(new LangEntry(key, english, polish));
    }

    private static String namespacedKey(String category, String path) {
        return category + "." + HarvestingEnchantment.MOD_ID + "." + path;
    }

}
