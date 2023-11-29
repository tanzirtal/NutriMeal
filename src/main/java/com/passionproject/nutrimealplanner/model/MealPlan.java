//package com.passionproject.nutrimealplanner.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name="meal_plan")
//public class MealPlan {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "meal_plan_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private User user;
//
//    @ManyToMany
//    @JoinTable(
//            name = "meal_plan_recipes",
//            joinColumns = @JoinColumn(name = "meal_plan_id"),
//            inverseJoinColumns = @JoinColumn(name = "recipe_id")
//    )
//    private Set<Recipe> recipes;
//
//    @Column(name = "plan_name")
//    private String planName;
//
//    public MealPlan() {
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
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Set<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Set<Recipe> recipes) {
//        this.recipes = recipes;
//    }
//
//    public String getPlanName() {
//        return planName;
//    }
//
//    public void setPlanName(String planName) {
//        this.planName = planName;
//    }
//}