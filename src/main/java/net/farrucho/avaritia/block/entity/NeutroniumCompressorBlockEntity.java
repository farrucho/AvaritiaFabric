package net.farrucho.avaritia.block.entity;

import net.farrucho.avaritia.item.AvaritiaModItems;
import net.farrucho.avaritia.screen.NeutroniumCompressorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class NeutroniumCompressorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    //private static int tickCounter;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;//7111 METER ESTE VALOR
    private String material = "";



    public NeutroniumCompressorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NEUTRONIUM_COMPRESSOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return NeutroniumCompressorBlockEntity.this.progress;
                    case 1: return NeutroniumCompressorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: NeutroniumCompressorBlockEntity.this.progress = value; break;
                    case 1: NeutroniumCompressorBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
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

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new NeutroniumCompressorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }


    @Override//adicionar isto para quando sair do mundo progresso estar guardado
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("neutronium_compressor.progress", progress);
        nbt.putString("neutronium_compressor.material", material);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("neutronium_compressor.progress");
        material = nbt.getString("neutronium_compressor.material");
        super.readNbt(nbt);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void consumeItem(NeutroniumCompressorBlockEntity entity){
        if(entity.propertyDelegate.get(0) == 0){ //progress == 0
            if(getMaterial(entity.inventory.get(0).getItem()) != null){
                entity.material = getMaterial(entity.inventory.get(0).getItem());
                addToProgress(entity);
                entity.inventory.set(0,new ItemStack(entity.inventory.get(0).getItem(),entity.inventory.get(0).getCount() - 1));
            }
        }else{
            if(Objects.equals(getMaterial(entity.inventory.get(0).getItem()), entity.material)){
                addToProgress(entity);
                entity.inventory.set(0,new ItemStack(entity.inventory.get(0).getItem(),entity.inventory.get(0).getCount() - 1));
            }
        }
    }

    private static void addToProgress(NeutroniumCompressorBlockEntity entity){
        if(entity.inventory.get(0).getItem() == null){
            return;
        }
        if(entity.inventory.get(0).getItem() == Items.REDSTONE_BLOCK ||
                entity.inventory.get(0).getItem() == Items.IRON_BLOCK ||
                entity.inventory.get(0).getItem() == Items.LAPIS_BLOCK ||
                entity.inventory.get(0).getItem() == Items.DIAMOND_BLOCK ||
                entity.inventory.get(0).getItem() == Items.EMERALD_BLOCK ||
                entity.inventory.get(0).getItem() == Items.GOLD_BLOCK ||
                entity.inventory.get(0).getItem() == Items.QUARTZ_BLOCK ){
            entity.propertyDelegate.set(0, entity.propertyDelegate.get(0) + 9);
        }else{
            entity.propertyDelegate.set(0, entity.propertyDelegate.get(0) + 1);
        }
    }

    private static String getMaterial(Item item){
        if(item == Items.IRON_BLOCK || item == Items.IRON_INGOT){
            return "IRON";
        }else if(item == Items.REDSTONE_BLOCK || item == Items.REDSTONE){
            return "REDSTONE";
        }else if(item == Items.GOLD_BLOCK || item == Items.GOLD_INGOT){
            return "GOLD";
        }else if(item == Items.DIAMOND_BLOCK || item == Items.DIAMOND){
            return "DIAMOND";
        }else if(item == Items.EMERALD_BLOCK || item == Items.EMERALD){
            return "EMERALD";
        }else if(item == Items.LAPIS_BLOCK || item == Items.LAPIS_LAZULI){
            return "LAPIS";
        }else if(item == Items.QUARTZ_BLOCK || item == Items.QUARTZ){
            return "QUARTZ";
        }else{
            return null;
        }
    }

    private static Item getSingularityToCraft(NeutroniumCompressorBlockEntity entity){
        if(Objects.equals(entity.material, "IRON")){
            return AvaritiaModItems.IRON_SINGULARITY;
        }else if(Objects.equals(entity.material, "REDSTONE")){
            return AvaritiaModItems.REDSTONE_SINGULARITY;
        }else if(Objects.equals(entity.material, "GOLD")){
            return AvaritiaModItems.GOLD_SINGULARITY;
        }else if(Objects.equals(entity.material, "DIAMOND")){
            return AvaritiaModItems.DIAMOND_SINGULARITY;
        }else if(Objects.equals(entity.material, "EMERALD")){
            return AvaritiaModItems.EMERALD_SINGULARITY;
        }else if(Objects.equals(entity.material, "LAPIS")){
            return AvaritiaModItems.LAPIS_SINGULARITY;
        }else if(Objects.equals(entity.material, "QUARTZ")){
            return AvaritiaModItems.QUARTZ_SINGULARITY;
        }else{
            return null;
        }
    }


    public static void tick(World world, BlockPos pos, BlockState state, NeutroniumCompressorBlockEntity entity) {
        if(entity.inventory.get(0).getItem() != null && entity.inventory.get(0).getItem() != Items.AIR){
            consumeItem(entity);
        }
        if(entity.progress >= 200){
            craftItem(entity);
        }



        /*entity.propertyDelegate.set(0,entity.propertyDelegate.get(0)+1);
        entity.progress++;
        //markDirty(world, pos,state);
        if(entity.progress >= entity.maxProgress) {
            craftItem(entity);
            entity.resetProgress();
            //markDirty(world, pos, state);
        }*/

        //trabalhar na funcao percentagem para gerar o nuggetzitos
        /*++tickCounter;
        if(tickCounter > 80){//7111 METER ESTE VALOR
            //METER ITEM PILE OF NEUTRONS
            be.inventory.set(0,new ItemStack(Items.DIAMOND, 1 + be.inventory.get(0).getCount()));
            tickCounter = 0;



        }*/
    }

    private static void craftItem(NeutroniumCompressorBlockEntity entity) {
        entity.inventory.set(1,new ItemStack(getSingularityToCraft(entity), entity.inventory.get(1).getCount() + 1));
        entity.resetProgress();
        entity.material = "";
    }

}
