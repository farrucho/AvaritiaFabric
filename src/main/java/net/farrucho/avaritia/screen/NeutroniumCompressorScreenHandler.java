package net.farrucho.avaritia.screen;

import net.farrucho.avaritia.block.entity.NeutronCollectorOutputSlot;
import net.farrucho.avaritia.block.entity.NeutroniumCompressorInputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;


public class NeutroniumCompressorScreenHandler extends ScreenHandler{
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;


    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public NeutroniumCompressorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2), new ArrayPropertyDelegate(2));
    }

    //This constructor gets called from the BlockEntity on the server without calling the other constructor first, the server knows the inventory of the container
    //and can therefore directly provide it as an argument. This inventory will then be synced to the client.
    public NeutroniumCompressorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.NEUTRONIUM_COMPRESSOR_SCREEN_HANDLER, syncId);
        checkSize(inventory, 1);
        this.inventory = inventory;
        this.propertyDelegate = delegate;

        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job


        this.addSlot(new NeutroniumCompressorInputSlot(inventory,0,39,35));
        this.addSlot(new NeutronCollectorOutputSlot(inventory,1,117,35));




        //The player inventory
        int m;
        int l;
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }


        addProperties(delegate);
    }


    public int getScaledProgressSingularity() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 18; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledProgressArrow() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 22; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public float getCurrentProgress() {
        return this.propertyDelegate.get(0);
    }

    public float getMaxProgress() {
        return this.propertyDelegate.get(1);
    }


    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        /*if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }*/

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}

