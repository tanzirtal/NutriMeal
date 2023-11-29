package com.passionproject.nutrimealplanner.service;

import com.passionproject.nutrimealplanner.exception.UserNotFoundException;
import com.passionproject.nutrimealplanner.exception.WeightEntryNotFound;
import com.passionproject.nutrimealplanner.model.User;
import com.passionproject.nutrimealplanner.model.WeightTracker;
import com.passionproject.nutrimealplanner.repository.UserRepo;
import com.passionproject.nutrimealplanner.repository.WeightTrackerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeightTrackerService {

    @Autowired
    private WeightTrackerRepo weightTrackerRepo;
    @Autowired
    private UserRepo userRepo;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public WeightTracker addWeightEntry(Long userId, Double weight){

        User user = userRepo.findById(userId).orElseThrow(()-> {
            logger.error("User with ID: " + userId + " not found.");
            throw new UserNotFoundException("Error fetching user.");
        });

        WeightTracker weightEntry = new WeightTracker();
        weightEntry.setUser(user);
        weightEntry.setWeight(weight);
        weightEntry.setDate(LocalDate.now());

        WeightTracker savedEntry = weightTrackerRepo.save(weightEntry);

        logger.info("Weight entry added for user ID: " + userId);
        return savedEntry;
    }

    public List<WeightTracker> getAllWeights(Long userId){
        if(weightTrackerRepo.findByUserId(userId).size()==0) {
            logger.error("No weight entries have been made yet");
            throw new WeightEntryNotFound("No weight entries have been made yet");
        }
        return weightTrackerRepo.findByUserId(userId);
    }


}
