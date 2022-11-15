package net.farrucho.avaritia.block.entity;

import net.farrucho.avaritia.Avaritia;
import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.block.AvaritiaModItems;
import net.farrucho.avaritia.screen.NeutronCollectorScreen;
import net.farrucho.avaritia.screen.NeutronCollectorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
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

public class NeutronCollectorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    //private static int tickCounter;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    //private int maxProgress = 500;//7111 METER ESTE VALOR
    private int maxProgress = 7111;


    public NeutronCollectorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NEUTRON_COLLECTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return NeutronCollectorBlockEntity.this.progress;
                    case 1: return NeutronCollectorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: NeutronCollectorBlockEntity.this.progress = value; break;
                    case 1: NeutronCollectorBlockEntity.this.maxProgress = value; break;
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
        return new NeutronCollectorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }


    @Override//adicionar isto para quando sair do mundo progresso estar guardado
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("neutron_collector.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("neutron_collector.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos pos, BlockState state, NeutronCollectorBlockEntity entity) {
        if(world.isClient()){
            return;
        }
        entity.propertyDelegate.set(0,entity.propertyDelegate.get(0)+1);
        entity.progress++;
        //markDirty(world, pos,state);
        if(entity.progress >= entity.maxProgress) {
            craftItem(entity);
            entity.resetProgress();
            //markDirty(world, pos, state);
        }


        //trabalhar na funcao percentagem para gerar o nuggetzitos
        /*++tickCounter;
        if(tickCounter > 80){//7111 METER ESTE VALOR
            //METER ITEM PILE OF NEUTRONS
            be.inventory.set(0,new ItemStack(Items.DIAMOND, 1 + be.inventory.get(0).getCount()));
            tickCounter = 0;



        }*/
    }

    private static void craftItem(NeutronCollectorBlockEntity entity) {
        entity.inventory.set(0,new ItemStack(AvaritiaModItems.NEUTRON_PILE, 1 + entity.inventory.get(0).getCount()));
        entity.resetProgress();
    }

}
