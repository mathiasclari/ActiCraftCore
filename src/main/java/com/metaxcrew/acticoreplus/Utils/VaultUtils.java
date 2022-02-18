package com.metaxcrew.acticoreplus.Utils;

import com.metaxcrew.acticoreplus.ActiCorePlus;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultUtils implements Listener {
    private static boolean vaultEnabled = false;
    private static Permission permission;
    private static Chat chat;

    /**
     * Get vaultEnabled.
     * @return vaultEnabled.
     */
    public static boolean isVaultEnabled() {
        return vaultEnabled;
    }

    /**
     * Enable vault.
     */
    public static void enableVault() {
        vaultEnabled = true;
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServicesManager().getRegistration(Permission.class);
        permission = rsp.getProvider();
        RegisteredServiceProvider<Chat> chatProvider = ActiCorePlus.instance.getServer().getServicesManager().getRegistration(Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        if(null == permission || null == chat) System.out.println("No vault found");
    }

    public static Permission getPermission() { return permission; }

    public static Chat getChat() { return chat; }
}
