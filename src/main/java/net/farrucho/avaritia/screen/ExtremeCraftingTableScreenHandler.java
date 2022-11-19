package net.farrucho.avaritia.screen;

import net.farrucho.avaritia.block.entity.CraftingSlot;
import net.farrucho.avaritia.block.entity.NeutronCollectorOutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;


public class ExtremeCraftingTableScreenHandler extends ScreenHandler{
    private final Inventory inventory;



    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public ExtremeCraftingTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(82));
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

        this.addSlot(new NeutronCollectorOutputSlot(inventory,81,202,80));
    }




    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        player.sendMessage(Text.of(String.valueOf(invSlot)), false);

        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (80 < invSlot && invSlot < 117) {
                //player.sendMessage(Text.of("shift no inventario"), false);
                if (!this.insertItem(originalStack, 0, 80, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (invSlot == 117) {
                //player.sendMessage(Text.of("shift no output slot"), false);

                if (!this.insertItem(originalStack, 81, 116, false)) {
                    return ItemStack.EMPTY;
                } else {
                    for (int i = 0; i < 81; ++i) {
                        if (this.getSlot(i).getStack().getCount() != 0) {
                            this.getSlot(i).getStack().setCount(this.getSlot(i).getStack().getCount() - 1);
                        }
                    }
                }

            } else {
                //player.sendMessage(Text.of("shift na crafting"), false);
                if (!this.insertItem(originalStack, 81, 116, false)) {
                    return ItemStack.EMPTY;
                }
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

