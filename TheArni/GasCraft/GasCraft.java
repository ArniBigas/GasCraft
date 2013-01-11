package TheArni.GasCraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "GC", name = "GasCraft", version = "0.1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class GasCraft {
	
@Instance
public static GasCraft instance = new GasCraft();

//Declaring GUIs
private GuiHandler guiHandler = new GuiHandler();

@SidedProxy(clientSide="TheArni.GasCraft.ClientProxy", serverSide="TheArni.GasCraft.CommonProxy")
public static CommonProxy proxy;

//Creating the creative tab
public static CreativeTabs gasTab = new GasTab(CreativeTabs.getNextID(),"GasTab"); //Our custom creative tab's object

//Declaring blocks and items
public static Block GasPipe;
public static Block AirtightChamber;
public static Item GasWrench;

@PreInit
public void preInit(FMLPreInitializationEvent event) {
	System.out.println("Initialitzating GasCraft - DM");
}
//Blocks ID used 2200 - 2250
//Item ID used 22200 - 22250
@Init
public void init(FMLInitializationEvent event) {
	System.out.println("GasCraft Initialitzated - DM");
	
	//Making Blocks and Items
	GasPipe = new BlockGasPipe(2200).setBlockName("GasPipe");
	GasWrench = new Wrench(22200).setIconIndex(1).setItemName("GasWrench");	
	AirtightChamber = new BlockPipeMaker(2201).setBlockName("Chamber");
	
	//Giving it a name
	LanguageRegistry.addName(GasPipe, "Gas Pipe");
	LanguageRegistry.addName(GasWrench, "Wrench");
	LanguageRegistry.addName(AirtightChamber, "Airtight Chamber");
	
	//Registering things
	GameRegistry.registerBlock(GasPipe, "Gas Pipe");
	GameRegistry.registerBlock(AirtightChamber, "AChamber");
	GameRegistry.registerTileEntity(PipeMaker.class, "PipeMaker");
	
	//General INTERNAL Settings
	MinecraftForge.setBlockHarvestLevel(GasPipe, "wrench", 0);
	MinecraftForge.setToolClass(GasWrench, "wrench", 0);
	
	//Rendering Textures
	proxy.registerRenderThings();
	
	//RegisterGUIs	
	NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
	
}

@PostInit
public static void postInit(FMLPostInitializationEvent event) {

}
}