package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ThunderBlade extends Item
	{
	        public ThunderBlade(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 11;
	        }
	public String getTextureFile(){
	  return "/FunMod/cliente/texturas/texturas.png";}      
	}