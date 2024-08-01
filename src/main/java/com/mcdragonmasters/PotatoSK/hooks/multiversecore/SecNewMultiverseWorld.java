package com.mcdragonmasters.PotatoSK.hooks.multiversecore;

import ch.njol.skript.Skript;
import ch.njol.skript.config.SectionNode;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.*;
import ch.njol.util.Kleenean;

import com.mcdragonmasters.PotatoSK.PotatoSK;

import com.onarandombox.MultiverseCore.api.MVWorldManager;

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
@Description("Creates a Multiverse Core world")
@Examples({
        "create a new multiverse-core world named \"test\":",
                "\tenvironment: normal # world environment, required",
                "\ttype: flat # world type, required",
                "\tgenerate structures: false # boolean optional",
                "\tseed: \"69\" # string, optional",
                "\tgenerator: \"VoidGen\" # string, optional",
                "\tadjust spawn: true # boolean, optional"
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
    private Expression<Boolean> adjust_spawn;
    private Expression<String> generator;
    private Boolean hasGenStruct;
    private Boolean hasAdjSpa;
    private Boolean hasSeed;
    private Boolean hasCustomGen;


    static {
        Skript.registerSection(SecNewMultiverseWorld.class,
                "create [a] [new] (multiverse[( |-)core]|mv) world (with name|named) %string%"
        );
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("environment", null, false, Environment.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("type", null, false, WorldType.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("seed", null, true, String.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("generate structures", null, true, Boolean.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("adjust spawn", null, true, Boolean.class));
        ENTRY_VALIDATOR.addEntryData(new ExpressionEntryData<>("generator", null, true, String.class));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult, @NotNull SectionNode sectionNode, @NotNull List<TriggerItem> triggerItems) {
        ENTRY_CONTAINER = ENTRY_VALIDATOR.build().validate(sectionNode);
        if (ENTRY_CONTAINER == null) return false;

        name = (Expression<String>) exprs[0];
        if (name == null) {
            return false;
        }

        // The world environment to be used, required
        environment = (Expression<Environment>) ENTRY_CONTAINER.getOptional("environment", false);
        if (environment == null) {
            return false;
        }

        // The world type to be used, required
        type = (Expression<WorldType>) ENTRY_CONTAINER.getOptional("type", false);
        if (type == null) {
            return false;
        }

        // seed
        seed = (Expression<String>) ENTRY_CONTAINER.getOptional("seed", false);

        // generate structures, optional
        generate_structures = (Expression<Boolean>) ENTRY_CONTAINER.getOptional("generate structures", false);

        // whether to adjust the world spawn, optional
        adjust_spawn = (Expression<Boolean>) ENTRY_CONTAINER.getOptional("adjust spawn", false);

        // The world generator to use, optional
        generator = (Expression<String>) ENTRY_CONTAINER.getOptional("generator", false);

        // Conditions
        hasGenStruct = generate_structures != null;
        hasSeed = seed != null;
        hasAdjSpa = adjust_spawn != null;
        hasCustomGen = generator != null;

        return true;
    }


    @Override
    protected @Nullable TriggerItem walk(@NotNull Event e) {
        ENTRY_CONTAINER.getSource().convertToEntries(-1, ":");
        execute(e);
        return super.walk(e, false);
    }

    private void execute(Event e) {

        MVWorldManager worldManager = PotatoSK.getMVWorldManager();

        worldManager.addWorld(
                name.getSingle(e), // The worldname
                environment.getSingle(e), // The overworld environment type.
                (hasSeed ? seed.getSingle(e) : null), // seed
                type.getSingle(e), // world type
                (hasGenStruct ? generate_structures.getSingle(e) : true), // generate structures
                (hasCustomGen ? generator.getSingle(e) : null), // generator
                (hasAdjSpa ? adjust_spawn.getSingle(e) : true) // adjust spawn
        );
    }


    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "create a new multiverse-core world named " + name.toString(e, debug);
    }
}