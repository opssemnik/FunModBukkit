package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.PathfinderGoalMeleeAttack;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;

public class EntityVenom extends EntityMobFun
{
    

	private int attackStrength;

	public EntityVenom(World par1World)
    {
        super(par1World);
        this.texture = "/FunMod/cliente/texturas/Mobs/Venom.png";
        this.bI = 0.23F;
        attackStrength = 40;
        this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 0.4F));
        this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, EntityHomemAranha.class, this.bI, false));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHomemAranha.class, 16.0F, 0, true));
        this.goalSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.attackStrength = 4;  
    }

    
    public int getMaxHealth()
    {
        return 25;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
   

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    

    /**
     * Returns the sound this mob makes while it's alive.
     */
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
        return 8.5F;
    }
    
    protected int getDropid()
    {
        return Item.STRING.id;
    }
    
}

	 