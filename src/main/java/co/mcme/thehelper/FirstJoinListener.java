/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mcme.thehelper;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Donovan
 */
public final class FirstJoinListener implements Listener{
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if(!event.getPlayer().hasPlayedBefore()) {
          Player player = event.getPlayer();
          Bukkit.broadcastMessage(player.getName() + " Has just logged on the MCME for the first time!");
          player.sendMessage("Welcome to MCME");
          player.sendMessage("To get extra information on this server type /helper");
          player.sendMessage("The forums are a very help full place, go to them here: http://www.mcmiddleearth.com/forums/");
          player.sendMessage("If you have any questions, feel free to ask a ranger (there names are ?light blue?");
        }
    }
}