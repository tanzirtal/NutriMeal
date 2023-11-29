package com.passionproject.nutrimealplanner.service;
import com.passionproject.nutrimealplanner.exception.UserNotFoundException;
import com.passionproject.nutrimealplanner.model.User;
import com.passionproject.nutrimealplanner.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user){

        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setId(user.getId());
        user.setPassword(user.getPassword());

        logger.info("User successfully created.");
        return userRepo.save(user);

    }

    public Iterable<User> getAllUsers(){
        List<User> users = userRepo.findAll();
        if(users.isEmpty()){
            logger.error("List of users is empty");
            throw new UserNotFoundException("List of users is empty");
        }
        logger.info("All users successfully retrieved");

        return userRepo.findAll();
    }

    public User getUserById(Long userId){
        User user = userRepo.findById(userId).orElseThrow(()-> {
            logger.error("User with ID: " + userId + " not found.");
            throw new UserNotFoundException("Error fetching user.");
        });
        logger.info("User successfully retrieved");
        return user;
    }

    public User updateUser(Long userId, User updatedUser){
        User existingUser = getUserById(userId);

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());

        logger.info("User successfully updated");
        userRepo.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long userId){
        User userToDelete = getUserById(userId);
        logger.info("User successfully deleted");
        userRepo.delete(userToDelete);
    }


}
