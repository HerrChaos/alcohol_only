package chaos.alcohol.entity.custom;

import chaos.alcohol.statuseffect.ModStatusEffects;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Objects;

public class Bottle_entity extends ThrownItemEntity {
    public Bottle_entity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public Bottle_entity(EntityType<Bottle_entity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.AIR;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.discard();
        super.onBlockHit(blockHitResult);
        if (this.getWorld().isClient) {
            return;
        }
        this.getWorld().sendEntityStatus(this, (byte) 3);
        World world = this.getWorld();
        Vec3d blockHitPos = blockHitResult.getPos();
        world.playSound(null, blockHitPos.getX(), blockHitPos.getY(), blockHitPos.getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1,1);
        ((ServerWorld) world).spawnParticles(
                new BlockStateParticleEffect(ParticleTypes.BLOCK, ((BlockItem)this.getStack().getItem()).getBlock().getDefaultState()),
                blockHitPos.getX(),
                blockHitPos.getY(),
                blockHitPos.getZ(),
                20, 0, 0, 0, 0.1
        );
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity) {
            Vec3d blockHitPos = entityHitResult.getPos();
            entity.getWorld().playSound(null, blockHitPos.getX(), blockHitPos.getY(), blockHitPos.getZ(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1, 1);

            if (this.getStack().getItem() != null && this.getStack().getItem().getComponents().get(DataComponentTypes.FOOD) != null) {
                if (Objects.requireNonNull(this.getStack().getItem().getComponents().get(DataComponentTypes.FOOD)).effects() != null) {
                    for (FoodComponent.StatusEffectEntry effect : Objects.requireNonNull(this.getStack().getItem().getComponents().get(DataComponentTypes.FOOD)).effects()) {
                        ((LivingEntity) entity).addStatusEffect(effect.effect());
                    }
                }
            }
            StatusEffectInstance apliedStatuseffect = ((LivingEntity) entity).getStatusEffect(ModStatusEffects.DRUNKNNESS);
            if (apliedStatuseffect != null) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKNNESS, 20 * 20, Math.min(6, (apliedStatuseffect.getAmplifier() + 1))));
            } else {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKNNESS, 20 * 20, 0));
            }
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 5f);
        }
        entityHitResult.getEntity().getWorld().playSound(null, entityHitResult.getEntity().getBlockPos() , SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.MUSIC,1,1);
        this.discard();
    }
}
