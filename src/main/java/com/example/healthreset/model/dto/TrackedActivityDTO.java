package com.example.healthreset.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackedActivityDTO {

    String date;

    Integer nrOfSteps;

    Double burnedCalories;

    Double eatenCalories;

    List<TrackedExerciseDTO> listOfTrackedExercises;

    List<TrackedFoodDTO> listOfTrackedFood;

    UserDTO regularUser;

}
