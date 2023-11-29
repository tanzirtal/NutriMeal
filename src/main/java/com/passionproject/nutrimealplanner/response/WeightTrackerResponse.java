package com.passionproject.nutrimealplanner.response;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.Nutrition;
import com.passionproject.nutrimealplanner.model.WeightTracker;
import com.passionproject.nutrimealplanner.service.WeightTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeightTrackerResponse {

    @Autowired
    private WeightTrackerService weightTrackerService;

    public ResponseEntity<WeightTracker> addWeightEntry(Long userId, Double weight) {
        WeightTracker weightTracker = weightTrackerService.addWeightEntry(userId, weight);
        Detail detail = new Detail();
        detail.setData(weightTracker);
        detail.setCode(HttpStatus.CREATED.value());
        detail.setMessage("All nutritional info successfully aggregated");

        return ResponseEntity.ok(weightTracker);
    }

    public ResponseEntity<?> getAllWeights(Long userId) {

        Detail detail = new Detail();
        detail.setData(weightTrackerService.getAllWeights(userId));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("All weight entries retrieved successfully");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }
}
