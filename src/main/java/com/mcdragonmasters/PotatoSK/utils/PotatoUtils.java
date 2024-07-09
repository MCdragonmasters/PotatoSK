package com.mcdragonmasters.PotatoSK.utils;

import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;

public class PotatoUtils {
public static boolean isWaterlogged(Block block) {
        if(block.getBlockData() instanceof Waterlogged wl) {
            return wl.isWaterlogged();
        } else {
            return false;
        }
    }
}

