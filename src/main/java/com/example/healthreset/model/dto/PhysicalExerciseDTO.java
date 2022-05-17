package com.example.healthreset.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalExerciseDTO {

    String name;
    String typeOfExercise;
    Integer caloriesBurnedPerMinute;

}
