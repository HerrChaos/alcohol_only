package cc.crss.alcoholonly;

import cc.crss.alcoholonly.entity.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class AlcoholOnlyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderer.registerModEntityRenderer();
	}
}