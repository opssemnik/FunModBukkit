package FunMod.tileentidades;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.Block;
import net.minecraft.server.BlockFurnace;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.IInventory;
import net.minecraft.server.Item;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.ItemHoe;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ItemSword;
import net.minecraft.server.ItemTool;
import net.minecraft.server.Material;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.RecipesFurnace;
import net.minecraft.server.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

import cpw.mods.fml.common.registry.GameRegistry;

public class EntidadeFantasyFurnace extends TileEntity
  implements IInventory, ISidedInventory
{
  private ItemStack[] items = new ItemStack[3];
  public int burnTime = 0;
  public int ticksForCurrentFuel = 0;
  public int cookTime = 0;

  private int lastTick = (int)(System.currentTimeMillis() / 50L);
  private int maxStack = 64;
  public List<HumanEntity> transaction = new ArrayList();

  public ItemStack[] getContents() {
    return this.items;
  }

  public void onOpen(CraftHumanEntity who) {
    this.transaction.add(who);
  }

  public void onClose(CraftHumanEntity who) {
    this.transaction.remove(who);
  }

  public List<HumanEntity> getViewers() {
    return this.transaction;
  }

  public void setMaxStackSize(int size) {
    this.maxStack = size;
  }

  public int getSize()
  {
    return this.items.length;
  }

  public ItemStack getItem(int i) {
    return this.items[i];
  }

  public ItemStack splitStack(int i, int j) {
    if (this.items[i] != null)
    {
      if (this.items[i].count <= j) {
        ItemStack itemstack = this.items[i];
        this.items[i] = null;
        return itemstack;
      }
      ItemStack itemstack = this.items[i].a(j);
      if (this.items[i].count == 0) {
        this.items[i] = null;
      }

      return itemstack;
    }

    return null;
  }

  public ItemStack splitWithoutUpdate(int i)
  {
    if (this.items[i] != null) {
      ItemStack itemstack = this.items[i];

      this.items[i] = null;
      return itemstack;
    }
    return null;
  }

  public void setItem(int i, ItemStack itemstack)
  {
    this.items[i] = itemstack;
    if ((itemstack != null) && (itemstack.count > getMaxStackSize()))
      itemstack.count = getMaxStackSize();
  }

  public String getName()
  {
    return "container.furnace";
  }

  public void a(NBTTagCompound nbttagcompound) {
    super.a(nbttagcompound);
    NBTTagList nbttaglist = nbttagcompound.getList("Items");

    this.items = new ItemStack[getSize()];

    for (int i = 0; i < nbttaglist.size(); i++) {
      NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.get(i);
      byte b0 = nbttagcompound1.getByte("Slot");

      if ((b0 >= 0) && (b0 < this.items.length)) {
        this.items[b0] = ItemStack.a(nbttagcompound1);
      }
    }

    this.burnTime = nbttagcompound.getShort("BurnTime");
    this.cookTime = nbttagcompound.getShort("CookTime");
    this.ticksForCurrentFuel = fuelTime(this.items[1]);
  }

  public void b(NBTTagCompound nbttagcompound) {
    super.b(nbttagcompound);
    nbttagcompound.setShort("BurnTime", (short)this.burnTime);
    nbttagcompound.setShort("CookTime", (short)this.cookTime);
    NBTTagList nbttaglist = new NBTTagList();

    for (int i = 0; i < this.items.length; i++) {
      if (this.items[i] != null) {
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();

        nbttagcompound1.setByte("Slot", (byte)i);
        this.items[i].save(nbttagcompound1);
        nbttaglist.add(nbttagcompound1);
      }
    }

    nbttagcompound.set("Items", nbttaglist);
  }

  public int getMaxStackSize() {
    return this.maxStack;
  }

  public boolean isBurning() {
    return this.burnTime > 0;
  }

  public void g() {
    boolean flag = this.burnTime > 0;
    boolean flag1 = false;

    int currentTick = (int)(System.currentTimeMillis() / 50L);
    int elapsedTicks = currentTick - this.lastTick;
    this.lastTick = currentTick;

    if ((isBurning()) && (canBurn())) {
      this.cookTime += elapsedTicks;
      if (this.cookTime >= 200) {
        this.cookTime %= 200;
        burn();
        flag1 = true;
      }
    } else {
      this.cookTime = 0;
    }

    if (this.burnTime > 0) {
      this.burnTime -= elapsedTicks;
    }

    if (!this.world.isStatic)
    {
      if ((this.burnTime <= 0) && (canBurn()) && (this.items[1] != null)) {
        CraftItemStack fuel = new CraftItemStack(this.items[1]);

        FurnaceBurnEvent furnaceBurnEvent = new FurnaceBurnEvent(this.world.getWorld().getBlockAt(this.x, this.y, this.z), fuel, fuelTime(this.items[1]));
        this.world.getServer().getPluginManager().callEvent(furnaceBurnEvent);

        if (furnaceBurnEvent.isCancelled()) {
          return;
        }

        this.ticksForCurrentFuel = furnaceBurnEvent.getBurnTime();
        this.burnTime += this.ticksForCurrentFuel;
        if ((this.burnTime > 0) && (furnaceBurnEvent.isBurning()))
        {
          flag1 = true;
          if (this.items[1] != null) {
            this.items[1].count -= 1;
            if (this.items[1].count == 0) {
              this.items[1] = this.items[1].getItem().getContainerItemStack(this.items[1]);
            }

          }

        }

      }

      if (flag != this.burnTime > 0) {
        flag1 = true;
        BlockFurnace.a(this.burnTime > 0, this.world, this.x, this.y, this.z);
      }
    }

    if (flag1)
      update();
  }

  private boolean canBurn()
  {
    if (this.items[0] == null) {
      return false;
    }
    ItemStack var1 = RecipesFurnace.getInstance().getSmeltingResult(this.items[0]);

    if (var1 == null)
    {
      return false;
    }
    if (this.items[2] == null)
    {
      return true;
    }
    if (!this.items[2].doMaterialsMatch(var1))
    {
      return false;
    }

    int var2 = this.items[2].count + var1.count;
    return (var2 <= getMaxStackSize()) && (var2 <= var1.getMaxStackSize());
  }

  public void burn()
  {
    if (canBurn()) {
      ItemStack itemstack = RecipesFurnace.getInstance().getSmeltingResult(this.items[0]);

      CraftItemStack source = new CraftItemStack(this.items[0]);
      CraftItemStack result = new CraftItemStack(itemstack.cloneItemStack());

      FurnaceSmeltEvent furnaceSmeltEvent = new FurnaceSmeltEvent(this.world.getWorld().getBlockAt(this.x, this.y, this.z), source, result);
      this.world.getServer().getPluginManager().callEvent(furnaceSmeltEvent);

      if (furnaceSmeltEvent.isCancelled()) {
        return;
      }

      itemstack = CraftItemStack.createNMSItemStack(furnaceSmeltEvent.getResult());

      if (this.items[2] == null)
        this.items[2] = itemstack.cloneItemStack();
      else if (this.items[2].doMaterialsMatch(itemstack)) {
        this.items[2].count += itemstack.count;
      }

      this.items[0].count -= 1;
      if (this.items[0].count <= 0)
        this.items[0] = null;
    }
  }

  public static int fuelTime(ItemStack itemstack)
  {
    if (itemstack == null) {
      return 0;
    }
    int i = itemstack.getItem().id;
    Item item = itemstack.getItem();

    if (((itemstack.getItem() instanceof ItemBlock)) && (Block.byId[i] != null)) {
      Block block = Block.byId[i];

      if (block == Block.WOOD_STEP) {
        return 150;
      }

      if (block.material == Material.WOOD) {
        return 300;
      }
    }

    return i == Item.BLAZE_ROD.id ? 2400 : i == Block.SAPLING.id ? 100 : i == Item.LAVA_BUCKET.id ? 20000 : i == Item.COAL.id ? 1600 : i == Item.STICK.id ? 100 : ((item instanceof ItemHoe)) && (((ItemHoe)item).g().equals("WOOD")) ? 200 : ((item instanceof ItemSword)) && (((ItemSword)item).h().equals("WOOD")) ? 200 : ((item instanceof ItemTool)) && (((ItemTool)item).g().equals("WOOD")) ? 200 : GameRegistry.getFuelValue(itemstack);
  }

  public static boolean isFuel(ItemStack itemstack)
  {
    return fuelTime(itemstack) > 0;
  }

  public boolean a(EntityHuman entityhuman) {
    return this.world.getTileEntity(this.x, this.y, this.z) == this;
  }
  public void startOpen() {
  }

  public void f() {
  }

  public int getStartInventorySide(ForgeDirection var1) {
    return var1 == ForgeDirection.UP ? 0 : var1 == ForgeDirection.DOWN ? 1 : 2;
  }

  public int getSizeInventorySide(ForgeDirection var1)
  {
    return 1;
  }
}