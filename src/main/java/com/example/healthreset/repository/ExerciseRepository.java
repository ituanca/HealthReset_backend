package com.example.healthreset.repository;

import com.example.healthreset.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {

    Optional<Exercise> findByName(String name);

}
