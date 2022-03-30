package com.metaxcrew.acticoreplus.Listeners;


import com.metaxcrew.acticoreplus.ActiCorePlus;
import com.metaxcrew.acticoreplus.Utils.Colors;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerMessageListener {



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerPlaceholderChat(AsyncPlayerChatEvent event){
        String format = Colors.toHex(Colors.color(PlaceholderAPI.setPlaceholders(event.getPlayer(), ActiCorePlus.instance.getConf().getString("format", "&7{display_name} &7> {message}").replace("{name}", event.getPlayer().getName()).replace("{display_name}", event.getPlayer().getDisplayName()))));
        event.setFormat(format.replace("{message}", event.getMessage().replace("%", "‰")));
    }

}
