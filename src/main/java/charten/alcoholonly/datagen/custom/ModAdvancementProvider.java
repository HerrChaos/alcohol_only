package charten.alcoholonly.datagen.custom;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        Advancement.Builder.create().display(
                        new AdvancementDisplay(
                                ModItems.BEER.getDefaultStack(),
                                Text.of("Du bist jetzt offizel Deutsch!"),
                                Text.translatable("advancements.husbandry.beer.description"),
                                Optional.empty(),
                                AdvancementFrame.TASK,
                                true,
                                true,
                                false)
                ).criterion(
                        "get_beer",
                        InventoryChangedCriterion.Conditions.items(ModItems.BEER)
                )
                .build(consumer, AlcoholOnly.MOD_ID + ":get_beer");

        Advancement.Builder.create().display(
                        new AdvancementDisplay(
                                ModItems.JAEGERMEISTER.getDefaultStack(),
                                Text.of("JÄGERMEISTER!!!"),
                                Text.of(URI.create("https://www.youtube.com/watch?v=jnhTxejPYFQ")),
                                Optional.empty(),
                                AdvancementFrame.TASK,
                                true,
                                true,
                                false)
                ).criterion(
                        "get_jaegermeister",
                        InventoryChangedCriterion.Conditions.items(ModItems.JAEGERMEISTER)
                )
                .build(consumer, AlcoholOnly.MOD_ID + ":get_jaegermeister");
    }
}
