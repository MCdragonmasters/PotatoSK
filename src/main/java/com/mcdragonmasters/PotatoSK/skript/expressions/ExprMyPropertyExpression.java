//package com.mcdragonmasters.PotatoSK.skript.expressions;
//
//import com.mcdragonmasters.PotatoSK.utils.types.MyType;
//
//import org.bukkit.event.Event;
//
//import ch.njol.skript.classes.Changer.ChangeMode;
//import ch.njol.skript.doc.Description;
//import ch.njol.skript.doc.Examples;
//import ch.njol.skript.doc.Name;
//import ch.njol.skript.doc.Since;
//import ch.njol.skript.expressions.base.SimplePropertyExpression;
//
//// Documentation
//@Name("My Property Expression")
//@Description("My awesome property expression just for you!")
//@Examples({ "set type name of {_type} to \"hello\"" })
//@Since("0.1.0")
//
//public class ExprMyPropertyExpression extends SimplePropertyExpression<MyType, String> {
//
//    static {
//        register(ExprMyPropertyExpression.class, String.class,
//            "type name", "mytype"
//        );
//    }
//
//    @Override
//    public String convert(MyType type) {
//        return type.getName();
//    }
//
//    @Override
//    public Class<?>[] acceptChange(ChangeMode mode) {
//        if (mode == ChangeMode.SET) {
//            return new Class[]{ String.class };
//        }
//        return new Class[0];
//    }
//
//    @Override
//    public void change(Event e, Object[] delta, ChangeMode mode) {
//        MyType type = getExpr().getSingle(e);
//        type.setName((String) delta[0]);
//    }
//
//    @Override
//    public Class<? extends String> getReturnType() {
//        return String.class;
//    }
//
//    @Override
//    protected java.lang.String getPropertyName() {
//        return "type name";
//    }
//
//}
