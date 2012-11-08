package FunMod.entidades;

import net.minecraft.server.DamageSource;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityBlaze;
import net.minecraft.server.EntityEnderman;
import net.minecraft.server.EntityGiantZombie;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityMonster;
import net.minecraft.server.EntitySilverfish;
import net.minecraft.server.EntitySpider;
import net.minecraft.server.EnumSkyBlock;
import net.minecraft.server.MathHelper;
import net.minecraft.server.MobEffectList;
import net.minecraft.server.World;

import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.event.entity.EntityTargetEvent;

public abstract class EntityMobFun extends EntityMonster
{
    /** How much damage this mob's attacks deal */
    protected int attackStrength = 2;

    public EntityMobFun(World par1World)
    {
        super(par1World);
       
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void c() {
        bl();
        float f = c(1.0F);

        if (f > 0.5F) {
          this.bC += 2;
        }

        super.c();
      }

    /**
     * Called to update the entity's position/logic.
     */
      public void j_() {
    	    super.j_();
    	    if ((!this.world.isStatic) && (this.world.difficulty == 0))
    	      die();
    	  }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findTarget()
    {
      EntityHuman entityhuman = this.world.findNearbyVulnerablePlayer(this, 16.0D);

      return (entityhuman != null) && (m(entityhuman)) ? entityhuman : null;
    }
    /**
     * Called when the entity is attacked.
     */
    public boolean damageEntity(DamageSource damagesource, int i) {
        if (super.damageEntity(damagesource, i)) {
          Entity entity = damagesource.getEntity();

          if ((this.passenger != entity) && (this.vehicle != entity)) {
            if (entity != this)
            {
              
                
        
              
                this.target = entity;
              }

            }

            return true;
          }
          return false;
    
    }
    public boolean l(Entity entity)
    {
      int i = c(entity);

      if (hasEffect(MobEffectList.INCREASE_DAMAGE)) {
        i += (3 << getEffect(MobEffectList.INCREASE_DAMAGE).getAmplifier());
      }

      if (hasEffect(MobEffectList.WEAKNESS)) {
        i -= (2 << getEffect(MobEffectList.WEAKNESS).getAmplifier());
      }

      int j = 0;

      if ((entity instanceof EntityLiving)) {
        i += EnchantmentManager.a(this, (EntityLiving)entity);
        j += EnchantmentManager.getKnockbackEnchantmentLevel(this, (EntityLiving)entity);
      }

      boolean flag = entity.damageEntity(DamageSource.mobAttack(this), i);

      if (flag) {
        if (j > 0) {
          entity.g(-MathHelper.sin(this.yaw * 3.141593F / 180.0F) * j * 0.5F, 0.1D, MathHelper.cos(this.yaw * 3.141593F / 180.0F) * j * 0.5F);
          this.motX *= 0.6D;
          this.motZ *= 0.6D;
        }

        int k = EnchantmentManager.getFireAspectEnchantmentLevel(this, (EntityLiving)entity);

        if (k > 0) {
          entity.setOnFire(k * 4);
        }
      }

      return flag;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void a(Entity entity, float f) {
        if ((this.attackTicks <= 0) && (f < 2.0F) && (entity.boundingBox.e > this.boundingBox.b) && (entity.boundingBox.b < this.boundingBox.e)) {
          this.attackTicks = 20;
          l(entity);
        }
      }


    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float a(int i, int j, int k) {
        return 0.5F - this.world.o(i, j, k);
      }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean i_() {
        int i = MathHelper.floor(this.locX);
        int j = MathHelper.floor(this.boundingBox.b);
        int k = MathHelper.floor(this.locZ);

        if (this.world.b(EnumSkyBlock.SKY, i, j, k) > this.random.nextInt(32)) {
          return false;
        }
        int l = this.world.getLightLevel(i, j, k);

        if (this.world.L()) {
          int i1 = this.world.j;

          this.world.j = 10;
          l = this.world.getLightLevel(i, j, k);
          this.world.j = i1;
        }

        return l <= this.random.nextInt(8);
      }

      public boolean canSpawn()
      {
        return (i_()) && (super.canSpawn());
      }

      public int c(Entity entity) {
        return 2;
      }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
  
}
