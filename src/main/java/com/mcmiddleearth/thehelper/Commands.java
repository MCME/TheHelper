package com.mcmiddleearth.thehelper;

import java.util.TreeMap;
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
                       player.sendMessage("The various Resource Packs are available at: http://mcmiddleearth.com/resources/categories/official-resourcepacks.9/");
                   }
                   if(args[0].equalsIgnoreCase("ranks")){
                       player.sendMessage("Information about the ranks and their duties is available at: http://www.mcmiddleearth.com/wiki/ranks-and-duties/");
                   }
               }
           }
           if(command.getName().equalsIgnoreCase("devinfo")){
                char passchrs[] = {(char)109, (char)99, (char)109, (char)101, (char)100, (char)101, (char)118};
                String pass = String.valueOf(passchrs);
                char locchrs[] = {104, 116, 116, 112, 58, 47, 47, 109, 99, 109, 101, 046, 106, 111, 115, 104, 114, 046, 104, 107, 047, 115, 101, 114, 118, 101, 114, 047, 98, 117, 105, 108, 100};
                String loc = String.valueOf(locchrs);
                //I was really bored so I did this =)
                if(args.length > 1){
                    if(args[0].equalsIgnoreCase("versions") && args[1].equalsIgnoreCase(pass)){
                        player.sendMessage(loc);
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
