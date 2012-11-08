package FunMod.entidades;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityProjectile;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.World;

public class EntityThrowing extends EntityProjectile
{
public EntityThrowing( World par1World )
{
super( par1World );
this.getTexture();
}
public EntityThrowing( World par1World, EntityLiving par2EntityLiving )
{
super( par1World, par2EntityLiving );
// TODO Auto-generated constructor stub
}
public EntityThrowing( World par1World, double par2, double par4,
double par6 )
{
super( par1World, par2, par4, par6 );
// TODO Auto-generated constructor stub
}

  public String getTexture(){
   return "/FunMod/cliente/texturas/texturas.png";}
@Override
protected void a(MovingObjectPosition arg0) {
	if (!this.world.isStatic)
    {


        this.world.createExplosion((Entity)null, this.locX, this.locY, this.locZ, 1.0F, true, inGround);
        
    }
}

    
}