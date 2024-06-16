//package com.mcdragonmasters.PotatoSK.skript.events;
//
//import com.mcdragonmasters.PotatoSK.skript.events.bukkit.MyEventBukkit;
//
//import ch.njol.skript.Skript;
//import ch.njol.skript.lang.util.SimpleEvent;
//import ch.njol.skript.registrations.EventValues;
//import ch.njol.skript.util.Getter;
//
//public class EvtMyEvent {
//
//    static {
//        // It's a really fast event, you should look at the docs to make a better one: https://forums.skunity.com/wiki/creating-an-event/
//        Skript.registerEvent("My Event", SimpleEvent.class, MyEventBukkit.class,
//            "my event"
//        ).description("This is my event!")
//            .examples("on my event:", "\tbroadcast \"Hello My event!\"")
//            .since("0.1.0");
//
//        // You should replace "Object" with a specific type.
//        // This is for "event-yourtype"
//        EventValues.registerEventValue(MyEventBukkit.class, Object.class,
//            new Getter<Object, MyEventBukkit>() {
//                @Override
//                public Object get(MyEventBukkit e) {
//                    return e;
//                }
//            }, 0);
//
//    }
//
//}
