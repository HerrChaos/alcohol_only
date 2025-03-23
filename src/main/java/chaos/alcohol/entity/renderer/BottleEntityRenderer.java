package chaos.alcohol.entity.renderer;

import chaos.alcohol.AlcoholOnly;
import chaos.alcohol.entity.custom.Bottle_entity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class BottleEntityRenderer extends EntityRenderer<Bottle_entity> {

    public BottleEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(Bottle_entity entity) {
        return Identifier.of(AlcoholOnly.MOD_ID, "textures/entity/bottle_entity.png");
    }
}
