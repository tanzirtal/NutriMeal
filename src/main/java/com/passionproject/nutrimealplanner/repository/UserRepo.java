package com.passionproject.nutrimealplanner.repository;

import com.passionproject.nutrimealplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
