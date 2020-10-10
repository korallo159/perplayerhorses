package koral.horseplugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.event.entity.EntityMountEvent;

import java.io.File;

public final class HorsePlugin extends JavaPlugin {

 private HorsePluginCommands commandExecutor;
 private HorsePluginListener Listener;
    @Override
    public void onEnable() {
        File file = new File(getDataFolder() + File.separator + "config.yml");
        if (!file.exists()) {
            saveDefaultConfig();;
        } else {
            saveDefaultConfig();
            reloadConfig();
        }
        this.Listener = new HorsePluginListener(this);
        getServer().getPluginManager().registerEvents(Listener, this);
        this.commandExecutor = new HorsePluginCommands(this);
        this.getCommand("wierzchowiecvip").setExecutor(this.commandExecutor);
        this.getCommand("wierzchowiecmvip").setExecutor(this.commandExecutor);
        this.getCommand("kon1").setExecutor(this.commandExecutor);
        this.getCommand("kon2").setExecutor(this.commandExecutor);
        this.getCommand("kon3").setExecutor(this.commandExecutor);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
