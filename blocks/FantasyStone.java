package FunMod.blocks;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import FunMod.FunMod;
public class FantasyStone extends Block
{
    public FantasyStone(int par1, int par2)
    {
        super(par1, par2, Material.STONE);
        this.textureId = 32;
        this.a(FunMod.funmodtab);
    }
 public String getTextureFile(){
	 return "/FunMod/cliente/texturas/texturas.png";
 }
 @Override
 public int getDropType(int par1, Random par2Random, int par3)
 {
     return FunMod.cobble.getDropType(0, par2Random, par3);
 }
}