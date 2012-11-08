package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class Itemnes extends Item
	{
	        public Itemnes(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 36;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}