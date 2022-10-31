package unmineraft.utils;

import org.bukkit.ChatColor;

public class StrEnchant {
    public static String applyColors(String plainString) {
        return ChatColor.translateAlternateColorCodes('&', plainString);
    }
}
