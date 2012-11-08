package FunMod.items;

import net.minecraft.server.ItemFood;
import net.minecraft.server.ItemStack;
import FunMod.FunMod;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
	public class ItemSuperCog extends ItemFood
	{
	        public ItemSuperCog(int i, int j, boolean b)
	        {
	                super(i, i, b);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 4;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
		
		
	
	
	
	}
	