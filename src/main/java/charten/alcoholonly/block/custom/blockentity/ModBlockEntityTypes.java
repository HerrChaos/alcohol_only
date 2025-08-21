package charten.alcoholonly.block.custom.blockentity;

import charten.alcoholonly.AlcoholOnly;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static charten.alcoholonly.block.ModBlocks.ALCOHOL_BARREL_BLOCK;


public class ModBlockEntityTypes {
    public static final BlockEntityType<AlcoholBarrelBlockEntity> ALCOHOL_BARREL_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "alcohol_block_entity"),
            FabricBlockEntityTypeBuilder.create(AlcoholBarrelBlockEntity::new, ALCOHOL_BARREL_BLOCK).build()
    );

    public static void registerModBlockEntities() {
        AlcoholOnly.LOGGER.info("Loading mod EntityTypes for " + AlcoholOnly.MOD_ID);
    }
}
