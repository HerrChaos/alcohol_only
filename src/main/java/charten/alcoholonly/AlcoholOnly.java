package charten.alcoholonly;

import charten.alcoholonly.Item.ModItemGroups;
import charten.alcoholonly.Item.ModItems;
import charten.alcoholonly.Item.custom.BrockenBottleTester;
import charten.alcoholonly.block.ModBlocks;
import charten.alcoholonly.block.custom.blockentity.ModBlockEntityTypes;
import charten.alcoholonly.entity.ModEntities;
import charten.alcoholonly.statuseffect.ModStatusEffects;
import charten.alcoholonly.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlcoholOnly implements ModInitializer {
	public static final String MOD_ID = "alcoholonly";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier ifOf(String name) {
        return Identifier.of(MOD_ID, name);
    }

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