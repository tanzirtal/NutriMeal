package com.passionproject.nutrimealplanner.response;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.model.User;
import com.passionproject.nutrimealplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class UserResponse {

    @Autowired
    private UserService userService;

    public ResponseEntity<?> createUser(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepositURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newDepositURI);

        Detail detail = new Detail();
        detail.setData(userService.createUser(user));
        detail.setCode(HttpStatus.CREATED.value());
        detail.setMessage("User successfully created");

        return new ResponseEntity<>(detail, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllUsers() {

        Detail detail = new Detail();
        detail.setData(userService.getAllUsers());
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("Users successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> getUserById(Long userId) {

        Detail detail = new Detail();
        detail.setData(userService.getUserById(userId));
        detail.setCode(HttpStatus.OK.value());
        detail.setMessage("User successfully retrieved");

        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    public ResponseEntity<?> updateUser(User user, Long userId) {

        Detail detail = new Detail();
        userService.updateUser(userId, user);
        detail.setCode(HttpStatus.ACCEPTED.value());
        detail.setMessage("User successfully updated");

        return new ResponseEntity<>(detail, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteUser(Long userId) {

        Detail detail = new Detail();
        userService.deleteUser(userId);
        detail.setCode(HttpStatus.NO_CONTENT.value());
        detail.setMessage("User successfully deleted");

        return new ResponseEntity<>(detail, HttpStatus.NO_CONTENT);
    }


}
