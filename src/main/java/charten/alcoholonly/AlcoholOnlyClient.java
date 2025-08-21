package charten.alcoholonly;

import charten.alcoholonly.entity.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class AlcoholOnlyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderer.registerModEntityRenderer();
	}
}