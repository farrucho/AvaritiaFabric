package net.farrucho.avaritia.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class NeutronCollectorOutputSlot extends Slot {

    public NeutronCollectorOutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        int c;
        for(c = 0;c < this.inventory.size(); c++){
            this.inventory.removeStack(c,1);
        }
        super.onTakeItem(player, stack);
    }

}
