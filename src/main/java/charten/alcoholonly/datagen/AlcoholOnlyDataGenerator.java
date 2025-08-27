package charten.alcoholonly.datagen;

import charten.alcoholonly.datagen.custom.ModAdvancementProvider;
import charten.alcoholonly.datagen.custom.ModRecipeProvider;
import charten.alcoholonly.datagen.custom.ModTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.advancement.*;
import net.minecraft.recipe.*;

public class AlcoholOnlyDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModTagProvider::new);
        pack.addProvider(ModAdvancementProvider::new);
    }
}
