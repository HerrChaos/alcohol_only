package charten.alcoholonly.datagen.custom;

import charten.alcoholonly.Item.ModItems;
import charten.alcoholonly.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(ModTags.Items.ALCOHOL_BOTTLE)
                .add(ModItems.BEER)
                .add(ModItems.WINE)
                .add(ModItems.VODKA)
                .add(ModItems.JAEGERMEISTER)
                .setReplace(true);
    }
}
