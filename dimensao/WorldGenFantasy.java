package FunMod.dimensao;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;
import FunMod.FunMod;
public class WorldGenFantasy extends WorldGenerator
{
    private final  int field_48202_a;
    private final boolean field_48200_b;
    private final  int field_48201_c;
    private final  int field_48199_d;

    public WorldGenFantasy(boolean par1)
    {
        this(par1, 4, 0, 0, false);
    }
    
    public WorldGenFantasy(boolean par1, int par2, int par3, int par4, boolean par5)
    {
        super(par1);
        field_48202_a = par2;
        field_48201_c = par3;
        field_48199_d = par4;
        field_48200_b = par5;
    }

    public boolean a(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int i = par2Random.nextInt(25) + field_48202_a;
        boolean flag = true;

        if (par4 < 1 || par4 + i + 1 > 256)
        {
            return false;
        }

        for (int j = par4; j <= par4 + 1 + i; j++)
        {
            byte byte0 = 1;

            if (j == par4)
            {
                byte0 = 0;
            }

            if (j >= (par4 + 1 + i) - 2)
            {
                byte0 = 2;
            }

            for (int l = par3 - byte0; l <= par3 + byte0 && flag; l++)
            {
                for (int j1 = par5 - byte0; j1 <= par5 + byte0 && flag; j1++)
                {
                    if (j >= 0 && j < 256)
                    {
                        int j2 = par1World.getTypeId(l, j, j1);

                        if (j2 != 0 && j2 != FunMod.FantasyLeaf.id && j2 != FunMod.FantasyGrass.id && j2 != FunMod.FantasyDIRT.id && j2 != FunMod.FantasyLog.id)
                        {
                            flag = false;
                        }
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
        }

        if (!flag)
        {
            return false;
        }

        int k = par1World.getTypeId(par3, par4 - 1, par5);

        if (k != FunMod.FantasyGrass.id && k != FunMod.FantasyDIRT.id || par4 >= 256 - i - 1)
        {
            return false;
        }

        par1World.setData(par3, par4 - 1, par5, FunMod.FantasyDIRT.id);
        byte byte1 = 3;
        int i1 = 0;

        for (int k1 = (par4 - byte1) + i; k1 <= par4 + i; k1++)
        {
            int k2 = k1 - (par4 + i);
            int j3 = (i1 + 1) - k2 / 2;

            for (int l3 = par3 - j3; l3 <= par3 + j3; l3++)
            {
                int j4 = l3 - par3;

                for (int l4 = par5 - j3; l4 <= par5 + j3; l4++)
                {
                    int i5 = l4 - par5;

                    if ((Math.abs(j4) != j3 || Math.abs(i5) != j3 || par2Random.nextInt(2) != 0 && k2 != 0) && !Block.q[par1World.getTypeId(l3, k1, l4)])
                    {
                    	par1World.setTypeIdAndData(l3, k1, l4, FunMod.FantasyLeaf.id, field_48199_d);
                    }
                }
            }
        }

        for (int l1 = 0; l1 < i; l1++)
        {
            int l2 = par1World.getTypeId(par3, par4 + l1, par5);

            if (l2 != 0 && l2 != FunMod.FantasyLeaf.id)
            {
                continue;
            }

            par1World.setTypeIdAndData(par3, par4 + l1, par5, 	FunMod.FantasyLog.id, 1);

            if (!field_48200_b || l1 <= 0)
            {
                continue;
            }

            if (par2Random.nextInt(3) > 0 && par1World.isEmpty(par3 - 1, par4 + l1, par5))
            {
            	par1World.setTypeIdAndData(par3 - 1, par4 + l1, par5, Block.VINE.id, 8);
            }

            if (par2Random.nextInt(3) > 0 && par1World.isEmpty(par3 + 1, par4 + l1, par5))
            {
            	par1World.setTypeIdAndData(par3 + 1, par4 + l1, par5, Block.VINE.id, 2);
            }

            if (par2Random.nextInt(3) > 0 && par1World.isEmpty(par3, par4 + l1, par5 - 1))
            {
            	par1World.setTypeIdAndData(par3, par4 + l1, par5 - 1, Block.VINE.id, 1);
            }

            if (par2Random.nextInt(3) > 0 && par1World.isEmpty(par3, par4 + l1, par5 + 1))
            {
                par1World.setTypeIdAndData(par3, par4 + l1, par5 + 1, Block.VINE.id, 4);
            }
        }

        if (field_48200_b)
        {
            for (int i2 = (par4 - 3) + i; i2 <= par4 + i; i2++)
            {
                int i3 = i2 - (par4 + i);
                int k3 = 2 - i3 / 2;

                for (int i4 = par3 - k3; i4 <= par3 + k3; i4++)
                {
                    for (int k4 = par5 - k3; k4 <= par5 + k3; k4++)
                    {
                        if (par1World.getTypeId(i4, i2, k4) != FunMod.FantasyLeaf.id)
                        {
                            continue;
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getTypeId(i4 - 1, i2, k4) == 0)
                        {
                        	setTypeAndData(par1World, i4 - 1, i2, k4, 8);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getTypeId(i4 + 1, i2, k4) == 0)
                        {
                        	setTypeAndData(par1World, i4 + 1, i2, k4, 2);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getTypeId(i4, i2, k4 - 1) == 0)
                        {
                        	setTypeAndData(par1World, i4, i2, k4 - 1, 1);
                        }

                        if (par2Random.nextInt(4) == 0 && par1World.getTypeId(i4, i2, k4 + 1) == 0)
                        {
                        	setTypeAndData(par1World, i4, i2, k4 + 1, 4);
                        }
                    }
                }
            }
        }

        return true;
    }

    private void setTypeAndData(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.setTypeIdAndData(par2, par3, par4, Block.VINE.id, par5);

        for (int i = 4; par1World.getTypeId(par2, --par3, par4) == 0 && i > 0; i--)
        {
            par1World.setRawTypeIdAndData(par2, par3, par4, Block.VINE.id, par5);
        }
    }
}
