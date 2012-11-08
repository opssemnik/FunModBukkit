package FunMod.blocks;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import FunMod.FunMod;
public class FantasyGrass extends Block
{
    public FantasyGrass(int par1, int par2)
    {
        super(par1, par2, Material.EARTH);
        b(true);
        this.a(FunMod.funmodtab);
    }
    @Override
    public int getDropType(int par1, Random par2Random, int par3)
    {
        return FunMod.FantasyDIRT.getDropType(0, par2Random, par3);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.isStatic)
        {
            return;
        }

        if (par1World.getLightLevel(par2, par3 + 1, par4) < 4 && Block.lightBlock[par1World.getTypeId(par2, par3 + 1, par4)] > 2)
        {
            par1World.setTypeId(par2, par3, par4, FunMod.FantasyGrass.id);
        }
        else if (par1World.getLightLevel(par2, par3 + 1, par4) >= 9)
        {
            for (int i = 0; i < 45; i++)
            {
                int j = (par2 + par5Random.nextInt(3)) - 1;
                int k = (par3 + par5Random.nextInt(5)) - 3;
                int l = (par4 + par5Random.nextInt(3)) - 1;
                int i1 = par1World.getTypeId(j, k + 1, l);

                if (par1World.getTypeId(j, k, l) == Block.GRASS.id && par1World.getLightLevel(j, k + 1, l) >= 4 && Block.lightBlock[i1] <= 2)
                {
                    par1World.setTypeId(j, k, l, FunMod.FantasyGrass.id);
                }
            }
        }
    }
   
    
    public String getTextureFile(){
     return "/FunMod/cliente/texturas/texturas.png";
    }
    	
    	
    	public int getBlockTextureFromSideAndMetadata (int i, int j)
    {
    	
    	if (i == 0)
    		
    		return 28;
    	if (i == 1)
    		
    		return 26;
    	
    	if (i == 2)
    		
    		return 27;
    	if (i == 3)
    		
    		return 27;
    	if (i == 4)
	
    		return 27;
    	if (i == 5)
	
    		return 27;
   
    	if (j ==1)
    	{
    		return 166;
    	}
    
    		return j != 2 ? 20 : 177;
    }

}
