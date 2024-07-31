package charten.alcoho_only;

import charten.alcoho_only.entity.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class AlcoholonlyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderer.registerModEntityRenderer();
	}
}