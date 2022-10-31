package unmineraft.un_works;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import unmineraft.utils.StrEnchant;

import java.io.File;

public final class UN_Works extends JavaPlugin {
    public String version;
    public String name;
    private final FileConfiguration fileConfiguration = this.getConfig();

    private void updateMetaData() {
        String plainText = this.fileConfiguration.getString("pluginConfig.pluginDisplayName");
        if (plainText == null) {
            plainText = this.getDescription().getName();
        }
        this.name = StrEnchant.applyColors(plainText);
        this.version = StrEnchant.applyColors("&a" + this.getDescription().getVersion());
    }

    public void configRegister() {
        File config = new File(this.getDataFolder(), "config.yml");

        if (!config.exists()){
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }

    public void commandRegister() {
        PluginCommand mainCommand = this.getCommand("squidTimer");
        if (mainCommand != null) {
            return;
        }
    }

    @Override
    public void onEnable() {
        this.updateMetaData();

        String initPluginMessage = StrEnchant.applyColors(name + "&f has been enabled in the version: " + this.version);
        Bukkit.getConsoleSender().sendMessage(initPluginMessage);

        this.configRegister();
        this.commandRegister();
    }

    @Override
    public void onDisable() {
        String endPluginMessage = StrEnchant.applyColors(name + "&c has been disabled");
        Bukkit.getConsoleSender().sendMessage(endPluginMessage);
    }

    /* MockBukkit Test */
    public UN_Works() {
        super();
    }

    private UN_Works(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
}
