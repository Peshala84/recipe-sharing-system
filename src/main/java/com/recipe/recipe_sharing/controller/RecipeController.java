package com.recipe.recipe_sharing.controller;

import com.recipe.recipe_sharing.model.Recipe;
import com.recipe.recipe_sharing.model.User;
import com.recipe.recipe_sharing.service.RecipeService;
import com.recipe.recipe_sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
   private UserService userService;
     @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe , @RequestHeader("Authorization") String jwt) throws Exception {

         User user = userService.findUserByJwt(jwt);

        Recipe createdRecipe = recipeService.createRecipe(recipe , user);
        return createdRecipe;
    }
    @PutMapping("{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable Long id) throws Exception {

        Recipe UpdatedRecipe = recipeService.updateRecipe(recipe , id);
        return UpdatedRecipe;
    }
    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@PathVariable Long id , @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        Recipe UpdatedRecipe = recipeService.likeRecipe(id , user);
        return UpdatedRecipe;
    }
    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {

        List<Recipe> recipes = recipeService.findAllRecipe();
        return recipes;
    }
    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

       recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }
}
