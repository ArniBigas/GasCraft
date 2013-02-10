package TheArni.GasCraft;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import TheArni.GasCraft.CommonProxy;
import TheArni.GasCraft.Pipes.GasPipe_softCopper;
import TheArni.GasCraft.Render.GasPipeItemRenders;
import TheArni.GasCraft.Render.PipeRender;

public class ClientProxy extends CommonProxy {
	@Override
	public void initRenderingAndTextures(){
		GasCraft.SoftCopperPipeRenderId = RenderingRegistry.getNextAvailableRenderId();
		
		//Pre-loading textures
		MinecraftForgeClient.preloadTexture("/TheArni/GasCraft/Textures/Block.png");
		//Registering special Item Renders
		MinecraftForgeClient.registerItemRenderer(GasCraft.GasPipe.blockID, new GasPipeItemRenders());
		//Registering TileEntitys special Renders
		ClientRegistry.bindTileEntitySpecialRenderer(GasPipe_softCopper.class, new PipeRender());
	}
}
