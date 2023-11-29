package com.passionproject.nutrimealplanner.response;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.Nutrition;
import com.passionproject.nutrimealplanner.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class NutritionResponse {
    @Autowired
    private NutritionService nutritionService;

    public ResponseEntity<?> createNutrition(Nutrition nutrition) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepositURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nutritionId}").buildAndExpand(nutrition.getId()).toUri();
        responseHeaders.setLocation(newDepositURI);

        Detail detail = new Detail();
        detail.setData(nutritionService.createNutritionalValue(nutrition));
        detail.setCode(HttpStatus.CREATED.value());
        detail.setMessage("Nutritional information successfully created for " + nutrition.getName());

        return new ResponseEntity<>(detail, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getNutritionByName(String name) {

        Detail detail = new Detail();
        detail.setData(nutritionService.getNutritionByName(name));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("Nutritional information successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> getNutritionById(Long nutritionId) {

        Detail detail = new Detail();
        detail.setData(nutritionService.getNutritionById(nutritionId));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("Nutritional information successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> updateNutrition(Nutrition nutrition, Long nutritionId) {

        Detail detail = new Detail();
        nutritionService.updateNutrition(nutritionId, nutrition);
        detail.setCode(HttpStatus.ACCEPTED.value());
        detail.setMessage("Nutritional information successfully updated");

        return new ResponseEntity<>(detail, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteNutrition(Long nutritionId) {

        Detail detail = new Detail();
        detail.setMessage("Nutritional information successfully deleted");
        nutritionService.deleteNutrition(nutritionId);
        detail.setCode(HttpStatus.NO_CONTENT.value());

        return new ResponseEntity<>(detail, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> getAllNutritions() {

        Detail detail = new Detail();
        detail.setData(nutritionService.getAllNutritions());
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("All nutritional info successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<Nutrition> addNutritionalValues(List<String> nutritionNames) {
        Nutrition aggregatedNutrition = nutritionService.addNutritionalValues(nutritionNames);
        Detail detail = new Detail();
        detail.setData(nutritionService.addNutritionalValues(nutritionNames));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("All nutritional info successfully aggregated");

        return ResponseEntity.ok(aggregatedNutrition);
    }
}
