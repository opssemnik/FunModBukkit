package FunMod.entidades;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.MobEffect;
import net.minecraft.server.PathfinderGoalMeleeAttack;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;

import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import FunMod.FunMod;
public class EntityMage extends EntityMobFun
{
	
    public EntityMage(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/firemage.png"; 
        a(0.9F, 1.0F);      
        this.bI = 0.4F;
        this.attackStrength = 2;  
        this.goalSelector.a(1, new  PathfinderGoalMeleeAttack(this, EntityHuman.class, this.bI, false));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 20; 
    }

   /** 
    public boolean l(Entity par1Entity)
    {
        if (super.l(par1Entity))
        {
            if (par1Entity instanceof EntityLiving)
            {
                byte var2 = 0;

                if (this.world.difficulty > 1)
                {
                    if (this.world.difficulty == 2)
                    {
                        var2 = 7;
                    }
                    else if (this.world.difficulty == 3)
                    {
                        var2 = 15;
                    }
                }

                if (var2 > 0)
                {
                    ((EntityLiving)par1Entity).addEffect(new MobEffect.POSION.id, var2 * 20, 0));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
**/
    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }


    protected float getSoundVolume()
    {
        return 0.4F;
    }

 
    protected int getDropid()
    {
        return FunMod.MarioCoin.id; 
    }
/**
    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(FunMod.ObsidianStick.id, 1);
        }
    }
   **/
public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    
   

} 