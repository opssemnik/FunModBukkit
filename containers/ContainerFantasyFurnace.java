package FunMod.containers;

import java.util.Iterator;

import net.minecraft.server.Container;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ICrafting;
import net.minecraft.server.ItemStack;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.RecipesFurnace;
import net.minecraft.server.Slot;
import net.minecraft.server.SlotFurnaceResult;
import net.minecraft.server.TileEntityFurnace;

import org.bukkit.craftbukkit.inventory.CraftInventoryFurnace;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;

import FunMod.tileentidades.EntidadeFantasyFurnace;

public class ContainerFantasyFurnace extends Container
{
  private EntidadeFantasyFurnace furnace;
  private int f = 0;
  private int g = 0;
  private int h = 0;

  private CraftInventoryView bukkitEntity = null;
  private PlayerInventory player;

  public CraftInventoryView getBukkitView()
  {
    if (this.bukkitEntity != null) {
      return this.bukkitEntity;
    }
	return bukkitEntity;

  }

  public ContainerFantasyFurnace(PlayerInventory playerinventory, EntidadeFantasyFurnace tileEntity)
  {
    this.furnace = tileEntity;
    a(new Slot(tileEntity, 0, 56, 17));
    a(new Slot(tileEntity, 1, 56, 53));
    a(new SlotFurnaceResult(playerinventory.player, tileEntity, 2, 116, 35));
    this.player = playerinventory;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        a(new Slot(playerinventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }

    for (f = 0; f < 9; f++)
      a(new Slot(playerinventory, f, 8 + f * 18, 142));
  }

  public void addSlotListener(ICrafting icrafting)
  {
    super.addSlotListener(icrafting);
    icrafting.setContainerData(this, 0, this.furnace.cookTime);
    icrafting.setContainerData(this, 1, this.furnace.burnTime);
    icrafting.setContainerData(this, 2, this.furnace.ticksForCurrentFuel);
  }

  public void b() {
    super.b();
    Iterator iterator = this.listeners.iterator();

    while (iterator.hasNext()) {
      ICrafting icrafting = (ICrafting)iterator.next();

      if (this.f != this.furnace.cookTime) {
        icrafting.setContainerData(this, 0, this.furnace.cookTime);
      }

      if (this.g != this.furnace.burnTime) {
        icrafting.setContainerData(this, 1, this.furnace.burnTime);
      }

      if (this.h != this.furnace.ticksForCurrentFuel) {
        icrafting.setContainerData(this, 2, this.furnace.ticksForCurrentFuel);
      }
    }

    this.f = this.furnace.cookTime;
    this.g = this.furnace.burnTime;
    this.h = this.furnace.ticksForCurrentFuel;
  }

  public boolean c(EntityHuman entityhuman) {
    if (!this.checkReachable) return true;
    return this.furnace.a(entityhuman);
  }

  public ItemStack b(EntityHuman entityhuman, int i) {
    ItemStack itemstack = null;
    Slot slot = (Slot)this.b.get(i);

    if ((slot != null) && (slot.d())) {
      ItemStack itemstack1 = slot.getItem();

      itemstack = itemstack1.cloneItemStack();
      if (i == 2) {
        if (!a(itemstack1, 3, 39, true)) {
          return null;
        }

        slot.a(itemstack1, itemstack);
      } else if ((i != 1) && (i != 0)) {
        if (RecipesFurnace.getInstance().getSmeltingResult(itemstack1) != null) {
          if (!a(itemstack1, 0, 1, false))
            return null;
        }
        else if (TileEntityFurnace.isFuel(itemstack1)) {
          if (!a(itemstack1, 1, 2, false))
            return null;
        }
        else if ((i >= 3) && (i < 30)) {
          if (!a(itemstack1, 30, 39, false))
            return null;
        }
        else if ((i >= 30) && (i < 39) && (!a(itemstack1, 3, 30, false)))
          return null;
      }
      else if (!a(itemstack1, 3, 39, false)) {
        return null;
      }

      if (itemstack1.count == 0)
        slot.set(null);
      else {
        slot.e();
      }

      if (itemstack1.count == itemstack.count) {
        return null;
      }

      slot.a(entityhuman, itemstack1);
    }

    return itemstack;
  }
}