package FunMod.blocks;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityItem;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.MathHelper;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.TileEntity;
import net.minecraft.server.World;
import FunMod.FunMod;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
public class FantasyFurnace extends BlockContainer
{
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private Random furnaceRand = new Random();

    /** True if this is an active furnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
     * furnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory = false;

    public FantasyFurnace(int par1, boolean par2)
    {
        super(par1, Material.STONE);
        this.isActive = par2;
        this.textureId = 39;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return FunMod.desatibada.id;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onPlace(World par1World, int par2, int par3, int par4)
    {
        super.onPlace(par1World, par2, par3, par4);
        l(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void l(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isStatic)
        {
            int var5 = par1World.getTypeId(par2, par3, par4 - 1);
            int var6 = par1World.getTypeId(par2, par3, par4 + 1);
            int var7 = par1World.getTypeId(par2 - 1, par3, par4);
            int var8 = par1World.getTypeId(par2 + 1, par3, par4);
            byte var9 = 3;

            if (Block.q[var5] && !Block.q[var6])
            {
                var9 = 3;
            }

            if (Block.q[var6] && !Block.q[var5])
            {
                var9 = 2;
            }

            if (Block.q[var7] && !Block.q[var8])
            {
                var9 = 5;
            }

            if (Block.q[var8] && !Block.q[var7])
            {
                var9 = 4;
            }

            par1World.setData(par2, par3, par4, var9);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int a(int paramInt)
    {
      if (paramInt == 1) return this.textureId - 1;
      if (paramInt == 0) return this.textureId - 1;
      if (paramInt == 3) return this.textureId - 1;
      return this.textureId;
    }

  
    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
	
    /**
     * Called upon block activation (right click on the block.)
     */
@Override
public boolean interact(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityHuman paramEntityHuman, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3)
{
  if (paramWorld.isStatic) {
    return true;
  }
       
        	TileEntity blockEntity = (TileEntity)paramWorld.getTileEntity(paramInt1, paramInt3, paramInt4);

           
        	
            	EntidadeFantasyFurnace var10 = (EntidadeFantasyFurnace)paramWorld.getTileEntity(paramInt1, paramInt3,paramInt4);
    			paramEntityHuman.openGui(FunMod.instance, 1, paramWorld, paramInt1, paramInt3, paramInt4);
    		

            return true;
            }  
    

    
    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */

    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getData(par2, par3, par4);
        TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (par0)
        {
            par1World.setTypeId(par2, par3, par4, FunMod.atiba.id);
        }
        else
        {
            par1World.setTypeId(par2, par3, par4, FunMod.atiba.id);
        }

        keepFurnaceInventory = false;
        par1World.setData(par2, par3, par4, var5);

        if (var6 != null)
        {
            var6.update();
            par1World.setTileEntity(par2, par3, par4, var6);
        }
    }

    /**
     * each class overrdies this to return a new <className>
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        return new EntidadeFantasyFurnace();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor((double)(par5EntityLiving.yaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setData(par2, par3, par4, 2);
        }

        if (var6 == 1)
        {
            par1World.setData(par2, par3, par4, 5);
        }

        if (var6 == 2)
        {
            par1World.setData(par2, par3, par4, 3);
        }

        if (var6 == 3)
        {
            par1World.setData(par2, par3, par4, 4);
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepFurnaceInventory)
        {
        	EntidadeFantasyFurnace var7 = (EntidadeFantasyFurnace)par1World.getTileEntity(par2, par3, par4);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSize(); ++var8)
                {
                    ItemStack var9 = var7.getItem(var8);

                    if (var9 != null)
                    {
                        float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (var9.count > 0)
                        {
                            int var13 = this.furnaceRand.nextInt(21) + 10;

                            if (var13 > var9.count)
                            {
                                var13 = var9.count;
                            }

                            var9.count -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.id, var13, var9.getData()));

                            if (var9.hasTag())
                            {
                                var14.itemStack.setTag((NBTTagCompound)var9.getTag().clone());
                            }

                            float var15 = 0.05F;
                            var14.motX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            var14.motY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                            var14.motZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            par1World.addEntity(var14);
                        }
                    }
                }
            }
        }

        super.remove(par1World, par2, par3, par4, par5, par6);
    }
    
    @Override
	public String getTextureFile()
    {
		return "/FunMod/cliente/texturas/texturas.png";
	}

	@Override
	public TileEntity a(World arg0) {
		
		return new EntidadeFantasyFurnace();
	}
}