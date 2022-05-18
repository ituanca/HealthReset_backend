package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysicalExerciseDTO {

    String name;
    String typeOfExercise;
    Integer caloriesBurnedPerMinute;

}
