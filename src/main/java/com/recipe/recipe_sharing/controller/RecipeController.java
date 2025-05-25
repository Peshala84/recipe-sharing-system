package com.recipe.recipe_sharing.controller;

import com.recipe.recipe_sharing.model.Recipe;
import com.recipe.recipe_sharing.model.User;
import com.recipe.recipe_sharing.service.RecipeService;
import com.recipe.recipe_sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
   private UserService userService;
     @PostMapping("api/recipe/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe , @PathVariable Long userId) throws Exception {

         User user = userService.findUserById(userId);

        Recipe createdRecipe = recipeService.createRecipe(recipe , user);
        return createdRecipe;
    }
    @PutMapping("api/recipe/user/{userId}")
    public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);

        Recipe createdRecipe = recipeService.createRecipe(recipe , user);
        return createdRecipe;
    }
    @GetMapping("api/recipe")
    public List<Recipe> getAllRecipe() throws Exception {

        List<Recipe> recipes = recipeService.findAllRecipe();
        return recipes;
    }
    @DeleteMapping("api/recipe/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

       recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }
}
