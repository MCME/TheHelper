package com.mcmiddleearth.thehelper;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheHelper extends JavaPlugin {
    
    public static TheHelper pluginInstance;
    
    public HashMap<String, String> urls = new HashMap<String, String>();
    
    public static ChatColor THccm = ChatColor.GREEN;
    public static ChatColor THccl = ChatColor.RED;
    
    @Override
    public void onEnable(){
        Servlet server = new Servlet(8800);
        server.start();
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        pluginInstance=this;
        getCommand("helper").setExecutor(new Commands());
	getCommand("devinfo").setExecutor(new Commands());
        if(this.getConfig().getBoolean("welcomeMsg")){
            PluginManager pm = this.getServer().getPluginManager();
            pm.registerEvents(new FirstJoinListener(), this);
        }
        for(String s : config.getKeys(true)){
            if(s.contains("url.")){
                urls.put(s.replace("url.", ""), config.getString(s));
            }
        }
    }
    @Override
    public void onDisable(){
        
    }
}
