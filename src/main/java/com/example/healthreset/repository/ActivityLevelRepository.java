package com.example.healthreset.repository;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityLevelRepository extends JpaRepository<ActivityLevel,Integer> {
    Optional<ActivityLevel> findByActivityLevel(String activityLevel);
}
