package charten.alcoholonly.util;

import charten.alcoholonly.AlcoholOnly;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> ALCOHOL_BOTTLE = createTag("alcohol_bottle");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AlcoholOnly.MOD_ID, name));
        }
    }
}