package FunMod.items;

import net.minecraft.server.Item;
	public class ItemControle extends Item
	{
	        public ItemControle(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                
	                this.textureId = 35;
	        
	        }
     public String getTextureFile(){
    	 return "/FunMod/cliente/texturas/texturas.png";
     }
	
	}