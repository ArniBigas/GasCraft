package TheArni.GasCraft;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;

public class Wrench extends Item {
	public Wrench(int par1) {
		super(par1);
		maxStackSize = 1;
		this.setCreativeTab(GasCraft.gasTab);
	}
	public String getTextureFile()
    {
            return "/TheArni/GasCraft/Textures/Item.png";
    }
}
