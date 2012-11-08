package FunMod.blocks;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import FunMod.FunMod;
public class MysticalStone extends Block
{

                public MysticalStone(int i, int j, int k)
                {
                        super(i, j, Material.STONE);
                        this.textureId = 42;
                        this.a(FunMod.funmodtab);
                }
public String getTextureFile(){
		return "/FunMod/cliente/texturas/texturas.png";}		
  
    }               