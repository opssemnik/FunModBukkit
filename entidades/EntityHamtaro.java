package FunMod.entidades;

import net.minecraft.server.BlockCloth;
import net.minecraft.server.DamageSource;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityAnimal;
import net.minecraft.server.EntityArrow;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.EntitySheep;
import net.minecraft.server.EntityTameableAnimal;
import net.minecraft.server.EntityWolf;
import net.minecraft.server.Item;
import net.minecraft.server.ItemFood;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MathHelper;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PathEntity;
import net.minecraft.server.PathfinderGoalBreed;
import net.minecraft.server.PathfinderGoalFloat;
import net.minecraft.server.PathfinderGoalFollowOwner;
import net.minecraft.server.PathfinderGoalHurtByTarget;
import net.minecraft.server.PathfinderGoalLeapAtTarget;
import net.minecraft.server.PathfinderGoalLookAtPlayer;
import net.minecraft.server.PathfinderGoalMeleeAttack;
import net.minecraft.server.PathfinderGoalOwnerHurtByTarget;
import net.minecraft.server.PathfinderGoalOwnerHurtTarget;
import net.minecraft.server.PathfinderGoalRandomLookaround;
import net.minecraft.server.PathfinderGoalRandomStroll;
import net.minecraft.server.PathfinderGoalRandomTargetNonTamed;
import net.minecraft.server.World;

import org.bukkit.craftbukkit.event.CraftEventFactory;

public class EntityHamtaro extends EntityTameableAnimal
{
    private float field_70926_e;
    private float field_70924_f;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    /** true is the wolf is wet else false */
    private boolean isShaking;
    private boolean field_70928_h;

    /**
     * This time increases while wolf is shaking and emitting water particles.
     */
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;

