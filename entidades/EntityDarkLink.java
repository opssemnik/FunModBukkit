package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalMeleeAttack;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;
import FunMod.FunMod;

public class EntityDarkLink extends EntityMobFun
{
    public EntityDarkLink(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/DarkLink.png"; 
        a(0.9F, 1.3F);  
        this.bI = 0.5F;
        this.attackStrength = 8;  
        this.goalSelector.a(1, new  PathfinderGoalMeleeAttack(this, EntityHuman.class, this.bI, false));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
        this.goalSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityLink.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 28; 
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
        return FunMod.PearlOfLink.id; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 