package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class Itemmesa extends Item
	{
	        public Itemmesa(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 37;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}