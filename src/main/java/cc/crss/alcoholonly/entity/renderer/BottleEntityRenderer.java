package cc.crss.alcoholonly.entity.renderer;

import cc.crss.alcoholonly.AlcoholOnly;
import cc.crss.alcoholonly.entity.custom.Bottle_entity;
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
