package com.example.healthreset.utils;

import com.example.healthreset.model.RoutineFood;
import com.example.healthreset.model.TrackedFood;
import com.example.healthreset.model.dto.RoutineFoodDTO;
import com.example.healthreset.model.dto.TrackedFoodDTO;

public class RoutineFoodMapper {

    public RoutineFood convertDTOtoRoutineFood(RoutineFoodDTO routineFoodDTO) {

        RoutineFood routineFood = new RoutineFood();
        routineFood.setName(routineFoodDTO.getName());
        routineFood.setCalories(Integer.parseInt(routineFoodDTO.getCalories()));
        routineFood.setProtein(Integer.parseInt(routineFoodDTO.getProtein()));
        routineFood.setFat(Integer.parseInt(routineFoodDTO.getFat()));
        routineFood.setSodium(Integer.parseInt(routineFoodDTO.getSodium()));
        routineFood.setQuantity(Integer.parseInt(routineFoodDTO.getQuantity()));
        routineFood.setMealOfTheDay(routineFoodDTO.getMealOfTheDay());

        return routineFood;

    }

    public RoutineFoodDTO convertDTOtoRoutineFood(RoutineFood routineFood) {

        RoutineFoodDTO routineFoodDTO = new RoutineFoodDTO();
        routineFoodDTO.setName(routineFood.getName());
        routineFoodDTO.setCalories(String.valueOf(routineFood.getCalories()));
        routineFoodDTO.setProtein(String.valueOf(routineFood.getProtein()));
        routineFoodDTO.setFat(String.valueOf(routineFood.getFat()));
        routineFoodDTO.setSodium(String.valueOf(routineFood.getSodium()));
        routineFoodDTO.setQuantity(String.valueOf(routineFood.getQuantity()));
        routineFoodDTO.setMealOfTheDay(String.valueOf(routineFood.getMealOfTheDay()));

        return routineFoodDTO;

    }

}
