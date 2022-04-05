package com.metaxcrew.acticoreplus.ScoreBoards;

import com.metaxcrew.acticoreplus.ActiCorePlus;
import fr.mrmicky.fastboard.FastBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreBoard implements Listener {

    private final Map<UUID, FastBoard> boards = new HashMap<>();

    public ScoreBoard() {
        Bukkit.getServer().getScheduler().runTaskTimer(ActiCorePlus.getInstance(), () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }

    @EventHandler

    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        FastBoard lobbysb = new FastBoard(player);

        lobbysb.updateTitle(ChatColor.of("#0162F5") + "" + ChatColor.BOLD + "ActiCraft");

        this.boards.put(player.getUniqueId(), lobbysb);


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard lobbysb = this.boards.remove(player.getUniqueId());

        if (lobbysb != null) {
            lobbysb.delete();
        }

    }


    private void updateBoard(FastBoard lobbysb) {
        lobbysb.updateLines(
                "",
                ChatColor.of("#4076C9")+""+ChatColor.BOLD + "Flight:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#709DE0") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%player_allow_flight%"),
                "",
                ChatColor.of("#4076C9")+""+ChatColor.BOLD + "MysteryBoxes:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#709DE0") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%gadgetsmenu_mystery_boxes%"),
                "",
                ChatColor.of("#4076C9")+""+ChatColor.BOLD + "MysteryDust:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#709DE0") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%gadgetsmenu_mystery_dust%"),
                "",
                ChatColor.of("#0162F5") + "" + ChatColor.BOLD + "play.acticraft.net");


        ;
    }
}