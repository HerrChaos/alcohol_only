package cc.crss.alcoholonly.Item;

import cc.crss.alcoholonly.Item.custom.AlcoholItem;
import cc.crss.alcoholonly.AlcoholOnly;
import cc.crss.alcoholonly.Item.custom.MolotovItem;
import cc.crss.alcoholonly.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Drinks
    public static final Item FULL_BEER_GLASS = registerItem("full_beer_glass_item",
            new AlcoholItem(ModBlocks.FULL_BEER_GLASS_BLOCK, new Item.Settings().maxCount(1).food(ModFoodComponents.BEER)));

    public static final Item BEER = registerItem("beer_item",
            new AlcoholItem(ModBlocks.BEER_BLOCK, new Item.Settings().maxCount(1).food(ModFoodComponents.BEER)));

    public static final Item VODKA = registerItem("vodka_item",
            new AlcoholItem(ModBlocks.VODKA_BLOCK, new Item.Settings().maxCount(1).food(ModFoodComponents.VODKA)));

    public static final Item WINE = registerItem("wine_item",
            new AlcoholItem(ModBlocks.WINE_BLOCK, new Item.Settings().maxCount(1).food(ModFoodComponents.WINE)));

    public static final Item JAEGERMEISTER = registerItem("jaegermeister_item",
            new AlcoholItem(ModBlocks.JAEGERMEISTER_BLOCK, new Item.Settings().maxCount(1).food(ModFoodComponents.JAEGERMEISTER)));

    public static final Item MOLOTOV = registerItem("molotov",
            new MolotovItem(new Item.Settings().maxCount(1)));

    public static final Item BROKEN_BOTTLE = registerItem("broken_bottle",
            new SwordItem(ToolMaterials.STONE, new Item.Settings().maxCount(1).maxDamage(10)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AlcoholOnly.MOD_ID, name), item);
    }


    private static void addItemsToToolsTabItemGroup(FabricItemGroupEntries entries) {
    }
    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(BROKEN_BOTTLE);
        entries.add(MOLOTOV);
    }
    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.BEER_GLASS_BLOCK);
    }
    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(BEER);
        entries.add(FULL_BEER_GLASS);
        entries.add(VODKA);
        entries.add(WINE);
        entries.add(JAEGERMEISTER);
    }
    public static void registerModItems() {
        AlcoholOnly.LOGGER.info("Registering Items for Mod " + AlcoholOnly.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
    }
}