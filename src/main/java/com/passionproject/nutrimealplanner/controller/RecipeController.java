package com.passionproject.nutrimealplanner.controller;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.Recipe;
import com.passionproject.nutrimealplanner.response.RecipeResponse;
import com.passionproject.nutrimealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
public class RecipeController {

    @Autowired
    private RecipeResponse recipeResponse;

    @PostMapping("/recipes")
    public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe){
        return recipeResponse.createRecipe(recipe);
    }

    @GetMapping("/recipes")
    public ResponseEntity<?> getAllRecipes(){
        return recipeResponse.getAllRecipes();
    }

    @GetMapping("/recipes/{recipeId}")
    public ResponseEntity<?> getRecipeById(@PathVariable Long recipeId){
        return recipeResponse.getRecipeById(recipeId);
    }

    @PutMapping("/recipes/{recipeId}")
    public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe, @PathVariable Long recipeId){
        return recipeResponse.updateRecipe(recipe, recipeId);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long recipeId){
        return recipeResponse.deleteRecipe(recipeId);
    }
}
