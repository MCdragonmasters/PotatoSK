package com.mcdragonmasters.PotatoSK.utils;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.plugin.Plugin;

public class PotatoUtils {
    public static boolean isWaterlogged(Block block) {
        if(block.getBlockData() instanceof Waterlogged wl) {
            return wl.isWaterlogged();
        } else {
            return false;
        }
    }
    public static Plugin getPluginInstance(String plugin) {
        return Bukkit.getServer().getPluginManager().getPlugin(plugin);
        }

}

