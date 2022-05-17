package com.example.healthreset.repository;

import com.example.healthreset.model.PhysicalExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalExerciseRepository extends JpaRepository<PhysicalExercise,Integer> {
}
