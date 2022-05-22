package com.example.healthreset.service;


import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.repository.MealOfTheDayRepository;
import com.example.healthreset.utils.MealOfTheDayMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MealOfTheDayService {

    private final MealOfTheDayRepository mealOfTheDayRepository;

    public MealOfTheDayService(MealOfTheDayRepository mealOfTheDayRepository) {
        this.mealOfTheDayRepository = mealOfTheDayRepository;
    }

    /**
     * Gets all the meals of the day from the database
     * @return a list of all the meals of the day from database as DTOs
     */
    public List<MealOfTheDayDTO> findAll(){
        List<MealOfTheDay> mealsOfTheDay = mealOfTheDayRepository.findAll();
        List<MealOfTheDayDTO> mealsOfTheDayDTO = new ArrayList<>();

        MealOfTheDayMapper mealOfTheDayMapper = new MealOfTheDayMapper();
        for(MealOfTheDay a : mealsOfTheDay){
            mealsOfTheDayDTO.add(mealOfTheDayMapper.convertMealOfTheDayToDTO(a));
        }
        log.info(" Meals of the day " + mealsOfTheDayDTO + " successfully fetched from database!");
        return mealsOfTheDayDTO;
    }

}
