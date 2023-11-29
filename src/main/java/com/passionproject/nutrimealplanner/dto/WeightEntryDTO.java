package com.passionproject.nutrimealplanner.dto;

public class WeightEntryDTO {
    private Long userId;
    private Double weight;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}