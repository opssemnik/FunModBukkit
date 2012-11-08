package FunMod.comandos;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import FunMod.FunMod;
import FunMod.enums.EnumColor;
import FunMod.ftp.ThreadFunModUpdater;
import FunMod.loader.FunModHooks;

public class CommandFun extends Command
{
   

	public CommandFun(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getCommandName()
    {
        return "fun";
    }
    
    public String getCommandUsage(CommandSender sender)
    {
    	return "/fun <parameters>";
    }
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	public List getCommandAliases()
	{
		return Arrays.asList(new String[] {"obsidian", "FunMod"});
	}
	/** Era isso que nao deixava eu usar o comando em single player *_*
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return !MinecraftServer.getServer().isSinglePlayer() && super.canCommandSenderUseCommand(sender);
    }
	**/
   

	@Override
	public boolean execute(CommandSender sender, String params, String[] arg2) 
		 {
		        if(arg2.length < 1)
		        {
		            sender.sendMessage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
		            sender.sendMessage(EnumColor.GREY.code + " *Version: " + EnumColor.DARK_GREY.code + FunMod.bersionNumber);
		            sender.sendMessage(EnumColor.GREY.code + " *Latest Version: " + EnumColor.DARK_GREY.code + FunMod.latestbersionNumber);
		            sender.sendMessage(EnumColor.GREY.code + " *Developed on Mac OS X 10.8 Mountain Lion, Eclipse Juno emulated with vmware (windows 7 workspace)");
		            sender.sendMessage(EnumColor.GREY.code + " *This mod is made by Brazilian Cool Guys");
		            sender.sendMessage(EnumColor.GREY.code + " *Recent News: " + EnumColor.INDIGO.code + FunMod.recentNews);
		            sender.sendMessage(EnumColor.GREY.code + "-------- " + EnumColor.ORANGE.code + "Type /fun help For Help" + EnumColor.GREY.code + " --------");
		            sender.sendMessage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
		        }
		        else if(arg2.length == 1)
		        {
			        if(arg2[0].equalsIgnoreCase("update"))
			        {
			        	if(FunModHooks.isLatestVersion())
			        	{
			        		sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "FunMod is already up-to-date.");
			        	}
			        	else {
			        		sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Preparing to update...");
			        		new ThreadFunModUpdater("http://dl.dropbox.com/u/90411166/FunMod.jar", sender);
			        	}
			        }
			        
			        else if(arg2[0].equalsIgnoreCase("help"))
			        {
			            sender.sendMessage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
			            sender.sendMessage(EnumColor.INDIGO.code + " /fun" + EnumColor.GREY.code + " -- displays the main page.");
			            sender.sendMessage(EnumColor.INDIGO.code + " /fun help" + EnumColor.GREY.code + " -- displays this guide.");
			            sender.sendMessage(EnumColor.INDIGO.code + " /fun update" + EnumColor.GREY.code + " -- updates the Obsidian Ingots server.");
			            sender.sendMessage(EnumColor.INDIGO.code + " /fun version" + EnumColor.GREY.code + " -- displays the version number.");
			            sender.sendMessage(EnumColor.INDIGO.code + " /fun news" + EnumColor.GREY.code + " -- displays most recent recent news.");
			            sender.sendMessage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
			        }
			        
			        else if(arg2[0].equalsIgnoreCase("version"))
			        {
			        	sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " This server is running on version " + EnumColor.DARK_GREY.code + FunMod.bersionNumber.toString() + EnumColor.GREY.code + ".");
			        }
			        
			        else if(arg2[0].equalsIgnoreCase("news"))
			        {
			        	sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Most recent news: " + EnumColor.INDIGO.code + FunMod.recentNews);
			        }
			        
			        else if(arg2[0].equalsIgnoreCase("latest"))
			        {
			        	sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " The latest version for this mod is " + EnumColor.DARK_GREY.code + FunMod.latestbersionNumber + EnumColor.GREY.code + ".");
			        }
			        
			        else {
			        	sender.sendMessage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Unknown command. Type '" + EnumColor.INDIGO.code + "/fun help" + EnumColor.GREY.code + "' for help.");
			        }
		        }
				return true;
		    }
}