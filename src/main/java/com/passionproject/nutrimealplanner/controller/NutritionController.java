package com.passionproject.nutrimealplanner.controller;

import com.passionproject.nutrimealplanner.dto.NutritionNamesDTO;
import com.passionproject.nutrimealplanner.model.Nutrition;
import com.passionproject.nutrimealplanner.response.NutritionResponse;
import com.passionproject.nutrimealplanner.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NutritionController {

    @Autowired
    private NutritionResponse nutritionResponse;
    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/nutritions")
    public ResponseEntity<?> createNutrition(@RequestBody Nutrition nutrition){
        return nutritionResponse.createNutrition(nutrition);
    }

    @GetMapping("/nutritions/by-name/{name}")
    public ResponseEntity<?> getNutritionByName(@PathVariable String name){
        return nutritionResponse.getNutritionByName(name);
    }

    @PostMapping("/nutritions/aggregate-values")
    public ResponseEntity<?> aggregateNutritionValues(@RequestBody NutritionNamesDTO nutritionNamesDTO) {
        return nutritionResponse.addNutritionalValues(nutritionNamesDTO.getNutritionNames());
    }

    @GetMapping("/nutritions/{nutritionId}")
    public ResponseEntity<?> getNutritionById(@PathVariable Long nutritionId){
        return nutritionResponse.getNutritionById(nutritionId);
    }

    @PutMapping("/nutritions/{nutritionId}")
    public ResponseEntity<?> updateNutrition(@RequestBody Nutrition nutrition, @PathVariable Long nutritionId){
        return nutritionResponse.updateNutrition(nutrition, nutritionId);
    }

    @DeleteMapping("/nutritions/{nutritionId}")
    public ResponseEntity<?> deleteNutrition(@PathVariable Long nutritionId){
        return nutritionResponse.deleteNutrition(nutritionId);
    }

    @GetMapping("/nutritions")
    public ResponseEntity<?> getAllNutritions(){
        return nutritionResponse.getAllNutritions();
    }



}
