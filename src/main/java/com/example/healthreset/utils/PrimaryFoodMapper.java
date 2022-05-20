package com.example.healthreset.utils;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.RoutineFood;
import com.example.healthreset.model.dto.PrimaryFoodDTO;

public class PrimaryFoodMapper {
    public PrimaryFood convertDTOtoPrimaryFood(PrimaryFoodDTO primaryfoodDTO) {
        PrimaryFood food = PrimaryFood.builder()
                .build();
        food.setProtein(Integer.parseInt(primaryfoodDTO.getProtein()));
        food.setFat(Integer.parseInt(primaryfoodDTO.getFat()));
        food.setSodium(Integer.parseInt(primaryfoodDTO.getSodium()));
        food.setQuantity(Integer.parseInt(primaryfoodDTO.getQuantity()));
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
                .mealOfTheDay("")
                .build();
    }

}
