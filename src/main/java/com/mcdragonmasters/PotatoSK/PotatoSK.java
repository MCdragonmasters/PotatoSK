package com.mcdragonmasters.PotatoSK;

import java.io.IOException;

import com.mcdragonmasters.PotatoSK.utils.PackageLoader;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.olyno.skriptmigrate.SkriptMigrate;
import ch.njol.skript.bstats.bukkit.Metrics;
import ch.njol.skript.bstats.charts.SimplePie;
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

@SuppressWarnings({"unused", "RedundantSuppression", "deprecation"})
public class PotatoSK extends JavaPlugin {

    public static PotatoSK instance;
    public static FileConfiguration config;
    private static Metrics metrics;
    private static String prefix = net.md_5.bungee.api.ChatColor.of("#40ff00")
            + "[PotatoSK] " + ChatColor.RESET;
    SkriptAddon addon;

	public void onEnable() {

        instance = this;
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("com.mcdragonmasters.PotatoSK.skript");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Register Metrics
        Metrics metrics = new Metrics(this, 22275);

        metrics.addCustomChart(new SimplePie("skript_version", () -> Skript.getVersion().toString()));
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "PotatoSK has been enabled!");
//        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
//            player.sendMessage(prefix + "fr");
//        }
         //Register events
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new JoinLeave(), this);
        new PackageLoader<Listener>("com.mcdragonmasters.PotatoSK.skript.events.bukkit", "register bukkit events").getList()
                .thenAccept(events -> {
                    for (Listener evt : events) {
                        getServer().getPluginManager().registerEvents(evt, this);
                    }
                });

        // Setup migrations
        if (classExist()) {
			SkriptMigrate.load(this);
		}

        if (!getDataFolder().exists()) {
			saveDefaultConfig();
		}

		config = getConfig();

    }

    private boolean classExist() {
		try {
			Class.forName("com.olyno.skriptmigrate.SkriptMigrate");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

}
