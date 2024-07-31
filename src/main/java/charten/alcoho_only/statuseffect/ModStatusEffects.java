package charten.alcoho_only.statuseffect;

import charten.alcoho_only.Alcoholonly;
import charten.alcoho_only.statuseffect.custom.DrunkennisStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> DRUNKINNIS = register("drunkinnis", new DrunkennisStatusEffect());

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Alcoholonly.MOD_ID, id), statusEffect);
    }

    public static void registerModStatusEffects() {

    }
}
