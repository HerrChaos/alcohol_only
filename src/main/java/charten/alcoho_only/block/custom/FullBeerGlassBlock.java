package charten.alcoho_only.block.custom;

import charten.alcoho_only.statuseffect.ModStatusEffects;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Objects;

import static charten.alcoho_only.block.ModBlocks.BEER_GLASS_BLOCK;
import static net.minecraft.sound.SoundEvents.ENTITY_GENERIC_DRINK;

public class FullBeerGlassBlock extends Block{

    private static final VoxelShape ONE_BOTTLE_SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 9.0, 10.0);
    public FullBeerGlassBlock(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return ONE_BOTTLE_SHAPE;
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Hand hand = player.getActiveHand();

        if (player.getStackInHand(hand).isEmpty()) {
            StatusEffectInstance apliedStatuseffect = player.getStatusEffect(ModStatusEffects.DRUNKINNIS);
            if (apliedStatuseffect != null) {
                if (apliedStatuseffect.getAmplifier() >= 5) {
                    player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKINNIS, 20 * 20, 5));
                }
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKINNIS, 20 * 20, apliedStatuseffect.getAmplifier() + 1));
            } else {
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKINNIS, 20 * 20, 0));
            }

            for (FoodComponent.StatusEffectEntry effect : Objects.requireNonNull(this.asItem().getComponents().get(DataComponentTypes.FOOD)).effects()) {
                player.addStatusEffect(effect.effect());
            }

            world.playSound(player, pos, ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,1,1);
            world.setBlockState(pos, BEER_GLASS_BLOCK.getDefaultState());
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
}
