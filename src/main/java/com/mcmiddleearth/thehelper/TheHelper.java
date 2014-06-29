package com.mcmiddleearth.thehelper;

import java.util.HashMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheHelper extends JavaPlugin {
    
    public static TheHelper pluginInstance;
    
    public HashMap<String, String> urls = new HashMap<String, String>();
    
    @Override
    public void onEnable(){
        FileConfiguration config = this.getConfig();
        pluginInstance=this;
        getCommand("helper").setExecutor(new Commands());
	getCommand("devinfo").setExecutor(new Commands());
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new FirstJoinListener(), this);
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
