package com.mcdragonmasters.PotatoSK.templates;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.doc.*;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

import me.neznamy.tab.api.nametag.UnlimitedNameTagManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.TabAPI;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

@Name("TAB - Player Unlimited NameTag")
@Description("Gets/Sets a Player's TAB unlimited nametag name")
@Examples({
        "send player's TAB unlimited nametag"
})
@Since("1.0.1")
@RequiredPlugins("TAB Below v5")

@SuppressWarnings("unused")
public class ExprTest extends PropertyExpression<Player, String> {

    static {
        register(ExprTest.class, String.class, "test", "players");
    }

    @Override
    protected String @NotNull [] get(@NotNull Event event, Player[] source) {
        List<Player> names = new ArrayList<>();
        for (Player player : source){
            names.add(player);

        }
        return names.toArray(String[]::new);
    }

    @Override
    public @NotNull Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event event, boolean debug) {
        return "player's test";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        setExpr((Expression<? extends Player>) exprs[0]);
        return true;
    }

    @Override
    public @Nullable Class<?> @NotNull [] acceptChange(Changer.@NotNull ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET){
            return CollectionUtils.array(String.class);
        }
        return null;
    }

    @Override
    public void change(@NotNull Event event, @Nullable Object @NotNull [] delta, Changer.@NotNull ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET){
            for (Player player : getExpr().getArray(event)){
                player.sendMessage(player + ": " + delta[0]);
            }
        }
    }
}