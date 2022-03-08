package com.metaxcrew.acticoreplus.Listeners;

import com.metaxcrew.acticoreplus.ActiCorePlus;
import com.metaxcrew.acticoreplus.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.awt.*;
/*
public class PlayerAlwaysSpawn implements Listener {
/
    private void FirstSpawn(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if (!p.hasPlayedBefore()) {

            String spawn = ActiCorePlus.instance.getConfig().getString("spawn");
            Location loc = Utils.toStringLoc(spawn);

            p.teleport(loc);
        return;}
    }
}
*/