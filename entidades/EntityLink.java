package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EnumMonsterType;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.World;
import FunMod.FunMod;
public class EntityLink extends EntityMobFun
{
    private boolean isPeacefulCreature;

    private static final ItemStack defaultHeldItem = new ItemStack(FunMod.LinkSword , 0);
    
	public EntityLink(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/LINK.png"; 
        a(0.9F, 1.3F); 
        this.bI = 0.23F;
        attackStrength = 3;
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.20F));
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 0.4F));
        this.goalSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
        
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 25; 
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
    
    protected int getDropid()
    {
        return Item.STONE_SWORD.id; 
    }
    
    public EnumMonsterType getCreatureAttribute()
    {
        return EnumMonsterType.UNDEAD;
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    public ItemStack getHeldItem()
    {
    return defaultHeldItem; 
    }
    
}

	 