package com.mcdragonmasters.PotatoSK;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PotatoUtils {
    public static void test(String msg) {
        sendMessage(fromMiniMessage("<rainbow>POTATOOOOOo"));
    }

    public static void sendMessage(@NotNull Component message, Player... players) {
        for (Player player : players) {
            player.sendMessage(message);
        }
    }

    public static Component fromMiniMessage(@NotNull String string) {
        return MiniMessage.miniMessage().deserialize(string);
    }
}

