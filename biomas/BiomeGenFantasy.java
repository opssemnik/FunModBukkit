package FunMod.biomas;

import java.util.Random;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldGenTrees;
import net.minecraft.server.WorldGenerator;
import FunMod.FunMod;
import FunMod.dimensao.WorldGenFantasy;

public class BiomeGenFantasy extends BiomeBase
{
    protected WorldGenerator bushGen;
	protected WorldGenerator sandGen;
    protected WorldGenerator hematiteGen;
    protected WorldGenerator meteoriteGen;
    protected WorldGenerator cobaltGen;
    protected WorldGenerator blazestoneGen;
   
    public BiomeGenFantasy(int par1)
    {

        super(par1);
      
        
        
        
        // this.spawnableCreatureList.add(new SpawnListEntry(net.minecraft.server.EntityAshCreeper.class, 2, 3, 3));
       //this.bushGen = new WorldGenForbiddenBush();

       // this.sandGen = new WorldGenForbiddenSand(7, mod_ForbiddenForest.ForbiddenSand.id);

       // this.spawnableWaterCreatureList.clear();
  
        A = (byte)FunMod.FantasyGrass.id;
        B = (byte)FunMod.FantasyDIRT.id;
       //biomeDecorator = new BiomeDecoratorForbidden(this);

        
       /* 
        this.blazestoneGen = new WorldGenForbidden2(mod_ForbiddenForest.FirestoneOre.id, 8);
        this.hematiteGen = new WorldGenForbidden2(mod_ForbiddenForest.HematiteOre.id, 8);
        this.meteoriteGen = new WorldGenForbidden2(mod_ForbiddenForest.MeteoriteOre.id, 7);
        this.cobaltGen = new WorldGenForbidden2(mod_ForbiddenForest.CobaltOre.id, 7);
        
       */ 
    }

    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.P : (par1Random.nextInt(3) == 0 ? new WorldGenFantasy(false) : new WorldGenTrees(false, 4 + par1Random.nextInt(7), 3, 3, true)));
    }
    
    
    
    
}
