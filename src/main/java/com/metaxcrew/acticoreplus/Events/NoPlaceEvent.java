package com.metaxcrew.acticoreplus.Events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.awt.*;

public class NoPlaceEvent implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission("acti.place")){
            event.setCancelled(false);
        }else {
            event.setCancelled(true);
            p.sendMessage(ChatColor.of(new Color(169, 45, 81)) + "You do not have required permissions to place blocks! ");
        }}

}

