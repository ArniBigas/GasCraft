package TheArni.GasCraft.GUI;

import org.lwjgl.opengl.GL11;

import TheArni.GasCraft.Blocks.PipeMaker;
import TheArni.GasCraft.Blocks.PipeMakerContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
 
 
public class PipeMakerGUI extends GuiContainer{
        public PipeMakerGUI(InventoryPlayer player_inventory, PipeMaker tile_entity){
                super(new PipeMakerContainer(tile_entity, player_inventory));
        }
       
       
        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j){
       
                fontRenderer.drawString("Aithight Chamber", 6, 6, 0x000000);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0x000000);
        }
       
       
        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
       
                int picture = mc.renderEngine.getTexture("/TheArni/GasCraft/GUI/PipeMaker.png");
               
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
               
                this.mc.renderEngine.bindTexture(picture);
               
                int x = (width - xSize) / 2;
               
                int y = (height - ySize) / 2;
               
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }
}

