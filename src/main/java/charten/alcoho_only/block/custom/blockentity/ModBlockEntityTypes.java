package charten.alcoho_only.block.custom.blockentity;

import charten.alcoho_only.Alcoholonly;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static charten.alcoho_only.block.ModBlocks.ALCOHOL_BARREL_BLOCK;


public class ModBlockEntityTypes {
    public static final BlockEntityType<Alcohol_Barrel_blockentity> ALCOHOL_BARREL_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(Alcoholonly.MOD_ID, "alcohol_block_entity"),
            FabricBlockEntityTypeBuilder.create(Alcohol_Barrel_blockentity::new, ALCOHOL_BARREL_BLOCK).build()
    );

    public static void registerModBlockEntities() {
        Alcoholonly.LOGGER.info("Loading mod EntityTypes for " + Alcoholonly.MOD_ID);
    }
}
