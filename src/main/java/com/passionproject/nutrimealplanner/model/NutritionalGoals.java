//package com.passionproject.nutrimealplanner.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name="nutritional_goals")
//public class NutritionalGoals {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="nutritional_goals_id")
//    private Long id;
//
//    @Column(name="protein_goal")
//    private Double proteinGoal;
//
//    @Column(name="carbohydrate_goal")
//    private Double carbGoal;
//
//    @Column(name="total_fat_goal")
//    private Double totalFatGoal;
//
//    @Column(name="saturated_fat_goal")
//    private Double satFatGoal;
//
//    @Column(name="calorie_goal")
//    private Double calorieGoal;
//
//    @Column(name="fiber_goal")
//    private Double fiberGoal;
//
//    @Column(name="sodium_goal")
//    private Double sodiumGoal;
//
//    @Column(name="sugar_goal")
//    private Double sugarGoal;
//
//    @ManyToMany(mappedBy = "nutritionalGoals")
//    private Set<User> users;
//
//    public NutritionalGoals() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Double getProteinGoal() {
//        return proteinGoal;
//    }
//
//    public void setProteinGoal(Double proteinGoal) {
//        this.proteinGoal = proteinGoal;
//    }
//
//    public Double getCarbGoal() {
//        return carbGoal;
//    }
//
//    public void setCarbGoal(Double carbGoal) {
//        this.carbGoal = carbGoal;
//    }
//
//    public Double getTotalFatGoal() {
//        return totalFatGoal;
//    }
//
//    public void setTotalFatGoal(Double totalFatGoal) {
//        this.totalFatGoal = totalFatGoal;
//    }
//
//    public Double getSatFatGoal() {
//        return satFatGoal;
//    }
//
//    public void setSatFatGoal(Double satFatGoal) {
//        this.satFatGoal = satFatGoal;
//    }
//
//    public Double getCalorieGoal() {
//        return calorieGoal;
//    }
//
//    public void setCalorieGoal(Double calorieGoal) {
//        this.calorieGoal = calorieGoal;
//    }
//
//    public Double getFiberGoal() {
//        return fiberGoal;
//    }
//
//    public void setFiberGoal(Double fiberGoal) {
//        this.fiberGoal = fiberGoal;
//    }
//
//    public Double getSodiumGoal() {
//        return sodiumGoal;
//    }
//
//    public void setSodiumGoal(Double sodiumGoal) {
//        this.sodiumGoal = sodiumGoal;
//    }
//
//    public Double getSugarGoal() {
//        return sugarGoal;
//    }
//
//    public void setSugarGoal(Double sugarGoal) {
//        this.sugarGoal = sugarGoal;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//}
//
