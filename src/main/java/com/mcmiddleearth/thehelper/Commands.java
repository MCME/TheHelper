package com.mcmiddleearth.thehelper;

import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
           Player player = (Player) sender;
           if(command.getName().equalsIgnoreCase("helper")){
               if(args.length > 0){
                   if(args[0].equalsIgnoreCase("teamspeak")||args[0].equalsIgnoreCase("ts")){
                       player.sendMessage("TeamSpeak is how mcme communicates on projects. Download TeamSpeak 3 here: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
                   }
                   else if(args[0].equalsIgnoreCase("forums")){
                       player.sendMessage("The forums are where discussions take place and where you can find help. Visit: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
                   }
                   else if(args[0].equalsIgnoreCase("textures")){
                       player.sendMessage("The various Resource Packs are available at: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
                   }
                   else if(args[0].equalsIgnoreCase("ranks")){
                       player.sendMessage("Information about the ranks and their duties is available at: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
                   }
<<<<<<< HEAD
                   if(args[0].equalsIgnoreCase("servers")){
                       player.sendMessage("All our IP's and domains can be found here: http://www.mcmiddleearth.com/resources/9/");
                   }
                   if(args[0].equalsIgnoreCase("dynmap")||args[0].equalsIgnoreCase("map")){
                       player.sendMessage("The Dynmap is a useful map to find your way on the server");
                       player.sendMessage("BuildServer Dynmap: " + TheHelper.pluginInstance.urls.get("dynmapb"));
                       player.sendMessage("FreeBuildServer Dynmap: " + TheHelper.pluginInstance.urls.get("dynmapfb"));
                   }
                   if(args[0].equalsIgnoreCase("newplayerguide")||args[0].equalsIgnoreCase("guide")){
                       player.sendMessage("A useful guide for new players: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
                   }
                   if(args[0].equalsIgnoreCase("rules")){
                       player.sendMessage("Our Terms of Service and Rules can be found here: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
=======
                   else if(args[0].equalsIgnoreCase("dynmap")){
                       player.sendMessage("The Dynmap is a useful map to find your way on the server");
                       player.sendMessage("BuildServer Dynmap: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase() + "b"));
                       player.sendMessage("FreeBuildServer Dynmap: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase() + "fb"));
                   }
                   else if(args[0].equalsIgnoreCase("newplayerguide")){
                       player.sendMessage("A useful guide for new players: " + TheHelper.pluginInstance.urls.get(args[0].toLowerCase()));
>>>>>>> 058d2489fc48b54ddd88d07ab5aff023f14ea678
                   }
               }
           }
            if(command.getName().equalsIgnoreCase("devinfo")){
                if(player.hasPermission("TheHelper.info")){
                    if(args.length > 0){
                        if(args[0].equalsIgnoreCase("versions")){
                            if(args.length == 1){
                                for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()){
                                    player.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.WHITE + " : " + ChatColor.GREEN + p.getDescription().getVersion());
                                }
                                return true;
                            }
                        }else if(args[0].equalsIgnoreCase("player")&&args.length>1){
                            OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
                            player.sendMessage(ChatColor.AQUA + p.getName());
                            player.sendMessage("========================");
                            player.sendMessage(ChatColor.AQUA + "First Join: " + ChatColor.DARK_GREEN + String.valueOf(new Date(p.getFirstPlayed())));
                            player.sendMessage(ChatColor.YELLOW + "Last Played: " + ChatColor.DARK_GREEN + String.valueOf(new Date(p.getLastPlayed())));
                            return true;
                        }else{
                            Plugin p = Bukkit.getServer().getPluginManager().getPlugin(args[0]);
                            if(p == null){
                                player.sendMessage("no plugin by that name");
                                player.sendMessage("'/devinfo versions' for a list of plugins");
                                return true;
                            }
                            player.sendMessage(ChatColor.AQUA + p.getName());
                            player.sendMessage("===========================");
                            player.sendMessage(ChatColor.YELLOW + "Version: " + ChatColor.DARK_GREEN + p.getDescription().getVersion());
                            player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.DARK_GREEN + p.getDescription().getDescription());
                            //player.sendMessage(ChatColor.YELLOW + "Config: " + ChatColor.DARK_GREEN + p.getConfig().toString());
                            player.sendMessage(ChatColor.YELLOW + "Commands: ");
                            for(String s : p.getDescription().getCommands().keySet()){
                                String cmd;
                                if(p.getDescription().getCommands().get(s).containsKey("description")){
                                    cmd = p.getDescription().getCommands().get(s).get("description").toString();
                                }else{
                                    cmd="no description provided";
                                }
                                player.sendMessage("  -" + ChatColor.LIGHT_PURPLE + s + ": " + ChatColor.DARK_AQUA + cmd);
                            }
                            return true;
                        }           
                    }
               }
           }
        } else {
           sender.sendMessage("You must be a player!");
           return false;
        }
        return false;
    }
}
