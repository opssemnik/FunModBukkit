package FunMod.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.Block;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class FantasyFurnacesRecipes
{
    private static final FantasyFurnacesRecipes smeltingBase = new FantasyFurnacesRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FantasyFurnacesRecipes smelting()
    {
        return smeltingBase;
    }

    private FantasyFurnacesRecipes()
    {
        this.addSmelting(Block.IRON_ORE.id, new ItemStack(Item.IRON_INGOT), 1.1F);
        this.addSmelting(Block.GOLD_ORE.id, new ItemStack(Item.GOLD_INGOT), 1.4F);
        this.addSmelting(Block.DIAMOND_ORE.id, new ItemStack(Item.DIAMOND), 0.1F);
        this.addSmelting(Block.SAND.id, new ItemStack(Block.GLASS), 0.5F);
        this.addSmelting(Item.PORK.id, new ItemStack(Item.GRILLED_PORK), 0.7F);
        this.addSmelting(Item.RAW_BEEF.id, new ItemStack(Item.COOKED_BEEF), 0.7F);
        this.addSmelting(Item.RAW_CHICKEN.id, new ItemStack(Item.COOKED_CHICKEN), 0.4F);
        this.addSmelting(Item.RAW_FISH.id, new ItemStack(Item.COOKED_FISH), 0.8F);
        this.addSmelting(Block.COBBLESTONE.id, new ItemStack(Block.STONE), 0.3F);
        this.addSmelting(Item.CLAY_BALL.id, new ItemStack(Item.CLAY_BRICK), 0.5F);
        this.addSmelting(Block.CACTUS.id, new ItemStack(Item.DIODE, 1, 2), 0.4F);
        this.addSmelting(Block.WOOD.id, new ItemStack(Item.COAL, 1, 1), 0.0F);
        this.addSmelting(Block.EMERALD_ORE.id, new ItemStack(Item.EMERALD), 1.4F);
        this.addSmelting(Block.COAL_ORE.id, new ItemStack(Item.COAL), 0.0F);
        this.addSmelting(Block.REDSTONE_ORE.id, new ItemStack(Item.REDSTONE), 1.1F);
        this.addSmelting(Block.LAPIS_ORE.id, new ItemStack(Item.DIODE, 1, 4), 0.2F);
           
    
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.id), Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_77601_c(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * Add a metadata-sensitive furnace recipe
     * @param id The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addSmelting(int id, int metadata, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(id, metadata), itemstack);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.id, item.getData()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.id));
    }
}
