//package com.mcdragonmasters.PotatoSK.skript.effects;
//
//import org.bukkit.event.Event;
//
//import ch.njol.skript.Skript;
//import ch.njol.skript.doc.Description;
//import ch.njol.skript.doc.Examples;
//import ch.njol.skript.doc.Name;
//import ch.njol.skript.doc.Since;
//import ch.njol.skript.lang.Effect;
//import ch.njol.skript.lang.Expression;
//import ch.njol.skript.lang.SkriptParser.ParseResult;
//import ch.njol.util.Kleenean;
//
//// Documentation
//@Name("My Effect")
//@Description("My awesome effect just for you!")
//@Examples({ "my effect" })
//@Since("0.1.0")
//
//public class EffMyEffect extends Effect {
//
//    static {
//        Skript.registerEffect(EffMyEffect.class,
//            "my effect"
//        );
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
//        return true;
//    }
//
//    @Override
//    protected void execute(Event e) {
//        System.out.println("Hello my effect!");
//    }
//
//    @Override
//    public String toString(Event e, boolean debug) {
//        return "my effect"; // In case of using a variable, use your variable as "yourvariable.toString(e, debug)"
//    }
//
//}
