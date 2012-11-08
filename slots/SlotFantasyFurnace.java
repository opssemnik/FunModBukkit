package FunMod.slots;

import net.minecraft.server.EntityExperienceOrb;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.IInventory;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Slot;
import FunMod.recipes.FantasyFurnacesRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotFantasyFurnace extends Slot
{
    /** The player that is using the GUI where this slot resides. */
    private EntityHuman thePlayer;
    private int field_75228_b;

    public SlotFantasyFurnace(EntityHuman par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5)
    {
        super(par2IInventory, par3, par4, par5);
        this.thePlayer = par1EntityPlayer;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isAllowed(ItemStack par1ItemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        if (d())
        {
            this.field_75228_b += Math.min(par1, getItem().count);
        }

        return super.a(par1);
    }

    /**
     * Called when the player picks up an item from an inventory slot
     */
    public void a(EntityHuman var1, ItemStack var2)
    {
      b(var2);
      super.a(var1, var2);
    }
    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void b(ItemStack var1, int var2)
    {
      this.field_75228_b += var2;
      b(var1);
    }
    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack par1ItemStack)
    {
        par1ItemStack.b(this.thePlayer.world, this.thePlayer, this.field_75228_b);

        if (!this.thePlayer.world.isStatic)
        {
            int var2 = this.field_75228_b;
            float var3 = FantasyFurnacesRecipes.smelting().func_77601_c(par1ItemStack.id);
            int var4;

            if (var3 == 0.0F)
            {
                var2 = 0;
            }
            else if (var3 < 1.0F)
            {
                var4 = MathHelper.d((float)var2 * var3);

                if (var4 < MathHelper.f((float)var2 * var3) && (float)Math.random() < (float)var2 * var3 - (float)var4)
                {
                    ++var4;
                }

                var2 = var4;
            }

            while (var2 > 0)
            {
                var4 = EntityExperienceOrb.getOrbValue(var2);
                var2 -= var4;
                this.thePlayer.world.addEntity(new EntityExperienceOrb(this.thePlayer.world, this.thePlayer.locX, this.thePlayer.locY + 0.5D, this.thePlayer.locZ + 0.5D, var4));
            }
        }


        this.field_75228_b = 0;

        GameRegistry.onItemSmelted(thePlayer, par1ItemStack);
    }
}