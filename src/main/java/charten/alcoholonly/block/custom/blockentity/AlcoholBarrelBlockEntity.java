package charten.alcoholonly.block.custom.blockentity;

import charten.alcoholonly.Item.ModItems;
import charten.alcoholonly.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class AlcoholBarrelBlockEntity extends BlockEntity {
    private int FillLevel = 0;
    private String Fluid = "none";
    public AlcoholBarrelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.ALCOHOL_BARREL_ENTITY, pos, state);
    }
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        this.Fluid = nbt.getString("fluid");
        this.FillLevel = nbt.getInt("fill level");
        super.readNbt(nbt, registryLookup);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putInt("fill level", this.FillLevel);
        if (!Objects.equals(this.Fluid, "none")) nbt.putString("fluid", this.Fluid);
        super.writeNbt(nbt, registryLookup);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AlcoholBarrelBlockEntity de) {
        if (de.FillLevel > 8) de.FillLevel = 8;
        if (de.FillLevel == 0) de.Fluid = "none";
    }

    public static void OnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.getBlockEntity(pos) != null) {
            AlcoholBarrelBlockEntity blockEntity = (AlcoholBarrelBlockEntity) world.getBlockEntity(pos);
            if (blockEntity.FillLevel < 8) {
                if (hasItemInHand(player, ModItems.BEER)) {
                    MakeFluidCheck("beer", player, blockEntity);
                }
                if (hasItemInHand(player, ModItems.WINE)) {
                    MakeFluidCheck("wine", player, blockEntity);
                }
                if (hasItemInHand(player, ModItems.VODKA)) {
                    MakeFluidCheck("vodka", player, blockEntity);
                }
                if (hasItemInHand(player, ModItems.JAEGERMEISTER)) {
                    MakeFluidCheck("jaegermeister", player, blockEntity);
                }
                if (hasItemInHand(player, ModItems.FULL_BEER_GLASS)) {
                    MakeFluidCheck("beer", player, blockEntity);
                }
            }

            if (blockEntity.FillLevel > 0) {
                MakeBottleCheck("beer", ModItems.BEER, player, blockEntity);
                MakeBottleCheck("wine", ModItems.WINE, player, blockEntity);
                MakeBottleCheck("vodka", ModItems.VODKA, player, blockEntity);
                MakeBottleCheck("jaegermeister", ModItems.JAEGERMEISTER, player, blockEntity);


                if (hasItemInHand(player, ModBlocks.BEER_GLASS_BLOCK.asItem()) && Objects.equals(blockEntity.Fluid, "beer")) {
                    if (!player.getAbilities().creativeMode) player.getStackInHand(player.getActiveHand()).decrement(1);
                    player.giveItemStack(new ItemStack(ModItems.FULL_BEER_GLASS, 1));
                    blockEntity.FillLevel--;
                }
            }
        }
    }




    private static boolean hasItemInHand(PlayerEntity player, Item item) {
        return player.getStackInHand(player.getActiveHand()).getItem() == item;
    }

    public static void MakeFluidCheck(String fluid, PlayerEntity player, AlcoholBarrelBlockEntity blockEntity) {
        if (blockEntity.Fluid.equals(fluid)) {
            if (!player.getAbilities().creativeMode) {
                if (blockEntity.Fluid.equals("beer") && hasItemInHand(player, ModItems.FULL_BEER_GLASS)) {
                    player.giveItemStack(new ItemStack(ModBlocks.BEER_GLASS_BLOCK.asItem(), 1));
                } else {
                    player.giveItemStack(new ItemStack(Items.GLASS_BOTTLE, 1));
                }
                player.getStackInHand(player.getActiveHand()).decrement(1);
            }
            player.getWorld().playSound(player, player.getBlockPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.PLAYERS,1,1);
            blockEntity.FillLevel += 1;
            return;
        }
        if (Objects.equals(blockEntity.Fluid, "none")) {
            blockEntity.Fluid = fluid;
            blockEntity.FillLevel += 1;
            if (!player.getAbilities().creativeMode) {
                player.getStackInHand(player.getActiveHand()).decrement(1);
                player.giveItemStack(new ItemStack(Items.GLASS_BOTTLE, 1));
            }
            player.getWorld().playSound(player, player.getBlockPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.PLAYERS,1,1);
        }
    }

    public static void MakeBottleCheck(String fluid,  Item returnItem, PlayerEntity player, AlcoholBarrelBlockEntity blockEntity) {
        if (hasItemInHand(player, Items.GLASS_BOTTLE) && Objects.equals(blockEntity.Fluid, fluid)) {
            if (!player.getAbilities().creativeMode) player.getStackInHand(player.getActiveHand()).decrement(1);
            player.giveItemStack(new ItemStack(returnItem, 1));
            blockEntity.FillLevel --;
        }
    }
}
