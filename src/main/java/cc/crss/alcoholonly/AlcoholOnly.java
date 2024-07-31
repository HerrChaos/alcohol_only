package cc.crss.alcoholonly;

import cc.crss.alcoholonly.Item.ModItemGroups;
import cc.crss.alcoholonly.Item.ModItems;
import cc.crss.alcoholonly.Item.custom.BrockenBottleTester;
import cc.crss.alcoholonly.block.ModBlocks;
import cc.crss.alcoholonly.block.custom.blockentity.ModBlockEntityTypes;
import cc.crss.alcoholonly.entity.ModEntities;
import cc.crss.alcoholonly.statuseffect.ModStatusEffects;
import cc.crss.alcoholonly.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlcoholOnly implements ModInitializer {
	public static final String MOD_ID = "alcoholonly";
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

		LOGGER.info("Drinking is gay because you can't think straight");
	}
}