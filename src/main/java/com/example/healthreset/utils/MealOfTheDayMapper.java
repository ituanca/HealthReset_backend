package com.example.healthreset.utils;

import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.dto.MealOfTheDayDTO;

public class MealOfTheDayMapper {

    public MealOfTheDay convertDTOtoMealOfTheDay(MealOfTheDayDTO mealOfTheDayDTO) {
        return MealOfTheDay.builder()
                .mealOfTheDay(mealOfTheDayDTO.getMealOfTheDay())
                .build();
    }

    public MealOfTheDayDTO convertMealOfTheDayToDTO(MealOfTheDay mealOfTheDay) {
        return MealOfTheDayDTO.builder()
                .mealOfTheDay(mealOfTheDay.getMealOfTheDay())
                .build();
    }

}
