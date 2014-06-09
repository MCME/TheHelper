package com.mcmiddleearth.thehelper;

import java.util.TreeMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
//                   if(args[0].equalsIgnoreCase("converse")){
//                       
//                   }
                   if(args[0].equalsIgnoreCase("teamspeak")||args[0].equalsIgnoreCase("ts")){
                       player.sendMessage("TeamSpeak is how mcme communicates on projects. Download TeamSpeak 3 here: http://www.teamspeak.com/?page=downloads");
                   }
                   if(args[0].equalsIgnoreCase("forums")){
                       player.sendMessage("The forums are where discussions take place and where you can find help. Visit: http://www.mcmiddleearth.com/forums/");
                   }
                   if(args[0].equalsIgnoreCase("textures")){
                       player.sendMessage("The various Resource Packs are available at: http://mcmiddleearth.com/resources/categories/9/");
                   }
                   if(args[0].equalsIgnoreCase("ranks")){
                       player.sendMessage("Information about the ranks and their duties is available at: http://www.mcmiddleearth.com/wiki/ranks-and-duties/");
                   }
                   if(args[0].equalsIgnoreCase("servers")){
                       player.sendMessage("All our IP's and domains can be found here: http://www.mcmiddleearth.com/resources/9/");
                   }
                   if(args[0].equalsIgnoreCase("dynmap")||args[0].equalsIgnoreCase("map")){
                       player.sendMessage("The Dynmap is a useful map to find your way on the server");
                       player.sendMessage("BuildServer Dynmap: http://build.mcmiddleearth.com:8123");
                       player.sendMessage("FreeBuildServer Dynmap: http://freebuild.mcmiddleearth.com:8123");
                   }
                   if(args[0].equalsIgnoreCase("newplayerguide")||args[0].equalsIgnoreCase("guide")){
                       player.sendMessage("A useful guide for new players: http://www.mcmiddleearth.com/pages/new-player-guide/");
                   }
                   if(args[0].equalsIgnoreCase("rules")){
                       player.sendMessage("Our Terms of Service and Rules can be found here: http://www.mcmiddleearth.com/help/terms");
                   }
               }
           }
            if(command.getName().equalsIgnoreCase("devinfo")){
                if(player.hasPermission("TheHelper.info")){
//                      char locchrs[] = {104, 116, 116, 112, 58, 47, 47, 109, 99, 109, 101, 046, 106, 111, 115, 104, 114, 046, 104, 107, 047, 115, 101, 114, 118, 101, 114, 047, 98, 117, 105, 108, 100};
//                      String loc = String.valueOf(locchrs);
                      //I was really bored so I did this =)
                    if(args.length > 0){
                        if(args[0].equalsIgnoreCase("versions")){
                            if(args.length == 1){
                                for(Plugin p : Bukkit.getServer().getPluginManager().getPlugins()){
                                    player.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.WHITE + " : " + ChatColor.GREEN + p.getDescription().getVersion());
                                }
                                return true;
                            }
                        }else if(args[0].equalsIgnoreCase("player")&&args.length>1){
                            
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
