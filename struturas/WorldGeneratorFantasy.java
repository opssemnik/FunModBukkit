package FunMod.struturas;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.World;
import FunMod.dimensao.WorldGenMinableFantasy;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorFantasy implements IWorldGenerator 
{
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{
switch (world.worldProvider.dimension)
{
case -1: generateNether(world, random, chunkX*16, chunkZ*16);
case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
case 10: generateFantasy(world, random, chunkX*16, chunkZ*16);

}
}

private void generateFantasy(World world, Random random, int blockX, int blockZ) {
	int Xcoord = blockX + random.nextInt(16);
	int Ycoord = random.nextInt(60);
	int Zcoord = blockZ + random.nextInt(16);
	(new WorldGenMinableFantasy(Block.COAL_ORE.id, 19)).a(world, random, Xcoord, Ycoord, Zcoord);	
	int Xcoord2 = blockX + random.nextInt(16);
	int Ycoord2 = random.nextInt(40);
	int Zcoord2 = blockZ + random.nextInt(16);
	(new WorldGenMinableFantasy(Block.IRON_ORE.id, 10)).a(world, random, Xcoord2, Ycoord2, Zcoord2);	
	int Xcoord3 = blockX + random.nextInt(16);
	int Ycoord3 = random.nextInt(40);
	int Zcoord3 = blockZ + random.nextInt(16);
	(new WorldGenMinableFantasy(Block.GOLD_ORE.id, 5)).a(world, random, Xcoord3, Ycoord3, Zcoord3);	
	int Xcoord4 = blockX + random.nextInt(16);
	int Ycoord4 = random.nextInt(14);
	int Zcoord4 = blockZ + random.nextInt(16);
	(new WorldGenMinableFantasy(Block.DIAMOND_ORE.id, 3)).a(world, random, Xcoord4, Ycoord4, Zcoord4);	
}



private void generateSurface(World world, Random rand, int x, int z)
{
if (world == null || rand == null){
return;
}
if (rand.nextInt(1000) < 100){
for (int i = 0; i < 15; ++i){
int RandPosX = x + rand.nextInt(16);
int RandPosY = rand.nextInt(150);
int RandPosZ = z + rand.nextInt(16);
if (new WorldGenCasaDoPokemon().a(world, rand, RandPosX, RandPosY, RandPosZ)){
{
break; }
}
}
}
if (world == null || rand == null){
return;
}
if (rand.nextInt(1000) < 150){
for (int i = 0; i < 15; ++i){
int RandPosX2 = x + rand.nextInt(16);
int RandPosY2 = rand.nextInt(150);
int RandPosZ2 = z + rand.nextInt(16);
if (new WorldGenLabirinto().a(world, rand, RandPosX2, RandPosY2, RandPosZ2)){
{
break; }
}
}
}
}
private void generateNether(World world, Random random, int blockX, int blockZ) 
{

}
}