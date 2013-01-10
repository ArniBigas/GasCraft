package TheArni.GasCraft;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGasPipe extends Block {

	public BlockGasPipe(int par1){
		super(par1, 0, Material.rock);
		this.setCreativeTab(GasCraft.gasTab);
		this.setHardness(0.05F);
		this.setStepSound(soundStoneFootstep);
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
}
