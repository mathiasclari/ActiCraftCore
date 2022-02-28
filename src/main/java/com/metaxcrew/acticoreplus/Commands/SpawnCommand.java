package com.metaxcrew.acticoreplus.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("acti.spawn")) {
                p.getPlayer().getLocation().getWorld().getBlockAt(0,225,0);

                Location l = p.getWorld().getSpawnLocation();
                p.teleport(l);
                p.sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You have been teleported to: " + ChatColor.of(new Color(0, 141, 183)) + "SPAWN");
            }else{
                sender.sendMessage(ChatColor.of(new Color(169, 45, 81)) + "You do not have permission to execute this command!");
            }
        }
        return true;}
}
