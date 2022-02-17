package com.metaxcrew.acticoreplus.GUIs;

import org.bukkit.command.CommandExecutor;
import jdk.vm.ci.code.ValueUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;

public class ProfileGui implements CommandExecutor, Listener{

    // Open Gui Command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Inventory PlayerMenuGUI = Bukkit.createInventory(null, 54, ChatColor.of(new Color(61, 210, 255))+"DeluxeShop Menu");

            // SetItems
            ItemStack fav = new ItemStack(Material.RED_STAINED_GLASS,1);
            ItemStack aqua = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,1);
            ItemStack cyan = new ItemStack(Material.CYAN_STAINED_GLASS_PANE,1);
            ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
            ItemStack purple = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE,1);
            ItemStack magenta = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE,1);
            ItemStack pink = new ItemStack(Material.PINK_STAINED_GLASS_PANE,1);
            ItemStack shop = new ItemStack(Material.CHEST,1);
            ItemStack changelanguage = new ItemStack(Material.WRITTEN_BOOK,1);




            ItemMeta fav_meta = fav.getItemMeta();
            fav_meta.setDisplayName(ChatColor.of(new Color(255, 61, 61))+"Favourite");
            ArrayList<String> fav_lore = new ArrayList<>();
            fav_lore.add(ChatColor.of(new Color(130, 139, 147))+"Select your favourite Categrory/Item");
            fav_meta.setLore(fav_lore);
            fav.setItemMeta(fav_meta);

            String money = "%vault_eco_balance_fixed%";
            String playername = "%player_displayname%";



            money = PlaceholderAPI.setPlaceholders(player, money);
            playername = PlaceholderAPI.setPlaceholders(player, playername);

            ItemMeta bank_meta = shop.getItemMeta();
            bank_meta.setDisplayName(ChatColor.of(new Color(224, 134, 0))+""+ChatColor.BOLD+"SHOP");
            shop.setItemMeta(bank_meta);

            ItemMeta changelang = changelanguage.getItemMeta();
            changelang.setDisplayName(ChatColor.of(new Color(61, 145, 255))+""+ChatColor.BOLD+"LANGUAGE");
            changelanguage.setItemMeta(changelang);

            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta headmeta = (SkullMeta) head.getItemMeta();
            headmeta.setOwningPlayer(player);
            headmeta.setDisplayName(ChatColor.of(new Color(61, 145, 255))+""+ChatColor.BOLD+"PROFILE");
            ArrayList<String> profile_lore = new ArrayList<>();
            profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+sender.getName());
            profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Money: "+ ChatColor.of(new Color(224, 134, 0))+money+"$");
            headmeta.setLore(profile_lore);
            head.setItemMeta(headmeta);
            //Translate Head


           /*ItemStack language = getSkull("https://textures.minecraft.net/texture/879e54cbe87867d14b2fbdf3f1870894352048dfecd962846dea893b2154c85");
            SkullMeta langhead = (SkullMeta) language.getItemMeta();
            langhead.setDisplayName(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+"LANGUAGE");
            language.setItemMeta(langhead);*/

            //Favourite Items
            PlayerMenuGUI.setItem(12, fav);
            PlayerMenuGUI.setItem(13, fav);
            PlayerMenuGUI.setItem(14, fav);
            PlayerMenuGUI.setItem(21, fav);
            PlayerMenuGUI.setItem(22, fav);
            PlayerMenuGUI.setItem(23, fav);
            //Design
            PlayerMenuGUI.setItem(0, aqua);
            PlayerMenuGUI.setItem(8, aqua);
            PlayerMenuGUI.setItem(9, cyan);
            PlayerMenuGUI.setItem(17, cyan);
            PlayerMenuGUI.setItem(18, blue);
            PlayerMenuGUI.setItem(26, blue);
            PlayerMenuGUI.setItem(27, purple);
            PlayerMenuGUI.setItem(35, purple);
            PlayerMenuGUI.setItem(36, magenta);
            PlayerMenuGUI.setItem(44, magenta);
            PlayerMenuGUI.setItem(45, pink);
            PlayerMenuGUI.setItem(53, pink);
            PlayerMenuGUI.setItem(38, head);
            PlayerMenuGUI.setItem(40, shop);
            PlayerMenuGUI.setItem(42, changelanguage);

            player.openInventory(PlayerMenuGUI);


        }

        return false;

    }

    @EventHandler
    public void HelpMenuAction(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of(new Color(61, 210, 255))+"DeluxeShop Menu") && event.getCurrentItem() != null) {

            if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS) {
                if (event.getClick().equals(ClickType.RIGHT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    event.getWhoClicked().sendMessage("Select your fav item!");
                }
            }else{

            }

            event.setCancelled(true);}}
}



