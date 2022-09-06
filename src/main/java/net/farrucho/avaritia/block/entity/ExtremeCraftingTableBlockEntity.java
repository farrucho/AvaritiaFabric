package net.farrucho.avaritia.block.entity;

import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.block.AvaritiaModItems;
import net.farrucho.avaritia.screen.ExtremeCraftingTableScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExtremeCraftingTableBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(82, ItemStack.EMPTY);

    public ExtremeCraftingTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXTREME_CRAFTING_TABLE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override//adicionar isto para quando sair do mundo progresso estar guardado
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }




    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ExtremeCraftingTableScreenHandler(syncId, inv, this);
    }

    private static boolean hasSkullFireSword(ExtremeCraftingTableBlockEntity entity){
        return (entity.inventory.get(0).getItem() == Items.AIR &&
                entity.inventory.get(1).getItem() == Items.AIR &&
                entity.inventory.get(2).getItem() == Items.AIR &&
                entity.inventory.get(3).getItem() == Items.AIR &&
                entity.inventory.get(4).getItem() == Items.AIR &&
                entity.inventory.get(5).getItem() == Items.AIR &&
                entity.inventory.get(6).getItem() == Items.AIR &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(8).getItem() == Items.BLAZE_POWDER &&

                entity.inventory.get(9).getItem() == Items.AIR &&
                entity.inventory.get(10).getItem() == Items.AIR &&
                entity.inventory.get(11).getItem() == Items.AIR &&
                entity.inventory.get(12).getItem() == Items.AIR &&
                entity.inventory.get(13).getItem() == Items.AIR &&
                entity.inventory.get(14).getItem() == Items.AIR &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(16).getItem() == Items.BLAZE_POWDER &&
                entity.inventory.get(17).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(18).getItem() == Items.AIR &&
                entity.inventory.get(19).getItem() == Items.AIR &&
                entity.inventory.get(20).getItem() == Items.AIR &&
                entity.inventory.get(21).getItem() == Items.AIR &&
                entity.inventory.get(22).getItem() == Items.AIR &&
                entity.inventory.get(23).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(24).getItem() == Items.BLAZE_POWDER &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(26).getItem() == Items.AIR &&

                entity.inventory.get(27).getItem() == Items.AIR &&
                entity.inventory.get(28).getItem() == Items.AIR &&
                entity.inventory.get(29).getItem() == Items.AIR &&
                entity.inventory.get(30).getItem() == Items.AIR &&
                entity.inventory.get(31).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(32).getItem() == Items.BLAZE_POWDER &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(34).getItem() == Items.AIR &&
                entity.inventory.get(35).getItem() == Items.AIR &&

                entity.inventory.get(36).getItem() == Items.AIR &&
                entity.inventory.get(37).getItem() == Items.BONE &&
                entity.inventory.get(38).getItem() == Items.AIR &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(40).getItem() == Items.BLAZE_POWDER &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(42).getItem() == Items.AIR &&
                entity.inventory.get(43).getItem() == Items.AIR &&
                entity.inventory.get(44).getItem() == Items.AIR &&

                entity.inventory.get(45).getItem() == Items.AIR &&
                entity.inventory.get(46).getItem() == Items.AIR &&
                entity.inventory.get(47).getItem() == Items.BONE &&
                entity.inventory.get(48).getItem() == Items.BLAZE_POWDER &&
                entity.inventory.get(49).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(50).getItem() == Items.AIR &&
                entity.inventory.get(51).getItem() == Items.AIR &&
                entity.inventory.get(52).getItem() == Items.AIR &&
                entity.inventory.get(53).getItem() == Items.AIR &&

                entity.inventory.get(54).getItem() == Items.AIR &&
                entity.inventory.get(55).getItem() == Items.AIR &&
                new ItemStack(entity.inventory.get(56).getItem()).isIn(ItemTags.LOGS)&&
                entity.inventory.get(57).getItem() == Items.BONE &&
                entity.inventory.get(58).getItem() == Items.AIR &&
                entity.inventory.get(59).getItem() == Items.AIR &&
                entity.inventory.get(60).getItem() == Items.AIR &&
                entity.inventory.get(61).getItem() == Items.AIR &&
                entity.inventory.get(62).getItem() == Items.AIR &&



                entity.inventory.get(63).getItem() == Items.AIR &&
                new ItemStack(entity.inventory.get(64).getItem()).isIn(ItemTags.LOGS)&&
                entity.inventory.get(65).getItem() == Items.AIR &&
                entity.inventory.get(66).getItem() == Items.AIR &&
                entity.inventory.get(67).getItem() == Items.BONE &&
                entity.inventory.get(68).getItem() == Items.AIR &&
                entity.inventory.get(69).getItem() == Items.AIR &&
                entity.inventory.get(70).getItem() == Items.AIR &&
                entity.inventory.get(71).getItem() == Items.AIR &&

                entity.inventory.get(72).getItem() == Items.NETHER_STAR &&
                entity.inventory.get(73).getItem() == Items.AIR &&
                entity.inventory.get(74).getItem() == Items.AIR &&
                entity.inventory.get(75).getItem() == Items.AIR &&
                entity.inventory.get(76).getItem() == Items.AIR &&
                entity.inventory.get(77).getItem() == Items.AIR &&
                entity.inventory.get(78).getItem() == Items.AIR &&
                entity.inventory.get(79).getItem() == Items.AIR &&
                entity.inventory.get(80).getItem() == Items.AIR);
    }


    private static boolean hasNeutronCollector(ExtremeCraftingTableBlockEntity entity){
        return (entity.inventory.get(0).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(1).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(2).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(3).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(4).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(5).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(6).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(7).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(8).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(9).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(10).getItem() == Items.AIR &&
                entity.inventory.get(11).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(12).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(13).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(14).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(15).getItem() == Items.QUARTZ_BLOCK &&
                entity.inventory.get(16).getItem() == Items.AIR &&
                entity.inventory.get(17).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(18).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(19).getItem() == Items.AIR &&
                entity.inventory.get(20).getItem() == Items.AIR &&
                entity.inventory.get(21).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(22).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(23).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(24).getItem() == Items.AIR &&
                entity.inventory.get(25).getItem() == Items.AIR &&
                entity.inventory.get(26).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(27).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(28).getItem() == Items.AIR &&
                entity.inventory.get(29).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(30).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(31).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(32).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(33).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(34).getItem() == Items.AIR &&
                entity.inventory.get(35).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(36).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(37).getItem() == Items.AIR &&
                entity.inventory.get(38).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(39).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(40).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(41).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(42).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(43).getItem() == Items.AIR &&
                entity.inventory.get(44).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(45).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(46).getItem() == Items.AIR &&
                entity.inventory.get(47).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(48).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(49).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(50).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(51).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(52).getItem() == Items.AIR &&
                entity.inventory.get(53).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(54).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(55).getItem() == Items.AIR &&
                entity.inventory.get(56).getItem() == Items.AIR &&
                entity.inventory.get(57).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(58).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(59).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(60).getItem() == Items.AIR &&
                entity.inventory.get(61).getItem() == Items.AIR &&
                entity.inventory.get(62).getItem() == Items.IRON_BLOCK &&



                entity.inventory.get(63).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(64).getItem() == Items.AIR &&
                entity.inventory.get(65).getItem() == Items.AIR &&
                entity.inventory.get(66).getItem() == Items.AIR &&
                entity.inventory.get(67).getItem() == Items.AIR &&
                entity.inventory.get(68).getItem() == Items.AIR &&
                entity.inventory.get(69).getItem() == Items.AIR &&
                entity.inventory.get(70).getItem() == Items.AIR &&
                entity.inventory.get(71).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(72).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(73).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(74).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(75).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(76).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(77).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(78).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(79).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(80).getItem() == Items.IRON_BLOCK);
    }



    private static void craftItem(ExtremeCraftingTableBlockEntity entity, ItemStack itemStack){//se ja ouver 64 o jogo crasha provavel
        entity.setStack(81,new ItemStack(itemStack.getItem(), itemStack.getCount()));
    }

    public static void tick(World world, BlockPos pos, BlockState state, ExtremeCraftingTableBlockEntity entity) {
        if(hasSkullFireSword(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.SKULLFIRE_SWORD, 1));
        }else if(hasNeutronCollector(entity)){//se tem outro recipe
            craftItem(entity, new ItemStack(AvaritiaModBlocks.NEUTRON_COLLECTOR, 1));
        }else{
            entity.getStack(81).setCount(0);//clear output slot
        }
    }


}