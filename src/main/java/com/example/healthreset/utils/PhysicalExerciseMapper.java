package com.example.healthreset.utils;

import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;

public class PhysicalExerciseMapper {

    public PhysicalExercise convertDTOtoPhysicalExercise(PhysicalExerciseDTO physicalExerciseDTO) {
        return PhysicalExercise.builder()
                .name(physicalExerciseDTO.getName())
                .caloriesBurnedPerMinute(physicalExerciseDTO.getCaloriesBurnedPerMinute())
                .build();
    }

}
