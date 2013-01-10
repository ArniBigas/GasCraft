package TheArni.GasCraft;

import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.item.ItemStack;

public class GasTab extends CreativeTabs {
;
public GasTab(int position, String tabID) {
  super(position, tabID); //The constructor for your tab
}

public int getTabIconItemIndex() //The item it displays for your tab
{ 
    return GasCraft.GasWrench.itemID; //For this we'll use the ruby
}

public String getTextureFile()
{    
	return "/Textures/Item.png";
}
public String getTranslatedTabLabel()
{
  return "GasCraft"; //The name of the tab in-game
}
}