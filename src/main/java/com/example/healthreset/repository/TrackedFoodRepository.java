package com.example.healthreset.repository;

import com.example.healthreset.model.Specialist;
import com.example.healthreset.model.TrackedFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackedFoodRepository extends JpaRepository<TrackedFood, Integer> {
    Optional<TrackedFood> findByName(String name);
}
