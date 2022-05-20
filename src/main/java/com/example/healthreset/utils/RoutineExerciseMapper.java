package com.example.healthreset.utils;

import com.example.healthreset.model.RoutineExercise;
import com.example.healthreset.model.dto.RoutineExerciseDTO;
import com.example.healthreset.model.dto.TrackedExerciseDTO;

public class RoutineExerciseMapper {

    public RoutineExercise convertDTOtoRoutineExercise(RoutineExerciseDTO routineExerciseDTO) {

        RoutineExercise routineExercise = new RoutineExercise();
        routineExercise.setName(routineExerciseDTO.getName());
        routineExercise.setCaloriesBurnedPerMinute(routineExercise.getCaloriesBurnedPerMinute());

        return routineExercise;
    }

    public RoutineExerciseDTO convertRoutineExerciseToDTO(RoutineExercise routineExercise) {

        return RoutineExerciseDTO.builder()
                .name(routineExercise.getName())
                .caloriesBurnedPerMinute(routineExercise.getCaloriesBurnedPerMinute())
                .typeOfExercise(new TypeOfExerciseMapper().convertTypeOfExerciseToDTO(routineExercise.getTypeOfExercise()))
                .build();
    }

}
