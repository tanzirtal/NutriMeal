package com.passionproject.nutrimealplanner.repository;

import com.passionproject.nutrimealplanner.model.WeightTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeightTrackerRepo extends JpaRepository<WeightTracker, Long> {
    @Query("SELECT wt FROM WeightTracker wt WHERE wt.user.id = :userId")
    List<WeightTracker> findByUserId(@Param("userId") Long userId);
}
