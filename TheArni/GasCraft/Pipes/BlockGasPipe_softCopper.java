package TheArni.GasCraft.Pipes;

import java.util.Random;

import TheArni.GasCraft.GasCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class BlockGasPipe_softCopper extends BlockContainer {

	public BlockGasPipe_softCopper(int par1){
		super(par1, 255, Material.rock);
		this.setCreativeTab(GasCraft.gasTab);
		this.setHardness(0.05F);
		this.setStepSound(soundStoneFootstep);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.1975F, 1F);
	}
	public boolean renderAsNormalBlock(){
		return false;
	}
	public int getRenderType() {

        return GasCraft.SoftCopperPipeRenderId;
    }
	public String getTextureFile()
    {
            return "/TheArni/GasCraft/Textures/Block.png";
    }

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4);
    }
	
	@Override
	public TileEntity createNewTileEntity(World world){
		return new GasPipe_softCopper();
	}
}
