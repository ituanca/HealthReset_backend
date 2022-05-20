package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineExerciseDTO {
    String name;
    TypeOfExerciseDTO typeOfExercise;
    Integer caloriesBurnedPerMinute;
    Integer timeOfExecution;
}
