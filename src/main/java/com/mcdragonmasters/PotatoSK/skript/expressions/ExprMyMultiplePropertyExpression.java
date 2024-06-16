//package com.mcdragonmasters.PotatoSK.skript.expressions;
//
//import com.mcdragonmasters.PotatoSK.utils.skript.MultiplePropertyExpression;
//import com.mcdragonmasters.PotatoSK.utils.types.MyType;
//
//import org.bukkit.event.Event;
//
//import ch.njol.skript.classes.Changer.ChangeMode;
//import ch.njol.skript.doc.Description;
//import ch.njol.skript.doc.Examples;
//import ch.njol.skript.doc.Name;
//import ch.njol.skript.doc.Since;
//
//// Documentation
//@Name("My Multiple Property Expression")
//@Description("My awesome multiple property expression just for you!")
//@Examples({ "set type contents of {_type} to \"hello\"" })
//@Since("0.1.0")
//
//public class ExprMyMultiplePropertyExpression extends MultiplePropertyExpression<MyType, String> {
//
//    static {
//        register(ExprMyMultiplePropertyExpression.class, String.class,
//            "type contents", "mytype"
//        );
//    }
//
//    @Override
//    public String[] convert(MyType type) {
//        return type.getContents().toArray(new String[0]);
//    }
//
//    @Override
//    public Class<?>[] acceptChange(ChangeMode mode) {
//        if (mode == ChangeMode.ADD || mode == ChangeMode.SET) {
//            return new Class[]{ String.class };
//        }
//        return new Class[0];
//    }
//
//    @Override
//    public void change(Event e, Object[] delta, ChangeMode mode) {
//        MyType type = getExpr().getSingle(e);
//        for (Object o : delta) {
//            String word = (String) o;
//            switch (mode) {
//                case SET:
//                    type.getContents().clear();
//                    break;
//                case ADD:
//                    type.addContent(word);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    @Override
//    public Class<? extends String> getReturnType() {
//        return String.class;
//    }
//
//    @Override
//    protected java.lang.String getPropertyName() {
//        return "type contents";
//    }
//
//}
