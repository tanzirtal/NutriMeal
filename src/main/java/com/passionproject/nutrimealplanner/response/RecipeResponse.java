package com.passionproject.nutrimealplanner.response;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.Recipe;
import com.passionproject.nutrimealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class RecipeResponse {

    @Autowired
    private RecipeService recipeService;

    public ResponseEntity<?> createRecipe(Recipe recipe) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepositURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{recipeId}").buildAndExpand(recipe.getId()).toUri();
        responseHeaders.setLocation(newDepositURI);

        Detail detail = new Detail();
        detail.setData(recipeService.createRecipe(recipe));
        detail.setCode(HttpStatus.CREATED.value());
        detail.setMessage("Recipe successfully created");

        return new ResponseEntity<>(detail, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllRecipes() {

        Detail detail = new Detail();
        detail.setData(recipeService.getAllRecipes());
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("Recipes successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> getRecipeById(Long recipeId) {

        Detail detail = new Detail();
        detail.setData(recipeService.getRecipeById(recipeId));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("Recipe successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> updateRecipe(Recipe recipe, Long recipeId) {

        Detail detail = new Detail();
        recipeService.updateRecipe(recipeId, recipe);
        detail.setCode(HttpStatus.ACCEPTED.value());
        detail.setMessage("Recipe successfully updated");

        return new ResponseEntity<>(detail, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteRecipe(Long recipeId) {

        Detail detail = new Detail();
        recipeService.deleteRecipe(recipeId);
        detail.setCode(HttpStatus.NO_CONTENT.value());
        detail.setMessage("Recipe successfully deleted");

        return new ResponseEntity<>(detail, HttpStatus.NO_CONTENT);
    }


}
