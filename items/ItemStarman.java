
	package FunMod.items;

import net.minecraft.server.Item;
import FunMod.FunMod;
	public class ItemStarman extends Item
	{
	        public ItemStarman(int i)
	        {
	                super(i);
	                maxStackSize = 1;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 8;
	        }
public String getTextureFile(){
			
				return "/FunMod/cliente/texturas/texturas.png";
			}
	}