package com.metaxcrew.acticoreplus.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class JoinMessageListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.of(new Color(153, 4, 56))+"» "+ChatColor.of(new Color(130, 139, 147))+ p.getDisplayName()+ ChatColor.of(new Color(69, 72, 77))+ " has joined the game!");
    }

    @EventHandler
    private void onLeave(PlayerQuitEvent e1){
        Player p = e1.getPlayer();
        e1.setQuitMessage(ChatColor.of(new Color(153, 4, 56))+"» "+ChatColor.of(new Color(130, 139, 147))+ p.getDisplayName()+ ChatColor.of(new Color(69, 72, 77))+ " has left the game!");
    }
}

