package chaos.alcohol;

import chaos.alcohol.Item.ModItemGroups;
import chaos.alcohol.Item.ModItems;
import chaos.alcohol.Item.custom.BrockenBottleTester;
import chaos.alcohol.block.ModBlocks;
import chaos.alcohol.block.custom.blockentity.ModBlockEntityTypes;
import chaos.alcohol.entity.ModEntities;
import chaos.alcohol.statuseffect.ModStatusEffects;
import chaos.alcohol.villager.ModVillagers;
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