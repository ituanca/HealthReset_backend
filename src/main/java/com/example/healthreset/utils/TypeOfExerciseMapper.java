package com.example.healthreset.utils;

import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;

public class TypeOfExerciseMapper {

    public TypeOfExercise convertDTOtoTypeOfExercise(TypeOfExerciseDTO typeOfExerciseDTO) {
        return TypeOfExercise.builder()
                .typeOfExercise(typeOfExerciseDTO.getTypeOfExercise())
                .build();
    }

    public TypeOfExerciseDTO convertTypeOfExerciseToDTO(TypeOfExercise typeOfExercise) {
        return TypeOfExerciseDTO.builder()
                .typeOfExercise(typeOfExercise.getTypeOfExercise())
                .build();
    }

}
