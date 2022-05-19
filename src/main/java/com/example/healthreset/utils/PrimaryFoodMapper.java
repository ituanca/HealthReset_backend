package com.example.healthreset.utils;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.dto.PrimaryFoodDTO;

public class PrimaryFoodMapper {
    public PrimaryFood convertDTOtoPrimaryFood(PrimaryFoodDTO primaryfoodDTO) {
        PrimaryFood food = PrimaryFood.builder()
                .protein(Integer.parseInt(primaryfoodDTO.getProtein()))
                .fat(Integer.parseInt(primaryfoodDTO.getFat()))
                .sodium(Integer.parseInt(primaryfoodDTO.getSodium()))
                .quantity(Integer.parseInt(primaryfoodDTO.getQuantity()))
                .mealOfTheDay(primaryfoodDTO.getMealOfTheDay())
                .eatenQuantity(primaryfoodDTO.getEatenQuantity())
                .build();
        food.setName(primaryfoodDTO.getName());
        food.setCalories(Integer.parseInt(primaryfoodDTO.getCalories()));
        return food;
    }

    public PrimaryFoodDTO convertPrimaryFoodToDTO(PrimaryFood primaryfood) {

        return PrimaryFoodDTO.builder()
                .name(primaryfood.getName())
                .calories(String.valueOf(primaryfood.getCalories()))
                .protein(String.valueOf(primaryfood.getProtein()))
                .fat(String.valueOf(primaryfood.getFat()))
                .sodium(String.valueOf(primaryfood.getSodium()))
                .quantity(String.valueOf(primaryfood.getQuantity()))
                .mealOfTheDay(primaryfood.getMealOfTheDay())
                .eatenQuantity(primaryfood.getEatenQuantity())
                .build();
    }
}
