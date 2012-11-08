package FunMod.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Packet3Chat;
import FunMod.FunMod;
import FunMod.enums.EnumColor;
import cpw.mods.fml.server.FMLServerHandler;



public class FunModHooks
{
	
	public static void checkForUpdates(EntityPlayer entityplayer)
	{
		if(!(FunMod.latestbersionNumber.equals("Error retrieving data.")) && !(FunMod.latestbersionNumber.equals(FunMod.bersionNumber.toString())))
		{
			entityplayer.sendMessage(EnumColor.GREY.code + "Your version of " + EnumColor.DARK_BLUE.code + "FunMod " + EnumColor.GREY.code + "(" + EnumColor.DARK_GREY.code + FunMod.bersionNumber.toString() + EnumColor.GREY.code + ") is outdated. Please update to version " + EnumColor.RED.code + FunMod.latestbersionNumber + EnumColor.ORANGE.code + FunMod.recentNews);
		}
		else if(FunMod.latestbersionNumber.equals("Error retrieving data."))
		{
			System.out.println("[FunMod] Minecraft is in offline mode, could not check for updates.");
		}
	}

	
	public static String getDisplayedEnergyNoColor(int energy)
	{
		if(energy < 1000)
		{
			return energy + " u";
		}
		else if(energy >= 1000 && energy < 10000)
		{
			return energy/10 + " kU";
		}
		else if(energy >= 10000 && energy < 100000)
		{
			return energy/100 + " mU";
		}
		else if(energy >= 100000 && energy < 1000000)
		{
			return energy/1000 + " gU";
		}
		else if(energy >= 1000000)
		{
			return energy/100000 + " tU";
		}
		else {
			return null;
		}
	}


	public static String getDisplayedEnergy(int energy)
	{
		if(energy == 0)
		{
			return EnumColor.DARK_RED.code + energy + " u" + EnumColor.DARK_GREY.code;
		}
		else if(energy < 1000)
		{
			return energy + " u";
		}
		else if(energy >= 1000 && energy < 10000)
		{
			return energy/10 + " kU";
		}
		else if(energy >= 10000 && energy < 100000)
		{
			return energy/100 + " mU";
		}
		else if(energy >= 100000 && energy < 1000000)
		{
			return energy/1000 + " gU";
		}
		else if(energy >= 1000000)
		{
			return energy/100000 + " tU";
		}
		else {
			return null;
		}
	}

	
	public static String getLatestVersion()
	{
		String[] text = getHTML("https://dl.dropbox.com/u/77390445/vercao.txt").split(":");
		if(!text[0].contains("UTF-8") && !text[0].contains("HTML")) return text[0];
		return "Error retrieving data.";
	}

	
	public static String getRecentNews()
	{
		String[] text = getHTML("https://dl.dropbox.com/u/77390445/vercao.txt").split(":");
		if(text.length > 1 && !text[1].contains("UTF-8") && !text[1].contains("HTML")) return text[1];
		return "There is no news to show.";
	}

	
	public static String getHTML(String urlToRead) 
	{
		StringBuilder sb = new StringBuilder();
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
				sb.append(line);
			}
			rd.close();
		} catch (Exception e) {
			result = "Error retrieving data.";
			System.err.println("[FunMod] An error occured while connecting to URL '" + urlToRead + ".'");
		}
		return result;
	}

	/*
	public static void sendChatMessageToPlayer(String playerUsername, String msg)
	{
		EntityPlayer player = FMLServerHandler.instance().getServer().aH().getPlayerForUsername(playerUsername);
		Packet3Chat chatPacket = new Packet3Chat(msg);
		if(player != null)
		{
			((EntityPlayer)player).netServerHandler.sendPacket(chatPacket);
		}
	}
*/
	
	public static boolean isLatestVersion()
	{
		return FunMod.bersionNumber.toString().equals(FunMod.latestbersionNumber);
	}

	
	public static boolean isOffline()
	{
		try {
			new URL("http://www.apple.com").openConnection().connect();
			return true;
		} catch (IOException e)
		{
			return false;
		}
	}

	/**
	 * Sets the defined world's time to the defined time.
	 * @param world - world to set time
	 * @param paramInt - hour to set time to
	 */

	/**
	 * Creates a fake explosion at the declared player, with only sounds and effects. No damage is caused to either blocks or the player.
	 * @param entityplayer - player to explode
	 */
	

	/**
	 * Creates a fake explosion at the declared coords, with only sounds and effects. No damage is caused to either blocks or the player.
	 * @param world - world where the explosion will occur
	 * @param x - x coord
	 * @param y - y coord
	 * @param z - z coord
	 */
	
}