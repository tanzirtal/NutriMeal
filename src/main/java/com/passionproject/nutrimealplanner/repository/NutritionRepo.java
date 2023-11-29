package com.passionproject.nutrimealplanner.repository;

import com.passionproject.nutrimealplanner.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface NutritionRepo extends JpaRepository<Nutrition, Long> {

    @Query("SELECT n FROM Nutrition n WHERE n.name = ?1")
    Optional<Nutrition> getNutritionByName(String name);


}
