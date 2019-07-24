package de.presti.opensource.teamchat.bungeecord.main;

import de.presti.opensource.teamchat.bungeecord.cmd.TC;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class TeamChatMain extends Plugin {
	public static TeamChatMain instance;
	
	public void onEnable() {
		instance = this;
		System.out.println(this.instance.getDescription().getName() + " enabeld!");
		onRegisterCMD();
	}
	
	public void onDisable() {
		System.out.println(this.instance.getDescription().getName() + " disabeld!");	
	}
	
	public void onRegisterCMD() {
		BungeeCord.getInstance().pluginManager.registerCommand(instance, new TC());
	}

}
