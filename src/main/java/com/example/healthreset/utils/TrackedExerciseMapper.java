package com.example.healthreset.utils;

import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.TrackedExercise;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.TrackedExerciseDTO;

public class TrackedExerciseMapper {

    public TrackedExercise convertDTOtoTrackedExercise(TrackedExerciseDTO trackedExerciseDTO) {

        TrackedExercise trackedExercise = new TrackedExercise();
        trackedExercise.setName(trackedExerciseDTO.getName());
        trackedExercise.setCaloriesBurnedPerMinute(trackedExercise.getCaloriesBurnedPerMinute());
        trackedExercise.setTimeOfExecution(trackedExerciseDTO.getTimeOfExecution());

        return trackedExercise;
    }

    public TrackedExerciseDTO convertTrackedExerciseToDTO(TrackedExercise trackedExercise) {

        return TrackedExerciseDTO.builder()
                .name(trackedExercise.getName())
                .caloriesBurnedPerMinute(trackedExercise.getCaloriesBurnedPerMinute())
                .timeOfExecution(trackedExercise.getTimeOfExecution())
                .build();
    }

}
