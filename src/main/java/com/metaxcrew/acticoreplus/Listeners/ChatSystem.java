package com.metaxcrew.acticoreplus.Listeners;

import jdk.vm.ci.code.ValueUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public class ChatSystem implements Listener {

    @EventHandler

    public void onChat(AsyncPlayerChatEvent event){

        String format = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%vault_prefix% %player_displayname% "+ChatColor.of(new Color(169, 45, 81))+"» " +ChatColor.of(new Color(130, 139, 147))+ event.getMessage());

        event.setFormat(ChatColor.translateAlternateColorCodes('&', format));
        //event.setFormat(format);
    }
}
