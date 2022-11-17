package net.farrucho.avaritia.block.entity;

import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.item.AvaritiaModItems;
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
        //return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
    // For versions 1.18.2 and below, please use return new TranslatableText(getCachedState().getBlock().getTranslationKey());

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

    private static boolean hasNeutroniumCompressor(ExtremeCraftingTableBlockEntity entity){
        return (entity.inventory.get(0).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(1).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(2).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(3).getItem() == Items.HOPPER &&
                entity.inventory.get(4).getItem() == Items.HOPPER &&
                entity.inventory.get(5).getItem() == Items.HOPPER &&
                entity.inventory.get(6).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(7).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(8).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(9).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(10).getItem() == Items.AIR &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(12).getItem() == Items.AIR &&
                entity.inventory.get(13).getItem() == Items.AIR &&
                entity.inventory.get(14).getItem() == Items.AIR &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(16).getItem() == Items.AIR &&
                entity.inventory.get(17).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(18).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(19).getItem() == Items.AIR &&
                entity.inventory.get(20).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(21).getItem() == Items.AIR &&
                entity.inventory.get(22).getItem() == Items.AIR &&
                entity.inventory.get(23).getItem() == Items.AIR &&
                entity.inventory.get(24).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(25).getItem() == Items.AIR &&
                entity.inventory.get(26).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(27).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(28).getItem() == Items.AIR &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(30).getItem() == Items.AIR &&
                entity.inventory.get(31).getItem() == Items.AIR &&
                entity.inventory.get(32).getItem() == Items.AIR &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(34).getItem() == Items.AIR &&
                entity.inventory.get(35).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(36).getItem() == Items.REDSTONE_BLOCK &&
                entity.inventory.get(37).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(39).getItem() == Items.AIR &&
                entity.inventory.get(40).getItem() == (AvaritiaModBlocks.NEUTRONIUM_BLOCK).asItem() &&
                entity.inventory.get(41).getItem() == Items.AIR &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(44).getItem() == Items.REDSTONE_BLOCK &&

                entity.inventory.get(45).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(46).getItem() == Items.AIR &&
                entity.inventory.get(47).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(48).getItem() == Items.AIR &&
                entity.inventory.get(49).getItem() == Items.AIR &&
                entity.inventory.get(50).getItem() == Items.AIR &&
                entity.inventory.get(51).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(52).getItem() == Items.AIR &&
                entity.inventory.get(53).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

                entity.inventory.get(54).getItem() == Items.IRON_BLOCK &&
                entity.inventory.get(55).getItem() == Items.AIR &&
                entity.inventory.get(56).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(57).getItem() == Items.AIR &&
                entity.inventory.get(58).getItem() == Items.AIR &&
                entity.inventory.get(59).getItem() == Items.AIR &&
                entity.inventory.get(60).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(61).getItem() == Items.AIR &&
                entity.inventory.get(62).getItem() == Items.IRON_BLOCK &&

                entity.inventory.get(63).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(64).getItem() == Items.AIR &&
                entity.inventory.get(65).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(66).getItem() == Items.AIR &&
                entity.inventory.get(67).getItem() == Items.AIR &&
                entity.inventory.get(68).getItem() == Items.AIR &&
                entity.inventory.get(69).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(70).getItem() == Items.AIR &&
                entity.inventory.get(71).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&

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

    private static boolean hasUltimateStew(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=15; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == AvaritiaModItems.NEUTRON_PILE &&
                entity.inventory.get(1).getItem() == Items.WHEAT &&
                entity.inventory.get(2).getItem() == Items.WHEAT &&
                entity.inventory.get(3).getItem() == Items.CARROT &&
                entity.inventory.get(4).getItem() == Items.CARROT &&
                entity.inventory.get(5).getItem() == Items.POTATO &&
                entity.inventory.get(6).getItem() == Items.POTATO &&
                entity.inventory.get(7).getItem() == Items.CACTUS &&
                entity.inventory.get(8).getItem() == Items.CACTUS &&

                entity.inventory.get(9).getItem() == Items.RED_MUSHROOM &&
                entity.inventory.get(10).getItem() == Items.RED_MUSHROOM &&
                entity.inventory.get(11).getItem() == Items.BROWN_MUSHROOM &&
                entity.inventory.get(12).getItem() == Items.BROWN_MUSHROOM &&
                entity.inventory.get(13).getItem() == Items.NETHER_WART &&
                entity.inventory.get(14).getItem() == Items.NETHER_WART);
    }

    private static boolean hasCosmicMeatballs(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=11; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == AvaritiaModItems.NEUTRON_PILE &&
                entity.inventory.get(1).getItem() == Items.BEEF &&
                entity.inventory.get(2).getItem() == Items.BEEF &&
                entity.inventory.get(3).getItem() == Items.CHICKEN &&
                entity.inventory.get(4).getItem() == Items.CHICKEN &&
                entity.inventory.get(5).getItem() == Items.PORKCHOP &&
                entity.inventory.get(6).getItem() == Items.PORKCHOP &&
                entity.inventory.get(7).getItem() == Items.RABBIT &&
                entity.inventory.get(8).getItem() == Items.RABBIT &&
                entity.inventory.get(9).getItem() == Items.COD &&
                entity.inventory.get(10).getItem() == Items.COD);
    }


    private static boolean hasEndestPearl(ExtremeCraftingTableBlockEntity entity){
        return (entity.inventory.get(0).getItem() == Items.AIR &&
                entity.inventory.get(1).getItem() == Items.AIR &&
                entity.inventory.get(2).getItem() == Items.AIR &&
                entity.inventory.get(3).getItem() == Items.END_STONE &&
                entity.inventory.get(4).getItem() == Items.END_STONE &&
                entity.inventory.get(5).getItem() == Items.END_STONE &&
                entity.inventory.get(6).getItem() == Items.AIR &&
                entity.inventory.get(7).getItem() == Items.AIR &&
                entity.inventory.get(8).getItem() == Items.AIR &&

                entity.inventory.get(9).getItem() == Items.AIR &&
                entity.inventory.get(10).getItem() == Items.END_STONE &&
                entity.inventory.get(11).getItem() == Items.END_STONE &&
                entity.inventory.get(12).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(13).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(14).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(15).getItem() == Items.END_STONE &&
                entity.inventory.get(16).getItem() == Items.END_STONE &&
                entity.inventory.get(17).getItem() == Items.AIR &&

                entity.inventory.get(18).getItem() == Items.AIR &&
                entity.inventory.get(19).getItem() == Items.END_STONE &&
                entity.inventory.get(20).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(21).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(22).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(23).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(24).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(25).getItem() == Items.END_STONE &&
                entity.inventory.get(26).getItem() == Items.AIR &&

                entity.inventory.get(27).getItem() == Items.END_STONE &&
                entity.inventory.get(28).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(29).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(30).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(31).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(32).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(33).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(34).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(35).getItem() == Items.END_STONE &&

                entity.inventory.get(36).getItem() == Items.END_STONE &&
                entity.inventory.get(37).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(38).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(40).getItem() == Items.NETHER_STAR &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(42).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(43).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(44).getItem() == Items.END_STONE &&

                entity.inventory.get(45).getItem() == Items.END_STONE &&
                entity.inventory.get(46).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(47).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(48).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(49).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(50).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(51).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(52).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(53).getItem() == Items.END_STONE &&

                entity.inventory.get(54).getItem() == Items.AIR &&
                entity.inventory.get(55).getItem() == Items.END_STONE &&
                entity.inventory.get(56).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(57).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(58).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(59).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(60).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(61).getItem() == Items.END_STONE &&
                entity.inventory.get(62).getItem() == Items.AIR &&

                entity.inventory.get(63).getItem() == Items.AIR &&
                entity.inventory.get(64).getItem() == Items.END_STONE &&
                entity.inventory.get(65).getItem() == Items.END_STONE &&
                entity.inventory.get(66).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(67).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(68).getItem() == Items.ENDER_PEARL &&
                entity.inventory.get(69).getItem() == Items.END_STONE &&
                entity.inventory.get(70).getItem() == Items.END_STONE &&
                entity.inventory.get(71).getItem() == Items.AIR &&

                entity.inventory.get(72).getItem() == Items.AIR &&
                entity.inventory.get(73).getItem() == Items.AIR &&
                entity.inventory.get(74).getItem() == Items.AIR &&
                entity.inventory.get(75).getItem() == Items.END_STONE &&
                entity.inventory.get(76).getItem() == Items.END_STONE &&
                entity.inventory.get(77).getItem() == Items.END_STONE &&
                entity.inventory.get(78).getItem() == Items.AIR &&
                entity.inventory.get(79).getItem() == Items.AIR &&
                entity.inventory.get(80).getItem() == Items.AIR);
    }

    private static boolean hasInfinityCatalyst(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=16; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == AvaritiaModItems.DIAMOND_LATTICE &&
                entity.inventory.get(1).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRON_PILE &&
                entity.inventory.get(3).getItem() == AvaritiaModItems.NEUTRONIUM_NUGGET &&
                entity.inventory.get(4).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(5).getItem() == AvaritiaModItems.ULTIMATE_STEW &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.COSMIC_MEATBALLS &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.ENDEST_PEARL &&
                entity.inventory.get(8).getItem() == AvaritiaModItems.RECORD_FRAGMENT &&

                entity.inventory.get(9).getItem() == AvaritiaModItems.IRON_SINGULARITY &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.GOLD_SINGULARITY &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.LAPIS_SINGULARITY &&
                entity.inventory.get(12).getItem() == AvaritiaModItems.REDSTONE_SINGULARITY &&
                entity.inventory.get(13).getItem() == AvaritiaModItems.QUARTZ_SINGULARITY &&
                entity.inventory.get(14).getItem() == AvaritiaModItems.DIAMOND_SINGULARITY &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.EMERALD_SINGULARITY);
    }

    private static boolean hasInfinityIngot(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=45; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(1).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(3).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(4).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(5).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(8).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(9).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(12).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(13).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(14).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(16).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(17).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(18).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(19).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(20).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(21).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(22).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(23).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(24).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(26).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(27).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(28).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(30).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(31).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(32).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(34).getItem() == AvaritiaModItems.CRYSTAL_MATRIX_INGOT &&
                entity.inventory.get(35).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(36).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(37).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(40).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(44).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT);
    }

    private static boolean hasInfinityHelmet(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=54; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == Items.AIR &&
                entity.inventory.get(1).getItem() == Items.AIR &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(3).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(4).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(5).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(7).getItem() == Items.AIR &&
                entity.inventory.get(8).getItem() == Items.AIR &&

                entity.inventory.get(9).getItem() == Items.AIR &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(12).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(13).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(14).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(16).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(17).getItem() == Items.AIR &&

                entity.inventory.get(18).getItem() == Items.AIR &&
                entity.inventory.get(19).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(20).getItem() == Items.AIR &&
                entity.inventory.get(21).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(22).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(23).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(24).getItem() == Items.AIR &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(26).getItem() == Items.AIR &&

                entity.inventory.get(27).getItem() == Items.AIR &&
                entity.inventory.get(28).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(30).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(31).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(32).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(34).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(35).getItem() == Items.AIR &&

                entity.inventory.get(36).getItem() == Items.AIR &&
                entity.inventory.get(37).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(40).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(44).getItem() == Items.AIR &&

                entity.inventory.get(45).getItem() == Items.AIR &&
                entity.inventory.get(46).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(47).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(48).getItem() == Items.AIR &&
                entity.inventory.get(49).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(50).getItem() == Items.AIR &&
                entity.inventory.get(51).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(52).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(53).getItem() == Items.AIR);
    }

    private static boolean hasInfinityBoots(ExtremeCraftingTableBlockEntity entity){
        int c;
        for(c=54; c < 81; c++){
            if(entity.inventory.get(c).getItem() != Items.AIR){
                return false;
            }
        }

        return (entity.inventory.get(0).getItem() == Items.AIR &&
                entity.inventory.get(1).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(3).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(4).getItem() == Items.AIR &&
                entity.inventory.get(5).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(8).getItem() == Items.AIR &&

                entity.inventory.get(9).getItem() == Items.AIR &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(12).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(13).getItem() == Items.AIR &&
                entity.inventory.get(14).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(16).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(17).getItem() == Items.AIR &&

                entity.inventory.get(18).getItem() == Items.AIR &&
                entity.inventory.get(19).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(20).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(21).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(22).getItem() == Items.AIR &&
                entity.inventory.get(23).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(24).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(26).getItem() == Items.AIR &&

                entity.inventory.get(27).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(28).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(30).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(31).getItem() == Items.AIR &&
                entity.inventory.get(32).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(34).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(35).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(36).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(37).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(40).getItem() == Items.AIR &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(44).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(45).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(46).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(47).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(48).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(49).getItem() == Items.AIR &&
                entity.inventory.get(50).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(51).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(52).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(53).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT);
    }

    private static boolean hasInfinityChestplate(ExtremeCraftingTableBlockEntity entity){

        return(entity.inventory.get(0).getItem() == Items.AIR &&
                entity.inventory.get(1).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(3).getItem() == Items.AIR &&
                entity.inventory.get(4).getItem() == Items.AIR &&
                entity.inventory.get(5).getItem() == Items.AIR &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(8).getItem() == Items.AIR &&

                entity.inventory.get(9).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(12).getItem() == Items.AIR &&
                entity.inventory.get(13).getItem() == Items.AIR &&
                entity.inventory.get(14).getItem() == Items.AIR &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(16).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(17).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(18).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(19).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(20).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(21).getItem() == Items.AIR &&
                entity.inventory.get(22).getItem() == Items.AIR &&
                entity.inventory.get(23).getItem() == Items.AIR &&
                entity.inventory.get(24).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(26).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(27).getItem() == Items.AIR &&
                entity.inventory.get(28).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(30).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(31).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(32).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(34).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(35).getItem() == Items.AIR &&

                entity.inventory.get(36).getItem() == Items.AIR &&
                entity.inventory.get(37).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(39).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(40).getItem() == AvaritiaModBlocks.CRYSTAL_MATRIX_BLOCK.asItem() &&
                entity.inventory.get(41).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(44).getItem() == Items.AIR &&

                entity.inventory.get(45).getItem() == Items.AIR &&
                entity.inventory.get(46).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(47).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(48).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(49).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(50).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(51).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(52).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(53).getItem() == Items.AIR &&

                entity.inventory.get(54).getItem() == Items.AIR &&
                entity.inventory.get(55).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(56).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(57).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(58).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(59).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(60).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(61).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(62).getItem() == Items.AIR &&


                entity.inventory.get(63).getItem() == Items.AIR &&
                entity.inventory.get(64).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(65).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(66).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(67).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(68).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(69).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(70).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(71).getItem() == Items.AIR &&

                entity.inventory.get(72).getItem() == Items.AIR &&
                entity.inventory.get(73).getItem() == Items.AIR &&
                entity.inventory.get(74).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(75).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(76).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(77).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(78).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(79).getItem() == Items.AIR &&
                entity.inventory.get(80).getItem() == Items.AIR );
    }

    private static boolean hasInfinityLeggings(ExtremeCraftingTableBlockEntity entity){

        return(entity.inventory.get(0).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(1).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(2).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(3).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(4).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(5).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(6).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(7).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(8).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(9).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(10).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(11).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(12).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(13).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(14).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(15).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(16).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(17).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(18).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(19).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(20).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(21).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(22).getItem() == AvaritiaModItems.INFINITY_CATALYST &&
                entity.inventory.get(23).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(24).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(25).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(26).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(27).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(28).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(29).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(30).getItem() == Items.AIR &&
                entity.inventory.get(31).getItem() == Items.AIR &&
                entity.inventory.get(32).getItem() == Items.AIR &&
                entity.inventory.get(33).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(34).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(35).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(36).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(37).getItem() == AvaritiaModBlocks.CRYSTAL_MATRIX_BLOCK.asItem() &&
                entity.inventory.get(38).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(39).getItem() == Items.AIR &&
                entity.inventory.get(40).getItem() == Items.AIR &&
                entity.inventory.get(41).getItem() == Items.AIR &&
                entity.inventory.get(42).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(43).getItem() == AvaritiaModBlocks.CRYSTAL_MATRIX_BLOCK.asItem() &&
                entity.inventory.get(44).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(45).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(46).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(47).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(48).getItem() == Items.AIR &&
                entity.inventory.get(49).getItem() == Items.AIR &&
                entity.inventory.get(50).getItem() == Items.AIR &&
                entity.inventory.get(51).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(52).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(53).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(54).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(55).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(56).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(57).getItem() == Items.AIR &&
                entity.inventory.get(58).getItem() == Items.AIR &&
                entity.inventory.get(59).getItem() == Items.AIR &&
                entity.inventory.get(60).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(61).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(62).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&


                entity.inventory.get(63).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(64).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(65).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(66).getItem() == Items.AIR &&
                entity.inventory.get(67).getItem() == Items.AIR &&
                entity.inventory.get(68).getItem() == Items.AIR &&
                entity.inventory.get(69).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(70).getItem() == AvaritiaModItems.INFINITY_INGOT &&
                entity.inventory.get(71).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&

                entity.inventory.get(72).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(73).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(74).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(75).getItem() == Items.AIR &&
                entity.inventory.get(76).getItem() == Items.AIR &&
                entity.inventory.get(77).getItem() == Items.AIR &&
                entity.inventory.get(78).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(79).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT &&
                entity.inventory.get(80).getItem() == AvaritiaModItems.NEUTRONIUM_INGOT );
    }




    private static void craftItem(ExtremeCraftingTableBlockEntity entity, ItemStack itemStack){//se ja ouver 64 o jogo crasha provavel
        entity.setStack(81,new ItemStack(itemStack.getItem(), itemStack.getCount()));
    }

    public static void tick(World world, BlockPos pos, BlockState state, ExtremeCraftingTableBlockEntity entity) {
        if(hasSkullFireSword(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.SKULLFIRE_SWORD, 1));
        }else if(hasNeutronCollector(entity)){//se tem outro recipe
            craftItem(entity, new ItemStack(AvaritiaModBlocks.NEUTRON_COLLECTOR, 1));
        }else if(hasNeutroniumCompressor(entity)){
            craftItem(entity, new ItemStack(AvaritiaModBlocks.NEUTRONIUM_COMPRESSOR, 1));
        }else if(hasUltimateStew(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.ULTIMATE_STEW, 1));
        }else if(hasEndestPearl(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.ENDEST_PEARL, 1));
        }else if(hasCosmicMeatballs(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.COSMIC_MEATBALLS, 1));
        }else if(hasInfinityCatalyst(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_CATALYST, 1));
        }else if(hasInfinityIngot(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_INGOT, 1));
        }else if(hasInfinityHelmet(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_HELMET, 1));
        }else if(hasInfinityBoots(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_BOOTS, 1));
        }else if(hasInfinityChestplate(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_CHESTPLATE, 1));
        }else if(hasInfinityLeggings(entity)){
            craftItem(entity, new ItemStack(AvaritiaModItems.INFINITY_LEGGINGS, 1));
        }


        else{
            entity.getStack(81).setCount(0);//clear output slot
        }
    }


}