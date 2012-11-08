package FunMod.items;

import net.minecraft.server.EntityArrow;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemBow;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import FunMod.FunMod;
import FunMod.entidades.EntityThrowing;
public class ItemThrowing extends ItemBow
{

public ItemThrowing( int par1 )
{
super( par1 );
this.textureId = 16;
this.a(FunMod.funmodtab);
}
/**
* Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
*/
public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
	int var5 = this.a(par1ItemStack);
	float var8 = (float)var5 / 20.0F;
	var8 = (var8 * var8 + var8 * 2.0F) / 3.0F;
	EntityArrow var9 = new EntityArrow(par2World, par3EntityPlayer, var8 * 2.0F);
	par2World.addEntity(var9);

return par1ItemStack;
}
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}


}