package com.passionproject.nutrimealplanner.service;

import com.passionproject.nutrimealplanner.exception.NutritionNotFoundException;
import com.passionproject.nutrimealplanner.model.Nutrition;
import com.passionproject.nutrimealplanner.model.Nutrition;
import com.passionproject.nutrimealplanner.repository.NutritionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionService {
    @Autowired
    private NutritionRepo nutritionRepo;

    private final Logger logger = LoggerFactory.getLogger(NutritionService.class);

    public Iterable<Nutrition> getAllNutritions(){
        List<Nutrition> nutritions = nutritionRepo.findAll();
        if(nutritions.isEmpty()){
            logger.error("List of nutritions is empty");
            throw new NutritionNotFoundException("List of nutritions is empty");
        }
        logger.info("All nutritions successfully retrieved");

        return nutritionRepo.findAll();
    }

    public Nutrition createNutritionalValue(Nutrition nutrition){

        nutrition.setName(nutrition.getName());
        nutrition.setCalories(nutrition.getCalories());
        nutrition.setSugar(nutrition.getSugar());
        nutrition.setFiber(nutrition.getFiber());
        nutrition.setServingSize(nutrition.getServingSize());
        nutrition.setSodium(nutrition.getSodium());
        nutrition.setSaturatedFat(nutrition.getSaturatedFat());
        nutrition.setTotalFat(nutrition.getTotalFat());
        nutrition.setCholesterol(nutrition.getCholesterol());
        nutrition.setProtein(nutrition.getProtein());
        nutrition.setTotalCarbs(nutrition.getTotalCarbs());


        logger.info("Nutrition successfully created.");
        return nutritionRepo.save(nutrition);

    }

    public Nutrition getNutritionByName(String name) {
        Optional<Nutrition> nutritionOptional = nutritionRepo.getNutritionByName(name);

        if (nutritionOptional.isPresent()) {
            Nutrition nutrition = nutritionOptional.get();
            logger.info("Nutrition successfully retrieved: " + nutrition.getName());
            return nutrition;
        } else {
            logger.error("No nutrition found with name: " + name);
            throw new NutritionNotFoundException("No nutrition found with name: " + name);
        }
    }

    public Nutrition getNutritionById(Long nutritionId){
        Nutrition nutrition = nutritionRepo.findById(nutritionId).orElseThrow(()-> {
            logger.error("Nutrition with ID: " + nutritionId + " not found.");
            throw new NutritionNotFoundException("Error fetching nutrition.");
        });
        logger.info("Nutrition successfully retrieved");
        return nutrition;
    }

    public Nutrition updateNutrition(Long nutritionId, Nutrition updatedNutrition){
        Nutrition existingNutrition = getNutritionById(nutritionId);

        existingNutrition.setCalories(updatedNutrition.getCalories());
        existingNutrition.setSugar(updatedNutrition.getSugar());
        existingNutrition.setFiber(updatedNutrition.getFiber());
        existingNutrition.setServingSize(updatedNutrition.getServingSize());
        existingNutrition.setSodium(updatedNutrition.getSodium());
        existingNutrition.setSaturatedFat(updatedNutrition.getSaturatedFat());
        existingNutrition.setTotalFat(updatedNutrition.getTotalFat());
        existingNutrition.setCholesterol(updatedNutrition.getCholesterol());
        existingNutrition.setProtein(updatedNutrition.getProtein());
        existingNutrition.setTotalCarbs(updatedNutrition.getTotalCarbs());
        existingNutrition.setName(updatedNutrition.getName());

        logger.info("Nutrition successfully updated");
        nutritionRepo.save(existingNutrition);
        return existingNutrition;
    }

    public void deleteNutrition(Long nutritionId){
        Nutrition nutritionToDelete = getNutritionById(nutritionId);
        logger.info("Nutrition successfully deleted");
        nutritionRepo.delete(nutritionToDelete);
    }

    public Nutrition addNutritionalValues(List<String> nutritionNames){
        if (nutritionNames == null || nutritionNames.isEmpty()) {
            logger.error("The list of nutrition names is empty or null");
            throw new IllegalArgumentException("Nutrition names list cannot be empty or null");
        }

        double totalCalories = 0;
        double totalSugar = 0;
        double totalFiber = 0;
        double totalServingSize = 0;
        double totalSodium = 0;
        double totalSaturatedFat = 0;
        double totalFat = 0;
        double totalCholesterol = 0;
        double totalProtein = 0;
        double totalCarbs = 0;

        for (String name : nutritionNames) {
            Nutrition nutrition = nutritionRepo.getNutritionByName(name)
                    .orElseThrow(() -> new NutritionNotFoundException("No nutrition found with name: " + name));

            totalCalories += nutrition.getCalories();
            totalSugar += nutrition.getSugar();
            totalFiber += nutrition.getFiber();
            totalServingSize += nutrition.getServingSize();
            totalSodium += nutrition.getSodium();
            totalSaturatedFat += nutrition.getSaturatedFat();
            totalFat += nutrition.getTotalFat();
            totalCholesterol += nutrition.getCholesterol();
            totalProtein += nutrition.getProtein();
            totalCarbs += nutrition.getTotalCarbs();
        }

        Nutrition aggregatedNutrition = new Nutrition();
        aggregatedNutrition.setCalories(totalCalories);
        aggregatedNutrition.setSugar(totalSugar);
        aggregatedNutrition.setFiber(totalFiber);
        aggregatedNutrition.setServingSize(totalServingSize);
        aggregatedNutrition.setSodium(totalSodium);
        aggregatedNutrition.setSaturatedFat(totalSaturatedFat);
        aggregatedNutrition.setTotalFat(totalFat);
        aggregatedNutrition.setCholesterol(totalCholesterol);
        aggregatedNutrition.setProtein(totalProtein);
        aggregatedNutrition.setTotalCarbs(totalCarbs);

        aggregatedNutrition.setName("Total Nutritional Value of Items");

        return aggregatedNutrition;
    }

}
