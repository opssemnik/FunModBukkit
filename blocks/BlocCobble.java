package FunMod.blocks;

import FunMod.FunMod;
import net.minecraft.server.Block;
import net.minecraft.server.Material;

public class BlocCobble extends Block
{
        public BlocCobble(int i, int j)
        {
                super(i, j , Material.STONE);
                this.textureId = 44;
                this.a(FunMod.funmodtab);
        }

        
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}
}