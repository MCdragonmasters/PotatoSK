//package com.author.PotatoSK.skript.expressions;
//
//import com.author.PotatoSK.utils.types.MyType;
//
//import org.bukkit.event.Event;
//
//import ch.njol.skript.Skript;
//import ch.njol.skript.doc.Description;
//import ch.njol.skript.doc.Examples;
//import ch.njol.skript.doc.Name;
//import ch.njol.skript.doc.Since;
//import ch.njol.skript.lang.Expression;
//import ch.njol.skript.lang.ExpressionType;
//import ch.njol.skript.lang.SkriptParser.ParseResult;
//import ch.njol.skript.lang.util.SimpleExpression;
//import ch.njol.util.Kleenean;
//
//// Documentation
//@Name("My Expression")
//@Description("My awesome expression just for you!")
//@Examples({ "set {_type} to new type" })
//@Since("0.1.0")
//
//public class ExprMyExpression extends SimpleExpression<MyType> {
//
//    static {
//        Skript.registerExpression(ExprMyExpression.class, MyType.class, ExpressionType.SIMPLE, "new type");
//    }
//
//    @Override
//    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
//        return true;
//    }
//
//    @Override
//    protected MyType[] get(Event e) {
//        return new MyType[] { new MyType() };
//    }
//
//    @Override
//    public boolean isSingle() {
//        return true;
//    }
//
//    @Override
//    public Class<? extends MyType> getReturnType() {
//        return MyType.class;
//    }
//
//    @Override
//    public String toString(Event e, boolean debug) {
//        return "new type";
//    }
//
//}
