package com.metaxcrew.acticoreplus.Listeners;


import com.metaxcrew.acticoreplus.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ItemChat implements Listener {
    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();

        if(p.getItemInHand().hasItemMeta()) {
            message = message.replace("[i]", Utils.chat(p.getItemInHand().getItemMeta().getDisplayName()));
        }else{
            message = message.replace("[i]", Utils.chat(p.getItemInHand().getType().name()));
        }
        e.setMessage(message);
    }
}
