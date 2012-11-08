package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntitySpider;
import net.minecraft.server.EnumCreatureType;
import net.minecraft.server.EnumMonsterType;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.World;

public class EntityMegaMan extends EntityMobFun
{
	
	private boolean isPeacefulCreature;
	
    public EntityMegaMan(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/MEGAMAN.png"; 
        a(0.9F, 1.3F);      
        this.attackStrength = 3;
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntitySpider.class, 16.0F, 0, true));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityDoctorWilly.class, 16.0F, 0, true));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.20F));
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 0.4F));
    }
    public EnumMonsterType getMonsterType() {
        return EnumMonsterType.UNDEAD;
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