package chaos.alcohol.block.custom.blockentity;

import chaos.alcohol.AlcoholOnly;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static chaos.alcohol.block.ModBlocks.ALCOHOL_BARREL_BLOCK;


public class ModBlockEntityTypes {
    public static final BlockEntityType<Alcohol_Barrel_blockentity> ALCOHOL_BARREL_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(AlcoholOnly.MOD_ID, "alcohol_block_entity"),
            FabricBlockEntityTypeBuilder.create(Alcohol_Barrel_blockentity::new, ALCOHOL_BARREL_BLOCK).build()
    );

    public static void registerModBlockEntities() {
        AlcoholOnly.LOGGER.info("Loading mod EntityTypes for " + AlcoholOnly.MOD_ID);
    }
}
