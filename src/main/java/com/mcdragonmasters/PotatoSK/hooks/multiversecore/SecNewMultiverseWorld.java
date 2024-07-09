package com.mcdragonmasters.PotatoSK.hooks.multiversecore;

import ch.njol.skript.Skript;
import ch.njol.skript.config.SectionNode;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.*;
import ch.njol.util.Kleenean;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.event.Event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.skriptlang.skript.lang.entry.EntryContainer;
import org.skriptlang.skript.lang.entry.EntryValidator;
import org.skriptlang.skript.lang.entry.util.ExpressionEntryData;

import java.util.List;

@Name("Create a New Multiverse World")
@Description("idk")
@Examples({
        "create [new] multiverse world named %string%:",
        "\turl: \"https://www.someurl.com\"",
        "\tmethod: \"GET\"",
        "",
        "http request builder stored in {_request}:",
        "\turl: \"https://www.someurl.com\"",
        "\tmethod: \"GET\"",
        "\tbody: \"some body\"",
})
@Since("1.0.1")
@RequiredPlugins("Multiverse-Core")
@SuppressWarnings("unused")
public class SecNewMultiverseWorld extends Section {

    private static final EntryValidator.EntryValidatorBuilder ENTRY_VALIDATOR = EntryValidator.builder();
    private static EntryContainer ENTRY_CONTAINER;
    private Expression<String> name;
    private Expression<Environment> environment;
    private Expression<WorldType> type;
    private Expression<String> seed;
    private Expression<Boolean> generate_structures;

    static {
        Skript.registerSection(SecNewMultiverseWorld.class,
                "create [a] [new] multiverse[( |-)core] world (with name|named) %string%"
        );
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("environment", null, false, Environment.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("type", null, false, WorldType.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("seed", null, true, String.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("generate structures", null, true, Boolean.class));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult, @NotNull SectionNode sectionNode, @NotNull List<TriggerItem> triggerItems) {
        ENTRY_CONTAINER = ENTRY_VALIDATOR.build().validate(sectionNode);
        if (ENTRY_CONTAINER == null) return false;
        this.environment = (Expression<Environment>) ENTRY_CONTAINER.getOptional("environment", false);
        if (this.environment == null) return false;
        type = (Expression<WorldType>) ENTRY_CONTAINER.getOptional("type", false);
        if (type == null) return false;
        seed = (Expression<String>) ENTRY_CONTAINER.getOptional("seed", false);
        generate_structures = (Expression<Boolean>) ENTRY_CONTAINER.getOptional("generate structures", false);
        name = (Expression<String>) exprs[0];
        if (name == null) return false;

        return true;
    }



    @Override
    protected @Nullable TriggerItem walk(@NotNull Event e) {
        ENTRY_CONTAINER.getSource().convertToEntries(-1, ":");
        execute(e);
        return super.walk(e, false);
    }

    private void execute(Event e) {
        if (Bukkit.getWorld(name.getSingle(e)) != null) return;
        MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        assert core != null;
        MVWorldManager worldManager = core.getMVWorldManager();

        worldManager.addWorld(
                name.getSingle(e), // The worldname
                environment.getSingle(e), // The overworld environment type.
                (seed != null ? seed.getSingle(e) : null), // The world seed. Any seed is fine for me, so we just pass null.
                type.getSingle(e), // Nothing special. If you want something like a flat world, change this.
                (generate_structures.getSingle(e) != null ? generate_structures.getSingle(e) : true), // This means we want to structures like villages to generator, Change to false if you don't want this.
                null // Specifies a custom generator. We are not using any, so we just pass null.
        );
    }


    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "idk TODO";
    }
}