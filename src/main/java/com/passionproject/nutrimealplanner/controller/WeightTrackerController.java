package com.passionproject.nutrimealplanner.controller;

import com.passionproject.nutrimealplanner.dto.WeightEntryDTO;
import com.passionproject.nutrimealplanner.model.User;
import com.passionproject.nutrimealplanner.model.WeightTracker;
import com.passionproject.nutrimealplanner.response.WeightTrackerResponse;
import com.passionproject.nutrimealplanner.service.UserService;
import com.passionproject.nutrimealplanner.service.WeightTrackerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class WeightTrackerController {

    @Autowired
    private WeightTrackerResponse weightTrackerResponse;

    @PostMapping("users/{userId}/weight")
    public ResponseEntity<WeightTracker> addWeightEntry(@PathVariable Long userId, @RequestBody WeightEntryDTO weightEntryDTO){
        return weightTrackerResponse.addWeightEntry(userId, weightEntryDTO.getWeight());
    }

    @GetMapping("users/{userId}/weights")
    public ResponseEntity<?> getAllWeights(@PathVariable Long userId){
        return weightTrackerResponse.getAllWeights(userId);
    }
}
