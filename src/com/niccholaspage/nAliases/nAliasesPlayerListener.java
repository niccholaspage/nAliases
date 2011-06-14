package com.niccholaspage.nAliases;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class nAliasesPlayerListener extends PlayerListener{
	 private final nAliases plugin;
	  public nAliasesPlayerListener(nAliases plugin) {
	        this.plugin = plugin;
	    }
	  public void onPlayerCommandPreprocess(PlayerChatEvent event) {
			Player player = event.getPlayer();
			for (int i = 0; i < plugin.aliases.size(); i++){
				if (event.getMessage().split(" ")[0].equalsIgnoreCase(plugin.aliases.get(i).getAlias())){
					event.setCancelled(true);
					Alias alias = plugin.aliases.get(i);
					if (!alias.getPermissions().contains(player.getName()) && !alias.getPermissions().contains("g~" + plugin.permissions.getPrimaryGroup(player.getWorld().getName(), player.getName()))){
						player.sendMessage(ChatColor.RED + "You do not have permission to use that alias.");
						return;
					}
					event.setMessage(event.getMessage().replace(plugin.aliases.get(i).getAlias(), plugin.aliases.get(i).getCommand()));
				}
			}
	  }
}
