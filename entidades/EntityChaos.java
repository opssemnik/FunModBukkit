package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;

public class EntityChaos extends EntityMobFun
{
    public EntityChaos(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Chaos.png"; 
        a(1F*1F, 2F*2F);   
        this.bI = 0.5F;
        this.attackStrength = 6;  
        /**
        this.goalSelector.a(1, new  PathfinderGoalMeleeAttack(this, EntityHuman.class.class, this.this.bI, false));
        **/
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
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
        return Item.IRON_SWORD.id; 
    }

   
    
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 