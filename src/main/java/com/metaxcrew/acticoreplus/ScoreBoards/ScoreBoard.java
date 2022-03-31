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

        lobbysb.updateTitle(ChatColor.of("#DA1D1D") + "" + ChatColor.BOLD + "ActiCraft");

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
                ChatColor.of("#D54A4A")+""+ChatColor.BOLD + "Personal Stats:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "Fly: " + ChatColor.of("#E3BFBF") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%player_allow_flight%"),
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "Kills: " + ChatColor.of("#E3BFBF") + lobbysb.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "Deaths: " + ChatColor.of("#E3BFBF") + lobbysb.getPlayer().getStatistic(Statistic.DEATHS),
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "Coins: " + ChatColor.of("#E3BFBF") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%vault_eco_balance_fixed%"),
                "",
                ChatColor.of("#D54A4A")+""+ChatColor.BOLD + "SlimeFun Stats:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "XP spend: " + ChatColor.of("#E3BFBF") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%slimefun_researches_total_xp_levels_spent%xp"),
                ChatColor.of("#738291") + "» " + ChatColor.of("#D16666") + "Unlocked: " + ChatColor.of("#E3BFBF") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%slimefun_researches_percentage_researches_unlocked%%"),
                "",
                ChatColor.of("#DA1D1D") + "" + ChatColor.BOLD + "www.acticraft.net");


        ;
    }
}
