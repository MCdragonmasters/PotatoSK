package com.mcdragonmasters.PotatoSK.skript.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.mcdragonmasters.PotatoSK.PotatoUtils;
import org.bukkit.block.Block;
import org.bukkit.event.Event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Name("Entity - Is Glowing")
@Description("Checks whether a player is glowing.")
@Examples({
        "if target block is waterlogged:"
})
@Since("1.6")
@SuppressWarnings("unused")
public class CondIsWaterlogged extends Condition {

    static{
        Skript.registerCondition(CondIsWaterlogged.class,
                "%blocks% (is|are) waterlogged",
                "%blocks% (isn't|is not|aren't|are not) glowing"
        );
    }

    private Expression<Block> blocks;
    private boolean is;

    @Override
    public boolean check(@NotNull Event event) {
        for (final Block block : blocks.getArray(event)){
            if (is){
                return PotatoUtils.isWaterlogged(block);
            }
            return !PotatoUtils.isWaterlogged(block);
        }
        return true;
    }

    @Override
    public @NotNull String toString(@Nullable Event event, boolean debug) {
        return blocks.toString(event, debug) + " is waterlogged";
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        blocks = (Expression<Block>) exprs[0];
        is = (matchedPattern == 0);
        return true;
    }
}