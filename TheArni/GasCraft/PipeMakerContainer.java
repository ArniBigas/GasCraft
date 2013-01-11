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
        		int slot = 0;
        		
                for(int i = 0; i < 9; i++){
                    addSlotToContainer(new Slot(player_inventory, slot, 8 + i * 18, 142));
                    slot++;
                }
            
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 9; j++){
                                addSlotToContainer(new Slot(player_inventory, slot, 8 + j * 18, 84 + i * 18));
                                slot++;
                               
                        }
       
}
               
        }
        
        @Override
        public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotNum)
        	{
        	ItemStack Items = getSlot(slotNum).getStack();
        	Slot Input = getSlot(0);
        	if (slotNum == 0) {
        		if (!mergeItemStack(Items, 2, 36, true)) {
        			return null;
        		}       		
        	} else if (slotNum == 1) {
        		if (!mergeItemStack(Items, 2, 36, true)) {
        			return null;
        		} 
        	} else {
        		if (Items.itemID==GasCraft.GasPipe.blockID) {
        			//Need a help here! Merge the pipes with the input slot!
        		} else return null;        		
        	}
        	return Items;
        	}
        
}