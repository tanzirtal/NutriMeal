package com.passionproject.nutrimealplanner.controller;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.User;
import com.passionproject.nutrimealplanner.response.UserResponse;
import com.passionproject.nutrimealplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
public class UserController {

    @Autowired
    private UserResponse userResponse;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userResponse.createUser(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return userResponse.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return userResponse.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){
        return userResponse.updateUser(user, userId);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return userResponse.deleteUser(userId);
    }
}
