package com.mcmiddleearth.thehelper;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheHelper extends JavaPlugin {
    
    public static TheHelper pluginInstance;
    
    @Override
    public void onEnable(){
        pluginInstance=this;
        getCommand("helper").setExecutor(new Commands());
	getCommand("devinfo").setExecutor(new Commands());
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new FirstJoinListener(), this);
    }
    @Override
    public void onDisable(){
        
    }
}
