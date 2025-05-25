package com.recipe.recipe_sharing.service;

import com.recipe.recipe_sharing.model.Recipe;
import com.recipe.recipe_sharing.model.User;

import java.util.List;

public interface RecipeService {

    public  Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipeById(Long id) throws Exception;

    public  void deleteRecipe(Long id) throws  Exception;

    public  Recipe updateRecipe(Recipe recipe, Long id) throws Exception;

    public List<Recipe>findAllRecipe();

    public  Recipe likeRecipe(Long recipeId,User user) throws Exception;

}
