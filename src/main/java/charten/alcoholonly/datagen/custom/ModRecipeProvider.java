package charten.alcoholonly.datagen.custom;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.Item.ModItems;
import charten.alcoholonly.block.ModBlocks;
import charten.alcoholonly.util.ModTags;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RawShapedRecipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.collection.DefaultedList;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        exporter.accept(AlcoholOnly.ifOf("beer"),
                new ShapelessRecipe(
                        "alcohol",
                        CraftingRecipeCategory.MISC,
                        ModItems.BEER.getDefaultStack(),
                        DefaultedList.copyOf(Ingredient.EMPTY, Ingredient.ofItems(Items.POTION, Items.WHEAT))
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("wine"),
                new ShapelessRecipe(
                        "alcohol",
                        CraftingRecipeCategory.MISC,
                        ModItems.WINE.getDefaultStack(),
                        DefaultedList.copyOf(Ingredient.EMPTY, Ingredient.ofItems(Items.POTION, Items.SWEET_BERRIES))
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("vodka"),
                new ShapelessRecipe(
                        "alcohol",
                        CraftingRecipeCategory.MISC,
                        ModItems.VODKA.getDefaultStack(),
                        DefaultedList.copyOf(Ingredient.EMPTY, Ingredient.ofItems(Items.POTION, Items.POTATO))
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("jaegermeister"),
                new ShapelessRecipe(
                        "alcohol",
                        CraftingRecipeCategory.MISC,
                        ModItems.JAEGERMEISTER.getDefaultStack(),
                        DefaultedList.copyOf(Ingredient.EMPTY, Ingredient.ofItems(Items.POTION, Items.FERN))
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("molotov"),
                new ShapelessRecipe(
                        "",
                        CraftingRecipeCategory.EQUIPMENT,
                        ModItems.MOLOTOV.getDefaultStack(),
                        DefaultedList.copyOf(Ingredient.EMPTY, Ingredient.fromTag(ModTags.Items.ALCOHOL_BOTTLE), Ingredient.ofItems(Items.PAPER))
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("alcohol_barrel_block"),
                new ShapedRecipe(
                        "",
                        CraftingRecipeCategory.EQUIPMENT,
                        RawShapedRecipe.create(Map.of('#', Ingredient.fromTag(ItemTags.PLANKS)),
                                " # ",
                                "# #",
                                " # "
                        ),
                        ModItems.MOLOTOV.getDefaultStack()
                ),
                null);

        exporter.accept(AlcoholOnly.ifOf("beer_glass"),
                new ShapedRecipe(
                        "",
                        CraftingRecipeCategory.EQUIPMENT,
                        RawShapedRecipe.create(Map.of('#', Ingredient.ofItems(Items.GLASS)),
                                "## ",
                                "###",
                                "## "
                        ),
                        ModBlocks.BEER_GLASS_BLOCK.asItem().getDefaultStack()
                ),
                null);
    }
}