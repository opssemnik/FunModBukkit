package FunMod.blocks;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import FunMod.FunMod;
public class FantasyDirt extends Block
{
    public FantasyDirt(int par1, int par2)
    {
        super(par1, par2, Material.EARTH);
        this.textureId = 28;
        this.a(FunMod.funmodtab);
    }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
}


