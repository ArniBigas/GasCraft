package TheArni.GasCraft.Pipes;

import net.minecraft.tileentity.TileEntity;

public class GasPipe_softCopper extends TileEntity {
	private PipeNetworks network;

	public GasPipe_softCopper(){
		this.network = new PipeNetworks();
	}
}
