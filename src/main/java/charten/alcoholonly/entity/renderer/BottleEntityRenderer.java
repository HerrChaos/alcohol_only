package charten.alcoholonly.entity.renderer;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.entity.custom.BottleEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class BottleEntityRenderer extends EntityRenderer<BottleEntity> {

    public BottleEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(BottleEntity entity) {
        return Identifier.of(AlcoholOnly.MOD_ID, "textures/entity/bottle_entity.png");
    }
}
