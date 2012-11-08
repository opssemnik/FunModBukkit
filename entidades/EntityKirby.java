
       
        package FunMod.entidades;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.Chunk;
import net.minecraft.server.DamageSource;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MathHelper;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.World;
import net.minecraft.server.WorldType;

        public class EntityKirby extends EntityLiving  
        {
            public float field_70813_a;
            public float field_70811_b;
            public float field_70812_c;

            /** the time between each jump of the slime */
            private int slimeJumpDelay = 0;

            public EntityKirby(World par1World)
            {
                super(par1World);
                this.a(0.3F, 0.6F);
                texture = "/FunMod/cliente/texturas/Mobs/KirbyTexture.png"; 
                int var2 = 1 << this.random.nextInt(3);
                this.height = 0.0F;
                this.slimeJumpDelay = this.random.nextInt(20) + 10;
                this.setSize(var2);
            }

            protected void a() {
                super.a();
                this.datawatcher.a(16, new Byte((byte)1));
              }
            public void setSize(int par1)
            {
                this.datawatcher.watch(16, new Byte((byte)par1));
                this.a(0.6F * (float)par1, 0.6F * (float)par1);
                this.setPosition(this.locX, this.locY, this.locZ);
                this.setHealth(this.getMaxHealth());
                this.bc = par1;
            }

            public int getMaxHealth()
            {
                int var1 = this.getSize();
                return var1 * var1;
            }

            /**
             * Returns the size of the slime.
             */
            public int getSize()
            {
                return this.datawatcher.getByte(16);
            }

            /**
             * (abstract) Protected helper method to write subclass entity data to NBT.
             */
            public void b(NBTTagCompound par1NBTTagCompound)
            {
                super.b(par1NBTTagCompound);
                par1NBTTagCompound.setInt("Size", this.getSize() - 1);
            }

            /**
             * (abstract) Protected helper method to read subclass entity data from NBT.
             */
            public void a(NBTTagCompound par1NBTTagCompound)
            {
                super.a(par1NBTTagCompound);
                this.setSize(par1NBTTagCompound.getInt("Size") + 1);
            }

            /**
             * Returns the name of a particle effect that may be randomly created by EntitySlime.onUpdate()
             */
            protected String getSlimeParticle()
            {
                return "smoke";
            }

            /**
             * Returns the name of the sound played when the slime jumps.
             */
            protected String getJumpSound()
            {
                return "mob.villager.defaulthurt";
            }

            /**
             * Called to update the entity's position/logic.
             */
            public void j_()
            {
                if (!this.world.isStatic && this.world.difficulty == 0 && this.getSize() > 0)
                {
                    this.dead = true;
                }

                this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
                this.field_70812_c = this.field_70811_b;
                boolean var1 = this.onGround;
                super.j_();

                if (this.onGround && !var1)
                {
                    int var2 = this.getSize();

                    for (int var3 = 0; var3 < var2 * 8; ++var3)
                    {
                        float var4 = this.random.nextFloat() * (float)Math.PI * 2.0F;
                        float var5 = this.random.nextFloat() * 0.5F + 0.5F;
                        float var6 = MathHelper.sin(var4) * (float)var2 * 0.5F * var5;
                        float var7 = MathHelper.cos(var4) * (float)var2 * 0.5F * var5;
                        this.world.addParticle(this.getSlimeParticle(), this.locX + (double)var6, this.boundingBox.b, this.locZ + (double)var7, 0.0D, 0.0D, 0.0D);
                    }

                    if (o()) {
                        this.world.makeSound(this, n(), aV(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
                      }

                    this.field_70813_a = -0.5F;
                }
                else if (!this.onGround && var1)
                {
                    this.field_70813_a = 1.0F;
                }

                this.func_70808_l();
            }
            protected String n() {
                return "mob.slime." + (getSize() > 1 ? "big" : "small");
              }


            protected boolean o() {
                return getSize() > 2;
              }
            protected int j() {
                return this.random.nextInt(20) + 10;
              }
            protected void bk() {
                bh();
                EntityHuman entityhuman = this.world.findNearbyVulnerablePlayer(this, 16.0D);

                if (entityhuman != null) {
                  a(entityhuman, 10.0F, 20.0F);
                }

                if ((this.onGround) && (this.slimeJumpDelay-- <= 0)) {
                  this.slimeJumpDelay = j();
                  if (entityhuman != null) {
                    this.slimeJumpDelay /= 3;
                  }

                  this.bG = true;
                  if (q()) {
                    this.world.makeSound(this, n(), aV(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
                  }

                  this.bD = (1.0F - this.random.nextFloat() * 2.0F);
                  this.bE = 1 * getSize();
                } else {
                  this.bG = false;
                  if (this.onGround)
                    this.bD = (this.bE = 0.0F);
                }
              }
            protected boolean q() {
                return getSize() > 0;
              }
            protected void func_70808_l()
            {
                this.field_70813_a *= 0.6F;
            }

            /**
             * Gets the amount of time the slime needs to wait between jumps.
             */
            protected int getJumpDelay()
            {
                return this.random.nextInt(20) + 10;
            }

            protected EntityKirby createInstance()
            {
                return new EntityKirby(this.world);
            }

            /**
             * Will get destroyed next tick.
             */
            

         
            /**
             * Called by a player entity when they collide with an entity
             */
            public void b_(EntityHuman entityhuman) {
                if (l()) {
                  int i = getSize();

                  if ((m(entityhuman)) && (e(entityhuman) < 0.6D * i * 0.6D * i) && (entityhuman.damageEntity(DamageSource.mobAttack(this), m())))
                    this.world.makeSound(this, "mob.attack", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                }
              }
            protected boolean l()
            {
              return getSize() > 1;
            }
            protected int m() {
                return getSize();
              }

            /**
             * Indicates weather the slime is able to damage the player (based upon the slime's size)
             */
            protected boolean canDamagePlayer()
            {
                return this.getSize() > 1;
            }

            /**
             * Gets the amount of damage dealt to the player when "attacked" by the slime.
             */
            protected int getAttackStrength()
            {
                return this.getSize();
            }

            /**
             * Returns the sound this mob makes when it is hurt.
             */
            protected String getHurtSound()
            {
                return "mob.villager.defaulthurt";
            }

            
            protected String getDeathSound()
            {
                return "mob.villager.defaultdeath";
            }
            /**
             * Returns the item ID for the item the mob drops on death.
             */
         
            /**
             * Checks if the entity's current position is a valid location to spawn this entity.
             */
            public boolean canSpawn() {
                Chunk chunk = this.world.getChunkAtWorldCoords(MathHelper.floor(this.locX), MathHelper.floor(this.locZ));

                if (this.world.getWorldData().getType().handleSlimeSpawnReduction(this.random, this.world))
                {
                  return false;
                }
                if ((getSize() == 1) || (this.world.difficulty > 0)) {
                  if ((this.world.getBiome(MathHelper.floor(this.locX), MathHelper.floor(this.locZ)) == BiomeBase.SWAMPLAND) && (this.locY > 50.0D) && (this.locY < 70.0D) && (this.world.getLightLevel(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)) <= this.random.nextInt(8))) {
                    return super.canSpawn();
                  }

                  if ((this.random.nextInt(10) == 0) && (chunk.a(987234911L).nextInt(10) == 0) && (this.locY < 40.0D)) {
                    return super.canSpawn();
                  }
                }

                return false;
              }
            /**
             * Returns the volume for the sounds this mob makes.
             */
            protected float getSoundVolume()
            {
                return 0.4F * (float)this.getSize();
            }

            /**
             * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
             * use in wolves.
             */
            public int getVerticalFaceSpeed()
            {
                return 0;
            }

            /**
             * Returns true if the slime makes a sound when it jumps (based upon the slime's size)
             */
            protected boolean makesSoundOnJump()
            {
                return this.getSize() > 1;
            }

            /**
             * Returns true if the slime makes a sound when it lands after a jump (based upon the slime's size)
             */
            protected boolean makesSoundOnLand()
            {
                return this.getSize() > 2;
            }
        }
