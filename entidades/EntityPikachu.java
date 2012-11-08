package FunMod.entidades;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MathHelper;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalFloat;
import net.minecraft.server.PathfinderGoalLookAtPlayer;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.PathfinderGoalRandomLookaround;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.World;
import FunMod.FunMod;

/** ticks until heightOffset is randomized */


public class EntityPikachu extends EntityMobFun
{
	private int heightOffsetUpdateTime;
	private int field_70846_g;
	
    public EntityPikachu(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/ModelPikachuHD.png"; 
        this.a(0.4F, 0.8F);     
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.15F));
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 0.5F));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, net.minecraft.server.EntityPlayer.class, 6F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 30; 
    }
/**
    protected void attackEntity(Entity par1Entity, float par2)
    {
       
            this.attackTicks = 20;
            this.l(par1Entity);
       
         if (par2 < 30.0F)
        {
            double var3 = par1Entity.locX - this.locX;
            double var5 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.locY + (double)(this.height / 2.0F));
            double var7 = par1Entity.locZ - this.locZ;

            if (this.attackTicks == 0)
            {
                ++this.field_70846_g;

                if (this.field_70846_g == 1)
                {
                    this.attackTicks = 60;
                    this.func_70844_e(true);
                }
                else if (this.field_70846_g <= 4)
                {
                    this.attackTicks = 6;
                }
                else
                {
                    this.attackTicks = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }

                if (this.field_70846_g > 1)
                {
                    float var9 = MathHelper.sqrt_float(par2) * 0.5F;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                    for (int var10 = 0; var10 < 1; ++var10)
                    {
                        EntityThunderBolt var11 = new EntityThunderBolt(this.worldObj, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
                        var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                        this.worldObj.spawnEntityInWorld(var11);
                    }
                }
            }

            this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
    }

 **/  

    
    public boolean func_70845_n()
    {
        return (this.datawatcher.getByte(16) & 1) != 0;
    }

    public void func_70844_e(boolean par1)
    {
        byte var2 = this.datawatcher.getByte(16);

        if (par1)
        {
            var2 = (byte)(var2 | 1);
        }
        else
        {
            var2 &= -2;
        }

        this.datawatcher.watch(16, Byte.valueOf(var2));
    }
	public void b(NBTTagCompound par1NBTTagCompound)
    {
        super.b(par1NBTTagCompound); 
    }

    public void a(NBTTagCompound par1NBTTagCompound)
    {
        super.a(par1NBTTagCompound);
    }

    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }
    protected float getSoundVolume()
    {
        return 0.4F;
    }

 
    protected int getDropid()
    {
        return FunMod.ThunderDust.id; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 