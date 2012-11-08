package FunMod.blocks;
import java.util.Random;

import net.minecraft.server.BlockContainer;
import net.minecraft.server.Material;
import net.minecraft.server.TileEntity;
import net.minecraft.server.World;
import FunMod.FunMod;
import FunMod.tileentidades.EntidadeSofa;
public class BlockSofa extends BlockContainer  
{

	public static boolean disableValidation = false;

public BlockSofa(int par1, int par2, Class class1)
{

super(par1, par2, Material.STONE);
this.a(FunMod.funmodtab);
this.r(); 
this.textureId = 45;

}

 public int idDropped()
{
return FunMod.tb.id; 
}
public int quantityDropped(Random par1Random)
{
return 1;
}


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


public TileEntity getBlockEntity() {
return new EntidadeSofa();

}


public TileEntity createNewTileEntity(World var1)
{
	return new EntidadeSofa();

}
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}

@Override
public TileEntity a(World arg0) {
	// TODO Auto-generated method stub
	return new EntidadeSofa();
}

}










	
	
 // to get all sub blocks. make it more or less ass you please.


