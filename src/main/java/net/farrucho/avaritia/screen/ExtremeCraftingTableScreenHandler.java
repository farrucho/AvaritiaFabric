package net.farrucho.avaritia.screen;

import net.farrucho.avaritia.block.entity.CraftingSlot;
import net.farrucho.avaritia.block.entity.NeutronCollectorOutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;


public class ExtremeCraftingTableScreenHandler extends ScreenHandler{
    private final Inventory inventory;



    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public ExtremeCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(81));
    }

    //This constructor gets called from the BlockEntity on the server without calling the other constructor first, the server knows the inventory of the container
    //and can therefore directly provide it as an argument. This inventory will then be synced to the client.
    public ExtremeCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.EXTREME_CRAFTING_TABLE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 1);
        this.inventory = inventory;

        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job


        //CRIAR CUSTOM CRAFTING SLOT EM VEZ DE SLOTS NORMAIS PARA INDEX SEREM MAIS FACEIS
        addCraftingSlots(inventory);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        //this.addSlot(new NeutronCollectorOutputSlot(inventory,0,80,35));
        //The player inventory
        /*for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, -1 + l * 18, 129 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, -1 + m * 18, 187));
        }*/


        //this.addSlot(new Slot(inventory,0,-40,0));
        /*for (m = 0; m < 9; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + m * 9, -18 - 9 -1 + l * 18, -18 -18 -1 + m * 18));
            }
        }*/
    }




    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
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
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }


    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 31 + l * 18, 174 + i * 18));
            }
        }
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }


    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 31 + i * 18, 232));
        }
    }

    private void addCraftingSlots(Inventory inventory){
        for (int i = 0; i < 9; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new CraftingSlot(inventory, l + i*9, 4 + l * 18, 8 + i * 18));
            }
        }
    }



}

