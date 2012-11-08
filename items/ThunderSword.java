
package FunMod.items;

import java.util.Random;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLightning;
import net.minecraft.server.EnumMovingObjectType;
import net.minecraft.server.EnumToolMaterial;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ItemSword;
import net.minecraft.server.MathHelper;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.World;
public class ThunderSword extends ItemSword
{
	
   
    		
	
    public ThunderSword(int i, EnumToolMaterial toolmaterial)
    {
        super(i, toolmaterial);
        this.textureId = 18;
    }
    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        int l = world.getData(i, j, k);
        double d = (float)i + 0.5F;
        double d1 = (float)j + 0.7F;
        double d2 = (float)k + 0.5F;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        if (l == 1)
        {
            world.addParticle("smoke", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.addParticle("flame", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 2)
        {
            world.addParticle("smoke", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.addParticle("flame", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 3)
        {
            world.addParticle("smoke", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.addParticle("flame", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 4)
        {
            world.addParticle("smoke", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.addParticle("flame", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
        else
        {
            world.addParticle("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            world.addParticle("flame", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
   
 
    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityplayer)
    {
        float f = 1.0F;
        float f1 = entityplayer.pitch + (entityplayer.pitch - entityplayer.pitch) * f;
        float f2 = entityplayer.yaw + (entityplayer.yaw - entityplayer.yaw) * f;
        double d = entityplayer.bY + (entityplayer.locX - entityplayer.bY) * (double)f;
        double d1 = (entityplayer.bZ+ (entityplayer.locY - entityplayer.bZ) * (double)f + 1.6200000000000001D) - (double)entityplayer.height;
        double d2 = entityplayer.bX + (entityplayer.locZ - entityplayer.bX) * (double)f;
        Vec3D vec3d = Vec3D.a(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5000D;
        Vec3D vec3d1 = vec3d.add((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        MovingObjectPosition movingobjectlocition = world.rayTrace(vec3d, vec3d1, false, true);
        if (movingobjectlocition == null) 
        {
         return itemstack;
        }
        if (movingobjectlocition.type == EnumMovingObjectType.TILE) 
        {
         int i = movingobjectlocition.b;
            int j = movingobjectlocition.c;
            int k = movingobjectlocition.d;
            world.addEntity(new EntityLightning(world, i, j, k));
        }
        itemstack.damage(10, entityplayer);
        return itemstack;
    }
    public String getTextureFile(){
     return "/FunMod/cliente/texturas/texturas.png";}
   
    } 