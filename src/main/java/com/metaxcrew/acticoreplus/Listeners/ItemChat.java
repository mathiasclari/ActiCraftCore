package com.metaxcrew.acticoreplus.Listeners;


import com.metaxcrew.acticoreplus.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public class ItemChat implements Listener {
    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();

        if(p.getItemInHand().hasItemMeta()) {
            message = message.replace("[i]", Utils.chat(ChatColor.of(new Color(241, 152, 35))+p.getItemInHand().getItemMeta().getDisplayName()+ChatColor.of(new Color(130, 139, 147))));
        }else{
            message = message.replace("[i]", Utils.chat(ChatColor.of(new Color(0, 141, 183))+p.getItemInHand().getType().name()+ChatColor.of(new Color(130, 139, 147))));
        }
        e.setMessage(message);
    }
}
