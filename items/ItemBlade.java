
	package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemBlade extends Item
	{
	        public ItemBlade(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 20;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}