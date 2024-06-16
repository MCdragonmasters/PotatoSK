package com.mcdragonmasters.PotatoSK.skript.effects;

import ch.njol.skript.lang.VariableString;
import ch.njol.skript.util.StringMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.util.Kleenean;
import org.jetbrains.annotations.NotNull;

import static com.mcdragonmasters.PotatoSK.PotatoSK.instance;


// Documentation
@Name("Command With Permission")
@Description("Make a Player execute a command with a permission")
@Examples({ "make player execute command \"/op %player%\" with permission \"minecraft.command.op\"",
        "#Supports multiple commands",
        "make player execute commands (\"/gamemode survival\" and \"/op %player%\") with permissions (\"minecraft.command.gamemode\" and \"minecraft.command.op\")" })
@Since("1.0.0")

@SuppressWarnings({"unused", "RedundantSuppression", "deprecation"})
public class EffCommandWithPermission extends Effect{

    static {
        Skript.registerEffect(EffCommandWithPermission.class,
                "[execute] %players% command[s] %strings% with permission[s] %strings%",
                "(let|make) %players% execute [command[s]] %strings% with permission[s] %strings%"
        );
    }
    private Expression<String> commands;
    private Expression<String> perms;
    private Expression<Player> players;

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull ParseResult parseResult) {
        players = (Expression<Player>) exprs[0];
        commands = (Expression<String>) exprs[1];
        perms = (Expression<String>) exprs[2];
        commands = VariableString.setStringMode(commands, StringMode.COMMAND);
        return true;
    }
    @Override
    protected void execute(@NotNull Event e) {
        for (String command : commands.getArray(e)) {
            assert command != null;
            if (command.startsWith("/"))
                command = command.substring(1);
            if (players != null) {
                for (Player player : players.getArray(e)) {
                    for (String perm : perms.getArray(e)) {
                        assert perm != null;
                        player.addAttachment(instance, perm, true, 1);
                    }
                    assert player != null;
                    player.performCommand(command);

                }
            }
        }
    }






    @Override
    public @NotNull String toString(Event e, boolean debug) {
        return "make " + players.toString(e, debug) + " execute command " + commands.toString(e, debug);
    }

}

