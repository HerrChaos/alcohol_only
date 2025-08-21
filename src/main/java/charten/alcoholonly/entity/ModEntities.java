package charten.alcoholonly.entity;

import charten.alcoholonly.AlcoholOnly;
import charten.alcoholonly.entity.custom.MolotovBottleEntity;
import charten.alcoholonly.entity.custom.BottleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BottleEntity> VODKA_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "vodka_bottleentity"),
            FabricEntityTypeBuilder.<BottleEntity>create(SpawnGroup.MISC, (type, world) -> new BottleEntity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BottleEntity> WINE_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "wine_bottleentity"),
            FabricEntityTypeBuilder.<BottleEntity>create(SpawnGroup.MISC, (type, world) -> new BottleEntity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BottleEntity> BEER_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "beer_bottleentity"),
            FabricEntityTypeBuilder.<BottleEntity>create(SpawnGroup.MISC, (type, world) -> new BottleEntity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BottleEntity> JAEGERMEISTER_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "jeagermeister_bottleentity"),
            FabricEntityTypeBuilder.<BottleEntity>create(SpawnGroup.MISC, (type, world) -> new BottleEntity(type, world))
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<MolotovBottleEntity> MOLOTOV_BOTTLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "molotov_bottleentity"),
            FabricEntityTypeBuilder.<MolotovBottleEntity>create(SpawnGroup.MISC, MolotovBottleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static void registerEntities() {
        AlcoholOnly.LOGGER.info("Registering Entities for " + AlcoholOnly.MOD_ID);
    }
}