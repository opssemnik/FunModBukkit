package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalMeleeAttack;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;

public class EntityDoctorWilly extends EntityMobFun
{
	
	
    public EntityDoctorWilly(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/willy.png"; 
        a(0.9F, 1.3F);  
        this.bI = 0.5F;
        this.attackStrength = 7;  
        this.goalSelector.a(1, new  PathfinderGoalMeleeAttack(this, EntityHuman.class, this.bI, false));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
        this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, EntityMegaMan.class, this.bI, false));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityMegaMan.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 30; 
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
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }


    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected int getDropid()
    {
        return 2;
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 