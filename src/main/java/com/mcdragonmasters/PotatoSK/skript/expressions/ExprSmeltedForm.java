package com.mcdragonmasters.PotatoSK.skript.expressions;


import ch.njol.skript.Skript;
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.bukkitutil.BurgerHelper;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.ExpressionType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

// code stolen from Skirt, which is no longer maintained,
// so it's here so that there is a up to date addon
// with this feature
@Name("ItemType - Smelted Form")
@Description("returns smelt result of items, returns the same item if it cannot be smelted")
@Examples({"on mine:",
        "\tgive player (smelted (drops of event-block using (player's tool)))"})
@Since("1.0.0")

@SuppressWarnings("unused")
public class ExprSmeltedForm extends SimplePropertyExpression<ItemType, ItemType> {

    static {
        Skript.registerExpression(ExprSmeltedForm.class, ItemType.class, ExpressionType.PROPERTY,
                "smelt[ed] [(result|form) of] %itemtypes%",
                "%itemtypes%'[s] smelted [(result|form)]",
                "%itemtypes% smelted");
    }

    @SuppressWarnings("deprecation")
    private ItemStack smelted(ItemStack item) {
        Material type = item.getType();
        for (@NotNull Iterator<Recipe> it = Bukkit.recipeIterator(); it.hasNext(); ) {
            if (it.next() instanceof FurnaceRecipe recipe){
                Material ingredient = recipe.getInput().getType();
                if (type == ingredient){
                    ItemStack result = item.clone();
                    result.setType(recipe.getResult().getType());
                    return result;
                }
            }
        }
        return item;
    }

    @Override
    public @NotNull Class<? extends ItemType> getReturnType() {
        return ItemType.class;
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "smelted form";
    }

    @Nullable
    @Override
    public ItemType convert(ItemType itemType) {
        return new ItemType(smelted(itemType.getRandom()));
    }
}