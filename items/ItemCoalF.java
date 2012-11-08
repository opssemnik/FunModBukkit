package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemCoalF extends Item
	{
	        public ItemCoalF(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 46;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}