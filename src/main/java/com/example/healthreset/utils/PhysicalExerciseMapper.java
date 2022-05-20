package com.example.healthreset.utils;

import com.example.healthreset.model.Exercise;
import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;

public class PhysicalExerciseMapper {

    public PhysicalExercise convertDTOtoPhysicalExercise(PhysicalExerciseDTO physicalExerciseDTO) {
        PhysicalExercise physicalExercise = PhysicalExercise.builder()
                .build();
        physicalExercise.setName(physicalExerciseDTO.getName());
        physicalExercise.setCaloriesBurnedPerMinute(physicalExerciseDTO.getCaloriesBurnedPerMinute());
        return physicalExercise;
    }

    public PhysicalExerciseDTO convertPhysicalExerciseToDTO(PhysicalExercise exercise) {
        TypeOfExerciseMapper typeOfExerciseMapper = new TypeOfExerciseMapper();
        TypeOfExerciseDTO typeOfExerciseDTO = typeOfExerciseMapper.convertTypeOfExerciseToDTO(exercise.getTypeOfExercise());

        return PhysicalExerciseDTO.builder()
                .name(exercise.getName())
                .typeOfExercise(typeOfExerciseDTO)
                .caloriesBurnedPerMinute(exercise.getCaloriesBurnedPerMinute())
                .build();
    }

}
