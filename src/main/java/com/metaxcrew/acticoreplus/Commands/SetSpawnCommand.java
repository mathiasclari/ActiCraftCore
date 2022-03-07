package com.metaxcrew.acticoreplus.Commands;

import com.metaxcrew.acticoreplus.ActiCorePlus;
import com.metaxcrew.acticoreplus.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {



        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("acti.setspawn")) {


                    player.sendMessage(ChatColor.of(new Color(130, 139, 147)) + "Spawn" +ChatColor.of(new Color(0, 141, 183)) + " Location was set");

                    Location l = player.getLocation();

                    String loc = Utils.toLocString(l);

                ActiCorePlus.instance.getConfig().set("spawn",loc);
                ActiCorePlus.instance.saveConfig();


            } else {
                sender.sendMessage(ChatColor.of(new Color(169, 45, 81)) + "You do not have permission to execute this command!");
            }


            return false;
        }
        return false;}
}
