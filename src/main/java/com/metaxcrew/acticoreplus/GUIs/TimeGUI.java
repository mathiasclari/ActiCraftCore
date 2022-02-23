package com.metaxcrew.acticoreplus.GUIs;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class TimeGUI implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("acti.timegui")){


                Inventory TIMESGUI = Bukkit.createInventory(null, 9, ChatColor.of(new Color(69, 72, 77)) + "Time Selector");

                // SetItems
                ItemStack morning = new ItemStack(Material.YELLOW_STAINED_GLASS, 1);
                ItemStack  day = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
                ItemStack midnight = new ItemStack(Material.BLUE_STAINED_GLASS, 1);
                ItemStack night = new ItemStack(Material.ORANGE_STAINED_GLASS, 1);


                ItemMeta morning_meta = morning.getItemMeta();
                morning_meta.setDisplayName(ChatColor.of(new Color(241, 152, 35)) + "MORNING");
                ArrayList<String> morning_lore = new ArrayList<>();
                morning_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change world time to morning!");
                morning_meta.setLore(morning_lore);
                morning.setItemMeta(morning_meta);

                ItemMeta day_meta = day.getItemMeta();
                day_meta.setDisplayName(ChatColor.of(new Color(241, 152, 35)) + "Day");
                ArrayList<String> day_lore = new ArrayList<>();
                day_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change world time to day!");
                day_meta.setLore(day_lore);
                day.setItemMeta(day_meta);

                ItemMeta night_meta = night.getItemMeta();
                night_meta.setDisplayName(ChatColor.of(new Color(54, 45, 179)) + "NIGHT");
                ArrayList<String> night_lore = new ArrayList<>();
                night_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change world time to midnight!");
                night_meta.setLore(night_lore);
                night.setItemMeta(night_meta);

                ItemMeta midnight_meta = midnight.getItemMeta();
                night_meta.setDisplayName(ChatColor.of(new Color(54, 45, 179)) + "MIDNIGHT");
                ArrayList<String> midnight_lore = new ArrayList<>();
                midnight_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change world time to midnight!");
                midnight_meta.setLore(midnight_lore);
                midnight.setItemMeta(midnight_meta);


                String money = "%vault_eco_balance_fixed%";
                String playername = "%player_displayname%";


                money = PlaceholderAPI.setPlaceholders(player, money);
                playername = PlaceholderAPI.setPlaceholders(player, playername);

            /*ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta headmeta = (SkullMeta) head.getItemMeta();
            headmeta.setOwningPlayer(player);
            headmeta.setDisplayName(ChatColor.of(new Color(61, 145, 255))+""+ChatColor.BOLD+"PROFILE");
            ArrayList<String> profile_lore = new ArrayList<>();
            profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+sender.getName());
            profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Money: "+ ChatColor.of(new Color(224, 134, 0))+money+"$");
            headmeta.setLore(profile_lore);
            head.setItemMeta(headmeta);
            //Translate Head
*/

           /*ItemStack language = getSkull("https://textures.minecraft.net/texture/879e54cbe87867d14b2fbdf3f1870894352048dfecd962846dea893b2154c85");
            SkullMeta langhead = (SkullMeta) language.getItemMeta();
            langhead.setDisplayName(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+"LANGUAGE");
            language.setItemMeta(langhead);*/

                //Design
                TIMESGUI.setItem(2, morning);
                TIMESGUI.setItem(6, night);
                TIMESGUI.setItem(4, day);
                TIMESGUI.setItem(8, midnight);

                player.openInventory(TIMESGUI);


            }else{
                player.sendMessage(ChatColor.of(new Color(169, 45, 81)) + "You do not have required permissions to use this command!");
            }}
        return false;}




    @EventHandler
    public void GamemodeSelector(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of(new Color(69, 72, 77)) + "Time Selector") && event.getCurrentItem() != null) {

            if (event.getCurrentItem().getType() == Material.YELLOW_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().getWorld().setTime(0);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed world time to: " + ChatColor.of(new Color(0, 141, 183)) + "MORNING");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.ORANGE_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().getWorld().setTime(12000);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed world time to: " + ChatColor.of(new Color(0, 141, 183)) + "SUNSET");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().getWorld().setTime(1000);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed world time to: " + ChatColor.of(new Color(0, 141, 183)) + "DAY");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
            }

            if (event.getCurrentItem().getType() == Material.BLUE_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().getWorld().setTime(18000);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed world time to: " + ChatColor.of(new Color(0, 141, 183)) + "MIDNIGHT");
                    event.getWhoClicked().closeInventory();
                } else {
                    event.setCancelled(true);
                }
                event.setCancelled(true);}}

    }

}
