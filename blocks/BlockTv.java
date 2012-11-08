package FunMod.blocks;
import java.util.Random;

import net.minecraft.server.BlockContainer;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Item;
import net.minecraft.server.Material;
import net.minecraft.server.TileEntity;
import net.minecraft.server.World;
import net.minecraft.server.WorldServer;
import FunMod.FunMod;
import FunMod.items.ItemControle;
import FunMod.tileentidades.EntidadeN64;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.server.FMLServerHandler;
public class BlockTv extends BlockContainer  

{


private  WorldServer server;

public BlockTv(int par1, int par2, Class class1)
{

super(par1, par2, Material.STONE);
this.a(FunMod.funmodtab);
this.r(); 
this.textureId = 33;
this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
}

 public int idDropped()
{
return FunMod.tb.id; 
}
public int quantityDropped(Random par1Random)
{
return 1;
}
//Linkado ao proxy do cliente pois somente ele que possui os metodos de renderizacao, caso linkasse ao do server o bloco bugaria


public boolean isOpaqueCube() {
return false;
}
public boolean renderAsNormalBlock() {
return false;
}


/**
* Determines the damage on the item the block drops. Used in cloth and wood.
*/
public int damageDropped(int par1)
{
return par1;
}


@Override
public boolean interact(World world, int i, int j, int k, EntityHuman entityplayer, int par6, float par7, float par8, float par9) {

EntidadeN64 tile = (EntidadeN64) world.getTileEntity(i, j, k);


Item equipped = entityplayer.inventory.getItemInHand() != null ? entityplayer.inventory.getItemInHand().getItem() : null;

entityplayer.sendMessage("You need a Remote Control to activate the Televison");

if (equipped instanceof ItemControle){

	
		   
	              entityplayer.sendMessage("Teleporting");
		        if (entityplayer.dimension != 10){	
		        	
		        	FMLServerHandler.instance().getServer();
		            
		           
		        }
		        else {
		      
		        	FMLCommonHandler.instance().getMinecraftServerInstance();	
		           return true;
		        }


	    




return true;

}
return true;
}
	
	
	
	public TileEntity getBlockEntity() {
return new EntidadeN64();

}


public TileEntity createNewTileEntity(World var1)
{
	return new EntidadeN64();

}
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}

@Override
public TileEntity a(World arg0) {
	// TODO Auto-generated method stub
	return new EntidadeN64();
}

}










	
	
 // to get all sub blocks. make it more or less ass you please.


