package com.example.healthreset.utils;

import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;

public class PhysicalExerciseMapper {

    public PhysicalExercise convertDTOtoPhysicalExercise(PhysicalExerciseDTO physicalExerciseDTO) {
        return PhysicalExercise.builder()
                .name(physicalExerciseDTO.getName())
                .caloriesBurnedPerMinute(physicalExerciseDTO.getCaloriesBurnedPerMinute())
                .build();
    }

    public PhysicalExerciseDTO convertPhysicalExerciseToDTO(PhysicalExercise physicalExercise) {
        TypeOfExerciseMapper typeOfExerciseMapper = new TypeOfExerciseMapper();
        TypeOfExerciseDTO typeOfExerciseDTO = typeOfExerciseMapper.convertTypeOfExerciseToDTO(physicalExercise.getTypeOfExercise());

        return PhysicalExerciseDTO.builder()
                .name(physicalExercise.getName())
                .typeOfExercise(typeOfExerciseDTO)
                .caloriesBurnedPerMinute(physicalExercise.getCaloriesBurnedPerMinute())
                .build();
    }

}
