package com.mcmiddleearth.thehelper;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
           Player player = (Player) sender;
           if(command.getName().equalsIgnoreCase("helper")){
               if(args.length > 0){
                   if(args[0].equalsIgnoreCase("converse")){
                       
                   }
                   if(args[0].equalsIgnoreCase("forums")){
                       player.sendMessage("The forums are where discussions take place and where you can find help. Visit: http://www.mcmiddleearth.com/forums/");
                   }
                   if(args[0].equalsIgnoreCase("resourcepack")){
                       player.sendMessage("The various Resource Packs are available at: http://mcmiddleearth.com/resources/categories/9/");
                   }
                   if(args[0].equalsIgnoreCase("ranks")){
                       player.sendMessage("Information about the ranks and their duties is available at: http://www.mcmiddleearth.com/wiki/ranks-and-duties/");
                   }
                   if(args[0].equalsIgnoreCase("teamspeak")){
                       player.sendMessage("A useful tutorial for how to install teamspeak: http://www.mcmiddleearth.com/resources/44/");
                   }
               }
           }
           if(command.getName().equalsIgnoreCase("devinfo")){
               if(args.length > 0){
                   if(args[0].equalsIgnoreCase("versions")){
                       player.sendMessage("x");
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
