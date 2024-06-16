//package com.mcdragonmasters.PotatoSK.skript.effects;
//
//import org.bukkit.event.Event;
//
//import com.mcdragonmasters.PotatoSK.utils.skript.AsyncEffect;
//
//import ch.njol.skript.doc.Description;
//import ch.njol.skript.doc.Examples;
//import ch.njol.skript.doc.Name;
//import ch.njol.skript.doc.Since;
//import ch.njol.skript.lang.Expression;
//import ch.njol.skript.lang.SkriptParser.ParseResult;
//import ch.njol.util.Kleenean;
//
//// Documentation
//@Name("My Effect Async")
//@Description("My awesome async effect just for you!")
//@Examples({ "my effect async" })
//@Since("0.1.0")
//
//public class EffMyEffectAsync extends AsyncEffect {
//
//    static {
//        registerAsyncEffect(EffMyEffectAsync.class, "my async effect");
//    }
//
//    @Override
//    protected boolean initAsync(Expression<?>[] expr, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
//        return true;
//    }
//
//    @Override
//    protected void execute(Event e) {
//        System.out.println("Executing async effect...");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e1) { }
//        System.out.println("Finished to execute the async effect!");
//    }
//
//    @Override
//    public String toString(Event e, boolean debug) {
//        return "my async effect";
//    }
//
//}
