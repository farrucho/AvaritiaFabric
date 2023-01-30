package net.farrucho.avaritia.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.farrucho.avaritia.Avaritia;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Avaritia.MOD_ID, ExtremeCraftingTableRecipe.Serializer.ID),
                ExtremeCraftingTableRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Avaritia.MOD_ID, ExtremeCraftingTableRecipe.Type.ID),
                ExtremeCraftingTableRecipe.Type.INSTANCE);
    }
}

