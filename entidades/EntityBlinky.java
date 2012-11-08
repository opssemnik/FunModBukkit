package FunMod.entidades;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.World;

public class EntityBlinky extends EntityMobFun
{
    public EntityBlinky(World par1World)
    {
        super(par1World);
        this.a(0.3F, 0.7F);
        this.texture = "/FunMod/cliente/texturas/Mobs/Blinky.png";
        this.bI = 0.23F;
        this.attackStrength = 3; 
        /*
        this.goalSelector.a(1, new EntityAIAttackOnCollide(this, EntityHuman.class, this.bI, false));
        */
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 16.0F, 0, true));
        
    }

    
    public int getMaxHealth()
    {
        return 20;
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
        return "mob.silverfish.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    

    
}