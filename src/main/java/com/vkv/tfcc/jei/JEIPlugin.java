package com.vkv.tfcc.jei;

import com.vkv.tfcc.TFCCompat;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

@mezz.jei.api.JeiPlugin
public class JEIPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(TFCCompat.MODID, "jei_plugin");
    private static final Map<IRecipeRegistration, Set<ResourceLocation>> REGISTERED_RECIPE_IDS = new WeakHashMap<>();

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var connection = Minecraft.getInstance().getConnection();
        if (connection == null) return;

        Set<ResourceLocation> registeredIds = REGISTERED_RECIPE_IDS.computeIfAbsent(registration, key -> new HashSet<>());

        List<CraftingRecipe> tfccRecipes = connection.getRecipeManager()
                .getAllRecipesFor(RecipeType.CRAFTING)
                .stream()
                .filter(recipe -> recipe.getId().getNamespace().equals(TFCCompat.MODID))
                .filter(recipe -> registeredIds.add(recipe.getId()))
                .toList();

        if (!tfccRecipes.isEmpty()) {
            registration.addRecipes(RecipeTypes.CRAFTING, tfccRecipes);
        }
    }
}
