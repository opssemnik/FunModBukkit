package FunMod.blocks;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.event.block.LeavesDecayEvent;

import net.minecraft.server.Block;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import FunMod.FunMod;

public class FantasyLeaf extends BlockLeaves
{

    private int baseIndexInPNG;
    int adjacentTreeBlocks[];

    
    
    
    public FantasyLeaf(int i, int j)
    {
        super(i, j);
        //baseIndexInPNG = j;   - Not needed
        b(true);
        this.textureId = 31;
        this.a(FunMod.funmodtab);
    }
    
   
    /*public int getRenderColor(int i)
    {
        if((i & 1) == 1)
        {
            return ColorizerFoliage.getFoliageColorPine();
        }
        if((i & 2) == 2)
        {
            return ColorizerFoliage.getFoliageColorBirch();
        } else
        {
            return ColorizerFoliage.getFoliageColorBasic();
        }
    }      *************Unnecessary Method */

   
    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.d(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getTypeId(i + j1, j + k1, k + l1);
                        if(i2 == Block.SAPLING.id)              ///////Leaf/////////////
                        {
                            int j2 = world.getData(i + j1, j + k1, k + l1);
                            world.setData(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.isStatic)
        {
            return;
        }
        int l = world.getData(i, j, k);
        if((l & 8) != 0 && (l & 4) == 0)
        {
            byte byte0 = 4;
            int i1 = byte0 + 1;
            byte byte1 = 32;
            int j1 = byte1 * byte1;
            int k1 = byte1 / 2;
            if(adjacentTreeBlocks == null)
            {
                adjacentTreeBlocks = new int[byte1 * byte1 * byte1];
            }
            if(world.d(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    for(int k2 = -byte0; k2 <= byte0; k2++)
                    {
                        for(int i3 = -byte0; i3 <= byte0; i3++)
                        {
                            int k3 = world.getTypeId(i + l1, j + k2, k + i3);
                            if(k3 ==FunMod.FantasyLog.id)            ///////Log//////////////
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = 0;
                                continue;
                            }
                            if(k3 ==FunMod.FantasyLeaf.id)               ///////Leaf///////////
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -2;
                            } else
                            {
                                adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -1;
                            }
                        }

                    }

                }

                for(int i2 = 1; i2 <= 4; i2++)
                {
                    for(int l2 = -byte0; l2 <= byte0; l2++)
                    {
                        for(int j3 = -byte0; j3 <= byte0; j3++)
                        {
                            for(int l3 = -byte0; l3 <= byte0; l3++)
                            {
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] != i2 - 1)
                                {
                                    continue;
                                }
                                if(adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] = i2;
                                }
                                if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] == -2)
                                {
                                    adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] = i2;
                                }
                            }

                        }

                    }

                }

            }
            int j2 = adjacentTreeBlocks[k1 * j1 + k1 * byte1 + k1];
            if(j2 >= 0)
            {
                world.setData(i, j, k, l & -9);
            } else
            {
                removeLeaves(world, i, j, k);
            }
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
    	 LeavesDecayEvent event = new LeavesDecayEvent(world.getWorld().getBlockAt(i, j, k));
    	    world.getServer().getPluginManager().callEvent(event);

    	    if (event.isCancelled()) {
    	      return;
    	    }

    	    c(world, i, j, k, world.getData(i, j, k), 0);
        world.setTypeId(i, j, k, 0);
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Block.SAPLING.id;
    }

   

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
      return true;
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
      ArrayList var7 = new ArrayList();
      var7.add(new ItemStack(this, 1, var2.getData(var3, var4, var5) & 0x3));
      return var7;
    }

    public int damageDropped(int i)
    {
        return i & 3;
    }

    

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if((j & 3) == 1)
        {
            return textureId;          //get rid of the 80///////////
        } else
        {
            return textureId;          
        }
    }

 

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        super.a(world, i, j, k, entity);
    }
   public String getTextureFile(){
	   return "/FunMod/cliente/texturas/texturas.png";
   }
    
}
