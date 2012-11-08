package FunMod.blocks;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import FunMod.FunMod;
public class FantasyLog extends Block
{
    public FantasyLog(int par1)
    {
        super(par1, Material.WOOD);
        textureId = 20;
        this.a(FunMod.funmodtab);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return FunMod.FantasyLog.id;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    

    /**
     * Called whenever the block is removed.
     */
    public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        byte byte0 = 4;
        int i = byte0 + 1;

        if (par1World.d(par2 - i, par3 - i, par4 - i, par2 + i, par3 + i, par4 + i))
        {
            for (int j = -byte0; j <= byte0; j++)
            {
                for (int k = -byte0; k <= byte0; k++)
                {
                    for (int l = -byte0; l <= byte0; l++)
                    {
                        int i1 = par1World.getTypeId(par2 + j, par3 + k, par4 + l);

                        if (i1 != Block.LEAVES.id)
                        {
                            continue;
                        }

                        int j1 = par1World.getData(par2 + j, par3 + k, par4 + l);

                        if ((j1 & 8) == 0)
                        {
                            par1World.setData(par2 + j, par3 + k, par4 + l, j1 | 8);
                        }
                    }
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int i, int j)  
    {
    	if(i == 0)
			return 29; //This is the bottom of the log
		if(i == 1)
			return 29; //This is the top
		if(i == 2)
			return 30; //These are the sides
		if(i == 3)
			return 30;
		if(i == 4)
			return 30;
		if(i == 5)
			return 30;
		
        if(j == 1)
        {
            return 116;
        }
        return j != 2 ? 20 : 117;
    }
    
    public int damageDropped(int par1)
    {
        return par1;
    }
 public String getTextureFile(){
	 return "/FunMod/cliente/texturas/texturas.png";
 }
}
