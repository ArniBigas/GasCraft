package TheArni.GasCraft.Render;

import org.lwjgl.opengl.GL11;
import TheArni.GasCraft.Models.ModelPipe;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

public class GasPipeItemRenders implements IItemRenderer {

	    private ModelPipe pipeModel;

	    public GasPipeItemRenders() {

	        pipeModel = new ModelPipe(1F);
	    }

	    @Override
	    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

	        return true;
	    }

	    @Override
	    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

	        return true;
	    }

	    @Override
	    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

	        switch (type) {
	            case ENTITY: {
	                renderPipe(-1F, -0.4F, -1F, .1F);
	                break;
	            }
	            case EQUIPPED: {
	                renderPipe(0F, .5F, 0F, .05F);
	                break;
	            }
	            case INVENTORY: {
	                renderPipe(0F, .5F, 0F, .09F);
	                break;
	            }
	            default:
	                break;
	        }

	    }

	    private void renderPipe(float x, float y, float z, float scale) {

	        Tessellator tesselator = Tessellator.instance;
	        ForgeHooksClient.bindTexture("/TheArni/GasCraft/Textures/SoftCopperPipe.png", 0);
	        GL11.glPushMatrix(); //start
	        GL11.glTranslatef(x, y, z); //size
	        pipeModel.render(scale);
	        GL11.glPopMatrix(); //end
	    }
}
