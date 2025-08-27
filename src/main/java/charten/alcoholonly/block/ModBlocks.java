package charten.alcoholonly.block;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.block.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ALCOHOL_BARREL_BLOCK = registerBlock("alcohol_barrel_block",
            new AlcoholBarrelBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD).strength(2f)));

    public static final Block BEER_GLASS_BLOCK = registerBlock("beer_glass",
            new BeerGlassBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f)));

    public static final Block FULL_BEER_GLASS_BLOCK = registerBlock("full_beer_glass",
            new FullBeerGlassBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f)));

    public static final Block BEER_BLOCK = registerBlock("beer",
            new AlcoholBottleBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f), Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 7.0, 10.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 11.0, 15.0)));

    public static final Block VODKA_BLOCK = registerBlock("vodka",
            new AlcoholBottleBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f),
                    Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 10.0, 10.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0)));

    public static final Block WINE_BLOCK = registerBlock("wine",
            new AlcoholBottleBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f),
                    Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 11.0, 10),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 11.0, 15.0)));

    public static final Block JAEGERMEISTER_BLOCK = registerBlock("jaegermeister",
            new AlcoholBottleBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GLASS).strength(0.1f),
                    Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 7.0, 10.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                    Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 11.0, 15.0)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AlcoholOnly.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(AlcoholOnly.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static void addItemsToFunctionalTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ALCOHOL_BARREL_BLOCK);
    }

    public static void registerModBlocks() {
        AlcoholOnly.LOGGER.info("Registering ModBlocks for " + AlcoholOnly.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemsToFunctionalTabItemGroup);
    }
}
