package com.metaxcrew.acticoreplus;

import com.metaxcrew.acticoreplus.Commands.*;
//import com.metaxcrew.acticoreplus.Events.NoBreakEvent;
//import com.metaxcrew.acticoreplus.Events.NoPlaceEvent;
//import com.metaxcrew.acticoreplus.Events.NoBreakEvent;
//import com.metaxcrew.acticoreplus.Events.NoPlaceEvent;
import com.metaxcrew.acticoreplus.GUIs.GmGUI;
import com.metaxcrew.acticoreplus.GUIs.TimeGUI;
//import com.metaxcrew.acticoreplus.Listeners.ChatSystem;
import com.metaxcrew.acticoreplus.Listeners.ChatSystem;
import com.metaxcrew.acticoreplus.Listeners.ItemChat;
import com.metaxcrew.acticoreplus.Listeners.JoinMessageListener;
import com.metaxcrew.acticoreplus.Listeners.PlayerMessageListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public final class ActiCorePlus extends JavaPlugin {

    public static ActiCorePlus instance;
    private final YamlConfiguration conf = new YamlConfiguration();
    @Override
    public void onEnable() {

        instance = this;


        reloadConfig();
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveDefaultConfig();

            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]=====================<" + ChatColor.of(new Color(169, 45, 81)) + ChatColor.BOLD + "ActiCaft" + ChatColor.GRAY + ">=====================[]");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(0, 141, 183))+"");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Plugin:" + ChatColor.of(new Color(0, 141, 183)) + " ServerCore");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Developer:" + ChatColor.of(new Color(0, 141, 183)) + " PxLb");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Discord:" + ChatColor.of(new Color(0, 141, 183)) + " PxLib#0001");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(0, 141, 183))+"");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Type:" + ChatColor.of(new Color(0, 141, 183)) + " Private");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(0, 141, 183))+"");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Licence:" + ChatColor.of(new Color(41, 255, 84)) + " Valid");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(0, 141, 183))+"");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(69, 72, 77)) + "    ・ Support Discord:" + ChatColor.of(new Color(0, 141, 183)) + " https://discord.gg/gFmBdpPZJa");
            Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(0, 141, 183))+"");
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]====================================================[]");

            //Commands GUI
            //getCommand("shop").setExecutor(new ""());
            getCommand("gm").setExecutor(new GmGUI());
            getCommand("time").setExecutor(new TimeGUI());

            //Commands
            getCommand("faq").setExecutor(new FaqCommand());
            getCommand("spawn").setExecutor(new SpawnCommand());
            getCommand("fly").setExecutor(new FlyCommand());
            getCommand("gmc").setExecutor(new CreativeCommand());
            getCommand("store").setExecutor(new StoreCommand());
            getCommand("rules").setExecutor(new RulesCommand());
            getCommand("gms").setExecutor(new SurvivalCommand());
            getCommand("gmsp").setExecutor(new SpectatorCommand());
            getCommand("gma").setExecutor(new AdventureCommand());
            getCommand("setspawn").setExecutor(new SetSpawnCommand());

            //Events
            getServer().getPluginManager().registerEvents(new JoinMessageListener(), this);
            getServer().getPluginManager().registerEvents(new ChatSystem(), this);
            //getServer().getPluginManager().registerEvents(new NoBreakEvent(), this);
            getServer().getPluginManager().registerEvents(new GmGUI(), this);
            getServer().getPluginManager().registerEvents(new ItemChat(), this);
            getServer().getPluginManager().registerEvents(new TimeGUI(), this);
            getServer().getPluginManager().registerEvents(new ChatSystem(), this);
           // getServer().getPluginManager().registerEvents(new NoPlaceEvent(), this);


            File co = new File(getDataFolder(), "config.yml");
            if(!co.exists()) saveResource("config.yml", false);

            try{
                this.conf.load(co);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onDisable() {}

        public YamlConfiguration getConf() { return this.conf; }
}