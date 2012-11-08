package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityZombie;
import net.minecraft.server.EnumMonsterType;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.World;

public class EntityAsh extends EntityMobFun
{
    private boolean isPeacefulCreature;

    
	public EntityAsh(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Ash.png"; 
        a(0.9F, 1.3F); 
        this.bI = 0.23F;
        attackStrength = 3;
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.20F));
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 0.4F));
        this.goalSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityZombie.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 25; 
    }
    public EnumMonsterType getMonsterType() {
        return EnumMonsterType.UNDEAD;
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

    
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }


    protected float getSoundVolume()
    {
        return 0.6F;
    }

    public boolean getPeacefulCreature()
    {
        return this.isPeacefulCreature;
    }
    
  
    
  

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
 
    
}

	 