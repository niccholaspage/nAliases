package com.niccholaspage.nAliases;

import org.bukkit.ChatColor;
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
			for (int i = 0; i < plugin.aliases.size(); i++){
				if (event.getMessage().split(" ")[0].equalsIgnoreCase(plugin.aliases.get(i).getAlias())){
					event.setCancelled(true);
					if (!(plugin.aliases.get(i).getPermissions().size() == 0)){
						if ((!(plugin.aliases.get(i).getPermissions().contains(player.getName()))) && (!(plugin.aliases.get(i).getPermissions().contains("g~" + nAliases.Permissions.getGroup(player.getWorld().getName(), player.getName()))))){
							player.sendMessage(ChatColor.RED + "You do not have permission to use that alias.");
							return;
						}
					}
					if (plugin.aliases.get(i).getCommand().startsWith("/")){
						event.setMessage(event.getMessage().replace(plugin.aliases.get(i).getAlias(), plugin.aliases.get(i).getCommand()));
					}else {
						player.chat(event.getMessage().replace(plugin.aliases.get(i).getAlias(), plugin.aliases.get(i).getCommand()));
					}
				}
			}
	  }
}
