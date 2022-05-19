package com.example.healthreset.utils;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.TrackedActivityDTO;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.model.dto.TrackedFoodDTO;
import com.example.healthreset.repository.MealOfTheDayRepository;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TrackedActivityMapper {

    public TrackedActivity convertDTOtoTrackedActivity(TrackedActivityDTO trackedActivityDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(trackedActivityDTO.getDate(), formatter);

        List<TrackedExercise> trackedExercises = new ArrayList<>();
        TrackedExerciseMapper trackedExerciseMapper = new TrackedExerciseMapper();
        for(TrackedExerciseDTO t: trackedActivityDTO.getListOfTrackedExercises()){
            trackedExercises.add(trackedExerciseMapper.convertDTOtoTrackedExercise(t));
        }

        List<TrackedFood> trackedFoodList = new ArrayList<>();
        TrackedFoodMapper trackedFoodMapper = new TrackedFoodMapper();
        for(TrackedFoodDTO f: trackedActivityDTO.getListOfTrackedFood()){
            trackedFoodList.add(trackedFoodMapper.convertDTOtoTrackedFood(f));
        }

        return TrackedActivity.builder()
                .trackedDay(dateTime)
                .nrOfSteps(trackedActivityDTO.getNrOfSteps())
                .burnedCalories(trackedActivityDTO.getBurnedCalories())
                .eatenCalories(trackedActivityDTO.getEatenCalories())
                .listOfTrackedExercises(trackedExercises)
                .listOfTrackedFood(trackedFoodList)
                .build();
    }

//    public TrackedActivityDTO convertTrackedActivityToDTO(TrackedActivity trackedActivity) {
//
//        return TrackedExerciseDTO.builder()
//                .name(trackedExercise.getName())
//                .caloriesBurnedPerMinute(trackedExercise.getCaloriesBurnedPerMinute())
//                .typeOfExercise(trackedExercise.getTypeOfExercise().getTypeOfExercise())
//                .timeOfExecution(trackedExercise.getTimeOfExecution())
//                .build();
//    }


}
