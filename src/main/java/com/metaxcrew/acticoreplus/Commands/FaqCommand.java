package com.metaxcrew.acticoreplus.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class FaqCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.of(new Color(161, 255, 234)) + "✿" +ChatColor.of(new Color(60, 60, 63)) + "---------------------("+ChatColor.of(new Color(161, 255, 234)) +ChatColor.BOLD+"FAQ"+ChatColor.of(new Color(60, 60, 63))+")---------------------"+ ChatColor.of(new Color(161, 255, 234)) +"✿");
            sender.sendMessage("");
            sender.sendMessage(ChatColor.of(new Color(161, 255, 234)) + "★ " +ChatColor.of(new Color(100, 100, 100)) + "How do i make account on website?");
            sender.sendMessage(ChatColor.of(new Color(173, 173, 173)) + "You need to join Hub server and execute the command"+ChatColor.of(new Color(185, 41, 71)) +" /register");
            sender.sendMessage("");
            sender.sendMessage(ChatColor.of(new Color(161, 255, 234)) + "★ " +ChatColor.of(new Color(100, 100, 100)) + "How can i apply for staff?");
            sender.sendMessage(ChatColor.of(new Color(173, 173, 173)) + "We have applications on website. To get the link to the website please execute command"+ChatColor.of(new Color(185, 41, 71)) +" /website");
            sender.sendMessage("");
            sender.sendMessage(ChatColor.of(new Color(161, 255, 234)) + "★ " +ChatColor.of(new Color(100, 100, 100)) + "How can i join Server Discord server?");
            sender.sendMessage(ChatColor.of(new Color(173, 173, 173)) + "You need to join Hub server and execute the command"+ChatColor.of(new Color(185, 41, 71)) +" /discord");
            sender.sendMessage("");
            sender.sendMessage(ChatColor.of(new Color(161, 255, 234)) + "✿" +ChatColor.of(new Color(60, 60, 63)) + "-----------------------"+"------------------------"+ ChatColor.of(new Color(161, 255, 234)) +"✿");
        }


        return false;
    }
}
