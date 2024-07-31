package charten.alcoho_only.entity;

import charten.alcoho_only.Alcoholonly;
import charten.alcoho_only.Item.ModItems;
import charten.alcoho_only.entity.custom.Bottle_entity;
import charten.alcoho_only.entity.custom.Molotov_BottleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<Bottle_entity> VODKA_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "vodka_bottleentity"),
            FabricEntityTypeBuilder.<Bottle_entity>create(SpawnGroup.MISC, (type, world) -> new Bottle_entity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<Bottle_entity> WINE_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "wine_bottleentity"),
            FabricEntityTypeBuilder.<Bottle_entity>create(SpawnGroup.MISC, (type, world) -> new Bottle_entity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<Bottle_entity> BEER_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "beer_bottleentity"),
            FabricEntityTypeBuilder.<Bottle_entity>create(SpawnGroup.MISC, (type, world) -> new Bottle_entity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<Bottle_entity> JAEGERMEISTER_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "jeagermeister_bottleentity"),
            FabricEntityTypeBuilder.<Bottle_entity>create(SpawnGroup.MISC, (type, world) -> new Bottle_entity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<Molotov_BottleEntity> MOLOTOV_BOTTLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "molotov_bottleentity"),
            FabricEntityTypeBuilder.<Molotov_BottleEntity>create(SpawnGroup.MISC, Molotov_BottleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static void registerEntities() {
        Alcoholonly.LOGGER.info("Registering Entities for " + Alcoholonly.MOD_ID);
    }
}