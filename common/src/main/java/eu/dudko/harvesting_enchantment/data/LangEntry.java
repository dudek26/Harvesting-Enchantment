package eu.dudko.harvesting_enchantment.data;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public record LangEntry(String key, String english, String polish) {

    public MutableComponent asComponent() {
        return Component.translatableWithFallback(key, english);
    }

}
