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
                .build();
        food.setName(primaryfoodDTO.getName());
        food.setCalories(Integer.parseInt(primaryfoodDTO.getCalories()));
        return food;
    }
}
