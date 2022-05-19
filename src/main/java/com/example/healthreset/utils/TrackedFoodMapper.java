package com.example.healthreset.utils;

import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.TrackedActivity;
import com.example.healthreset.model.TrackedFood;
import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.model.dto.TrackedFoodDTO;

public class TrackedFoodMapper {

    public TrackedFood convertDTOtoTrackedFood(TrackedFoodDTO trackedFoodDTO) {

        TrackedFood trackedFood = new TrackedFood();
        trackedFood.setName(trackedFoodDTO.getName());
        trackedFood.setCalories(Integer.parseInt(trackedFoodDTO.getCalories()));
        trackedFood.setProtein(Integer.parseInt(trackedFoodDTO.getProtein()));
        trackedFood.setFat(Integer.parseInt(trackedFoodDTO.getFat()));
        trackedFood.setSodium(Integer.parseInt(trackedFoodDTO.getSodium()));
        trackedFood.setQuantity(Integer.parseInt(trackedFoodDTO.getQuantity()));
        trackedFood.setMealOfTheDay(trackedFoodDTO.getMealOfTheDay());
        trackedFood.setEatenQuantity(trackedFoodDTO.getEatenQuantity());

         return trackedFood;

    }

    public TrackedFoodDTO convertTrackedFoodToDTO(TrackedFood trackedFood) {

//        MealOfTheDayDTO mealOfTheDayDTO = new MealOfTheDayDTO();
//        if(trackedFood.getMealOfTheDay()!=null){
//            mealOfTheDayDTO = new MealOfTheDayMapper().convertMealOfTheDayToDTO(trackedFood.getMealOfTheDay());
//        }

        return TrackedFoodDTO.builder()
                .name(trackedFood.getName())
                .calories(String.valueOf(trackedFood.getCalories()))
                .protein(String.valueOf(trackedFood.getProtein()))
                .fat(String.valueOf(trackedFood.getFat()))
                .sodium(String.valueOf(trackedFood.getSodium()))
                .quantity(String.valueOf(trackedFood.getQuantity()))
                .mealOfTheDay(trackedFood.getMealOfTheDay())
                .eatenQuantity(trackedFood.getEatenQuantity())
                .build();
    }

}
