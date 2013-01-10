package TheArni.GasCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

// Global Handler, use it for every TileEntity

public class GuiHandler implements IGuiHandler{
 
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
       
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
               
                if(tile_entity instanceof PipeMaker){
               
                        return new PipeMakerContainer((PipeMaker) tile_entity, player.inventory);
                }
                
                /*
                 * Write this for different tiles
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
               
                if(tile_entity instanceof [TILE]){
               
                        return new TileContainer(([TILE]) tile_entity, player.inventory);
                }
                 */
               
               
                return null;
        }
       
       
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
       
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
               
               
                if(tile_entity instanceof PipeMaker){
       
                        return new PipeMakerGUI(player.inventory, (PipeMaker) tile_entity);
                }
                
                /*
                 * Write this for different tiles
                if(tile_entity instanceof ){
       
                        return new TileGUI(player.inventory, ([TILE]) tile_entity);
                }
                 */
       
        return null;
        }
}