package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemPearl extends Item
	{
	        public ItemPearl(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 10;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}