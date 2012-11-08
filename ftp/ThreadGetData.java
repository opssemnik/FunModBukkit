package FunMod.ftp;

import FunMod.loader.FunModHooks;
import FunMod.FunMod;
/**
 * Thread used to retrieve data from the Fun Mod server.
 * @author Antonio
 *
 */
public class ThreadGetData extends Thread
{
	public ThreadGetData()
	{
		setDaemon(true);
		start();
	}

	public void run()
	{
		FunMod.latestbersionNumber = FunModHooks.getLatestVersion();
		FunMod.recentNews = FunModHooks.getRecentNews();
		System.out.println("[FunMod] Successfully retrieved data from server.");
		try {
			finalize();
		} catch(Throwable t) {
			System.out.println("[FunMod] Unable to finalize server data.");
		}
	}
}