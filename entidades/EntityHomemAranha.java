package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.Item;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalAvoidPlayer;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.World;

public class EntityHomemAranha extends EntityMobFun
{
    public EntityHomemAranha(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Spiderman.png"; 
        a(0.9F, 1.3F);    
        this.attackStrength = 4;  
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.10F));
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 0.4F));
        this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityVenom.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 25; 
    }

    public void a(NBTTagCompound par1NBTTagCompound)
    {
        super.a(par1NBTTagCompound); 
    }

    public void b(NBTTagCompound par1NBTTagCompound)
    {
        super.b(par1NBTTagCompound);
    }

    protected String getLivingSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.spiderdeath";
    }


    protected float getSoundVolume()
    {
        return 0.4F;
    }

 
  

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    public float spiderScaleAmount()
    {
        return 6.5F;
    }
    
    protected int getDropid()
    {
        return Item.STRING.id;
    }
    
}

	 