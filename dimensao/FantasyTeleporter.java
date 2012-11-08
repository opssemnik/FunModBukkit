package FunMod.dimensao;

import java.util.Random;

import net.minecraft.server.Entity;
import net.minecraft.server.MathHelper;
import net.minecraft.server.World;

import org.bukkit.Location;

import FunMod.FunMod;
public class FantasyTeleporter extends Location
{

	





public FantasyTeleporter(org.bukkit.World world, double x, double y,
			double z) {
		super(world, x, y, z);
		// TODO Auto-generated constructor stub
	}

private Random random;




public void placeInPortal(World world, Entity entity)
{




createPortal(world, entity);

return;
}









public boolean createPortal(World world, Entity entity)
{


return true;
}
}
