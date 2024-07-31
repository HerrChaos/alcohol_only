package charten.alcoho_only;

import charten.alcoho_only.Item.ModItemGroups;
import charten.alcoho_only.Item.ModItems;
import charten.alcoho_only.Item.custom.BrockenBottleTester;
import charten.alcoho_only.block.ModBlocks;
import charten.alcoho_only.block.custom.blockentity.ModBlockEntityTypes;
import charten.alcoho_only.entity.ModEntities;
import charten.alcoho_only.statuseffect.ModStatusEffects;
import charten.alcoho_only.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alcoholonly implements ModInitializer {
	public static final String MOD_ID = "alcohol-only";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		BrockenBottleTester.InitializeEventListiner();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntityTypes.registerModBlockEntities();
		ModEntities.registerEntities();
		ModStatusEffects.registerModStatusEffects();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		LOGGER.info("Hello Fabric world!");
	}
}