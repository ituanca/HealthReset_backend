package com.example.healthreset.repository;

import com.example.healthreset.model.Exercise;
import com.example.healthreset.model.PhysicalExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhysicalExerciseRepository extends JpaRepository<PhysicalExercise, Integer> {

    Optional<PhysicalExercise> findByName(String name);

}
