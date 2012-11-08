package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemTvCima extends Item
	{
	        public ItemTvCima(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 34;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}