
	package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemObsidianStick extends Item
	{
	        public ItemObsidianStick(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 19;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}