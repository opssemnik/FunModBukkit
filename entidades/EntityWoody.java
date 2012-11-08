package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EnumMonsterType;
import net.minecraft.server.Item;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalFollowParent;
import net.minecraft.server.PathfinderGoalLeapAtTarget;
import net.minecraft.server.PathfinderGoalLookAtPlayer;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.PathfinderGoalRandomLookaround;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.World;

public class EntityWoody extends EntityAnimal 
{
    public EntityWoody(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/WOODY.png"; 
        a(0.9F, 1.3F);      
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.25F));
        this.goalSelector.a(2, new PathfinderGoalLeapAtTarget(this, 0.2F));
        this.goalSelector.a(4, new  PathfinderGoalFollowParent(this, 0.25F));
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 0.2F));
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

 
    protected int getDropid()
    {
        return Item.APPLE.id; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    
    public EnumMonsterType getCreatureAttribute()
    {
        return EnumMonsterType.UNDEAD;
    }

	@Override
	public EntityAnimal createChild(EntityAnimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}

} 