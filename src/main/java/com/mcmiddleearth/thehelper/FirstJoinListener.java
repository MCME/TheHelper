package com.mcmiddleearth.thehelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class FirstJoinListener implements Listener{
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore() || player.getName().equalsIgnoreCase("swcd")) {
          Bukkit.broadcastMessage(String.valueOf(ChatColor.BOLD + player.getName() + ChatColor.RESET + ChatColor.YELLOW + " logged in for the first time!"));
          player.sendMessage(ChatColor.YELLOW + "Welcome to Minecraft Middle Earth!");
          player.sendMessage(ChatColor.YELLOW + "If you have questions, feel free to ask a" + ChatColor.DARK_AQUA +" Ranger");
        }
    }
}