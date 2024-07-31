package charten.alcoho_only.Item.custom;

import charten.alcoho_only.Item.ModItems;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

import java.util.ArrayList;
import java.util.List;

public class BrockenBottleTester {

    public static void InitializeEventListiner() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            List<Item> items = new ArrayList<>(5);
            items.add(ModItems.JAEGERMEISTER);
            items.add(ModItems.VODKA);
            items.add(ModItems.WINE);
            items.add(ModItems.FULL_BEER_GLASS);
            items.add(ModItems.BEER);

            ItemStack heldItem = player.getStackInHand(hand);

            if (items.contains(heldItem.getItem())) {
                if (world.getBlockState(pos).getBlock().getHardness() >= Blocks.STONE.getHardness()) {
                    player.setStackInHand(player.getActiveHand(), ModItems.BROKEN_BOTTLE.getDefaultStack());
                    world.playSound(null, pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1, 1);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}
