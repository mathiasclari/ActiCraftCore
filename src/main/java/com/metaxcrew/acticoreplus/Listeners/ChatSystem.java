package com.metaxcrew.acticoreplus.Listeners;

import com.metaxcrew.acticoreplus.ActiCorePlus;
import com.metaxcrew.acticoreplus.Utils.Colors;
import jdk.vm.ci.code.ValueUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public class ChatSystem implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerPlaceholderChat(AsyncPlayerChatEvent event){
        String format = Colors.toHex(Colors.color(PlaceholderAPI.setPlaceholders(event.getPlayer(), ActiCorePlus.getInstance().getConf().getString("format", "&7{display_name} &7> {message}").replace("{name}", event.getPlayer().getName()).replace("{display_name}", event.getPlayer().getDisplayName()))));
        event.setFormat(format.replace("{message}", event.getMessage().replace("%", "‰")));
    }

}
