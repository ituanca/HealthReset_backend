package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrackedExerciseDTO {

    String name;
    TypeOfExerciseDTO typeOfExercise;
    Integer caloriesBurnedPerMinute;

    String date;
    Integer timeOfExecution;

}
