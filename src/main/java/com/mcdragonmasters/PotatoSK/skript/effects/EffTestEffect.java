package com.mcdragonmasters.PotatoSK.skript.effects;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.VariableString;
import ch.njol.skript.util.StringMode;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.mcdragonmasters.PotatoSK.PotatoSK.instance;
import com.mcdragonmasters.PotatoSK.PotatoUtils;

public class EffTestEffect extends Effect {

    static {
        Skript.registerEffect(EffTestEffect.class,
                "test all players with (msg|message) %string%"
        );
    }
    private Expression<String> msg;

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull SkriptParser.ParseResult parseResult) {
        return true;
    }
    @Override
    protected void execute(@NotNull Event e) {
        String msg = this.msg.getSingle(e);
        PotatoUtils.test(msg);
            }

    @Override
    public @NotNull String toString(@Nullable Event event, boolean b) {
        return "test all players";
    }
}

