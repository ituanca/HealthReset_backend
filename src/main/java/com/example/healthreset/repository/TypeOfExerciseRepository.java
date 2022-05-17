package com.example.healthreset.repository;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.TypeOfExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfExerciseRepository extends JpaRepository<TypeOfExercise,Integer> {

    Optional<TypeOfExercise> findByTypeOfExercise(String typeOfExercise);

}
