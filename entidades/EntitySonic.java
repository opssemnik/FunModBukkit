package FunMod.entidades;

import net.minecraft.server.EntityAnimal;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathfinderGoalLookAtPlayer;
import net.minecraft.server.PathfinderGoalPanic;
import net.minecraft.server.PathfinderGoalRandomLookaround;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.World;
import FunMod.FunMod;

public class EntitySonic extends EntityAnimal
{
    public EntitySonic(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Sonic.png"; 
        a(1F*1F, 0.8F*0.8F);       
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 0.15F));
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 0.5F));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, net.minecraft.server.EntityHuman.class, 6F));
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
    protected float getSoundVolume()
    {
        return 0.4F;
    }

 /**
    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(FunMod.SonicBoots.id, 1);
        }
    }
    **/
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }

	@Override
	public EntityAnimal createChild(EntityAnimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}
    
    


} 