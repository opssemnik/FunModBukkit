package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemBattery extends Item
	{
	        public ItemBattery(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 7;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}