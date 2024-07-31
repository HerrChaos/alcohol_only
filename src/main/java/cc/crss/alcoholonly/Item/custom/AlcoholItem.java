package cc.crss.alcoholonly.Item.custom;

import cc.crss.alcoholonly.Item.ModItems;
import cc.crss.alcoholonly.block.ModBlocks;
import cc.crss.alcoholonly.entity.ModEntities;
import cc.crss.alcoholonly.entity.custom.Bottle_entity;
import cc.crss.alcoholonly.statuseffect.ModStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static net.minecraft.item.Items.GLASS_BOTTLE;

public class AlcoholItem extends BlockItem {

    private static final int MAX_USE_TIME = 60;

    public AlcoholItem(Block block, Settings settings) {
        super(block, settings);
    }


    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return MAX_USE_TIME;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType != ClickType.RIGHT) {
            return false;
        }
        if (stack.getItem() == ModItems.BEER && otherStack.getItem() == ModBlocks.BEER_GLASS_BLOCK.asItem() && otherStack.getCount() == 1) {
            cursorStackReference.set(ModItems.FULL_BEER_GLASS.getDefaultStack());
            slot.setStack(GLASS_BOTTLE.getDefaultStack());
            return true;
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        List<Item> items = new ArrayList<>(5);
        items.add(ModItems.JAEGERMEISTER);
        items.add(ModItems.VODKA);
        items.add(ModItems.WINE);
        items.add(ModItems.FULL_BEER_GLASS);
        items.add(ModItems.BEER);
        if (Objects.requireNonNull(context.getPlayer()).getStackInHand(Hand.OFF_HAND).getItem() != null) {
            if (items.contains(context.getPlayer().getStackInHand(Hand.OFF_HAND).getItem())) {
                this.use(context.getWorld(), context.getPlayer(), context.getHand());
                return ActionResult.PASS;
            }
        }
        //this.place(new ItemPlacementContext(context));
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        List<Item> items = Arrays.asList(
                ModItems.JAEGERMEISTER,
                ModItems.VODKA,
                ModItems.WINE,
                ModItems.FULL_BEER_GLASS,
                ModItems.BEER
        );

        if (hand == Hand.OFF_HAND) {
            Item itemInHand = itemStack.getItem();
            if (items.contains(itemInHand)) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

                if (!world.isClient) {
                    ThrownItemEntity entity = null;

                    if (itemInHand == ModItems.VODKA) {
                        entity = new Bottle_entity(ModEntities.VODKA_BOTTLE_PROJECTILE, user, world);
                    } else if (itemInHand == ModItems.BEER) {
                        entity = new Bottle_entity(ModEntities.BEER_BOTTLE_PROJECTILE, user, world);
                    } else if (itemInHand == ModItems.WINE) {
                        entity = new Bottle_entity(ModEntities.WINE_BOTTLE_PROJECTILE, user, world);
                    } else if (itemInHand == ModItems.JAEGERMEISTER) {
                        entity = new Bottle_entity(ModEntities.JAEGERMEISTER_BOTTLE_PROJECTILE, user, world);
                    } else if (itemInHand == ModItems.FULL_BEER_GLASS) {
                        entity = new Bottle_entity(ModEntities.BEER_BOTTLE_PROJECTILE, user, world);
                    }

                    if (entity != null) {
                        entity.setItem(itemStack);
                        entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                        world.spawnEntity(entity);

                        if (!user.getAbilities().creativeMode) {
                            itemStack.decrement(1);
                        }
                    }
                }

                return TypedActionResult.success(itemStack, world.isClient());
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        StatusEffectInstance apliedStatuseffect = user.getStatusEffect(ModStatusEffects.DRUNKNNESS);
        if (apliedStatuseffect != null) {
            if (apliedStatuseffect.getAmplifier() >= 5) {
                user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKNNESS, 20 * 20, 5));
            }
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKNNESS, 20 * 20, apliedStatuseffect.getAmplifier() + 1));
        } else {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.DRUNKNNESS, 20 * 20, 0));
        }
        if (user.isPlayer() && !((PlayerEntity) user).getAbilities().creativeMode) {
            if (stack.getItem() == ModItems.FULL_BEER_GLASS) {
                ((PlayerEntity) user).giveItemStack(new ItemStack(ModBlocks.BEER_GLASS_BLOCK, 1));
            }
            ((PlayerEntity) user).giveItemStack(new ItemStack(GLASS_BOTTLE, 1));
        }
        return stack;
    }
}
