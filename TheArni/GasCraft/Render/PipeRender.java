package TheArni.GasCraft.Render;

import TheArni.GasCraft.Models.ModelPipe;
import TheArni.GasCraft.Pipes.GasPipe_softCopper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class PipeRender extends TileEntitySpecialRenderer {
	static final float scale = (float) (1.0 / 16.0);

    private ModelPipe Pipe = new ModelPipe(scale);

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

       Pipe.render((GasPipe_softCopper) tileEntity, x, y, z);
    }

}
