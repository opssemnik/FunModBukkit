
package FunMod.items;

import java.util.Random;

import net.minecraft.server.EnumToolMaterial;
import net.minecraft.server.ItemSword;
import net.minecraft.server.World;
public class LinkSword extends ItemSword
{
	
    
    		
	
  public LinkSword(int id, EnumToolMaterial toolMaterial)
   {
    super(id, toolMaterial);
    this.textureId = 9;
   }
    public String getTextureFile() {
	
	return "/FunMod/cliente/texturas/texturas.png";
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
    
} 