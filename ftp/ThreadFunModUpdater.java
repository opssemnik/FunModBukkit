package FunMod.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.server.MinecraftServer;

import org.bukkit.command.CommandSender;

import FunMod.FunMod;
import FunMod.enums.EnumColor;
/**
 * Thread that downloads the latest release of Obsidian Ingots. The older file is deleted and the newly downloaded file takes it's place.
 * @author AidanBrady
 *
 */
public class ThreadFunModUpdater extends Thread
{
	private CommandSender sender;
	private int bytesDownloaded;
	private int lastBytesDownloaded;
	private byte[] buffer = new byte[10240];
	private URL url;
	
	public ThreadFunModUpdater(String location, CommandSender player)
	{
		sender = player;
		try {
			url = new URL(location);
			setDaemon(true);
			start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		File download = new File(new StringBuilder().append(MinecraftServer.D().G()).append("/mods/FunMod.jar").toString());
		try {
			prepareForDownload();
			download.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(download.getAbsolutePath());
			InputStream stream = url.openStream();
			
			while((lastBytesDownloaded = stream.read(buffer)) > 0)
			{
				outputStream.write(buffer, 0, lastBytesDownloaded);
				buffer = new byte[10240];
				bytesDownloaded += lastBytesDownloaded;
			}
			
			outputStream.close();
			stream.close();
			sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Successfully updated to version " + EnumColor.DARK_GREY.code + FunMod.latestbersionNumber);
			System.out.println("[FunMod] Successfully updated to latest version (" + FunMod.latestbersionNumber + ").");
			finalize();
			
		} catch(Throwable e)
		{
			sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Unable to update to version " + EnumColor.DARK_GREY.code + FunMod.latestbersionNumber);
			System.err.println("[FunMod] Error while finishing update thread: " + e.getMessage());
			try {
				finalize();
			} catch (Throwable e1) {
				System.err.println("[FunMod] Error while finalizing update thread: " + e1.getMessage());
			}
		}
	}
	
	public void prepareForDownload()
	{
		File download = new File(new StringBuilder().append(MinecraftServer.D().G()).append("/mods/FunMod.jar").toString());
		File config = new File(new StringBuilder().append(MinecraftServer.D().G()).append("/config/FunMod.cfg").toString());
		
		if(download.exists())
		{
			download.delete();
		}
		if(config.exists())
		{
			config.delete();
		}
		System.out.println("[FunMod] Preparing to update...");
	}
}