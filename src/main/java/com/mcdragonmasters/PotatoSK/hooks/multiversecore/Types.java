package com.mcdragonmasters.PotatoSK.hooks.multiversecore;

import ch.njol.skript.Skript;
import ch.njol.skript.registrations.Classes;
import com.mcdragonmasters.PotatoSK.utils.EnumWrapper;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;

public class Types {
    static {
        if (Skript.classExists("org.bukkit.WorldType") && Classes.getExactClassInfo(WorldType.class) == null) {
            EnumWrapper<WorldType> WORLDTYPE_ENUM = new EnumWrapper<>(WorldType.class);
            Classes.registerClass(WORLDTYPE_ENUM.getClassInfo("environment")
                    .user("world ?types?")
                    .name("World Type")
                    .description("All the World Types.") // add example
                    .since("1.0.1"));
        }
        if (Skript.classExists("org.bukkit.World.Environment") && Classes.getExactClassInfo(Environment.class) == null) {
            EnumWrapper<Environment> ENVIRONMENT_ENUM = new EnumWrapper<>(Environment.class);
            Classes.registerClass(ENVIRONMENT_ENUM.getClassInfo("environment")
                    .user("world ?environments?")
                    .name("World Environment")
                    .description("All the World Environments.") // add example
                    .since("1.0.1"));
        }
    }
}