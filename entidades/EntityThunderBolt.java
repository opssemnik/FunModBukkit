package FunMod.entidades;

import java.util.Iterator;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityWeather;
import net.minecraft.server.MathHelper;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.World;

import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.event.block.BlockIgniteEvent;

public class EntityThunderBolt extends EntityWeather
{
  private int lifeTicks;
  public long a = 0L;
  private int c;
  private CraftWorld cworld;
  public boolean isEffect = false;

  public EntityThunderBolt(World world, double d0, double d1, double d2) {
    this(world, d0, d1, d2, false);
  }

  public EntityThunderBolt(World world, double d0, double d1, double d2, boolean isEffect)
  {
    super(world);

    this.isEffect = isEffect;
    this.cworld = world.getWorld();

    setPositionRotation(d0, d1, d2, 0.0F, 0.0F);
    this.lifeTicks = 2;
    this.a = this.random.nextLong();
    this.c = (this.random.nextInt(3) + 1);

    if ((!isEffect) && (world.difficulty >= 2) && (world.areChunksLoaded(MathHelper.floor(d0), MathHelper.floor(d1), MathHelper.floor(d2), 10))) {
      int i = MathHelper.floor(d0);
      int j = MathHelper.floor(d1);
      int k = MathHelper.floor(d2);

      if ((world.getTypeId(i, j, k) == 0) && (Block.FIRE.canPlace(world, i, j, k)))
      {
        BlockIgniteEvent event = new BlockIgniteEvent(this.cworld.getBlockAt(i, j, k), BlockIgniteEvent.IgniteCause.LIGHTNING, null);
        world.getServer().getPluginManager().callEvent(event);

        if (!event.isCancelled()) {
          world.setTypeId(i, j, k, Block.FIRE.id);
        }

      }

      for (i = 0; i < 4; i++) {
        j = MathHelper.floor(d0) + this.random.nextInt(3) - 1;
        k = MathHelper.floor(d1) + this.random.nextInt(3) - 1;
        int l = MathHelper.floor(d2) + this.random.nextInt(3) - 1;

        if ((world.getTypeId(j, k, l) == 0) && (Block.FIRE.canPlace(world, j, k, l)))
        {
          BlockIgniteEvent event = new BlockIgniteEvent(this.cworld.getBlockAt(j, k, l), BlockIgniteEvent.IgniteCause.LIGHTNING, null);
          world.getServer().getPluginManager().callEvent(event);

          if (!event.isCancelled())
            world.setTypeId(j, k, l, Block.FIRE.id);
        }
      }
    }
  }

  public void j_()
  {
    super.j_();
    if (this.lifeTicks == 2) {
      this.world.makeSound(this.locX, this.locY, this.locZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.random.nextFloat() * 0.2F);
      this.world.makeSound(this.locX, this.locY, this.locZ, "random.explode", 2.0F, 0.5F + this.random.nextFloat() * 0.2F);
    }

    this.lifeTicks -= 1;
    if (this.lifeTicks < 0) {
      if (this.c == 0) {
        die();
      } else if (this.lifeTicks < -this.random.nextInt(10)) {
        this.c -= 1;
        this.lifeTicks = 1;
        this.a = this.random.nextLong();

        if ((!this.isEffect) && (this.world.areChunksLoaded(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ), 10))) {
          int i = MathHelper.floor(this.locX);
          int j = MathHelper.floor(this.locY);
          int k = MathHelper.floor(this.locZ);

          if ((this.world.getTypeId(i, j, k) == 0) && (Block.FIRE.canPlace(this.world, i, j, k)))
          {
            BlockIgniteEvent event = new BlockIgniteEvent(this.cworld.getBlockAt(i, j, k), BlockIgniteEvent.IgniteCause.LIGHTNING, null);
            this.world.getServer().getPluginManager().callEvent(event);

            if (!event.isCancelled()) {
              this.world.setTypeId(i, j, k, Block.FIRE.id);
            }
          }
        }
      }

    }

    

      this.world.r = 2;
    }
  

  protected void a()
  {
  }

  protected void a(NBTTagCompound nbttagcompound)
  {
  }

  protected void b(NBTTagCompound nbttagcompound)
  {
  }
}