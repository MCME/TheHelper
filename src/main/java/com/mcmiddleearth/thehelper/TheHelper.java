package com.mcmiddleearth.thehelper;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheHelper extends JavaPlugin {
    @Override
	getCommand("helper").setExecutor(new Commands());
	getCommand("devinfo").setExecutor(new Commands());
    public void onEnable(){
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new FirstJoinListener(), this);
    }
    @Override
    public void onDisable(){
        
    }
}
