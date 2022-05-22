package com.example.healthreset.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class PhysicalExercise extends Exercise{

    public PhysicalExercise(String name, Integer caloriesBurnedPerMinute, TypeOfExercise typeOfExercise) {
        super(name, caloriesBurnedPerMinute, typeOfExercise);
    }
}
