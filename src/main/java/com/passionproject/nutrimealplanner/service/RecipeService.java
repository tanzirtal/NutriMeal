package com.passionproject.nutrimealplanner.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passionproject.nutrimealplanner.exception.RecipesNotFoundException;
import com.passionproject.nutrimealplanner.model.Recipe;
import com.passionproject.nutrimealplanner.repository.RecipeRepo;
//import com.passionproject.nutrimealplanner.service.client.CalorieNinjasApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    private final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    public Recipe createRecipe(Recipe recipe){

        recipe.setIngredients(recipe.getIngredients());
        recipe.setServings(recipe.getServings());
        recipe.setTitle(recipe.getTitle());
        recipe.setId(recipe.getId());
        recipe.setInstructions(recipe.getInstructions());

        logger.info("Recipe successfully created.");
        return recipeRepo.save(recipe);

    }

    public Iterable<Recipe> getAllRecipes(){
        List<Recipe> recipes = recipeRepo.findAll();
        if(recipes.isEmpty()){
            logger.error("List of recipes is empty");
            throw new RecipesNotFoundException("List of recipes is empty");
        }
        logger.info("All recipes successfully retrieved");

        return recipeRepo.findAll();
    }

    public Recipe getRecipeById(Long recipeId){
        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow(()-> {
            logger.error("Recipe with ID: " + recipeId + " not found.");
            throw new RecipesNotFoundException("Error fetching recipe.");
        });
        logger.info("Recipe successfully retrieved");
        return recipe;
    }

    public Recipe updateRecipe(Long recipeId, Recipe updatedRecipe){
        Recipe existingRecipe = getRecipeById(recipeId);

        existingRecipe.setInstructions(updatedRecipe.getInstructions());
        existingRecipe.setTitle(updatedRecipe.getTitle());
        existingRecipe.setIngredients(updatedRecipe.getIngredients());
        existingRecipe.setServings(updatedRecipe.getServings());

        logger.info("Recipe successfully updated");
        recipeRepo.save(existingRecipe);
        return existingRecipe;
    }

    public void deleteRecipe(Long recipeId){
        Recipe recipeToDelete = getRecipeById(recipeId);
        logger.info("Recipe successfully deleted");
        recipeRepo.delete(recipeToDelete);
    }


}
