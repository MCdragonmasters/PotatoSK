//package com.mcdragonmasters.PotatoSK.skript;
//
//import com.mcdragonmasters.PotatoSK.utils.types.MyType;
//
//import ch.njol.skript.classes.ClassInfo;
//import ch.njol.skript.classes.Parser;
//import ch.njol.skript.expressions.base.EventValueExpression;
//import ch.njol.skript.lang.ParseContext;
//import ch.njol.skript.registrations.Classes;
//
//public class Types {
//
//	static {
//
//		Classes.registerClass(new ClassInfo<>(MyType.class, "mytype")
//			.defaultExpression(new EventValueExpression<>(MyType.class))
//			.user("mytype")
//			.name("My Type!")
//			.description("This is my type.")
//			.since("0.1.0")
//			.parser(new Parser<MyType>() {
//
//				@Override
//				public String getVariableNamePattern() {
//					return ".+";
//				}
//
//				@Override
//				public MyType parse(String id, ParseContext arg1) {
//					return null; // x parsed as mytype
//				}
//
//				@Override
//				public String toString(MyType MyType, int arg1) {
//					return MyType.getName(); // send "%mytype%"
//				}
//
//				@Override
//				public String toVariableNameString(MyType MyType) {
//					return MyType.getName(); // set {players::%player%::%mytype%} to "hello type"
//				}
//
//            }));
//
//    }
//
//}