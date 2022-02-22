package com.metaxcrew.acticoreplus.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("acti.gmgui")) {
                if (player.isFlying() == true) {
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.of(new Color(130, 139, 147)) + "Flight has been" +ChatColor.of(new Color(0, 141, 183)) + " disabled");
                } else {


                    if (player.isFlying() == false) {
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.of(new Color(130, 139, 147)) + "Flight has been" +ChatColor.of(new Color(0, 141, 183)) + " enabled");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.of(new Color(169, 45, 81)) + "You do not have permission to execute this command!");
            }


            return false;
        }
        return false;}
}
