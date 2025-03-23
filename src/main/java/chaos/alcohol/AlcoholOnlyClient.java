package chaos.alcohol;

import chaos.alcohol.entity.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class AlcoholOnlyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderer.registerModEntityRenderer();
	}
}