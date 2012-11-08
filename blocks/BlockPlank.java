package FunMod.blocks;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import FunMod.FunMod;

public class BlockPlank extends Block
{
        public BlockPlank(int i, int j)
        {
                super(i, j , Material.WOOD);
                this.textureId = 43;
                this.a(FunMod.funmodtab);
        }

        
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}
}