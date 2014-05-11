/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mcme.thehelper;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Donovan
 */
public class Commands implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
           Player player = (Player) sender;
           if(command.getName().equalsIgnoreCase("helper")){
               if(args.length > 0){
                   if(args[0].equalsIgnoreCase("pm")){
                       
                   }
                   if(args[0].equalsIgnoreCase("forums")){
                       player.sendMessage("The forums are a very help full place, go to them here: http://www.mcmiddleearth.com/forums/");
                   }
                   if(args[0].equalsIgnoreCase("textures")){
                       player.sendMessage("The texture pack is here: http://mcmiddleearth.com/resources/categories/official-resourcepacks.9/");
                   }
                   if(args[0].equalsIgnoreCase("ranks")){
                       player.sendMessage("https://docs.google.com/spreadsheets/d/1nX8RBjMEDHqbuZK55t3PyG1OWzstc1rItHGkLfod4LI/edit#gid=641145490 thanks to Lizzy =)");
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
