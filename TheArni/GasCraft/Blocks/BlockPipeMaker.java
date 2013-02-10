package TheArni.GasCraft.Blocks;

import java.util.Random;

import TheArni.GasCraft.GasCraft;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPipeMaker extends BlockContainer {

	public BlockPipeMaker(int par1){
		super(par1, Material.rock);
		this.setCreativeTab(GasCraft.gasTab);
		this.setHardness(1F);
		this.setStepSound(soundStoneFootstep);
	}
	
	public String getTextureFile()
    {
            return "/TheArni/GasCraft/Textures/Block.png";
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

                if(tile_entity == null || player.isSneaking()){
                return false;
                }

        player.openGui(GasCraft.instance, 0, world, x, y, z);
        return true;
        }
	
	@Override
    public void breakBlock(World world, int x, int y, int z, int i, int j){
            dropItems(world, x, y, z);
            super.breakBlock(world, x, y, z, i, j);
            }
	
	private void dropItems(World world, int x, int y, int z){
        Random rand = new Random();
       
        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
       
        if(!(tile_entity instanceof IInventory)){
                return;
        }

        IInventory inventory = (IInventory) tile_entity;

        for(int i = 0; i < inventory.getSizeInventory(); i++){
                ItemStack item = inventory.getStackInSlot(i);
               
                if(item != null && item.stackSize > 0){
                float rx = rand.nextFloat() * 0.6F + 0.1F;
                float ry = rand.nextFloat() * 0.6F + 0.1F;
                float rz = rand.nextFloat() * 0.6F + 0.1F;
               
                EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));
               
                if(item.hasTagCompound()){
                        item.setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.1F;
               
                entity_item.motionX = rand.nextGaussian() * factor;
                entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
                entity_item.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entity_item);
                item.stackSize = 0;
                }
        }
}
	
	@Override
	public TileEntity createNewTileEntity(World world){
		return new PipeMaker();
	}
	
	public int getBlockTextureFromSide(int par1)
	{
	    switch(par1){
	    case 1: return 1;
	    default: return 0;
	    }
	}
}
