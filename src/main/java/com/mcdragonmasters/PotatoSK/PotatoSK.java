package com.mcdragonmasters.PotatoSK;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.bstats.bukkit.Metrics;
import ch.njol.skript.bstats.charts.SimplePie;
import com.mcdragonmasters.PotatoSK.utils.PotatoUtils;
import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@SuppressWarnings({"unused", "RedundantSuppression", "deprecation"})
public class PotatoSK extends JavaPlugin {

    public static PotatoSK instance;
    public static FileConfiguration config;
    public static MVWorldManager MVWorldManager;
    private static Metrics metrics;
    private static final String prefix = net.md_5.bungee.api.ChatColor.of("#40ff00")
            + "[PotatoSK] " + ChatColor.RESET;
    SkriptAddon addon;

    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        Metrics metrics = new Metrics(this, 22275);
        instance = this;

        try {
            addon = Skript.registerAddon(this);
            addon.loadClasses("com.mcdragonmasters.PotatoSK.skript");
            //registerHook("WorldEdit", "WorldEdit");
            registerHook("Multiverse-Core", "MultiverseCore");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        metrics.addCustomChart(new SimplePie("skript_version", () -> Skript.getVersion().toString()));
        Logger.success("PotatoSK has been enabled!");

        //PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new JoinLeave(), this);
    }
    public void registerHook(@NotNull String name, @NotNull String plugin) throws IOException {
        if (Bukkit.getServer().getPluginManager().isPluginEnabled(name) && config.getBoolean(plugin.toLowerCase()+"-hook", true)) {
            addon.loadClasses("com.mcdragonmasters.PotatoSK.hooks."+plugin.toLowerCase());
            if (plugin.equals("MultiverseCore")) {
                MVWorldManager = ((MultiverseCore) PotatoUtils.getPluginInstance("Multiverse-Core")).getMVWorldManager();
            }
            Logger.success(name+" hook loaded!");
        } else {
            Logger.error(name+" hook not loaded.");
        }
    }
    public static Plugin getInstance() {
        return instance;
    }
    public static MVWorldManager getMVWorldManager() {
        return MVWorldManager;
    }
    public static class Logger{
        static ConsoleCommandSender console = Bukkit.getConsoleSender();
        public static void success(String message){
            console.sendMessage(prefix + ChatColor.GREEN + message);
        }

        public static void log(String message){
            console.sendMessage(prefix + ChatColor.WHITE + message);
        }

        public static void warn(String message){
            console.sendMessage(prefix + ChatColor.YELLOW + message);
        }

        public static void error(String message){
            console.sendMessage(prefix + ChatColor.RED + message);
        }
    }
}
