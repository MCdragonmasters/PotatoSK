//package com.mcdragonmasters.PotatoSK.skript.events.bukkit;
//
//import com.mcdragonmasters.PotatoSK.PotatoSK;
//
//import org.bukkit.Bukkit;
//import org.bukkit.event.Event;
//import org.bukkit.event.HandlerList;
//import org.bukkit.event.Listener;
//
//public class MyEventBukkit extends Event implements Listener {
//
//    public static final HandlerList handlers = new HandlerList();
//
//    // Need this for the event loader in the Main class
//    public MyEventBukkit() { }
//
//    // You should replace "Object" with a specific type
//    public MyEventBukkit(Object event) {
//        // Get your values from your event here
//        // ===============
//        // HERE
//        // ===============
//        // Execute the event asynchronously
//        Bukkit.getScheduler().runTask(PotatoSK.instance, () -> Bukkit.getPluginManager().callEvent(this));
//    }
//
//    public static HandlerList getHandlerList() {
//        return handlers;
//    }
//
//    @Override
//    public HandlerList getHandlers() {
//        return handlers;
//    }
//
//    // You should create getters below this
//
//}