package de.presti.opensource.teamchat.bungeecord.cmd;

import de.presti.opensource.teamchat.bungeecord.main.Data;
import de.presti.opensource.teamchat.bungeecord.main.TeamChatMain;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TC extends Command {
	
	public TC() {
		super("tc");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
	  if(sender instanceof ProxiedPlayer) {
		  ProxiedPlayer p = (ProxiedPlayer)sender;
		if(p.hasPermission("tc.chat") || p.hasPermission("tc.*")) {
		   if(args.length == 0) {
			  for(ProxiedPlayer all : TeamChatMain.instance.getProxy().getPlayers()) {
				  if(all.hasPermission("tc.chat") || all.hasPermission("tc.*")) {
			   p.sendMessage(Data.prefix + all.getName() + " on " + all.getServer().getInfo().getName());
				  }
			}
		   } else {
	            StringBuilder sb = new StringBuilder();
	            int i = 0;
	            while (i < args.length) {
	                sb.append(String.valueOf(args[i]) + " ");
	                ++i;
	            }
	            String st = sb.toString();
				for(ProxiedPlayer all : TeamChatMain.instance.getProxy().getPlayers()) {
					if(all.hasPermission("tc.chat") || all.hasPermission("tc.*")) {
					all.sendMessage(Data.prefix + p.getName() + ": " + st.replace("&", "\u00A7"));
					}
					System.out.println(Data.prefix + p.getName() + ": " + st.replace("&", "\u00A7"));
			}
	            
			}
		   } else {
			   p.sendMessage(Data.noperms);
		   }
	  } else {
		  sender.sendMessage(Data.prefix + "\u00A7cYou arent a Player!");
	  }
		
	}

}
