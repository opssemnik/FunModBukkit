package FunMod.blocks;
import net.minecraft.server.Block;
import net.minecraft.server.Material;

public class BlockBrickBlock extends Block
{

                public BlockBrickBlock(int i, int j, int k)
                {
                        super(i, j, Material.STONE);
                        this.textureId = 0;
                }
public String getTextureFile(){
		return "/FunMod/cliente/texturas/texturas.png";}		
  
    }               