package com.mcdragonmasters.PotatoSK.hooks.multiversecore;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.mcdragonmasters.PotatoSK.PotatoSK;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

@Name("Delete Multiverse World")
@Description("Deletes a Multiverse Core world")
@Examples({"delete mv world named \"test\""})
@Since("1.0.1")

@SuppressWarnings({"unused"})
public class EffDeleteMultiverseWorld extends Effect {

    static {
        Skript.registerEffect(EffDeleteMultiverseWorld.class,
                "delete (multiverse[( |-)core]|mv) world (with name|named) %string%"
        );
    }

    private Expression<String> worldName;
    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull ParseResult parseResult) {
        worldName = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    protected void execute(@NotNull Event e) {

        MVWorldManager worldManager = PotatoSK.getMVWorldManager();

        worldManager.deleteWorld(worldName.getSingle(e));

    }


    @Override
    public @NotNull String toString(Event e, boolean debug) {
        return "delete multiverse-core world named" + worldName.toString(e, debug);
    }

}

