package TheArni.GasCraft.Models;

import org.lwjgl.opengl.GL11;

import TheArni.GasCraft.Pipes.GasPipe_softCopper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.ForgeHooksClient;

public class ModelPipe extends ModelBase
{
	//fields
	ModelRenderer Pipe;
	private float scale;

	public ModelPipe(float scale)
	{
		this.scale = scale;
		textureWidth = 64;
		textureHeight = 32;

		Pipe = new ModelRenderer(this, 0, 0);
		Pipe.addBox(0F, 0F, 0F, 16, 3, 4, scale);
		Pipe.setRotationPoint(0F, 0F, 6F);
		Pipe.setTextureSize(64, 32);
		Pipe.mirror = true;
	}
	public void render(float scale)
	{
		Pipe.render(scale);
	}

	public void render(GasPipe_softCopper tileEntity, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glTranslated(x, y, z);
		ForgeHooksClient.bindTexture("/TheArni/GasCraft/Textures/SoftCopperPipe.png", 0);

		Pipe.render(scale);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}
