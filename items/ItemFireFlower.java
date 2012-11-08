package FunMod.items;

import java.util.Map;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemInWorldManager;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import FunMod.FunMod;
import FunMod.entidades.EntityThrowing;
 public class ItemFireFlower extends ItemThrowing
 {
	 public int ck;
         public ItemFireFlower(int i)
         {
                 super(i);
                 maxStackSize = 1;     
                 this.a(FunMod.funmodtab);
                 this.ck = 20;
                 this.textureId = 5;
         }
        public String getTextureFile(){
			
			return "/FunMod/cliente/texturas/texturas.png";
		}
        public int a(Entity var1)
        {
            return this.ck;
        }

       
		public ItemStack a(ItemStack par1ItemStack, World par2World, EntityHuman par3EntityPlayer)
         {
            
             par2World.makeSound(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (d.nextFloat() * 0.4F + 0.8F));

             if (!par2World.isStatic)
             {
                 par2World.addEntity(new EntityThrowing(par2World, par3EntityPlayer));
             }
              
             par1ItemStack.damage(1, par3EntityPlayer);
             
             return par1ItemStack;
         }
         
      
         
     }