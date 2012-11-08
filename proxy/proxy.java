package FunMod.proxy;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.TileEntity;
import net.minecraft.server.World;
import FunMod.containers.ContainerFantasyFurnace;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import cpw.mods.fml.common.network.IGuiHandler;
public class proxy implements IGuiHandler
{
    public void registerRenderThings()
    {
        
    }
    public void renderMobs()
    {
    }
	public void renderBlocoComModelo() {
		// TODO Auto-generated method stub
		
	}
	
    public Object getServerGuiElement(int id, EntityHuman player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof EntidadeFantasyFurnace){
                    return new ContainerFantasyFurnace(player.inventory, (EntidadeFantasyFurnace) tileEntity);
            }
            return null;
}
	
	public void loadUtilities() {}
	public void loadTickHandler()
	{
		
	}
	
	public void init() {
		// TODO Auto-generated method stub


}
 
	public void renderItemComModelos(int var1){
	      
        
       
}
	
	public void rendercontrole() {
		
		
	}
	@Override
	public Object getClientGuiElement(int arg0, EntityHuman arg1, World arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return null;
	}
	

    
}