package com.mcmiddleearth.thehelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

public class TheHelper extends JavaPlugin {
    
    final static HashMap<String, String> commands = new HashMap<>();
    
    final static ChatColor THccm = ChatColor.GREEN;

    final static Permission admin = new Permission("thehelper.admin", PermissionDefault.OP);

    @Override
    public void onEnable(){
        this.saveDefaultConfig();

        for(String key : this.getConfig().getKeys(false)) {
            commands.put(key, this.getConfig().getString(key));
        }

        getCommand("helper").setExecutor(new Commands());
    }

    class Commands implements TabExecutor {
        private void sendCommandHelp(CommandSender sender) {
            sender.sendMessage("Valid help options:");
            for(String key :  commands.keySet()) {
                sender.sendMessage(" - /helper " + key);
            }
            if(sender.hasPermission(admin)) {
                sender.sendMessage("/helper add <key> <value>");
                sender.sendMessage("/helper remove <key>");
            }
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(args.length < 1) {
                sendCommandHelp(sender);
                return true;
            }

            if(sender.hasPermission(admin) && args[0].equalsIgnoreCase("add")) {
                if(args.length < 3) {
                    sendCommandHelp(sender);
                    return true;
                }
                StringBuilder messageBuilder = new StringBuilder();
                for(int i = 2; i < args.length; i++) {
                    messageBuilder.append(args[i]);
                    if(i < args.length - 1) {
                        messageBuilder.append(" ");
                    }
                }
                commands.put(args[1], messageBuilder.toString());
                TheHelper.this.getConfig().set(args[1], messageBuilder.toString());
                TheHelper.this.saveConfig();
                sender.sendMessage("Help option " + args[1] + " added");
                return true;
            }
            if(sender.hasPermission(admin) && args[0].equalsIgnoreCase("remove")) {
                if(args.length < 2) {
                    sendCommandHelp(sender);
                    return true;
                }
                String message = commands.remove(args[1]);
                TheHelper.this.getConfig().set(args[1], null);
                TheHelper.this.saveConfig();
                sender.sendMessage(message == null ? "Could not locate help option" : "Help option removed");
                return true;
            }

            String help = commands.get(args[0]);
            if(help == null) {
                sendCommandHelp(sender);
                return true;
            }
            sender.sendMessage(THccm + help.replace('#', ChatColor.COLOR_CHAR));
            return true;
        }

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if(args.length <= 1) {
                ArrayList<String> possible = new ArrayList<>(commands.keySet());
                if(sender.hasPermission(admin)){
                    possible.add("add");
                    possible.add("remove");
                }
                if(args.length == 0) {
                    return possible;
                }
                ArrayList<String> actual = new ArrayList<>();
                for(String k : possible) {
                    if(k.startsWith(args[0])) {
                        actual.add(k);
                    }
                }
                return actual;
            } else {
                if(args[0].equalsIgnoreCase("add")) {
                    return new ArrayList<>();
                } else if(args[0].equalsIgnoreCase("remove")){
                    ArrayList<String> possible = new ArrayList<>();
                    for(String k : commands.keySet()) {
                        if(k.startsWith(args[1])){
                            possible.add(k);
                        }
                    }
                    return possible;
                }
            }
            return new ArrayList<>();
        }
    }
}
