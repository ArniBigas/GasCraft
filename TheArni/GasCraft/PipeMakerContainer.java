package TheArni.GasCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class PipeMakerContainer extends Container{
        protected PipeMaker tile_entity;
       
        public PipeMakerContainer(PipeMaker tile_entity, InventoryPlayer player_inventory){
                this.tile_entity = tile_entity;
                addSlotToContainer(new Slot(tile_entity, 1, 80, 17));
                addSlotToContainer(new Slot(tile_entity, 2, 80, 53));
                bindPlayerInventory(player_inventory);                
        }
       
        @Override
        public boolean canInteractWith(EntityPlayer player){
                return tile_entity.isUseableByPlayer(player);
        }
       
        protected void bindPlayerInventory(InventoryPlayer player_inventory){
        		int slot = 1;
        		
                for(int i = 0; i < 9; i++){
                    addSlotToContainer(new Slot(player_inventory, slot, 8 + i * 18, 142));
                    slot++;
                }
            
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 9; j++){
                                addSlotToContainer(new Slot(player_inventory, slot, 8 + j * 18, 84 + i * 18));
                                slot++;
                                // So odd
                               
                        }
       
}
               
        }
 
        public ItemStack putStackInSlot(int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);

                //null checks and checks if the item can be stacked (maxStackSize > 1)
                if (slotObject != null && slotObject.getHasStack()) {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        //merges the item into player inventory since its in the tileEntity
                        //this assumes only 1 slot, for inventories with > 1 slots, check out the Chest Container.
                        if (slot == 0) {
                                if (!mergeItemStack(stackInSlot, 1,
                                                inventorySlots.size(), true)) {
                                        return null;
                                }
                        //places it into the tileEntity is possible since its in the player inventory
                        } else if (!mergeItemStack(stackInSlot, 0, 1, false)) {
                                return null;
                        }

                        if (stackInSlot.stackSize == 0) {
                                slotObject.putStack(null);
                        } else {
                                slotObject.onSlotChanged();
                        }
                }

                return stack;
        }
}