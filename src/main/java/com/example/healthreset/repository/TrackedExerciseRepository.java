package com.example.healthreset.repository;

import com.example.healthreset.model.TrackedExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackedExerciseRepository extends JpaRepository<TrackedExercise, Integer> {
}
