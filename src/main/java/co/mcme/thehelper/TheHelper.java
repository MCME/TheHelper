/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mcme.thehelper;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Donovan
 */
public class TheHelper extends JavaPlugin {
    @Override
    public void onEnable(){
        getCommand("helper").setExecutor(new Commands());
        getCommand("devinfo").setExecutor(new Commands());
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new FirstJoinListener(), this);
    }
    @Override
    public void onDisable(){
        
    }
}
