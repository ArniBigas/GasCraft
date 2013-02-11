package TheArni.GasCraft.Pipes;

import TheArni.GasCraft.GasCraft;
import net.minecraft.tileentity.TileEntity;

public class GasPipe_softCopper extends TileEntity {
	public PipeNetworks network;

	public GasPipe_softCopper(){
		this.network = new PipeNetworks();
	}
}
