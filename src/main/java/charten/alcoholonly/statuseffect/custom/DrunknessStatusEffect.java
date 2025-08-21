package charten.alcoholonly.statuseffect.custom;

import charten.alcoholonly.statuseffect.ModStatusEffects;
import charten.alcoholonly.entity.ModEntities;
import charten.alcoholonly.entity.custom.BottleEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class DrunknessStatusEffect extends StatusEffect {

    public DrunknessStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x549c33);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        Random random = new Random();
        amplifier += 1;
        if (random.nextInt(20) == 1) {
            Vec3d playerLook = entity.getRotationVector();
            Vec3d force_right = new Vec3d(-playerLook.z, 0, playerLook.x).normalize().multiply(0.1);
            Vec3d force_left = new Vec3d(playerLook.z, 0, -playerLook.x).normalize().multiply(0.1);

            if (random.nextInt(2) == 1) {
                entity.addVelocity(force_right);
            } else {
                entity.addVelocity(force_left);
            }
        }

        if (amplifier >= 2) {
            if (random.nextInt(300) == 1) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 0, false, true));
            }
        }

        if (amplifier >= 3) {
            if (random.nextInt(160) == 1) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 40, 0, false, true));
            }
        }
        if (amplifier >= 4) {
            if (random.nextInt(160) == 1) {
                entity.dropStack(entity.getStackInHand(entity.getActiveHand()));
                entity.setStackInHand(entity.getActiveHand(), Items.AIR.getDefaultStack());
            }
        }
        if (amplifier >= 5) {
            if (random.nextInt(190) == 1) {
                entity.damage(new BottleEntity(ModEntities.VODKA_BOTTLE_PROJECTILE, entity.getWorld()).getDamageSources( ).magic(), 5f);
            }
        }
        if (amplifier >= 6) {
            if (random.nextInt(200) == 1) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 0, false, true));
            }
        }
        if (amplifier >= 7) {
            if (random.nextInt(400) == 1) {
                BlockPos newPos = findRandomSolidBlock(entity.getWorld(), entity.getBlockPos(), 100);
                if (newPos != null) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20, 2, false, true));
                    entity.requestTeleport(newPos.getX(), newPos.getY(), newPos.getZ());
                    entity.removeStatusEffect(ModStatusEffects.DRUNKNNESS);
                }
            }
        }
        return true;
    }

    private BlockPos findRandomSolidBlock(World world, BlockPos startPos, int radius) {
        for (int i = 0; i < 2000; i++) {
            int offsetX = world.getRandom().nextInt(radius * 2 + 1) - radius;
            int offsetY = world.getRandom().nextInt(radius * 2 + 1) - radius;
            int offsetZ = world.getRandom().nextInt(radius * 2 + 1) - radius;

            BlockPos targetPos = startPos.add(offsetX, offsetY, offsetZ);

            if (targetPos != startPos && !world.getBlockState(targetPos).isSolidBlock(world, targetPos) && !world.getBlockState(targetPos.up()).isSolidBlock(world, targetPos)) {
                if (world.getBlockState(targetPos.down()).isSolidBlock(world, targetPos)) {
                    return targetPos;
                }
            }
        }
        return null;
    }
}
