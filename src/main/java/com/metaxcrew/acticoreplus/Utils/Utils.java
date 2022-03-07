package com.metaxcrew.acticoreplus.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Utils {
    public static String chat (String s) {return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String toLocString(Location location) {
        String worldName = location.getWorld().getName();

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        float yaw = location.getYaw();
        float pitch = location.getPitch();

        return worldName+":"+x+":"+y+":"+z+":"+yaw+":"+pitch;
    }

    public static Location toStringLoc(String location) {
        Location loc = null;
        String[] parties = location.split(":");

        String worldName = parties[0];

        double x = Double.valueOf(parties[1]);
        double y = Double.valueOf(parties[2]);
        double z = Double.valueOf(parties[3]);
        float yaw = Float.valueOf(parties[4]);
        float pitch = Float.valueOf(parties[5]);

        loc = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);

        return loc;
    }
}