    public EntityHamtaro(World par1World)
    {
        super(par1World);
        this.texture = "/FunMod/cliente/texturas/Mobs/Hamtaro.png";
        this.a(0.6F, 0.8F);
        this.bI = 0.3F;
        this.getNavigation().a(true);
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, this.d);
        this.goalSelector.a(3, new PathfinderGoalLeapAtTarget(this, 0.4F));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, this.bI, true));
        this.goalSelector.a(5, new PathfinderGoalFollowOwner(this, this.bI, 10.0F, 2.0F));
        this.goalSelector.a(6, new PathfinderGoalBreed(this, this.bI));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, this.bI));
        this.goalSelector.a(9, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(9, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(1, new PathfinderGoalOwnerHurtByTarget(this));
        this.goalSelector.a(2, new PathfinderGoalOwnerHurtTarget(this));
        this.goalSelector.a(3, new PathfinderGoalHurtByTarget(this, true));
        this.goalSelector.a(4, new PathfinderGoalRandomTargetNonTamed(this, EntitySheep.class, 16.0F, 200, false));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void b(EntityLiving entityliving) {
        super.b(entityliving);
        if ((entityliving instanceof EntityHuman))
          setAngry(true);
      }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void bj()
    {
      this.datawatcher.watch(18, Integer.valueOf(getHealth()));
    }

    public int getMaxHealth()
    {
        return this.isTamed() ? 20 : 8;
    }

    protected void a() {
        super.a();
        this.datawatcher.a(18, new Integer(getHealth()));
        this.datawatcher.a(19, new Byte((byte)0));
        this.datawatcher.a(20, new Byte((byte)BlockCloth.e_(1)));
      }



    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String aW()
    {
        return this.isTamed() ? "/FunMod/cliente/texturas/Mobs/Hamtaro.png" : (this.isAngry() ? "/FunMod/cliente/texturas/Mobs/Hamtaro.png" : super.aW());
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void b(NBTTagCompound par1NBTTagCompound)
    {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void a(NBTTagCompound par1NBTTagCompound)
    {
        super.a(par1NBTTagCompound);
        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return this.isAngry();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
   

    /**
     * Returns the sound this mob makes on death.
     */
   
    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropid()
    {
        return -1;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void c() {
        super.c();
        if ((!this.world.isStatic) && (this.g) && (!this.h) && (!k()) && (this.onGround)) {
          this.H = true;
          this.i = 0.0F;
          this.j = 0.0F;
          this.world.broadcastEntityEffect(this, (byte)8);
        }
      }



    /**
     * Called to update the entity's position/logic.
     */
    public void j_() {
        super.j_();
        this.f = this.e;
        if (bI())
          this.e += (1.0F - this.e) * 0.4F;
        else {
          this.e += (0.0F - this.e) * 0.4F;
        }

        if (bI()) {
          this.bJ = 10;
        }

        if (G()) {
          this.g = true;
          this.h = false;
          this.i = 0.0F;
          this.j = 0.0F;
        } else if (((this.g) || (this.h)) && (this.h)) {
          if (this.i == 0.0F) {
            this.world.makeSound(this, "mob.wolf.shake", aV(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
          }

          this.j = this.i;
          this.i += 0.05F;
          if (this.j >= 2.0F) {
            this.g = false;
            this.h = false;
            this.j = 0.0F;
            this.i = 0.0F;
          }

          if (this.i > 0.4F) {
            float f = (float)this.boundingBox.b;
            int i = (int)(MathHelper.sin((this.i - 0.4F) * 3.141593F) * 7.0F);

            for (int j = 0; j < i; j++) {
              float f1 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
              float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;

              this.world.addParticle("splash", this.locX + f1, f + 0.8F, this.locZ + f2, this.motX, this.motY, this.motZ);
            }
          }
        }
      }
    public boolean getWolfShaking()
    {
        return this.isShaking;
    }

    /**
     * Used when calculating the amount of shading to apply while the wolf is shaking.
     */
    public float getShadingWhileShaking(float par1)
    {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1) / 2.0F * 0.25F;
    }

    public float getShakeAngle(float par1, float par2)
    {
        float var3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1 + par2) / 1.8F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }
        else if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return MathHelper.sin(var3 * (float)Math.PI) * MathHelper.sin(var3 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    public float getInterestedAngle(float par1)
    {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float)Math.PI;
    }

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int bm() {
        return isSitting() ? 20 : super.bm();
      }

    /**
     * Called when the entity is attacked.
     */
    public boolean damageEntity(DamageSource damagesource, int i) {
        Entity entity = damagesource.getEntity();

        this.d.a(false);
        if ((entity != null) && (!(entity instanceof EntityHuman)) && (!(entity instanceof EntityArrow))) {
          i = (i + 1) / 2;
        }

        return super.damageEntity(damagesource, i);
      }

    public boolean l(Entity entity) {
        int i = isTamed() ? 4 : 2;

        return entity.damageEntity(DamageSource.mobAttack(this), i);
      }
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */public boolean c(EntityHuman entityhuman) {
    	    ItemStack itemstack = entityhuman.inventory.getItemInHand();

    	    if (isTamed()) {
    	      if (itemstack != null) {
    	        if ((Item.byId[itemstack.id] instanceof ItemFood)) {
    	          ItemFood itemfood = (ItemFood)Item.byId[itemstack.id];

    	          if ((itemfood.i()) && (this.datawatcher.getInt(18) < 20)) {
    	            if (!entityhuman.abilities.canInstantlyBuild) {
    	              itemstack.count -= 1;
    	            }

    	            heal(itemfood.getNutrition());
    	            if (itemstack.count <= 0) {
    	              entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
    	            }

    	            return true;
    	          }
    	        } else if (itemstack.id == Item.INK_SACK.id) {
    	          int i = BlockCloth.e_(itemstack.getData());

    	          if (i != getCollarColor()) {
    	            setCollarColor(i);
    	            if (!entityhuman.abilities.canInstantlyBuild) if (itemstack.count-- <= 0) {
    	                entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
    	              }

    	            return true;
    	          }
    	        }
    	      }

    	      if ((entityhuman.name.equalsIgnoreCase(getOwnerName())) && (!this.world.isStatic) && (!c(itemstack))) {
    	        this.d.a(!isSitting());
    	        this.bG = false;
    	        setPathEntity((PathEntity)null);
    	      }
    	    } else if ((itemstack != null) && (itemstack.id == Item.BONE.id) && (!isAngry())) {
    	      if (!entityhuman.abilities.canInstantlyBuild) {
    	        itemstack.count -= 1;
    	      }

    	      if (itemstack.count <= 0) {
    	        entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
    	      }

    	      if (!this.world.isStatic)
    	      {
    	        if ((this.random.nextInt(3) == 0) && (!CraftEventFactory.callEntityTameEvent(this, entityhuman).isCancelled())) {
    	          setTamed(true);
    	          setPathEntity((PathEntity)null);
    	          b((EntityLiving)null);
    	          this.d.a(true);
    	          setHealth(20);
    	          setOwnerName(entityhuman.name);
    	          f(true);
    	          this.world.broadcastEntityEffect(this, (byte)7);
    	        } else {
    	          f(false);
    	          this.world.broadcastEntityEffect(this, (byte)6);
    	        }
    	      }

    	      return true;
    	    }

    	    return super.c(entityhuman);
    	  }
     public int getCollarColor()
     {
       return this.datawatcher.getByte(20) & 0xF;
     }
     public void setCollarColor(int i) {
    	    this.datawatcher.watch(20, Byte.valueOf((byte)(i & 0xF)));
    	  }

   

    /**
     * Checks if the parameter is an wheat item.
     */
    public boolean c(ItemStack itemstack) {
        return !(Item.byId[itemstack.id] instanceof ItemFood) ? false : itemstack == null ? false : ((ItemFood)Item.byId[itemstack.id]).i();
      }
    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry() {
        return (this.datawatcher.getByte(16) & 0x2) != 0;
      }
    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean flag) {
        byte b0 = this.datawatcher.getByte(16);

        if (flag)
          this.datawatcher.watch(16, Byte.valueOf((byte)(b0 | 0x2)));
        else
          this.datawatcher.watch(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFD)));
      }


    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityAnimal createChild(EntityAnimal entityanimal) {
        EntityHamtaro entitywolf = new  EntityHamtaro(this.world);

        entitywolf.setOwnerName(getOwnerName());
        entitywolf.setTamed(true);
        return entitywolf;
      }

    public boolean bI()
    {
      return this.datawatcher.getByte(19) == 1;
    }
    public void j(boolean flag) {
        byte b0 = this.datawatcher.getByte(19);

        if (flag)
          this.datawatcher.watch(19, Byte.valueOf((byte)1));
        else
          this.datawatcher.watch(19, Byte.valueOf((byte)0));
      }



    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean mate(EntityAnimal entityanimal)
    {
      if (entityanimal == this)
        return false;
      if (!isTamed())
        return false;
      if (!(entityanimal instanceof EntityHamtaro)) {
        return false;
      }
      EntityHamtaro entitywolf = (EntityHamtaro)entityanimal;

      return entitywolf.isTamed();
    }

    public boolean func_70922_bv()
    {
        return this.datawatcher.getByte(19) == 1;
    }

	
}
