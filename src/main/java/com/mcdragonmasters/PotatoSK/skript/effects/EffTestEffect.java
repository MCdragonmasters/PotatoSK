//package com.mcdragonmasters.PotatoSK.skript.effects;
//import ch.njol.skript.Skript;
//import ch.njol.skript.lang.Effect;
//import ch.njol.skript.lang.Expression;
//import ch.njol.skript.lang.SkriptParser;
//import ch.njol.util.Kleenean;
//import org.bukkit.event.Event;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import com.mcdragonmasters.PotatoSK.PotatoUtils;
//@SuppressWarnings("unused")
//public class EffTestEffect extends Effect {
//
//    static {
//        Skript.registerEffect(EffTestEffect.class,
//                "test all players with (msg|message) %string%"
//        );
//    }
//    private Expression<String> msg;
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, @NotNull SkriptParser.ParseResult parseResult) {
//        msg = (Expression<String>) exprs[0];
//        return true;
//    }
//    @Override
//    protected void execute(@NotNull Event e) {
//        String msg = this.msg.getSingle(e);
//        PotatoUtils.test(msg);
//            }
//
//    @Override
//    public @NotNull String toString(@Nullable Event event, boolean b) {
//        return "test all players";
//    }
//}
//
