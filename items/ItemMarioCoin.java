
	package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemMarioCoin extends Item
	{
	        public ItemMarioCoin(int i)
	        {
	                super(i);
	                maxStackSize = 16;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 6;
	        }
public String getTextureFile(){
				
				return "/FunMod/cliente/texturas/texturas.png";
			}
	}