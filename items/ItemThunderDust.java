
	package FunMod.items;
	import net.minecraft.server.Item;
import FunMod.FunMod;

	public class ItemThunderDust extends Item
	{
	        public ItemThunderDust(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.a(FunMod.funmodtab);
	                this.textureId = 17;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}