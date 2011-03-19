package com.niccholaspage.nAliases;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class nAliasesPlayerListener extends PlayerListener{
	 public static nAliases plugin;
	  public nAliasesPlayerListener(nAliases instance) {
	        plugin = instance;
	    }
	  public void onPlayerCommandPreprocess(PlayerChatEvent event) {
			//Get the player that talked.
			Player player = event.getPlayer();
			for (int i = 0; i < plugin.commands.size(); i++){
			if (event.getMessage().split(" ")[0].equalsIgnoreCase((plugin.commands.get(i)))){
				event.setCancelled(true);
				if (plugin.aliases.get(i).startsWith("/")){
					event.setMessage(event.getMessage().replace(plugin.commands.get(i), plugin.aliases.get(i)));
				}else {
					player.chat(event.getMessage().replace(plugin.commands.get(i), plugin.aliases.get(i)));
				}
				return;
			}
		}
	  }
}
