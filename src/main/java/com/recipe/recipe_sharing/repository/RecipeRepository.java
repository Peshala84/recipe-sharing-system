package com.recipe.recipe_sharing.repository;

import com.recipe.recipe_sharing.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
