package FunMod.items;

import net.minecraft.server.Enchantment;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityArrow;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemBow;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import FunMod.FunMod;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
public class ItemLinkBow extends ItemBow
{
	public int ck;
	public ItemLinkBow(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        ck = 499;
        this.a(FunMod.funmodtab);
        this.textureId = 12;
    }
	 public int a(Entity var1)
     {
         return this.ck;
     }
    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
   

    

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
   
    

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
   
    

    
   

public String getTextureFile(){
return "/FunMod/cliente/texturas/texturas.png";}

}
