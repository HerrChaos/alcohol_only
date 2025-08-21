package charten.alcoholonly.statuseffect;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.statuseffect.custom.DrunknessStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> DRUNKNNESS = register("drunkness", new DrunknessStatusEffect());

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(AlcoholOnly.MOD_ID, id), statusEffect);
    }

    public static void registerModStatusEffects() {

    }
}
