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
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;
import java.util.ArrayList;

public class GmGUI implements CommandExecutor, Listener {

    // Open Gui Command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


            Inventory GMSLGUI = Bukkit.createInventory(null, 9, ChatColor.of(new Color(69, 72, 77)) + "Gamemode Selector");

            // SetItems
            ItemStack gmc = new ItemStack(Material.ORANGE_STAINED_GLASS, 1);
            ItemStack gms = new ItemStack(Material.LIME_STAINED_GLASS, 1);
            ItemStack gmsp = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1);
            ItemStack gma = new ItemStack(Material.RED_STAINED_GLASS, 1);


            ItemMeta gmc_meta = gmc.getItemMeta();
            gmc_meta.setDisplayName(ChatColor.of(new Color(169, 45, 81)) + "CREATIVE");
            ArrayList<String> gmc_lore = new ArrayList<>();
            gmc_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change your gamemode to Creative!");
            gmc_meta.setLore(gmc_lore);
            gmc.setItemMeta(gmc_meta);

            ItemMeta gmsp_meta = gmsp.getItemMeta();
            gmsp_meta.setDisplayName(ChatColor.of(new Color(169, 45, 81)) + "SPECTATOR");
            ArrayList<String> gmsp_lore = new ArrayList<>();
            gmsp_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change your gamemode to Spectator!");
            gmsp_meta.setLore(gmsp_lore);
            gmsp.setItemMeta(gmsp_meta);

            ItemMeta gms_meta = gms.getItemMeta();
            gms_meta.setDisplayName(ChatColor.of(new Color(169, 45, 81)) + "SURVIVAL");
            ArrayList<String> gms_lore = new ArrayList<>();
            gms_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change your gamemode to Survival!");
            gms_meta.setLore(gms_lore);
            gms.setItemMeta(gms_meta);

            ItemMeta gma_meta = gma.getItemMeta();
            gma_meta.setDisplayName(ChatColor.of(new Color(169, 45, 81)) + "ADVENTURE");
            ArrayList<String> gma_lore = new ArrayList<>();
            gma_lore.add(ChatColor.of(new Color(130, 139, 147)) + "Change your gamemode to Adventure!");
            gma_meta.setLore(gma_lore);
            gma.setItemMeta(gma_meta);

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
            GMSLGUI.setItem(1, gms);
            GMSLGUI.setItem(3, gmc);
            GMSLGUI.setItem(5, gmsp);
            GMSLGUI.setItem(7, gma);

            player.openInventory(GMSLGUI);


        }
        return false;}




    @EventHandler
    public void GamemodeSelector(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of(new Color(69, 72, 77)) + "Gamemode Selector") && event.getCurrentItem() != null) {

            if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT == ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().setGameMode(GameMode.ADVENTURE);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed your gamemode to: " + ChatColor.of(new Color(169, 45, 81)) + "ADVENTURE");
                }
                else{
                    event.setCancelled(true);}}

                if (event.getCurrentItem().getType() == Material.ORANGE_STAINED_GLASS) {
                    if (event.getClick().equals(ClickType.RIGHT == ClickType.LEFT)) {
                        ItemMeta meta = event.getCurrentItem().getItemMeta();
                        event.getWhoClicked().setGameMode(GameMode.CREATIVE);
                        event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed your gamemode to: " + ChatColor.of(new Color(169, 45, 81)) + "CREATIVE");
                    }
                    else{
                        event.setCancelled(true);}}


                if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS) {
                        if (event.getClick().equals(ClickType.RIGHT == ClickType.LEFT)) {
                            ItemMeta meta = event.getCurrentItem().getItemMeta();
                            event.getWhoClicked().setGameMode(GameMode.SURVIVAL);
                            event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed your gamemode to: " + ChatColor.of(new Color(169, 45, 81)) + "SURVIVAL");
                        }else{
                    event.setCancelled(true);}}


            if (event.getCurrentItem().getType() == Material.LIGHT_GRAY_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT == ClickType.LEFT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().setGameMode(GameMode.SPECTATOR);
                    event.getWhoClicked().sendMessage(ChatColor.of(new Color(130, 139, 147)) + "You changed your gamemode to: " + ChatColor.of(new Color(169, 45, 81)) + "SPECTATOR");
                }
            }

                else {

        }
        event.setCancelled(true);}}

    }




